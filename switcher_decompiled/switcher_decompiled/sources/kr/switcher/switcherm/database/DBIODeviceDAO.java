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
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.LoginUser;

/* JADX INFO: loaded from: classes2.dex */
public class DBIODeviceDAO {
    public static final String COLUMN_BATTERY = "battery";
    public static final String COLUMN_CREATION_DATETIME = "creation_datetime";
    public static final String COLUMN_IS_MINE = "is_mine";
    public static final String COLUMN_MAC_ADDRESS = "mac_address";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_OWNER = "owner";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_SERIAL_NUMBER = "serial_number";
    public static final String COLUMN_SHARE_CODE = "share_code";
    public static final String COLUMN_UPDATE_DATETIME = "update_datetime";
    public static final String TABLE_IO_DEVICE = "tb_io_device";
    private static Context context;
    private String[] columns = {"mac_address", COLUMN_SERIAL_NUMBER, "name", COLUMN_SHARE_CODE, COLUMN_PRODUCT_ID, COLUMN_OWNER, COLUMN_IS_MINE, COLUMN_BATTERY, "creation_datetime", "update_datetime"};
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

    public DBIODevice getData(String str) {
        Cursor cursorQuery = this.database.query(TABLE_IO_DEVICE, this.columns, "mac_address=?", new String[]{str}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return null;
        }
        DBIODevice dBIODevice = new DBIODevice(cursorQuery);
        cursorQuery.close();
        return dBIODevice;
    }

    public List<DBIODevice> getDatas(IODevice.ProductId productId) {
        Cursor cursorQuery = this.database.query(TABLE_IO_DEVICE, this.columns, "product_id=?", new String[]{String.valueOf(DeviceUtil.convertSwitcherType(productId))}, null, null, null);
        if (!DBUtil.checkCursor(cursorQuery)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(new DBIODevice(cursorQuery));
        } while (cursorQuery.moveToNext());
        cursorQuery.close();
        return arrayList;
    }

    public List<DBIODevice> getDatas() {
        Cursor cursorRawQuery = this.database.rawQuery("SELECT  * FROM tb_io_device", null);
        if (!DBUtil.checkCursor(cursorRawQuery)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(new DBIODevice(cursorRawQuery));
        } while (cursorRawQuery.moveToNext());
        cursorRawQuery.close();
        return arrayList;
    }

    public DBIODevice insertOrUpdate(String str, String str2, String str3, String str4, int i, String str5, boolean z) {
        if (IOUtil.checkIsNullParameter(str, str2, str3, String.valueOf(i), String.valueOf(z))) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("mac_address", str);
        contentValues.put(COLUMN_SERIAL_NUMBER, str2);
        contentValues.put("name", str3);
        contentValues.put(COLUMN_SHARE_CODE, str4);
        contentValues.put(COLUMN_PRODUCT_ID, Integer.valueOf(i));
        contentValues.put(COLUMN_OWNER, str5);
        contentValues.put(COLUMN_IS_MINE, Integer.valueOf(z ? 1 : 0));
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        if (getData(str) == null) {
            if (this.database.insert(TABLE_IO_DEVICE, null, contentValues) > 0) {
                return getData(str);
            }
            return null;
        }
        if (this.database.update(TABLE_IO_DEVICE, contentValues, "mac_address=?", new String[]{str}) > 0) {
            return getData(str);
        }
        return null;
    }

    public DBIODevice updateName(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str2);
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        String phoneNumber = new LoginUser().getPhoneNumber();
        if (phoneNumber == null || phoneNumber.length() < 10 || getData(str) == null || this.database.update(TABLE_IO_DEVICE, contentValues, "mac_address=?", new String[]{str}) <= 0) {
            return null;
        }
        return getData(str);
    }

    public DBIODevice updateBattery(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_BATTERY, Integer.valueOf(i));
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        String phoneNumber = new LoginUser().getPhoneNumber();
        if (phoneNumber == null || phoneNumber.length() < 10 || getData(str) == null || this.database.update(TABLE_IO_DEVICE, contentValues, "mac_address=?", new String[]{str}) <= 0) {
            return null;
        }
        return getData(str);
    }

    public DBIODevice updateType(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PRODUCT_ID, Integer.valueOf(i));
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        String phoneNumber = new LoginUser().getPhoneNumber();
        if (phoneNumber == null || phoneNumber.length() < 10 || getData(str) == null || this.database.update(TABLE_IO_DEVICE, contentValues, "mac_address=?", new String[]{str}) <= 0) {
            return null;
        }
        return getData(str);
    }

    public DBIODevice updateShareCode(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SHARE_CODE, str2);
        contentValues.put("update_datetime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        if (getData(str) != null && this.database.update(TABLE_IO_DEVICE, contentValues, "mac_address=?", new String[]{str}) > 0) {
            return getData(str);
        }
        return null;
    }

    public boolean delete(String str) {
        return this.database.delete(TABLE_IO_DEVICE, "mac_address=?", new String[]{str}) >= 1;
    }

    public boolean deleteRemocons() {
        return this.database.delete(TABLE_IO_DEVICE, "product_id=?", new String[]{String.valueOf(DeviceUtil.convertSwitcherType(IODevice.ProductId.REMOCON))}) >= 1;
    }

    public boolean deleteMyDevices() {
        return this.database.delete(TABLE_IO_DEVICE, "is_mine=?", new String[]{String.valueOf(1)}) >= 1;
    }
}
