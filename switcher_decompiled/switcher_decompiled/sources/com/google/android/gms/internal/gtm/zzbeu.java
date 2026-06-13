package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbeu {
    private static final zzbeu zzb = new zzbeu(true);
    final zzbhs zza = new zzbhi(16);
    private boolean zzc;
    private boolean zzd;

    private zzbeu() {
    }

    static int zza(zzbip zzbipVar, int i, Object obj) {
        int iZzI = zzbcj.zzI(i);
        if (zzbipVar == zzbip.GROUP) {
            zzbfq.zzi((zzbgs) obj);
            iZzI += iZzI;
        }
        zzbiq zzbiqVar = zzbiq.INT;
        int iZzK = 4;
        switch (zzbipVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                iZzK = 8;
                return iZzI + iZzK;
            case FLOAT:
                ((Float) obj).floatValue();
                return iZzI + iZzK;
            case INT64:
                iZzK = zzbcj.zzK(((Long) obj).longValue());
                return iZzI + iZzK;
            case UINT64:
                iZzK = zzbcj.zzK(((Long) obj).longValue());
                return iZzI + iZzK;
            case INT32:
                iZzK = zzbcj.zzC(((Integer) obj).intValue());
                return iZzI + iZzK;
            case FIXED64:
                ((Long) obj).longValue();
                iZzK = 8;
                return iZzI + iZzK;
            case FIXED32:
                ((Integer) obj).intValue();
                return iZzI + iZzK;
            case BOOL:
                ((Boolean) obj).booleanValue();
                iZzK = 1;
                return iZzI + iZzK;
            case STRING:
                iZzK = obj instanceof zzbbw ? zzbcj.zzz((zzbbw) obj) : zzbcj.zzH((String) obj);
                return iZzI + iZzK;
            case GROUP:
                iZzK = zzbcj.zzB((zzbgs) obj);
                return iZzI + iZzK;
            case MESSAGE:
                iZzK = obj instanceof zzbfx ? zzbcj.zzD((zzbfx) obj) : zzbcj.zzE((zzbgs) obj);
                return iZzI + iZzK;
            case BYTES:
                iZzK = obj instanceof zzbbw ? zzbcj.zzz((zzbbw) obj) : zzbcj.zzy((byte[]) obj);
                return iZzI + iZzK;
            case UINT32:
                iZzK = zzbcj.zzJ(((Integer) obj).intValue());
                return iZzI + iZzK;
            case ENUM:
                iZzK = obj instanceof zzbfh ? zzbcj.zzC(((zzbfh) obj).zza()) : zzbcj.zzC(((Integer) obj).intValue());
                return iZzI + iZzK;
            case SFIXED32:
                ((Integer) obj).intValue();
                return iZzI + iZzK;
            case SFIXED64:
                ((Long) obj).longValue();
                iZzK = 8;
                return iZzI + iZzK;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                iZzK = zzbcj.zzJ((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZzI + iZzK;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                iZzK = zzbcj.zzK((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZzI + iZzK;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zzb(zzbet zzbetVar, Object obj) {
        zzbip zzbipVarZzd = zzbetVar.zzd();
        int iZza = zzbetVar.zza();
        if (!zzbetVar.zzg()) {
            return zza(zzbipVarZzd, iZza, obj);
        }
        zzbetVar.zzf();
        Iterator it = ((List) obj).iterator();
        int iZza2 = 0;
        while (it.hasNext()) {
            iZza2 += zza(zzbipVarZzd, iZza, it.next());
        }
        return iZza2;
    }

    public static zzbeu zze() {
        return zzb;
    }

    private static Object zzn(Object obj) {
        if (obj instanceof zzbgx) {
            return ((zzbgx) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzo(Map.Entry entry) {
        zzbgs zzbgsVarZzC;
        zzbet zzbetVar = (zzbet) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzbfx) {
            throw null;
        }
        if (zzbetVar.zzg()) {
            Object objZzf = zzf(zzbetVar);
            if (objZzf == null) {
                objZzf = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZzf).add(zzn(it.next()));
            }
            this.zza.put(zzbetVar, objZzf);
            return;
        }
        if (zzbetVar.zze() != zzbiq.MESSAGE) {
            this.zza.put(zzbetVar, zzn(value));
            return;
        }
        Object objZzf2 = zzf(zzbetVar);
        if (objZzf2 == null) {
            this.zza.put(zzbetVar, zzn(value));
            return;
        }
        if (objZzf2 instanceof zzbgx) {
            zzbgsVarZzC = zzbetVar.zzc((zzbgx) objZzf2, (zzbgx) value);
        } else {
            zzbgr zzbgrVarZzat = ((zzbgs) objZzf2).zzat();
            zzbetVar.zzb(zzbgrVarZzat, (zzbgs) value);
            zzbgsVarZzC = zzbgrVarZzat.zzC();
        }
        this.zza.put(zzbetVar, zzbgsVarZzC);
    }

    private static boolean zzp(Map.Entry entry) {
        zzbet zzbetVar = (zzbet) entry.getKey();
        if (zzbetVar.zze() != zzbiq.MESSAGE) {
            return true;
        }
        if (!zzbetVar.zzg()) {
            return zzq(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzq(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzq(Object obj) {
        if (obj instanceof zzbgt) {
            return ((zzbgt) obj).zzaw();
        }
        if (obj instanceof zzbfx) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzr(Map.Entry entry) {
        int iZzJ;
        int iZzJ2;
        zzbet zzbetVar = (zzbet) entry.getKey();
        Object value = entry.getValue();
        if (zzbetVar.zze() != zzbiq.MESSAGE || zzbetVar.zzg()) {
            return zzb(zzbetVar, value);
        }
        zzbetVar.zzf();
        if (value instanceof zzbfx) {
            int iZza = ((zzbet) entry.getKey()).zza();
            int iZzJ3 = zzbcj.zzJ(8);
            int iZza2 = ((zzbfx) value).zza();
            iZzJ = iZzJ3 + iZzJ3 + zzbcj.zzJ(16) + zzbcj.zzJ(iZza);
            iZzJ2 = zzbcj.zzJ(24) + zzbcj.zzJ(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzbet) entry.getKey()).zza();
            int iZzJ4 = zzbcj.zzJ(8);
            iZzJ = iZzJ4 + iZzJ4 + zzbcj.zzJ(16) + zzbcj.zzJ(iZza3);
            iZzJ2 = zzbcj.zzJ(24) + zzbcj.zzE((zzbgs) value);
        }
        return iZzJ + iZzJ2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzs(com.google.android.gms.internal.gtm.zzbet r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.gtm.zzbip r0 = r4.zzd()
            com.google.android.gms.internal.gtm.zzbfq.zze(r5)
            com.google.android.gms.internal.gtm.zzbip r1 = com.google.android.gms.internal.gtm.zzbip.DOUBLE
            com.google.android.gms.internal.gtm.zzbiq r1 = com.google.android.gms.internal.gtm.zzbiq.INT
            com.google.android.gms.internal.gtm.zzbiq r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzbgs
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzbfx
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzbfh
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzbbw
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r5 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r5 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r5 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            r2 = 1
            com.google.android.gms.internal.gtm.zzbip r4 = r4.zzd()
            com.google.android.gms.internal.gtm.zzbiq r4 = r4.zza()
            r1[r2] = r4
            r4 = 2
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r1[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbeu.zzs(com.google.android.gms.internal.gtm.zzbet, java.lang.Object):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbeu) {
            return this.zza.equals(((zzbeu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int iZzr = 0;
        for (int i = 0; i < this.zza.zzb(); i++) {
            iZzr += zzr(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZzr += zzr((Map.Entry) it.next());
        }
        return iZzr;
    }

    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzbeu clone() {
        zzbeu zzbeuVar = new zzbeu();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzbeuVar.zzk((zzbet) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzbeuVar.zzk((zzbet) entry.getKey(), entry.getValue());
        }
        zzbeuVar.zzd = this.zzd;
        return zzbeuVar;
    }

    public final Object zzf(zzbet zzbetVar) {
        Object obj = this.zza.get(zzbetVar);
        if (!(obj instanceof zzbfx)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzg() {
        return this.zzd ? new zzbfw(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzh(zzbet zzbetVar, Object obj) {
        List arrayList;
        if (!((zzbfc) zzbetVar).zzd) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        zzs(zzbetVar, obj);
        Object objZzf = zzf(zzbetVar);
        if (objZzf == null) {
            arrayList = new ArrayList();
            this.zza.put(zzbetVar, arrayList);
        } else {
            arrayList = (List) objZzf;
        }
        arrayList.add(obj);
    }

    public final void zzi() {
        if (this.zzc) {
            return;
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzj(zzbeu zzbeuVar) {
        for (int i = 0; i < zzbeuVar.zza.zzb(); i++) {
            zzo(zzbeuVar.zza.zzg(i));
        }
        Iterator it = zzbeuVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzo((Map.Entry) it.next());
        }
    }

    public final void zzk(zzbet zzbetVar, Object obj) {
        if (!zzbetVar.zzg()) {
            zzs(zzbetVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzs(zzbetVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzbfx) {
            this.zzd = true;
        }
        this.zza.put(zzbetVar, obj);
    }

    public final boolean zzl() {
        return this.zzc;
    }

    public final boolean zzm() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzp(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzp((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzbeu(boolean z) {
        zzi();
        zzi();
    }
}
