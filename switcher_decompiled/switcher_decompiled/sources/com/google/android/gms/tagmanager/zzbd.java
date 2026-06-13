package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.gtm.zzgb;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
final class zzbd implements zzaw {
    private static final String zza = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", ClientCookie.EXPIRES_ATTR);
    private final Executor zzb;
    private final Context zzc;
    private final zzbb zzd;
    private final Clock zze;

    public zzbd(Context context) {
        Clock defaultClock = DefaultClock.getInstance();
        ExecutorService executorServiceZza = zzgb.zza().zza(2);
        this.zzc = context;
        this.zze = defaultClock;
        this.zzb = executorServiceZza;
        this.zzd = new zzbb(this, context, "google_tagmanager.db");
    }

    static /* bridge */ /* synthetic */ List zzf(zzbd zzbdVar) {
        ObjectInputStream objectInputStream;
        try {
            zzbdVar.zzk(zzbdVar.zze.currentTimeMillis());
            SQLiteDatabase sQLiteDatabaseZzi = zzbdVar.zzi("Error opening database for loadSerialized.");
            ArrayList<zzbc> arrayList = new ArrayList();
            if (sQLiteDatabaseZzi != null) {
                Cursor cursorQuery = sQLiteDatabaseZzi.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(new zzbc(cursorQuery.getString(0), cursorQuery.getBlob(1)));
                    } finally {
                        cursorQuery.close();
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (zzbc zzbcVar : arrayList) {
                String str = zzbcVar.zza;
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(zzbcVar.zzb);
                ObjectInputStream objectInputStream2 = null;
                object = null;
                object = null;
                object = null;
                Object object = null;
                try {
                    objectInputStream = new ObjectInputStream(byteArrayInputStream);
                } catch (IOException unused) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused2) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    object = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (ClassNotFoundException unused5) {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream2 = objectInputStream;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException unused6) {
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    throw th;
                }
                byteArrayInputStream.close();
                arrayList2.add(new zzat(str, object));
            }
            return arrayList2;
        } finally {
            zzbdVar.zzj();
        }
    }

    static /* synthetic */ void zzg(zzbd zzbdVar, String str) {
        SQLiteDatabase sQLiteDatabaseZzi = zzbdVar.zzi("Error opening database for clearKeysWithPrefix.");
        if (sQLiteDatabaseZzi == null) {
            return;
        }
        try {
            zzdg.zzb.zzd("Cleared " + sQLiteDatabaseZzi.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
        } catch (SQLiteException e) {
            Log.w("GoogleTagManager", "Error deleting entries with key prefix: " + str + " (" + e.toString() + ").");
        } finally {
            zzbdVar.zzj();
        }
    }

    private final SQLiteDatabase zzi(String str) {
        try {
            return this.zzd.getWritableDatabase();
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", str);
            return null;
        }
    }

    private final void zzj() {
        try {
            this.zzd.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzk(long j) {
        SQLiteDatabase sQLiteDatabaseZzi = zzi("Error opening database for deleteOlderThan.");
        if (sQLiteDatabaseZzi == null) {
            return;
        }
        try {
            zzdg.zzb.zzd("Deleted " + sQLiteDatabaseZzi.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
        } catch (SQLiteException unused) {
            Log.w("GoogleTagManager", "Error deleting old entries.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[Catch: all -> 0x0182, TRY_LEAVE, TryCatch #1 {all -> 0x0182, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:55:0x00c6, B:57:0x00ef, B:60:0x00f3, B:62:0x00fb, B:63:0x0116, B:65:0x011c, B:39:0x0098, B:69:0x0134, B:70:0x0137, B:71:0x0138, B:74:0x0143, B:75:0x0147, B:77:0x014d, B:15:0x0031, B:22:0x0042, B:85:0x017e, B:86:0x0181), top: B:94:0x0003, outer: #4, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0098 A[Catch: all -> 0x0182, PHI: r7 r8
      0x0098: PHI (r7v14 char) = (r7v13 char), (r7v16 char) binds: [B:53:0x00c3, B:38:0x0096] A[DONT_GENERATE, DONT_INLINE]
      0x0098: PHI (r8v8 android.database.Cursor) = (r8v7 android.database.Cursor), (r8v9 android.database.Cursor) binds: [B:53:0x00c3, B:38:0x0096] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0182, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:55:0x00c6, B:57:0x00ef, B:60:0x00f3, B:62:0x00fb, B:63:0x0116, B:65:0x011c, B:39:0x0098, B:69:0x0134, B:70:0x0137, B:71:0x0138, B:74:0x0143, B:75:0x0147, B:77:0x014d, B:15:0x0031, B:22:0x0042, B:85:0x017e, B:86:0x0181), top: B:94:0x0003, outer: #4, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0134 A[Catch: all -> 0x0182, TryCatch #1 {all -> 0x0182, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:55:0x00c6, B:57:0x00ef, B:60:0x00f3, B:62:0x00fb, B:63:0x0116, B:65:0x011c, B:39:0x0098, B:69:0x0134, B:70:0x0137, B:71:0x0138, B:74:0x0143, B:75:0x0147, B:77:0x014d, B:15:0x0031, B:22:0x0042, B:85:0x017e, B:86:0x0181), top: B:94:0x0003, outer: #4, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0143 A[Catch: all -> 0x0182, TryCatch #1 {all -> 0x0182, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:55:0x00c6, B:57:0x00ef, B:60:0x00f3, B:62:0x00fb, B:63:0x0116, B:65:0x011c, B:39:0x0098, B:69:0x0134, B:70:0x0137, B:71:0x0138, B:74:0x0143, B:75:0x0147, B:77:0x014d, B:15:0x0031, B:22:0x0042, B:85:0x017e, B:86:0x0181), top: B:94:0x0003, outer: #4, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017e A[Catch: all -> 0x0182, TRY_ENTER, TryCatch #1 {all -> 0x0182, blocks: (B:4:0x0003, B:23:0x0046, B:25:0x004b, B:55:0x00c6, B:57:0x00ef, B:60:0x00f3, B:62:0x00fb, B:63:0x0116, B:65:0x011c, B:39:0x0098, B:69:0x0134, B:70:0x0137, B:71:0x0138, B:74:0x0143, B:75:0x0147, B:77:0x014d, B:15:0x0031, B:22:0x0042, B:85:0x017e, B:86:0x0181), top: B:94:0x0003, outer: #4, inners: #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzl(java.util.List r18, long r19) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbd.zzl(java.util.List, long):void");
    }

    @Override // com.google.android.gms.tagmanager.zzaw
    public final void zza(String str) {
        this.zzb.execute(new zzba(this, str));
    }

    @Override // com.google.android.gms.tagmanager.zzaw
    public final void zzb(zzav zzavVar) {
        this.zzb.execute(new zzaz(this, zzavVar));
    }

    @Override // com.google.android.gms.tagmanager.zzaw
    public final void zzc(List list, long j) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzat zzatVar = (zzat) it.next();
            String str = zzatVar.zza;
            Object obj = zzatVar.zzb;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = null;
            byteArray = null;
            byte[] byteArray = null;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (IOException unused) {
                    if (objectOutputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    arrayList.add(new zzbc(str, byteArray));
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException unused3) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException unused4) {
            }
            arrayList.add(new zzbc(str, byteArray));
        }
        this.zzb.execute(new zzay(this, arrayList, j));
    }
}
