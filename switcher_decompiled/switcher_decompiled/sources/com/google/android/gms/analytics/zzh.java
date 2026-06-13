package com.google.android.gms.analytics;

import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    private final zzk zza;
    private final Clock zzb;
    private boolean zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private final Map zzj;
    private final List zzk;

    zzh(zzh zzhVar) {
        this.zza = zzhVar.zza;
        this.zzb = zzhVar.zzb;
        this.zzd = zzhVar.zzd;
        this.zze = zzhVar.zze;
        this.zzf = zzhVar.zzf;
        this.zzg = zzhVar.zzg;
        this.zzh = zzhVar.zzh;
        this.zzk = new ArrayList(zzhVar.zzk);
        this.zzj = new HashMap(zzhVar.zzj.size());
        for (Map.Entry entry : zzhVar.zzj.entrySet()) {
            zzj zzjVarZzn = zzn((Class) entry.getKey());
            ((zzj) entry.getValue()).zzc(zzjVarZzn);
            this.zzj.put((Class) entry.getKey(), zzjVarZzn);
        }
    }

    private static zzj zzn(Class cls) {
        try {
            return (zzj) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            if (e instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e);
            }
            if (e instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e);
            }
            if (Build.VERSION.SDK_INT < 19 || !(e instanceof ReflectiveOperationException)) {
                throw new RuntimeException(e);
            }
            throw new IllegalArgumentException("Linkage exception", e);
        }
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzj zzb(Class cls) {
        zzj zzjVar = (zzj) this.zzj.get(cls);
        if (zzjVar != null) {
            return zzjVar;
        }
        zzj zzjVarZzn = zzn(cls);
        this.zzj.put(cls, zzjVarZzn);
        return zzjVarZzn;
    }

    public final zzj zzc(Class cls) {
        return (zzj) this.zzj.get(cls);
    }

    final zzk zzd() {
        return this.zza;
    }

    public final Collection zze() {
        return this.zzj.values();
    }

    public final List zzf() {
        return this.zzk;
    }

    public final void zzg(zzj zzjVar) {
        Preconditions.checkNotNull(zzjVar);
        Class<?> cls = zzjVar.getClass();
        if (cls.getSuperclass() != zzj.class) {
            throw new IllegalArgumentException();
        }
        zzjVar.zzc(zzb(cls));
    }

    final void zzh() {
        this.zzi = true;
    }

    final void zzi() {
        this.zzf = this.zzb.elapsedRealtime();
        long j = this.zze;
        if (j != 0) {
            this.zzd = j;
        } else {
            this.zzd = this.zzb.currentTimeMillis();
        }
        this.zzc = true;
    }

    public final void zzj(long j) {
        this.zze = j;
    }

    public final void zzk() {
        this.zza.zzm().zzk(this);
    }

    final boolean zzl() {
        return this.zzi;
    }

    public final boolean zzm() {
        return this.zzc;
    }

    zzh(zzk zzkVar, Clock clock) {
        Preconditions.checkNotNull(zzkVar);
        Preconditions.checkNotNull(clock);
        this.zza = zzkVar;
        this.zzb = clock;
        this.zzg = 1800000L;
        this.zzh = 3024000000L;
        this.zzj = new HashMap();
        this.zzk = new ArrayList();
    }
}
