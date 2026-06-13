package com.google.android.gms.internal.gtm;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScanner;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzew {
    public static final zzev zzA;
    public static final zzev zzB;
    public static final zzev zzC;
    public static final zzev zzD;
    public static final zzev zzE;
    public static final zzev zzF;
    public static final zzev zzG;
    public static final zzev zzH;
    public static final zzev zzI;
    public static final zzev zzJ;
    public static final zzev zzK;
    public static final zzev zzL;
    public static final zzev zzM;
    public static final zzev zzN;
    public static final zzev zzO;
    public static final zzev zzP;
    public static final zzev zzQ;
    public static final zzev zzR;
    private static final Set zzS = Collections.synchronizedSet(new HashSet());
    public static final zzev zza = zzev.zza(false, false, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdc
    });
    public static final zzev zzb = zzev.zza(true, true, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzde
    });
    public static final zzev zzc = zzev.zza("GAv4", "GAv4-SVC", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdq
    });
    public static final zzev zzd = zzev.zza(60L, 60L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzec
    });
    public static final zzev zze;
    public static final zzev zzf;
    public static final zzev zzg;
    public static final zzev zzh;
    public static final zzev zzi;
    public static final zzev zzj;
    public static final zzev zzk;
    public static final zzev zzl;
    public static final zzev zzm;
    public static final zzev zzn;
    public static final zzev zzo;
    public static final zzev zzp;
    public static final zzev zzq;
    public static final zzev zzr;
    public static final zzev zzs;
    public static final zzev zzt;
    public static final zzev zzu;
    public static final zzev zzv;
    public static final zzev zzw;
    public static final zzev zzx;
    public static final zzev zzy;
    public static final zzev zzz;

    static {
        Double dValueOf = Double.valueOf(0.5d);
        zze = zzev.zza(dValueOf, dValueOf, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzeh
        });
        zzf = zzev.zza(2000, Integer.valueOf(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH), new zzeu() { // from class: com.google.android.gms.internal.gtm.zzei
        });
        zzg = zzev.zza(2000, 2000, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzek
        });
        zzh = zzev.zza(100, 100, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzel
        });
        zzi = zzev.zza(1800000L, 120000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzem
        });
        Long lValueOf = Long.valueOf(BootloaderScanner.TIMEOUT);
        zzj = zzev.zza(lValueOf, lValueOf, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzen
        });
        zzk = zzev.zza(120000L, 120000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdn
        });
        zzl = zzev.zza(7200000L, 7200000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdy
        });
        zzm = zzev.zza(7200000L, 7200000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzej
        });
        zzn = zzev.zza(32400000L, 32400000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzeo
        });
        zzo = zzev.zza(20, 20, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzep
        });
        zzp = zzev.zza(20, 20, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzeq
        });
        zzq = zzev.zza("http://www.google-analytics.com", "http://www.google-analytics.com", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzer
        });
        zzr = zzev.zza("https://ssl.google-analytics.com", "https://ssl.google-analytics.com", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzes
        });
        zzs = zzev.zza("/collect", "/collect", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzet
        });
        zzt = zzev.zza("/batch", "/batch", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdd
        });
        zzu = zzev.zza(2036, 2036, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdf
        });
        zzv = zzev.zza("BATCH_BY_COUNT", "BATCH_BY_COUNT", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdg
        });
        zzw = zzev.zza("GZIP", "GZIP", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdh
        });
        zzx = zzev.zza(20, 20, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdi
        });
        zzy = zzev.zza(8192, 8192, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdj
        });
        zzz = zzev.zza(8192, 8192, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdk
        });
        zzA = zzev.zza(8192, 8192, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdl
        });
        zzB = zzev.zza("404,502", "404,502", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdm
        });
        zzC = zzev.zza(3600, 3600, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdo
        });
        zzD = zzev.zza(86400000L, 86400000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdp
        });
        zzE = zzev.zza(60000, 60000, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdr
        });
        zzF = zzev.zza(61000, 61000, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzds
        });
        zzG = zzev.zza(86400000L, 86400000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdt
        });
        zzH = zzev.zza("", "", new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdu
        });
        zzI = zzev.zza(0, 0, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdv
        });
        zzJ = zzev.zza(false, false, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdw
        });
        zzK = zzev.zza(10000L, 10000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdx
        });
        zzL = zzev.zza(lValueOf, lValueOf, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzdz
        });
        zzM = zzev.zza(lValueOf, lValueOf, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzea
        });
        zzN = zzev.zza(60000L, 60000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzeb
        });
        zzO = zzev.zza(1800000L, 1800000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzed
        });
        zzP = zzev.zza(86400000L, 86400000L, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzee
        });
        zzQ = zzev.zza(lValueOf, lValueOf, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzef
        });
        zzR = zzev.zza(false, false, new zzeu() { // from class: com.google.android.gms.internal.gtm.zzeg
        });
    }
}
