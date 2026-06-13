package kr.switcher.switcherm.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DBUser {
    private String address1;
    private String address2;
    private String createDate;
    private String mainSwitcherCode;
    private String phoneNumber;
    private String postNumber;
    private String updateDate;
    private String userName;

    public DBUser() {
    }

    public DBUser(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(DBUserDAO.COLUMN_PHONE_NUMBER);
        int columnIndex2 = cursor.getColumnIndex(DBUserDAO.COLUMN_USER_NAME);
        int columnIndex3 = cursor.getColumnIndex(DBUserDAO.COLUMN_MAIN_SWITCHER_MAC_ADDRESS);
        int columnIndex4 = cursor.getColumnIndex(DBUserDAO.COLUMN_POST_NUMBER);
        int columnIndex5 = cursor.getColumnIndex(DBUserDAO.COLUMN_ADDRESS1);
        int columnIndex6 = cursor.getColumnIndex(DBUserDAO.COLUMN_ADDRESS2);
        int columnIndex7 = cursor.getColumnIndex("creation_datetime");
        int columnIndex8 = cursor.getColumnIndex("update_datetime");
        setPhoneNumber(cursor.getString(columnIndex));
        setUserName(cursor.getString(columnIndex2));
        setMainSwitcherCode(cursor.getString(columnIndex3));
        setPostNumber(cursor.getString(columnIndex4));
        setAddress1(cursor.getString(columnIndex5));
        setAddress2(cursor.getString(columnIndex6));
        setCreateDate(cursor.getString(columnIndex7));
        setUpdateDate(cursor.getString(columnIndex8));
    }

    public DBUser(String str, String str2, String str3, String str4, String str5, String str6) {
        this.phoneNumber = str;
        this.userName = str2;
        this.mainSwitcherCode = str3;
        this.postNumber = str4;
        this.address1 = str5;
        this.address2 = str6;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getMainSwitcherCode() {
        return this.mainSwitcherCode;
    }

    public void setMainSwitcherCode(String str) {
        this.mainSwitcherCode = str;
    }

    public String getPostNumber() {
        return this.postNumber;
    }

    public void setPostNumber(String str) {
        this.postNumber = str;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String str) {
        this.address1 = str;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String str) {
        this.address2 = str;
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
