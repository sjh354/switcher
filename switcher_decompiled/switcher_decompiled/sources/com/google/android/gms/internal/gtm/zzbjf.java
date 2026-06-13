package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbjf implements zzbfh {
    EC_NONE(0),
    EC_CROSS_PRODUCT_PERSONALIZATION(1),
    EC_3P_SHARING_APP_FUNCTIONALITY(9),
    EC_3P_SHARING_ANALYTICS(10),
    EC_3P_SHARING_DEVELOPER_COMMS(11),
    EC_3P_SHARING_FRAUD_SECURITY_COMPLIANCE(12),
    EC_3P_SHARING_ADVERTISING_MARKETING(13),
    EC_3P_SHARING_PERSONALIZATION(14),
    EC_3P_SHARING(2),
    EC_3P_SHARING_AGGREGATED(3),
    EC_ADS_DELIVERY(4),
    EC_ADS_GENERAL_TARGETING(5),
    EC_ADS_PERSONALIZATION(6),
    EC_ADS_MEASUREMENT(7),
    EC_ADS_EXTERNAL_INTEGRATION(8),
    EC_DEVELOPER_COMMS(15),
    EC_MARKETING_ENGAGEMENT_GROWTH_COMMS(16),
    EC_SEARCH_HISTORY(17),
    EC_VOICE_AND_APP_ACTIVITY_FOOTPRINTS(18),
    EC_PAY_OFFERS_AND_REWARDS(19),
    EC_PAY_PERSONALIZATION(20);

    private static final zzbfi zzv = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbjd
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbjf.zzc(i);
        }
    };
    private final int zzx;

    zzbjf(int i) {
        this.zzx = i;
    }

    public static zzbfj zzb() {
        return zzbje.zza;
    }

    public static zzbjf zzc(int i) {
        switch (i) {
            case 0:
                return EC_NONE;
            case 1:
                return EC_CROSS_PRODUCT_PERSONALIZATION;
            case 2:
                return EC_3P_SHARING;
            case 3:
                return EC_3P_SHARING_AGGREGATED;
            case 4:
                return EC_ADS_DELIVERY;
            case 5:
                return EC_ADS_GENERAL_TARGETING;
            case 6:
                return EC_ADS_PERSONALIZATION;
            case 7:
                return EC_ADS_MEASUREMENT;
            case 8:
                return EC_ADS_EXTERNAL_INTEGRATION;
            case 9:
                return EC_3P_SHARING_APP_FUNCTIONALITY;
            case 10:
                return EC_3P_SHARING_ANALYTICS;
            case 11:
                return EC_3P_SHARING_DEVELOPER_COMMS;
            case 12:
                return EC_3P_SHARING_FRAUD_SECURITY_COMPLIANCE;
            case 13:
                return EC_3P_SHARING_ADVERTISING_MARKETING;
            case 14:
                return EC_3P_SHARING_PERSONALIZATION;
            case 15:
                return EC_DEVELOPER_COMMS;
            case 16:
                return EC_MARKETING_ENGAGEMENT_GROWTH_COMMS;
            case 17:
                return EC_SEARCH_HISTORY;
            case 18:
                return EC_VOICE_AND_APP_ACTIVITY_FOOTPRINTS;
            case 19:
                return EC_PAY_OFFERS_AND_REWARDS;
            case 20:
                return EC_PAY_PERSONALIZATION;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzx);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzx;
    }
}
