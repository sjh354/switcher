package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class LoginUser extends PreferenceHelper {
    private static final String FILE_NAME = "LOGIN_UESR";
    private String KEY_PHONE_NUMBER = "PHONE_NUMBER";
    private String KEY_AUTH_NUMBER = "AUTH_NUMBER";
    private String KEY_MIGRATION = "MIGRATION";
    private String phoneNumber = "";
    private String authNumber = "";
    private boolean migration = false;

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setPhoneNumber(String str) {
        if (context != null) {
            setString(this.KEY_PHONE_NUMBER, str);
        }
        this.phoneNumber = str;
    }

    public String getPhoneNumber() {
        if (context != null) {
            return getString(this.KEY_PHONE_NUMBER, null);
        }
        return this.phoneNumber;
    }

    public void setAuthNumber(String str) {
        if (context != null) {
            setString(this.KEY_AUTH_NUMBER, str);
        }
        this.authNumber = str;
    }

    public String getAuthNumber() {
        if (context != null) {
            return getString(this.KEY_AUTH_NUMBER, null);
        }
        return this.authNumber;
    }

    public void setMigration(boolean z) {
        if (context != null) {
            setBoolean(this.KEY_MIGRATION, z);
        }
        this.migration = z;
    }

    public boolean getMigration() {
        Boolean boolValueOf;
        if (context != null) {
            boolValueOf = Boolean.valueOf(getBoolean(this.KEY_MIGRATION, false));
        } else {
            boolValueOf = Boolean.valueOf(this.migration);
        }
        return boolValueOf.booleanValue();
    }
}
