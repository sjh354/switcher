package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzbez;
import com.google.android.gms.internal.gtm.zzbff;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbff<MessageType extends zzbff<MessageType, BuilderType>, BuilderType extends zzbez<MessageType, BuilderType>> extends zzbay<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzbia zzd = zzbia.zzc();
    protected int zze = -1;

    public static zzbfd zzab(zzbgs zzbgsVar, zzbgs zzbgsVar2, zzbfi zzbfiVar, int i, zzbip zzbipVar, boolean z, Class cls) {
        return new zzbfd(zzbgsVar, Collections.emptyList(), zzbgsVar2, new zzbfc(null, i, zzbipVar, true, false), cls);
    }

    public static zzbfd zzac(zzbgs zzbgsVar, Object obj, zzbgs zzbgsVar2, zzbfi zzbfiVar, int i, zzbip zzbipVar, Class cls) {
        return new zzbfd(zzbgsVar, obj, zzbgsVar2, new zzbfc(zzbfiVar, i, zzbipVar, false, false), cls);
    }

    static zzbff zzad(Class cls) {
        Map map = zza;
        zzbff zzbffVar = (zzbff) map.get(cls);
        if (zzbffVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzbffVar = (zzbff) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzbffVar == null) {
            zzbffVar = (zzbff) ((zzbff) zzbij.zze(cls)).zzb(6, null, null);
            if (zzbffVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzbffVar);
        }
        return zzbffVar;
    }

    protected static zzbff zzae(zzbff zzbffVar, InputStream inputStream, zzbep zzbepVar) throws zzbfs {
        zzbca zzbcaVar = new zzbca(inputStream, 4096, null);
        zzbff zzbffVar2 = (zzbff) zzbffVar.zzb(4, null, null);
        try {
            zzbhf zzbhfVarZzb = zzbhb.zza().zzb(zzbffVar2.getClass());
            zzbhfVarZzb.zzh(zzbffVar2, zzbcd.zzp(zzbcaVar), zzbepVar);
            zzbhfVarZzb.zzf(zzbffVar2);
            zzc(zzbffVar2);
            return zzbffVar2;
        } catch (zzbfs e) {
            e = e;
            if (e.zzl()) {
                e = new zzbfs(e);
            }
            e.zzh(zzbffVar2);
            throw e;
        } catch (zzbhy e2) {
            zzbfs zzbfsVarZza = e2.zza();
            zzbfsVarZza.zzh(zzbffVar2);
            throw zzbfsVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzbfs) {
                throw ((zzbfs) e3.getCause());
            }
            zzbfs zzbfsVar = new zzbfs(e3);
            zzbfsVar.zzh(zzbffVar2);
            throw zzbfsVar;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzbfs) {
                throw ((zzbfs) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzbff zzaf(zzbff zzbffVar, byte[] bArr, zzbep zzbepVar) throws zzbfs {
        zzbff zzbffVarZze = zze(zzbffVar, bArr, 0, bArr.length, zzbepVar);
        zzc(zzbffVarZze);
        return zzbffVarZze;
    }

    protected static zzbfk zzag() {
        return zzbew.zze();
    }

    protected static zzbfl zzah() {
        return zzbfg.zzf();
    }

    protected static zzbfo zzai() {
        return zzbgh.zzf();
    }

    protected static zzbfp zzaj() {
        return zzbhc.zze();
    }

    protected static zzbfp zzak(zzbfp zzbfpVar) {
        int size = zzbfpVar.size();
        return zzbfpVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzal(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzam(zzbgs zzbgsVar, String str, Object[] objArr) {
        return new zzbhd(zzbgsVar, str, objArr);
    }

    protected static void zzan(Class cls, zzbff zzbffVar) {
        zza.put(cls, zzbffVar);
    }

    protected static final boolean zzao(zzbff zzbffVar, boolean z) {
        byte bByteValue = ((Byte) zzbffVar.zzb(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzbhb.zza().zzb(zzbffVar.getClass()).zzk(zzbffVar);
        if (z) {
            zzbffVar.zzb(2, true != zZzk ? null : zzbffVar, null);
        }
        return zZzk;
    }

    private static zzbff zzc(zzbff zzbffVar) throws zzbfs {
        if (zzbffVar == null || zzbffVar.zzaw()) {
            return zzbffVar;
        }
        zzbfs zzbfsVarZza = new zzbhy(zzbffVar).zza();
        zzbfsVarZza.zzh(zzbffVar);
        throw zzbfsVarZza;
    }

    private static zzbff zze(zzbff zzbffVar, byte[] bArr, int i, int i2, zzbep zzbepVar) throws zzbfs {
        zzbff zzbffVar2 = (zzbff) zzbffVar.zzb(4, null, null);
        try {
            zzbhf zzbhfVarZzb = zzbhb.zza().zzb(zzbffVar2.getClass());
            zzbhfVarZzb.zzi(zzbffVar2, bArr, 0, i2, new zzbbf(zzbepVar));
            zzbhfVarZzb.zzf(zzbffVar2);
            if (zzbffVar2.zzc == 0) {
                return zzbffVar2;
            }
            throw new RuntimeException();
        } catch (zzbfs e) {
            e = e;
            if (e.zzl()) {
                e = new zzbfs(e);
            }
            e.zzh(zzbffVar2);
            throw e;
        } catch (zzbhy e2) {
            zzbfs zzbfsVarZza = e2.zza();
            zzbfsVarZza.zzh(zzbffVar2);
            throw zzbfsVarZza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzbfs) {
                throw ((zzbfs) e3.getCause());
            }
            zzbfs zzbfsVar = new zzbfs(e3);
            zzbfsVar.zzh(zzbffVar2);
            throw zzbfsVar;
        } catch (IndexOutOfBoundsException unused) {
            zzbfs zzbfsVarZzj = zzbfs.zzj();
            zzbfsVarZzj.zzh(zzbffVar2);
            throw zzbfsVarZzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzbhb.zza().zzb(getClass()).zzj(this, (zzbff) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int iZzb = zzbhb.zza().zzb(getClass()).zzb(this);
        this.zzc = iZzb;
        return iZzb;
    }

    public final String toString() {
        return zzbgu.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.gtm.zzbay
    final int zzQ() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.gtm.zzbay
    final void zzT(int i) {
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgs
    public final int zzY() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZza = zzbhb.zza().zzb(getClass()).zza(this);
        this.zze = iZza;
        return iZza;
    }

    protected final zzbez zzZ() {
        return (zzbez) zzb(5, null, null);
    }

    public final zzbez zzaa() {
        zzbez zzbezVar = (zzbez) zzb(5, null, null);
        zzbezVar.zzz(this);
        return zzbezVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgs
    public final /* synthetic */ zzbgr zzas() {
        return (zzbez) zzb(5, null, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzbgs
    public final /* synthetic */ zzbgr zzat() {
        zzbez zzbezVar = (zzbez) zzb(5, null, null);
        zzbezVar.zzz(this);
        return zzbezVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzbgs
    public final void zzau(zzbcj zzbcjVar) throws IOException {
        zzbhb.zza().zzb(getClass()).zzn(this, zzbck.zza(zzbcjVar));
    }

    @Override // com.google.android.gms.internal.gtm.zzbgt
    public final /* synthetic */ zzbgs zzav() {
        return (zzbff) zzb(6, null, null);
    }

    @Override // com.google.android.gms.internal.gtm.zzbgt
    public final boolean zzaw() {
        return zzao(this, Boolean.TRUE.booleanValue());
    }

    protected abstract Object zzb(int i, Object obj, Object obj2);
}
