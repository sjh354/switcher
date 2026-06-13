package cz.msebera.android.httpclient.auth;

import java.security.Principal;

/* JADX INFO: loaded from: classes2.dex */
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
