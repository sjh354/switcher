package kr.switcher.switcherm.ui.irbrand.presenter;

import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.irbrand.adapter.BrandItem;
import kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor;
import kr.switcher.switcherm.ui.irbrand.view.IRBrandListView;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandListPresenter {
    private IRBrandListInteractor interactor;
    private IRBrandListView view;

    public IRBrandListPresenter(IRBrandListView iRBrandListView, IRBrandListInteractor iRBrandListInteractor) {
        this.view = iRBrandListView;
        this.interactor = iRBrandListInteractor;
    }

    public void onResume(Remocon.ControllerID controllerID) {
        this.view.initRecyclerListView();
        this.interactor.getBrandList(controllerID);
    }

    public void onItemClick(String str, Remocon.ControllerID controllerID) {
        this.interactor.makeRemocon(str, controllerID);
    }

    public void onGetBrandList(List<BrandItem> list) {
        this.view.setBrandItems(list);
    }

    public void onMakeRemocon(Remocon remocon, int i) {
        this.interactor.setRemoconSetting(remocon, i);
    }

    public void onSetRemoconSetting() {
        this.view.acvivityFinish();
    }
}
