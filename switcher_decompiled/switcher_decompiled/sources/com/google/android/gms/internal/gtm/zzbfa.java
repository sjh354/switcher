package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class zzbfa extends zzbez implements zzbgt {
    protected zzbfa(zzbfb zzbfbVar) {
        super(zzbfbVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzbez
    protected final void zzF() {
        super.zzF();
        zzbfb zzbfbVar = (zzbfb) this.zza;
        zzbfbVar.zzb = zzbfbVar.zzb.clone();
    }

    @Override // com.google.android.gms.internal.gtm.zzbez, com.google.android.gms.internal.gtm.zzbgr
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzbfb zzD() {
        if (this.zzb) {
            return (zzbfb) this.zza;
        }
        ((zzbfb) this.zza).zzb.zzi();
        return (zzbfb) super.zzD();
    }
}
