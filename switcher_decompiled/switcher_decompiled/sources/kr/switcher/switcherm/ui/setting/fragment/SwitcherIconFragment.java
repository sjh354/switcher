package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.setting.adapter.SwitcherPagerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherIconFragment extends Fragment {
    private static final String PARM_POSITION = "position";
    int position;

    public static SwitcherIconFragment newInstance(int i) {
        SwitcherIconFragment switcherIconFragment = new SwitcherIconFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARM_POSITION, i);
        switcherIconFragment.setArguments(bundle);
        return switcherIconFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = arguments.getInt(PARM_POSITION);
        }
        View viewInflate = layoutInflater.inflate(R.layout.fragment_timer_page, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_switcher_icon);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_switcher_name);
        int i = this.position;
        if (i != 0) {
            if (i == 1) {
                imageView.setImageResource(R.drawable.ic_switch_two_second);
                textView.setText(R.string.only_bottom_switch);
            }
        } else if (SwitcherPagerAdapter.MAX_PAGE == 1) {
            textView.setText(R.string.switch_name);
            imageView.setImageResource(R.drawable.ic_switch_one);
        } else if (SwitcherPagerAdapter.MAX_PAGE == 2) {
            textView.setText(R.string.only_top_switch);
            imageView.setImageResource(R.drawable.ic_switch_two_first);
        }
        return viewInflate;
    }
}
