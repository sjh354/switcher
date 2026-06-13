package kr.switcher.switcherm.ui.switcherInfo.presenters;

import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.common.util.IODeviceIconMaker;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.dialog.ConfirmCallback;
import kr.switcher.switcherm.ui.switcherInfo.helper.SwitcherInfoHelper;
import kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor;
import kr.switcher.switcherm.ui.switcherInfo.views.WholesaleView;

/* JADX INFO: loaded from: classes2.dex */
public class WholesalePresenter implements ConfirmCallback, FindSwitcherInfoInteractor.OnGetSwitcherInfoListener, FindSwitcherInfoInteractor.OnInitializeResultListener, FindSwitcherInfoInteractor.OnFoundMainSwitcherListener {
    private SwitcherInfoHelper helper = new SwitcherInfoHelper();
    private FindSwitcherInfoInteractor interactor;
    private WholesaleView view;

    public WholesalePresenter(WholesaleView wholesaleView, FindSwitcherInfoInteractor findSwitcherInfoInteractor) {
        this.view = wholesaleView;
        this.interactor = findSwitcherInfoInteractor;
    }

    public void initialize(IODevice iODevice) {
        viewData(iODevice);
        this.view.setInitButton(iODevice);
    }

    @Override // kr.switcher.switcherm.ui.dialog.ConfirmCallback
    public void onConfirmResult(boolean z) {
        if (z) {
            this.interactor.requestInitializeSwitcher(this);
            this.view.showProgressbar();
        }
    }

    public void setSwitcherInfo() {
        this.interactor.requestSwitcherDetails(this);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.OnGetSwitcherInfoListener
    public void onGetSwitcherInfoResult(IODevice iODevice, String str, String str2, String str3, String str4, String str5) {
        try {
            Switcher switcher = (Switcher) iODevice;
            if (switcher.getOwner() == null) {
                terminateMainSwitcher();
                if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
                    switcher.disconnect();
                    this.view.moveSwitcherListScreen();
                    return;
                } else {
                    this.view.finish();
                    return;
                }
            }
            viewData(switcher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void terminateMainSwitcher() {
        this.interactor.findMainSwitcher(this);
    }

    public void viewData(IODevice iODevice) {
        this.view.hideProgressbar();
        this.view.setSwitcherImage(IODeviceIconMaker.makeInfoIcon(iODevice.getProductId(), iODevice.getMacAddress()));
        this.view.setSwitcherType("'" + DeviceUtil.getDefaultDeviceName(iODevice) + "'");
        this.view.setRoomName(iODevice.getName());
        this.view.setOwnerName(iODevice.getOwner());
        this.view.setPKey(iODevice.getSerialNumber());
        if (iODevice.isMine()) {
            this.view.trackWholesaleForGA();
            this.view.showOwnerMenu();
            this.view.setShareCode(iODevice.getShareCode());
            this.view.setWarrantyDate(IOUtil.convertDateFormat(iODevice.getOption().getWarrantyDate()));
            return;
        }
        this.view.trackGuestUsingForGA();
        this.view.hideOwnerMenu();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x003f). Please report as a decompilation issue!!! */
    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.OnInitializeResultListener
    public void onInitializeResult(IODevice iODevice) {
        this.view.hideProgressbar();
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$IODevice$ProductId[iODevice.getProductId().ordinal()];
        if (i == 1 || i == 2) {
            try {
                Switcher switcher = (Switcher) iODevice;
                terminateMainSwitcher();
                if (switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
                    switcher.disconnect();
                    this.view.moveSwitcherListScreen();
                } else {
                    this.view.finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i != 3) {
            return;
        }
        try {
            this.view.moveSwitcherListScreen();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.switcherInfo.presenters.WholesalePresenter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;

        static {
            int[] iArr = new int[IODevice.ProductId.values().length];
            $SwitchMap$kr$switcher$device$IODevice$ProductId = iArr;
            try {
                iArr[IODevice.ProductId.SWITCHER_TYPE_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.SWITCHER_TYPE_TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.CHECKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.LINKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.FindSwitcherInfoInteractor.OnFoundMainSwitcherListener
    public void onFoundMainSwitcher(boolean z) {
        if (z) {
            this.view.terminateMainSwitcher();
        }
    }

    public void onInitializeButtonClicked(IODevice iODevice) {
        this.view.trackWarningForGA();
        if (iODevice.getProductId() == IODevice.ProductId.SWITCHER_TYPE_ONE || iODevice.getProductId() == IODevice.ProductId.SWITCHER_TYPE_TWO) {
            this.view.showWarningForInitializeDialog();
        } else if (iODevice.getProductId() == IODevice.ProductId.CHECKER || iODevice.getProductId() == IODevice.ProductId.LINKER) {
            this.view.showWarningForProductInitializeDialog();
        }
    }

    public void setInitButton(IODevice iODevice) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$IODevice$ProductId[iODevice.getProductId().ordinal()];
        if (i == 1) {
            this.view.showInitButton();
            return;
        }
        if (i == 2) {
            this.view.showInitButton();
        } else if (i == 3) {
            this.view.showInitButton();
        } else {
            if (i != 4) {
                return;
            }
            this.view.showInitButton();
        }
    }
}
