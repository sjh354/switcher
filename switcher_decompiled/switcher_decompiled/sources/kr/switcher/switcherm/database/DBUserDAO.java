package kr.switcher.switcherm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import kr.switcher.switcherm.preference.LoginUser;

/* JADX INFO: loaded from: classes2.dex */
public class DBUserDAO {
    public static final String COLUMN_ADDRESS1 = "address1";
    public static final String COLUMN_ADDRESS2 = "address2";
    public static final String COLUMN_CREATION_DATETIME = "creation_datetime";
    public static final String COLUMN_MAIN_SWITCHER_MAC_ADDRESS = "main_switcher_mac_address";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_POST_NUMBER = "post_number";
    public static final String COLUMN_UPDATE_DATETIME = "update_datetime";
    public static final String COLUMN_USER_NAME = "user_name";
    public static final String TABLE_USER = "tb_user";
    private static Context context;
    private String[] columns = {COLUMN_PHONE_NUMBER, COLUMN_USER_NAME, COLUMN_MAIN_SWITCHER_MAC_ADDRESS, COLUMN_POST_NUMBER, COLUMN_ADDRESS1, COLUMN_ADDRESS2, "creation_datetime", "update_datetime"};
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

    public DBUser getData(String str) {
        Cursor cursorQuery = this.database.query(TABLE_USER, this.columns, "phone_number=?", new String[]{str}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return null;
        }
        DBUser dBUser = new DBUser(cursorQuery);
        cursorQuery.close();
        return dBUser;
    }

    public DBUser getData() {
        String phoneNumber = new LoginUser().getPhoneNumber();
        if (phoneNumber == null || phoneNumber.length() < 11) {
            return null;
        }
        Cursor cursorQuery = this.database.query(TABLE_USER, this.columns, "phone_number=?", new String[]{phoneNumber}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return null;
        }
        DBUser dBUser = new DBUser(cursorQuery);
        cursorQuery.close();
        return dBUser;
    }

    public DBUser insertOrUpdate(String str, String str2, String str3, String str4, String str5, String str6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PHONE_NUMBER, str);
        contentValues.put(COLUMN_USER_NAME, str2);
        contentValues.put(COLUMN_POST_NUMBER, str4);
        contentValues.put(COLUMN_ADDRESS1, str5);
        contentValues.put(COLUMN_ADDRESS2, str6);
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        if (getData(str) != null) {
            if (this.database.update(TABLE_USER, contentValues, "phone_number=?", new String[]{str}) > 0) {
                return getData(str);
            }
            return null;
        }
        contentValues.put(COLUMN_MAIN_SWITCHER_MAC_ADDRESS, str3);
        if (this.database.insert(TABLE_USER, null, contentValues) > 0) {
            return getData(str);
        }
        return null;
    }

    public DBUser updateMainSwitcher(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MAIN_SWITCHER_MAC_ADDRESS, str2);
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        if (getData(str) != null && this.database.update(TABLE_USER, contentValues, "phone_number=?", new String[]{str}) > 0) {
            return getData(str);
        }
        return null;
    }

    public boolean delete(String str) {
        return this.database.delete(TABLE_USER, "phone_number=?", new String[]{str}) >= 1;
    }
}
