package com.google.android.gms.internal.gtm;

import cz.msebera.android.httpclient.HttpStatus;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzakx implements zzbfh {
    PRECISION_CENTURY(100),
    PRECISION_DECADE(200),
    PRECISION_YEAR(HttpStatus.SC_MULTIPLE_CHOICES),
    PRECISION_MONTH(HttpStatus.SC_BAD_REQUEST),
    PRECISION_DAY(500),
    PRECISION_HOUR(600),
    PRECISION_MINUTE(700),
    PRECISION_SECOND(800);

    private static final zzbfi zzi = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzakv
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzakx.zzb(i);
        }
    };
    private final int zzk;

    zzakx(int i) {
        this.zzk = i;
    }

    public static zzakx zzb(int i) {
        if (i == 100) {
            return PRECISION_CENTURY;
        }
        if (i == 200) {
            return PRECISION_DECADE;
        }
        if (i == 300) {
            return PRECISION_YEAR;
        }
        if (i == 400) {
            return PRECISION_MONTH;
        }
        if (i == 500) {
            return PRECISION_DAY;
        }
        if (i == 600) {
            return PRECISION_HOUR;
        }
        if (i == 700) {
            return PRECISION_MINUTE;
        }
        if (i != 800) {
            return null;
        }
        return PRECISION_SECOND;
    }

    public static zzbfj zzc() {
        return zzakw.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzk);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzk;
    }
}
