package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbin extends IllegalArgumentException {
    zzbin(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
