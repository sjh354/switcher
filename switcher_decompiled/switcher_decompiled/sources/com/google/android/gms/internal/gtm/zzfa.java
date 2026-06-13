package com.google.android.gms.internal.gtm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzfa extends zzau implements IInterface {
    zzfa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    public final void zze() throws RemoteException {
        zzl(2, zza());
    }

    public final void zzf(Map map, long j, String str, List list) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeMap(map);
        parcelZza.writeLong(j);
        parcelZza.writeString(str);
        parcelZza.writeTypedList(list);
        zzl(1, parcelZza);
    }
}
