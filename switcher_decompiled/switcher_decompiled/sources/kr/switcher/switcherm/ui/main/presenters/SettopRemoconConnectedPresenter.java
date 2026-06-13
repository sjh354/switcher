package kr.switcher.switcherm.ui.main.presenters;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.RestErrorCode;
import kr.switcher.switcherm.preference.SettopBadgePreference;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor;
import kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopRemoconConnectedPresenter {
    public static final String BUTTON_CANCEL = "나가기";
    public static final String BUTTON_CHANNEL = "채널입력";
    public static final String BUTTON_CHANNEL_DOWN = "채널DOWN";
    public static final String BUTTON_CHANNEL_UP = "채널UP";
    public static final String BUTTON_CONFIRM = "확인";
    public static final String BUTTON_DOWN = "DOWN";
    public static final String BUTTON_LEFT = "LEFT";
    public static final String BUTTON_POWER = "ON";
    public static final String BUTTON_PREVIOUS = "이전";
    public static final String BUTTON_RIGHT = "RIGHT";
    public static final String BUTTON_TIMETABLE = "편성표";
    public static final String BUTTON_UP = "UP";
    public static final String BUTTON_VOLUME_DOWN = "볼륨DOWN";
    public static final String BUTTON_VOLUME_UP = "볼륨UP";
    private static String POWER = "ON";
    private static final String TAG = "SettopRemoconConnectedPresenter";
    private FindIRCommandInteractor interactor;
    private SettopRemoconConnectedView view;
    private List<IRCommand> allOfIRCommandList = new ArrayList();
    private List<IRCommand> numberIRCommandList = new ArrayList();
    private int countCHRelease = 0;

    public SettopRemoconConnectedPresenter(SettopRemoconConnectedView settopRemoconConnectedView, FindIRCommandInteractor findIRCommandInteractor) {
        this.view = settopRemoconConnectedView;
        this.interactor = findIRCommandInteractor;
    }

    public void onCreateView() {
        this.view.hideProgressbar();
        this.view.initRecyclerListView();
    }

    public void onResume(Remocon remocon) {
        this.view.onMainData(remocon.getMacAddress(), IODevice.ProductId.REMOCON, remocon.getName(), "", remocon.getProductId().equals(IODevice.ProductId.REMOCON) ? MainActivity.MainBackgroundState.CONNECTED_REMOCON_SETTOP : MainActivity.MainBackgroundState.DISCONNECTED);
        this.interactor.findIRCommand(remocon);
        if (new SettopBadgePreference().getReservationBadge()) {
            this.view.showReservationBadge();
        } else {
            this.view.hideReservationBadge();
        }
        if (new SettopBadgePreference().getWidgetBadge()) {
            this.view.showWidgetBadge();
        } else {
            this.view.hideWidgetBadge();
        }
    }

    public void onItemClick(IRCommand iRCommand) {
        if (iRCommand.getName().equals("버튼 추가")) {
            this.view.moveIRCommandRegisterScreen();
        } else {
            this.view.showProgressbar(1000);
            this.interactor.releaseIR(iRCommand);
        }
    }

    public void onItemLongClick(int i) {
        if (this.view.getCommandName(i).equals("버튼 추가")) {
            IOUtil.showToast("해당 버튼은 삭제하실 수 없습니다.");
        } else {
            this.view.showInfoDialog(i);
        }
    }

    public void onSelection(IRCommand iRCommand) {
        this.interactor.removeIR(iRCommand.getId());
    }

    public void onRemove(Remocon remocon) {
        this.interactor.findIRCommand(remocon);
    }

    public void onReservationButtonClicked() {
        if (new SettopBadgePreference().getReservationBadge()) {
            new SettopBadgePreference().setReservationBadge(false);
        }
    }

    public void onWidgetButtonClicked() {
        if (new SettopBadgePreference().getWidgetBadge()) {
            new SettopBadgePreference().setWidgetBadge(false);
        }
    }

    public void onFind(List<IRCommand> list) {
        this.allOfIRCommandList.addAll(list);
        this.view.initCommandList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (IRCommand iRCommand : list) {
            if (iRCommand.getName().equals("ON") || iRCommand.getName().equals(IOConfig.OFF) || iRCommand.getName().equals(BUTTON_VOLUME_UP) || iRCommand.getName().equals(BUTTON_VOLUME_DOWN) || iRCommand.getName().equals(BUTTON_CHANNEL_UP) || iRCommand.getName().equals(BUTTON_CHANNEL_DOWN) || iRCommand.getName().equals(BUTTON_TIMETABLE) || iRCommand.getName().equals(BUTTON_PREVIOUS) || iRCommand.getName().equals(BUTTON_CANCEL) || iRCommand.getName().equals(BUTTON_UP) || iRCommand.getName().equals(BUTTON_DOWN) || iRCommand.getName().equals(BUTTON_LEFT) || iRCommand.getName().equals(BUTTON_RIGHT) || iRCommand.getName().equals(BUTTON_CONFIRM) || iRCommand.getName().equals("음소거")) {
                arrayList.add(iRCommand);
            } else if (iRCommand.getName().equals(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE) || iRCommand.getName().equals("1") || iRCommand.getName().equals(RestErrorCode.PHONE_NUMBER_IS_WRONG) || iRCommand.getName().equals(RestErrorCode.CUSTOMER_DOES_NOT_EXIST) || iRCommand.getName().equals(RestErrorCode.AUTHNUMBER_IS_WRONG) || iRCommand.getName().equals(RestErrorCode.ACCESS_TOKEN_IS_EMPTY) || iRCommand.getName().equals(RestErrorCode.ACCESSTOKEN_DOES_NOT_EXIST) || iRCommand.getName().equals(RestErrorCode.ACCESSTOKEN_IS_NOT_MATCHED) || iRCommand.getName().equals(RestErrorCode.MACADDRESS_IS_EMPTY) || iRCommand.getName().equals(RestErrorCode.MACADDRESS_DOES_NOT_EXIST)) {
                arrayList3.add(iRCommand);
            } else {
                arrayList2.add(iRCommand);
            }
        }
        arrayList2.add(new IRCommand(null, "버튼 추가"));
        this.view.setCommandList(arrayList, arrayList2, arrayList3);
        this.view.setRemoconCommandItems(arrayList2);
        this.numberIRCommandList = arrayList3;
    }

    public void showProgressbar(int i) {
        this.view.showProgressbar(i);
    }

    public void onUpButtonClicked() {
        this.view.onReleaseIR(BUTTON_UP);
    }

    public void onDownButtonClicked() {
        this.view.onReleaseIR(BUTTON_DOWN);
    }

    public void onLeftButtonClicked() {
        this.view.onReleaseIR(BUTTON_LEFT);
    }

    public void onRightButtonClicked() {
        this.view.onReleaseIR(BUTTON_RIGHT);
    }

    public void onConfirmButtonClicked() {
        this.view.onReleaseIR(BUTTON_CONFIRM);
    }

    public void onPreviousButtonClicked() {
        this.view.onReleaseIR(BUTTON_PREVIOUS);
    }

    public void onCancelButtonClicked() {
        this.view.onReleaseIR(BUTTON_CANCEL);
    }

    public void onTimeTableButtonClicked() {
        this.view.onReleaseIR(BUTTON_TIMETABLE);
    }

    public void onPowerButtonClicked() {
        this.view.onReleaseIR("ON");
    }

    public void onChannelButtonClicked() {
        if (this.numberIRCommandList.size() == 10) {
            this.view.showChannelDialog();
        } else {
            IOUtil.showToast(R.string.notice_server_does_not_have_command);
        }
    }

    public void onVolumeUpButtonTouched(int i) {
        if (i == 0) {
            this.view.showVolumeUpButtonPressed();
            this.view.showVolumeDownButtonSpring();
        } else {
            if (i != 1) {
                return;
            }
            this.view.showVolumeUpButtonDefault();
            this.view.showVolumeDownButtonDefault();
            this.view.onReleaseIR(BUTTON_VOLUME_UP);
        }
    }

    public void onVolumeDownButtonTouched(int i) {
        if (i == 0) {
            this.view.showVolumeDwonButtonPressed();
            this.view.showVolumeUpButtonSpring();
        } else {
            if (i != 1) {
                return;
            }
            this.view.showVolumeDownButtonDefault();
            this.view.showVolumeUpButtonDefault();
            this.view.onReleaseIR(BUTTON_VOLUME_DOWN);
        }
    }

    public void onChannelUpButtonTouched(int i) {
        if (i == 0) {
            this.view.showChannelUpButtonPressed();
            this.view.showChannelDownButtonSpring();
        } else {
            if (i != 1) {
                return;
            }
            this.view.showChannelUpButtonDefault();
            this.view.showChannelDownButtonDefault();
            this.view.onReleaseIR(BUTTON_CHANNEL_UP);
        }
    }

    public void onChannelDownButtonTouched(int i) {
        if (i == 0) {
            this.view.showChannelDownButtonPressed();
            this.view.showChannelUpButtonSpring();
        } else {
            if (i != 1) {
                return;
            }
            this.view.showChannelUpButtonDefault();
            this.view.showChannelDownButtonDefault();
            this.view.onReleaseIR(BUTTON_CHANNEL_DOWN);
        }
    }

    public void onReleaseIR(String str) {
        IRCommand iRCommandFindIRCommand = findIRCommand(str);
        if (iRCommandFindIRCommand.getName().equals("none")) {
            IOUtil.showToast(R.string.notice_server_does_not_have_command);
        } else {
            this.interactor.releaseIR(iRCommandFindIRCommand);
        }
    }

    public IRCommand findIRCommand(String str) {
        if (str.equals("ON")) {
            for (IRCommand iRCommand : this.allOfIRCommandList) {
                if (iRCommand.getName().equals("ON")) {
                    return iRCommand;
                }
            }
        } else {
            for (IRCommand iRCommand2 : this.allOfIRCommandList) {
                if (iRCommand2.getName().equals(str)) {
                    return iRCommand2;
                }
            }
        }
        return new IRCommand(null, "none");
    }

    public void onChannelIRRelease(String str) {
        if (this.countCHRelease < str.length()) {
            this.interactor.releaseCHIR(findIRCommand(String.valueOf(str.charAt(this.countCHRelease))), str);
            this.countCHRelease++;
        } else {
            this.countCHRelease = 0;
            IOUtil.showToast(str + "번 명령어 전송 완료");
        }
    }
}
