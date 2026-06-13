package kr.switcher.ioble.scanner;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class BLEScannerFactory {
    public static BLEScanner createBLEScanner(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new BLENewScanner();
        }
        return new BLEOldScanner();
    }
}
