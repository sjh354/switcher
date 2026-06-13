package kr.switcher.switcherm.network.http.response;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HttpResponseHandler {
    public abstract void onFailure(String str, String str2);

    public abstract void onSuccess(HttpAPIResponse httpAPIResponse);
}
