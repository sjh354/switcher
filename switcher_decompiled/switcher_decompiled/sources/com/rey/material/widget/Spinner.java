package com.rey.material.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;
import androidx.core.view.GravityCompat;
import com.rey.material.R;
import com.rey.material.app.ThemeManager;
import com.rey.material.drawable.ArrowDrawable;
import com.rey.material.drawable.DividerDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class Spinner extends FrameLayout implements ThemeManager.OnThemeChangedListener {
    private static final int INVALID_POSITION = -1;
    private static final int MAX_ITEMS_MEASURED = 15;
    private SpinnerAdapter mAdapter;
    private boolean mArrowAnimSwitchMode;
    private ArrowDrawable mArrowDrawable;
    private int mArrowPadding;
    private int mArrowSize;
    private SpinnerDataSetObserver mDataSetObserver;
    private boolean mDisableChildrenWhenDisabled;
    private DividerDrawable mDividerDrawable;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDropDownWidth;
    private int mGravity;
    private boolean mIsRtl;
    private boolean mLabelEnable;
    private TextView mLabelView;
    private int mMinHeight;
    private int mMinWidth;
    private OnItemClickListener mOnItemClickListener;
    private OnItemSelectedListener mOnItemSelectedListener;
    private DropdownPopup mPopup;
    private RecycleBin mRecycler;
    private int mSelectedPosition;
    private DropDownAdapter mTempAdapter;
    private Rect mTempRect;

    public interface OnItemClickListener {
        boolean onItemClick(Spinner spinner, View view, int i, long j);
    }

    public interface OnItemSelectedListener {
        void onItemSelected(Spinner spinner, View view, int i, long j);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Spinner(Context context) {
        super(context, null, R.attr.listPopupWindowStyle);
        this.mRecycler = new RecycleBin();
        this.mTempRect = new Rect();
        this.mDataSetObserver = new SpinnerDataSetObserver();
    }

    public Spinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.listPopupWindowStyle);
        this.mRecycler = new RecycleBin();
        this.mTempRect = new Rect();
        this.mDataSetObserver = new SpinnerDataSetObserver();
    }

    public Spinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRecycler = new RecycleBin();
        this.mTempRect = new Rect();
        this.mDataSetObserver = new SpinnerDataSetObserver();
    }

    @Override // com.rey.material.widget.FrameLayout
    protected void init(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mLabelEnable = false;
        this.mDropDownWidth = -2;
        this.mArrowAnimSwitchMode = false;
        this.mGravity = 17;
        this.mDisableChildrenWhenDisabled = false;
        this.mSelectedPosition = -1;
        this.mIsRtl = false;
        setWillNotDraw(false);
        DropdownPopup dropdownPopup = new DropdownPopup(context, attributeSet, i, i2);
        this.mPopup = dropdownPopup;
        dropdownPopup.setModal(true);
        if (isInEditMode()) {
            applyStyle(R.style.Material_Widget_Spinner);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.rey.material.widget.Spinner.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Spinner.this.showPopup();
            }
        });
        super.init(context, attributeSet, i, i2);
    }

    private android.widget.TextView getLabelView() {
        if (this.mLabelView == null) {
            this.mLabelView = new TextView(getContext());
            if (Build.VERSION.SDK_INT >= 17) {
                this.mLabelView.setTextDirection(this.mIsRtl ? 4 : 3);
            }
            this.mLabelView.setSingleLine(true);
            this.mLabelView.setDuplicateParentStateEnabled(true);
        }
        return this.mLabelView;
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02cc  */
    @Override // com.rey.material.widget.FrameLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void applyStyle(android.content.Context r23, android.util.AttributeSet r24, int r25, int r26) {
        /*
            Method dump skipped, instruction units count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rey.material.widget.Spinner.applyStyle(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        boolean z = i == 1;
        if (this.mIsRtl != z) {
            this.mIsRtl = z;
            if (this.mLabelView != null && Build.VERSION.SDK_INT >= 17) {
                this.mLabelView.setTextDirection(this.mIsRtl ? 4 : 3);
            }
            requestLayout();
        }
    }

    public View getSelectedView() {
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt == this.mLabelView) {
            return null;
        }
        return childAt;
    }

    public void setSelection(int i) {
        if (this.mAdapter != null) {
            i = Math.max(0, Math.min(i, r0.getCount() - 1));
        }
        int i2 = i;
        if (this.mSelectedPosition != i2) {
            this.mSelectedPosition = i2;
            OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                View selectedView = getSelectedView();
                SpinnerAdapter spinnerAdapter = this.mAdapter;
                onItemSelectedListener.onItemSelected(this, selectedView, i2, spinnerAdapter == null ? -1L : spinnerAdapter.getItemId(i2));
            }
            onDataInvalidated();
        }
    }

    public int getSelectedItemPosition() {
        return this.mSelectedPosition;
    }

    public Object getSelectedItem() {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getItem(this.mSelectedPosition);
    }

    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        SpinnerAdapter spinnerAdapter2 = this.mAdapter;
        if (spinnerAdapter2 != null) {
            spinnerAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mRecycler.clear();
        this.mAdapter = spinnerAdapter;
        spinnerAdapter.registerDataSetObserver(this.mDataSetObserver);
        onDataChanged();
        DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup != null) {
            dropdownPopup.setAdapter(new DropDownAdapter(spinnerAdapter));
        } else {
            this.mTempAdapter = new DropDownAdapter(spinnerAdapter);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(getContext().getDrawable(i));
    }

    public Drawable getPopupBackground() {
        return this.mPopup.getBackground();
    }

    public void setDropDownVerticalOffset(int i) {
        this.mPopup.setVerticalOffset(i);
    }

    public int getDropDownVerticalOffset() {
        return this.mPopup.getVerticalOffset();
    }

    public void setDropDownHorizontalOffset(int i) {
        this.mPopup.setHorizontalOffset(i);
    }

    public int getDropDownHorizontalOffset() {
        return this.mPopup.getHorizontalOffset();
    }

    public void setDropDownWidth(int i) {
        this.mDropDownWidth = i;
    }

    public int getDropDownWidth() {
        return this.mDropDownWidth;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.mDisableChildrenWhenDisabled) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).setEnabled(z);
            }
        }
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.mMinHeight = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.mMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((i & 7) == 0) {
                i |= GravityCompat.START;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int baseline;
        View selectedView = getSelectedView();
        if (selectedView == null || (baseline = selectedView.getBaseline()) < 0) {
            return -1;
        }
        int paddingTop = getPaddingTop();
        TextView textView = this.mLabelView;
        if (textView != null) {
            paddingTop += textView.getMeasuredHeight();
        }
        int measuredHeight = ((getMeasuredHeight() - paddingTop) - getPaddingBottom()) - getDividerDrawableHeight();
        int i = this.mGravity & 112;
        if (i == 48) {
            return paddingTop + baseline;
        }
        if (i == 80) {
            return ((paddingTop + measuredHeight) - selectedView.getMeasuredHeight()) + baseline;
        }
        return ((measuredHeight - selectedView.getMeasuredHeight()) / 2) + paddingTop + baseline;
    }

    @Override // com.rey.material.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DropdownPopup dropdownPopup = this.mPopup;
        if (dropdownPopup == null || !dropdownPopup.isShowing()) {
            return;
        }
        this.mPopup.dismiss();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || this.mArrowDrawable == drawable || this.mDividerDrawable == drawable;
    }

    private int getArrowDrawableWidth() {
        if (this.mArrowDrawable != null) {
            return this.mArrowSize + (this.mArrowPadding * 2);
        }
        return 0;
    }

    private int getDividerDrawableHeight() {
        int i = this.mDividerHeight;
        if (i > 0) {
            return i + this.mDividerPadding;
        }
        return 0;
    }

    private int getSpec(int i, int i2) {
        if (i2 == -2) {
            if (i > 0) {
                return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
            }
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        if (i2 != -1) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (i > 0) {
            return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int measuredHeight;
        int measuredHeight2;
        int measuredWidth2;
        int measuredHeight3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight() + getArrowDrawableWidth();
        int paddingTop = getPaddingTop() + getPaddingBottom() + getDividerDrawableHeight();
        TextView textView = this.mLabelView;
        int measuredWidth3 = 0;
        if (textView == null || textView.getLayoutParams() == null) {
            measuredWidth = 0;
            measuredHeight = 0;
        } else {
            this.mLabelView.measure(View.MeasureSpec.makeMeasureSpec(mode == 0 ? 0 : size - paddingLeft, mode), View.MeasureSpec.makeMeasureSpec(0, 0));
            measuredWidth = this.mLabelView.getMeasuredWidth();
            measuredHeight = this.mLabelView.getMeasuredHeight();
        }
        View selectedView = getSelectedView();
        if (selectedView != null) {
            ViewGroup.LayoutParams layoutParams = selectedView.getLayoutParams();
            selectedView.measure(getSpec(size - paddingLeft, layoutParams.width), getSpec((size2 - paddingTop) - this.mLabelView.getMeasuredHeight(), layoutParams.height));
            measuredWidth3 = selectedView.getMeasuredWidth();
            measuredHeight2 = selectedView.getMeasuredHeight();
        } else {
            measuredHeight2 = 0;
        }
        int iMax = Math.max(this.mMinWidth, Math.max(measuredWidth, measuredWidth3) + paddingLeft);
        int iMax2 = Math.max(this.mMinHeight, measuredHeight2 + measuredHeight + paddingTop);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, iMax);
        } else if (mode != 1073741824) {
            size = iMax;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, iMax2);
        } else if (mode2 != 1073741824) {
            size2 = iMax2;
        }
        setMeasuredDimension(size, size2);
        if (selectedView != null) {
            ViewGroup.LayoutParams layoutParams2 = selectedView.getLayoutParams();
            int i3 = layoutParams2.width;
            if (i3 == -2) {
                measuredWidth2 = selectedView.getMeasuredWidth();
            } else {
                measuredWidth2 = i3 != -1 ? layoutParams2.width : size - paddingLeft;
            }
            int i4 = layoutParams2.height;
            if (i4 == -2) {
                measuredHeight3 = selectedView.getMeasuredHeight();
            } else {
                measuredHeight3 = i4 != -1 ? layoutParams2.height : (size2 - measuredHeight) - paddingTop;
            }
            if (selectedView.getMeasuredWidth() == measuredWidth2 && selectedView.getMeasuredHeight() == measuredHeight3) {
                return;
            }
            selectedView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight3, 1073741824));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0127  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rey.material.widget.Spinner.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        DividerDrawable dividerDrawable = this.mDividerDrawable;
        if (dividerDrawable != null) {
            dividerDrawable.draw(canvas);
        }
        ArrowDrawable arrowDrawable = this.mArrowDrawable;
        if (arrowDrawable != null) {
            arrowDrawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ArrowDrawable arrowDrawable = this.mArrowDrawable;
        if (arrowDrawable != null) {
            arrowDrawable.setState(getDrawableState());
        }
        DividerDrawable dividerDrawable = this.mDividerDrawable;
        if (dividerDrawable != null) {
            dividerDrawable.setState(getDrawableState());
        }
    }

    public boolean performItemClick(View view, int i, long j) {
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            if (!onItemClickListener.onItemClick(this, view, i, j)) {
                return true;
            }
            setSelection(i);
            return true;
        }
        setSelection(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataChanged() {
        int i = this.mSelectedPosition;
        if (i == -1) {
            setSelection(0);
        } else if (i < this.mAdapter.getCount()) {
            onDataInvalidated();
        } else {
            setSelection(this.mAdapter.getCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDataInvalidated() {
        if (this.mAdapter == null) {
            return;
        }
        if (this.mLabelView == null) {
            removeAllViews();
        } else {
            for (int childCount = getChildCount() - 1; childCount > 0; childCount--) {
                removeViewAt(childCount);
            }
        }
        int itemViewType = this.mAdapter.getItemViewType(this.mSelectedPosition);
        View view = this.mAdapter.getView(this.mSelectedPosition, this.mRecycler.get(itemViewType), this);
        view.setFocusable(false);
        view.setClickable(false);
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        super.addView(view);
        this.mRecycler.put(itemViewType, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopup() {
        if (this.mPopup.isShowing()) {
            return;
        }
        this.mPopup.show();
        final ListView listView = this.mPopup.getListView();
        if (listView != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                listView.setChoiceMode(1);
            }
            listView.setSelection(getSelectedItemPosition());
            if (this.mArrowDrawable == null || !this.mArrowAnimSwitchMode) {
                return;
            }
            listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.rey.material.widget.Spinner.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    Spinner.this.mArrowDrawable.setMode(ArrowDrawable.MODE_UP, true);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPopupDismissed() {
        ArrowDrawable arrowDrawable = this.mArrowDrawable;
        if (arrowDrawable != null) {
            arrowDrawable.setMode(ArrowDrawable.MODE_DOWN, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int measureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.mTempRect);
        return iMax2 + this.mTempRect.left + this.mTempRect.right;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.rey.material.widget.Spinner.SavedState.1
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
        int position;
        boolean showDropdown;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.position = parcel.readInt();
            this.showDropdown = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeByte(this.showDropdown ? (byte) 1 : (byte) 0);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + " showDropdown=" + this.showDropdown + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = getSelectedItemPosition();
        DropdownPopup dropdownPopup = this.mPopup;
        savedState.showDropdown = dropdownPopup != null && dropdownPopup.isShowing();
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setSelection(savedState.position);
        if (!savedState.showDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rey.material.widget.Spinner.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Spinner.this.showPopup();
                ViewTreeObserver viewTreeObserver2 = Spinner.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    viewTreeObserver2.removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    private class SpinnerDataSetObserver extends DataSetObserver {
        private SpinnerDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Spinner.this.onDataChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Spinner.this.onDataInvalidated();
        }
    }

    private class RecycleBin {
        private final SparseArray<View> mScrapHeap;

        private RecycleBin() {
            this.mScrapHeap = new SparseArray<>();
        }

        public void put(int i, View view) {
            this.mScrapHeap.put(i, view);
        }

        View get(int i) {
            View view = this.mScrapHeap.get(i);
            if (view != null) {
                this.mScrapHeap.delete(i);
            }
            return view;
        }

        void clear() {
            this.mScrapHeap.clear();
        }
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter, View.OnClickListener {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;
        private AdapterView.OnItemClickListener mOnItemClickListener;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter) {
            this.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.mListAdapter = (ListAdapter) spinnerAdapter;
            }
        }

        public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIntValue = ((Integer) view.getTag()).intValue();
            AdapterView.OnItemClickListener onItemClickListener = this.mOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(null, view, iIntValue, 0L);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View dropDownView = getDropDownView(i, view, viewGroup);
            dropDownView.setOnClickListener(this);
            dropDownView.setTag(Integer.valueOf(i));
            return dropDownView;
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter == null || listAdapter.areAllItemsEnabled();
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            return listAdapter == null || listAdapter.isEnabled(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.getItemViewType(i);
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.getViewTypeCount();
            }
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class DropdownPopup extends ListPopupWindow {
        private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
        private DropDownAdapter mAdapter;
        private CharSequence mHintText;

        public DropdownPopup(Context context, AttributeSet attributeSet, int i, int i2) {
            super(context, attributeSet, i, i2);
            this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rey.material.widget.Spinner.DropdownPopup.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    DropdownPopup.this.computeContentWidth();
                    DropdownPopup.super.show();
                }
            };
            setAnchorView(Spinner.this);
            setModal(true);
            setPromptPosition(0);
            setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rey.material.widget.Spinner.DropdownPopup.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver = Spinner.this.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            viewTreeObserver.removeOnGlobalLayoutListener(DropdownPopup.this.layoutListener);
                        } else {
                            viewTreeObserver.removeGlobalOnLayoutListener(DropdownPopup.this.layoutListener);
                        }
                    }
                    Spinner.this.onPopupDismissed();
                }
            });
        }

        @Override // com.rey.material.widget.ListPopupWindow
        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            DropDownAdapter dropDownAdapter = (DropDownAdapter) listAdapter;
            this.mAdapter = dropDownAdapter;
            dropDownAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.rey.material.widget.Spinner.DropdownPopup.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    Spinner.this.performItemClick(view, i, DropdownPopup.this.mAdapter.getItemId(i));
                    DropdownPopup.this.dismiss();
                }
            });
        }

        public CharSequence getHintText() {
            return this.mHintText;
        }

        public void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        void computeContentWidth() {
            Drawable background = getBackground();
            int i = 0;
            if (background != null) {
                background.getPadding(Spinner.this.mTempRect);
                i = Spinner.this.mIsRtl ? Spinner.this.mTempRect.right : -Spinner.this.mTempRect.left;
            } else {
                Rect rect = Spinner.this.mTempRect;
                Spinner.this.mTempRect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = Spinner.this.getPaddingLeft();
            int paddingRight = Spinner.this.getPaddingRight();
            int width = Spinner.this.getWidth();
            if (Spinner.this.mDropDownWidth == -2) {
                int iMeasureContentWidth = Spinner.this.measureContentWidth(this.mAdapter, getBackground());
                int i2 = (Spinner.this.getContext().getResources().getDisplayMetrics().widthPixels - Spinner.this.mTempRect.left) - Spinner.this.mTempRect.right;
                if (iMeasureContentWidth > i2) {
                    iMeasureContentWidth = i2;
                }
                setContentWidth(Math.max(iMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (Spinner.this.mDropDownWidth != -1) {
                setContentWidth(Spinner.this.mDropDownWidth);
            } else {
                setContentWidth((width - paddingLeft) - paddingRight);
            }
            setHorizontalOffset(Spinner.this.mIsRtl ? i + ((width - paddingRight) - getWidth()) : i + paddingLeft);
        }

        @Override // com.rey.material.widget.ListPopupWindow
        public void show() {
            ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            if (zIsShowing || (viewTreeObserver = Spinner.this.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.addOnGlobalLayoutListener(this.layoutListener);
        }
    }
}
