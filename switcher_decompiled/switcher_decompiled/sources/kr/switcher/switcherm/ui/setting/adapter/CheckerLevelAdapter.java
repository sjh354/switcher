package kr.switcher.switcherm.ui.setting.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import kr.switcher.switcherm.ui.setting.fragment.CheckerLevelIconFragment;
import kr.switcher.switcherm.ui.setting.helper.CheckerPageHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerLevelAdapter extends FragmentStatePagerAdapter {
    public static int MAX_PAGE = 2;
    private static final String TAG = "CheckerLevelAdapter";
    private int currentPosition;
    private CheckerPageHashMap pageHashMap;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public CheckerLevelAdapter(FragmentManager fragmentManager, CheckerPageHashMap checkerPageHashMap) {
        super(fragmentManager);
        MAX_PAGE = checkerPageHashMap.getSize();
        this.currentPosition = 0;
        this.pageHashMap = checkerPageHashMap;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        this.currentPosition = i;
        return CheckerLevelIconFragment.newInstance(i, this.pageHashMap);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return MAX_PAGE;
    }

    public String getControllerName(int i) {
        return this.pageHashMap.getProposeMessage(i);
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
