package kr.switcher.switcherm.ui.mypage.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class CompanyInfoFragment extends Fragment {
    private static final String TAG = "CompanyInfoFragment";

    public static CompanyInfoFragment newInstance() {
        CompanyInfoFragment companyInfoFragment = new CompanyInfoFragment();
        companyInfoFragment.setArguments(new Bundle());
        return companyInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_company_info, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_6_0_0_4));
    }

    public void onMoveFacebookButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_FACEBOOK_PAGE)));
    }

    public void onMoveIOWebsiteButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_IO)));
    }
}
