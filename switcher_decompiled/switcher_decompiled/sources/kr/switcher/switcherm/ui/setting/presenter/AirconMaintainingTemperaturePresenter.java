package kr.switcher.switcherm.ui.setting.presenter;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.helper.RemoconMaintenanceCreator;
import kr.switcher.switcherm.ui.setting.helper.RemoconMaintenanceInfo;
import kr.switcher.switcherm.ui.setting.interactor.DeleteMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.MakeMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.interactor.ModifyAirconMaintenanceInteractor;
import kr.switcher.switcherm.ui.setting.view.AirconMaintainingTemperatureView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperaturePresenter {
    private static final String TAG = "AirconMaintainingTemperaturePresenter";
    private DeleteMaintenanceInteractor deleteInteractor;
    private MakeMaintenanceInteractor makeInteractor;
    private ModifyAirconMaintenanceInteractor modifyInteractor;
    private AirconMaintainingTemperatureView view;
    private int MIN_TEMPERATURE = 19;
    private int MAX_TEMPERATURE = 30;

    public AirconMaintainingTemperaturePresenter(AirconMaintainingTemperatureView airconMaintainingTemperatureView, MakeMaintenanceInteractor makeMaintenanceInteractor, ModifyAirconMaintenanceInteractor modifyAirconMaintenanceInteractor, DeleteMaintenanceInteractor deleteMaintenanceInteractor) {
        this.view = airconMaintainingTemperatureView;
        this.makeInteractor = makeMaintenanceInteractor;
        this.modifyInteractor = modifyAirconMaintenanceInteractor;
        this.deleteInteractor = deleteMaintenanceInteractor;
    }

    public void onCreateView(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        this.view.initWheel();
        setDefault();
        if (remoconMaintenanceTemperature != null) {
            this.view.setTitle(remoconMaintenanceTemperature.title);
            this.view.setMaintenanceInfo(remoconMaintenanceTemperature);
            this.view.showRemoveButton();
        } else {
            this.view.showDefaultTemperature();
            this.view.setMaintenanceInfo(new RemoconMaintenanceCreator().getRemoconMaintenance());
            this.view.hideRemoveButton();
        }
    }

    public String onTemperatureUpButtonClicked(String str) {
        int i = Integer.parseInt(str);
        if (i == this.MAX_TEMPERATURE) {
            return String.valueOf(i);
        }
        return String.valueOf(i + 1);
    }

    public String onTemperatureDownButtonClicked(String str) {
        int i = Integer.parseInt(str);
        if (i == this.MIN_TEMPERATURE) {
            return String.valueOf(i);
        }
        return String.valueOf(i - 1);
    }

    public void onSaveRervationButtonClicked(String str, Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature, RemoconMaintenanceInfo remoconMaintenanceInfo) {
        if (remoconMaintenanceInfo.checkIsValidDaySet()) {
            this.view.showProgressbar();
            Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperatureCreateNewMaintenance = new RemoconMaintenanceCreator().createNewMaintenance(remoconMaintenanceInfo);
            this.view.setRemoconMaintenanceData(remoconMaintenanceTemperatureCreateNewMaintenance);
            if (remoconMaintenanceTemperature == null) {
                if (checkEndtimeIsSame(remoconMaintenanceTemperatureCreateNewMaintenance)) {
                    this.view.showSameTimeSettingError();
                    return;
                } else if (checkEndtimeIsBigger(remoconMaintenanceTemperatureCreateNewMaintenance).booleanValue()) {
                    this.makeInteractor.requestPostMaintenance(str, remoconMaintenanceTemperatureCreateNewMaintenance);
                    return;
                } else {
                    divideMaintenance(str, remoconMaintenanceTemperatureCreateNewMaintenance);
                    return;
                }
            }
            remoconMaintenanceTemperatureCreateNewMaintenance.id = remoconMaintenanceTemperature.id;
            remoconMaintenanceTemperatureCreateNewMaintenance.appliances = remoconMaintenanceTemperature.appliances;
            if (checkEndtimeIsSame(remoconMaintenanceTemperatureCreateNewMaintenance)) {
                this.view.showSameTimeSettingError();
            } else if (checkEndtimeIsBigger(remoconMaintenanceTemperatureCreateNewMaintenance).booleanValue()) {
                this.modifyInteractor.requestPutRemoconMaintenance(remoconMaintenanceTemperatureCreateNewMaintenance);
            } else {
                this.view.showLogicalOrderError();
            }
        }
    }

    private boolean checkEndtimeIsSame(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        return remoconMaintenanceTemperature.start_time_at.equals(remoconMaintenanceTemperature.end_time_at);
    }

    private Boolean checkEndtimeIsBigger(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        String str = remoconMaintenanceTemperature.start_time_at;
        String str2 = remoconMaintenanceTemperature.end_time_at;
        if (Integer.parseInt(str.substring(0, 2)) <= Integer.parseInt(str2.substring(0, 2))) {
            return true;
        }
        return false;
    }

    private void divideMaintenance(String str, Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature2 = new Remocon.RemoconMaintenanceTemperature(remoconMaintenanceTemperature.title, remoconMaintenanceTemperature.mon, remoconMaintenanceTemperature.tue, remoconMaintenanceTemperature.wed, remoconMaintenanceTemperature.thu, remoconMaintenanceTemperature.fri, remoconMaintenanceTemperature.sat, remoconMaintenanceTemperature.sun, remoconMaintenanceTemperature.goal_temperature, remoconMaintenanceTemperature.startHour, remoconMaintenanceTemperature.endHour, remoconMaintenanceTemperature.startMin, remoconMaintenanceTemperature.endMin);
        Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature3 = new Remocon.RemoconMaintenanceTemperature(remoconMaintenanceTemperature.title, remoconMaintenanceTemperature.mon, remoconMaintenanceTemperature.tue, remoconMaintenanceTemperature.wed, remoconMaintenanceTemperature.thu, remoconMaintenanceTemperature.fri, remoconMaintenanceTemperature.sat, remoconMaintenanceTemperature.sun, remoconMaintenanceTemperature.goal_temperature, remoconMaintenanceTemperature.startHour, remoconMaintenanceTemperature.endHour, remoconMaintenanceTemperature.startMin, remoconMaintenanceTemperature.endMin);
        remoconMaintenanceTemperature2.endHour = 23;
        remoconMaintenanceTemperature2.endMin = 59;
        remoconMaintenanceTemperature3.startHour = 0;
        remoconMaintenanceTemperature3.startMin = 0;
        remoconMaintenanceTemperature3.weekdays = remoconMaintenanceTemperature.weekdays;
        setRemoconMaintenanceData(remoconMaintenanceTemperature2);
        makeSecondMaintenanceWeekDays(remoconMaintenanceTemperature3);
        setRemoconMaintenanceData(remoconMaintenanceTemperature3);
        this.makeInteractor.requestPostMaintenance(str, remoconMaintenanceTemperature2);
        this.makeInteractor.requestPostMaintenance(str, remoconMaintenanceTemperature3);
    }

    private void makeSecondMaintenanceWeekDays(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        remoconMaintenanceTemperature.mon = false;
        remoconMaintenanceTemperature.tue = false;
        remoconMaintenanceTemperature.wed = false;
        remoconMaintenanceTemperature.thu = false;
        remoconMaintenanceTemperature.fri = false;
        remoconMaintenanceTemperature.sat = false;
        remoconMaintenanceTemperature.sun = false;
        if (remoconMaintenanceTemperature.weekdays.charAt(0) == '1') {
            remoconMaintenanceTemperature.tue = true;
        }
        if (remoconMaintenanceTemperature.weekdays.charAt(1) == '1') {
            remoconMaintenanceTemperature.wed = true;
        }
        if (remoconMaintenanceTemperature.weekdays.charAt(2) == '1') {
            remoconMaintenanceTemperature.thu = true;
        }
        if (remoconMaintenanceTemperature.weekdays.charAt(3) == '1') {
            remoconMaintenanceTemperature.fri = true;
        }
        if (remoconMaintenanceTemperature.weekdays.charAt(4) == '1') {
            remoconMaintenanceTemperature.sat = true;
        }
        if (remoconMaintenanceTemperature.weekdays.charAt(5) == '1') {
            remoconMaintenanceTemperature.sun = true;
        }
        if (remoconMaintenanceTemperature.weekdays.charAt(6) == '1') {
            remoconMaintenanceTemperature.mon = true;
        }
    }

    public void onRemoveButtonClicked(int i) {
        this.deleteInteractor.requestDeleteMaintenance(String.valueOf(i));
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

    public void setRemoconMaintenanceData(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        remoconMaintenanceTemperature.weekdays = makeWeekDays(remoconMaintenanceTemperature);
        remoconMaintenanceTemperature.start_time_at = makeTimeAt(remoconMaintenanceTemperature.startHour, remoconMaintenanceTemperature.startMin);
        remoconMaintenanceTemperature.end_time_at = makeTimeAt(remoconMaintenanceTemperature.endHour, remoconMaintenanceTemperature.endMin);
        remoconMaintenanceTemperature.is_enabled = true;
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

    private String makeWeekDays(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        return (((((String.valueOf(remoconMaintenanceTemperature.mon ? 1 : 0) + (remoconMaintenanceTemperature.tue ? 1 : 0)) + (remoconMaintenanceTemperature.wed ? 1 : 0)) + (remoconMaintenanceTemperature.thu ? 1 : 0)) + (remoconMaintenanceTemperature.fri ? 1 : 0)) + (remoconMaintenanceTemperature.sat ? 1 : 0)) + (remoconMaintenanceTemperature.sun ? 1 : 0);
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
}
