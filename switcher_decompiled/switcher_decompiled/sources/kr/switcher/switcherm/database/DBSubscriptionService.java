package kr.switcher.switcherm.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DBSubscriptionService {
    private String beginningDate;
    private String expirationDate;
    private String freeYN;
    private String macAddress;
    private String paymentCard;
    private String paymentDate;
    private int paymentPlan;

    public DBSubscriptionService(Cursor cursor) {
        setMacAddress(cursor.getString(cursor.getColumnIndex("mac_address")));
        setFreeYN(cursor.getString(cursor.getColumnIndex(DBSubscriptionServiceDAO.COLUMN_FREE_YN)));
        setBeginningDate(cursor.getString(cursor.getColumnIndex(DBSubscriptionServiceDAO.COLUMN_BEGINNING_DATE)));
        setExpirationDate(cursor.getString(cursor.getColumnIndex(DBSubscriptionServiceDAO.COLUMN_EXPIRATION_DATE)));
        setPaymentPlan(cursor.getInt(cursor.getColumnIndex(DBSubscriptionServiceDAO.COLUMN_PAYMENT_PLAN)));
        setPaymentCard(cursor.getString(cursor.getColumnIndex(DBSubscriptionServiceDAO.COLUMN_PAYMENT_CARD)));
        setPaymentDate(cursor.getString(cursor.getColumnIndex(DBSubscriptionServiceDAO.COLUMN_PAYMENT_DATE)));
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public String getFreeYN() {
        return this.freeYN;
    }

    public void setFreeYN(String str) {
        this.freeYN = str;
    }

    public String getBeginningDate() {
        return this.beginningDate;
    }

    public void setBeginningDate(String str) {
        this.beginningDate = str;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String str) {
        this.expirationDate = str;
    }

    public int getPaymentPlan() {
        return this.paymentPlan;
    }

    public void setPaymentPlan(int i) {
        this.paymentPlan = i;
    }

    public String getPaymentCard() {
        return this.paymentCard;
    }

    public void setPaymentCard(String str) {
        this.paymentCard = str;
    }

    public String getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(String str) {
        this.paymentDate = str;
    }
}
