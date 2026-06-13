package kr.switcher.switcherm.ui.irbrand.view;

import kr.switcher.device.remocon.Remocon;

/* JADX INFO: loaded from: classes2.dex */
public interface IRBrandProductSelectView {
    void activeRegisterButton();

    void activityFinish();

    void hideLeftArrowButton();

    void hideProposeIndicator();

    void hideRightArrowButton();

    void inactiveRegisterButton();

    void initViewPager(int i);

    void moveIRBrandListFragment(Remocon.ControllerID controllerID, String str);

    void moveIRCommandRegisterActivity(Remocon remocon);

    void onClickLeftArrowButtonClicked();

    void onClickRightArrowButtonClicked(int i);

    void refreshViewPage();

    void setControllerName(String str);

    void setOpacityHalfLeftArrowButton();

    void setOpacityHalfRightArrowButton();

    void setOpacityOneLeftArrowButton();

    void setOpacityOneRightArrowButton();

    void setPagerListener(int i);

    void setPagingDisable();

    void setPagingEnable();

    void setProposeCurrentItem(int i);

    void showErrorMessage(String str);

    void showLeftArrowButton();

    void showProposeIndicator();

    void showRightArrowButton();
}
