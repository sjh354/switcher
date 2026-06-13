package kr.switcher.switcherm.signal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class SignalData implements Parcelable {
    public static final Parcelable.Creator<SignalData> CREATOR = new Parcelable.Creator<SignalData>() { // from class: kr.switcher.switcherm.signal.SignalData.1
        @Override // android.os.Parcelable.Creator
        public SignalData createFromParcel(Parcel parcel) {
            return new SignalData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SignalData[] newArray(int i) {
            return new SignalData[i];
        }
    };
    public static final String SIGNAL_STATUS_ACCEPTED = "accept";
    public static final String SIGNAL_STATUS_DENIED = "deny";
    public static final int SIGNAL_STATUS_FAILED = 2;
    public static final String SIGNAL_STATUS_NOT_APPLICABLE = "not_applicable";
    public static final int SIGNAL_STATUS_PUSHED = 1;
    public static final int SIGNAL_STATUS_READY = 0;
    public static final int SIGNAL_TYPE_1 = 1;
    public static final int SIGNAL_TYPE_2 = 2;
    public static final int SIGNAL_TYPE_3 = 3;
    public static final int SIGNAL_TYPE_CARD_REGISTER = 98;
    public static final int SIGNAL_TYPE_MARKETING = 0;
    public static final int SIGNAL_TYPE_TROUBLE_SHOOTING = 99;
    public static final int SIGNAL_TYPE_WIDGET_BANNER = 4;
    private String contentText;
    private int instanceId;
    private String param;
    private int signalStatus;
    private String titleText;
    private int type;
    private String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SignalData() {
        this.instanceId = 0;
        this.contentText = "";
        this.titleText = "";
        this.url = "";
        this.param = "";
        this.type = -1;
        ready();
    }

    public SignalData(int i, int i2, String str, String str2, String str3) {
        this.param = "";
        this.instanceId = i2;
        this.type = i;
        this.contentText = str;
        this.titleText = str2;
        this.url = str3;
    }

    public SignalData(int i, int i2, String str, String str2, String str3, String str4) {
        this.instanceId = i2;
        this.type = i;
        this.contentText = str;
        this.titleText = str2;
        this.url = str3;
        this.param = str4;
    }

    protected SignalData(Parcel parcel) {
        this.instanceId = 0;
        this.type = -1;
        this.contentText = "";
        this.titleText = "";
        this.url = "";
        this.param = "";
        this.instanceId = parcel.readInt();
        this.type = parcel.readInt();
        this.signalStatus = parcel.readInt();
        this.contentText = parcel.readString();
        this.titleText = parcel.readString();
        this.url = parcel.readString();
    }

    public boolean checkIsValidData() {
        int i = this.type;
        return i >= 0 && i <= 3;
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public String getContentText() {
        return this.contentText;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getUrl() {
        return this.url;
    }

    public int getSignalStatus() {
        return this.signalStatus;
    }

    public void ready() {
        this.signalStatus = 0;
    }

    public void push(boolean z) {
        if (z) {
            this.signalStatus = 1;
        } else {
            this.signalStatus = 2;
        }
    }

    public String getParam() {
        return this.param;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.instanceId);
        parcel.writeInt(this.type);
        parcel.writeInt(this.signalStatus);
        parcel.writeString(this.contentText);
        parcel.writeString(this.titleText);
        parcel.writeString(this.url);
    }
}
