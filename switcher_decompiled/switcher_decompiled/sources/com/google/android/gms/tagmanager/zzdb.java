package com.google.android.gms.tagmanager;

import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdb extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.LANGUAGE.toString();

    public zzdb() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzfu.zzb();
        }
        String language = locale.getLanguage();
        return language == null ? zzfu.zzb() : zzfu.zzc(language.toLowerCase());
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
