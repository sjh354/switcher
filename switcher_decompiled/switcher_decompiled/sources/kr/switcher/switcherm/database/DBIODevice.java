package kr.switcher.switcherm.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DBIODevice {
    public static final int GUEST = 0;
    public static final int MINE = 1;
    private int battery;
    private String createDate;
    private int isMine;
    private String macAddress;
    private String name;
    private String owner;
    private int productId;
    private String serialNumber;
    private String shareCode;
    private String updateDate;

    public DBIODevice(Cursor cursor) {
        setMacAddress(cursor.getString(cursor.getColumnIndex("mac_address")));
        setSerialNumber(cursor.getString(cursor.getColumnIndex(DBIODeviceDAO.COLUMN_SERIAL_NUMBER)));
        setName(cursor.getString(cursor.getColumnIndex("name")));
        setShareCode(cursor.getString(cursor.getColumnIndex(DBIODeviceDAO.COLUMN_SHARE_CODE)));
        setProductId(cursor.getInt(cursor.getColumnIndex(DBIODeviceDAO.COLUMN_PRODUCT_ID)));
        setOwner(cursor.getString(cursor.getColumnIndex(DBIODeviceDAO.COLUMN_OWNER)));
        setMine(cursor.getInt(cursor.getColumnIndex(DBIODeviceDAO.COLUMN_IS_MINE)));
        setBattery(cursor.getInt(cursor.getColumnIndex(DBIODeviceDAO.COLUMN_BATTERY)));
        setCreateDate(cursor.getString(cursor.getColumnIndex("creation_datetime")));
        setUpdateDate(cursor.getString(cursor.getColumnIndex("update_datetime")));
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getShareCode() {
        return this.shareCode;
    }

    public void setShareCode(String str) {
        this.shareCode = str;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i) {
        this.productId = i;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public int isMine() {
        return this.isMine;
    }

    public void setMine(int i) {
        this.isMine = i;
    }

    public int getBattery() {
        return this.battery;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String str) {
        this.createDate = str;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String str) {
        this.updateDate = str;
    }
}
