package com.google.android.gms.analytics;

import android.os.Process;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzq extends Thread {
    zzq(Runnable runnable, String str) {
        super(runnable, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
