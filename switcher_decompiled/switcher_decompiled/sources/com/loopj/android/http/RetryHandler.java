package com.loopj.android.http;

import android.os.SystemClock;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes.dex */
class RetryHandler implements HttpRequestRetryHandler {
    private static final HashSet<Class<?>> exceptionBlacklist;
    private static final HashSet<Class<?>> exceptionWhitelist;
    private final int maxRetries;
    private final int retrySleepTimeMS;

    static {
        HashSet<Class<?>> hashSet = new HashSet<>();
        exceptionWhitelist = hashSet;
        HashSet<Class<?>> hashSet2 = new HashSet<>();
        exceptionBlacklist = hashSet2;
        hashSet.add(NoHttpResponseException.class);
        hashSet.add(UnknownHostException.class);
        hashSet.add(SocketException.class);
        hashSet2.add(InterruptedIOException.class);
        hashSet2.add(SSLException.class);
    }

    public RetryHandler(int i, int i2) {
        this.maxRetries = i;
        this.retrySleepTimeMS = i2;
    }

    static void addClassToWhitelist(Class<?> cls) {
        exceptionWhitelist.add(cls);
    }

    static void addClassToBlacklist(Class<?> cls) {
        exceptionBlacklist.add(cls);
    }

    @Override // cz.msebera.android.httpclient.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        if (bool != null) {
            bool.booleanValue();
        }
        boolean z = true;
        if (i > this.maxRetries || (!isInList(exceptionWhitelist, iOException) && isInList(exceptionBlacklist, iOException))) {
            z = false;
        }
        if (z && ((HttpUriRequest) httpContext.getAttribute("http.request")) == null) {
            return false;
        }
        if (z) {
            SystemClock.sleep(this.retrySleepTimeMS);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }

    protected boolean isInList(HashSet<Class<?>> hashSet, Throwable th) {
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(th)) {
                return true;
            }
        }
        return false;
    }
}
