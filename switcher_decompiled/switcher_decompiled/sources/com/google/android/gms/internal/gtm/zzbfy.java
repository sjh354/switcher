package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class zzbfy {
    private static final zzbep zzb = zzbep.zza;
    protected volatile zzbgs zza;
    private volatile zzbbw zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbfy)) {
            return false;
        }
        zzbfy zzbfyVar = (zzbfy) obj;
        zzbgs zzbgsVar = this.zza;
        zzbgs zzbgsVar2 = zzbfyVar.zza;
        if (zzbgsVar == null && zzbgsVar2 == null) {
            return zzb().equals(zzbfyVar.zzb());
        }
        if (zzbgsVar != null && zzbgsVar2 != null) {
            return zzbgsVar.equals(zzbgsVar2);
        }
        if (zzbgsVar != null) {
            zzbfyVar.zzd(zzbgsVar.zzav());
            return zzbgsVar.equals(zzbfyVar.zza);
        }
        zzd(zzbgsVar2.zzav());
        return this.zza.equals(zzbgsVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzbbt) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzY();
        }
        return 0;
    }

    public final zzbbw zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzbbw.zzb;
            } else {
                this.zzc = this.zza.zzR();
            }
            return this.zzc;
        }
    }

    public final zzbgs zzc(zzbgs zzbgsVar) {
        zzbgs zzbgsVar2 = this.zza;
        this.zzc = null;
        this.zza = zzbgsVar;
        return zzbgsVar2;
    }

    protected final void zzd(zzbgs zzbgsVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzbgsVar;
                    this.zzc = zzbbw.zzb;
                } catch (zzbfs unused) {
                    this.zza = zzbgsVar;
                    this.zzc = zzbbw.zzb;
                }
            }
        }
    }
}
