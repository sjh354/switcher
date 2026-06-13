package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbck {
    private final zzbcj zza;

    private zzbck(zzbcj zzbcjVar) {
        zzbfq.zzf(zzbcjVar, "output");
        this.zza = zzbcjVar;
        zzbcjVar.zze = this;
    }

    public static zzbck zza(zzbcj zzbcjVar) {
        zzbck zzbckVar = zzbcjVar.zze;
        return zzbckVar != null ? zzbckVar : new zzbck(zzbcjVar);
    }

    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzD(int i, long j) throws IOException {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzs(i, 3);
    }

    public final void zzG(int i, String str) throws IOException {
        this.zza.zzq(i, str);
    }

    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzbga)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzbga zzbgaVar = (zzbga) list;
        while (i2 < list.size()) {
            Object objZzf = zzbgaVar.zzf(i2);
            if (objZzf instanceof String) {
                this.zza.zzq(i, (String) objZzf);
            } else {
                this.zza.zzU(i, (zzbbw) objZzf);
            }
            i2++;
        }
    }

    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzt(i, i2);
    }

    public final void zzK(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzT(i, z);
    }

    public final void zzd(int i, zzbbw zzbbwVar) throws IOException {
        this.zza.zzU(i, zzbbwVar);
    }

    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzU(i, (zzbbw) list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzs(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zzq(int i, Object obj, zzbhf zzbhfVar) throws IOException {
        zzbcj zzbcjVar = this.zza;
        zzbcjVar.zzs(i, 3);
        zzbhfVar.zzn((zzbgs) obj, zzbcjVar.zze);
        zzbcjVar.zzs(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    public final void zzv(int i, Object obj, zzbhf zzbhfVar) throws IOException {
        this.zza.zzn(i, (zzbgs) obj, zzbhfVar);
    }

    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzbbw) {
            this.zza.zzp(i, (zzbbw) obj);
        } else {
            this.zza.zzo(i, (zzbgs) obj);
        }
    }

    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzz(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzu(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzbcj zzbcjVar = this.zza;
                int iIntValue = ((Integer) list.get(i2)).intValue();
                zzbcjVar.zzt(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iZzJ += zzbcj.zzJ((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.zza.zzu(iZzJ);
        while (i2 < list.size()) {
            zzbcj zzbcjVar2 = this.zza;
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            zzbcjVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i2++;
        }
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzbcj zzbcjVar = this.zza;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzbcjVar.zzv(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzK += zzbcj.zzK((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.zza.zzu(iZzK);
        while (i2 < list.size()) {
            zzbcj zzbcjVar2 = this.zza;
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzbcjVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzJ += zzbcj.zzJ(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzu(iZzJ);
        while (i2 < list.size()) {
            this.zza.zzu(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzK += zzbcj.zzK(((Long) list.get(i3)).longValue());
        }
        this.zza.zzu(iZzK);
        while (i2 < list.size()) {
            this.zza.zzw(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzT(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.zza.zzu(i3);
        while (i2 < list.size()) {
            this.zza.zzS(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzC = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzC += zzbcj.zzC(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzu(iZzC);
        while (i2 < list.size()) {
            this.zza.zzm(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzu(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.zza.zzu(i3);
        while (i2 < list.size()) {
            this.zza.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzC = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzC += zzbcj.zzC(((Integer) list.get(i3)).intValue());
        }
        this.zza.zzu(iZzC);
        while (i2 < list.size()) {
            this.zza.zzm(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int iZzK = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzK += zzbcj.zzK(((Long) list.get(i3)).longValue());
        }
        this.zza.zzu(iZzK);
        while (i2 < list.size()) {
            this.zza.zzw(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.zza.zzu(i3);
        while (i2 < list.size()) {
            this.zza.zzi(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.zza.zzu(i3);
        while (i2 < list.size()) {
            this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        this.zza.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.zza.zzu(i3);
        while (i2 < list.size()) {
            this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }
}
