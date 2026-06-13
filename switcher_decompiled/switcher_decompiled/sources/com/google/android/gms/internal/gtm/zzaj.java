package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaj extends zzbez implements zzbgt {
    private zzaj() {
        super(zzak.zza);
    }

    public final zzaj zza() {
        if (this.zzb) {
            zzF();
            this.zzb = false;
        }
        ((zzak) this.zza).zzf = zzak.zzaj();
        return this;
    }

    public final zzaj zzb(String str) {
        if (this.zzb) {
            zzF();
            this.zzb = false;
        }
        zzak.zzl((zzak) this.zza, str);
        return this;
    }

    public final zzaj zzc(zzac zzacVar) {
        if (this.zzb) {
            zzF();
            this.zzb = false;
        }
        zzak.zzk((zzak) this.zza, zzacVar);
        return this;
    }

    /* synthetic */ zzaj(zzn zznVar) {
        super(zzak.zza);
    }
}
