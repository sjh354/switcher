package kr.switcher.switcherm.ui.auth.domain;

/* JADX INFO: loaded from: classes2.dex */
public class AccessTokensInfo {
    String accessTokenId;
    String authNumber = "";
    String key = "";

    public AccessTokensInfo(String str) {
        this.accessTokenId = str;
    }

    public String getAccessTokenId() {
        return this.accessTokenId;
    }

    public void setAccessTokenId(String str) {
        this.accessTokenId = str;
    }

    public String getAuthNumber() {
        return this.authNumber;
    }

    public void setAuthNumber(String str) {
        this.authNumber = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
