package kr.switcher.switcherm.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;

/* JADX INFO: loaded from: classes2.dex */
public class MainDefaultFragment extends Fragment {
    private static final String TAG = "MainDefaultFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    public static MainDefaultFragment newInstance(MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainDefaultFragment mainDefaultFragment = new MainDefaultFragment();
        mainDefaultFragment.setArguments(new Bundle());
        return mainDefaultFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_default, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        callback.onMainData("", null, "", IOUtil.getStringResource(R.string.connect_switcher), MainActivity.MainBackgroundState.NORMAL);
        return viewInflate;
    }
}
