package kr.switcher.switcherm.ui.mypage.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentHelpBinding;
import kr.switcher.switcherm.viewmodel.HelpFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class HelpFragment extends Fragment {
    private static final String TAG = "HelpFragment";
    private FragmentHelpBinding binder;
    private HelpFragmentViewModel viewModel;

    public static HelpFragment newInstance() {
        HelpFragment helpFragment = new HelpFragment();
        helpFragment.setArguments(new Bundle());
        return helpFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentHelpBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_help, viewGroup, false);
        HelpFragmentViewModel helpFragmentViewModel = new HelpFragmentViewModel(getContext());
        this.viewModel = helpFragmentViewModel;
        this.binder.setViewModel(helpFragmentViewModel);
        return this.binder.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_6_0_0));
    }
}
