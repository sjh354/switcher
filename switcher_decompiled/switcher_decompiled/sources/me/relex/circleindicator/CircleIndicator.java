package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class CircleIndicator extends LinearLayout {
    private static final int DEFAULT_INDICATOR_WIDTH = 5;
    private Animator mAnimatorIn;
    private Animator mAnimatorOut;
    private int mAnimatorResId;
    private int mAnimatorReverseResId;
    private Animator mImmediateAnimatorIn;
    private Animator mImmediateAnimatorOut;
    private int mIndicatorBackgroundResId;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorUnselectedBackgroundResId;
    private int mIndicatorWidth;
    private DataSetObserver mInternalDataSetObserver;
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private int mLastPosition;
    private ViewPager mViewpager;

    public CircleIndicator(Context context) {
        super(context);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CircleIndicator circleIndicator;
                View childAt;
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                    CircleIndicator.this.mAnimatorIn.end();
                    CircleIndicator.this.mAnimatorIn.cancel();
                }
                if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                    CircleIndicator.this.mAnimatorOut.end();
                    CircleIndicator.this.mAnimatorOut.cancel();
                }
                if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                    childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                    CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    CircleIndicator.this.mAnimatorIn.start();
                }
                View childAt2 = CircleIndicator.this.getChildAt(i);
                if (childAt2 != null) {
                    childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                    CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    CircleIndicator.this.mAnimatorOut.start();
                }
                CircleIndicator.this.mLastPosition = i;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null || (count = CircleIndicator.this.mViewpager.getAdapter().getCount()) == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition >= count) {
                    CircleIndicator.this.mLastPosition = -1;
                } else {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                }
                CircleIndicator.this.createIndicators();
            }
        };
        init(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CircleIndicator circleIndicator;
                View childAt;
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                    CircleIndicator.this.mAnimatorIn.end();
                    CircleIndicator.this.mAnimatorIn.cancel();
                }
                if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                    CircleIndicator.this.mAnimatorOut.end();
                    CircleIndicator.this.mAnimatorOut.cancel();
                }
                if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                    childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                    CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    CircleIndicator.this.mAnimatorIn.start();
                }
                View childAt2 = CircleIndicator.this.getChildAt(i);
                if (childAt2 != null) {
                    childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                    CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    CircleIndicator.this.mAnimatorOut.start();
                }
                CircleIndicator.this.mLastPosition = i;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null || (count = CircleIndicator.this.mViewpager.getAdapter().getCount()) == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition >= count) {
                    CircleIndicator.this.mLastPosition = -1;
                } else {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                }
                CircleIndicator.this.createIndicators();
            }
        };
        init(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                CircleIndicator circleIndicator;
                View childAt;
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                    CircleIndicator.this.mAnimatorIn.end();
                    CircleIndicator.this.mAnimatorIn.cancel();
                }
                if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                    CircleIndicator.this.mAnimatorOut.end();
                    CircleIndicator.this.mAnimatorOut.cancel();
                }
                if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                    childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                    CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    CircleIndicator.this.mAnimatorIn.start();
                }
                View childAt2 = CircleIndicator.this.getChildAt(i2);
                if (childAt2 != null) {
                    childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                    CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    CircleIndicator.this.mAnimatorOut.start();
                }
                CircleIndicator.this.mLastPosition = i2;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null || (count = CircleIndicator.this.mViewpager.getAdapter().getCount()) == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition >= count) {
                    CircleIndicator.this.mLastPosition = -1;
                } else {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                }
                CircleIndicator.this.createIndicators();
            }
        };
        init(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIndicatorMargin = -1;
        this.mIndicatorWidth = -1;
        this.mIndicatorHeight = -1;
        this.mAnimatorResId = R.animator.scale_with_alpha;
        this.mAnimatorReverseResId = 0;
        this.mIndicatorBackgroundResId = R.drawable.white_radius;
        this.mIndicatorUnselectedBackgroundResId = R.drawable.white_radius;
        this.mLastPosition = -1;
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f, int i222) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
                CircleIndicator circleIndicator;
                View childAt;
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                if (CircleIndicator.this.mAnimatorIn.isRunning()) {
                    CircleIndicator.this.mAnimatorIn.end();
                    CircleIndicator.this.mAnimatorIn.cancel();
                }
                if (CircleIndicator.this.mAnimatorOut.isRunning()) {
                    CircleIndicator.this.mAnimatorOut.end();
                    CircleIndicator.this.mAnimatorOut.cancel();
                }
                if (CircleIndicator.this.mLastPosition >= 0 && (childAt = (circleIndicator = CircleIndicator.this).getChildAt(circleIndicator.mLastPosition)) != null) {
                    childAt.setBackgroundResource(CircleIndicator.this.mIndicatorUnselectedBackgroundResId);
                    CircleIndicator.this.mAnimatorIn.setTarget(childAt);
                    CircleIndicator.this.mAnimatorIn.start();
                }
                View childAt2 = CircleIndicator.this.getChildAt(i22);
                if (childAt2 != null) {
                    childAt2.setBackgroundResource(CircleIndicator.this.mIndicatorBackgroundResId);
                    CircleIndicator.this.mAnimatorOut.setTarget(childAt2);
                    CircleIndicator.this.mAnimatorOut.start();
                }
                CircleIndicator.this.mLastPosition = i22;
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int count;
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null || (count = CircleIndicator.this.mViewpager.getAdapter().getCount()) == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition >= count) {
                    CircleIndicator.this.mLastPosition = -1;
                } else {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                }
                CircleIndicator.this.createIndicators();
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
        this.mIndicatorWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_width, -1);
        this.mIndicatorHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_height, -1);
        this.mIndicatorMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleIndicator_ci_margin, -1);
        this.mAnimatorResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator, R.animator.scale_with_alpha);
        this.mAnimatorReverseResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_animator_reverse, 0);
        this.mIndicatorBackgroundResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable, R.drawable.white_radius);
        this.mIndicatorUnselectedBackgroundResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircleIndicator_ci_drawable_unselected, this.mIndicatorBackgroundResId);
        setOrientation(typedArrayObtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_orientation, -1) == 1 ? 1 : 0);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleIndicator_ci_gravity, -1);
        if (i < 0) {
            i = 17;
        }
        setGravity(i);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void configureIndicator(int i, int i2, int i3) {
        configureIndicator(i, i2, i3, R.animator.scale_with_alpha, 0, R.drawable.white_radius, R.drawable.white_radius);
    }

    public void configureIndicator(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mIndicatorWidth = i;
        this.mIndicatorHeight = i2;
        this.mIndicatorMargin = i3;
        this.mAnimatorResId = i4;
        this.mAnimatorReverseResId = i5;
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
        int i = this.mAnimatorResId;
        if (i == 0) {
            i = R.animator.scale_with_alpha;
        }
        this.mAnimatorResId = i;
        this.mAnimatorOut = createAnimatorOut(context);
        Animator animatorCreateAnimatorOut = createAnimatorOut(context);
        this.mImmediateAnimatorOut = animatorCreateAnimatorOut;
        animatorCreateAnimatorOut.setDuration(0L);
        this.mAnimatorIn = createAnimatorIn(context);
        Animator animatorCreateAnimatorIn = createAnimatorIn(context);
        this.mImmediateAnimatorIn = animatorCreateAnimatorIn;
        animatorCreateAnimatorIn.setDuration(0L);
        int i2 = this.mIndicatorBackgroundResId;
        if (i2 == 0) {
            i2 = R.drawable.white_radius;
        }
        this.mIndicatorBackgroundResId = i2;
        int i3 = this.mIndicatorUnselectedBackgroundResId;
        if (i3 != 0) {
            i2 = i3;
        }
        this.mIndicatorUnselectedBackgroundResId = i2;
    }

    private Animator createAnimatorOut(Context context) {
        return AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
    }

    private Animator createAnimatorIn(Context context) {
        int i = this.mAnimatorReverseResId;
        if (i == 0) {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, this.mAnimatorResId);
            animatorLoadAnimator.setInterpolator(new ReverseInterpolator());
            return animatorLoadAnimator;
        }
        return AnimatorInflater.loadAnimator(context, i);
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
        int currentItem = this.mViewpager.getCurrentItem();
        int orientation = getOrientation();
        for (int i = 0; i < count; i++) {
            if (currentItem == i) {
                addIndicator(orientation, this.mIndicatorBackgroundResId, this.mImmediateAnimatorOut);
            } else {
                addIndicator(orientation, this.mIndicatorUnselectedBackgroundResId, this.mImmediateAnimatorIn);
            }
        }
    }

    private void addIndicator(int i, int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
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
        animator.setTarget(view);
        animator.start();
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
