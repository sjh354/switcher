package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbk extends zzbu {
    public static boolean zza;
    private AdvertisingIdClient.Info zzb;
    private final zzfq zzc;
    private String zzd;
    private boolean zze;
    private final Object zzf;

    zzbk(zzbx zzbxVar) {
        super(zzbxVar);
        this.zze = false;
        this.zzf = new Object();
        this.zzc = new zzfq(zzbxVar.zzr());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034 A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0012, B:15:0x002e, B:19:0x0038, B:66:0x0137, B:22:0x0040, B:23:0x004a, B:67:0x013a, B:71:0x014b, B:18:0x0034, B:10:0x001c, B:12:0x0020, B:13:0x0028, B:72:0x014c, B:24:0x004b, B:27:0x0050, B:29:0x0068, B:31:0x007c, B:32:0x0085, B:33:0x008a, B:39:0x0093, B:42:0x00a7, B:48:0x00b8, B:49:0x00cb, B:51:0x00cd, B:46:0x00b2, B:52:0x00e2, B:54:0x00fb, B:56:0x00fd, B:58:0x0105, B:60:0x0107, B:62:0x010f, B:63:0x0121, B:64:0x0134, B:41:0x00a2), top: B:80:0x0001, inners: #2, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[Catch: all -> 0x0150, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0012, B:15:0x002e, B:19:0x0038, B:66:0x0137, B:22:0x0040, B:23:0x004a, B:67:0x013a, B:71:0x014b, B:18:0x0034, B:10:0x001c, B:12:0x0020, B:13:0x0028, B:72:0x014c, B:24:0x004b, B:27:0x0050, B:29:0x0068, B:31:0x007c, B:32:0x0085, B:33:0x008a, B:39:0x0093, B:42:0x00a7, B:48:0x00b8, B:49:0x00cb, B:51:0x00cd, B:46:0x00b2, B:52:0x00e2, B:54:0x00fb, B:56:0x00fd, B:58:0x0105, B:60:0x0107, B:62:0x010f, B:63:0x0121, B:64:0x0134, B:41:0x00a2), top: B:80:0x0001, inners: #2, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013a A[Catch: all -> 0x0150, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000b, B:7:0x0012, B:15:0x002e, B:19:0x0038, B:66:0x0137, B:22:0x0040, B:23:0x004a, B:67:0x013a, B:71:0x014b, B:18:0x0034, B:10:0x001c, B:12:0x0020, B:13:0x0028, B:72:0x014c, B:24:0x004b, B:27:0x0050, B:29:0x0068, B:31:0x007c, B:32:0x0085, B:33:0x008a, B:39:0x0093, B:42:0x00a7, B:48:0x00b8, B:49:0x00cb, B:51:0x00cd, B:46:0x00b2, B:52:0x00e2, B:54:0x00fb, B:56:0x00fd, B:58:0x0105, B:60:0x0107, B:62:0x010f, B:63:0x0121, B:64:0x0134, B:41:0x00a2), top: B:80:0x0001, inners: #2, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final synchronized com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzc() {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbk.zzc():com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    private static String zze(String str) {
        MessageDigest messageDigestZze = zzfu.zze("MD5");
        if (messageDigestZze == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZze.digest(str.getBytes())));
    }

    private final boolean zzf(String str) {
        try {
            String strZze = zze(str);
            zzN("Storing hashed adid.");
            FileOutputStream fileOutputStreamOpenFileOutput = zzo().openFileOutput("gaClientIdData", 0);
            fileOutputStreamOpenFileOutput.write(strZze.getBytes());
            fileOutputStreamOpenFileOutput.close();
            this.zzd = strZze;
            return true;
        } catch (IOException e) {
            zzJ("Error creating hash file", e);
            return false;
        }
    }

    public final String zza() {
        zzV();
        AdvertisingIdClient.Info infoZzc = zzc();
        String id = infoZzc != null ? infoZzc.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }

    public final boolean zzb() {
        zzV();
        AdvertisingIdClient.Info infoZzc = zzc();
        return (infoZzc == null || infoZzc.isLimitAdTrackingEnabled()) ? false : true;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
    }
}
