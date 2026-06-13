package kr.switcher.switcherm.ui.irbrand.interactor;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CreateApplianceMeAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.irbrand.adapter.BrandItem;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandListInteractor {
    private static final String TAG = "IRBrandListInteractor";
    private OnGetBrandListener getBrandListListener;
    private OnMakeRemoconListener makeRemoconListener;
    private OnSetRemoconSettingListener setRemoconSettingListener;

    public interface OnGetBrandListener {
        void onError(String str);

        void onGetBrandList(List<BrandItem> list);
    }

    public interface OnMakeRemoconListener {
        void onError(String str);

        void onMakeRemocon(Remocon remocon);
    }

    public interface OnSetRemoconSettingListener {
        void onError(String str);

        void onSetRemoconSetting();
    }

    public IRBrandListInteractor(OnGetBrandListener onGetBrandListener, OnMakeRemoconListener onMakeRemoconListener, OnSetRemoconSettingListener onSetRemoconSettingListener) {
        this.getBrandListListener = onGetBrandListener;
        this.makeRemoconListener = onMakeRemoconListener;
        this.setRemoconSettingListener = onSetRemoconSettingListener;
    }

    public void getBrandList(Remocon.ControllerID controllerID) {
        RestSwitcherAPIStore.requestGetBrands(controllerID, new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                IRBrandListInteractor.this.getBrandListListener.onGetBrandList(IODeviceMapper.parseGetBrands(list));
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOLog.error(IRBrandListInteractor.TAG, new OAuthToken().getOAuthToken(), "requestGetBrands", new Exception("code:" + str + ", message:" + str2));
                IRBrandListInteractor.this.getBrandListListener.onError(str2);
            }
        });
    }

    public void makeRemocon(String str, final Remocon.ControllerID controllerID) {
        RestSwitcherAPIStore.requestPostApplianceMe(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                Remocon getRemocon = IODeviceMapper.parseGetRemocon((CreateApplianceMeAPIResponse) httpAPIResponse);
                getRemocon.setControllerId(controllerID);
                IRBrandListInteractor.this.makeRemoconListener.onMakeRemocon(getRemocon);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str2, String str3) {
                IOLog.error(IRBrandListInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostApplianceMe", new Exception("code:" + str2 + ", message:" + str3));
                IRBrandListInteractor.this.makeRemoconListener.onError(str3);
            }
        });
    }

    public void setRemoconSetting(Remocon remocon, int i) {
        RestSwitcherAPIStore.requestPostAppliancesDatabases(remocon.getId(), remocon.getControllerId(), String.valueOf(i), new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.3
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                IRBrandListInteractor.this.setRemoconSettingListener.onSetRemoconSetting();
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(IRBrandListInteractor.TAG, new OAuthToken().getOAuthToken(), "requestPostAppliancesDatabases", new Exception("code:" + str + ", message:" + str2));
                IRBrandListInteractor.this.setRemoconSettingListener.onError(str2);
            }
        });
    }
}
