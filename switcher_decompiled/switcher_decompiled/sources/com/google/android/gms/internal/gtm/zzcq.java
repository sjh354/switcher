package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcq implements Parcelable.Creator {
    zzcq() {
    }

    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzcr(parcel);
    }

    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcr[i];
    }
}
