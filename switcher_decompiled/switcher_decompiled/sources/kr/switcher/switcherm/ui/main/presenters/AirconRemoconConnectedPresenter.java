package kr.switcher.switcherm.ui.main.presenters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.AirconMaintenanceBadgePreference;
import kr.switcher.switcherm.preference.AirconReservationBadgePreference;
import kr.switcher.switcherm.preference.AirconWidgetBadgePreference;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor;
import kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconRemoconConnectedPresenter {
    private FindAirconIRCommandInteractor interactor;
    private AirconRemoconConnectedView view;

    public AirconRemoconConnectedPresenter(AirconRemoconConnectedView airconRemoconConnectedView, FindAirconIRCommandInteractor findAirconIRCommandInteractor) {
        this.view = airconRemoconConnectedView;
        this.interactor = findAirconIRCommandInteractor;
    }

    public void changeClickedButtomcolor(String str) {
        changeBottonColor(str);
    }

    public void onCreateView() {
        this.view.hideProgressbar();
        this.view.initButton();
        this.view.initRecyclerListView();
        this.view.initWheel();
    }

    public void onResume(Remocon remocon) {
        this.view.onMainData(remocon.getMacAddress(), IODevice.ProductId.REMOCON, remocon.getName(), "", remocon.getProductId().equals(IODevice.ProductId.REMOCON) ? MainActivity.MainBackgroundState.CONNECTED_REMOCON_AIRCON : MainActivity.MainBackgroundState.DISCONNECTED);
        this.interactor.findAirconIRCommand(remocon);
        if (new AirconReservationBadgePreference().getReservationBadge()) {
            this.view.showReservationBadge();
        } else {
            this.view.hideReservationBadge();
        }
        if (new AirconMaintenanceBadgePreference().getMaintenanceBadge()) {
            this.view.showMaintenanceBadge();
        } else {
            this.view.hideMaintenanceBadge();
        }
        if (new AirconWidgetBadgePreference().getWidgetBadge()) {
            this.view.showWidgetBadge();
        } else {
            this.view.hideWidgetBadge();
        }
    }

    public void changeBottonColor(String str) {
        str.hashCode();
        switch (str) {
            case "AIR_VOLUME":
                this.view.setAirVolumeButtonClicked();
                break;
            case "ETC":
                this.view.setETCButtonClicked();
                break;
            case "MODE":
                this.view.setModeButtonClicked();
                break;
            case "CUSTOM":
                this.view.setCustomButtonClicked();
                break;
        }
    }

    public void onFind(List<IRCommand> list, String str) {
        this.view.initCommandList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (IRCommand iRCommand : list) {
            if (iRCommand.getName().equals("ON")) {
                this.view.setAirconOnCommand(iRCommand);
            } else if (iRCommand.getName().equals(IOConfig.OFF)) {
                this.view.setAirconOffCommand(iRCommand);
            } else if (iRCommand.getName().equals("약풍") || iRCommand.getName().equals("강풍")) {
                arrayList2.add(iRCommand);
            } else if (iRCommand.getName().equals("냉방") || iRCommand.getName().equals("제습") || iRCommand.getName().equals("송풍")) {
                arrayList.add(iRCommand);
            } else if (iRCommand.getName().equals("회전")) {
                arrayList3.add(iRCommand);
            } else if (iRCommand.getName().equals("19") || iRCommand.getName().equals("20") || iRCommand.getName().equals("21") || iRCommand.getName().equals("22") || iRCommand.getName().equals("23") || iRCommand.getName().equals("24") || iRCommand.getName().equals("25") || iRCommand.getName().equals("26") || iRCommand.getName().equals("27") || iRCommand.getName().equals("28") || iRCommand.getName().equals("29") || iRCommand.getName().equals("30")) {
                arrayList5.add(iRCommand);
            } else {
                arrayList4.add(iRCommand);
            }
        }
        arrayList4.add(new IRCommand(null, "버튼 추가"));
        this.view.setCommandList(arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
        if (str == null) {
            return;
        }
        if (str.equals("CUSTOM")) {
            this.view.setRemoconCommandItems(arrayList4);
            return;
        }
        if (str.equals("MODE")) {
            this.view.setRemoconCommandItems(arrayList);
        } else if (str.equals("AIR_VOLUME")) {
            this.view.setRemoconCommandItems(arrayList2);
        } else if (str.equals("ETC")) {
            this.view.setRemoconCommandItems(arrayList3);
        }
    }

    public void onAirconONButtonClicked(IRCommand iRCommand) {
        this.view.showProgressbar(1000);
        if (iRCommand != null) {
            this.interactor.releaseIR(iRCommand);
        } else {
            IOUtil.showToast("저장된 명령어가 없습니다. 곧 추가될 예정입니다 :)");
        }
    }

    public void onAirconOFFButtonClicked(IRCommand iRCommand) {
        this.view.showProgressbar(1000);
        if (iRCommand != null) {
            this.interactor.releaseIR(iRCommand);
        } else {
            IOUtil.showToast("저장된 명령어가 없습니다. 곧 추가될 예정입니다 :)");
        }
    }

    public void commandCategoryButtonClicked(String str, List<IRCommand> list) {
        changeClickedButtomcolor(str);
        this.view.setRemoconCommandItems(list);
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
        this.interactor.findAirconIRCommand(remocon);
    }

    public void onScrollingFinished(int i) {
        this.view.showProgressbar(1000);
        if (i == 0) {
            return;
        }
        IRCommand iRCommand = null;
        Iterator<IRCommand> it = this.view.getAirconTemperatureCommandList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IRCommand next = it.next();
            if (next.getName().equals(this.view.getCurrentTemperature(i))) {
                iRCommand = next;
                break;
            }
        }
        if (iRCommand != null) {
            this.interactor.releaseIR(iRCommand);
        } else {
            IOUtil.showToast("저장된 명령어가 없습니다. 곧 추가 될 예정입니다 :)");
        }
    }

    public void onReservationButtonClicked() {
        if (new AirconReservationBadgePreference().getReservationBadge()) {
            new AirconReservationBadgePreference().setReservationBadge(false);
        }
    }

    public void onHoldTemperatureButtonClicked() {
        if (new AirconMaintenanceBadgePreference().getMaintenanceBadge()) {
            new AirconMaintenanceBadgePreference().setMaintenanceBadge(false);
        }
    }

    public void onWidgetButtonClicked() {
        if (new AirconWidgetBadgePreference().getWidgetBadge()) {
            new AirconWidgetBadgePreference().setWidgetBadge(false);
        }
    }
}
