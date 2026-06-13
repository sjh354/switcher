package kr.switcher.switcherm.ui.setting.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import kr.switcher.switcherm.ui.setting.fragment.SwitcherIconFragment;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherPagerAdapter extends FragmentStatePagerAdapter {
    public static int MAX_PAGE = 3;
    public static final int SWITCH_1WAY_TYPE = 0;
    public static final int SWITCH_2WAY_TYPE = 1;
    private static final String TAG = "SwitcherPagerAdapter";
    private int currentPosition;

    public SwitcherPagerAdapter(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        MAX_PAGE = i;
        this.currentPosition = 0;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        this.currentPosition = i;
        return SwitcherIconFragment.newInstance(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return MAX_PAGE;
    }
}
