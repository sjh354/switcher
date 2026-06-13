package com.google.android.gms.internal.measurement;

import android.os.Binder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzhh {
    public static Object zza(zzhi zzhiVar) {
        try {
            return zzhiVar.zza();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzhiVar.zza();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
