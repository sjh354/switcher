package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.params.HttpParams;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface ClientConnectionManagerFactory {
    ClientConnectionManager newInstance(HttpParams httpParams, SchemeRegistry schemeRegistry);
}
