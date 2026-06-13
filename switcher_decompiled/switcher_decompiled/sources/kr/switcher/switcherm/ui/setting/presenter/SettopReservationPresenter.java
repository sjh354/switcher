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
import kr.switcher.switcherm.ui.setting.view.SettopReservationView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopReservationPresenter {
    private final String TAG = "SettopReservationPresenter";
    private String applianceId;
    private FindAirconCommandListInteractor commandInteractor;
    private String connectedRemoconMacAddress;
    private DeleteReservationInteractor deleteReservationInteractor;
    private List<IRCommand> irCommandList;
    private SendReservationToServerInteractor sendResrvInteractor;
    private SettopReservationView view;

    public SettopReservationPresenter(SettopReservationView settopReservationView, FindAirconCommandListInteractor findAirconCommandListInteractor, SendReservationToServerInteractor sendReservationToServerInteractor, DeleteReservationInteractor deleteReservationInteractor) {
        this.view = settopReservationView;
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
            if (!remoconReservation.tag.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                this.view.setCannelNumber(remoconReservation.tag);
            }
            this.view.showRemoveButton();
            return;
        }
        this.view.setTimerInfo(new RemoconReservationCreator().getRemoconReservation());
        this.view.hideRemoveButton();
    }

    public void setSwitch(String str) {
        if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            this.view.setBackgroundTimerOffWhenIsOff();
            this.view.setBackgroundTimerOnWhenIsOff();
            this.view.setColorTimerOffTextWhenIsOff();
            this.view.setColorTimerOnTextWhenIsOff();
            this.view.setInactiveChannelField();
            return;
        }
        this.view.setBackgroundTimerOffWhenIsOn();
        this.view.setBackgroundTimerOnWhenIsOn();
        this.view.setColorTimerOffTextWhenIsOn();
        this.view.setColorTimerOnTextWhenIsOn();
        this.view.setActiveChannelField();
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
        if (remoconReservation.tag.equals("none")) {
            return;
        }
        for (int i = 0; i < remoconReservation.tag.length(); i++) {
            for (IRCommand iRCommand3 : this.irCommandList) {
                if (iRCommand3.getName().equals(String.valueOf(remoconReservation.tag.charAt(i)))) {
                    remoconReservation.irIdList.add(iRCommand3.getId());
                }
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
