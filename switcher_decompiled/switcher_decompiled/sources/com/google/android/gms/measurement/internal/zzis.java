package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzis extends zzf {
    protected zzik zza;
    private volatile zzik zzb;
    private volatile zzik zzc;
    private final Map zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzik zzg;
    private zzik zzh;
    private boolean zzi;
    private final Object zzj;

    public zzis(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzA(zzik zzikVar, zzik zzikVar2, long j, boolean z, Bundle bundle) {
        long j2;
        long j3;
        zzg();
        boolean z2 = false;
        boolean z3 = (zzikVar2 != null && zzikVar2.zzc == zzikVar.zzc && zzil.zza(zzikVar2.zzb, zzikVar.zzb) && zzil.zza(zzikVar2.zza, zzikVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzlh.zzK(zzikVar, bundle2, true);
            if (zzikVar2 != null) {
                String str = zzikVar2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zzikVar2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zzikVar2.zzc);
            }
            if (z2) {
                zzkg zzkgVar = this.zzs.zzu().zzb;
                long j4 = j - zzkgVar.zzb;
                zzkgVar.zzb = j;
                if (j4 > 0) {
                    this.zzs.zzv().zzI(bundle2, j4);
                }
            }
            if (!this.zzs.zzf().zzu()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != zzikVar.zze ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "app";
            long jCurrentTimeMillis = this.zzs.zzav().currentTimeMillis();
            if (zzikVar.zze) {
                j2 = jCurrentTimeMillis;
                long j5 = zzikVar.zzf;
                if (j5 != 0) {
                    j3 = j5;
                }
                this.zzs.zzq().zzH(str3, "_vs", j3, bundle2);
            } else {
                j2 = jCurrentTimeMillis;
            }
            j3 = j2;
            this.zzs.zzq().zzH(str3, "_vs", j3, bundle2);
        }
        if (z2) {
            zzB(this.zza, true, j);
        }
        this.zza = zzikVar;
        if (zzikVar.zze) {
            this.zzh = zzikVar;
        }
        this.zzs.zzt().zzG(zzikVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzB(zzik zzikVar, boolean z, long j) {
        this.zzs.zzd().zzf(this.zzs.zzav().elapsedRealtime());
        if (!this.zzs.zzu().zzb.zzd(zzikVar != null && zzikVar.zzd, z, j) || zzikVar == null) {
            return;
        }
        zzikVar.zzd = false;
    }

    static /* bridge */ /* synthetic */ void zzp(zzis zzisVar, Bundle bundle, zzik zzikVar, zzik zzikVar2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzisVar.zzA(zzikVar, zzikVar2, j, true, zzisVar.zzs.zzv().zzy(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    private final zzik zzy(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzik zzikVar = (zzik) this.zzd.get(activity);
        if (zzikVar == null) {
            zzik zzikVar2 = new zzik(null, zzl(activity.getClass(), "Activity"), this.zzs.zzv().zzq());
            this.zzd.put(activity, zzikVar2);
            zzikVar = zzikVar2;
        }
        return this.zzg != null ? this.zzg : zzikVar;
    }

    private final void zzz(Activity activity, zzik zzikVar, boolean z) {
        zzik zzikVar2;
        zzik zzikVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzikVar.zzb == null) {
            zzikVar2 = new zzik(zzikVar.zza, activity != null ? zzl(activity.getClass(), "Activity") : null, zzikVar.zzc, zzikVar.zze, zzikVar.zzf);
        } else {
            zzikVar2 = zzikVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzikVar2;
        this.zzs.zzaz().zzp(new zzin(this, zzikVar2, zzikVar3, this.zzs.zzav().elapsedRealtime(), z));
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final zzik zzi() {
        return this.zzb;
    }

    public final zzik zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zzik zzikVar = this.zza;
        return zzikVar != null ? zzikVar : this.zzh;
    }

    final String zzl(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        this.zzs.zzf();
        if (length2 <= 100) {
            return str2;
        }
        this.zzs.zzf();
        return str2.substring(0, 100);
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzs.zzf().zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzik(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzs.zzf().zzu()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = this.zzs.zzav().elapsedRealtime();
        if (!this.zzs.zzf().zzu()) {
            this.zzb = null;
            this.zzs.zzaz().zzp(new zzip(this, jElapsedRealtime));
        } else {
            zzik zzikVarZzy = zzy(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            this.zzs.zzaz().zzp(new zziq(this, zzikVarZzy, jElapsedRealtime));
        }
    }

    public final void zzu(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzs.zzf().zzu()) {
                    this.zzg = null;
                    this.zzs.zzaz().zzp(new zzir(this));
                }
            }
        }
        if (!this.zzs.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzs.zzaz().zzp(new zzio(this));
        } else {
            zzz(activity, zzy(activity), false);
            zzd zzdVarZzd = this.zzs.zzd();
            zzdVarZzd.zzs.zzaz().zzp(new zzc(zzdVarZzd, zzdVarZzd.zzs.zzav().elapsedRealtime()));
        }
    }

    public final void zzv(Activity activity, Bundle bundle) {
        zzik zzikVar;
        if (!this.zzs.zzf().zzu() || bundle == null || (zzikVar = (zzik) this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzikVar.zzc);
        bundle2.putString("name", zzikVar.zza);
        bundle2.putString("referrer_name", zzikVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r5.length() <= 100) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r6.length() <= 100) goto L39;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzw(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzis.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r2 > 100) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r4 > 100) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzis.zzx(android.os.Bundle, long):void");
    }
}
