package kr.switcher.switcherm.ui.setting.helper;

import kr.switcher.switcherm.network.http.response.NewHashingShareCodeAPIResponse;

/* JADX INFO: loaded from: classes2.dex */
public class ShareCodeJsonParser {
    public static String parseNewHashingShareCode(NewHashingShareCodeAPIResponse newHashingShareCodeAPIResponse) throws NullPointerException {
        return newHashingShareCodeAPIResponse.getHashingShareCode();
    }
}
