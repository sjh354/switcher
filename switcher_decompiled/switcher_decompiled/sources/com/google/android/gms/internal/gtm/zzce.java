package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzce extends zzbu {
    private final zzcd zza;
    private final zzcy zzb;
    private final zzfq zzc;
    private zzfa zzd;

    protected zzce(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzc = new zzfq(zzbxVar.zzr());
        this.zza = new zzcd(this);
        this.zzb = new zzca(this, zzbxVar);
    }

    static /* synthetic */ void zzb(zzce zzceVar, ComponentName componentName) {
        com.google.android.gms.analytics.zzr.zzh();
        if (zzceVar.zzd != null) {
            zzceVar.zzd = null;
            zzceVar.zzO("Disconnected from device AnalyticsService", componentName);
            zzceVar.zzs().zzk();
        }
    }

    static /* synthetic */ void zzi(zzce zzceVar, zzfa zzfaVar) {
        com.google.android.gms.analytics.zzr.zzh();
        zzceVar.zzd = zzfaVar;
        zzceVar.zzj();
        zzceVar.zzs().zzj();
    }

    private final void zzj() {
        this.zzc.zzb();
        zzcy zzcyVar = this.zzb;
        zzw();
        zzcyVar.zzg(((Long) zzew.zzK.zzb()).longValue());
    }

    public final void zzc() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        try {
            ConnectionTracker.getInstance().unbindService(zzo(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.zzd != null) {
            this.zzd = null;
            zzs().zzk();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
    }

    public final boolean zze() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        zzfa zzfaVar = this.zzd;
        if (zzfaVar == null) {
            return false;
        }
        try {
            zzfaVar.zze();
            zzj();
            return true;
        } catch (RemoteException unused) {
            zzN("Failed to clear hits from AnalyticsService");
            return false;
        }
    }

    public final boolean zzf() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        if (this.zzd != null) {
            return true;
        }
        zzfa zzfaVarZza = this.zza.zza();
        if (zzfaVarZza == null) {
            return false;
        }
        this.zzd = zzfaVarZza;
        zzj();
        return true;
    }

    public final boolean zzg() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        return this.zzd != null;
    }

    public final boolean zzh(zzez zzezVar) {
        String strZzk;
        Preconditions.checkNotNull(zzezVar);
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        zzfa zzfaVar = this.zzd;
        if (zzfaVar == null) {
            return false;
        }
        if (zzezVar.zzh()) {
            zzw();
            strZzk = zzcv.zzi();
        } else {
            zzw();
            strZzk = zzcv.zzk();
        }
        try {
            zzfaVar.zzf(zzezVar.zzg(), zzezVar.zzd(), strZzk, Collections.emptyList());
            zzj();
            return true;
        } catch (RemoteException unused) {
            zzN("Failed to send hits to AnalyticsService");
            return false;
        }
    }
}
