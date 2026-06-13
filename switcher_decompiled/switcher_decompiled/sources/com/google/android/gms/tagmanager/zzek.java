package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.internal.gtm.zzro;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzek implements Runnable {
    final /* synthetic */ zzro zza;
    final /* synthetic */ zzel zzb;

    zzek(zzel zzelVar, zzro zzroVar) {
        this.zzb = zzelVar;
        this.zza = zzroVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileOutputStream fileOutputStream;
        zzel zzelVar = this.zzb;
        zzro zzroVar = this.zza;
        File fileZze = zzelVar.zze();
        try {
            try {
                fileOutputStream = new FileOutputStream(fileZze);
                try {
                    zzroVar.zzU(fileOutputStream);
                } catch (IOException unused) {
                    Log.w("GoogleTagManager", "Error writing resource to disk. Removing resource from disk.");
                    fileZze.delete();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        Log.w("GoogleTagManager", "error closing stream for writing resource to disk");
                    }
                }
            } catch (FileNotFoundException unused3) {
                Log.e("GoogleTagManager", "Error opening resource file for writing");
            }
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException unused4) {
                Log.w("GoogleTagManager", "error closing stream for writing resource to disk");
            }
        }
    }
}
