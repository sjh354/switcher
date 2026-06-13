package com.google.android.gms.internal.firebase_messaging;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzn implements zzs {
    private final int zza;
    private final zzr zzb;

    zzn(int i, zzr zzrVar) {
        this.zza = i;
        this.zzb = zzrVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class<? extends Annotation> annotationType() {
        return zzs.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        return this.zza == zzsVar.zza() && this.zzb.equals(zzsVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzs
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzs
    public final zzr zzb() {
        return this.zzb;
    }
}
