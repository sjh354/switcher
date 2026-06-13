package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbhy extends RuntimeException {
    public zzbhy(zzbgs zzbgsVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzbfs zza() {
        return new zzbfs(getMessage());
    }
}
