package kr.switcher.switcherm.ui.questionnaire.pager;

import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {
    private CardAdapter mAdapter;
    private float mLastOffset;
    private boolean mScalingEnabled;
    private ViewPager mViewPager;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
    }

    public ShadowTransformer(ViewPager viewPager, CardAdapter cardAdapter) {
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
        this.mAdapter = cardAdapter;
    }

    public void enableScaling(boolean z) {
        CardView cardViewAt;
        boolean z2 = this.mScalingEnabled;
        if (z2 && !z) {
            CardView cardViewAt2 = this.mAdapter.getCardViewAt(this.mViewPager.getCurrentItem());
            if (cardViewAt2 != null) {
                cardViewAt2.animate().scaleY(1.0f);
                cardViewAt2.animate().scaleX(1.0f);
            }
        } else if (!z2 && z && (cardViewAt = this.mAdapter.getCardViewAt(this.mViewPager.getCurrentItem())) != null) {
            cardViewAt.animate().scaleY(1.1f);
            cardViewAt.animate().scaleX(1.1f);
        }
        this.mScalingEnabled = z;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        float f2;
        int i3;
        float baseElevation = this.mAdapter.getBaseElevation();
        if (this.mLastOffset > f) {
            i3 = i + 1;
            f2 = 1.0f - f;
        } else {
            f2 = f;
            i3 = i;
            i++;
        }
        if (i > this.mAdapter.getCount() - 1 || i3 > this.mAdapter.getCount() - 1) {
            return;
        }
        CardView cardViewAt = this.mAdapter.getCardViewAt(i3);
        if (cardViewAt != null) {
            if (this.mScalingEnabled) {
                float f3 = (float) ((((double) (1.0f - f2)) * 0.1d) + 1.0d);
                cardViewAt.setScaleX(f3);
                cardViewAt.setScaleY(f3);
            }
            cardViewAt.setCardElevation((baseElevation * 2.0f * (1.0f - f2)) + baseElevation);
        }
        CardView cardViewAt2 = this.mAdapter.getCardViewAt(i);
        if (cardViewAt2 != null) {
            if (this.mScalingEnabled) {
                float f4 = (float) ((((double) f2) * 0.1d) + 1.0d);
                cardViewAt2.setScaleX(f4);
                cardViewAt2.setScaleY(f4);
            }
            cardViewAt2.setCardElevation(baseElevation + (2.0f * baseElevation * f2));
        }
        this.mLastOffset = f;
    }
}
