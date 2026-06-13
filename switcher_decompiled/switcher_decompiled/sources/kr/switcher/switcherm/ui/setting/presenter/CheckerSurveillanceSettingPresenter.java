package kr.switcher.switcherm.ui.setting.presenter;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.ui.setting.helper.CheckerSurveillanceCreator;
import kr.switcher.switcherm.ui.setting.helper.CheckerSurveillanceInfo;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.interactor.DeleteSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.MakeSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyCheckerSurveillanceInteractor;
import kr.switcher.switcherm.ui.setting.view.CheckerSurveillanceSettingView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceSettingPresenter {
    private static final String TAG = "CheckerSurveillanceSettingPresenter";
    private DeleteSurveillanceInteractor deleteInteractor;
    private MakeSurveillanceInteractor makeInteractor;
    private ModifyCheckerSurveillanceInteractor modifyInteractor;
    private CheckerSurveillanceSettingView view;
    private int MIN_STAGE = 1;
    private int MAX_STAGE = 2;
    private final int POSITION_LEFTMOST = 0;
    private final int POSITION_RIGHTMOST = 1;
    private final int MAX_PAGE = 2;

    public CheckerSurveillanceSettingPresenter(CheckerSurveillanceSettingView checkerSurveillanceSettingView, MakeSurveillanceInteractor makeSurveillanceInteractor, ModifyCheckerSurveillanceInteractor modifyCheckerSurveillanceInteractor, DeleteSurveillanceInteractor deleteSurveillanceInteractor) {
        this.view = checkerSurveillanceSettingView;
        this.makeInteractor = makeSurveillanceInteractor;
        this.modifyInteractor = modifyCheckerSurveillanceInteractor;
        this.deleteInteractor = deleteSurveillanceInteractor;
    }

    public void onCreateView(Checker.Surveillance surveillance) {
        this.view.initWheel();
        this.view.initViewPager(0);
        showPagerComponent();
        this.view.setPagerListener(2);
        this.view.refreshViewPage();
        setDefault();
        if (surveillance == null) {
            this.view.setSurveillanceInfo(new CheckerSurveillanceCreator().getCheckerSurveillance());
            this.view.hideRemoveButton();
        } else {
            this.view.setSurveillanceInfo(surveillance);
            this.view.showRemoveButton();
        }
    }

    private void showPagerComponent() {
        this.view.showRightArrowButton();
    }

    private boolean checkEndtimeIsSame(Checker.Surveillance surveillance) {
        return surveillance.startAt.equals(surveillance.endAt);
    }

    private Boolean checkEndtimeIsBigger(Checker.Surveillance surveillance) {
        String str = surveillance.startAt;
        String str2 = surveillance.endAt;
        if (Integer.parseInt(str.substring(0, 2)) <= Integer.parseInt(str2.substring(0, 2))) {
            return true;
        }
        return false;
    }

    private void makeSecondSurveillanceWeekDays(Checker.Surveillance surveillance) {
        surveillance.mon = false;
        surveillance.tue = false;
        surveillance.wed = false;
        surveillance.thu = false;
        surveillance.fri = false;
        surveillance.sat = false;
        surveillance.sun = false;
        if (surveillance.weekDays.charAt(0) == '1') {
            surveillance.tue = true;
        }
        if (surveillance.weekDays.charAt(1) == '1') {
            surveillance.wed = true;
        }
        if (surveillance.weekDays.charAt(2) == '1') {
            surveillance.thu = true;
        }
        if (surveillance.weekDays.charAt(3) == '1') {
            surveillance.fri = true;
        }
        if (surveillance.weekDays.charAt(4) == '1') {
            surveillance.sat = true;
        }
        if (surveillance.weekDays.charAt(5) == '1') {
            surveillance.sun = true;
        }
        if (surveillance.weekDays.charAt(6) == '1') {
            surveillance.mon = true;
        }
    }

    public void onRemoveButtonClicked(String str, int i) {
        this.deleteInteractor.requestDeleteCheckersSurveillance(str, String.valueOf(i));
    }

    public void setMon(boolean z) {
        if (z) {
            this.view.selectMon();
        } else {
            this.view.unSelectMon();
        }
        this.view.setRepeater();
    }

    public void setTue(boolean z) {
        if (z) {
            this.view.selectTue();
        } else {
            this.view.unSelectTue();
        }
        this.view.setRepeater();
    }

    public void setWed(boolean z) {
        if (z) {
            this.view.selectWed();
        } else {
            this.view.unSelectWed();
        }
        this.view.setRepeater();
    }

    public void setThu(boolean z) {
        if (z) {
            this.view.selectThu();
        } else {
            this.view.unSelectThu();
        }
        this.view.setRepeater();
    }

    public void setFri(boolean z) {
        if (z) {
            this.view.selectFri();
        } else {
            this.view.unSelectFri();
        }
        this.view.setRepeater();
    }

    public void setSat(boolean z) {
        if (z) {
            this.view.selectSat();
        } else {
            this.view.unSelectSat();
        }
        this.view.setRepeater();
    }

    public void setSun(boolean z) {
        if (z) {
            this.view.selectSun();
        } else {
            this.view.unSelectSun();
        }
        this.view.setRepeater();
    }

    public void setCheckerSurveillanceData(Checker.Surveillance surveillance) {
        surveillance.weekDays = makeWeekDays(surveillance);
        surveillance.startAt = makeTimeAt(surveillance.startHour, surveillance.startMin);
        surveillance.endAt = makeTimeAt(surveillance.endHour, surveillance.endMin);
        surveillance.isActive = "True";
    }

    private String makeTimeAt(int i, int i2) {
        String str;
        if (i < 10) {
            str = "" + Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE + String.valueOf(i);
        } else {
            str = "" + String.valueOf(i);
        }
        if (i2 < 10) {
            return str + Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE + String.valueOf(i2);
        }
        return str + String.valueOf(i2);
    }

    private String makeWeekDays(Checker.Surveillance surveillance) {
        return (((((String.valueOf(surveillance.mon.booleanValue() ? 1 : 0) + (surveillance.tue.booleanValue() ? 1 : 0)) + (surveillance.wed.booleanValue() ? 1 : 0)) + (surveillance.thu.booleanValue() ? 1 : 0)) + (surveillance.fri.booleanValue() ? 1 : 0)) + (surveillance.sat.booleanValue() ? 1 : 0)) + (surveillance.sun.booleanValue() ? 1 : 0);
    }

    private void setDefault() {
        setTue(false);
        setWed(false);
        setThu(false);
        setFri(false);
        setSat(false);
        setSun(false);
    }

    public void setDaily() {
        setMon(true);
        setTue(true);
        setWed(true);
        setThu(true);
        setFri(true);
        setSat(true);
        setSun(true);
        this.view.setRepeater();
    }

    public void setWeekday() {
        setMon(true);
        setTue(true);
        setWed(true);
        setThu(true);
        setFri(true);
        setSat(false);
        setSun(false);
        this.view.setRepeater();
    }

    public void setWeekend() {
        setMon(false);
        setTue(false);
        setWed(false);
        setThu(false);
        setFri(false);
        setSat(true);
        setSun(true);
        this.view.setRepeater();
    }

    public void setRepeater(DayOfWeekRepeater dayOfWeekRepeater) {
        int status = dayOfWeekRepeater.getStatus();
        if (status == 1) {
            this.view.selectDaily();
            this.view.unSelectWeekday();
            this.view.unSelectWeekend();
        } else if (status == 2) {
            this.view.unSelectDaily();
            this.view.selectWeekday();
            this.view.unSelectWeekend();
        } else if (status == 3) {
            this.view.unSelectDaily();
            this.view.unSelectWeekday();
            this.view.selectWeekend();
        } else {
            this.view.unSelectDaily();
            this.view.unSelectWeekday();
            this.view.unSelectWeekend();
        }
    }

    public void onSaveButtonClicked(String str, Checker.Surveillance surveillance, int i, CheckerSurveillanceInfo checkerSurveillanceInfo) {
        if (checkerSurveillanceInfo.checkIsValidDaySet()) {
            this.view.showProgressbar();
            Checker.Surveillance surveillanceCreateNewSurveillance = new CheckerSurveillanceCreator().createNewSurveillance(checkerSurveillanceInfo, i + 1);
            if (surveillance == null) {
                if (checkEndtimeIsSame(surveillanceCreateNewSurveillance)) {
                    this.view.showSameTimeSettingError();
                    return;
                } else if (checkEndtimeIsBigger(surveillanceCreateNewSurveillance).booleanValue()) {
                    this.makeInteractor.requestPostSurveillance(str, surveillanceCreateNewSurveillance);
                    return;
                } else {
                    divideSurveillance(str, surveillanceCreateNewSurveillance);
                    return;
                }
            }
            surveillanceCreateNewSurveillance.id = surveillance.id;
            if (checkEndtimeIsSame(surveillanceCreateNewSurveillance)) {
                this.view.showSameTimeSettingError();
            } else if (checkEndtimeIsBigger(surveillanceCreateNewSurveillance).booleanValue()) {
                this.modifyInteractor.requestPutCheckersSurveillance(str, surveillanceCreateNewSurveillance);
            } else {
                this.view.showLogicalOrderError();
            }
        }
    }

    private void divideSurveillance(String str, Checker.Surveillance surveillance) {
        Checker.Surveillance surveillance2 = new Checker.Surveillance(surveillance.title, surveillance.trespass_duration_min, surveillance.alarm_duration_min, surveillance.level, surveillance.startHour, surveillance.startMin, surveillance.endHour, surveillance.endMin, surveillance.mon, surveillance.tue, surveillance.wed, surveillance.thu, surveillance.fri, surveillance.sat, surveillance.sun);
        Checker.Surveillance surveillance3 = new Checker.Surveillance(surveillance.title, surveillance.trespass_duration_min, surveillance.alarm_duration_min, surveillance.level, surveillance.startHour, surveillance.startMin, surveillance.endHour, surveillance.endMin, surveillance.mon, surveillance.tue, surveillance.wed, surveillance.thu, surveillance.fri, surveillance.sat, surveillance.sun);
        surveillance2.endHour = 23;
        surveillance2.endMin = 59;
        surveillance3.startHour = 0;
        surveillance3.startMin = 0;
        surveillance3.weekDays = surveillance.weekDays;
        setCheckerSurveillanceData(surveillance2);
        makeSecondSurveillanceWeekDays(surveillance3);
        setCheckerSurveillanceData(surveillance3);
        this.makeInteractor.requestPostSurveillance(str, surveillance2);
        this.makeInteractor.requestPostSurveillance(str, surveillance3);
    }

    public View.OnClickListener onClickRightArrowButtonClicked(final int i) {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.CheckerSurveillanceSettingPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheckerSurveillanceSettingPresenter.this.view.onClickRightArrowButtonClicked(i);
            }
        };
    }

    public View.OnClickListener onClickLeftArrowButtonClicked() {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.CheckerSurveillanceSettingPresenter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheckerSurveillanceSettingPresenter.this.view.onClickLeftArrowButtonClicked();
            }
        };
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

    public ViewPager.OnPageChangeListener onPageChangeListener() {
        return new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.setting.presenter.CheckerSurveillanceSettingPresenter.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CheckerSurveillanceSettingPresenter.this.selectItem(i);
            }
        };
    }

    public void selectItem(int i) {
        setArrowStatus(i);
        this.view.setProposeCurrentItem(i);
    }

    private void setArrowStatus(int i) {
        if (i == 0) {
            this.view.showRightArrowButton();
            this.view.hideLeftArrowButton();
        } else if (i == 1) {
            this.view.showLeftArrowButton();
            this.view.hideRightArrowButton();
        } else {
            this.view.showLeftArrowButton();
            this.view.showRightArrowButton();
        }
    }
}
