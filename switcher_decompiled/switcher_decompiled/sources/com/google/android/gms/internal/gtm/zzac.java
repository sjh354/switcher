package com.google.android.gms.internal.gtm;

import java.util.List;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzac extends zzbff implements zzbgt {
    private static final zzac zza;
    private int zzb;
    private zzs zzr;
    private float zzs;
    private boolean zzt;
    private int zzv;
    private byte zzw = 2;
    private zzbfp zzf = zzbff.zzaj();
    private zzbfp zzg = zzbff.zzaj();
    private zzbfp zzh = zzaj();
    private zzbfp zzi = zzaj();
    private zzbfp zzj = zzaj();
    private zzbfp zzk = zzaj();
    private zzbfp zzl = zzaj();
    private zzbfp zzm = zzaj();
    private String zzn = "";
    private String zzo = "";
    private String zzp = Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE;
    private String zzq = "";
    private zzbfp zzu = zzbff.zzaj();

    static {
        zzac zzacVar = new zzac();
        zza = zzacVar;
        zzbff.zzan(zzac.class, zzacVar);
    }

    private zzac() {
    }

    public static zzac zzk() {
        return zza;
    }

    public static zzac zzl(byte[] bArr, zzbep zzbepVar) throws zzbfs {
        return (zzac) zzbff.zzaf(zza, bArr, zzbepVar);
    }

    public final int zza() {
        return this.zzj.size();
    }

    public final int zzc() {
        return this.zzl.size();
    }

    public final int zzd() {
        return this.zzv;
    }

    public final int zze() {
        return this.zzk.size();
    }

    public final int zzf() {
        return this.zzh.size();
    }

    public final zzu zzg(int i) {
        return (zzu) this.zzj.get(i);
    }

    public final zzu zzh(int i) {
        return (zzu) this.zzl.get(i);
    }

    public final zzu zzi(int i) {
        return (zzu) this.zzk.get(i);
    }

    public final zzam zzm(int i) {
        return (zzam) this.zzh.get(i);
    }

    public final String zzn() {
        return this.zzq;
    }

    public final List zzo() {
        return this.zzg;
    }

    public final List zzp() {
        return this.zzi;
    }

    public final List zzq() {
        return this.zzm;
    }

    public final List zzr() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzw);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0011\u0000\u0001\u0001\u0013\u0011\u0000\t\u0005\u0001\u001a\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007\u001b\tဈ\u0000\nဈ\u0001\fဈ\u0002\rဈ\u0003\u000eဉ\u0004\u000fခ\u0005\u0010\u001a\u0011င\u0007\u0012ဇ\u0006\u0013\u001a", new Object[]{"zzb", "zzg", "zzh", zzam.class, "zzi", zzaa.class, "zzj", zzu.class, "zzk", zzu.class, "zzl", zzu.class, "zzm", zzae.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzu", "zzv", "zzt", "zzf"});
        }
        if (i2 == 3) {
            return new zzac();
        }
        zzn zznVar = null;
        if (i2 == 4) {
            return new zzab(zznVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzw = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
