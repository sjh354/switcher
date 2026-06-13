package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.setting.helper.CheckerPageHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerLevelIconFragment extends Fragment {
    private static final String PARM_POSITION = "position";
    private static CheckerPageHashMap pageHashMap;

    @BindView(R.id.iv_level_info)
    ImageView iv_level_info;

    public static CheckerLevelIconFragment newInstance(int i, CheckerPageHashMap checkerPageHashMap) {
        CheckerLevelIconFragment checkerLevelIconFragment = new CheckerLevelIconFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARM_POSITION, i);
        checkerLevelIconFragment.setArguments(bundle);
        pageHashMap = checkerPageHashMap;
        return checkerLevelIconFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        int id = arguments != null ? arguments.getInt(PARM_POSITION) : 0;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_checker_level_page, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        if (pageHashMap.getSize() <= 1) {
            id = pageHashMap.getId();
        }
        this.iv_level_info.setImageDrawable(pageHashMap.getPageDrawable(id));
        return viewInflate;
    }
}
