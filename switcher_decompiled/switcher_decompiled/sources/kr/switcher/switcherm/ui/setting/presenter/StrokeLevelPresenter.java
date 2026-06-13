package kr.switcher.switcherm.ui.setting.presenter;

import android.os.Handler;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.setting.helper.PageViewer;
import kr.switcher.switcherm.ui.setting.view.StrokeLevelView;
import kr.switcher.switcherm.viewmodel.helper.LetKnowStrokeLevelStatus;

/* JADX INFO: loaded from: classes2.dex */
public class StrokeLevelPresenter implements IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback {
    private final int DISABLE_TIME = 2500;
    private final int POSITION_LEFTMOST = 0;
    private final int POSITION_RIGHTMOST = 2;
    private Handler handler = new Handler();
    private LetKnowStrokeLevelStatus letKnow;
    private boolean loading;
    private Runnable runnable;
    private int selectedLevel;
    private StrokeLevelView view;

    public StrokeLevelPresenter(StrokeLevelView strokeLevelView) {
        this.view = strokeLevelView;
        strokeLevelView.getStrokeLevel();
    }

    public void initialize(int i) {
        this.letKnow = new LetKnowStrokeLevelStatus(i);
        hidePagerComponent();
        initViewData(i);
        initViewPager(i);
    }

