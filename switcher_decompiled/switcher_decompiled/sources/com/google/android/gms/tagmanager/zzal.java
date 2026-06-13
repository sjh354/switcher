package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzal {
    private final Context zza;
    private final Random zzb;
    private final String zzc;

    public zzal(Context context, String str) {
        Random random = new Random();
        this.zza = (Context) Preconditions.checkNotNull(context);
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzb = random;
    }

    private final long zze(long j, long j2) {
        long jMax = Math.max(0L, zzf().getLong("FORBIDDEN_COUNT", 0L));
        return (long) (this.zzb.nextFloat() * (j + ((long) ((jMax / ((jMax + Math.max(0L, r0.getLong("SUCCESSFUL_COUNT", 0L))) + 1)) * (j2 - j)))));
    }

    private final SharedPreferences zzf() {
        return this.zza.getSharedPreferences("_gtmContainerRefreshPolicy_".concat(String.valueOf(this.zzc)), 0);
    }

    public final long zza() {
        return zze(7200000L, 259200000L) + 43200000;
    }

    public final long zzb() {
        return zze(600000L, 86400000L) + 3600000;
    }

    public final void zzc() {
        SharedPreferences sharedPreferencesZzf = zzf();
        long j = sharedPreferencesZzf.getLong("FORBIDDEN_COUNT", 0L);
        long j2 = sharedPreferencesZzf.getLong("SUCCESSFUL_COUNT", 0L);
        SharedPreferences.Editor editorEdit = sharedPreferencesZzf.edit();
        long jMin = j == 0 ? 3L : Math.min(10L, j + 1);
        long jMax = Math.max(0L, Math.min(j2, 10 - jMin));
        editorEdit.putLong("FORBIDDEN_COUNT", jMin);
        editorEdit.putLong("SUCCESSFUL_COUNT", jMax);
        editorEdit.apply();
    }

    public final void zzd() {
        SharedPreferences sharedPreferencesZzf = zzf();
        long j = sharedPreferencesZzf.getLong("SUCCESSFUL_COUNT", 0L);
        long j2 = sharedPreferencesZzf.getLong("FORBIDDEN_COUNT", 0L);
        long jMin = Math.min(10L, j + 1);
        long jMax = Math.max(0L, Math.min(j2, 10 - jMin));
        SharedPreferences.Editor editorEdit = sharedPreferencesZzf.edit();
        editorEdit.putLong("SUCCESSFUL_COUNT", jMin);
        editorEdit.putLong("FORBIDDEN_COUNT", jMax);
        editorEdit.apply();
    }
}
