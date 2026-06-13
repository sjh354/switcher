package kr.switcher.switcherm.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DBReservation {
    private String amPm;
    private String createDate;
    private boolean enable;
    private boolean fri;
    private int hour;
    private long id;
    private boolean light;
    private int min;
    private boolean mon;
    private String productCode;
    private boolean sat;
    private boolean sun;
    private String switcherTarget;
    private boolean thu;
    private String title;
    private boolean tue;
    private String updateDate;
    private boolean wed;

    public DBReservation(Cursor cursor) {
        setProductCode(cursor.getString(cursor.getColumnIndex("mac_address")));
        setId(cursor.getLong(cursor.getColumnIndex(DBReservationDAO.COLUMN_ID)));
        setTitle(cursor.getString(cursor.getColumnIndex(DBReservationDAO.COLUMN_TITLE)));
        setMon(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_MON)) > 0);
        setTue(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_TUE)) > 0);
        setWed(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_WED)) > 0);
        setThu(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_THU)) > 0);
        setFri(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_FRI)) > 0);
        setSat(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_SAT)) > 0);
        setSun(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_SUN)) > 0);
        setAmPm(cursor.getString(cursor.getColumnIndex(DBReservationDAO.COLUMN_AM_PM)));
        setHour(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_HOUR)));
        setMin(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_MIN)));
        setSwitcherTarget(cursor.getString(cursor.getColumnIndex(DBReservationDAO.COLUMN_SWITCHER_TARGET)));
        setEnable(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_ENABLE)) > 0);
        setLight(cursor.getInt(cursor.getColumnIndex(DBReservationDAO.COLUMN_LIGHT)) > 0);
        setCreateDate(cursor.getString(cursor.getColumnIndex("creation_datetime")));
        setUpdateDate(cursor.getString(cursor.getColumnIndex("update_datetime")));
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isMon() {
        return this.mon;
    }

    public void setMon(boolean z) {
        this.mon = z;
    }

    public boolean isTue() {
        return this.tue;
    }

    public void setTue(boolean z) {
        this.tue = z;
    }

    public boolean isWed() {
        return this.wed;
    }

    public void setWed(boolean z) {
        this.wed = z;
    }

    public boolean isThu() {
        return this.thu;
    }

    public void setThu(boolean z) {
        this.thu = z;
    }

    public boolean isFri() {
        return this.fri;
    }

    public void setFri(boolean z) {
        this.fri = z;
    }

    public boolean isSat() {
        return this.sat;
    }

    public void setSat(boolean z) {
        this.sat = z;
    }

    public boolean isSun() {
        return this.sun;
    }

    public void setSun(boolean z) {
        this.sun = z;
    }

    public String getAmPm() {
        return this.amPm;
    }

    public void setAmPm(String str) {
        this.amPm = str;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int i) {
        this.hour = i;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int i) {
        this.min = i;
    }

    public String getSwitcherTarget() {
        return this.switcherTarget;
    }

    public void setSwitcherTarget(String str) {
        this.switcherTarget = str;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public boolean isLight() {
        return this.light;
    }

    public void setLight(boolean z) {
        this.light = z;
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
