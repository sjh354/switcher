package antistatic.spinnerwheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import antistatic.spinnerwheel.WheelScroller;
import cz.msebera.android.httpclient.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class WheelHorizontalView extends AbstractWheelView {
    private static int itemID = -1;
    private final String LOG_TAG;
    private int itemWidth;
    protected int mSelectionDividerWidth;

    public WheelHorizontalView(Context context) {
        this(context, null);
    }

    public WheelHorizontalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.abstractWheelViewStyle);
    }

    public WheelHorizontalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        StringBuilder sbAppend = new StringBuilder().append(WheelVerticalView.class.getName()).append(" #");
        int i2 = itemID + 1;
        itemID = i2;
        this.LOG_TAG = sbAppend.append(i2).toString();
        this.itemWidth = 0;
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView, antistatic.spinnerwheel.AbstractWheel
    protected void initAttributes(AttributeSet attributeSet, int i) {
        super.initAttributes(attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.WheelHorizontalView, i, 0);
        this.mSelectionDividerWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setSelectionDividerWidth(int i) {
        this.mSelectionDividerWidth = i;
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView
    public void setSelectorPaintCoeff(float f) {
        LinearGradient linearGradient;
        if (this.mItemsDimmedAlpha >= 100) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        float f2 = measuredWidth;
        float itemDimension = getItemDimension() / f2;
        float f3 = (1.0f - itemDimension) / 2.0f;
        float f4 = (itemDimension + 1.0f) / 2.0f;
        float f5 = this.mItemsDimmedAlpha * (1.0f - f);
        float f6 = (f * 255.0f) + f5;
        if (this.mVisibleItems == 2) {
            int iRound = Math.round(f6) << 24;
            int iRound2 = Math.round(f5) << 24;
            linearGradient = new LinearGradient(0.0f, 0.0f, f2, 0.0f, new int[]{iRound2, iRound, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, iRound, iRound2}, new float[]{0.0f, f3, f3, f4, f4, 1.0f}, Shader.TileMode.CLAMP);
        } else {
            float f7 = (r2 * 3) / f2;
            float f8 = (1.0f - f7) / 2.0f;
            float f9 = (f7 + 1.0f) / 2.0f;
            float f10 = ((255.0f * f8) / f3) * f;
            Math.round(f6);
            int iRound3 = Math.round(f5 + f10) << 24;
            Math.round(f10);
            linearGradient = new LinearGradient(0.0f, 0.0f, f2, 0.0f, new int[]{iRound3, iRound3, iRound3, iRound3, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, iRound3, iRound3, iRound3, iRound3}, new float[]{0.0f, f8, f8, f3, f3, f4, f4, f9, f9, 1.0f}, Shader.TileMode.CLAMP);
        }
        this.mSelectorWheelPaint.setShader(linearGradient);
        invalidate();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected WheelScroller createScroller(WheelScroller.ScrollingListener scrollingListener) {
        return new WheelHorizontalScroller(getContext(), scrollingListener);
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected float getMotionEventPosition(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected int getBaseDimension() {
        return getWidth();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected int getItemDimension() {
        int i = this.itemWidth;
        if (i != 0) {
            return i;
        }
        if (this.mItemsLayout != null && this.mItemsLayout.getChildAt(0) != null) {
            int measuredWidth = this.mItemsLayout.getChildAt(0).getMeasuredWidth();
            this.itemWidth = measuredWidth;
            return measuredWidth;
        }
        return getBaseDimension() / this.mVisibleItems;
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView, antistatic.spinnerwheel.AbstractWheel
    protected void onScrollTouchedUp() {
        super.onScrollTouchedUp();
        int childCount = this.mItemsLayout.getChildCount();
        Log.e(this.LOG_TAG, " ----- layout: " + this.mItemsLayout.getMeasuredWidth() + this.mItemsLayout.getMeasuredHeight());
        Log.e(this.LOG_TAG, " -------- dumping " + childCount + " items");
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mItemsLayout.getChildAt(i);
            Log.e(this.LOG_TAG, " item #" + i + ": " + childAt.getWidth() + "x" + childAt.getHeight());
            childAt.forceLayout();
        }
        Log.e(this.LOG_TAG, " ---------- dumping finished ");
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void createItemsLayout() {
        if (this.mItemsLayout == null) {
            this.mItemsLayout = new LinearLayout(getContext());
            this.mItemsLayout.setOrientation(0);
        }
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void doItemsLayout() {
        this.mItemsLayout.layout(0, 0, getMeasuredWidth(), getMeasuredHeight() - (this.mItemsPadding * 2));
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView
    protected void measureLayout() {
        this.mItemsLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mItemsLayout.measure(View.MeasureSpec.makeMeasureSpec(getWidth() + getItemDimension(), 0), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        rebuildItems();
        int iCalculateLayoutHeight = calculateLayoutHeight(size2, mode2);
        if (mode != 1073741824) {
            int iMax = Math.max(getItemDimension() * (this.mVisibleItems - (this.mItemOffsetPercent / 100)), getSuggestedMinimumWidth());
            size = mode == Integer.MIN_VALUE ? Math.min(iMax, size) : iMax;
        }
        setMeasuredDimension(size, iCalculateLayoutHeight);
    }

    private int calculateLayoutHeight(int i, int i2) {
        this.mItemsLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mItemsLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(i, 0));
        int measuredHeight = this.mItemsLayout.getMeasuredHeight();
        if (i2 != 1073741824) {
            int iMax = Math.max(measuredHeight + (this.mItemsPadding * 2), getSuggestedMinimumHeight());
            if (i2 != Integer.MIN_VALUE || i >= iMax) {
                i = iMax;
            }
        }
        this.mItemsLayout.measure(View.MeasureSpec.makeMeasureSpec(HttpStatus.SC_BAD_REQUEST, 1073741824), View.MeasureSpec.makeMeasureSpec(i - (this.mItemsPadding * 2), 1073741824));
        return i;
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView
    protected void drawItems(Canvas canvas) {
        canvas.save();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int itemDimension = getItemDimension();
        this.mSpinBitmap.eraseColor(0);
        Canvas canvas2 = new Canvas(this.mSpinBitmap);
        Canvas canvas3 = new Canvas(this.mSpinBitmap);
        canvas2.translate((-(((this.mCurrentItemIdx - this.mFirstItemIdx) * itemDimension) + ((itemDimension - getWidth()) / 2))) + this.mScrollingOffset, this.mItemsPadding);
        this.mItemsLayout.draw(canvas2);
        this.mSeparatorsBitmap.eraseColor(0);
        Canvas canvas4 = new Canvas(this.mSeparatorsBitmap);
        if (this.mSelectionDivider != null) {
            int width = getWidth() - itemDimension;
            int i = this.mSelectionDividerWidth;
            int i2 = (width - i) / 2;
            int i3 = i + i2;
            canvas4.save();
            canvas4.clipRect(i2, 0, i3, measuredHeight);
            this.mSelectionDivider.setBounds(i2, 0, i3, measuredHeight);
            this.mSelectionDivider.draw(canvas4);
            canvas4.restore();
            canvas4.save();
            int i4 = i2 + itemDimension;
            int i5 = i3 + itemDimension;
            canvas4.clipRect(i4, 0, i5, measuredHeight);
            this.mSelectionDivider.setBounds(i4, 0, i5, measuredHeight);
            this.mSelectionDivider.draw(canvas4);
            canvas4.restore();
        }
        float f = measuredWidth;
        float f2 = measuredHeight;
        canvas3.drawRect(0.0f, 0.0f, f, f2, this.mSelectorWheelPaint);
        canvas4.drawRect(0.0f, 0.0f, f, f2, this.mSeparatorsPaint);
        canvas.drawBitmap(this.mSpinBitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(this.mSeparatorsBitmap, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }
}
