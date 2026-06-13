package kr.switcher.switcherm.ui.switcherList.presenters;

import android.view.View;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter;
import kr.switcher.switcherm.ui.switcherList.interactors.SwitcherItemListInteractor;
import kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherAdapterPresenter {
    private static final String TAG = "SwitcherAdapterPresenter";
    private SwitcherItemListInteractor interactor;
    private SwitcherAdapterView view;
    private SwitcherAdapter.ViewHolder viewHolder;

    public SwitcherAdapterPresenter(SwitcherAdapterView switcherAdapterView, SwitcherItemListInteractor switcherItemListInteractor) {
        this.view = switcherAdapterView;
        this.interactor = switcherItemListInteractor;
    }

    public void setSwitcherItems(List<IODeviceItem> list) {
        this.interactor.setIODeviceItems(list);
        this.view.refresh();
    }

    public void setLinkerItems(List<IODeviceItem> list) {
        this.interactor.setHubItems(list);
        this.view.refresh();
    }

    public List<IODeviceItem> getDeviceItems() {
        return this.interactor.getIODeviceItems();
    }

    public void clearSwitcherItems() {
        this.interactor.clearSwitcherItems();
        this.view.refresh();
    }

    public void initialize(IODeviceItem iODeviceItem, SwitcherAdapter.ViewHolder viewHolder, int i) {
        this.viewHolder = viewHolder;
        this.view.initialize(iODeviceItem, viewHolder, i);
    }

    public void setSwitcherType(IODeviceItem iODeviceItem) {
        if (iODeviceItem.getFreeTrialId() > 0) {
            showProductionView(iODeviceItem.getProductId());
            return;
        }
        if (iODeviceItem.getProductId().equals(IODevice.ProductId.LINKER)) {
            if (iODeviceItem.isScanned()) {
                this.view.setLinkerWifiSetting(this.viewHolder);
                return;
            } else if (iODeviceItem.isLinked()) {
                this.view.setLinker(this.viewHolder);
                return;
            } else {
                showInfoView(iODeviceItem.getStatus(), iODeviceItem.getProductId());
                return;
            }
        }
        if (iODeviceItem.getProductId().equals(IODevice.ProductId.REMOCON)) {
            Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(iODeviceItem.getMacAddress());
            if (remocon != null) {
                int i = AnonymousClass2.$SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[remocon.getControllerId().ordinal()];
                if (i == 1) {
                    this.view.setTV(this.viewHolder);
                    return;
                }
                if (i == 2) {
                    this.view.setSetTopBox(this.viewHolder);
                    return;
                } else if (i == 3) {
                    this.view.setAircon(this.viewHolder);
                    return;
                } else {
                    if (i != 4) {
                        return;
                    }
                    this.view.setRemocon(this.viewHolder);
                    return;
                }
            }
            return;
        }
        if (iODeviceItem.getProductId().equals(IODevice.ProductId.CHECKER)) {
            if (iODeviceItem.isScanned()) {
                this.view.setCheckerWifiSetting(this.viewHolder);
                return;
            } else if (iODeviceItem.isLinked()) {
                this.view.setChecker(iODeviceItem.getSerialNumber(), this.viewHolder);
                return;
            } else {
                showInfoView(iODeviceItem.getStatus(), iODeviceItem.getProductId());
                return;
            }
        }
        if (iODeviceItem.isLinked()) {
            int i2 = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[iODeviceItem.getProductId().ordinal()];
            if (i2 == 1) {
                this.view.setLinkerSwitcherOneType(this.viewHolder);
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                this.view.setLinkerSwitcherTwoType(this.viewHolder);
                return;
            }
        }
        IODevice.ProductId productId = iODeviceItem.getProductId();
        if (!iODeviceItem.isScanned()) {
            showInfoView(iODeviceItem.getStatus(), productId);
        } else if (iODeviceItem.isScanned()) {
            showScannedView(productId);
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.switcherList.presenters.SwitcherAdapterPresenter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID;

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
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.LINKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.CHECKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Remocon.ControllerID.values().length];
            $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID = iArr2;
            try {
                iArr2[Remocon.ControllerID.TV.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.SET_TOP_BOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.AIRCON.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.REMOCON.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void showProductionView(IODevice.ProductId productId) {
        int i = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.view.setSwitcherTypeIsOneProduction(this.viewHolder);
            return;
        }
        if (i == 2) {
            this.view.setSwitcherTypeIsTwoProduction(this.viewHolder);
            return;
        }
        if (i == 3) {
            this.view.setLinkerProduction(this.viewHolder);
        } else if (i == 4) {
            this.view.setCheckerProduction(this.viewHolder);
        } else {
            this.view.setSwitcherTypeIsOtherProduction(this.viewHolder);
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showProductionView", new Exception("other type"));
        }
    }

    private void showScannedView(IODevice.ProductId productId) {
        int i = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.view.setSwitcherTypeIsOneAndScanned(this.viewHolder);
            return;
        }
        if (i == 2) {
            this.view.setSwitcherTypeIsTwoAndScanned(this.viewHolder);
        } else if (i == 3) {
            this.view.setLinkerWifiSetting(this.viewHolder);
        } else {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showScannedView", new Exception("other type"));
        }
    }

    private void showInfoView(int i, IODevice.ProductId productId) {
        if (i == 0) {
            showProductionView(productId);
            return;
        }
        if (i == 4) {
            showUsingInfoView(productId);
            return;
        }
        if (i == 6) {
            showReturnInfoView(productId);
        } else if (i == 8) {
            showReturnCompleteInfoView(productId);
        } else {
            showUsingInfoView(productId);
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showInfoView", new Exception("other status"));
        }
    }

    private void showDeliveryInfoView(IODevice.ProductId productId) {
        int i = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.view.setSwitcherTypeIsOneAndDelivery(this.viewHolder);
        } else if (i == 2) {
            this.view.setSwitcherTypeIsTwoAndDelivery(this.viewHolder);
        } else {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showDeliveryInfoView", new Exception("other type"));
        }
    }

    private void showUsingInfoView(IODevice.ProductId productId) {
        int i = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
                this.view.setSwitcherTypeIsOneAndConnectable(this.viewHolder);
                return;
            } else {
                this.view.setSwitcherTypeIsOneAndNotScanned(this.viewHolder);
                return;
            }
        }
        if (i == 2) {
            if (LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
                this.view.setSwitcherTypeIsTwoAndConnectable(this.viewHolder);
                return;
            } else {
                this.view.setSwitcherTypeIsTwoAndNotScanned(this.viewHolder);
                return;
            }
        }
        if (i == 3) {
            this.view.setLinkerProduction(this.viewHolder);
        } else if (i == 4) {
            this.view.setCheckerProduction(this.viewHolder);
        } else {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showUsingInfoView", new Exception("other type"));
        }
    }

    private void showReturnInfoView(IODevice.ProductId productId) {
        int i = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.view.setSwitcherTypeIsOneAndReturn(this.viewHolder);
        } else if (i == 2) {
            this.view.setSwitcherTypeIsTwoAndReturn(this.viewHolder);
        } else {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showReturnInfoView", new Exception("other type"));
        }
    }

    private void showReturnCompleteInfoView(IODevice.ProductId productId) {
        int i = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            this.view.setSwitcherTypeIsOneAndReturnComplete(this.viewHolder);
        } else if (i == 2) {
            this.view.setSwitcherTypeIsTwoAndReturnComplete(this.viewHolder);
        } else {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showReturnCompleteInfoView", new Exception("other type"));
        }
    }

    public void setSwitcherStatus(IODeviceItem iODeviceItem) {
        if (iODeviceItem.isConnected()) {
            if (iODeviceItem.isLinked()) {
                this.view.setSwitcherGWStatusIsConnected(this.viewHolder);
            } else {
                this.view.setSwitcherStatusIsConnected(this.viewHolder);
            }
        }
    }

    public View.OnClickListener getOnClickListener(final int i) {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.switcherList.presenters.SwitcherAdapterPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwitcherAdapterPresenter.this.onItemClick(SwitcherAdapterPresenter.this.interactor.getIODeviceItems().get(i), i);
            }
        };
    }

    public void onItemClick(IODeviceItem iODeviceItem, int i) {
        if (iODeviceItem.getFreeTrialId() > 0) {
            this.view.onItemClickToInfo(i);
            return;
        }
        if (iODeviceItem.getProductId().equals(IODevice.ProductId.LINKER)) {
            if (iODeviceItem.isLinked()) {
                this.view.onItemClickToLinker(i);
                return;
            } else if (iODeviceItem.isScanned()) {
                this.view.onItemClickToLinkerWifiSetting(i);
                return;
            } else {
                this.view.onItemClickToInfo(i);
                return;
            }
        }
        if (iODeviceItem.getProductId().equals(IODevice.ProductId.CHECKER)) {
            if (iODeviceItem.isLinked()) {
                this.view.onItemClickToConnect(i);
                return;
            } else if (iODeviceItem.isScanned()) {
                this.view.onItemClickToCheckerWifiSetting(i);
                return;
            } else {
                this.view.onItemClickToInfo(i);
                return;
            }
        }
        if (iODeviceItem.isLinked()) {
            this.view.onItemClickToConnect(i);
            return;
        }
        if (iODeviceItem.isScanned()) {
            this.view.onItemClickToConnect(i);
        } else if (iODeviceItem.getStatus() == 4 && LinkerHandler.getInstance().getAliveLinkers().size() > 0) {
            this.view.onItemClickToMainThing(i);
        } else {
            this.view.onItemClickToInfo(i);
        }
    }
}
