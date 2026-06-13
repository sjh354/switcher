package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbjq implements zzbfh {
    RT_DEFAULT(0),
    RT_OBSOLETE(1),
    RT_WEEK(10),
    RT_MONTH(20),
    RT_5_WEEKS(21),
    RT_QUARTER(30),
    RT_HALF_A_YEAR(40),
    RT_YEAR(50),
    RT_16_MONTHS(58),
    RT_YEAR_AND_A_HALF(60),
    RT_2_YEARS(70),
    RT_3_YEARS(80),
    RT_ARCHIVAL(1000);

    private static final zzbfi zzn = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbjo
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbjq.zzc(i);
        }
    };
    private final int zzp;

    zzbjq(int i) {
        this.zzp = i;
    }

    public static zzbfj zzb() {
        return zzbjp.zza;
    }

    public static zzbjq zzc(int i) {
        if (i == 0) {
            return RT_DEFAULT;
        }
        if (i == 1) {
            return RT_OBSOLETE;
        }
        if (i == 10) {
            return RT_WEEK;
        }
        if (i == 30) {
            return RT_QUARTER;
        }
        if (i == 40) {
            return RT_HALF_A_YEAR;
        }
        if (i == 50) {
            return RT_YEAR;
        }
        if (i == 58) {
            return RT_16_MONTHS;
        }
        if (i == 60) {
            return RT_YEAR_AND_A_HALF;
        }
        if (i == 70) {
            return RT_2_YEARS;
        }
        if (i == 80) {
            return RT_3_YEARS;
        }
        if (i == 1000) {
            return RT_ARCHIVAL;
        }
        if (i == 20) {
            return RT_MONTH;
        }
        if (i != 21) {
            return null;
        }
        return RT_5_WEEKS;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzp);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzp;
    }
}
