package com.google.android.gms.internal.gtm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.switcher.device.switcher.Switcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzcg extends zzbu implements Closeable {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String zzb = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final zzcf zzc;
    private final zzfq zzd;
    private final zzfq zze;

    zzcg(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzd = new zzfq(zzC());
        this.zze = new zzfq(zzC());
        this.zzc = new zzcf(this, zzbxVar.zza(), zzad());
    }

    private final long zzac(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzf().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getLong(0);
                }
                if (cursorRawQuery == null) {
                    return 0L;
                }
                cursorRawQuery.close();
                return 0L;
            } catch (SQLiteException e) {
                zzK("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzad() {
        zzw();
        zzw();
        return "google_analytics_v4.db";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.zzc.close();
        } catch (SQLiteException e) {
            zzJ("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zzJ("Error closing database", e2);
        }
    }

    public final void zzY(List list) {
        Preconditions.checkNotNull(list);
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i = 0; i < list.size(); i++) {
            Long l = (Long) list.get(i);
            if (l == null || l.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(l);
        }
        sb.append(")");
        String string = sb.toString();
        try {
            SQLiteDatabase sQLiteDatabaseZzf = zzf();
            zzO("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int iDelete = sQLiteDatabaseZzf.delete("hits2", string, null);
            if (iDelete != list.size()) {
                zzT("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(iDelete), string);
            }
        } catch (SQLiteException e) {
            zzJ("Error deleting hits", e);
            throw e;
        }
    }

    public final void zzZ() {
        zzV();
        zzf().endTransaction();
    }

    public final int zza() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        if (!this.zzd.zzc(86400000L)) {
            return 0;
        }
        this.zzd.zzb();
        zzN("Deleting stale hits (if any)");
        int iDelete = zzf().delete("hits2", "hit_time < ?", new String[]{Long.toString(zzC().currentTimeMillis() - 2592000000L)});
        zzO("Deleted stale hits, count", Integer.valueOf(iDelete));
        return iDelete;
    }

    public final void zzaa() {
        zzV();
        zzf().setTransactionSuccessful();
    }

    final boolean zzab() {
        return zzb() == 0;
    }

    public final long zzb() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = zzf().rawQuery("SELECT COUNT(*) FROM hits2", null);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzK("Database error", "SELECT COUNT(*) FROM hits2", e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zzc() {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        return zzac(zzb, null, 0L);
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
    }

    public final long zze(long j, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzV();
        com.google.android.gms.analytics.zzr.zzh();
        return zzac("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE, str, str2}, 0L);
    }

    final SQLiteDatabase zzf() {
        try {
            return this.zzc.getWritableDatabase();
        } catch (SQLiteException e) {
            zzR("Error opening database", e);
            throw e;
        }
    }

    public final List zzj(long j) throws Throwable {
        Cursor cursorQuery;
        Preconditions.checkArgument(j >= 0);
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        Cursor cursor = null;
        try {
            try {
                cursorQuery = zzf().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
            } catch (SQLiteException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (cursorQuery.moveToFirst()) {
                do {
                    long j2 = cursorQuery.getLong(0);
                    long j3 = cursorQuery.getLong(1);
                    String string = cursorQuery.getString(2);
                    String string2 = cursorQuery.getString(3);
                    arrayList.add(new zzez(this, zzk(string), j3, TextUtils.isEmpty(string2) || !string2.startsWith("http:"), j2, cursorQuery.getInt(4), null));
                } while (cursorQuery.moveToNext());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (SQLiteException e2) {
            e = e2;
            cursor = cursorQuery;
            zzJ("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map zzk(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                str = "?" + str;
            }
            return HttpUtils.parse(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            zzJ("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    final Map zzl(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            return HttpUtils.parse(new URI("?" + str), "UTF-8");
        } catch (URISyntaxException e) {
            zzJ("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    public final void zzm() {
        zzV();
        zzf().beginTransaction();
    }

    public final void zzn(long j) {
        com.google.android.gms.analytics.zzr.zzh();
        zzV();
        ArrayList arrayList = new ArrayList(1);
        Long lValueOf = Long.valueOf(j);
        arrayList.add(lValueOf);
        zzO("Deleting hit, id", lValueOf);
        zzY(arrayList);
    }
}
