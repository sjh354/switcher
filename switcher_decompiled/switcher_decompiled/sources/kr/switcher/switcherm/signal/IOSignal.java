package kr.switcher.switcherm.signal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.notification.NotiButtonParameter;
import kr.switcher.switcherm.common.notification.NotificationUtil;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.LocalMarketingPreference;
import kr.switcher.switcherm.signal.helper.FindSignalDataInteractor;

/* JADX INFO: loaded from: classes2.dex */
public class IOSignal {
    private static final String TAG = "IOSignal";
    private static Context context;
    private static List<SignalFragment> registeredFragmentList = new ArrayList();
    private static SignalData signalData = new SignalData();

    public static void registerSignalFragment(SignalFragment signalFragment) {
        registeredFragmentList.add(signalFragment);
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void clear() {
        registeredFragmentList = new ArrayList();
        signalData = new SignalData();
    }

    public static void start() {
        if (SwitcherHandler.getInstance().getConnectedSwitcherList().size() <= 0) {
            return;
        }
        final String macAddress = SwitcherHandler.getInstance().getConnectedSwitcherList().get(0).getMacAddress();
        if (IOUtil.checkIsIODeviceKey(macAddress)) {
            signalData.ready();
            new FindSignalDataInteractor(getOnFoundSignalDataListener(macAddress)).findSignalForFeature(macAddress);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: kr.switcher.switcherm.signal.IOSignal.1
                @Override // java.lang.Runnable
                public void run() {
                    IOSignal.signalData.push(IOSignal.signal(macAddress, IOSignal.signalData));
                }
            }, 1000L);
        }
    }

    private static FindSignalDataInteractor.OnFoundSignalDataListener getOnFoundSignalDataListener(final String str) {
        return new FindSignalDataInteractor.OnFoundSignalDataListener() { // from class: kr.switcher.switcherm.signal.IOSignal.2
            @Override // kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.OnFoundSignalDataListener
            public void onFoundSignalData(SignalData signalData2) {
                SignalData unused = IOSignal.signalData = signalData2;
                IOSignal.pushSignalBySignalStatus(str, IOSignal.signalData);
            }

            @Override // kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.OnFoundSignalDataListener
            public void onEmpty() {
                new FindSignalDataInteractor(IOSignal.getOnFoundSignalDataForMarketingListener()).findSignalForMarketing();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FindSignalDataInteractor.OnFoundSignalDataListener getOnFoundSignalDataForMarketingListener() {
        return new FindSignalDataInteractor.OnFoundSignalDataListener() { // from class: kr.switcher.switcherm.signal.IOSignal.3
            @Override // kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.OnFoundSignalDataListener
            public void onFoundSignalData(SignalData signalData2) {
                IOLog.d(IOSignal.TAG, "found marketing signal");
                signalData2.push(IOSignal.signal(null, signalData2));
            }

            @Override // kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.OnFoundSignalDataListener
            public void onEmpty() {
                IOLog.d(IOSignal.TAG, "marketing signal is empty");
                new FindSignalDataInteractor(IOSignal.getOnFoundSignalDataForLocalMarketingListener()).findSignalForLocalMarketing();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FindSignalDataInteractor.OnFoundSignalDataListener getOnFoundSignalDataForLocalMarketingListener() {
        return new FindSignalDataInteractor.OnFoundSignalDataListener() { // from class: kr.switcher.switcherm.signal.IOSignal.4
            @Override // kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.OnFoundSignalDataListener
            public void onFoundSignalData(SignalData signalData2) {
                if (Build.VERSION.SDK_INT < 26 || !new LocalMarketingPreference().getLocalMarketingLinker()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new NotiButtonParameter(NotiButtonParameter.PARM_NOTI_ACTION, NotiButtonParameter.NOTI_ACTION_DISABLE, "다시 보지 않기"));
                arrayList.add(new NotiButtonParameter(NotiButtonParameter.PARM_NOTI_ACTION, NotiButtonParameter.NOTI_ACTION_CONFIRM, "보러 가기"));
                NotificationUtil.sendNotification(IOSignal.context, signalData2.getTitleText(), signalData2.getContentText(), IOActivity.ACTION_SIGNAL, signalData2, arrayList);
            }

            @Override // kr.switcher.switcherm.signal.helper.FindSignalDataInteractor.OnFoundSignalDataListener
            public void onEmpty() {
                IOLog.d(IOSignal.TAG, "local marketing signal is empty");
            }
        };
    }

    public static int pushSignalBySignalStatus(String str, SignalData signalData2) {
        if (signalData2.getSignalStatus() == 2) {
            signalData2.push(signal(str, signalData2));
        }
        return signalData2.getSignalStatus();
    }

    public static void pushSignalToNotificationBar(SignalData signalData2) {
        NotificationUtil.sendNotification(context, signalData2.getTitleText(), signalData2.getContentText(), IOActivity.ACTION_SIGNAL, signalData2);
    }

    public static boolean signal(String str, SignalData signalData2) {
        if (!signalData2.checkIsValidData()) {
            return false;
        }
        if (registeredFragmentList.size() == 0 || signalData2.getType() == 0) {
            pushSignalToNotificationBar(signalData2);
        } else {
            Iterator<SignalFragment> it = registeredFragmentList.iterator();
            while (it.hasNext()) {
                it.next().onSignal(str, signalData2);
            }
            IOLog.i(TAG, "signal (mac address:" + str + ", type:" + signalData2.getType() + ")");
        }
        signalData = new SignalData();
        return true;
    }
}
