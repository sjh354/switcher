package kr.switcher.switcherm.ui.main.presenters;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.adapter.CommandItem;
import kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor;
import kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedRemoconPresenter {
    private FindIRCommandInteractor interactor;
    private MainConnectedRemoconView view;

    public MainConnectedRemoconPresenter(MainConnectedRemoconView mainConnectedRemoconView, FindIRCommandInteractor findIRCommandInteractor) {
        this.view = mainConnectedRemoconView;
        this.interactor = findIRCommandInteractor;
    }

    public void onAddCommandButtonClicked() {
        this.view.moveIRCommandRegisterScreen();
    }

    public void onResume(Remocon remocon) {
        this.view.initRecyclerListView();
        this.view.onMainData(remocon.getMacAddress(), IODevice.ProductId.REMOCON, remocon.getName(), "", remocon.getControllerId().equals(Remocon.ControllerID.REMOCON) ? MainActivity.MainBackgroundState.CONNECTED_MANUAL_REMOCON : MainActivity.MainBackgroundState.CONNECTED_LINKER_THING);
        this.interactor.findIRCommand(remocon);
    }

    public void onItemClick(CommandItem commandItem) {
        this.view.showProgressbar();
        this.interactor.releaseIR(commandItem);
    }

    public void onItemLongClick(int i) {
        this.view.showInfoDialog(i);
    }

    public void onSelection(CommandItem commandItem) {
        this.interactor.removeIR(commandItem.getId());
    }

    public void onFind(List<IRCommand> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new CommandItem(list.get(i).getId(), list.get(i).getName()));
        }
        this.view.setCommandItems(arrayList);
    }

    public void onRelease(boolean z) {
        if (z) {
            return;
        }
        this.view.showMessage("명령을 실패하였습니다");
    }

    public void onRemove(boolean z, String str) {
        if (!z) {
            this.view.showMessage("명령을 삭제하지 못했습니다");
        } else {
            this.view.removeItem(str);
        }
    }
}
