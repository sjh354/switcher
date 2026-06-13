package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import kr.switcher.switcherm.common.util.IOLog;

/* JADX INFO: loaded from: classes2.dex */
public class RequestConnControl implements HttpRequestInterceptor {
    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase(IOLog.DEVICE_LOG_TYPE_CONNECT) || httpRequest.containsHeader("Connection")) {
            return;
        }
        httpRequest.addHeader("Connection", HTTP.CONN_KEEP_ALIVE);
    }
}
