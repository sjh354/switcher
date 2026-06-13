package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzgy extends ContentObserver {
    zzgy(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzgz.zzk.set(true);
    }
}
