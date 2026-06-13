package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.HashMap;
import kr.switcher.device.IODevice;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IODeviceIconMaker;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherInfoMainFragmentViewModel extends BaseObservable {
    private Context context;
    private String creditCard;
    private String invoiceNumber;
    private boolean isMine;
    private String owner;
    private String paymentDay;
    private String pricingModel;
    private String reservationDateReturn;
    private String returnState;
    private HashMap<Integer, String> returnStates;
    private String serialNumber;
    private String shareCode;
    private Drawable switcherIcon;
    private String switcherType;
    private int visibilityOfFreeTrial;
    private int visibilityOfOwnerMenu;
    private int visibilityOfPaymentDay;
    private int visibilityOfPlanButton;
    private int visibilityOfReturn;
    private int visibilityOfReturnButton;
    private int visibilityOfReturnComplete;
    private int visibilityOfUsing;

    public SwitcherInfoMainFragmentViewModel(Context context) {
        this.context = context;
        setWhoAmI(false);
    }

    public void initResource(IODevice.ProductId productId) {
        HashMap<Integer, String> map = new HashMap<>();
        this.returnStates = map;
        map.put(0, IOUtil.getStringResource(R.string.status_code0));
        this.returnStates.put(4, "'" + DeviceUtil.getDefaultDeviceName(productId) + "' " + IOUtil.getStringResource(R.string.status_code4));
        this.returnStates.put(6, IOUtil.getStringResource(R.string.status_code6));
        this.returnStates.put(8, IOUtil.getStringResource(R.string.status_code8));
    }

    public void viewData(IODevice iODevice, String str, String str2, String str3, String str4, String str5, String str6) {
        setShareCode(iODevice.getShareCode());
        setSwitcherType(iODevice.getName());
        setSwitcherIcon(IODeviceIconMaker.makeInfoIcon(iODevice.getProductId(), iODevice.getMacAddress()));
        setOwner(iODevice.getOwner());
        setSerialNumber(iODevice.getSerialNumber());
        setCreditCard(str2);
        setPricingModel(str3);
        setPaymentDay(str4);
        setReservationDateReturn(str5);
        setInvoiceNumber(str6);
        setState(iODevice.getOption().getShipping().getStatus(), IODeviceConfig.YES.equals(str));
    }

    public void setState(int i, boolean z) {
        if (this.isMine) {
            setReturnState(i);
            if (i == 0) {
                setVisibilityOfReturnButton(4);
                setVisibilityOfPaymentDay(4);
                setVisibilityOfUsing(0);
                setVisibilityOfReturn(4);
                setVisibilityOfReturnComplete(4);
                return;
            }
            if (i == 4) {
                if (z) {
                    setVisibilityOfFreeTrial(0);
                    IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_0));
                } else {
                    setVisibilityOfFreeTrial(8);
                    IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_2_1));
                }
                setVisibilityOfReturnButton(0);
                setVisibilityOfPaymentDay(0);
                setVisibilityOfUsing(0);
                setVisibilityOfReturn(4);
                setVisibilityOfReturnComplete(4);
                setVisibilityOfPlanButton(8);
                return;
            }
            if (i == 6) {
                IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_3));
                setVisibilityOfReturnButton(4);
                setVisibilityOfPaymentDay(4);
                setVisibilityOfUsing(4);
                setVisibilityOfReturn(0);
                setVisibilityOfReturnComplete(4);
                return;
            }
            if (i == 8) {
                IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_0_4));
                setVisibilityOfReturnButton(4);
                setVisibilityOfPaymentDay(4);
                setVisibilityOfUsing(4);
                setVisibilityOfReturn(4);
                setVisibilityOfReturnComplete(0);
                return;
            }
            if (i == 9) {
                setVisibilityOfReturnButton(4);
                setVisibilityOfPaymentDay(4);
                setVisibilityOfUsing(4);
                setVisibilityOfReturn(0);
                setVisibilityOfReturnComplete(4);
                return;
            }
            setVisibilityOfReturnButton(4);
            setVisibilityOfPaymentDay(4);
            setVisibilityOfUsing(4);
            setVisibilityOfReturn(4);
            setVisibilityOfReturnComplete(4);
            return;
        }
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_5_1_0));
    }

    public void setWhoAmI(boolean z) {
        this.isMine = z;
        if (z) {
            setVisibilityOfOwnerMenu(0);
        } else {
            setVisibilityOfOwnerMenu(4);
        }
    }

    @Bindable
    public String getSwitcherType() {
        return this.switcherType;
    }

    public void setSwitcherType(String str) {
        this.switcherType = str;
        notifyPropertyChanged(36);
    }

    @Bindable
    public Drawable getSwitcherIcon() {
        return this.switcherIcon;
    }

    public void setSwitcherIcon(Drawable drawable) {
        this.switcherIcon = drawable;
        notifyPropertyChanged(35);
    }

    @Bindable
    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
        notifyPropertyChanged(21);
    }

    @Bindable
    public String getShareCode() {
        return this.shareCode;
    }

    public void setShareCode(String str) {
        this.shareCode = str;
        notifyPropertyChanged(33);
    }

    @Bindable
    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
        notifyPropertyChanged(32);
    }

    @Bindable
    public String getReturnState() {
        return this.returnState;
    }

    public void setReturnState(int i) {
        this.returnState = this.returnStates.get(Integer.valueOf(i));
        notifyPropertyChanged(29);
    }

    @Bindable
    public String getCreditCard() {
        return this.creditCard;
    }

    public void setCreditCard(String str) {
        this.creditCard = str;
        notifyPropertyChanged(8);
    }

    @Bindable
    public String getPricingModel() {
        return this.pricingModel;
    }

    public void setPricingModel(String str) {
        this.pricingModel = str;
        notifyPropertyChanged(24);
    }

    @Bindable
    public String getPaymentDay() {
        return this.paymentDay;
    }

    public void setPaymentDay(String str) {
        this.paymentDay = str;
        notifyPropertyChanged(22);
    }

    @Bindable
    public int getVisibilityOfPaymentDay() {
        return this.visibilityOfPaymentDay;
    }

    public void setVisibilityOfPaymentDay(int i) {
        this.visibilityOfPaymentDay = i;
        notifyPropertyChanged(44);
    }

    @Bindable
    public int getVisibilityOfReturnButton() {
        return this.visibilityOfReturnButton;
    }

    public void setVisibilityOfReturnButton(int i) {
        this.visibilityOfReturnButton = i;
        notifyPropertyChanged(48);
    }

    @Bindable
    public int getVisibilityOfOwnerMenu() {
        return this.visibilityOfOwnerMenu;
    }

    public void setVisibilityOfOwnerMenu(int i) {
        this.visibilityOfOwnerMenu = i;
        notifyPropertyChanged(43);
    }

    @Bindable
    public int getVisibilityOfUsing() {
        return this.visibilityOfUsing;
    }

    public void setVisibilityOfUsing(int i) {
        this.visibilityOfUsing = i;
        notifyPropertyChanged(53);
    }

    @Bindable
    public int getVisibilityOfReturn() {
        return this.visibilityOfReturn;
    }

    public void setVisibilityOfReturn(int i) {
        this.visibilityOfReturn = i;
        notifyPropertyChanged(47);
    }

    @Bindable
    public int getVisibilityOfReturnComplete() {
        return this.visibilityOfReturnComplete;
    }

    public void setVisibilityOfReturnComplete(int i) {
        this.visibilityOfReturnComplete = i;
        notifyPropertyChanged(49);
    }

    @Bindable
    public int getVisibilityOfFreeTrial() {
        return this.visibilityOfFreeTrial;
    }

    public void setVisibilityOfFreeTrial(int i) {
        this.visibilityOfFreeTrial = i;
        notifyPropertyChanged(41);
    }

    @Bindable
    public String getReservationDateReturn() {
        return this.reservationDateReturn;
    }

    public void setReservationDateReturn(String str) {
        this.reservationDateReturn = str;
        notifyPropertyChanged(27);
    }

    @Bindable
    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(String str) {
        this.invoiceNumber = str;
        notifyPropertyChanged(11);
    }

    @Bindable
    public int getVisibilityOfPlanButton() {
        return this.visibilityOfPlanButton;
    }

    public void setVisibilityOfPlanButton(int i) {
        this.visibilityOfPlanButton = i;
        notifyPropertyChanged(45);
    }
}
