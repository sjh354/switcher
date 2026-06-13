package kr.switcher.switcherm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class DBProductionServiceDAO {
    public static final String COLUMN_CARD_CODE = "card_code";
    public static final String COLUMN_MAC_ADDRESS = "mac_address";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_REGISTER_YN = "register_yn";
    public static final String COLUMN_WARRANTY_DATE = "warranty_date";
    public static final String TABLE_PRODUCTION_SERVICE = "tb_production_service";
    private static Context context;
    private String[] columns = {"mac_address", COLUMN_REGISTER_YN, COLUMN_CARD_CODE, COLUMN_WARRANTY_DATE, "price"};
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

    public DBProductionService getProductionService(String str) {
        Cursor cursorQuery = this.database.query(TABLE_PRODUCTION_SERVICE, this.columns, "mac_address=?", new String[]{str}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return null;
        }
        DBProductionService dBProductionService = new DBProductionService(cursorQuery);
        cursorQuery.close();
        return dBProductionService;
    }

    public DBProductionService insertOrUpdateProductionService(String str, String str2, int i, String str3, int i2) {
        if (IOUtil.checkIsNullParameter(str, str2)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("mac_address", str);
        contentValues.put(COLUMN_REGISTER_YN, str2);
        contentValues.put(COLUMN_CARD_CODE, Integer.valueOf(i));
        contentValues.put(COLUMN_WARRANTY_DATE, str3);
        contentValues.put("price", Integer.valueOf(i2));
        if (getProductionService(str) == null) {
            if (this.database.insert(TABLE_PRODUCTION_SERVICE, null, contentValues) > 0) {
                return getProductionService(str);
            }
            return null;
        }
        if (this.database.update(TABLE_PRODUCTION_SERVICE, contentValues, "mac_address=?", new String[]{str}) > 0) {
            return getProductionService(str);
        }
        return null;
    }

    public boolean updatePaymentCard(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mac_address", str);
        contentValues.put(COLUMN_CARD_CODE, str2);
        return getProductionService(str) != null && this.database.update(TABLE_PRODUCTION_SERVICE, contentValues, "mac_address=?", new String[]{str}) > 0;
    }

    public boolean deleteService(String str) {
        if (this.database.delete(TABLE_PRODUCTION_SERVICE, "mac_address=?", new String[]{str}) < 1) {
            this.database.close();
            return false;
        }
        this.database.close();
        return true;
    }
}
