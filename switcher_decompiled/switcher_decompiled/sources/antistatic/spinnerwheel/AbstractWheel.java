package antistatic.spinnerwheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import antistatic.spinnerwheel.WheelScroller;
import antistatic.spinnerwheel.adapters.WheelViewAdapter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractWheel extends View {
    private static final boolean DEF_IS_CYCLIC = false;
    private static final int DEF_VISIBLE_ITEMS = 4;
    private static int itemID = -1;
    private final String LOG_TAG;
    private List<OnWheelChangedListener> changingListeners;
    private List<OnWheelClickedListener> clickingListeners;
    protected int mCurrentItemIdx;
    private DataSetObserver mDataObserver;
    protected int mFirstItemIdx;
    protected boolean mIsAllVisible;
    protected boolean mIsCyclic;
    protected boolean mIsScrollingPerformed;
    protected LinearLayout mItemsLayout;
    protected int mLayoutHeight;
    protected int mLayoutWidth;
    private WheelRecycler mRecycler;
    protected WheelScroller mScroller;
    protected int mScrollingOffset;
    protected WheelViewAdapter mViewAdapter;
    protected int mVisibleItems;
    private List<OnWheelScrollListener> scrollingListeners;

    protected abstract void createItemsLayout();

    protected abstract WheelScroller createScroller(WheelScroller.ScrollingListener scrollingListener);

    protected abstract void doItemsLayout();

    protected abstract int getBaseDimension();

    protected abstract int getItemDimension();

    protected abstract float getMotionEventPosition(MotionEvent motionEvent);

    protected void onScrollFinished() {
    }

    protected void onScrollStarted() {
    }

    protected void onScrollTouched() {
    }

    protected void onScrollTouchedUp() {
    }

    protected abstract void recreateAssets(int i, int i2);

    public AbstractWheel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        StringBuilder sbAppend = new StringBuilder().append(AbstractWheel.class.getName()).append(" #");
        int i2 = itemID + 1;
        itemID = i2;
        this.LOG_TAG = sbAppend.append(i2).toString();
        this.mCurrentItemIdx = 0;
        this.mRecycler = new WheelRecycler(this);
        this.changingListeners = new LinkedList();
        this.scrollingListeners = new LinkedList();
        this.clickingListeners = new LinkedList();
        initAttributes(attributeSet, i);
        initData(context);
    }

    protected void initAttributes(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AbstractWheelView, i, 0);
        this.mVisibleItems = typedArrayObtainStyledAttributes.getInt(0, 4);
        this.mIsAllVisible = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.mIsCyclic = typedArrayObtainStyledAttributes.getBoolean(8, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    protected void initData(Context context) {
        this.mDataObserver = new DataSetObserver() { // from class: antistatic.spinnerwheel.AbstractWheel.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                AbstractWheel.this.invalidateItemsLayout(false);
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                AbstractWheel.this.invalidateItemsLayout(true);
            }
        };
        this.mScroller = createScroller(new WheelScroller.ScrollingListener() { // from class: antistatic.spinnerwheel.AbstractWheel.2
            @Override // antistatic.spinnerwheel.WheelScroller.ScrollingListener
            public void onStarted() {
                AbstractWheel.this.mIsScrollingPerformed = true;
                AbstractWheel.this.notifyScrollingListenersAboutStart();
                AbstractWheel.this.onScrollStarted();
            }

            @Override // antistatic.spinnerwheel.WheelScroller.ScrollingListener
            public void onTouch() {
                AbstractWheel.this.onScrollTouched();
            }

            @Override // antistatic.spinnerwheel.WheelScroller.ScrollingListener
            public void onTouchUp() {
                if (AbstractWheel.this.mIsScrollingPerformed) {
                    return;
                }
                AbstractWheel.this.onScrollTouchedUp();
            }

            @Override // antistatic.spinnerwheel.WheelScroller.ScrollingListener
            public void onScroll(int i) {
                AbstractWheel.this.doScroll(i);
                int baseDimension = AbstractWheel.this.getBaseDimension();
                if (AbstractWheel.this.mScrollingOffset > baseDimension) {
                    AbstractWheel.this.mScrollingOffset = baseDimension;
                    AbstractWheel.this.mScroller.stopScrolling();
                    return;
                }
                int i2 = -baseDimension;
                if (AbstractWheel.this.mScrollingOffset < i2) {
                    AbstractWheel.this.mScrollingOffset = i2;
                    AbstractWheel.this.mScroller.stopScrolling();
                }
            }

            @Override // antistatic.spinnerwheel.WheelScroller.ScrollingListener
            public void onFinished() {
                if (AbstractWheel.this.mIsScrollingPerformed) {
                    AbstractWheel.this.notifyScrollingListenersAboutEnd();
                    AbstractWheel.this.mIsScrollingPerformed = false;
                    AbstractWheel.this.onScrollFinished();
                }
                AbstractWheel.this.mScrollingOffset = 0;
                AbstractWheel.this.invalidate();
            }

            @Override // antistatic.spinnerwheel.WheelScroller.ScrollingListener
            public void onJustify() {
                if (Math.abs(AbstractWheel.this.mScrollingOffset) > 1) {
                    AbstractWheel.this.mScroller.scroll(AbstractWheel.this.mScrollingOffset, 0);
                }
            }
        });
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentItem = getCurrentItem();
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentItemIdx = savedState.currentItem;
        postDelayed(new Runnable() { // from class: antistatic.spinnerwheel.AbstractWheel.3
            @Override // java.lang.Runnable
            public void run() {
                AbstractWheel.this.invalidateItemsLayout(false);
            }
        }, 100L);
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: antistatic.spinnerwheel.AbstractWheel.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int currentItem;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentItem = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentItem);
        }
    }

    public void stopScrolling() {
        this.mScroller.stopScrolling();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mScroller.setInterpolator(interpolator);
    }

    public void scroll(int i, int i2) {
        int itemDimension = (i * getItemDimension()) - this.mScrollingOffset;
        onScrollTouched();
        this.mScroller.scroll(itemDimension, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doScroll(int i) {
        this.mScrollingOffset += i;
        int itemDimension = getItemDimension();
        int i2 = this.mScrollingOffset / itemDimension;
        int i3 = this.mCurrentItemIdx - i2;
        int itemsCount = this.mViewAdapter.getItemsCount();
        int i4 = this.mScrollingOffset % itemDimension;
        if (Math.abs(i4) <= itemDimension / 2) {
            i4 = 0;
        }
        if (this.mIsCyclic && itemsCount > 0) {
            if (i4 > 0) {
                i3--;
                i2++;
            } else if (i4 < 0) {
                i3++;
                i2--;
            }
            while (i3 < 0) {
                i3 += itemsCount;
            }
            i3 %= itemsCount;
        } else if (i3 < 0) {
            i2 = this.mCurrentItemIdx;
            i3 = 0;
        } else if (i3 >= itemsCount) {
            i2 = (this.mCurrentItemIdx - itemsCount) + 1;
            i3 = itemsCount - 1;
        } else if (i3 > 0 && i4 > 0) {
            i3--;
            i2++;
        } else if (i3 < itemsCount - 1 && i4 < 0) {
            i3++;
            i2--;
        }
        int i5 = this.mScrollingOffset;
        if (i3 != this.mCurrentItemIdx) {
            setCurrentItem(i3, false);
        } else {
            invalidate();
        }
        int baseDimension = getBaseDimension();
        int i6 = i5 - (i2 * itemDimension);
        this.mScrollingOffset = i6;
        if (i6 > baseDimension) {
            this.mScrollingOffset = (i6 % baseDimension) + baseDimension;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            doItemsLayout();
            if (this.mLayoutWidth != i5 || this.mLayoutHeight != i6) {
                recreateAssets(getMeasuredWidth(), getMeasuredHeight());
            }
            this.mLayoutWidth = i5;
            this.mLayoutHeight = i6;
        }
    }

    public void invalidateItemsLayout(boolean z) {
        if (z) {
            this.mRecycler.clearAll();
            LinearLayout linearLayout = this.mItemsLayout;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.mScrollingOffset = 0;
        } else {
            LinearLayout linearLayout2 = this.mItemsLayout;
            if (linearLayout2 != null) {
                this.mRecycler.recycleItems(linearLayout2, this.mFirstItemIdx, new ItemsRange());
            }
        }
        invalidate();
    }

    public int getVisibleItems() {
        return this.mVisibleItems;
    }

    public void setVisibleItems(int i) {
        this.mVisibleItems = i;
    }

    public void setAllItemsVisible(boolean z) {
        this.mIsAllVisible = z;
        invalidateItemsLayout(false);
    }

    public WheelViewAdapter getViewAdapter() {
        return this.mViewAdapter;
    }

    public void setViewAdapter(WheelViewAdapter wheelViewAdapter) {
        WheelViewAdapter wheelViewAdapter2 = this.mViewAdapter;
        if (wheelViewAdapter2 != null) {
            wheelViewAdapter2.unregisterDataSetObserver(this.mDataObserver);
        }
        this.mViewAdapter = wheelViewAdapter;
        if (wheelViewAdapter != null) {
            wheelViewAdapter.registerDataSetObserver(this.mDataObserver);
        }
        invalidateItemsLayout(true);
    }

    public int getCurrentItem() {
        return this.mCurrentItemIdx;
    }

    public void setCurrentItem(int i, boolean z) {
        int iMin;
        WheelViewAdapter wheelViewAdapter = this.mViewAdapter;
        if (wheelViewAdapter == null || wheelViewAdapter.getItemsCount() == 0) {
            return;
        }
        int itemsCount = this.mViewAdapter.getItemsCount();
        if (i < 0 || i >= itemsCount) {
            if (!this.mIsCyclic) {
                return;
            }
            while (i < 0) {
                i += itemsCount;
            }
            i %= itemsCount;
        }
        int i2 = this.mCurrentItemIdx;
        if (i != i2) {
            if (z) {
                int i3 = i - i2;
                if (this.mIsCyclic && (iMin = (itemsCount + Math.min(i, i2)) - Math.max(i, this.mCurrentItemIdx)) < Math.abs(i3)) {
                    i3 = i3 < 0 ? iMin : -iMin;
                }
                scroll(i3, 0);
                return;
            }
            this.mScrollingOffset = 0;
            this.mCurrentItemIdx = i;
            notifyChangingListeners(i2, i);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, false);
    }

    public boolean isCyclic() {
        return this.mIsCyclic;
    }

    public void setCyclic(boolean z) {
        this.mIsCyclic = z;
        invalidateItemsLayout(false);
    }

    public void addChangingListener(OnWheelChangedListener onWheelChangedListener) {
        this.changingListeners.add(onWheelChangedListener);
    }

    public void removeChangingListener(OnWheelChangedListener onWheelChangedListener) {
        this.changingListeners.remove(onWheelChangedListener);
    }

    protected void notifyChangingListeners(int i, int i2) {
        Iterator<OnWheelChangedListener> it = this.changingListeners.iterator();
        while (it.hasNext()) {
            it.next().onChanged(this, i, i2);
        }
    }

    public void addScrollingListener(OnWheelScrollListener onWheelScrollListener) {
        this.scrollingListeners.add(onWheelScrollListener);
    }

    public void removeScrollingListener(OnWheelScrollListener onWheelScrollListener) {
        this.scrollingListeners.remove(onWheelScrollListener);
    }

    protected void notifyScrollingListenersAboutStart() {
        Iterator<OnWheelScrollListener> it = this.scrollingListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollingStarted(this);
        }
    }

    protected void notifyScrollingListenersAboutEnd() {
        Iterator<OnWheelScrollListener> it = this.scrollingListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollingFinished(this);
        }
    }

    public void addClickingListener(OnWheelClickedListener onWheelClickedListener) {
        this.clickingListeners.add(onWheelClickedListener);
    }

    public void removeClickingListener(OnWheelClickedListener onWheelClickedListener) {
        this.clickingListeners.remove(onWheelClickedListener);
    }

    protected void notifyClickListenersAboutClick(int i) {
        Iterator<OnWheelClickedListener> it = this.clickingListeners.iterator();
        while (it.hasNext()) {
            it.next().onItemClicked(this, i);
        }
    }

    protected boolean rebuildItems() {
        boolean z;
        ItemsRange itemsRange = getItemsRange();
        LinearLayout linearLayout = this.mItemsLayout;
        if (linearLayout != null) {
            int iRecycleItems = this.mRecycler.recycleItems(linearLayout, this.mFirstItemIdx, itemsRange);
            z = this.mFirstItemIdx != iRecycleItems;
            this.mFirstItemIdx = iRecycleItems;
        } else {
            createItemsLayout();
            z = true;
        }
        if (!z) {
            z = (this.mFirstItemIdx == itemsRange.getFirst() && this.mItemsLayout.getChildCount() == itemsRange.getCount()) ? false : true;
        }
        if (this.mFirstItemIdx > itemsRange.getFirst() && this.mFirstItemIdx <= itemsRange.getLast()) {
            for (int i = this.mFirstItemIdx - 1; i >= itemsRange.getFirst() && addItemView(i, true); i--) {
                this.mFirstItemIdx = i;
            }
        } else {
            this.mFirstItemIdx = itemsRange.getFirst();
        }
        int i2 = this.mFirstItemIdx;
        for (int childCount = this.mItemsLayout.getChildCount(); childCount < itemsRange.getCount(); childCount++) {
            if (!addItemView(this.mFirstItemIdx + childCount, false) && this.mItemsLayout.getChildCount() == 0) {
                i2++;
            }
        }
        this.mFirstItemIdx = i2;
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[PHI: r0
      0x004b: PHI (r0v4 int) = (r0v3 int), (r0v6 int) binds: [B:17:0x0034, B:24:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private antistatic.spinnerwheel.ItemsRange getItemsRange() {
        /*
            r5 = this;
            boolean r0 = r5.mIsAllVisible
            r1 = 1
            if (r0 == 0) goto L13
            int r0 = r5.getBaseDimension()
            int r2 = r5.getItemDimension()
            if (r2 == 0) goto L13
            int r0 = r0 / r2
            int r0 = r0 + r1
            r5.mVisibleItems = r0
        L13:
            int r0 = r5.mCurrentItemIdx
            int r2 = r5.mVisibleItems
            int r3 = r2 / 2
            int r0 = r0 - r3
            int r3 = r0 + r2
            int r2 = r2 % 2
            r4 = 0
            if (r2 != 0) goto L23
            r2 = r4
            goto L24
        L23:
            r2 = r1
        L24:
            int r3 = r3 - r2
            int r2 = r5.mScrollingOffset
            if (r2 == 0) goto L30
            if (r2 <= 0) goto L2e
            int r0 = r0 + (-1)
            goto L30
        L2e:
            int r3 = r3 + 1
        L30:
            boolean r2 = r5.isCyclic()
            if (r2 != 0) goto L4b
            if (r0 >= 0) goto L39
            r0 = r4
        L39:
            antistatic.spinnerwheel.adapters.WheelViewAdapter r2 = r5.mViewAdapter
            if (r2 != 0) goto L3e
            goto L4c
        L3e:
            int r2 = r2.getItemsCount()
            if (r3 <= r2) goto L4b
            antistatic.spinnerwheel.adapters.WheelViewAdapter r2 = r5.mViewAdapter
            int r4 = r2.getItemsCount()
            goto L4c
        L4b:
            r4 = r3
        L4c:
            antistatic.spinnerwheel.ItemsRange r2 = new antistatic.spinnerwheel.ItemsRange
            int r4 = r4 - r0
            int r4 = r4 + r1
            r2.<init>(r0, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: antistatic.spinnerwheel.AbstractWheel.getItemsRange():antistatic.spinnerwheel.ItemsRange");
    }

    protected boolean isValidItemIndex(int i) {
        WheelViewAdapter wheelViewAdapter = this.mViewAdapter;
        return wheelViewAdapter != null && wheelViewAdapter.getItemsCount() > 0 && (this.mIsCyclic || (i >= 0 && i < this.mViewAdapter.getItemsCount()));
    }

    private boolean addItemView(int i, boolean z) {
        View itemView = getItemView(i);
        if (itemView == null) {
            return false;
        }
        if (z) {
            this.mItemsLayout.addView(itemView, 0);
            return true;
        }
        this.mItemsLayout.addView(itemView);
        return true;
    }

    private View getItemView(int i) {
        WheelViewAdapter wheelViewAdapter = this.mViewAdapter;
        if (wheelViewAdapter == null || wheelViewAdapter.getItemsCount() == 0) {
            return null;
        }
        int itemsCount = this.mViewAdapter.getItemsCount();
        if (!isValidItemIndex(i)) {
            return this.mViewAdapter.getEmptyItem(this.mRecycler.getEmptyItem(), this.mItemsLayout);
        }
        while (i < 0) {
            i += itemsCount;
        }
        return this.mViewAdapter.getItem(i % itemsCount, this.mRecycler.getItem(), this.mItemsLayout);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = r3.isEnabled()
            r1 = 1
            if (r0 == 0) goto L63
            antistatic.spinnerwheel.adapters.WheelViewAdapter r0 = r3.getViewAdapter()
            if (r0 != 0) goto Le
            goto L63
        Le:
            int r0 = r4.getAction()
            if (r0 == 0) goto L4f
            r2 = 2
            if (r0 == r1) goto L1a
            if (r0 == r2) goto L4f
            goto L5c
        L1a:
            boolean r0 = r3.mIsScrollingPerformed
            if (r0 != 0) goto L5c
            float r0 = r3.getMotionEventPosition(r4)
            int r0 = (int) r0
            int r1 = r3.getBaseDimension()
            int r1 = r1 / r2
            int r0 = r0 - r1
            if (r0 <= 0) goto L32
            int r1 = r3.getItemDimension()
            int r1 = r1 / r2
            int r0 = r0 + r1
            goto L38
        L32:
            int r1 = r3.getItemDimension()
            int r1 = r1 / r2
            int r0 = r0 - r1
        L38:
            int r1 = r3.getItemDimension()
            int r0 = r0 / r1
            if (r0 == 0) goto L5c
            int r1 = r3.mCurrentItemIdx
            int r1 = r1 + r0
            boolean r1 = r3.isValidItemIndex(r1)
            if (r1 == 0) goto L5c
            int r1 = r3.mCurrentItemIdx
            int r1 = r1 + r0
            r3.notifyClickListenersAboutClick(r1)
            goto L5c
        L4f:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L5c
            android.view.ViewParent r0 = r3.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L5c:
            antistatic.spinnerwheel.WheelScroller r0 = r3.mScroller
            boolean r4 = r0.onTouchEvent(r4)
            return r4
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: antistatic.spinnerwheel.AbstractWheel.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
