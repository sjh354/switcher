package kr.switcher.switcherm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class DBSubscriptionServiceDAO {
    public static final String COLUMN_BEGINNING_DATE = "beginning_date";
    public static final String COLUMN_EXPIRATION_DATE = "expiration_date";
    public static final String COLUMN_FREE_YN = "free_yn";
    public static final String COLUMN_MAC_ADDRESS = "mac_address";
    public static final String COLUMN_PAYMENT_CARD = "payment_card";
    public static final String COLUMN_PAYMENT_DATE = "payment_date";
    public static final String COLUMN_PAYMENT_PLAN = "payment_plan";
    public static final String TABLE_SUBSCRIPTION_SERVICE = "tb_subscription_service";
    private static Context context;
    private String[] columns = {"mac_address", COLUMN_FREE_YN, COLUMN_BEGINNING_DATE, COLUMN_EXPIRATION_DATE, COLUMN_PAYMENT_PLAN, COLUMN_PAYMENT_CARD, COLUMN_PAYMENT_DATE};
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

    public DBSubscriptionService getService(String str) {
        Cursor cursorQuery = this.database.query(TABLE_SUBSCRIPTION_SERVICE, this.columns, "mac_address=?", new String[]{str}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return null;
        }
        DBSubscriptionService dBSubscriptionService = new DBSubscriptionService(cursorQuery);
        cursorQuery.close();
        return dBSubscriptionService;
    }

    public DBSubscriptionService insertOrUpdateService(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        if (IOUtil.checkIsNullParameter(str, str3, str4, str5)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("mac_address", str);
        contentValues.put(COLUMN_FREE_YN, str2);
        contentValues.put(COLUMN_BEGINNING_DATE, str3);
        contentValues.put(COLUMN_EXPIRATION_DATE, str4);
        contentValues.put(COLUMN_PAYMENT_PLAN, Integer.valueOf(i));
        contentValues.put(COLUMN_PAYMENT_CARD, str5);
        contentValues.put(COLUMN_PAYMENT_DATE, str6);
        if (getService(str) == null) {
            if (this.database.insert(TABLE_SUBSCRIPTION_SERVICE, null, contentValues) > 0) {
                return getService(str);
            }
            return null;
        }
        if (this.database.update(TABLE_SUBSCRIPTION_SERVICE, contentValues, "mac_address=?", new String[]{str}) > 0) {
            return getService(str);
        }
        return null;
    }

    public boolean updatePaymentCard(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mac_address", str);
        contentValues.put(COLUMN_PAYMENT_CARD, str2);
        return getService(str) != null && this.database.update(TABLE_SUBSCRIPTION_SERVICE, contentValues, "mac_address=?", new String[]{str}) > 0;
    }

    public boolean deleteService(String str) {
        if (this.database.delete(TABLE_SUBSCRIPTION_SERVICE, "mac_address=?", new String[]{str}) < 1) {
            this.database.close();
            return false;
        }
        this.database.close();
        return true;
    }
}
