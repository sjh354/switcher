package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcp extends zzbu {
    private volatile String zza;
    private Future zzb;

    protected zzcp(zzbx zzbxVar) {
        super(zzbxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzf() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            Context contextZza = zzq().zza();
            Preconditions.checkNotEmpty(lowerCase);
            Preconditions.checkNotMainThread("ClientId should be saved from worker thread");
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    try {
                        zzO("Storing clientId", lowerCase);
                        fileOutputStreamOpenFileOutput = contextZza.openFileOutput("gaClientId", 0);
                        fileOutputStreamOpenFileOutput.write(lowerCase.getBytes());
                        return lowerCase;
                    } catch (FileNotFoundException e) {
                        zzJ("Error creating clientId file", e);
                        if (fileOutputStreamOpenFileOutput != null) {
                            try {
                                fileOutputStreamOpenFileOutput.close();
                            } catch (IOException e2) {
                                e = e2;
                                zzJ("Failed to close clientId writing stream", e);
                                return Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
                            }
                        }
                        return Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
                    }
                } catch (IOException e3) {
                    zzJ("Error writing to clientId file", e3);
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e4) {
                            e = e4;
                            zzJ("Failed to close clientId writing stream", e);
                            return Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
                        }
                    }
                    return Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
                }
            } finally {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e5) {
                        zzJ("Failed to close clientId writing stream", e5);
                    }
                }
            }
        } catch (Exception e6) {
            zzJ("Error saving clientId file", e6);
            return Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
        }
    }

    public final String zzb() {
        String str;
        zzV();
        synchronized (this) {
            if (this.zza == null) {
                this.zzb = zzq().zzg(new zzcn(this));
            }
            Future future = this.zzb;
            if (future != null) {
                try {
                    this.zza = (String) future.get();
                } catch (InterruptedException e) {
                    zzR("ClientId loading or generation was interrupted", e);
                    this.zza = Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
                } catch (ExecutionException e2) {
                    zzJ("Failed to load or generate client id", e2);
                    this.zza = Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
                }
                if (this.zza == null) {
                    this.zza = Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
                }
                zzO("Loaded clientId", this.zza);
                this.zzb = null;
                str = this.zza;
            } else {
                str = this.zza;
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074 A[Catch: IOException -> 0x008c, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x008c, blocks: (B:9:0x0032, B:15:0x0047, B:32:0x0074, B:44:0x0088), top: B:61:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088 A[Catch: IOException -> 0x008c, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x008c, blocks: (B:9:0x0032, B:15:0x0047, B:32:0x0074, B:44:0x0088), top: B:61:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0072 -> B:53:0x0090). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0074 -> B:53:0x0090). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0088 -> B:60:0x0090). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x008d -> B:53:0x0090). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.lang.String zzc() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            com.google.android.gms.analytics.zzr r2 = r9.zzq()
            android.content.Context r2 = r2.zza()
            java.lang.String r3 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r3)
            r3 = 0
            java.io.FileInputStream r4 = r2.openFileInput(r0)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68 java.io.FileNotFoundException -> L85
            r5 = 36
            byte[] r6 = new byte[r5]     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            r7 = 0
            int r5 = r4.read(r6, r7, r5)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            int r8 = r4.available()     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            if (r8 <= 0) goto L36
            java.lang.String r5 = "clientId file seems corrupted, deleting it."
            r9.zzQ(r5)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            r4.close()     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            r2.deleteFile(r0)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            if (r4 == 0) goto L90
            r4.close()     // Catch: java.io.IOException -> L8c
            goto L90
        L36:
            r8 = 14
            if (r5 >= r8) goto L4b
            java.lang.String r5 = "clientId file is empty, deleting it."
            r9.zzQ(r5)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            r4.close()     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            r2.deleteFile(r0)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            if (r4 == 0) goto L90
            r4.close()     // Catch: java.io.IOException -> L8c
            goto L90
        L4b:
            r4.close()     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            java.lang.String r8 = new java.lang.String     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            r8.<init>(r6, r7, r5)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            java.lang.String r5 = "Read client id from disk"
            r9.zzO(r5, r8)     // Catch: java.io.IOException -> L64 java.lang.Throwable -> L78 java.io.FileNotFoundException -> L86
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r0 = move-exception
            r9.zzJ(r1, r0)
        L62:
            r3 = r8
            goto L90
        L64:
            r5 = move-exception
            goto L6a
        L66:
            r0 = move-exception
            goto L7a
        L68:
            r5 = move-exception
            r4 = r3
        L6a:
            java.lang.String r6 = "Error reading client id file, deleting it"
            r9.zzJ(r6, r5)     // Catch: java.lang.Throwable -> L78
            r2.deleteFile(r0)     // Catch: java.lang.Throwable -> L78
            if (r4 == 0) goto L90
            r4.close()     // Catch: java.io.IOException -> L8c
            goto L90
        L78:
            r0 = move-exception
            r3 = r4
        L7a:
            if (r3 == 0) goto L84
            r3.close()     // Catch: java.io.IOException -> L80
            goto L84
        L80:
            r2 = move-exception
            r9.zzJ(r1, r2)
        L84:
            throw r0
        L85:
            r4 = r3
        L86:
            if (r4 == 0) goto L90
            r4.close()     // Catch: java.io.IOException -> L8c
            goto L90
        L8c:
            r0 = move-exception
            r9.zzJ(r1, r0)
        L90:
            if (r3 != 0) goto L97
            java.lang.String r0 = r9.zzf()
            return r0
        L97:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcp.zzc():java.lang.String");
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
    }

    final String zze() {
        synchronized (this) {
            this.zza = null;
            this.zzb = zzq().zzg(new zzco(this));
        }
        return zzb();
    }
}
