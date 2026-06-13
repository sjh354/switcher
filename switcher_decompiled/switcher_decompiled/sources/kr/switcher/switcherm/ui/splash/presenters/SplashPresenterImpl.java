package kr.switcher.switcherm.ui.splash.presenters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.preference.AutoBluetoothPreference;
import kr.switcher.switcherm.preference.LoginUser;
import kr.switcher.switcherm.signal.SignalData;
import kr.switcher.switcherm.ui.dialog.signal.interactor.SendStatusForSignalInteractor;
import kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractor;
import kr.switcher.switcherm.ui.splash.views.SplashView;

/* JADX INFO: loaded from: classes2.dex */
public class SplashPresenterImpl implements SplashPresenter, FindTokenInteractor.OnFinishedListener {
    private static final String TAG = "SplashPresenterImpl";
    private FindTokenInteractor findTokenInteractor;
    private Handler handler = new Handler(Looper.getMainLooper());
    private SendStatusForSignalInteractor signalInteractor;
    private SplashView view;

    public SplashPresenterImpl(Context context, SplashView splashView, FindTokenInteractor findTokenInteractor, SendStatusForSignalInteractor sendStatusForSignalInteractor) {
        this.view = splashView;
        this.findTokenInteractor = findTokenInteractor;
        this.signalInteractor = sendStatusForSignalInteractor;
    }

    @Override // kr.switcher.switcherm.ui.splash.presenters.SplashPresenter
    public void onResume(int i, Parcelable parcelable) {
        if (i == IOActivity.ACTION_MAIN && this.view.checkPermission()) {
            this.findTokenInteractor.findIsToken(this);
            if (new AutoBluetoothPreference().getAutoBluetooth().booleanValue()) {
                SwitcherUtil.activeBluetoothIfOffWithDelay();
                return;
            }
            return;
        }
        if (i == IOActivity.ACTION_WIDGET) {
            this.view.showWebsite(IOUtil.getStringResource(R.string.cafe_link_lg_o_widget));
        } else if (i == IOActivity.ACTION_SIGNAL || i == IOActivity.ACTION_WIDGET_BANNER) {
            showSignalResult((SignalData) parcelable);
        }
    }

    @Override // kr.switcher.switcherm.ui.splash.presenters.SplashPresenter
    public void onPause() {
        this.findTokenInteractor.finish();
    }

    @Override // kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractor.OnFinishedListener
    public void onIsToken(boolean z) {
        if (z) {
            this.view.moveMainActivity();
            this.view.updateFCMToken();
        } else {
            this.view.moveStartActivity();
        }
    }

    @Override // kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractor.OnFinishedListener
    public void onMigration(boolean z) {
        if (!z) {
            this.view.showMessage("마이그레이션 실패");
        }
        new LoginUser().setMigration(true);
        this.findTokenInteractor.findIsToken(this);
    }

    private void showSignalResult(SignalData signalData) {
        if (signalData != null) {
            String macAddress = SwitcherHandler.getInstance().getConnectedSwitcherList().size() > 0 ? SwitcherHandler.getInstance().getConnectedSwitcherList().get(0).getMacAddress() : "";
            int type = signalData.getType();
            if (type == 0) {
                this.signalInteractor.sendStatus(null, signalData, SignalData.SIGNAL_STATUS_ACCEPTED);
                this.view.showWebsite(signalData.getUrl());
                return;
            }
            if (type == 1) {
                this.signalInteractor.sendStatus(macAddress, signalData, SignalData.SIGNAL_STATUS_ACCEPTED);
                this.view.moveSettingStrokeMenu(macAddress);
                return;
            }
            if (type == 2) {
                this.signalInteractor.sendStatus(macAddress, signalData, SignalData.SIGNAL_STATUS_ACCEPTED);
                this.view.moveSettingReservationMenu(macAddress);
            } else if (type == 3) {
                this.signalInteractor.sendStatus(macAddress, signalData, SignalData.SIGNAL_STATUS_ACCEPTED);
                this.view.showWebsite(signalData.getUrl());
            } else {
                if (type != 4) {
                    return;
                }
                this.view.showWebsite(signalData.getUrl());
            }
        }
    }
}
