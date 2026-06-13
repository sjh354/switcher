package kr.switcher.switcherm.ui.setting.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import kr.switcher.switcherm.ui.setting.fragment.StrokeLevelIconFragment;
import kr.switcher.switcherm.ui.setting.helper.PageHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class StrokeLevelPagerAdapter extends FragmentStatePagerAdapter {
    public static int MAX_PAGE = 3;
    private static final String TAG = "StrokeLevelPagerAdapter";
    private int currentPosition;
    private PageHashMap pageHashMap;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public StrokeLevelPagerAdapter(FragmentManager fragmentManager, PageHashMap pageHashMap) {
        super(fragmentManager);
        MAX_PAGE = pageHashMap.getSize();
        this.currentPosition = 0;
        this.pageHashMap = pageHashMap;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        this.currentPosition = i;
        return StrokeLevelIconFragment.newInstance(i, this.pageHashMap);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return MAX_PAGE;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