    private Runnable getRunnable(final int i) {
        return new Runnable() { // from class: kr.switcher.switcherm.ui.setting.presenter.StrokeLevelPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                StrokeLevelPresenter.this.setVisibleData(i);
                StrokeLevelPresenter.this.view.onFinishTest();
            }
        };
    }

    private void initViewData(int i) {
        this.loading = false;
        setStrokeLevel(i);
        this.view.activeSmallLevelText();
        this.view.activeMiddleLevelText();
        this.view.activeLongLevelText();
        this.view.setOpacityOneLeftArrowButton();
        this.view.setOpacityOneRightArrowButton();
    }

    public void setStrokeLevel(int i) {
        if (i == 0) {
            checkSmallLevel(true);
            checkMiddleLevel(false);
            checkLongLevel(false);
        } else if (i == 1) {
            checkSmallLevel(false);
            checkMiddleLevel(true);
            checkLongLevel(false);
        } else {
            if (i != 2) {
                return;
            }
            checkSmallLevel(false);
            checkMiddleLevel(false);
            checkLongLevel(true);
        }
    }

    private void checkSmallLevel(boolean z) {
        if (z) {
            this.view.checkSmallLevel();
            this.view.selectSmallLevel();
        } else {
            this.view.uncheckSmallLevel();
            this.view.unselectSmallLevel();
        }
    }

    private void checkMiddleLevel(boolean z) {
        if (z) {
            this.view.checkMiddleLevel();
            this.view.selectMiddleLevel();
        } else {
            this.view.uncheckMiddleLevel();
            this.view.unselectMiddleLevel();
        }
    }

    private void checkLongLevel(boolean z) {
        if (z) {
            this.view.checkLongLevel();
            this.view.selectLongLevel();
        } else {
            this.view.uncheckLongLevel();
            this.view.unselectLongLevel();
        }
    }

    public void initViewPager(int i) {
        setGAScreen(i);
        selectCheckBox(i);
        this.view.initViewPager(i);
        int size = new PageViewer(i).getPage().getSize();
        if (size > 1) {
            showPagerComponent();
            this.view.setPagerListener(size);
        } else {
            hidePagerComponent();
        }
    }

    public void selectCheckBox(int i) {
        this.letKnow.saveStrokeLevel(i);
        setStrokeLevel(i);
        setDisableData();
        this.view.onStartTest();
        this.handler.removeCallbacks(this.runnable);
        Runnable runnable = getRunnable(i);
        this.runnable = runnable;
        this.handler.postDelayed(runnable, 2500L);
    }

    public void setVisibleData(int i) {
        initViewData(i);
        this.view.setPagingEnable();
    }

    private void setDisableData() {
        this.view.setPagingDisable();
        if (this.letKnow.isActivated(0)) {
            this.view.activeSmallLevelText();
        } else {
            this.view.inactiveSmallLevelText();
        }
        if (this.letKnow.isActivated(1)) {
            this.view.activeMiddleLevelText();
        } else {
            this.view.inactiveMiddleLevelText();
        }
        if (this.letKnow.isActivated(2)) {
            this.view.activeLongLevelText();
        } else {
            this.view.inactiveLongLevelText();
        }
        this.view.setOpacityHalfLeftArrowButton();
        this.view.setOpacityHalfRightArrowButton();
        this.loading = true;
    }

    public void showPagerComponent() {
        this.view.showLeftArrowButton();
        this.view.showRightArrowButton();
        this.view.showProposeIndicator();
    }

    public void hidePagerComponent() {
        this.view.hideLeftArrowButton();
        this.view.hideRightArrowButton();
        this.view.hideProposeIndicator();
    }

    public void setNextPosition(int i, int i2, int i3) {
        int i4 = i + 1;
        if (i4 < i2) {
            this.view.setProposeCurrentItem(i4);
            selectItem(i4, i3);
        }
    }

    public void setPreviousPosition(int i, int i2) {
        if (i - 1 >= 0) {
            int i3 = i - 1;
            this.view.setProposeCurrentItem(i3);
            selectItem(i3, i2);
        }
    }

    public void selectItem(int i, int i2) {
        if (this.loading) {
            return;
        }
        selectLevel(i);
        selectCheckBox(i);
        this.view.testStrokeLevel(i);
        this.view.setProposeCurrentItem(i);
        if (i2 == 1) {
            setArrowStatus(i);
        }
        setGACategoryTestFingerLength(i);
    }

    public void selectLevel(int i) {
        this.selectedLevel = i;
    }

    private void setArrowStatus(int i) {
        if (i == 0) {
            this.view.showRightArrowButton();
            this.view.hideLeftArrowButton();
        } else if (i == 2) {
            this.view.showLeftArrowButton();
            this.view.hideRightArrowButton();
        } else {
            this.view.showLeftArrowButton();
            this.view.showRightArrowButton();
        }
    }

    public void onSaveButtonClicked() {
        if (this.loading) {
            return;
        }
        this.view.saveStrokeLevel(this.selectedLevel);
        selectCheckBox(this.selectedLevel);
    }

    public void setGAScreen(int i) {
        if (i == 0) {
            this.view.trackStrokeShortLevelFotGA();
        } else if (i == 1) {
            this.view.trackStrokeMiddleLevelFotGA();
        } else {
            if (i != 2) {
                return;
            }
            this.view.trackStrokeLongLevelFotGA();
        }
    }

    public void setGACategoryTestFingerLength(int i) {
        if (i == 0) {
            this.view.trackTestFingerLengthShortForGA();
        } else if (i == 1) {
            this.view.trackTestFingerLengthMiddleForGA();
        } else {
            if (i != 2) {
                return;
            }
            this.view.trackTestFingerLengthLongForGA();
        }
    }

    public void setGACategorySaveFingerLength(int i) {
        if (i == 0) {
            this.view.trackSaveFingerLengthShortForGA();
        } else if (i == 1) {
            this.view.trackSaveFingerLengthMiddleForGA();
        } else {
            if (i != 2) {
                return;
            }
            this.view.trackSaveFingerLengthLongForGA();
        }
    }

    public View.OnClickListener onClickRightArrowButtonClicked(final int i) {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.StrokeLevelPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StrokeLevelPresenter.this.view.onClickRightArrowButtonClicked(i);
            }
        };
    }

    public View.OnClickListener onClickLeftArrowButtonClicked() {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.StrokeLevelPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StrokeLevelPresenter.this.view.onClickLeftArrowButtonClicked();
            }
        };
    }

    public ViewPager.OnPageChangeListener onPageChangeListener(final int i) {
        return new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.StrokeLevelPresenter.4
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                StrokeLevelPresenter.this.selectItem(i2, i);
            }
        };
    }

    public void onStrokeLevelResult(int i) {
        LetKnowStrokeLevelStatus letKnowStrokeLevelStatus = this.letKnow;
        if (letKnowStrokeLevelStatus == null || i == letKnowStrokeLevelStatus.getSavedStrokeLevel()) {
            return;
        }
        if (i == -1) {
            this.view.showErrorMessage("손가락 길이 정보를 읽어오는데 실패했습니다");
        } else {
            initialize(i);
        }
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.StrokeLevelUpdateResultResponseCallback
    public void onStrokeLevelResult(boolean z) {
        if (z) {
            this.view.saveStrokeLevelToDB(this.selectedLevel);
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.save_stroke_level_setting));
            initViewPager(this.selectedLevel);
            setGACategorySaveFingerLength(this.selectedLevel);
        } else {
            this.view.showErrorMessage(IOUtil.getStringResource(R.string.failed_stroke_level_setting));
        }
        setVisibleData(this.selectedLevel);
    }
}
