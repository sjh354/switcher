package kr.switcher.switcherm.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PreferenceHelper {
    public static Context context;

    public abstract String getFileName();

    public static void setContext(Context context2) {
        context = context2;
    }

    private SharedPreferences.Editor getEditor() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(getFileName(), 0);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public String getString(String str, String str2) {
        try {
            return context.getSharedPreferences(getFileName(), 0).getString(str, str2);
        } catch (NullPointerException unused) {
            return str2;
        }
    }

    public int getInt(String str, int i) {
        return context.getSharedPreferences(getFileName(), 0).getInt(str, i);
    }

    public boolean getBoolean(String str, boolean z) {
        return context.getSharedPreferences(getFileName(), 0).getBoolean(str, z);
    }

    public long getLong(String str, long j) {
        return context.getSharedPreferences(getFileName(), 0).getLong(str, j);
    }

    public void setInt(String str, int i) {
        SharedPreferences.Editor editor = getEditor();
        if (editor != null) {
            editor.putInt(str, i).commit();
        }
    }

    public void setString(String str, String str2) {
        SharedPreferences.Editor editor = getEditor();
        if (editor != null) {
            editor.putString(str, str2).commit();
        }
    }

    public void setBoolean(String str, boolean z) {
        SharedPreferences.Editor editor = getEditor();
        if (editor != null) {
            editor.putBoolean(str, z).commit();
        }
    }

    public void setLong(String str, long j) {
        SharedPreferences.Editor editor = getEditor();
        if (editor != null) {
            editor.putLong(str, j).commit();
        }
    }
}
