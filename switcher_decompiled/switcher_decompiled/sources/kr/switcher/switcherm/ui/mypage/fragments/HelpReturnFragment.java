package kr.switcher.switcherm.ui.mypage.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class HelpReturnFragment extends Fragment {
    private static final String TAG = "HelpReturnFragment";

    public static HelpReturnFragment newInstance() {
        HelpReturnFragment helpReturnFragment = new HelpReturnFragment();
        helpReturnFragment.setArguments(new Bundle());
        return helpReturnFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_help_return, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_6_0_0_1));
    }
}
