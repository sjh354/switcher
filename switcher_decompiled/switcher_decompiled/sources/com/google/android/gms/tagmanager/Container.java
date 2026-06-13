package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzrv;
import com.google.android.gms.internal.gtm.zzsc;
import com.google.android.gms.internal.gtm.zzsd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class Container {
    private final Context zza;
    private final String zzb;
    private final DataLayer zzc;
    private zzet zzd;
    private Map zze;
    private Map zzf;
    private volatile long zzg;
    private volatile String zzh;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    Container(Context context, DataLayer dataLayer, String str, long j, com.google.android.gms.internal.gtm.zzak zzakVar) throws InterruptedException {
        this.zze = new HashMap();
        this.zzf = new HashMap();
        this.zzh = "";
        this.zza = context;
        this.zzc = dataLayer;
        this.zzb = str;
        this.zzg = j;
        com.google.android.gms.internal.gtm.zzac zzacVarZzc = zzakVar.zzc();
        zzacVarZzc.getClass();
        try {
            zzg(zzsd.zzb(zzacVarZzc));
        } catch (zzsc e) {
            Log.e("GoogleTagManager", "Not loading resource: " + zzacVarZzc.toString() + " because it is invalid: " + e.toString());
        }
        if (zzakVar.zza() != 0) {
            com.google.android.gms.internal.gtm.zzai[] zzaiVarArr = (com.google.android.gms.internal.gtm.zzai[]) zzakVar.zzi().toArray(new com.google.android.gms.internal.gtm.zzai[0]);
            zzet zzetVarZzf = zzf();
            if (zzetVarZzf == null) {
                Log.e("GoogleTagManager", "evaluateTags called for closed container.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.gtm.zzai zzaiVar : zzaiVarArr) {
                arrayList.add(zzaiVar);
            }
            zzetVarZzf.zze(arrayList);
        }
    }

    private final synchronized zzet zzf() {
        return this.zzd;
    }

    private final void zzg(zzrv zzrvVar) throws InterruptedException {
        this.zzh = zzrvVar.zzb();
        zzh(new zzet((Context) Preconditions.checkNotNull(this.zza), zzrvVar, (DataLayer) Preconditions.checkNotNull(this.zzc), new zzu(this, null), new zzw(this, null), new zzdk(), null));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzc.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", Preconditions.checkNotNull(this.zzb)));
        }
    }

    private final synchronized void zzh(zzet zzetVar) {
        this.zzd = zzetVar;
    }

    public boolean getBoolean(String str) {
        zzet zzetVarZzf = zzf();
        if (zzetVarZzf == null) {
            Log.e("GoogleTagManager", "getBoolean called for closed container.");
            return zzfu.zzf().booleanValue();
        }
        try {
            return zzfu.zzg(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzetVarZzf.zza(str).zza())).booleanValue();
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzfu.zzf().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzb;
    }

    public double getDouble(String str) {
        zzet zzetVarZzf = zzf();
        if (zzetVarZzf == null) {
            Log.e("GoogleTagManager", "getDouble called for closed container.");
            return zzfu.zzh().doubleValue();
        }
        try {
            return zzfu.zzi(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzetVarZzf.zza(str).zza())).doubleValue();
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzfu.zzh().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzg;
    }

    public long getLong(String str) {
        zzet zzetVarZzf = zzf();
        if (zzetVarZzf == null) {
            Log.e("GoogleTagManager", "getLong called for closed container.");
            return zzfu.zzj().longValue();
        }
        try {
            return zzfu.zzk(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzetVarZzf.zza(str).zza())).longValue();
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzfu.zzj().longValue();
        }
    }

    public String getString(String str) {
        zzet zzetVarZzf = zzf();
        if (zzetVarZzf == null) {
            Log.e("GoogleTagManager", "getString called for closed container.");
            return zzfu.zzm();
        }
        try {
            return zzfu.zzn(zzfu.zzl((com.google.android.gms.internal.gtm.zzam) zzetVarZzf.zza(str).zza()));
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzfu.zzm();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zze) {
            this.zze.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzf) {
            this.zzf.put(str, functionCallTagCallback);
        }
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zze) {
            this.zze.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzf) {
            this.zzf.remove(str);
        }
    }

    final FunctionCallMacroCallback zza(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zze) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zze.get(str);
        }
        return functionCallMacroCallback;
    }

    public final FunctionCallTagCallback zzb(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzf) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzf.get(str);
        }
        return functionCallTagCallback;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final void zzd(String str) {
        zzet zzetVarZzf = zzf();
        if (zzetVarZzf == null) {
            Log.e("GoogleTagManager", "evaluateTags called for closed container.");
        } else {
            zzetVarZzf.zzc(str);
        }
    }

    final void zze() {
        this.zzd = null;
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzrv zzrvVar) throws InterruptedException {
        this.zze = new HashMap();
        this.zzf = new HashMap();
        this.zzh = "";
        this.zza = context;
        this.zzc = dataLayer;
        this.zzb = str;
        this.zzg = 0L;
        zzg(zzrvVar);
    }
}
