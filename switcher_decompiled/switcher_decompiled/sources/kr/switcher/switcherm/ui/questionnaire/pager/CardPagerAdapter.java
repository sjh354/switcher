package kr.switcher.switcherm.ui.questionnaire.pager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class CardPagerAdapter extends PagerAdapter implements CardAdapter {
    private float mBaseElevation;
    private List<CardItem> mData = new ArrayList();
    private List<CardView> mViews = new ArrayList();

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public void addCardItem(CardItem cardItem) {
        this.mViews.add(null);
        this.mData.add(cardItem);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.pager.CardAdapter
    public float getBaseElevation() {
        return this.mBaseElevation;
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.pager.CardAdapter
    public CardView getCardViewAt(int i) {
        return this.mViews.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_questionnaire, viewGroup, false);
        viewGroup.addView(viewInflate);
        bind(this.mData.get(i), viewInflate);
        CardView cardView = (CardView) viewInflate.findViewById(R.id.cardView);
        if (this.mBaseElevation == 0.0f) {
            this.mBaseElevation = cardView.getCardElevation();
        }
        cardView.setMaxCardElevation(this.mBaseElevation * 3.0f);
        this.mViews.set(i, cardView);
        return viewInflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        this.mViews.set(i, null);
    }

    private void bind(CardItem cardItem, View view) {
        TextView textView = (TextView) view.findViewById(R.id.titleTextView);
        TextView textView2 = (TextView) view.findViewById(R.id.contentTextView);
        textView.setText(cardItem.getTitle());
        textView2.setText(cardItem.getText());
    }
}
