package kr.switcher.switcherm.ui.questionnaire.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireIndicator extends LinearLayout {
    private static final int DEFAULT_INDICATOR_WIDTH = 5;
    private int mIndicatorBackgroundResId;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorUnselectedBackgroundResId;
    private int mIndicatorWidth;
    private DataSetObserver mInternalDataSetObserver;
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private int mLastPosition;
    private ViewPager mViewpager;

    public QuestionnaireIndicator(Context context) {
        super(context);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (QuestionnaireIndicator.this.mViewpager.getAdapter() == null || QuestionnaireIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= 0) {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.getChildAt(questionnaireIndicator.mLastPosition);
                }
                QuestionnaireIndicator.this.checkItem();
                QuestionnaireIndicator.this.mLastPosition = i;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (QuestionnaireIndicator.this.mViewpager == null || (count = QuestionnaireIndicator.this.mViewpager.getAdapter().getCount()) == QuestionnaireIndicator.this.getChildCount()) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= count) {
                    QuestionnaireIndicator.this.mLastPosition = -1;
                } else {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.mLastPosition = questionnaireIndicator.mViewpager.getCurrentItem();
                }
                QuestionnaireIndicator.this.createIndicators();
            }
        };
        init(context, null);
    }

    public QuestionnaireIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (QuestionnaireIndicator.this.mViewpager.getAdapter() == null || QuestionnaireIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= 0) {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.getChildAt(questionnaireIndicator.mLastPosition);
                }
                QuestionnaireIndicator.this.checkItem();
                QuestionnaireIndicator.this.mLastPosition = i;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (QuestionnaireIndicator.this.mViewpager == null || (count = QuestionnaireIndicator.this.mViewpager.getAdapter().getCount()) == QuestionnaireIndicator.this.getChildCount()) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= count) {
                    QuestionnaireIndicator.this.mLastPosition = -1;
                } else {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.mLastPosition = questionnaireIndicator.mViewpager.getCurrentItem();
                }
                QuestionnaireIndicator.this.createIndicators();
            }
        };
        init(context, attributeSet);
    }

    public QuestionnaireIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (QuestionnaireIndicator.this.mViewpager.getAdapter() == null || QuestionnaireIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= 0) {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.getChildAt(questionnaireIndicator.mLastPosition);
                }
                QuestionnaireIndicator.this.checkItem();
                QuestionnaireIndicator.this.mLastPosition = i2;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (QuestionnaireIndicator.this.mViewpager == null || (count = QuestionnaireIndicator.this.mViewpager.getAdapter().getCount()) == QuestionnaireIndicator.this.getChildCount()) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= count) {
                    QuestionnaireIndicator.this.mLastPosition = -1;
                } else {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.mLastPosition = questionnaireIndicator.mViewpager.getCurrentItem();
                }
                QuestionnaireIndicator.this.createIndicators();
            }
        };
        init(context, attributeSet);
    }

    public QuestionnaireIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f, int i222) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
                if (QuestionnaireIndicator.this.mViewpager.getAdapter() == null || QuestionnaireIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= 0) {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.getChildAt(questionnaireIndicator.mLastPosition);
                }
                QuestionnaireIndicator.this.checkItem();
                QuestionnaireIndicator.this.mLastPosition = i22;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (QuestionnaireIndicator.this.mViewpager == null || (count = QuestionnaireIndicator.this.mViewpager.getAdapter().getCount()) == QuestionnaireIndicator.this.getChildCount()) {
                    return;
                }
                if (QuestionnaireIndicator.this.mLastPosition >= count) {
                    QuestionnaireIndicator.this.mLastPosition = -1;
                } else {
                    QuestionnaireIndicator questionnaireIndicator = QuestionnaireIndicator.this;
                    questionnaireIndicator.mLastPosition = questionnaireIndicator.mViewpager.getCurrentItem();
                }
                QuestionnaireIndicator.this.createIndicators();
            }
        };
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        handleTypedArray(context, attributeSet);
        checkIndicatorConfig(context);
    }

    private void handleTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleIndicator);
        this.mIndicatorWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, -1);
        this.mIndicatorHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, -1);
        this.mIndicatorMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, -1);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, R.drawable.white_radius);
        this.mIndicatorBackgroundResId = resourceId;
        this.mIndicatorUnselectedBackgroundResId = typedArrayObtainStyledAttributes.getResourceId(3, resourceId);
        setOrientation(typedArrayObtainStyledAttributes.getInt(7, -1) != 1 ? 0 : 1);
        int i = typedArrayObtainStyledAttributes.getInt(4, -1);
        if (i < 0) {
            i = 17;
        }
        setGravity(i);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void configureIndicator(int i, int i2, int i3) {
        configureIndicator(i, i2, i3, 0, 0, R.drawable.white_radius, R.drawable.white_radius);
    }

    public void configureIndicator(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mIndicatorWidth = i;
        this.mIndicatorHeight = i2;
        this.mIndicatorMargin = i3;
        this.mIndicatorBackgroundResId = i6;
        this.mIndicatorUnselectedBackgroundResId = i7;
        checkIndicatorConfig(getContext());
    }

    private void checkIndicatorConfig(Context context) {
        int iDip2px = this.mIndicatorWidth;
        if (iDip2px < 0) {
            iDip2px = dip2px(5.0f);
        }
        this.mIndicatorWidth = iDip2px;
        int iDip2px2 = this.mIndicatorHeight;
        if (iDip2px2 < 0) {
            iDip2px2 = dip2px(5.0f);
        }
        this.mIndicatorHeight = iDip2px2;
        int iDip2px3 = this.mIndicatorMargin;
        if (iDip2px3 < 0) {
            iDip2px3 = dip2px(5.0f);
        }
        this.mIndicatorMargin = iDip2px3;
        int i = this.mIndicatorBackgroundResId;
        if (i == 0) {
            i = R.drawable.white_radius;
        }
        this.mIndicatorBackgroundResId = i;
        int i2 = this.mIndicatorUnselectedBackgroundResId;
        if (i2 != 0) {
            i = i2;
        }
        this.mIndicatorUnselectedBackgroundResId = i;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewpager = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        this.mLastPosition = -1;
        createIndicators();
        this.mViewpager.removeOnPageChangeListener(this.mInternalPageChangeListener);
        this.mViewpager.addOnPageChangeListener(this.mInternalPageChangeListener);
        this.mInternalPageChangeListener.onPageSelected(this.mViewpager.getCurrentItem());
    }

    public void checkItem() {
        QuestionnaireData questionnaireData = new QuestionnaireData();
        for (int i = 0; i < 5; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                if (i == 0 && questionnaireData.getQuestion1Data() != null) {
                    childAt.setBackgroundResource(this.mIndicatorBackgroundResId);
                } else if (i == 1 && questionnaireData.getQuestion2Data() != null) {
                    childAt.setBackgroundResource(this.mIndicatorBackgroundResId);
                } else if (i == 2 && questionnaireData.getQuestion3Data() != null) {
                    childAt.setBackgroundResource(this.mIndicatorBackgroundResId);
                } else if (i == 3 && questionnaireData.getQuestion4Data() != null) {
                    childAt.setBackgroundResource(this.mIndicatorBackgroundResId);
                } else if (i == 4 && questionnaireData.getQuestion5Data() != null) {
                    childAt.setBackgroundResource(this.mIndicatorBackgroundResId);
                }
            }
        }
    }

    public DataSetObserver getDataSetObserver() {
        return this.mInternalDataSetObserver;
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager viewPager = this.mViewpager;
        if (viewPager == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        viewPager.removeOnPageChangeListener(onPageChangeListener);
        this.mViewpager.addOnPageChangeListener(onPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        removeAllViews();
        int count = this.mViewpager.getAdapter().getCount();
        if (count <= 0) {
            return;
        }
        this.mViewpager.getCurrentItem();
        int orientation = getOrientation();
        for (int i = 0; i < count; i++) {
            addIndicator(orientation, this.mIndicatorUnselectedBackgroundResId);
        }
    }

    private void addIndicator(int i, int i2) {
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.mIndicatorWidth, this.mIndicatorHeight);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = this.mIndicatorMargin;
            layoutParams.rightMargin = this.mIndicatorMargin;
        } else {
            layoutParams.topMargin = this.mIndicatorMargin;
            layoutParams.bottomMargin = this.mIndicatorMargin;
        }
        view.setLayoutParams(layoutParams);
    }

    private class ReverseInterpolator implements Interpolator {
        private ReverseInterpolator() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }
}
