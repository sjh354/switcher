package kr.switcher.switcherm.ui.setting.presenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.setting.helper.RemoconReservationCreator;
import kr.switcher.switcherm.ui.setting.helper.RemoconReservationInfo;
import kr.switcher.switcherm.ui.setting.interactor.DeleteReservationInteractor;
import kr.switcher.switcherm.ui.setting.interactor.FindAirconCommandListInteractor;
import kr.switcher.switcherm.ui.setting.interactor.SendReservationToServerInteractor;
import kr.switcher.switcherm.ui.setting.view.AirconReservationView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconReservationPresenter {
    private static final int MAX_TEMPERATRUE = 30;
    private static final int MIN_TEMPERATRUE = 19;
    private final String TAG = "AirconReservationPresenter";
    private String applianceId;
    private FindAirconCommandListInteractor commandInteractor;
    private String connectedRemoconMacAddress;
    private DeleteReservationInteractor deleteReservationInteractor;
    private List<IRCommand> irCommandList;
    private SendReservationToServerInteractor sendResrvInteractor;
    private AirconReservationView view;

    public AirconReservationPresenter(AirconReservationView airconReservationView, FindAirconCommandListInteractor findAirconCommandListInteractor, SendReservationToServerInteractor sendReservationToServerInteractor, DeleteReservationInteractor deleteReservationInteractor) {
        this.view = airconReservationView;
        this.commandInteractor = findAirconCommandListInteractor;
        this.sendResrvInteractor = sendReservationToServerInteractor;
        this.deleteReservationInteractor = deleteReservationInteractor;
    }

    public void initialize(Remocon remocon, Remocon.RemoconReservation remoconReservation) {
        this.connectedRemoconMacAddress = remocon.getMacAddress();
        this.applianceId = remocon.getId();
        this.view.hideProgressbar();
        setDefault();
        this.view.initWheel();
        this.commandInteractor.requestGetAirconCommandList(this.applianceId);
        if (remoconReservation != null) {
            this.view.setTitle(remoconReservation.title);
            this.view.setTimerInfo(remoconReservation);
            this.view.showRemoveButton();
        } else {
            this.view.setTimerInfo(new RemoconReservationCreator().getRemoconReservation());
            this.view.hideRemoveButton();
        }
    }

    public void setSwitch(String str) {
        if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            this.view.setTemperatureWhenIsOff();
            this.view.setBackgroundTimerOffWhenIsOff();
            this.view.setBackgroundTimerOnWhenIsOff();
            this.view.setColorTimerOffTextWhenIsOff();
            this.view.setColorTimerOnTextWhenIsOff();
            this.view.setActiveTemperatureUpWhenIsOff();
            return;
        }
        this.view.setTemperatureWhenIsOn(str);
        this.view.setBackgroundTimerOffWhenIsOn();
        this.view.setBackgroundTimerOnWhenIsOn();
        this.view.setColorTimerOffTextWhenIsOn();
        this.view.setColorTimerOnTextWhenIsOn();
        this.view.setActiveTemperatureUpWhenIsOn();
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

    public void setDefault() {
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

    public String onTemperatureUpButtonClicked(String str) {
        int i = Integer.parseInt(str);
        if (i >= 30) {
            return String.valueOf(30);
        }
        if (i < 30) {
            i++;
            this.view.setTemperature(i);
        }
        return String.valueOf(i);
    }

    public String onTemperatureDownButtonClicked(String str) {
        int i = Integer.parseInt(str);
        if (i <= 19) {
            return String.valueOf(19);
        }
        if (i > 19) {
            i--;
            this.view.setTemperature(i);
        }
        return String.valueOf(i);
    }

    public void onSaveRervationButtonClicked(Remocon.RemoconReservation remoconReservation, RemoconReservationInfo remoconReservationInfo) {
        if (remoconReservationInfo.checkIsValidDaySet()) {
            Linker linker = LinkerHandler.getInstance().getAliveLinkers().size() > 0 ? LinkerHandler.getInstance().getAliveLinkers().get(0) : null;
            this.view.showProgressbar();
            Remocon.RemoconReservation remoconReservationCreateNewReservation = new RemoconReservationCreator().createNewReservation(remoconReservationInfo);
            this.view.setRemoconReservationData(remoconReservationCreateNewReservation);
            if (remoconReservation == null) {
                this.sendResrvInteractor.requestPostToServer(linker.getMacAddress(), this.applianceId, remoconReservationCreateNewReservation);
            } else if (remoconReservation != null) {
                this.deleteReservationInteractor.requestChangeReservationData(remoconReservationCreateNewReservation, IOUtil.makeBackendMacAddressFormat(linker.getMacAddress()), remoconReservation.weekTime);
            }
        }
    }

    public void setRemoconReservationData(Remocon.RemoconReservation remoconReservation) {
        remoconReservation.weekTime = makeWeekTime(remoconReservation);
        remoconReservation.time = remoconReservation.weekTime.substring(7);
        remoconReservation.isEnabled = "true";
        if (remoconReservation.tag.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            for (IRCommand iRCommand : this.irCommandList) {
                if (iRCommand.getName().equals(IOConfig.OFF)) {
                    remoconReservation.irIdList.add(iRCommand.getId());
                }
            }
            return;
        }
        for (IRCommand iRCommand2 : this.irCommandList) {
            if (iRCommand2.getName().equals("ON")) {
                remoconReservation.irIdList.add(iRCommand2.getId());
            }
        }
        for (IRCommand iRCommand3 : this.irCommandList) {
            if (iRCommand3.getName().equals(remoconReservation.tag)) {
                remoconReservation.irIdList.add(iRCommand3.getId());
            }
        }
    }

    private String makeWeekTime(Remocon.RemoconReservation remoconReservation) {
        String str;
        String str2 = (((((String.valueOf(remoconReservation.mon ? 1 : 0) + (remoconReservation.tue ? 1 : 0)) + (remoconReservation.wed ? 1 : 0)) + (remoconReservation.thu ? 1 : 0)) + (remoconReservation.fri ? 1 : 0)) + (remoconReservation.sat ? 1 : 0)) + (remoconReservation.sun ? 1 : 0);
        if (remoconReservation.hour < 10) {
            str = str2 + Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE + String.valueOf(remoconReservation.hour);
        } else {
            str = str2 + String.valueOf(remoconReservation.hour);
        }
        if (remoconReservation.min < 10) {
            return str + Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE + String.valueOf(remoconReservation.min);
        }
        return str + String.valueOf(remoconReservation.min);
    }

    public void onFindRemoconReservation(List<IRCommand> list) {
        this.irCommandList = new ArrayList();
        Iterator<IRCommand> it = list.iterator();
        while (it.hasNext()) {
            this.irCommandList.add(it.next());
        }
    }

    public void onRemoveButtonClicked(String str) {
        if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
            this.deleteReservationInteractor.requestDeleteReservation(IOUtil.makeBackendMacAddressFormat(LinkerHandler.getInstance().getAliveLinkers().get(0).getMacAddress()), str);
        }
    }

    public void onDeleteReservationSuccess() {
        IOUtil.showToast("예약 삭제가 완료되었습니다.");
        this.view.backButtonClicked();
    }

    public void onChangeReservationDataSuccess(Remocon.RemoconReservation remoconReservation, String str, String str2) {
        this.sendResrvInteractor.requestPostToServer(str2, str, remoconReservation);
    }
}
