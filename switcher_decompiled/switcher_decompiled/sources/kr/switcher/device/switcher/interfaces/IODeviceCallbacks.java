package kr.switcher.device.switcher.interfaces;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: loaded from: classes2.dex */
public class IODeviceCallbacks {

    public interface ActionShareCodeResultCallback {
        void onActionComplete(boolean z);
    }

    public interface CreateSwitcherResultCallback {
        void onCreateComplete(boolean z);
    }

    public interface FirmwareVersionResultCallback {
        void onFirmwareVersion(String str);
    }

    public interface LoadTimerInfoResultResponseCallback {
        void onLoadReservationListResult(List<Switcher.SwitcherReservation> list);
    }

    public interface OnCardChangeResultCallback {
        void onCardChangeResult(boolean z);
    }

    public interface OnChangePaymentPlanInfoResultCallback {
        void onPaymentPlanResult(boolean z);
    }

    public interface OnCommandResultCallback {
        void onCommandResult(String str);
    }

    public interface OnControlResponseListener {
        void onControlResult(boolean z);
    }

    public interface OnDeviceConnectListener {
        void onConnected(IODevice iODevice);

        void onDisconnected(String str, int i);
    }

    public interface OnGetCardCompaniesCallback {
        void onCardCompaniesResult(List<String> list);
    }

    public interface OnPaymentAndPlanInfoResultCallback {
        void onPaymentAndPlanInfoResult(String str, String str2, String str3);
    }

    public interface OnSetCreditCardCallback {
        void onCreditCardResult(boolean z);
    }

    public interface OnShareCodeChangeResultCallback {
        void onShareCodeChangeResult(boolean z);
    }

    public interface ReservationUpdateResultCallback {
        void onUpdatedReservation(boolean z);
    }

    public interface ReturnResultResponseCallback {
        void onReturnResult(String str);
    }

    public interface StrokeLevelReadResultResponseCallback {
        void onStrokeLevelResult(int i);
    }

    public interface StrokeLevelUpdateResultResponseCallback {
        void onStrokeLevelResult(boolean z);
    }

    public interface SwitcherConnectionResultCallback {
        void onConnectionStateResult(Switcher switcher, int i);
    }

    public interface SwitcherRestResponseCallback {
        void onSwitcherInfo(Switcher switcher);
    }

    public interface UpdateCreditCardMeResultResponseCallback {
        void onUpdateCreditCardMeResult(boolean z);
    }
}
