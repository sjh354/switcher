package kr.switcher.switcherm.ui.questionnaire.pager;

import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.ui.questionnaire.OnSelectItemListener;
import kr.switcher.switcherm.ui.questionnaire.fragment.CardFragment;

/* JADX INFO: loaded from: classes2.dex */
public class CardFragmentPagerAdapter extends FragmentStatePagerAdapter implements CardAdapter {
    private float baseElevation;
    private List<CardFragment> fragments;
    private OnSelectItemListener listener;

    public CardFragmentPagerAdapter(FragmentManager fragmentManager, float f, OnSelectItemListener onSelectItemListener) {
        super(fragmentManager);
        this.fragments = new ArrayList();
        this.baseElevation = f;
        this.listener = onSelectItemListener;
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.pager.CardAdapter
    public float getBaseElevation() {
        return this.baseElevation;
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.pager.CardAdapter
    public CardView getCardViewAt(int i) {
        return this.fragments.get(i).getCardView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.fragments.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.fragments.get(i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Object objInstantiateItem = super.instantiateItem(viewGroup, i);
        this.fragments.set(i, (CardFragment) objInstantiateItem);
        return objInstantiateItem;
    }

    public void addCardFragment(CardFragment cardFragment) {
        this.fragments.add(CardFragment.newInstance(this.listener, cardFragment));
    }
}
