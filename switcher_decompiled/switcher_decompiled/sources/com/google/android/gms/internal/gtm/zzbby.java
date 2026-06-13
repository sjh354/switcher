package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbby extends zzbcc {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;

    /* synthetic */ zzbby(byte[] bArr, int i, int i2, boolean z, zzbbx zzbbxVar) {
        super(null);
        this.zzh = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzf = 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final int zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final int zzb(int i) throws zzbfs {
        int i2 = this.zzh;
        this.zzh = 0;
        int i3 = this.zzf + this.zzg;
        this.zzf = i3;
        if (i3 > 0) {
            this.zzg = i3;
            this.zzf = i3 - i3;
        } else {
            this.zzg = 0;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final int zzc() throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final zzbbw zzd() throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final String zze() throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final String zzf() throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final void zzg(int i) throws zzbfs {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final void zzh(int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final boolean zzi() throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final boolean zzj() throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.gtm.zzbcc
    public final boolean zzk(int i) throws IOException {
        throw null;
    }
}
