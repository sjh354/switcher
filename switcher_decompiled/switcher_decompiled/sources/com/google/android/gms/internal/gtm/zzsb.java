package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzsb {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();
    private final List zzd = new ArrayList();
    private final List zze = new ArrayList();
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final List zzh = new ArrayList();
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();

    private zzsb() {
    }

    public final zzrz zza() {
        return new zzrz(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, null);
    }

    public final zzsb zzb(zzrr zzrrVar) {
        this.zze.add(zzrrVar);
        return this;
    }

    public final zzsb zzc(String str) {
        this.zzg.add(str);
        return this;
    }

    public final zzsb zzd(zzrr zzrrVar) {
        this.zzc.add(zzrrVar);
        return this;
    }

    public final zzsb zze(String str) {
        this.zzi.add(str);
        return this;
    }

    public final zzsb zzf(zzrr zzrrVar) {
        this.zzb.add(zzrrVar);
        return this;
    }

    public final zzsb zzg(zzrr zzrrVar) {
        this.zza.add(zzrrVar);
        return this;
    }

    public final zzsb zzh(zzrr zzrrVar) {
        this.zzf.add(zzrrVar);
        return this;
    }

    public final zzsb zzi(String str) {
        this.zzh.add(str);
        return this;
    }

    public final zzsb zzj(zzrr zzrrVar) {
        this.zzd.add(zzrrVar);
        return this;
    }

    public final zzsb zzk(String str) {
        this.zzj.add(str);
        return this;
    }

    /* synthetic */ zzsb(zzsa zzsaVar) {
    }
}
