package kr.switcher.switcherm.common.activity;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class IOActivity extends AppCompatActivity {
    public static String ACTION = "ACTION";
    public static int ACTION_MAIN = 0;
    public static int ACTION_PUSH = 3;
    public static int ACTION_SIGNAL = 2;
    public static String ACTION_VALUE = "ACTION_VALUE";
    public static int ACTION_WIDGET = 1;
    public static int ACTION_WIDGET_BANNER = 4;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (IOUtil.isRestartApp()) {
            IOUtil.restartApp(this);
        }
    }

    protected void setStatusBarColor(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(i);
        }
    }
}
