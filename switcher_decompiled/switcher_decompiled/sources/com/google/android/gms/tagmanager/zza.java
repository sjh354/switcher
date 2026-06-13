package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zza implements zzc {
    final /* synthetic */ zzd zza;

    zza(zzd zzdVar) {
        this.zza = zzdVar;
    }

    @Override // com.google.android.gms.tagmanager.zzc
    public final AdvertisingIdClient.Info zza() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.zza.zzi);
        } catch (GooglePlayServicesNotAvailableException e) {
            this.zza.zze();
            Log.w("GoogleTagManager", "GooglePlayServicesNotAvailableException getting Advertising Id Info", e);
            return null;
        } catch (GooglePlayServicesRepairableException e2) {
            Log.w("GoogleTagManager", "GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            return null;
        } catch (IOException e3) {
            Log.w("GoogleTagManager", "IOException getting Ad Id Info", e3);
            return null;
        } catch (IllegalStateException e4) {
            Log.w("GoogleTagManager", "IllegalStateException getting Advertising Id Info", e4);
            return null;
        } catch (Exception e5) {
            Log.w("GoogleTagManager", "Unknown exception. Could not get the Advertising Id Info.", e5);
            return null;
        }
    }
}
