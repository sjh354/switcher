package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
final class zznb extends IllegalArgumentException {
    zznb(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
