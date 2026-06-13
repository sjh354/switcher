package kr.switcher.switcherm.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DBUtil {
    public static boolean checkCursor(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        if (cursor.getCount() >= 1 && cursor.moveToFirst()) {
            return true;
        }
        cursor.close();
        return false;
    }
}
