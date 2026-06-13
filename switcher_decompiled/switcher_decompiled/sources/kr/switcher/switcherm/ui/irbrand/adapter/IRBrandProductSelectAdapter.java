package kr.switcher.switcherm.ui.irbrand.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import kr.switcher.switcherm.ui.irbrand.fragment.IRBrandProductIconFragment;
import kr.switcher.switcherm.ui.irbrand.helper.PageHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandProductSelectAdapter extends FragmentStatePagerAdapter {
    public static int MAX_PAGE = 4;
    private static final String TAG = "IRBrandProductSelectAdapter";
    private int currentPosition;
    private PageHashMap pageHashMap;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public IRBrandProductSelectAdapter(FragmentManager fragmentManager, PageHashMap pageHashMap) {
        super(fragmentManager);
        MAX_PAGE = pageHashMap.getSize();
        this.currentPosition = 0;
        this.pageHashMap = pageHashMap;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        this.currentPosition = i;
        return IRBrandProductIconFragment.newInstance(i, this.pageHashMap);
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
