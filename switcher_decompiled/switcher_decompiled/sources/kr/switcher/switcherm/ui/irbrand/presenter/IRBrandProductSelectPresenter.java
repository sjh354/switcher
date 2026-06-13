package kr.switcher.switcherm.ui.irbrand.presenter;

import android.os.Handler;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.irbrand.helper.ControllerItem;
import kr.switcher.switcherm.ui.irbrand.helper.PageViewer;
import kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor;
import kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandProductSelectPresenter {
    private final int POSITION_LEFTMOST = 0;
    private final int POSITION_RIGHTMOST = 3;
    private Handler handler = new Handler();
    private IRControllerInteractor interactor;
    private boolean loading;
    private int selectedProduct;
    private IRBrandProductSelectView view;

    public void onSaveButtonClicked() {
    }

    public IRBrandProductSelectPresenter(IRBrandProductSelectView iRBrandProductSelectView, IRControllerInteractor iRControllerInteractor) {
        this.view = iRBrandProductSelectView;
        this.interactor = iRControllerInteractor;
    }

    public void initialize() {
        hidePagerComponent();
        this.interactor.getController();
        this.view.inactiveRegisterButton();
    }

    private void initViewData() {
        this.view.setOpacityOneLeftArrowButton();
        this.view.setOpacityOneRightArrowButton();
    }

    public void initViewPager(int i) {
        this.view.initViewPager(i);
    }

    public void hidePagerComponent() {
        this.view.hideLeftArrowButton();
        this.view.hideRightArrowButton();
        this.view.hideProposeIndicator();
    }

    public void showPagerComponent() {
        this.view.showRightArrowButton();
        this.view.showProposeIndicator();
    }

    public void setNextPosition(int i, int i2) {
        int i3 = i + 1;
        if (i3 < i2) {
            this.view.setProposeCurrentItem(i3);
        }
    }

    public void setPreviousPosition(int i) {
        if (i - 1 >= 0) {
            this.view.setProposeCurrentItem(i - 1);
        }
    }

    public void selectItem(int i) {
        selectProduct(i);
        setArrowStatus(i);
        this.view.setProposeCurrentItem(i);
    }

    public void selectProduct(int i) {
        this.selectedProduct = i;
    }

    private void setArrowStatus(int i) {
        if (i == 0) {
            this.view.showRightArrowButton();
            this.view.hideLeftArrowButton();
        } else if (i == 3) {
            this.view.showLeftArrowButton();
            this.view.hideRightArrowButton();
        } else {
            this.view.showLeftArrowButton();
            this.view.showRightArrowButton();
        }
    }

    public View.OnClickListener onClickRightArrowButtonClicked(final int i) {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.irbrand.presenter.IRBrandProductSelectPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IRBrandProductSelectPresenter.this.view.onClickRightArrowButtonClicked(i);
            }
        };
    }

    public View.OnClickListener onClickLeftArrowButtonClicked() {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.irbrand.presenter.IRBrandProductSelectPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IRBrandProductSelectPresenter.this.view.onClickLeftArrowButtonClicked();
            }
        };
    }

    public ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.irbrand.presenter.IRBrandProductSelectPresenter.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IRBrandProductSelectPresenter.this.selectItem(i);
            }
        };
    }

    public void onGetRemoteController(List<ControllerItem> list) {
        initViewData();
        initViewPager(0);
        int size = new PageViewer(list).getPage().getSize();
        if (size > 0) {
            showPagerComponent();
            this.view.setPagerListener(size);
            this.view.refreshViewPage();
            return;
        }
        hidePagerComponent();
    }

    public void onTextChanged(String str) {
        if (!checkIsValidData(str)) {
            this.view.inactiveRegisterButton();
        } else {
            this.view.activeRegisterButton();
        }
    }

    private boolean checkIsValidData(String str) {
        return str != null && str.length() >= 1;
    }

    public void onRegisterBtnClicked(int i, String str) {
        int i2 = i + 1;
        if (i2 == 4) {
            this.interactor.createRemocon(str);
        } else {
            this.view.moveIRBrandListFragment(Remocon.convertIntToControllerID(i2), str);
        }
    }

    public void onCreateRemocon(Remocon remocon) {
        this.view.moveIRCommandRegisterActivity(remocon);
        this.view.activityFinish();
    }
}
