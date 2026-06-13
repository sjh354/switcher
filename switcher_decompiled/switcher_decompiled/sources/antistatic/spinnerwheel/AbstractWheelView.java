package antistatic.spinnerwheel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractWheelView extends AbstractWheel {
    protected static final int DEF_ITEMS_DIMMED_ALPHA = 50;
    protected static final int DEF_ITEM_OFFSET_PERCENT = 10;
    protected static final int DEF_ITEM_PADDING = 10;
    protected static final int DEF_SELECTION_DIVIDER_ACTIVE_ALPHA = 70;
    protected static final int DEF_SELECTION_DIVIDER_DIMMED_ALPHA = 70;
    protected static final int DEF_SELECTION_DIVIDER_SIZE = 2;
    protected static final String PROPERTY_SELECTOR_PAINT_COEFF = "selectorPaintCoeff";
    protected static final String PROPERTY_SEPARATORS_PAINT_ALPHA = "separatorsPaintAlpha";
    private static int itemID = -1;
    private final String LOG_TAG;
    protected Animator mDimSelectorWheelAnimator;
    protected Animator mDimSeparatorsAnimator;
    protected int mItemOffsetPercent;
    protected int mItemsDimmedAlpha;
    protected int mItemsPadding;
    protected Drawable mSelectionDivider;
    protected int mSelectionDividerActiveAlpha;
    protected int mSelectionDividerDimmedAlpha;
    protected Paint mSelectorWheelPaint;
    protected Bitmap mSeparatorsBitmap;
    protected Paint mSeparatorsPaint;
    protected Bitmap mSpinBitmap;

    protected abstract void drawItems(Canvas canvas);

    protected abstract void measureLayout();

    public abstract void setSelectorPaintCoeff(float f);

    public AbstractWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        StringBuilder sbAppend = new StringBuilder().append(AbstractWheelView.class.getName()).append(" #");
        int i2 = itemID + 1;
        itemID = i2;
        this.LOG_TAG = sbAppend.append(i2).toString();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void initAttributes(AttributeSet attributeSet, int i) {
        super.initAttributes(attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AbstractWheelView, i, 0);
        this.mItemsDimmedAlpha = typedArrayObtainStyledAttributes.getInt(7, 50);
        this.mSelectionDividerActiveAlpha = typedArrayObtainStyledAttributes.getInt(5, 70);
        this.mSelectionDividerDimmedAlpha = typedArrayObtainStyledAttributes.getInt(4, 70);
        this.mItemOffsetPercent = typedArrayObtainStyledAttributes.getInt(2, 10);
        this.mItemsPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 10);
        this.mSelectionDivider = typedArrayObtainStyledAttributes.getDrawable(6);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void initData(Context context) {
        super.initData(context);
        this.mDimSelectorWheelAnimator = ObjectAnimator.ofFloat(this, PROPERTY_SELECTOR_PAINT_COEFF, 1.0f, 0.0f);
        this.mDimSeparatorsAnimator = ObjectAnimator.ofInt(this, PROPERTY_SEPARATORS_PAINT_ALPHA, this.mSelectionDividerActiveAlpha, this.mSelectionDividerDimmedAlpha);
        Paint paint = new Paint();
        this.mSeparatorsPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mSeparatorsPaint.setAlpha(this.mSelectionDividerDimmedAlpha);
        Paint paint2 = new Paint();
        this.mSelectorWheelPaint = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void recreateAssets(int i, int i2) {
        this.mSpinBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.mSeparatorsBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        setSelectorPaintCoeff(0.0f);
    }

    public void setSeparatorsPaintAlpha(int i) {
        this.mSeparatorsPaint.setAlpha(i);
        invalidate();
    }

    public void setSelectionDivider(Drawable drawable) {
        this.mSelectionDivider = drawable;
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void onScrollTouched() {
        this.mDimSelectorWheelAnimator.cancel();
        this.mDimSeparatorsAnimator.cancel();
        setSelectorPaintCoeff(1.0f);
        setSeparatorsPaintAlpha(this.mSelectionDividerActiveAlpha);
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void onScrollTouchedUp() {
        super.onScrollTouchedUp();
        fadeSelectorWheel(750L);
        lightSeparators(750L);
    }

    @Override // antistatic.spinnerwheel.AbstractWheel
    protected void onScrollFinished() {
        fadeSelectorWheel(500L);
        lightSeparators(500L);
    }

    private void fadeSelectorWheel(long j) {
        this.mDimSelectorWheelAnimator.setDuration(j);
        this.mDimSelectorWheelAnimator.start();
    }

    private void lightSeparators(long j) {
        this.mDimSeparatorsAnimator.setDuration(j);
        this.mDimSeparatorsAnimator.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mViewAdapter == null || this.mViewAdapter.getItemsCount() <= 0) {
            return;
        }
        if (rebuildItems()) {
            measureLayout();
        }
        doItemsLayout();
        drawItems(canvas);
    }
}
