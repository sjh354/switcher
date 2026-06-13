package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzft extends Number implements Comparable {
    private double zza;
    private long zzb;
    private final boolean zzc = false;

    private zzft(double d) {
        this.zza = d;
    }

    public static zzft zzc(Double d) {
        return new zzft(d.doubleValue());
    }

    public static zzft zzd(long j) {
        return new zzft(j);
    }

    public static zzft zze(String str) throws NumberFormatException {
        try {
            try {
                return new zzft(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                throw new NumberFormatException(String.valueOf(str).concat(" is not a valid TypedNumber"));
            }
        } catch (NumberFormatException unused2) {
            return new zzft(Double.parseDouble(str));
        }
    }

    @Override // java.lang.Number
    public final byte byteValue() {
        return (byte) zzb();
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return this.zzc ? this.zzb : this.zza;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzft) && compareTo((zzft) obj) == 0;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(zzb()).hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) zzb();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return zzb();
    }

    @Override // java.lang.Number
    public final short shortValue() {
        return (short) zzb();
    }

    public final String toString() {
        return this.zzc ? Long.toString(this.zzb) : Double.toString(this.zza);
    }

    public final long zzb() {
        return this.zzc ? this.zzb : (long) this.zza;
    }

    public final boolean zzf() {
        return !this.zzc;
    }

    public final boolean zzg() {
        return this.zzc;
    }

    private zzft(long j) {
        this.zzb = j;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzft zzftVar) {
        return (this.zzc && zzftVar.zzc) ? new Long(this.zzb).compareTo(Long.valueOf(zzftVar.zzb)) : Double.compare(doubleValue(), zzftVar.doubleValue());
    }
}
