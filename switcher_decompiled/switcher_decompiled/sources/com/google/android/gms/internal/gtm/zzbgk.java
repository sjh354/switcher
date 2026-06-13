package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbgk implements zzbhg {
    private static final zzbgq zza = new zzbgi();
    private final zzbgq zzb;

    public zzbgk() {
        zzbgq zzbgqVar;
        zzbgq[] zzbgqVarArr = new zzbgq[2];
        zzbgqVarArr[0] = zzbey.zza();
        try {
            zzbgqVar = (zzbgq) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzbgqVar = zza;
        }
        zzbgqVarArr[1] = zzbgqVar;
        zzbgj zzbgjVar = new zzbgj(zzbgqVarArr);
        zzbfq.zzf(zzbgjVar, "messageInfoFactory");
        this.zzb = zzbgjVar;
    }

    private static boolean zzb(zzbgp zzbgpVar) {
        return zzbgpVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.gtm.zzbhg
    public final zzbhf zza(Class cls) {
        zzbhh.zzG(cls);
        zzbgp zzbgpVarZzb = this.zzb.zzb(cls);
        return zzbgpVarZzb.zzb() ? zzbff.class.isAssignableFrom(cls) ? zzbgw.zzc(zzbhh.zzB(), zzbes.zzb(), zzbgpVarZzb.zza()) : zzbgw.zzc(zzbhh.zzz(), zzbes.zza(), zzbgpVarZzb.zza()) : zzbff.class.isAssignableFrom(cls) ? zzb(zzbgpVarZzb) ? zzbgv.zzl(cls, zzbgpVarZzb, zzbgz.zzb(), zzbgg.zze(), zzbhh.zzB(), zzbes.zzb(), zzbgo.zzb()) : zzbgv.zzl(cls, zzbgpVarZzb, zzbgz.zzb(), zzbgg.zze(), zzbhh.zzB(), null, zzbgo.zzb()) : zzb(zzbgpVarZzb) ? zzbgv.zzl(cls, zzbgpVarZzb, zzbgz.zza(), zzbgg.zzd(), zzbhh.zzz(), zzbes.zza(), zzbgo.zza()) : zzbgv.zzl(cls, zzbgpVarZzb, zzbgz.zza(), zzbgg.zzd(), zzbhh.zzA(), null, zzbgo.zza());
    }
}
