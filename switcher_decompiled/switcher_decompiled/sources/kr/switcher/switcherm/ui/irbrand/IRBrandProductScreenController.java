package kr.switcher.switcherm.ui.irbrand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.irbrand.fragment.IRBrandListFragment;
import kr.switcher.switcherm.ui.irbrand.fragment.IRBrandProductSelectFragment;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandProductScreenController {
    public static void moveSelectProductFragment(AppCompatActivity appCompatActivity) {
        moveFragment(appCompatActivity, IRBrandProductSelectFragment.newInstance(), "IRBrandProductSelectFragment");
    }

    public static void moveIRBrandListFragment(AppCompatActivity appCompatActivity, Remocon.ControllerID controllerID, String str) {
        moveFragment(appCompatActivity, IRBrandListFragment.newInstance(controllerID, str), "IRBrandListFragment");
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
