package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzdv implements zzcc {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final zzdu zzb;
    private volatile zzbj zzc;
    private final Context zzd;
    private final String zze;
    private long zzf;
    private final Clock zzg;
    private final int zzh;
    private final zzey zzi;

    zzdv(zzey zzeyVar, Context context, byte[] bArr) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        this.zze = "gtm_urls.db";
        this.zzi = zzeyVar;
        this.zzg = DefaultClock.getInstance();
        this.zzb = new zzdu(this, applicationContext, "gtm_urls.db");
        this.zzc = new zzfi(applicationContext, new zzdt(this));
        this.zzf = 0L;
        this.zzh = 2000;
    }

    static /* synthetic */ void zzi(zzdv zzdvVar, long j, long j2) {
        SQLiteDatabase sQLiteDatabaseZzk = zzdvVar.zzk("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzk == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            sQLiteDatabaseZzk.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
            zzdvVar.zzl(j);
        }
    }

    private final SQLiteDatabase zzk(String str) {
        try {
            return this.zzb.getWritableDatabase();
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(long j) {
        zzj(new String[]{String.valueOf(j)});
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013e A[Catch: all -> 0x00f9, TryCatch #11 {all -> 0x00f9, blocks: (B:22:0x00ab, B:25:0x00b2, B:27:0x00bf, B:29:0x00ea, B:28:0x00ce, B:49:0x0116, B:50:0x0138, B:52:0x013e, B:57:0x0152), top: B:119:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b2  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Override // com.google.android.gms.tagmanager.zzcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdv.zza():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc A[PHI: r2
      0x00bc: PHI (r2v8 android.database.Cursor) = (r2v7 android.database.Cursor), (r2v9 android.database.Cursor) binds: [B:31:0x00ba, B:22:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    @Override // com.google.android.gms.tagmanager.zzcc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzb(long r20, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdv.zzb(long, java.lang.String):void");
    }

    final int zzc() {
        SQLiteDatabase sQLiteDatabaseZzk = zzk("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzk == null) {
            return 0;
        }
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZzk.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                if (cursorRawQuery != null) {
                    return i;
                }
            } catch (SQLiteException unused) {
                Log.w("GoogleTagManager", "Error getting numStoredHits");
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return 0;
                }
            }
            return i;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    final void zzj(String[] strArr) {
        int length;
        SQLiteDatabase sQLiteDatabaseZzk;
        if (strArr == null || (length = strArr.length) == 0 || (sQLiteDatabaseZzk = zzk("Error opening database for deleteHits.")) == null) {
            return;
        }
        boolean z = true;
        try {
            sQLiteDatabaseZzk.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(length, "?"))), strArr);
            zzey zzeyVar = this.zzi;
            if (zzc() != 0) {
                z = false;
            }
            zzeyVar.zza(z);
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error deleting hits");
        }
    }
}
