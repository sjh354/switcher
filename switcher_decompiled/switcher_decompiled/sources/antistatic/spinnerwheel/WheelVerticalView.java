package antistatic.spinnerwheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import antistatic.spinnerwheel.WheelScroller;

/* JADX INFO: loaded from: classes.dex */
public class WheelVerticalView extends AbstractWheelView {
    private static int itemID = -1;
    private final String LOG_TAG;
    private int mItemHeight;
    protected int mSelectionDividerHeight;

    public WheelVerticalView(Context context) {
        this(context, null);
    }

    public WheelVerticalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.abstractWheelViewStyle);
    }

    public WheelVerticalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        StringBuilder sbAppend = new StringBuilder().append(WheelVerticalView.class.getName()).append(" #");
        int i2 = itemID + 1;
        itemID = i2;
        this.LOG_TAG = sbAppend.append(i2).toString();
        this.mItemHeight = 0;
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView, antistatic.spinnerwheel.AbstractWheel
    protected void initAttributes(AttributeSet attributeSet, int i) {
        super.initAttributes(attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.WheelVerticalView, i, 0);
        this.mSelectionDividerHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 2);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView
    public void setSelectorPaintCoeff(float f) {
        LinearGradient linearGradient;
        int measuredHeight = getMeasuredHeight();
        float f2 = measuredHeight;
        float itemDimension = getItemDimension() / f2;
        float f3 = (1.0f - itemDimension) / 2.0f;
        float f4 = (itemDimension + 1.0f) / 2.0f;
        float f5 = this.mItemsDimmedAlpha * (1.0f - f);
        float f6 = (f * 255.0f) + f5;
        if (this.mVisibleItems == 2) {
            int iRound = Math.round(f6) << 24;
            int iRound2 = Math.round(f5) << 24;
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, f2, new int[]{iRound2, iRound, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, iRound, iRound2}, new float[]{0.0f, f3, f3, f4, f4, 1.0f}, Shader.TileMode.CLAMP);
        } else {
            float f7 = (r2 * 3) / f2;
            float f8 = (1.0f - f7) / 2.0f;
            float f9 = (f7 + 1.0f) / 2.0f;
            float f10 = ((255.0f * f8) / f3) * f;
            int iRound3 = Math.round(f6) << 24;
            int iRound4 = Math.round(f5 + f10) << 24;
            int iRound5 = Math.round(f10) << 24;
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, f2, new int[]{0, iRound5, iRound4, iRound3, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, iRound3, iRound4, iRound5, 0}, new float[]{0.0f, f8, f8, f3, f3, f4, f4, f9, f9, 1.0f}, Shader.TileMode.CLAMP);
        }
        this.mSelectorWheelPaint.setShader(linearGradient);
        invalidate();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected WheelScroller createScroller(WheelScroller.ScrollingListener scrollingListener) {
        return new WheelVerticalScroller(getContext(), scrollingListener);
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected float getMotionEventPosition(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected int getBaseDimension() {
        return getHeight();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected int getItemDimension() {
        int i = this.mItemHeight;
        if (i != 0) {
            return i;
        }
        if (this.mItemsLayout != null && this.mItemsLayout.getChildAt(0) != null) {
            int measuredHeight = this.mItemsLayout.getChildAt(0).getMeasuredHeight();
            this.mItemHeight = measuredHeight;
            return measuredHeight;
        }
        return getBaseDimension() / this.mVisibleItems;
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void createItemsLayout() {
        if (this.mItemsLayout == null) {
            this.mItemsLayout = new LinearLayout(getContext());
            this.mItemsLayout.setOrientation(1);
        }
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void doItemsLayout() {
        this.mItemsLayout.layout(0, 0, getMeasuredWidth() - (this.mItemsPadding * 2), getMeasuredHeight());
    }

    @Override // antistatic.spinnerwheel.AbstractWheelView
    protected void measureLayout() {
        this.mItemsLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mItemsLayout.measure(View.MeasureSpec.makeMeasureSpec(getWidth() - (this.mItemsPadding * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        rebuildItems();
        int iCalculateLayoutWidth = calculateLayoutWidth(size, mode);
        if (mode2 != 1073741824) {
            int iMax = Math.max(getItemDimension() * (this.mVisibleItems - (this.mItemOffsetPercent / 100)), getSuggestedMinimumHeight());
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(iMax, size2) : iMax;
        }
        setMeasuredDimension(iCalculateLayoutWidth, size2);
    }

    private int calculateLayoutWidth(int i, int i2) {
        this.mItemsLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.mItemsLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.mItemsLayout.getMeasuredWidth();
        if (i2 != 1073741824) {
            int iMax = Math.max(measuredWidth + (this.mItemsPadding * 2), getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= iMax) {
                i = iMax;
            }
        }
        this.mItemsLayout.measure(View.MeasureSpec.makeMeasureSpec(i - (this.mItemsPadding * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
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
        canvas2.translate(this.mItemsPadding, (-(((this.mCurrentItemIdx - this.mFirstItemIdx) * itemDimension) + ((itemDimension - getHeight()) / 2))) + this.mScrollingOffset);
        this.mItemsLayout.draw(canvas2);
        this.mSeparatorsBitmap.eraseColor(0);
        Canvas canvas4 = new Canvas(this.mSeparatorsBitmap);
        if (this.mSelectionDivider != null) {
            int height = getHeight() - itemDimension;
            int i = this.mSelectionDividerHeight;
            int i2 = (height - i) / 2;
            int i3 = i + i2;
            this.mSelectionDivider.setBounds(0, i2, measuredWidth, i3);
            this.mSelectionDivider.draw(canvas4);
            this.mSelectionDivider.setBounds(0, i2 + itemDimension, measuredWidth, i3 + itemDimension);
            this.mSelectionDivider.draw(canvas4);
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
