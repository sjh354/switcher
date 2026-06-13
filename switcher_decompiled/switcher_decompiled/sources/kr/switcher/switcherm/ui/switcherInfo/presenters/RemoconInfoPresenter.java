package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IODeviceIconMaker;
import kr.switcher.switcherm.ui.switcherInfo.interactors.DeleteRemoconInteractor;
import kr.switcher.switcherm.ui.switcherInfo.views.RemoconInfoView;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconInfoPresenter {
    private DeleteRemoconInteractor interactor;
    private RemoconInfoView view;

    public RemoconInfoPresenter(RemoconInfoView remoconInfoView, DeleteRemoconInteractor deleteRemoconInteractor) {
        this.view = remoconInfoView;
        this.interactor = deleteRemoconInteractor;
    }

    public void onCreateView(Remocon remocon) {
        this.view.setRemoconType("'" + getRemoconType(remocon.getControllerId()) + "'");
        this.view.setRemoconName(remocon.getName());
        this.view.setRemoconIcon(IODeviceIconMaker.makeInfoIcon(remocon.getProductId(), remocon.getMacAddress()));
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.switcherInfo.presenters.RemoconInfoPresenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID;

        static {
            int[] iArr = new int[Remocon.ControllerID.values().length];
            $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID = iArr;
            try {
                iArr[Remocon.ControllerID.AIRCON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.TV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.SET_TOP_BOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.REMOCON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private String getRemoconType(Remocon.ControllerID controllerID) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[controllerID.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "-" : "리모컨" : "셋톱박스" : "TV" : "에어컨";
    }

    public void onDeleteButtonCliecked(Remocon remocon) {
        this.interactor.deleteRemocon(remocon);
    }

    public void onError() {
        this.view.showErrorMessage("서버 통신이 실패하였습니다. 다시 시도해주세요");
    }
}
