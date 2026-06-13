package kr.switcher.switcherm.network.http.response;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HttpResponseListHandler<T> {
    public abstract void onFailure(String str, String str2);

    public abstract void onSuccess(List<HttpAPIResponse<T>> list);
}
