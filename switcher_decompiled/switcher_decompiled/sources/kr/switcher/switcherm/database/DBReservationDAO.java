package kr.switcher.switcherm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DBReservationDAO {
    public static final String COLUMN_AM_PM = "am_pm";
    public static final String COLUMN_CREATION_DATETIME = "creation_datetime";
    public static final String COLUMN_ENABLE = "enable";
    public static final String COLUMN_FRI = "fri";
    public static final String COLUMN_HOUR = "hour";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LIGHT = "light";
    public static final String COLUMN_MAC_ADDRESS = "mac_address";
    public static final String COLUMN_MIN = "min";
    public static final String COLUMN_MON = "mon";
    public static final String COLUMN_SAT = "sat";
    public static final String COLUMN_SUN = "sun";
    public static final String COLUMN_SWITCHER_TARGET = "switcher_target";
    public static final String COLUMN_THU = "thu";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TUE = "tue";
    public static final String COLUMN_UPDATE_DATETIME = "update_datetime";
    public static final String COLUMN_WED = "wed";
    public static final String TABLE_RESERVATION = "tb_reservation";
    private static Context context;
    private String[] columns = {"mac_address", COLUMN_ID, COLUMN_TITLE, COLUMN_MON, COLUMN_TUE, COLUMN_WED, COLUMN_THU, COLUMN_FRI, COLUMN_SAT, COLUMN_SUN, COLUMN_AM_PM, COLUMN_HOUR, COLUMN_MIN, COLUMN_SWITCHER_TARGET, COLUMN_ENABLE, COLUMN_LIGHT, "creation_datetime", "update_datetime"};
    private SQLiteDatabase database;
    private SQLiteOpenHelper databaseHelper;

    public static void setContext(Context context2) {
        context = context2;
    }

    public void open() {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        this.databaseHelper = databaseHelper;
        this.database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public DBReservation getTimer(String str, long j) {
        Cursor cursorQuery = this.database.query(TABLE_RESERVATION, this.columns, "mac_address=? AND _id=?", new String[]{str, String.valueOf(j)}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return null;
        }
        DBReservation dBReservation = new DBReservation(cursorQuery);
        cursorQuery.close();
        return dBReservation;
    }

    public List<DBReservation> getTimers(String str) {
        Cursor cursorQuery = this.database.query(TABLE_RESERVATION, this.columns, "mac_address=?", new String[]{str}, null, null, "enable desc, am_pm, hour, min, switcher_target");
        if (!DBUtil.checkCursor(cursorQuery)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(new DBReservation(cursorQuery));
        } while (cursorQuery.moveToNext());
        cursorQuery.close();
        return arrayList;
    }

    public DBReservation insertTimer(String str, int i, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str3, int i2, int i3, boolean z8, String str4, boolean z9) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, Integer.valueOf(i));
        contentValues.put("mac_address", str);
        contentValues.put(COLUMN_TITLE, str2);
        contentValues.put(COLUMN_MON, Boolean.valueOf(z));
        contentValues.put(COLUMN_TUE, Boolean.valueOf(z2));
        contentValues.put(COLUMN_WED, Boolean.valueOf(z3));
        contentValues.put(COLUMN_THU, Boolean.valueOf(z4));
        contentValues.put(COLUMN_FRI, Boolean.valueOf(z5));
        contentValues.put(COLUMN_SAT, Boolean.valueOf(z6));
        contentValues.put(COLUMN_SUN, Boolean.valueOf(z7));
        contentValues.put(COLUMN_AM_PM, str3);
        contentValues.put(COLUMN_HOUR, Integer.valueOf(i2));
        contentValues.put(COLUMN_MIN, Integer.valueOf(i3));
        contentValues.put(COLUMN_LIGHT, Boolean.valueOf(z8));
        contentValues.put(COLUMN_SWITCHER_TARGET, str4);
        contentValues.put(COLUMN_ENABLE, Boolean.valueOf(z9));
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        long j = i;
        if (getTimer(str, j) == null) {
            if (this.database.insert(TABLE_RESERVATION, null, contentValues) < 0) {
                return null;
            }
            return getTimer(str, j);
        }
        if (this.database.update(TABLE_RESERVATION, contentValues, "mac_address=? AND _id=?", new String[]{str, String.valueOf(i)}) < 0) {
            return null;
        }
        return getTimer(str, j);
    }

    public boolean deleteTimer(String str, int i) {
        return this.database.delete(TABLE_RESERVATION, "mac_address=? AND _id=?", new String[]{str, String.valueOf(i)}) >= 1;
    }

    public boolean deleteTimers(String str) {
        return this.database.delete(TABLE_RESERVATION, "mac_address=?", new String[]{str}) >= 1;
    }
}
