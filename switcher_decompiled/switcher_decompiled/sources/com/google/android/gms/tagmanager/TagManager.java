package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public class TagManager {
    private static TagManager zza;
    private final zzfo zzb;
    private final Context zzc;
    private final DataLayer zzd;
    private final zzex zze;
    private final ConcurrentMap zzf;
    private final zzao zzg;

    TagManager(Context context, zzfo zzfoVar, DataLayer dataLayer, zzex zzexVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzc = applicationContext;
        this.zze = zzexVar;
        this.zzb = zzfoVar;
        this.zzf = new ConcurrentHashMap();
        this.zzd = dataLayer;
        dataLayer.zzg(new zzfl(this));
        dataLayer.zzg(new zzg(applicationContext));
        this.zzg = new zzao();
        Preconditions.checkNotNull(applicationContext);
        applicationContext.registerComponentCallbacks(new zzfn(this));
        Preconditions.checkNotNull(applicationContext);
        zzd.zzb(applicationContext);
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zza == null) {
                if (context == null) {
                    Log.e("GoogleTagManager", "TagManager.getInstance requires non-null context.");
                    throw null;
                }
                zza = new TagManager(context, new zzfm(), new DataLayer(new zzbd(context)), zzfe.zzg());
            }
            tagManager = zza;
        }
        return tagManager;
    }

    static /* bridge */ /* synthetic */ void zzb(TagManager tagManager, String str) {
        Preconditions.checkNotNull(tagManager.zzf);
        Iterator it = tagManager.zzf.values().iterator();
        while (it.hasNext()) {
            ((zzz) it.next()).zzd(str);
        }
    }

    public void dispatch() {
        this.zze.zza();
    }

    public DataLayer getDataLayer() {
        return this.zzd;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        zzak zzakVar = new zzak(this.zzc, this, null, str, i, this.zzg);
        zzakVar.zzl();
        return zzakVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        zzak zzakVar = new zzak(this.zzc, this, null, str, i, this.zzg);
        zzakVar.zzm();
        return zzakVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        zzak zzakVar = new zzak(this.zzc, this, null, str, i, this.zzg);
        zzakVar.zzn();
        return zzakVar;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        int i = true != z ? 5 : 2;
        zzdg.zza = i;
        zzdg.zzb.zzc(i);
    }

    public final int zza(zzz zzzVar) {
        this.zzf.put(zzzVar.zza(), zzzVar);
        return this.zzf.size();
    }

    public final boolean zzc(zzz zzzVar) {
        return this.zzf.remove(zzzVar.zza()) != null;
    }

    final synchronized boolean zzd(Uri uri) {
        zzdz zzdzVarZza = zzdz.zza();
        if (!zzdzVarZza.zzd(uri)) {
            return false;
        }
        String strZzc = zzdzVarZza.zzc();
        int iZze = zzdzVarZza.zze();
        int i = iZze - 1;
        if (iZze == 0) {
            throw null;
        }
        if (i == 0) {
            zzz zzzVar = (zzz) this.zzf.get(strZzc);
            if (zzzVar != null) {
                zzzVar.zze(null);
                zzzVar.refresh();
            }
        } else if (i == 1 || i == 2) {
            for (String str : this.zzf.keySet()) {
                zzz zzzVar2 = (zzz) this.zzf.get(str);
                if (str.equals(strZzc)) {
                    zzzVar2.zze(zzdzVarZza.zzb());
                    zzzVar2.refresh();
                } else if (zzzVar2.zzb() != null) {
                    zzzVar2.zze(null);
                    zzzVar2.refresh();
                }
            }
        }
        return true;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        zzak zzakVar = new zzak(this.zzc, this, handler.getLooper(), str, i, this.zzg);
        zzakVar.zzl();
        return zzakVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        zzak zzakVar = new zzak(this.zzc, this, handler.getLooper(), str, i, this.zzg);
        zzakVar.zzm();
        return zzakVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        zzak zzakVar = new zzak(this.zzc, this, handler.getLooper(), str, i, this.zzg);
        zzakVar.zzn();
        return zzakVar;
    }
}
