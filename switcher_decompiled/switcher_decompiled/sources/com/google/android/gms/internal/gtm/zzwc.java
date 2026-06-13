package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzwc extends zzbfb implements zzbgt {
    private static final zzwc zza;
    private zzvg zzA;
    private int zzf;
    private int zzg;
    private zzvi zzh;
    private boolean zzj;
    private long zzk;
    private double zzl;
    private zzvx zzn;
    private long zzp;
    private zzvq zzt;
    private long zzx;
    private zzvk zzy;
    private zzvo zzz;
    private byte zzC = 2;
    private String zzi = "";
    private String zzm = "";
    private String zzo = "";
    private String zzq = "";
    private String zzr = "";
    private zzbbw zzs = zzbbw.zzb;
    private String zzu = "";
    private zzbfp zzv = zzaj();
    private zzbfp zzw = zzaj();
    private zzbfo zzB = zzai();

    static {
        zzwc zzwcVar = new zzwc();
        zza = zzwcVar;
        zzbff.zzan(zzwc.class, zzwcVar);
    }

    private zzwc() {
    }

    @Override // com.google.android.gms.internal.gtm.zzbff
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzC);
        }
        if (i2 == 2) {
            return zzam(zza, "\u0001\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0003\u0006\u0001ဃ\u000f\u0002ဌ\u0000\u0003ᐉ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006ဂ\u0004\u0007က\u0005\bဈ\u0006\tᐉ\u0007\nဈ\b\u000bဈ\n\fဈ\u000b\rည\f\u000eဈ\u000e\u000fЛ\u0010ဉ\u0010\u0011ᐉ\u0011\u0012ဂ\t\u0013ဉ\u0012\u0015\u0015\u0016Л\u0017ᐉ\r", new Object[]{"zzf", "zzx", "zzg", zzwb.zzc(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzq", "zzr", "zzs", "zzu", "zzv", zzbrv.class, "zzy", "zzz", "zzp", "zzA", "zzB", "zzw", zzbrv.class, "zzt"});
        }
        if (i2 == 3) {
            return new zzwc();
        }
        zzve zzveVar = null;
        if (i2 == 4) {
            return new zzvy(zzveVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzC = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
