package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzhr implements zzlg {
    final /* synthetic */ zzid zza;

    zzhr(zzid zzidVar) {
        this.zza = zzidVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlg
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzD(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle);
        } else {
            this.zza.zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_err", bundle, str);
        }
    }
}
