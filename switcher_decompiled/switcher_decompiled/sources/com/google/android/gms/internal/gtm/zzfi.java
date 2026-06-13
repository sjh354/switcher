package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfi {
    final /* synthetic */ zzfj zza;
    private final String zzb;
    private final long zzc;

    /* synthetic */ zzfi(zzfj zzfjVar, String str, long j, zzfh zzfhVar) {
        this.zza = zzfjVar;
        Preconditions.checkNotEmpty("monitoring");
        Preconditions.checkArgument(j > 0);
        this.zzb = "monitoring";
        this.zzc = j;
    }

    private final long zzd() {
        return this.zza.zza.getLong(zzf(), 0L);
    }

    private final String zze() {
        return this.zzb.concat(":count");
    }

    private final String zzf() {
        return this.zzb.concat(":start");
    }

    private final void zzg() {
        long jCurrentTimeMillis = this.zza.zzC().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zza.zza.edit();
        editorEdit.remove(zze());
        editorEdit.remove(zzb());
        editorEdit.putLong(zzf(), jCurrentTimeMillis);
        editorEdit.commit();
    }

    public final Pair zza() {
        long jZzd = zzd();
        long jAbs = jZzd == 0 ? 0L : Math.abs(jZzd - this.zza.zzC().currentTimeMillis());
        long j = this.zzc;
        if (jAbs < j) {
            return null;
        }
        if (jAbs > j + j) {
            zzg();
            return null;
        }
        String string = this.zza.zza.getString(zzb(), null);
        long j2 = this.zza.zza.getLong(zze(), 0L);
        zzg();
        if (string == null || j2 <= 0) {
            return null;
        }
        return new Pair(string, Long.valueOf(j2));
    }

    protected final String zzb() {
        return this.zzb.concat(":value");
    }

    public final void zzc(String str) {
        if (zzd() == 0) {
            zzg();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            long j = this.zza.zza.getLong(zze(), 0L);
            if (j <= 0) {
                SharedPreferences.Editor editorEdit = this.zza.zza.edit();
                editorEdit.putString(zzb(), str);
                editorEdit.putLong(zze(), 1L);
                editorEdit.apply();
                return;
            }
            long leastSignificantBits = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
            long j2 = j + 1;
            long j3 = Long.MAX_VALUE / j2;
            SharedPreferences.Editor editorEdit2 = this.zza.zza.edit();
            if (leastSignificantBits < j3) {
                editorEdit2.putString(zzb(), str);
            }
            editorEdit2.putLong(zze(), j2);
            editorEdit2.apply();
        }
    }
}
