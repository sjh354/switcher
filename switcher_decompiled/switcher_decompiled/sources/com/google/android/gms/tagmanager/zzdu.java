package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzdu extends SQLiteOpenHelper {
    final /* synthetic */ zzdv zza;
    private boolean zzb;
    private long zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdu(zzdv zzdvVar, Context context, String str) {
        super(context, "gtm_urls.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzdvVar;
        this.zzc = 0L;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        if (this.zzb && this.zzc + 3600000 > this.zza.zzg.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
        }
        this.zzb = true;
        this.zzc = this.zza.zzg.currentTimeMillis();
        try {
            writableDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdv zzdvVar = this.zza;
            zzdvVar.zzd.getDatabasePath(zzdvVar.zze).delete();
            writableDatabase = null;
        }
        if (writableDatabase == null) {
            writableDatabase = super.getWritableDatabase();
        }
        this.zzb = false;
        return writableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzbu.zza(sQLiteDatabase.getPath());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        if (Build.VERSION.SDK_INT < 15) {
            try {
                sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null).moveToFirst();
            } finally {
            }
        }
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{"gtm_hits"}, null, null, null);
            } catch (SQLiteException unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zMoveToFirst = cursorQuery.moveToFirst();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (zMoveToFirst) {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
                HashSet hashSet = new HashSet();
                try {
                    for (String str : cursorRawQuery.getColumnNames()) {
                        hashSet.add(str);
                    }
                    cursorRawQuery.close();
                    if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                        throw new SQLiteException("Database column missing");
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    }
                    return;
                } finally {
                }
            }
        } catch (SQLiteException unused2) {
            cursor = cursorQuery;
            Log.w("GoogleTagManager", "Error querying for table gtm_hits");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        sQLiteDatabase.execSQL(zzdv.zza);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
