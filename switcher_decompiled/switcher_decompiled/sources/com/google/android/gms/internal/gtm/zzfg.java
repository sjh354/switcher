package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzfg extends zzbu {
    private static final byte[] zza = "\n".getBytes();
    private final String zzb;
    private final zzfq zzc;

    zzfg(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzb = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", zzbv.zza, Build.VERSION.RELEASE, zzfu.zzd(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzc = new zzfq(zzbxVar.zzr());
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zzg(java.net.URL r5, byte[] r6, int r7) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r7 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            int r0 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "POST bytes, url"
            r4.zzG(r2, r1, r5)
            boolean r1 = zzU()
            if (r1 == 0) goto L22
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.zzO(r2, r1)
        L22:
            r1 = 0
            java.net.HttpURLConnection r5 = r4.zzb(r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6e
            r2 = 1
            r5.setDoOutput(r2)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r5.setFixedLengthStreamingMode(r0)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r5.connect()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r1.write(r6)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r4.zzk(r5)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            int r6 = r5.getResponseCode()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 != r0) goto L4b
            com.google.android.gms.internal.gtm.zzbs r6 = r4.zzs()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r6.zzi()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r6 = r0
        L4b:
            java.lang.String r0 = "POST status"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            r4.zzF(r0, r2)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L66
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r0 = move-exception
            r4.zzJ(r7, r0)
        L5e:
            if (r5 == 0) goto L63
            r5.disconnect()
        L63:
            return r6
        L64:
            r6 = move-exception
            goto L8a
        L66:
            r6 = move-exception
            r3 = r1
            r1 = r5
            r5 = r3
            goto L70
        L6b:
            r6 = move-exception
            r5 = r1
            goto L8a
        L6e:
            r6 = move-exception
            r5 = r1
        L70:
            java.lang.String r0 = "Network POST connection error"
            r4.zzR(r0, r6)     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L7f
            r5.close()     // Catch: java.io.IOException -> L7b
            goto L7f
        L7b:
            r5 = move-exception
            r4.zzJ(r7, r5)
        L7f:
            if (r1 == 0) goto L84
            r1.disconnect()
        L84:
            r5 = 0
            return r5
        L86:
            r6 = move-exception
            r3 = r1
            r1 = r5
            r5 = r3
        L8a:
            if (r1 == 0) goto L94
            r1.close()     // Catch: java.io.IOException -> L90
            goto L94
        L90:
            r0 = move-exception
            r4.zzJ(r7, r0)
        L94:
            if (r5 == 0) goto L99
            r5.disconnect()
        L99:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfg.zzg(java.net.URL, byte[], int):int");
    }

    private final URL zzh() {
        zzw();
        String strZzi = zzcv.zzi();
        zzw();
        try {
            return new URL(strZzi.concat((String) zzew.zzt.zzb()));
        } catch (MalformedURLException e) {
            zzJ("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzi(zzez zzezVar) {
        String strConcat;
        if (zzezVar.zzh()) {
            zzw();
            String strZzi = zzcv.zzi();
            zzw();
            strConcat = strZzi.concat(zzcv.zzj());
        } else {
            zzw();
            String strZzk = zzcv.zzk();
            zzw();
            strConcat = strZzk.concat(zzcv.zzj());
        }
        try {
            return new URL(strConcat);
        } catch (MalformedURLException e) {
            zzJ("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzj(zzez zzezVar, String str) {
        String str2;
        if (zzezVar.zzh()) {
            zzw();
            String strZzi = zzcv.zzi();
            zzw();
            str2 = strZzi + zzcv.zzj() + "?" + str;
        } else {
            zzw();
            String strZzk = zzcv.zzk();
            zzw();
            str2 = strZzk + zzcv.zzj() + "?" + str;
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            zzJ("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final void zzk(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        zzJ("Error closing http connection input stream", e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        zzJ("Error closing http connection input stream", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    private static final void zzl(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append(Typography.amp);
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    final String zza(zzez zzezVar, boolean z) {
        Preconditions.checkNotNull(zzezVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry entry : zzezVar.zzg().entrySet()) {
                String str = (String) entry.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zzl(sb, str, (String) entry.getValue());
                }
            }
            zzl(sb, "ht", String.valueOf(zzezVar.zzd()));
            zzl(sb, "qt", String.valueOf(zzC().currentTimeMillis() - zzezVar.zzd()));
            zzw();
            if (z) {
                long jZzc = zzezVar.zzc();
                zzl(sb, "z", jZzc != 0 ? String.valueOf(jZzc) : String.valueOf(zzezVar.zzb()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zzJ("Failed to encode name or value", e);
            return null;
        }
    }

    final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        zzw();
        httpURLConnection.setConnectTimeout(((Integer) zzew.zzE.zzb()).intValue());
        zzw();
        httpURLConnection.setReadTimeout(((Integer) zzew.zzF.zzb()).intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzb);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0328 A[EDGE_INSN: B:183:0x0328->B:156:0x0328 BREAK  A[LOOP:1: B:107:0x0232->B:187:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[LOOP:1: B:107:0x0232->B:187:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List zzc(java.util.List r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfg.zzc(java.util.List):java.util.List");
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        zzO("Network initialized. User agent", this.zzb);
    }

    public final boolean zze() {
        NetworkInfo activeNetworkInfo;
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        try {
            activeNetworkInfo = ((ConnectivityManager) zzo().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzN("No network connectivity");
        return false;
    }
}
