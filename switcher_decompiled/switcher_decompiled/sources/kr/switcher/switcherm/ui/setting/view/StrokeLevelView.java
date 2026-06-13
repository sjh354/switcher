package kr.switcher.switcherm.ui.setting.view;

/* JADX INFO: loaded from: classes2.dex */
public interface StrokeLevelView {
    void activeLongLevelText();

    void activeMiddleLevelText();

    void activeSmallLevelText();

    void checkLongLevel();

    void checkMiddleLevel();

    void checkSmallLevel();

    void getStrokeLevel();

    void hideLeftArrowButton();

    void hideProposeIndicator();

    void hideRightArrowButton();

    void inactiveLongLevelText();

    void inactiveMiddleLevelText();

    void inactiveSmallLevelText();

    void initViewPager(int i);

    void onClickLeftArrowButtonClicked();

    void onClickRightArrowButtonClicked(int i);

    void onFinishTest();

    void onStartTest();

    void saveStrokeLevel(int i);

    void saveStrokeLevelToDB(int i);

    void selectLongLevel();

    void selectMiddleLevel();

    void selectSmallLevel();

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

    void testStrokeLevel(int i);

    void trackSaveFingerLengthLongForGA();

    void trackSaveFingerLengthMiddleForGA();

    void trackSaveFingerLengthShortForGA();

    void trackStrokeLongLevelFotGA();

    void trackStrokeMiddleLevelFotGA();

    void trackStrokeShortLevelFotGA();

    void trackTestFingerLengthLongForGA();

    void trackTestFingerLengthMiddleForGA();

    void trackTestFingerLengthShortForGA();

    void uncheckLongLevel();

    void uncheckMiddleLevel();

    void uncheckSmallLevel();

    void unselectLongLevel();

    void unselectMiddleLevel();

    void unselectSmallLevel();
}
