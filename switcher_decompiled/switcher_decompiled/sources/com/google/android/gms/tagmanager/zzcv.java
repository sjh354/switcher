package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcv extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.INSTALL_REFERRER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.COMPONENT.toString();
    private final Context zzc;

    public zzcv(Context context) {
        super(zza, new String[0]);
        this.zzc = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String str = zzb;
        String strZzb = zzcw.zzb(this.zzc, ((com.google.android.gms.internal.gtm.zzam) map.get(str)) != null ? zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) map.get(str))) : null);
        return strZzb != null ? zzfu.zzc(strZzb) : zzfu.zzb();
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
