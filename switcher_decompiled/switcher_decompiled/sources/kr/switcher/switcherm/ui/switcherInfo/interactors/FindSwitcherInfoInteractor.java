package kr.switcher.switcherm.ui.switcherInfo.interactors;

import android.content.Context;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.device.switcher.option.PaymentInfo;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.ConsignmentAPIResponse;
import kr.switcher.switcherm.network.http.response.ContractAPIResponse;
import kr.switcher.switcherm.network.http.response.FreeTrialAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.ReturnInfo;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class FindSwitcherInfoInteractor {
    private static final String TAG = "FindSwitcherInfoInteractor";
    private IODevice ioDevice;

    public interface OnFoundMainSwitcherListener {
        void onFoundMainSwitcher(boolean z);
    }

    public interface OnGetSwitcherInfoListener {
        void onGetSwitcherInfoResult(IODevice iODevice, String str, String str2, String str3, String str4, String str5);
    }

    public interface OnInitializeResultListener {
        void onInitializeResult(IODevice iODevice);
    }

    public interface OnPaymentInfoListener {
        void onPaymentInfo(String str, int i, int i2, String str2);
    }

    public FindSwitcherInfoInteractor(Context context, IODevice iODevice) {
        this.ioDevice = iODevice;
    }

    public void requestSwitcherDetails(final OnGetSwitcherInfoListener onGetSwitcherInfoListener) {
        SwitcherHandler.getInstance().getCreditCardMeFromRestServer(this.ioDevice.getMacAddress(), new IODeviceCallbacks.UpdateCreditCardMeResultResponseCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.1
            @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.UpdateCreditCardMeResultResponseCallback
            public void onUpdateCreditCardMeResult(boolean z) {
                if (z) {
                    ReturnInfo returnInfo = new ReturnInfo(FindSwitcherInfoInteractor.this.ioDevice.getMacAddress());
                    PaymentInfo paymentInfo = FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo();
                    onGetSwitcherInfoListener.onGetSwitcherInfoResult(FindSwitcherInfoInteractor.this.ioDevice, paymentInfo.getCardName(), paymentInfo.getNextPayAt(), IOUtil.convertPaymentTypeName(paymentInfo.getPaymentMethod()), returnInfo.getHopeVisit(), returnInfo.getInvoiceNumber());
                }
            }
        });
    }

    public void requestInitializeSwitcher(final OnInitializeResultListener onInitializeResultListener) {
        RestSwitcherAPIStore.requestDeleteDeviceMe(this.ioDevice.getMacAddress(), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IODeviceHandler.getInstance().removeDevice(FindSwitcherInfoInteractor.this.ioDevice);
                onInitializeResultListener.onInitializeResult(FindSwitcherInfoInteractor.this.ioDevice);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(FindSwitcherInfoInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostHashingShareCode", new Exception("code:" + str + ", message:" + str2));
            }
        });
    }

    public void findMainSwitcher(OnFoundMainSwitcherListener onFoundMainSwitcherListener) {
        onFoundMainSwitcherListener.onFoundMainSwitcher(this.ioDevice.getMacAddress().equalsIgnoreCase(UserStateManager.getInstance().getCurrentUserFromDB().getMainSwitcherCode()));
    }

    public void findPaymentInfo(final OnPaymentInfoListener onPaymentInfoListener) {
        String type = this.ioDevice.getOption().getPaymentInfo().getType();
        if (type == null) {
            onPaymentInfoListener.onPaymentInfo(PaymentInfo.BUYING_TYPE_CONTRACT, this.ioDevice.getOption().getShipping().getStatus(), 3, "");
            return;
        }
        int buyingId = this.ioDevice.getOption().getPaymentInfo().getBuyingId();
        if (type.equals(PaymentInfo.BUYING_TYPE_FREE_TRIAL)) {
            RestSwitcherAPIStore.requestGetFreeTrial(buyingId, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.3
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    FreeTrialAPIResponse freeTrialAPIResponse = (FreeTrialAPIResponse) httpAPIResponse;
                    FindSwitcherInfoInteractor.this.ioDevice.getOption().setPaymentMethod(freeTrialAPIResponse.payment_method, freeTrialAPIResponse.end_at);
                    onPaymentInfoListener.onPaymentInfo(FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo().getType(), FindSwitcherInfoInteractor.this.ioDevice.getOption().getShipping().getStatus(), FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo().getPaymentMethod(), "");
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    IOLog.error(FindSwitcherInfoInteractor.TAG, new OAuthToken().getOAuthToken(), "findPaymentInfo", new Exception("code:" + str + ", message:" + str2));
                }
            });
        } else if (type.equals(PaymentInfo.BUYING_TYPE_CONTRACT)) {
            RestSwitcherAPIStore.requestGetContract(buyingId, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.4
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    ContractAPIResponse contractAPIResponse = (ContractAPIResponse) httpAPIResponse;
                    FindSwitcherInfoInteractor.this.ioDevice.getOption().setPaymentMethod(contractAPIResponse.payment_method, contractAPIResponse.next_pay_at);
                    FindSwitcherInfoInteractor.this.ioDevice.getOption().setContractStatus(contractAPIResponse.status);
                    onPaymentInfoListener.onPaymentInfo(FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo().getType(), FindSwitcherInfoInteractor.this.ioDevice.getOption().getShipping().getStatus(), FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo().getPaymentMethod(), FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo().getStatus());
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    IOLog.error(FindSwitcherInfoInteractor.TAG, new OAuthToken().getOAuthToken(), "findPaymentInfo", new Exception("code:" + str + ", message:" + str2));
                }
            });
        } else if (type.equals(PaymentInfo.BUYING_TYPE_CONSIGNMENT)) {
            RestSwitcherAPIStore.requestGetConsignment(buyingId, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.5
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    FindSwitcherInfoInteractor.this.ioDevice.getOption().setPaymentMethod(((ConsignmentAPIResponse) httpAPIResponse).payment_method, null);
                    onPaymentInfoListener.onPaymentInfo(FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo().getType(), FindSwitcherInfoInteractor.this.ioDevice.getOption().getShipping().getStatus(), FindSwitcherInfoInteractor.this.ioDevice.getOption().getPaymentInfo().getPaymentMethod(), "");
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str, String str2) {
                    IOLog.error(FindSwitcherInfoInteractor.TAG, new OAuthToken().getOAuthToken(), "findPaymentInfo", new Exception("code:" + str + ", message:" + str2));
                }
            });
        }
    }
}
