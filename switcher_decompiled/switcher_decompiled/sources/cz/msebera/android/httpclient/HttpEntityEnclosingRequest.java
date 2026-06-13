package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpEntityEnclosingRequest extends HttpRequest {
    boolean expectContinue();

    HttpEntity getEntity();

    void setEntity(HttpEntity httpEntity);
}
