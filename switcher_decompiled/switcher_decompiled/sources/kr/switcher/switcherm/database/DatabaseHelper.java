package kr.switcher.switcherm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_IO_DEVICE = "create table tb_io_device (mac_address text not null, serial_number text not null, name text not null, share_code text, product_id integer not null, owner text, is_mine integer not null default 1, battery integer not null default -1, creation_datetime timestamp not null default current_timestamp, update_datetime timestamp not null default current_timestamp, primary key (mac_address));";
    private static final String CREATE_PRICING_MODEL = "create table tb_pricing_model (code integer not null, price integer not null, plan_name text not null, plan_info text, primary key (code));";
    private static final String CREATE_PRODUCTION_SERVICE = "create table tb_production_service (mac_address text primary key, register_yn text not null, card_code integer, warranty_date timestamp, price integer );";
    private static final String CREATE_RESERVATION = "create table tb_reservation (_id integer not null, mac_address text not null, title text, mon integer not null default 0, tue integer not null default 0, wed integer not null default 0, thu integer not null default 0, fri integer not null default 0, sat integer not null default 0, sun integer not null default 0, am_pm text not null, hour integer not null default 0, min integer not null default 0, light integer not null default 0, switcher_target text not null, enable integer not null default 0, creation_datetime timestamp not null default current_timestamp, update_datetime timestamp not null default current_timestamp, primary key (_id, mac_address));";
    private static final String CREATE_SUBSCRIPTION_SERVICE = "create table tb_subscription_service (mac_address text primary key, free_yn text key, beginning_date timestamp not null, expiration_date timestamp not null, payment_plan integer not null, payment_card text not null, payment_date timestamp );";
    private static final String CREATE_USER = "create table tb_user (phone_number text primary key, user_name text not null, main_switcher_mac_address text, post_number text, address1 text, address2 text, creation_datetime timestamp not null default current_timestamp, update_datetime timestamp default current_timestamp );";
    private static final String DATABASE_NAME = "switcher_m.db";
    private static final int DATABASE_VERSION = 9;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 9);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_USER);
        sQLiteDatabase.execSQL(CREATE_IO_DEVICE);
        sQLiteDatabase.execSQL(CREATE_SUBSCRIPTION_SERVICE);
        sQLiteDatabase.execSQL(CREATE_PRODUCTION_SERVICE);
        sQLiteDatabase.execSQL(CREATE_RESERVATION);
        sQLiteDatabase.execSQL(CREATE_PRICING_MODEL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_user");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_io_device");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_subscription_service");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_production_service");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_reservation");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_pricing_model");
        onCreate(sQLiteDatabase);
    }
}
