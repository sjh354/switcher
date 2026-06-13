package kr.switcher.switcherm.network.http.helper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/* JADX INFO: loaded from: classes2.dex */
public class AuthLegacyParser {
    public static String parseGetAccessTokenInAuthLegacyInfo(String str) throws Exception {
        try {
            return ((AuthLegacyVo) new Gson().fromJson(str, AuthLegacyVo.class)).AccessToken;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    class AuthLegacyVo {
        String AccessToken;
        String type;

        AuthLegacyVo() {
        }
    }
}
