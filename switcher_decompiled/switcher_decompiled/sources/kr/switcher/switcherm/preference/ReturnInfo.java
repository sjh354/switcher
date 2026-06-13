package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnInfo extends PreferenceHelper {
    private static final String FILE_NAME = "RETURN_INFO";
    String macAddress;
    private String KEY_INVOICE_NUMBER = "INVOICE_NUMBER";
    private String KEY_POST_NUMBER = "POST_NUMBER";
    private String KEY_ADDRESS1 = "ADDRESS1";
    private String KEY_ADDRESS2 = "ADDRESS2";
    private String KEY_HOPE_VISIT = "HOPE_VISIT";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return "RETURN_INFO";
    }

    public ReturnInfo(String str) {
        this.macAddress = str;
    }

    public void setInvoiceNumber(String str) {
        setString(this.KEY_INVOICE_NUMBER + "." + this.macAddress, str);
    }

    public String getInvoiceNumber() {
        return getString(this.KEY_INVOICE_NUMBER + "." + this.macAddress, "");
    }

    public void setPostNumber(String str) {
        setString(this.KEY_POST_NUMBER + "." + this.macAddress, str);
    }

    public String getPostNumber() {
        return getString(this.KEY_POST_NUMBER + "." + this.macAddress, "");
    }

    public void setAddress1(String str) {
        setString(this.KEY_ADDRESS1 + "." + this.macAddress, str);
    }

    public String getAddress1() {
        return getString(this.KEY_ADDRESS1 + "." + this.macAddress, "");
    }

    public void setAddress2(String str) {
        setString(this.KEY_ADDRESS2 + "." + this.macAddress, str);
    }

    public String getAddress2() {
        return getString(this.KEY_ADDRESS2 + "." + this.macAddress, "");
    }

    public void setHopeVisit(String str) {
        setString(this.KEY_HOPE_VISIT + "." + this.macAddress, str);
    }

    public String getHopeVisit() {
        return getString(this.KEY_HOPE_VISIT + "." + this.macAddress, "");
    }
}
