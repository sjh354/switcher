package kr.switcher.switcherm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DBPricingModelDAO {
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_PLAN_INFO = "plan_info";
    public static final String COLUMN_PLAN_NAME = "plan_name";
    public static final String COLUMN_PRICE = "price";
    public static final String TABLE_PRICING_MODEL = "tb_pricing_model";
    private static Context context;
    private String[] columns = {COLUMN_CODE, "price", COLUMN_PLAN_NAME, COLUMN_PLAN_INFO};
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

    public DBPricingModel getPricingModel(int i) {
        Cursor cursorQuery = this.database.query(TABLE_PRICING_MODEL, this.columns, "code=?", new String[]{String.valueOf(i)}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return null;
        }
        DBPricingModel dBPricingModel = new DBPricingModel(cursorQuery);
        cursorQuery.close();
        return dBPricingModel;
    }

    public List<DBPricingModel> getPricingModels() {
        Cursor cursorQuery = this.database.query(TABLE_PRICING_MODEL, this.columns, null, null, null, null, COLUMN_CODE);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(new DBPricingModel(cursorQuery));
        } while (cursorQuery.moveToNext());
        cursorQuery.close();
        return arrayList;
    }

    public DBPricingModel insertOrUpdate(int i, int i2, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CODE, Integer.valueOf(i));
        contentValues.put("price", Integer.valueOf(i2));
        contentValues.put(COLUMN_PLAN_NAME, str);
        contentValues.put(COLUMN_PLAN_INFO, str2);
        if (getPricingModel(i) == null) {
            if (this.database.insert(TABLE_PRICING_MODEL, null, contentValues) > 0) {
                return getPricingModel(i);
            }
            return null;
        }
        if (this.database.update(TABLE_PRICING_MODEL, contentValues, "code=?", new String[]{String.valueOf(i)}) > 0) {
            return getPricingModel(i);
        }
        return null;
    }
}
