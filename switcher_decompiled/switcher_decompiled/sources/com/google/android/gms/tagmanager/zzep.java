package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzrz;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzep implements zzeq {
    zzep(zzet zzetVar) {
    }

    @Override // com.google.android.gms.tagmanager.zzeq
    public final void zza(zzrz zzrzVar, Set set, Set set2, zzdn zzdnVar) {
        set.addAll(zzrzVar.zzc());
        set2.addAll(zzrzVar.zzh());
        zzrzVar.zzc();
        zzrzVar.zzb();
        zzrzVar.zzh();
        zzrzVar.zzg();
    }
}
