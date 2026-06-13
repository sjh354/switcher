package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzbg;
import com.google.android.gms.internal.gtm.zzbk;
import com.google.android.gms.internal.gtm.zzbx;
import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class zza extends zzk {
    private final zzbx zzb;
    private boolean zzc;

    public zza(zzbx zzbxVar) {
        super(zzbxVar.zzd(), zzbxVar.zzr());
        this.zzb = zzbxVar;
    }

    public final zzh zza() {
        zzh zzhVar = new zzh(this.zza);
        zzhVar.zzg(this.zzb.zzh().zza());
        zzhVar.zzg(this.zzb.zzk().zza());
        zzn(zzhVar);
        return zzhVar;
    }

    final zzbx zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        Preconditions.checkNotEmpty(str);
        Uri uriZza = zzb.zza(str);
        ListIterator listIterator = this.zza.zzf().listIterator();
        while (listIterator.hasNext()) {
            if (uriZza.equals(((zzt) listIterator.next()).zzb())) {
                listIterator.remove();
            }
        }
        this.zza.zzf().add(new zzb(this.zzb, str));
    }

    public final void zzd(boolean z) {
        this.zzc = z;
    }

    @Override // com.google.android.gms.analytics.zzk
    protected final void zze(zzh zzhVar) {
        zzbg zzbgVar = (zzbg) zzhVar.zzb(zzbg.class);
        if (TextUtils.isEmpty(zzbgVar.zze())) {
            zzbgVar.zzj(this.zzb.zzi().zzb());
        }
        if (this.zzc && TextUtils.isEmpty(zzbgVar.zzd())) {
            zzbk zzbkVarZze = this.zzb.zze();
            zzbgVar.zzi(zzbkVarZze.zza());
            zzbgVar.zzh(zzbkVarZze.zzb());
        }
    }
}
