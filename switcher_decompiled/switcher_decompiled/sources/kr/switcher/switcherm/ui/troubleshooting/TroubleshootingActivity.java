package kr.switcher.switcherm.ui.troubleshooting;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment;

/* JADX INFO: loaded from: classes2.dex */
public class TroubleshootingActivity extends AppCompatActivity {
    public static final String AI_FROM = "FROM";
    public static final String FROM_SCANNED_SWITCHER = "SCANNED_SWITCHER";
    public static final String FROM_USER_INFO = "USER_INFO";
    private static final String TAG = "TroubleshootingActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_troubleshooting);
        String stringExtra = getIntent().getStringExtra(AI_FROM);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, HelpTroubleshootingFragment.newInstance(stringExtra), "HelpTroubleshootingFragment");
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "onCreateRemocon", e);
        }
    }

    public void onLeftButtonClicked(View view) {
        finish();
    }
}
