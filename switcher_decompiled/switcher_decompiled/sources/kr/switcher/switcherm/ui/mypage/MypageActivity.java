package kr.switcher.switcherm.ui.mypage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.databinding.ActivityMypageBinding;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.mypage.fragments.CompanyInfoFragment;
import kr.switcher.switcherm.ui.mypage.fragments.HelpFragment;
import kr.switcher.switcherm.ui.mypage.fragments.HelpOpenSourceFragment;
import kr.switcher.switcherm.ui.mypage.fragments.HelpReturnFragment;
import kr.switcher.switcherm.ui.mypage.fragments.MypageListFragment;
import kr.switcher.switcherm.ui.troubleshooting.TroubleshootingActivity;
import kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment;
import kr.switcher.switcherm.viewmodel.MypageActivityViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class MypageActivity extends IOActivity {
    private static final String TAG = "MypageActivity";
    private ActivityMypageBinding binder;
    private CompanyInfoFragment companyInfoFragment;
    private HelpFragment helpFragment;
    private HelpOpenSourceFragment helpOpenSourceFragment;
    private HelpReturnFragment helpReturnFragment;
    private MypageListFragment mypageListFragment;
    private HelpTroubleshootingFragment troubleshootingFragment;
    private MypageActivityViewModel viewModel;

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.binder = (ActivityMypageBinding) DataBindingUtil.setContentView(this, R.layout.activity_mypage);
        MypageActivityViewModel mypageActivityViewModel = new MypageActivityViewModel(getApplicationContext(), MypageActivityViewModel.MENU_LIST);
        this.viewModel = mypageActivityViewModel;
        this.binder.setViewModel(mypageActivityViewModel);
        this.mypageListFragment = MypageListFragment.newInstance();
        this.helpFragment = HelpFragment.newInstance();
        this.troubleshootingFragment = HelpTroubleshootingFragment.newInstance(TroubleshootingActivity.FROM_USER_INFO);
        this.helpReturnFragment = HelpReturnFragment.newInstance();
        this.companyInfoFragment = CompanyInfoFragment.newInstance();
        this.helpOpenSourceFragment = HelpOpenSourceFragment.newInstance();
        moveFragment(this.mypageListFragment, "MypageListFragment", MypageActivityViewModel.MENU_LIST);
    }

    private void moveFragment(Fragment fragment, String str, String str2) {
        this.viewModel.setState(str2);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.container, fragment, str);
        try {
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception e) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "moveWifiConnectFragment", e);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MypageListFragment mypageListFragment = (MypageListFragment) getSupportFragmentManager().findFragmentByTag("MypageListFragment");
        HelpFragment helpFragment = (HelpFragment) getSupportFragmentManager().findFragmentByTag("HelpFragment");
        HelpTroubleshootingFragment helpTroubleshootingFragment = (HelpTroubleshootingFragment) getSupportFragmentManager().findFragmentByTag("HelpTroubleshootingFragment");
        HelpReturnFragment helpReturnFragment = (HelpReturnFragment) getSupportFragmentManager().findFragmentByTag("HelpReturnFragment");
        CompanyInfoFragment companyInfoFragment = (CompanyInfoFragment) getSupportFragmentManager().findFragmentByTag("CompanyInfoFragment");
        HelpOpenSourceFragment helpOpenSourceFragment = (HelpOpenSourceFragment) getSupportFragmentManager().findFragmentByTag("HelpOpenSourceFragment");
        if (mypageListFragment != null) {
            finish();
            return;
        }
        if (helpFragment != null) {
            moveFragment(this.mypageListFragment, "MypageListFragment", MypageActivityViewModel.MENU_LIST);
            return;
        }
        if (helpTroubleshootingFragment != null) {
            moveFragment(this.helpFragment, "HelpFragment", MypageActivityViewModel.MENU_HELP);
            return;
        }
        if (helpReturnFragment != null) {
            moveFragment(this.helpFragment, "HelpFragment", MypageActivityViewModel.MENU_HELP);
        } else if (companyInfoFragment != null) {
            moveFragment(this.helpFragment, "HelpFragment", MypageActivityViewModel.MENU_HELP);
        } else if (helpOpenSourceFragment != null) {
            moveFragment(this.helpFragment, "HelpFragment", MypageActivityViewModel.MENU_HELP);
        }
    }

    public void onLeftButtonClicked(View view) {
        onBackPressed();
    }

    public void onRightButtonClicked(View view) {
    }

    public void onMoveHelpButtonClicked(View view) {
        moveFragment(this.helpFragment, "HelpFragment", MypageActivityViewModel.MENU_HELP);
    }

    public void onMenu1ButtonClicked(View view) {
        moveFragment(this.troubleshootingFragment, "HelpTroubleshootingFragment", MypageActivityViewModel.MENU_HELP_TROUBLESHOOTING);
    }

    public void onMenu2ButtonClicked(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_IO)));
    }

    public void onMenu3ButtonClicked(View view) {
        moveFragment(this.helpReturnFragment, "HelpReturnFragment", MypageActivityViewModel.MENU_HELP_RETURN);
    }

    public void onMenu4ButtonClicked(View view) {
        moveFragment(this.companyInfoFragment, "CompanyInfoFragment", MypageActivityViewModel.MENU_HELP_COMPANY_INFO);
    }

    public void onMenu5ButtonClicked(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_TERMS_OF_USE)));
    }

    public void onMenu6ButtonClicked(View view) {
        moveFragment(this.helpOpenSourceFragment, "HelpOpenSourceFragment", MypageActivityViewModel.MENU_HELP_OPEN_SOURCE);
    }

    public void onMoveKakaotalkButtonClicked(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_KAKAO_YELLOID)));
    }

    public void onMoveFacebookButtonClicked(View view) {
        this.companyInfoFragment.onMoveFacebookButtonClicked();
    }

    public void onMoveIOWebsiteButtonClicked(View view) {
        this.companyInfoFragment.onMoveIOWebsiteButtonClicked();
    }

    public void onOpenSourceLink1ButtonClicked(View view) {
        this.helpOpenSourceFragment.onOpenSourceLink1ButtonClicked();
    }

    public void onOpenSourceLink2ButtonClicked(View view) {
        this.helpOpenSourceFragment.onOpenSourceLink2ButtonClicked();
    }

    public void onOpenSourceLink3ButtonClicked(View view) {
        this.helpOpenSourceFragment.onOpenSourceLink3ButtonClicked();
    }
}
