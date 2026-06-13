package kr.switcher.switcherm.preference;

/* JADX INFO: loaded from: classes2.dex */
public class OAuthToken extends PreferenceHelper {
    private static final String FILE_NAME = "AUTH";
    private String KEY_OAUTH_TOKEN = "OAUTH_TOKEN";

    @Override // kr.switcher.switcherm.preference.PreferenceHelper
    public String getFileName() {
        return FILE_NAME;
    }

    public void setOAuthToken(String str) {
        setString(this.KEY_OAUTH_TOKEN, str);
    }

    public String getOAuthToken() {
        return getString(this.KEY_OAUTH_TOKEN, "");
    }
}
