package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzbez;
import com.google.android.gms.internal.gtm.zzbff;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class zzbez<MessageType extends zzbff<MessageType, BuilderType>, BuilderType extends zzbez<MessageType, BuilderType>> extends zzbax<MessageType, BuilderType> {
    protected zzbff zza;
    protected boolean zzb = false;
    private final zzbff zzc;

    protected zzbez(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzbff) messagetype.zzb(4, null, null);
    }

    private static final void zza(zzbff zzbffVar, zzbff zzbffVar2) {
        zzbhb.zza().zzb(zzbffVar.getClass()).zzg(zzbffVar, zzbffVar2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbgr
    /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
    public final MessageType zzC() {
        MessageType messagetype = (MessageType) zzD();
        if (messagetype.zzaw()) {
            return messagetype;
        }
        throw new zzbhy(messagetype);
    }

    @Override // com.google.android.gms.internal.gtm.zzbgr
    /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
    public MessageType zzD() {
        if (this.zzb) {
            return (MessageType) this.zza;
        }
        zzbff zzbffVar = this.zza;
        zzbhb.zza().zzb(zzbffVar.getClass()).zzf(zzbffVar);
        this.zzb = true;
        return (MessageType) this.zza;
    }

    protected void zzF() {
        zzbff zzbffVar = (zzbff) this.zza.zzb(4, null, null);
        zza(zzbffVar, this.zza);
        this.zza = zzbffVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgt
    public final /* synthetic */ zzbgs zzav() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgt
    public final boolean zzaw() {
        return zzbff.zzao(this.zza, false);
    }

    @Override // com.google.android.gms.internal.gtm.zzbax
    protected final /* synthetic */ zzbax zzw(zzbay zzbayVar) {
        zzz((zzbff) zzbayVar);
        return this;
    }

    @Override // com.google.android.gms.internal.gtm.zzbax
    /* JADX INFO: renamed from: zzy, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzbez zzv() {
        zzbez zzbezVar = (zzbez) this.zzc.zzb(5, null, null);
        zzbezVar.zzz(zzD());
        return zzbezVar;
    }

    public final zzbez zzz(zzbff zzbffVar) {
        if (this.zzb) {
            zzF();
            this.zzb = false;
        }
        zza(this.zza, zzbffVar);
        return this;
    }
}
