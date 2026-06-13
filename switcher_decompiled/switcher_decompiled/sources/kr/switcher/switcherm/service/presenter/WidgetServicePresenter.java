package kr.switcher.switcherm.service.presenter;

import android.content.Context;
import android.content.Intent;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.WidgetCheckerPreference;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.service.view.WidgetServiceView;
import kr.switcher.switcherm.signal.IOSignal;
import kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetServicePresenter {
    private static final String TAG = "WidgetServicePresenter";
    private Checker checker;
    private Context context;
    private IODevice ioDevice;
    private Linker linker = null;
    private Remocon remocon;
    private Switcher switcher;
    private WidgetServiceView view;

    public WidgetServicePresenter(WidgetServiceView widgetServiceView, Context context) {
        this.view = widgetServiceView;
        this.context = context;
    }

    public void onStartCommand(String str, int i) {
        if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
            this.linker = LinkerHandler.getInstance().getAliveLinkers().get(0);
        }
        findAliveLinker();
        IODevice device = IODeviceHandler.getInstance().getDevice(str);
        this.ioDevice = device;
        if (device != null) {
            if (device.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_ONE) || this.ioDevice.getProductId().equals(IODevice.ProductId.SWITCHER_TYPE_TWO)) {
                this.switcher = SwitcherHandler.getInstance().getSwitcher(str);
            } else if (this.ioDevice.getProductId().equals(IODevice.ProductId.REMOCON)) {
                this.remocon = (Remocon) IODeviceHandler.getInstance().getDevice(str);
            } else if (this.ioDevice.getProductId().equals(IODevice.ProductId.CHECKER)) {
                this.checker = (Checker) IODeviceHandler.getInstance().getDevice(str);
            }
            run(i);
        }
    }

    private void findAliveLinker() {
        new GetCurrentSensorValueForWidgetInteractor().getAliveLinker(new GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener() { // from class: kr.switcher.switcherm.service.presenter.WidgetServicePresenter.1
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onError() {
            }

            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onFindAliveLinker(String str) {
                new WidgetPreference().setWidgetAliveLinker(str);
                IOLog.i(WidgetServicePresenter.TAG, "Find Alive Linker in onStartCommand (macAddress : " + str);
            }
        });
    }

    private void sendBroadcast() {
        IODevice.ProductId productId = this.ioDevice.getProductId();
        if (productId == IODevice.ProductId.SWITCHER_TYPE_ONE) {
            this.view.sendBroadcastToOneButtonWidget();
            return;
        }
        if (productId == IODevice.ProductId.SWITCHER_TYPE_TWO) {
            this.view.sendBroadcastToTwoButtonWidget();
            return;
        }
        if (productId == IODevice.ProductId.REMOCON) {
            Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(this.ioDevice.getMacAddress());
            this.remocon = remocon;
            Remocon.ControllerID controllerId = remocon.getControllerId();
            if (controllerId == Remocon.ControllerID.AIRCON) {
                this.view.sendBroadcastToAirconWidget();
            } else if (controllerId == Remocon.ControllerID.SET_TOP_BOX) {
                this.view.sendBroadcastToSettopWidget();
            }
        }
    }

    public void run(int i) {
        WidgetPreference widgetPreference = new WidgetPreference();
        sendBroadcast();
        Switcher switcher = this.switcher;
        if (switcher != null) {
            this.view.foundSwitcherInfo(switcher, i);
            Switcher.ConnectionState connectionState = this.switcher.getConnectionState();
            if (connectionState.equals(Switcher.ConnectionState.CONNECTED)) {
                this.view.controlSwitch();
                return;
            } else {
                if (connectionState.equals(Switcher.ConnectionState.CONNECTING)) {
                    return;
                }
                this.view.connect();
                return;
            }
        }
        Remocon remocon = this.remocon;
        if (remocon != null) {
            this.view.foundRemoconInfo(remocon, i);
            if (this.remocon.getControllerId() != Remocon.ControllerID.AIRCON) {
                if (this.remocon.getControllerId() == Remocon.ControllerID.SET_TOP_BOX) {
                    if (widgetPreference.getWidgetAliveLinker().length() > 1) {
                        this.view.controlLinker(this.remocon);
                        return;
                    } else {
                        if (widgetPreference.getWidgetAliveLinker().length() < 2) {
                            new WidgetPreference().setWidgetAliveLinker("");
                            IOUtil.sendBroadcastToSettopWidget();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (i == 7) {
                new WidgetPreference().setAirconWidgetRefreshFinished(new WidgetPreference().getWidgetId(this.remocon.getMacAddress()), false);
                IOUtil.sendBroadcastToAirconWidget();
                this.view.refreshAirconWidget(this.remocon, i);
                return;
            } else {
                if (i == 8) {
                    this.view.updateTemperature(this.remocon, i);
                    return;
                }
                if (widgetPreference.getWidgetAliveLinker().length() > 1) {
                    this.view.controlLinker(this.remocon);
                    return;
                } else {
                    if (widgetPreference.getWidgetAliveLinker().length() < 2) {
                        new WidgetPreference().setWidgetAliveLinker("");
                        IOUtil.sendBroadcastToAirconWidget();
                        return;
                    }
                    return;
                }
            }
        }
        if (this.checker != null) {
            new WidgetCheckerPreference().setWidgetCheckerRefreshFinished(new WidgetPreference().getWidgetId(IOUtil.makeLocalMacAddressFormat(this.checker.getMacAddress())), "false");
            IOUtil.sendBroadcastToCheckerWidget();
            this.view.checkerRefresh(this.checker, i);
        }
    }

    public void onConnectionResult(Switcher switcher) {
        Switcher.ConnectionState connectionState = switcher.getConnectionState();
        this.switcher = switcher;
        this.view.setSwitcherToWidgetSwitchService(switcher);
        IOLog.i(TAG, "connection result (state : " + connectionState + ")");
        if (connectionState.equals(Switcher.ConnectionState.CONNECTED)) {
            this.view.controlSwitch();
            showMarketingSignalIfItIs();
        } else if (connectionState.equals(Switcher.ConnectionState.CONNECTING)) {
            this.view.sendMessage("연결중");
        } else if (connectionState.equals(Switcher.ConnectionState.FAILED)) {
            this.view.sendMessage("연결 실패");
        }
        sendBroadcast();
    }

    public void onConnectionResult(IODevice iODevice) {
        IODevice.ThingConnectionStatus thingConnectionStatus = iODevice.getThingConnectionStatus();
        this.ioDevice = iODevice;
        this.view.setLinkerToWidgetAirconService(iODevice);
        IOLog.i(TAG, "connection result (state : " + thingConnectionStatus + ")");
        if (thingConnectionStatus.equals(IODevice.ThingConnectionStatus.ALIVE)) {
            this.view.controlLinker((Remocon) iODevice);
        }
        sendBroadcast();
    }

    public void onComplete(boolean z) {
        IOLog.i(TAG, "command completed");
        sendBroadcast();
    }

    public void onReceive(Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_OFF")) {
            this.view.onScreenOff();
        } else if (action.equals("android.intent.action.SCREEN_ON")) {
            this.view.onScreenOn();
        }
    }

    public void onScreenOff() {
        this.view.disconnect();
        sendBroadcast();
    }

    private void showMarketingSignalIfItIs() {
        IOSignal.setContext(this.context);
        IOSignal.start();
    }
}
