package kr.switcher.switcherm.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.notification.NotiButtonParameter;
import kr.switcher.switcherm.common.notification.NotificationChannelUtil;
import kr.switcher.switcherm.common.notification.NotificationUtil;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.DevicesMeAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.FCMPreference;
import kr.switcher.switcherm.preference.LocalMarketingPreference;
import kr.switcher.switcherm.preference.PreferenceHelper;
import kr.switcher.switcherm.preference.WidgetCheckerPreference;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.service.presenter.WidgetServicePresenter;
import kr.switcher.switcherm.service.view.WidgetServiceView;
import kr.switcher.switcherm.service.widget.WidgetAirconService;
import kr.switcher.switcherm.service.widget.WidgetCheckerService;
import kr.switcher.switcherm.service.widget.WidgetRemoconConnector;
import kr.switcher.switcherm.service.widget.WidgetSettopService;
import kr.switcher.switcherm.service.widget.WidgetSwitchService;
import kr.switcher.switcherm.service.widget.WidgetSwitcherConnector;
import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.ui.widget.AirconWidget;
import kr.switcher.switcherm.ui.widget.CheckerWidget;
import kr.switcher.switcherm.ui.widget.OneButtonWidget;
import kr.switcher.switcherm.ui.widget.SettopWidget;
import kr.switcher.switcherm.ui.widget.TwoButtonWidget;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetService extends Service implements WidgetServiceView, WidgetSwitcherConnector.OnConnectSwitcherListener, WidgetSwitchService.OnControlSwitchListener, WidgetRemoconConnector.OnConnectAirconListener {
    private static String TAG = "WidgetService";
    private WidgetAirconService airconService;
    private AirconWidget airconWidget;
    int appWidgetId = 0;
    private WidgetCheckerService checkerService;
    private CheckerWidget checkerWidget;
    private WidgetSwitcherConnector connector;
    private OneButtonWidget oneButtonWidget;
    private WidgetServicePresenter presenter;
    private WidgetRemoconConnector remoconConnector;
    private ScreenOnReceiver screenOnReceiver;
    private WidgetSettopService settopService;
    private SettopWidget settopWidget;
    private WidgetSwitchService switchService;
    private TwoButtonWidget twoButtonWidget;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        registerReceiver();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iIntValue;
        IOLog.d(TAG, "||WIDGET|| WidgetService -> onStartCommand()==========");
        updateFCMID();
        startForeground();
        findDevicesMe();
        PreferenceHelper.setContext(this);
        WidgetPreference widgetPreference = new WidgetPreference();
        String dataString = intent.getDataString();
        if (dataString == null || !IOUtil.isDigit(dataString)) {
            Log.i(TAG, "invalid app widget id : " + dataString);
            return 2;
        }
        this.appWidgetId = Integer.parseInt(dataString);
        Log.i(TAG, "start command (widget id : " + this.appWidgetId + ")");
        int i3 = this.appWidgetId;
        if (i3 == 0) {
            return 2;
        }
        String widgetSwitcherAddress = widgetPreference.getWidgetSwitcherAddress(i3);
        Log.i(TAG, "command mac address : " + widgetSwitcherAddress);
        IOLog.d(TAG, "||WIDGET|| Device's MacAddress : " + widgetSwitcherAddress);
        int iIntValue2 = 0;
        IODevice device = IODeviceHandler.getInstance().getDevice(widgetSwitcherAddress);
        if (device == null) {
            Log.i(TAG, "IO Device is null");
        } else if (device != null) {
            Log.i(TAG, "IO Device is : " + device.getProductId());
        }
        int i4 = 1;
        for (IODevice iODevice : IODeviceHandler.getInstance().getDeviceAll()) {
            int i5 = i4 + 1;
            IOLog.d(TAG, "||WIDGET|| " + i4 + "번째 ProductID : " + iODevice.getProductId());
            if (iODevice.getProductId().equals(IODevice.ProductId.REMOCON)) {
                IOLog.d(TAG, "||WIDGET|| Remocon's Controller ID : " + ((Remocon) IODeviceHandler.getInstance().getDevice(iODevice.getMacAddress())).getControllerId() + "\n");
            }
            i4 = i5;
        }
        if (device.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || device.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
            iIntValue2 = ((Integer) intent.getSerializableExtra(IOService.PARM_SWITCH_POSITION)).intValue();
        } else if (device.getProductId().equals(IODevice.ProductId.REMOCON)) {
            Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(device.getMacAddress());
            IOLog.d(TAG, "||WIDGET|| Clicked Remocon's controllerID = " + remocon.getControllerId());
            if (remocon.getControllerId() == Remocon.ControllerID.AIRCON) {
                iIntValue = ((Integer) intent.getSerializableExtra(IOService.PARM_AIRCON_BUTTON)).intValue();
            } else if (remocon.getControllerId() == Remocon.ControllerID.SET_TOP_BOX) {
                iIntValue = ((Integer) intent.getSerializableExtra(IOService.PARM_SETTOP_BUTTON)).intValue();
                IOLog.d(TAG, "||WIDGET|| Remocon's switchPosition = " + iIntValue);
            }
            iIntValue2 = iIntValue;
        } else if (device.getProductId().equals(IODevice.ProductId.CHECKER)) {
            iIntValue2 = ((Integer) intent.getSerializableExtra(IOService.PARM_CHECKER_REFRESH_BUTTON)).intValue();
        }
        IOLog.i(TAG, "command switch : " + iIntValue2);
        WidgetServicePresenter widgetServicePresenter = new WidgetServicePresenter(this, this);
        this.presenter = widgetServicePresenter;
        widgetServicePresenter.onStartCommand(widgetSwitcherAddress, iIntValue2);
        return 2;
    }

    private void startForeground() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("channel_1", "WIDGET", 2));
            startForeground(1, new NotificationCompat.Builder(this, "channel_1").setContentTitle(getString(R.string.app_name)).setContentText(getString(R.string.app_name)).setAutoCancel(true).build());
            stopForeground(true);
        }
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void setSwitcherToWidgetSwitchService(Switcher switcher) {
        this.switchService.setSwitcher(switcher);
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void setLinkerToWidgetAirconService(IODevice iODevice) {
        this.airconService.setLinker(iODevice);
    }

    @Override // kr.switcher.switcherm.service.widget.WidgetSwitchService.OnControlSwitchListener
    public void onWaiting() {
        IOLog.i(TAG, "operating...");
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void controlSwitch() {
        this.switchService.controlSwitch();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void controlLinker(Remocon remocon) {
        if (remocon.getControllerId() == Remocon.ControllerID.AIRCON) {
            this.airconService.releaseIR();
        } else if (remocon.getControllerId() == Remocon.ControllerID.SET_TOP_BOX) {
            this.settopService.releaseIR();
        }
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void remoconConnect() {
        this.remoconConnector.remoconConnect();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void checkerRefresh(final Checker checker, int i) {
        WidgetCheckerService widgetCheckerService = new WidgetCheckerService(checker, i);
        this.checkerService = widgetCheckerService;
        widgetCheckerService.refreshWidget();
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.service.WidgetService.1
            @Override // java.lang.Runnable
            public void run() {
                new WidgetCheckerPreference().setWidgetCheckerRefreshFinished(new WidgetPreference().getWidgetId(IOUtil.makeLocalMacAddressFormat(checker.getMacAddress())), "true");
                IOUtil.sendBroadcastToCheckerWidget();
            }
        }, 2000L);
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void refreshAirconWidget(final Remocon remocon, int i) {
        WidgetAirconService widgetAirconService = new WidgetAirconService(remocon, i);
        this.airconService = widgetAirconService;
        widgetAirconService.refreshWidget();
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.service.WidgetService.2
            @Override // java.lang.Runnable
            public void run() {
                new WidgetPreference().setAirconWidgetRefreshFinished(new WidgetPreference().getWidgetId(remocon.getMacAddress()), true);
                IOUtil.sendBroadcastToAirconWidget();
            }
        }, 2000L);
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void updateTemperature(Remocon remocon, int i) {
        WidgetAirconService widgetAirconService = new WidgetAirconService(remocon, i);
        this.airconService = widgetAirconService;
        widgetAirconService.getTemperature(new WidgetPreference().getWidgetAliveLinker(), new WidgetPreference().getWidgetId(remocon.getMacAddress()));
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.service.WidgetService.3
            @Override // java.lang.Runnable
            public void run() {
                IOUtil.sendBroadcastToAirconWidget();
            }
        }, 1000L);
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void disconnect() {
        IOLog.i(TAG, "disconnect (screen off)");
        SwitcherHandler.getInstance().disconnectAll();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void sendMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void sendBroadcastToOneButtonWidget() {
        IOUtil.sendBroadcastToOneButtonWidget();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void sendBroadcastToTwoButtonWidget() {
        IOUtil.sendBroadcastToTwoButtonWidget();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void sendBroadcastToAirconWidget() {
        IOUtil.sendBroadcastToAirconWidget();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void sendBroadcastToSettopWidget() {
        IOUtil.sendBroadcastToSettopWidget();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void foundSwitcherInfo(Switcher switcher, int i) {
        this.connector = new WidgetSwitcherConnector(switcher, this);
        this.switchService = new WidgetSwitchService(switcher, i, this);
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void foundRemoconInfo(Remocon remocon, int i) {
        this.remoconConnector = new WidgetRemoconConnector(remocon, this);
        if (remocon.getControllerId() == Remocon.ControllerID.AIRCON) {
            this.airconService = new WidgetAirconService(remocon, i);
        } else if (remocon.getControllerId() == Remocon.ControllerID.SET_TOP_BOX) {
            this.settopService = new WidgetSettopService(remocon, i);
        }
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void connect() {
        this.connector.connect();
    }

    @Override // kr.switcher.switcherm.service.widget.WidgetSwitchService.OnControlSwitchListener
    public void onComplete(boolean z) {
        this.presenter.onComplete(z);
    }

    @Override // kr.switcher.switcherm.service.widget.WidgetRemoconConnector.OnConnectAirconListener
    public void onConnectionResult(IODevice iODevice) {
        this.presenter.onConnectionResult(iODevice);
    }

    @Override // kr.switcher.switcherm.service.widget.WidgetSwitcherConnector.OnConnectSwitcherListener
    public void onConnectionResult(Switcher switcher) {
        this.presenter.onConnectionResult(switcher);
    }

    @Override // kr.switcher.switcherm.service.widget.WidgetSwitcherConnector.OnConnectSwitcherListener
    public void onBatteryInfo(int i) {
        NotificationMessage notificationMessage = getNotificationMessage(i);
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannelUtil.createChannel(this);
            NotificationChannelUtil.sendNotification(this, 1, NotificationChannelUtil.Channel.NOTICE, notificationMessage.title, notificationMessage.content);
        } else {
            NotificationUtil.sendNotification(this, notificationMessage.title, notificationMessage.content, IOActivity.ACTION_MAIN, null);
        }
    }

    private NotificationMessage getNotificationMessage(int i) {
        return new NotificationMessage(IOUtil.getStringResource(R.string.low_battery_noti_title), IOUtil.getStringResource(R.string.low_battery_noti_content));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void onScreenOn() {
        IOLog.i(TAG, "onScreenOn()");
    }

    @Override // kr.switcher.switcherm.service.view.WidgetServiceView
    public void onScreenOff() {
        IOLog.i(TAG, "onScreenOff()");
        this.presenter.onScreenOff();
        sendMessage("연결 종료");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.switcherm.service.WidgetService.4
            @Override // java.lang.Runnable
            public void run() {
                WidgetService.this.unregisterReceiver();
                WidgetService.this.stopSelf();
            }
        }, 1000L);
    }

    private void registerReceiver() {
        IOLog.i(TAG, "registerReceiver()");
        this.oneButtonWidget = new OneButtonWidget();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.appwidget.action.APPWIDGET_UPDATE");
        intentFilter.addAction(OneButtonWidget.ACTION_ONE_BUTTON_WIDGET_STATE);
        registerReceiver(this.oneButtonWidget, intentFilter);
        this.twoButtonWidget = new TwoButtonWidget();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.appwidget.action.APPWIDGET_UPDATE");
        intentFilter2.addAction(TwoButtonWidget.ACTION_TWO_BUTTON_WIDGET_STATE);
        registerReceiver(this.twoButtonWidget, intentFilter2);
        this.airconWidget = new AirconWidget();
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("android.appwidget.action.APPWIDGET_UPDATE");
        intentFilter3.addAction(AirconWidget.ACTION_AIRCON_WIDGET_STATE);
        registerReceiver(this.airconWidget, intentFilter3);
        this.checkerWidget = new CheckerWidget();
        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction("android.appwidget.action.APPWIDGET_UPDATE");
        intentFilter4.addAction(CheckerWidget.ACTION_CHECKER_WIDGET_STATE);
        registerReceiver(this.checkerWidget, intentFilter4);
        this.settopWidget = new SettopWidget();
        IntentFilter intentFilter5 = new IntentFilter();
        intentFilter4.addAction("android.appwidget.action.APPWIDGET_UPDATE");
        intentFilter4.addAction(SettopWidget.ACTION_SETTOP_WIDGET_STATE);
        registerReceiver(this.settopWidget, intentFilter5);
        this.screenOnReceiver = new ScreenOnReceiver();
        IntentFilter intentFilter6 = new IntentFilter();
        intentFilter6.addAction("android.intent.action.SCREEN_ON");
        intentFilter6.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.screenOnReceiver, intentFilter6);
    }

    private void updateFCMID() {
        final FCMPreference fCMPreference = new FCMPreference();
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: kr.switcher.switcherm.service.WidgetService.5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(WidgetService.TAG, "토큰 생성 실패", task.getException());
                    return;
                }
                String result = task.getResult();
                fCMPreference.setFCMPreference(result);
                RestSwitcherAPIStore.requestPostFCMMobileDevices(result, new HttpResponseHandler() { // from class: kr.switcher.switcherm.service.WidgetService.5.1
                    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                    public void onSuccess(HttpAPIResponse httpAPIResponse) {
                        IOLog.i(WidgetService.TAG, "Updating FCM token to server was succeed");
                    }

                    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                    public void onFailure(String str, String str2) {
                        IOLog.i(WidgetService.TAG, "Updating FCM token to server was Failed");
                    }
                });
                AsyncHttpClient.log.d("MessageToken", result);
            }
        });
    }

    private void findDevicesMe() {
        RestSwitcherAPIStore.requestDevicesMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.service.WidgetService.6
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                WidgetService widgetService = WidgetService.this;
                widgetService.showMarketingNotification(widgetService.findRecommendationProduct(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findRecommendationProduct(List<DevicesMeAPIResponse> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, true);
        arrayList.add(1, false);
        arrayList.add(2, false);
        arrayList.add(3, false);
        arrayList.add(4, false);
        Iterator<DevicesMeAPIResponse> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().product_id).intValue(), true);
        }
        for (int i = 4; i >= 0; i--) {
            if (!((Boolean) arrayList.get(i)).booleanValue()) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMarketingNotification(int i) {
        IOLog.i(TAG, "Noti test indexOfProduct : " + i);
        if (Build.VERSION.SDK_INT < 26 || !new LocalMarketingPreference().getMarketingWidgetBanner()) {
            return;
        }
        SignalData signalData = new SignalData();
        if (i == 4) {
            signalData = new SignalData(4, 0, IOUtil.getStringResource(R.string.widget_banner_content_checker), IOUtil.getStringResource(R.string.widget_banner_title_checker), IOUtil.getStringResource(R.string.widget_banner_url_checker));
        } else if (i == 3) {
            signalData = new SignalData(4, 0, IOUtil.getStringResource(R.string.widget_banner_content_linker), IOUtil.getStringResource(R.string.widget_banner_title_linker), IOUtil.getStringResource(R.string.widget_banner_url_linker));
        } else if (i == 2 || i == 1) {
            signalData = new SignalData(4, 0, IOUtil.getStringResource(R.string.widget_banner_content_switcher), IOUtil.getStringResource(R.string.widget_banner_title_switcher), IOUtil.getStringResource(R.string.widget_banner_url_switcher));
        }
        SignalData signalData2 = signalData;
        if (i > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new NotiButtonParameter(NotiButtonParameter.PARM_NOTI_ACTION, NotiButtonParameter.NOTI_ACTION_DISABLE, "다시 보지 않기"));
            arrayList.add(new NotiButtonParameter(NotiButtonParameter.PARM_NOTI_ACTION, NotiButtonParameter.NOTI_ACTION_CONFIRM, "보러 가기"));
            NotificationUtil.sendNotification(this, signalData2.getTitleText(), signalData2.getContentText(), IOActivity.ACTION_WIDGET_BANNER, signalData2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterReceiver() {
        IOLog.i(TAG, "unregisterReceiver()");
        unregisterReceiver(this.oneButtonWidget);
        unregisterReceiver(this.twoButtonWidget);
        unregisterReceiver(this.airconWidget);
        unregisterReceiver(this.checkerWidget);
        unregisterReceiver(this.settopWidget);
        unregisterReceiver(this.screenOnReceiver);
    }

    class ScreenOnReceiver extends BroadcastReceiver {
        ScreenOnReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WidgetService.this.presenter.onReceive(intent);
        }
    }

    private class NotificationMessage {
        String content;
        String title;

        public NotificationMessage(String str, String str2) {
            this.title = str;
            this.content = str2;
        }
    }
}
