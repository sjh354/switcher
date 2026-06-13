package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhv extends zzia {
    zzhv(zzhx zzhxVar, String str, Double d, boolean z) {
        super(zzhxVar, "measurement.test.double_flag", d, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzia
    @Nullable
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            Log.e("PhenotypeFlag", "Invalid double value for " + super.zzc() + ": " + ((String) obj));
            return null;
        }
    }
}
