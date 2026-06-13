package kr.switcher.switcherm.ui.ircommandtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerInsertIrCommandFragment;
import kr.switcher.switcherm.ui.ircommandtest.fragment.LinkerTestIrCommandFragment;

/* JADX INFO: loaded from: classes2.dex */
public class IrCommandTestScreenController {
    public static void moveInsertFragment(AppCompatActivity appCompatActivity, String str, String str2) {
        moveFragment(appCompatActivity, LinkerInsertIrCommandFragment.newInstance(str, str2), "LinkerInsertIrCommandFragment");
    }

    public static void moveTestFragment(AppCompatActivity appCompatActivity, String str, IRCommand iRCommand) {
        moveFragment(appCompatActivity, LinkerTestIrCommandFragment.newInstance(str, iRCommand), "LinkerTestIrCommandFragment");
    }

    private static void moveFragment(AppCompatActivity appCompatActivity, Fragment fragment, String str) {
        FragmentTransaction fragmentTransactionBeginTransaction = appCompatActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment, str);
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error("ContentValues", new OAuthToken().getOAuthToken(), "moveWifiConnectFragment", e);
        }
    }
}
