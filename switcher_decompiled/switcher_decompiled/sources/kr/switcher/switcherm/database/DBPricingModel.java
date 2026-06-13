package kr.switcher.switcherm.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DBPricingModel {
    private int code;
    private String planInfo;
    private String planName;
    private int price;

    public DBPricingModel(int i, int i2, String str, String str2) {
        this.code = i;
        this.price = i2;
        this.planName = str;
        this.planInfo = str2;
    }

    public DBPricingModel(Cursor cursor) {
        setCode(cursor.getInt(cursor.getColumnIndex(DBPricingModelDAO.COLUMN_CODE)));
        setPrice(cursor.getInt(cursor.getColumnIndex("price")));
        setPlanName(cursor.getString(cursor.getColumnIndex(DBPricingModelDAO.COLUMN_PLAN_NAME)));
        setPlanInfo(cursor.getString(cursor.getColumnIndex(DBPricingModelDAO.COLUMN_PLAN_INFO)));
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int i) {
        this.price = i;
    }

    public String getPlanName() {
        return this.planName;
    }

    public void setPlanName(String str) {
        this.planName = str;
    }

    public String getPlanInfo() {
        return this.planInfo;
    }

    public void setPlanInfo(String str) {
        this.planInfo = str;
    }
}
