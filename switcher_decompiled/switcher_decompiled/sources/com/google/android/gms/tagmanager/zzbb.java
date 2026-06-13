package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbb extends SQLiteOpenHelper {
    final /* synthetic */ zzbd zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbb(zzbd zzbdVar, Context context, String str) {
        super(context, "google_tagmanager.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzbdVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            this.zza.zzc.getDatabasePath("google_tagmanager.db").delete();
            writableDatabase = null;
        }
        return writableDatabase == null ? super.getWritableDatabase() : writableDatabase;
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
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{"datalayer"}, null, null, null);
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
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
                HashSet hashSet = new HashSet();
                try {
                    for (String str : cursorRawQuery.getColumnNames()) {
                        hashSet.add(str);
                    }
                    cursorRawQuery.close();
                    if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove(ClientCookie.EXPIRES_ATTR)) {
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
            Log.w("GoogleTagManager", "Error querying for table datalayer");
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
        sQLiteDatabase.execSQL(zzbd.zza);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
