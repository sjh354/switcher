package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.gtm.zzrn;
import com.google.android.gms.internal.gtm.zzro;
import com.google.android.gms.internal.gtm.zzrp;
import com.google.android.gms.internal.gtm.zzrv;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzak extends BasePendingResult {
    private final Clock zza;
    private final zzah zzb;
    private final Looper zzc;
    private final zzeb zzd;
    private final int zze;
    private final Context zzf;
    private final TagManager zzg;
    private final String zzh;
    private final zzal zzi;
    private zzaj zzj;
    private final zzrp zzk;
    private volatile zzz zzl;
    private volatile boolean zzm;
    private com.google.android.gms.internal.gtm.zzak zzn;
    private long zzo;
    private String zzp;
    private zzai zzq;
    private zzab zzr;

    public zzak(Context context, TagManager tagManager, Looper looper, String str, int i, zzao zzaoVar) {
        zzel zzelVar = new zzel(context, str);
        zzei zzeiVar = new zzei(context, str, zzaoVar, null, null, null);
        zzrp zzrpVar = new zzrp(context);
        Clock defaultClock = DefaultClock.getInstance();
        zzde zzdeVar = new zzde(1, 5, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, BootloaderScanner.TIMEOUT, "refreshing", DefaultClock.getInstance());
        zzal zzalVar = new zzal(context, str);
        super(looper == null ? Looper.getMainLooper() : looper);
        this.zzf = context;
        this.zzg = tagManager;
        this.zzc = looper == null ? Looper.getMainLooper() : looper;
        this.zzh = str;
        this.zze = i;
        this.zzj = zzelVar;
        this.zzq = zzeiVar;
        this.zzk = zzrpVar;
        this.zzb = new zzah(this, null);
        this.zzn = com.google.android.gms.internal.gtm.zzak.zzf();
        this.zza = defaultClock;
        this.zzd = zzdeVar;
        this.zzi = zzalVar;
        if (zzv()) {
            zzo(zzdz.zza().zzb());
        }
        zzaoVar.zza();
    }

    static /* bridge */ /* synthetic */ boolean zzp(zzak zzakVar) {
        boolean z = zzakVar.zzm;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzr(long j) {
        zzai zzaiVar = this.zzq;
        if (zzaiVar == null) {
            Log.w("GoogleTagManager", "Refresh requested, but no network load scheduler.");
        } else {
            zzaiVar.zza(j, this.zzn.zzh());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzs(boolean z) {
        this.zzj.zzd(new zzad(this, null));
        this.zzq.zzc(new zzaf(this, 0 == true ? 1 : 0));
        zzrv zzrvVarZza = this.zzj.zza(this.zze);
        if (zzrvVarZza != null) {
            TagManager tagManager = this.zzg;
            this.zzl = new zzz(tagManager, this.zzc, new Container(this.zzf, tagManager.getDataLayer(), this.zzh, 0L, zzrvVarZza), this.zzb);
        }
        this.zzr = new zzab(this, z);
        if (zzv()) {
            this.zzq.zza(0L, "");
        } else {
            this.zzj.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzt(com.google.android.gms.internal.gtm.zzak zzakVar) {
        if (this.zzj != null) {
            zzrn zzrnVarZze = zzro.zze();
            zzrnVarZze.zzc(0L);
            zzrnVarZze.zza(com.google.android.gms.internal.gtm.zzac.zzk());
            zzrnVarZze.zzc(this.zzo);
            zzrnVarZze.zza(com.google.android.gms.internal.gtm.zzac.zzk());
            zzrnVarZze.zzb(zzakVar);
            this.zzj.zzc((zzro) zzrnVarZze.zzC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzu(com.google.android.gms.internal.gtm.zzak zzakVar, long j, boolean z) {
        if (isReady() && this.zzl == null) {
            return;
        }
        this.zzn = zzakVar;
        this.zzo = j;
        long jZza = this.zzi.zza();
        zzr(Math.max(0L, Math.min(jZza, (this.zzo + jZza) - this.zza.currentTimeMillis())));
        Container container = new Container(this.zzf, this.zzg.getDataLayer(), this.zzh, j, zzakVar);
        if (this.zzl == null) {
            this.zzl = new zzz(this.zzg, this.zzc, container, this.zzb);
        } else {
            this.zzl.zzc(container);
        }
        if (isReady() || !this.zzr.zza(container)) {
            return;
        }
        setResult(this.zzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzv() {
        zzdz zzdzVarZza = zzdz.zza();
        return (zzdzVarZza.zze() == 2 || zzdzVarZza.zze() == 3) && this.zzh.equals(zzdzVarZza.zzc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final ContainerHolder createFailedResult(Status status) {
        if (this.zzl != null) {
            return this.zzl;
        }
        if (status == Status.RESULT_TIMEOUT) {
            Log.e("GoogleTagManager", "timer expired: setting result to failure");
        }
        return new zzz(status);
    }

    final synchronized String zzh() {
        return this.zzp;
    }

    public final void zzl() {
        zzrv zzrvVarZza = this.zzj.zza(this.zze);
        if (zzrvVarZza != null) {
            setResult(new zzz(this.zzg, this.zzc, new Container(this.zzf, this.zzg.getDataLayer(), this.zzh, 0L, zzrvVarZza), new zzaa(this)));
        } else {
            Log.e("GoogleTagManager", "Default was requested, but no default container was found");
            setResult(createFailedResult(new Status(10, "Default was requested, but no default container was found", (PendingIntent) null)));
        }
        this.zzq = null;
        this.zzj = null;
    }

    public final void zzm() {
        zzs(true);
    }

    public final void zzn() {
        zzs(false);
    }

    final synchronized void zzo(String str) {
        this.zzp = str;
        zzai zzaiVar = this.zzq;
        if (zzaiVar != null) {
            zzaiVar.zzb(str);
        }
    }
}
