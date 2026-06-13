package kr.switcher.switcherm.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DBProductionService {
    private int cardCode;
    private String macAddress;
    private int price;
    private String registerYN;
    private String warrantyDate;

    public DBProductionService(Cursor cursor) {
        setMacAddress(cursor.getString(cursor.getColumnIndex("mac_address")));
        setRegisterYN(cursor.getString(cursor.getColumnIndex(DBProductionServiceDAO.COLUMN_REGISTER_YN)));
        setPrice(cursor.getInt(cursor.getColumnIndex("price")));
        setCardCode(cursor.getInt(cursor.getColumnIndex(DBProductionServiceDAO.COLUMN_CARD_CODE)));
        setWarrantyDate(cursor.getString(cursor.getColumnIndex(DBProductionServiceDAO.COLUMN_WARRANTY_DATE)));
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String getRegisterYN() {
        return this.registerYN;
    }

    public void setRegisterYN(String str) {
        this.registerYN = str;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int i) {
        this.price = i;
    }

    public int getCardCode() {
        return this.cardCode;
    }

    public void setCardCode(int i) {
        this.cardCode = i;
    }

    public String getWarrantyDate() {
        return this.warrantyDate;
    }

    public void setWarrantyDate(String str) {
        this.warrantyDate = str;
    }
}
