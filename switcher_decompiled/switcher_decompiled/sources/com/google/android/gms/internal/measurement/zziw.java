package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
/* JADX INFO: loaded from: classes.dex */
abstract class zziw implements zziy {
    zziw() {
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return Byte.valueOf(zza());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
