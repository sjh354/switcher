package com.google.android.gms.internal.gtm;

import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzsf implements zzsg {
    private HttpURLConnection zza;
    private InputStream zzb = null;

    zzsf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzsg
    public final InputStream zza(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        httpURLConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        this.zza = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            this.zzb = inputStream;
            return inputStream;
        }
        String str2 = "Bad response: " + responseCode;
        if (responseCode == 404) {
            throw new FileNotFoundException(str2);
        }
        if (responseCode == 503) {
            throw new zzsi(str2);
        }
        throw new IOException(str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzsg
    public final void zzb() {
        HttpURLConnection httpURLConnection = this.zza;
        try {
            InputStream inputStream = this.zzb;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            Log.e("GoogleTagManager", "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(String.valueOf(e.getMessage())), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
