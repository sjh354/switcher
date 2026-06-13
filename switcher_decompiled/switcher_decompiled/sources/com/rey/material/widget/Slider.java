package com.rey.material.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.rey.material.R;
import com.rey.material.app.ThemeManager;
import com.rey.material.drawable.RippleDrawable;
import com.rey.material.util.ColorUtil;
import com.rey.material.util.ThemeUtil;
import com.rey.material.util.TypefaceUtil;
import com.rey.material.util.ViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class Slider extends View implements ThemeManager.OnThemeChangedListener {
    private boolean mAlwaysFillThumb;
    private int mBaselineOffset;
    protected int mCurrentStyle;
    private boolean mDiscreteMode;
    private RectF mDrawRect;
    private int mGravity;
    private Interpolator mInterpolator;
    private boolean mIsDragging;
    private boolean mIsRtl;
    private Path mLeftTrackPath;
    private Path mMarkPath;
    private int mMaxValue;
    private PointF mMemoPoint;
    private int mMemoValue;
    private int mMinValue;
    private OnPositionChangeListener mOnPositionChangeListener;
    private Paint mPaint;
    private int mPrimaryColor;
    private Path mRightTrackPath;
    private RippleManager mRippleManager;
    private int mSecondaryColor;
    private int mStepValue;
    protected int mStyleId;
    private RectF mTempRect;
    private int mTextColor;
    private int mTextHeight;
    private int mTextSize;
    private int mThumbBorderSize;
    private float mThumbCurrentRadius;
    private float mThumbFillPercent;
    private int mThumbFocusRadius;
    private ThumbMoveAnimator mThumbMoveAnimator;
    private float mThumbPosition;
    private int mThumbRadius;
    private ThumbRadiusAnimator mThumbRadiusAnimator;
    private ThumbStrokeAnimator mThumbStrokeAnimator;
    private int mThumbTouchRadius;
    private int mTouchSlop;
    private Paint.Cap mTrackCap;
    private int mTrackSize;
    private int mTransformAnimationDuration;
    private int mTravelAnimationDuration;
    private Typeface mTypeface;
    private ValueDescriptionProvider mValueDescriptionProvider;
    private String mValueText;

    public interface OnPositionChangeListener {
        void onPositionChanged(Slider slider, boolean z, float f, float f2, int i, int i2);
    }

    public interface ValueDescriptionProvider {
        String getDescription(int i);
    }

    public Slider(Context context) {
        super(context);
        this.mCurrentStyle = Integer.MIN_VALUE;
        this.mMinValue = 0;
        this.mMaxValue = 100;
        this.mStepValue = 1;
        this.mDiscreteMode = false;
        this.mTrackSize = -1;
        this.mTrackCap = Paint.Cap.BUTT;
        this.mThumbBorderSize = -1;
        this.mThumbRadius = -1;
        this.mThumbFocusRadius = -1;
        this.mThumbTouchRadius = -1;
        this.mThumbPosition = -1.0f;
        this.mTypeface = Typeface.DEFAULT;
        this.mTextSize = -1;
        this.mTextColor = -1;
        this.mGravity = 17;
        this.mTravelAnimationDuration = -1;
        this.mTransformAnimationDuration = -1;
        this.mAlwaysFillThumb = false;
        this.mIsRtl = false;
        init(context, null, 0, 0);
    }

    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentStyle = Integer.MIN_VALUE;
        this.mMinValue = 0;
        this.mMaxValue = 100;
        this.mStepValue = 1;
        this.mDiscreteMode = false;
        this.mTrackSize = -1;
        this.mTrackCap = Paint.Cap.BUTT;
        this.mThumbBorderSize = -1;
        this.mThumbRadius = -1;
        this.mThumbFocusRadius = -1;
        this.mThumbTouchRadius = -1;
        this.mThumbPosition = -1.0f;
        this.mTypeface = Typeface.DEFAULT;
        this.mTextSize = -1;
        this.mTextColor = -1;
        this.mGravity = 17;
        this.mTravelAnimationDuration = -1;
        this.mTransformAnimationDuration = -1;
        this.mAlwaysFillThumb = false;
        this.mIsRtl = false;
        init(context, attributeSet, 0, 0);
    }

    public Slider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentStyle = Integer.MIN_VALUE;
        this.mMinValue = 0;
        this.mMaxValue = 100;
        this.mStepValue = 1;
        this.mDiscreteMode = false;
        this.mTrackSize = -1;
        this.mTrackCap = Paint.Cap.BUTT;
        this.mThumbBorderSize = -1;
        this.mThumbRadius = -1;
        this.mThumbFocusRadius = -1;
        this.mThumbTouchRadius = -1;
        this.mThumbPosition = -1.0f;
        this.mTypeface = Typeface.DEFAULT;
        this.mTextSize = -1;
        this.mTextColor = -1;
        this.mGravity = 17;
        this.mTravelAnimationDuration = -1;
        this.mTransformAnimationDuration = -1;
        this.mAlwaysFillThumb = false;
        this.mIsRtl = false;
        init(context, attributeSet, i, 0);
    }

    protected void init(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mPaint = new Paint(1);
        this.mPrimaryColor = ThemeUtil.colorControlActivated(context, ViewCompat.MEASURED_STATE_MASK);
        this.mSecondaryColor = ThemeUtil.colorControlNormal(context, ViewCompat.MEASURED_STATE_MASK);
        this.mDrawRect = new RectF();
        this.mTempRect = new RectF();
        this.mLeftTrackPath = new Path();
        this.mRightTrackPath = new Path();
        this.mThumbRadiusAnimator = new ThumbRadiusAnimator();
        this.mThumbStrokeAnimator = new ThumbStrokeAnimator();
        this.mThumbMoveAnimator = new ThumbMoveAnimator();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMemoPoint = new PointF();
        applyStyle(context, attributeSet, i, i2);
        if (isInEditMode()) {
            return;
        }
        this.mStyleId = ThemeManager.getStyleId(context, attributeSet, i, i2);
    }

    public void applyStyle(int i) {
        ViewUtil.applyStyle(this, i);
        applyStyle(getContext(), null, 0, i);
    }

    protected void applyStyle(Context context, AttributeSet attributeSet, int i, int i2) {
        getRippleManager().onCreate(this, context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Slider, i, i2);
        int minValue = getMinValue();
        int maxValue = getMaxValue();
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        int integer = -1;
        String string = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int integer2 = 0;
        while (i3 < indexCount) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            int i4 = indexCount;
            if (index == R.styleable.Slider_sl_discreteMode) {
                this.mDiscreteMode = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.Slider_sl_primaryColor) {
                this.mPrimaryColor = typedArrayObtainStyledAttributes.getColor(index, 0);
            } else if (index == R.styleable.Slider_sl_secondaryColor) {
                this.mSecondaryColor = typedArrayObtainStyledAttributes.getColor(index, 0);
            } else if (index == R.styleable.Slider_sl_trackSize) {
                this.mTrackSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.Slider_sl_trackCap) {
                int integer3 = typedArrayObtainStyledAttributes.getInteger(index, 0);
                if (integer3 == 0) {
                    this.mTrackCap = Paint.Cap.BUTT;
                } else if (integer3 == 1) {
                    this.mTrackCap = Paint.Cap.ROUND;
                } else {
                    this.mTrackCap = Paint.Cap.SQUARE;
                }
            } else if (index == R.styleable.Slider_sl_thumbBorderSize) {
                this.mThumbBorderSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.Slider_sl_thumbRadius) {
                this.mThumbRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.Slider_sl_thumbFocusRadius) {
                this.mThumbFocusRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.Slider_sl_thumbTouchRadius) {
                this.mThumbTouchRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.Slider_sl_travelAnimDuration) {
                int integer4 = typedArrayObtainStyledAttributes.getInteger(index, 0);
                this.mTravelAnimationDuration = integer4;
                this.mTransformAnimationDuration = integer4;
            } else if (index == R.styleable.Slider_sl_alwaysFillThumb) {
                this.mAlwaysFillThumb = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Slider_sl_alwaysFillThumb, false);
            } else if (index == R.styleable.Slider_sl_interpolator) {
                this.mInterpolator = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.Slider_sl_interpolator, 0));
            } else if (index == R.styleable.Slider_android_gravity) {
                this.mGravity = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else {
                if (index == R.styleable.Slider_sl_minValue) {
                    minValue = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Slider_sl_maxValue) {
                    maxValue = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Slider_sl_stepValue) {
                    this.mStepValue = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Slider_sl_value) {
                    integer = typedArrayObtainStyledAttributes.getInteger(index, 0);
                    z2 = true;
                } else {
                    if (index == R.styleable.Slider_sl_fontFamily) {
                        string = typedArrayObtainStyledAttributes.getString(index);
                    } else if (index == R.styleable.Slider_sl_textStyle) {
                        integer2 = typedArrayObtainStyledAttributes.getInteger(index, 0);
                    } else if (index == R.styleable.Slider_sl_textColor) {
                        this.mTextColor = typedArrayObtainStyledAttributes.getColor(index, 0);
                    } else if (index == R.styleable.Slider_sl_textSize) {
                        this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    } else if (index == R.styleable.Slider_android_enabled) {
                        setEnabled(typedArrayObtainStyledAttributes.getBoolean(index, true));
                    } else if (index == R.styleable.Slider_sl_baselineOffset) {
                        this.mBaselineOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, 0);
                    }
                    z3 = true;
                }
                z = true;
            }
            i3++;
            indexCount = i4;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (this.mTrackSize < 0) {
            this.mTrackSize = ThemeUtil.dpToPx(context, 2);
        }
        if (this.mThumbBorderSize < 0) {
            this.mThumbBorderSize = ThemeUtil.dpToPx(context, 2);
        }
        if (this.mThumbRadius < 0) {
            this.mThumbRadius = ThemeUtil.dpToPx(context, 10);
        }
        if (this.mThumbFocusRadius < 0) {
            this.mThumbFocusRadius = ThemeUtil.dpToPx(context, 14);
        }
        if (this.mTravelAnimationDuration < 0) {
            int integer5 = context.getResources().getInteger(android.R.integer.config_mediumAnimTime);
            this.mTravelAnimationDuration = integer5;
            this.mTransformAnimationDuration = integer5;
        }
        if (this.mInterpolator == null) {
            this.mInterpolator = new DecelerateInterpolator();
        }
        if (z) {
            setValueRange(minValue, maxValue, false);
        }
        if (z2) {
            setValue(integer, false);
        } else if (this.mThumbPosition < 0.0f) {
            setValue(this.mMinValue, false);
        }
        if (z3) {
            this.mTypeface = TypefaceUtil.load(context, string, integer2);
        }
        if (this.mTextSize < 0) {
            this.mTextSize = context.getResources().getDimensionPixelOffset(R.dimen.abc_text_size_small_material);
        }
        this.mPaint.setTextSize(this.mTextSize);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTypeface(this.mTypeface);
        measureText();
        invalidate();
    }

    @Override // com.rey.material.app.ThemeManager.OnThemeChangedListener
    public void onThemeChanged(ThemeManager.OnThemeChangedEvent onThemeChangedEvent) {
        int currentStyle = ThemeManager.getInstance().getCurrentStyle(this.mStyleId);
        if (this.mCurrentStyle != currentStyle) {
            this.mCurrentStyle = currentStyle;
            applyStyle(currentStyle);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mStyleId != 0) {
            ThemeManager.getInstance().registerOnThemeChangedListener(this);
            onThemeChanged(null);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RippleManager.cancelRipple(this);
        if (this.mStyleId != 0) {
            ThemeManager.getInstance().unregisterOnThemeChangedListener(this);
        }
    }

    private void measureText() {
        if (this.mValueText == null) {
            return;
        }
        Rect rect = new Rect();
        this.mPaint.setTextSize(this.mTextSize);
        float fMeasureText = this.mPaint.measureText(this.mValueText);
        float fSqrt = (float) (((((double) this.mThumbRadius) * Math.sqrt(2.0d)) * 2.0d) - ((double) ThemeUtil.dpToPx(getContext(), 8)));
        if (fMeasureText > fSqrt) {
            this.mPaint.setTextSize((this.mTextSize * fSqrt) / fMeasureText);
        }
        Paint paint = this.mPaint;
        String str = this.mValueText;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.mTextHeight = rect.height();
    }

    private String getValueText() {
        int value = getValue();
        if (this.mValueText == null || this.mMemoValue != value) {
            this.mMemoValue = value;
            ValueDescriptionProvider valueDescriptionProvider = this.mValueDescriptionProvider;
            this.mValueText = valueDescriptionProvider == null ? String.valueOf(value) : valueDescriptionProvider.getDescription(value);
            measureText();
        }
        return this.mValueText;
    }

    public int getMinValue() {
        return this.mMinValue;
    }

    public int getMaxValue() {
        return this.mMaxValue;
    }

    public int getStepValue() {
        return this.mStepValue;
    }

    public void setValueRange(int i, int i2, boolean z) {
        if (i2 >= i) {
            if (i == this.mMinValue && i2 == this.mMaxValue) {
                return;
            }
            float exactValue = getExactValue();
            float position = getPosition();
            this.mMinValue = i;
            this.mMaxValue = i2;
            setValue(exactValue, z);
            if (this.mOnPositionChangeListener == null || position != getPosition() || exactValue == getExactValue()) {
                return;
            }
            this.mOnPositionChangeListener.onPositionChanged(this, false, position, position, Math.round(exactValue), getValue());
        }
    }

    public int getValue() {
        return Math.round(getExactValue());
    }

    public float getExactValue() {
        return ((this.mMaxValue - this.mMinValue) * getPosition()) + this.mMinValue;
    }

    public float getPosition() {
        return this.mThumbMoveAnimator.isRunning() ? this.mThumbMoveAnimator.getPosition() : this.mThumbPosition;
    }

    public void setPosition(float f, boolean z) {
        setPosition(f, z, z, false);
    }

    private void setPosition(float f, boolean z, boolean z2, boolean z3) {
        OnPositionChangeListener onPositionChangeListener;
        boolean z4 = getPosition() != f;
        int value = getValue();
        float position = getPosition();
        if (!z || !this.mThumbMoveAnimator.startAnimation(f)) {
            this.mThumbPosition = f;
            if (z2) {
                if (!this.mIsDragging) {
                    this.mThumbRadiusAnimator.startAnimation(this.mThumbRadius);
                }
                this.mThumbStrokeAnimator.startAnimation(f == 0.0f ? 0 : 1);
            } else {
                this.mThumbCurrentRadius = this.mThumbRadius;
                this.mThumbFillPercent = (this.mAlwaysFillThumb || f != 0.0f) ? 1.0f : 0.0f;
                invalidate();
            }
        }
        int value2 = getValue();
        float position2 = getPosition();
        if (!z4 || (onPositionChangeListener = this.mOnPositionChangeListener) == null) {
            return;
        }
        onPositionChangeListener.onPositionChanged(this, z3, position, position2, value, value2);
    }

    public void setPrimaryColor(int i) {
        this.mPrimaryColor = i;
        invalidate();
    }

    public void setSecondaryColor(int i) {
        this.mSecondaryColor = i;
        invalidate();
    }

    public void setAlwaysFillThumb(boolean z) {
        this.mAlwaysFillThumb = z;
    }

    public void setValue(float f, boolean z) {
        setPosition((Math.min(this.mMaxValue, Math.max(f, this.mMinValue)) - this.mMinValue) / (this.mMaxValue - r0), z);
    }

    public void setOnPositionChangeListener(OnPositionChangeListener onPositionChangeListener) {
        this.mOnPositionChangeListener = onPositionChangeListener;
    }

    public void setValueDescriptionProvider(ValueDescriptionProvider valueDescriptionProvider) {
        this.mValueDescriptionProvider = valueDescriptionProvider;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Drawable background = getBackground();
        if ((background instanceof RippleDrawable) && !(drawable instanceof RippleDrawable)) {
            ((RippleDrawable) background).setBackgroundDrawable(drawable);
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    protected RippleManager getRippleManager() {
        if (this.mRippleManager == null) {
            synchronized (RippleManager.class) {
                if (this.mRippleManager == null) {
                    this.mRippleManager = new RippleManager();
                }
            }
        }
        return this.mRippleManager;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        RippleManager rippleManager = getRippleManager();
        if (onClickListener == rippleManager) {
            super.setOnClickListener(onClickListener);
        } else {
            rippleManager.setOnClickListener(onClickListener);
            setOnClickListener(rippleManager);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(size, getSuggestedMinimumWidth());
        } else if (mode == 0) {
            size = getSuggestedMinimumWidth();
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, getSuggestedMinimumHeight());
        } else if (mode2 == 0) {
            size2 = getSuggestedMinimumHeight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return ((this.mDiscreteMode ? (int) (((double) this.mThumbRadius) * Math.sqrt(2.0d)) : this.mThumbFocusRadius) * 4) + getPaddingLeft() + getPaddingRight();
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return (this.mDiscreteMode ? (int) (((double) this.mThumbRadius) * (Math.sqrt(2.0d) + 4.0d)) : this.mThumbFocusRadius * 2) + getPaddingTop() + getPaddingBottom();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        boolean z = i == 1;
        if (this.mIsRtl != z) {
            this.mIsRtl = z;
            invalidate();
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int paddingTop;
        int i;
        int measuredHeight;
        int paddingBottom;
        int iRound;
        int i2 = this.mGravity & 112;
        if (this.mDiscreteMode) {
            int iSqrt = (int) (((double) this.mThumbRadius) * (Math.sqrt(2.0d) + 4.0d));
            int i3 = this.mThumbRadius * 2;
            if (i2 == 48) {
                paddingTop = Math.max(getPaddingTop(), iSqrt - i3);
                i = this.mThumbRadius;
                iRound = paddingTop + i;
            } else if (i2 == 80) {
                measuredHeight = getMeasuredHeight();
                paddingBottom = getPaddingBottom();
                iRound = measuredHeight - paddingBottom;
            } else {
                iRound = Math.round(Math.max((getMeasuredHeight() - i3) / 2.0f, iSqrt - i3) + this.mThumbRadius);
            }
        } else {
            int i4 = this.mThumbFocusRadius * 2;
            if (i2 == 48) {
                paddingTop = getPaddingTop();
                i = this.mThumbFocusRadius;
                iRound = paddingTop + i;
            } else if (i2 == 80) {
                measuredHeight = getMeasuredHeight();
                paddingBottom = getPaddingBottom();
                iRound = measuredHeight - paddingBottom;
            } else {
                iRound = Math.round(((getMeasuredHeight() - i4) / 2.0f) + this.mThumbFocusRadius);
            }
        }
        return iRound + this.mBaselineOffset;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mDrawRect.left = getPaddingLeft() + this.mThumbRadius;
        this.mDrawRect.right = (i - getPaddingRight()) - this.mThumbRadius;
        int i5 = this.mGravity & 112;
        if (this.mDiscreteMode) {
            int iSqrt = (int) (((double) this.mThumbRadius) * (Math.sqrt(2.0d) + 4.0d));
            int i6 = this.mThumbRadius * 2;
            if (i5 == 48) {
                this.mDrawRect.top = Math.max(getPaddingTop(), iSqrt - i6);
                RectF rectF = this.mDrawRect;
                rectF.bottom = rectF.top + i6;
                return;
            }
            if (i5 == 80) {
                this.mDrawRect.bottom = i2 - getPaddingBottom();
                RectF rectF2 = this.mDrawRect;
                rectF2.top = rectF2.bottom - i6;
                return;
            }
            this.mDrawRect.top = Math.max((i2 - i6) / 2.0f, iSqrt - i6);
            RectF rectF3 = this.mDrawRect;
            rectF3.bottom = rectF3.top + i6;
            return;
        }
        int i7 = this.mThumbFocusRadius * 2;
        if (i5 == 48) {
            this.mDrawRect.top = getPaddingTop();
            RectF rectF4 = this.mDrawRect;
            rectF4.bottom = rectF4.top + i7;
            return;
        }
        if (i5 == 80) {
            this.mDrawRect.bottom = i2 - getPaddingBottom();
            RectF rectF5 = this.mDrawRect;
            rectF5.top = rectF5.bottom - i7;
            return;
        }
        this.mDrawRect.top = (i2 - i7) / 2.0f;
        RectF rectF6 = this.mDrawRect;
        rectF6.bottom = rectF6.top + i7;
    }

    private boolean isThumbHit(float f, float f2, float f3) {
        float fWidth = (this.mDrawRect.width() * this.mThumbPosition) + this.mDrawRect.left;
        float fCenterY = this.mDrawRect.centerY();
        return f >= fWidth - f3 && f <= fWidth + f3 && f2 >= fCenterY - f3 && f2 < fCenterY + f3;
    }

    private double distance(float f, float f2, float f3, float f4) {
        return Math.sqrt(Math.pow(f - f3, 2.0d) + Math.pow(f2 - f4, 2.0d));
    }

    private float correctPosition(float f) {
        if (!this.mDiscreteMode) {
            return f;
        }
        int i = this.mMaxValue - this.mMinValue;
        float f2 = i;
        int iRound = Math.round(f * f2);
        int i2 = this.mStepValue;
        int i3 = iRound / i2;
        int i4 = i3 * i2;
        int iMin = Math.min(i, (i3 + 1) * i2);
        return (iRound - i4 < iMin - iRound ? i4 : iMin) / f2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        getRippleManager().onTouchEvent(this, motionEvent);
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.mIsRtl) {
            x = (this.mDrawRect.centerX() * 2.0f) - x;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int i = this.mThumbTouchRadius;
            if (i <= 0) {
                i = this.mThumbRadius;
            }
            this.mIsDragging = isThumbHit(x, y, (float) i) && !this.mThumbMoveAnimator.isRunning();
            this.mMemoPoint.set(x, y);
            if (this.mIsDragging) {
                this.mThumbRadiusAnimator.startAnimation(this.mDiscreteMode ? 0 : this.mThumbFocusRadius);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
        } else if (action != 1) {
            if (action == 2) {
                if (this.mIsDragging) {
                    if (this.mDiscreteMode) {
                        setPosition(correctPosition(Math.min(1.0f, Math.max(0.0f, (x - this.mDrawRect.left) / this.mDrawRect.width()))), true, true, true);
                    } else {
                        setPosition(Math.min(1.0f, Math.max(0.0f, this.mThumbPosition + ((x - this.mMemoPoint.x) / this.mDrawRect.width()))), false, true, true);
                        this.mMemoPoint.x = x;
                        invalidate();
                    }
                }
            } else if (action == 3 && this.mIsDragging) {
                this.mIsDragging = false;
                setPosition(getPosition(), true, true, true);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            }
        } else if (this.mIsDragging) {
            this.mIsDragging = false;
            setPosition(getPosition(), true, true, true);
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else if (distance(this.mMemoPoint.x, this.mMemoPoint.y, x, y) <= this.mTouchSlop) {
            setPosition(correctPosition(Math.min(1.0f, Math.max(0.0f, (x - this.mDrawRect.left) / this.mDrawRect.width()))), true, true, true);
        }
        return true;
    }

    private void getTrackPath(float f, float f2, float f3) {
        float f4 = this.mTrackSize / 2.0f;
        this.mLeftTrackPath.reset();
        this.mRightTrackPath.reset();
        if (f3 - 1.0f < f4) {
            if (this.mTrackCap != Paint.Cap.ROUND) {
                if (f > this.mDrawRect.left) {
                    float f5 = f2 - f4;
                    this.mLeftTrackPath.moveTo(this.mDrawRect.left, f5);
                    this.mLeftTrackPath.lineTo(f, f5);
                    float f6 = f2 + f4;
                    this.mLeftTrackPath.lineTo(f, f6);
                    this.mLeftTrackPath.lineTo(this.mDrawRect.left, f6);
                    this.mLeftTrackPath.close();
                }
                if (f < this.mDrawRect.right) {
                    float f7 = f2 + f4;
                    this.mRightTrackPath.moveTo(this.mDrawRect.right, f7);
                    this.mRightTrackPath.lineTo(f, f7);
                    float f8 = f2 - f4;
                    this.mRightTrackPath.lineTo(f, f8);
                    this.mRightTrackPath.lineTo(this.mDrawRect.right, f8);
                    this.mRightTrackPath.close();
                    return;
                }
                return;
            }
            if (f > this.mDrawRect.left) {
                float f9 = f2 - f4;
                float f10 = f2 + f4;
                this.mTempRect.set(this.mDrawRect.left, f9, this.mDrawRect.left + this.mTrackSize, f10);
                this.mLeftTrackPath.arcTo(this.mTempRect, 90.0f, 180.0f);
                this.mLeftTrackPath.lineTo(f, f9);
                this.mLeftTrackPath.lineTo(f, f10);
                this.mLeftTrackPath.close();
            }
            if (f < this.mDrawRect.right) {
                float f11 = f2 - f4;
                float f12 = f2 + f4;
                this.mTempRect.set(this.mDrawRect.right - this.mTrackSize, f11, this.mDrawRect.right, f12);
                this.mRightTrackPath.arcTo(this.mTempRect, 270.0f, 180.0f);
                this.mRightTrackPath.lineTo(f, f12);
                this.mRightTrackPath.lineTo(f, f11);
                this.mRightTrackPath.close();
                return;
            }
            return;
        }
        if (this.mTrackCap != Paint.Cap.ROUND) {
            float f13 = f - f3;
            float f14 = f + f3;
            this.mTempRect.set(f13 + 1.0f, (f2 - f3) + 1.0f, f14 - 1.0f, (f2 + f3) - 1.0f);
            float fAsin = (float) ((Math.asin(f4 / r6) / 3.141592653589793d) * 180.0d);
            if (f13 > this.mDrawRect.left) {
                this.mLeftTrackPath.moveTo(this.mDrawRect.left, f2 - f4);
                this.mLeftTrackPath.arcTo(this.mTempRect, 180.0f + fAsin, (-fAsin) * 2.0f);
                this.mLeftTrackPath.lineTo(this.mDrawRect.left, f2 + f4);
                this.mLeftTrackPath.close();
            }
            if (f14 < this.mDrawRect.right) {
                this.mRightTrackPath.moveTo(this.mDrawRect.right, f2 - f4);
                this.mRightTrackPath.arcTo(this.mTempRect, -fAsin, fAsin * 2.0f);
                this.mRightTrackPath.lineTo(this.mDrawRect.right, f2 + f4);
                this.mRightTrackPath.close();
                return;
            }
            return;
        }
        float fAsin2 = (float) ((Math.asin(f4 / r6) / 3.141592653589793d) * 180.0d);
        float f15 = f - f3;
        if (f15 > this.mDrawRect.left) {
            float fAcos = (float) ((Math.acos(Math.max(0.0f, (((this.mDrawRect.left + f4) - f) + f3) / f4)) / 3.141592653589793d) * 180.0d);
            this.mTempRect.set(this.mDrawRect.left, f2 - f4, this.mDrawRect.left + this.mTrackSize, f2 + f4);
            this.mLeftTrackPath.arcTo(this.mTempRect, 180.0f - fAcos, fAcos * 2.0f);
            this.mTempRect.set(f15 + 1.0f, (f2 - f3) + 1.0f, (f + f3) - 1.0f, (f2 + f3) - 1.0f);
            this.mLeftTrackPath.arcTo(this.mTempRect, 180.0f + fAsin2, (-fAsin2) * 2.0f);
            this.mLeftTrackPath.close();
        }
        float f16 = f + f3;
        if (f16 < this.mDrawRect.right) {
            double dAcos = (float) Math.acos(Math.max(0.0f, ((f16 - this.mDrawRect.right) + f4) / f4));
            double d = f4;
            this.mRightTrackPath.moveTo((float) (((double) (this.mDrawRect.right - f4)) + (Math.cos(dAcos) * d)), (float) (((double) f2) + (Math.sin(dAcos) * d)));
            float f17 = (float) ((dAcos / 3.141592653589793d) * 180.0d);
            this.mTempRect.set(this.mDrawRect.right - this.mTrackSize, f2 - f4, this.mDrawRect.right, f4 + f2);
            this.mRightTrackPath.arcTo(this.mTempRect, f17, (-f17) * 2.0f);
            this.mTempRect.set(f15 + 1.0f, (f2 - f3) + 1.0f, f16 - 1.0f, (f2 + f3) - 1.0f);
            this.mRightTrackPath.arcTo(this.mTempRect, -fAsin2, fAsin2 * 2.0f);
            this.mRightTrackPath.close();
        }
    }

    private Path getMarkPath(Path path, float f, float f2, float f3, float f4) {
        Path path2;
        if (path == null) {
            path2 = new Path();
        } else {
            path.reset();
            path2 = path;
        }
        float f5 = f - f3;
        float f6 = f + f3;
        float f7 = f2 + f3;
        float f8 = f2 - (f3 * f4);
        float fAtan2 = (float) ((Math.atan2(f2 - f8, f6 - f) * 180.0d) / 3.141592653589793d);
        float fDistance = (float) distance(f, f8, f5, f2);
        this.mTempRect.set(f - fDistance, f8 - fDistance, f + fDistance, f8 + fDistance);
        path2.moveTo(f5, f2);
        path2.arcTo(this.mTempRect, 180.0f - fAtan2, (fAtan2 * 2.0f) + 180.0f);
        if (f4 > 0.9f) {
            path2.lineTo(f, f7);
        } else {
            float f9 = (f6 + f) / 2.0f;
            float f10 = (f2 + f7) / 2.0f;
            double dDistance = distance(f6, f2, f9, f10) / Math.tan((((double) (1.0f - f4)) * 3.141592653589793d) / 4.0d);
            float fCos = (float) (((double) f9) - (Math.cos(0.7853981633974483d) * dDistance));
            float fSin = (float) (((double) f10) - (Math.sin(0.7853981633974483d) * dDistance));
            double d = f2 - fSin;
            float fAtan22 = (float) ((Math.atan2(d, f6 - fCos) * 180.0d) / 3.141592653589793d);
            double d2 = f7 - fSin;
            float fAtan23 = (float) ((Math.atan2(d2, f - fCos) * 180.0d) / 3.141592653589793d);
            float fDistance2 = (float) distance(fCos, fSin, f6, f2);
            float f11 = fSin - fDistance2;
            float f12 = fSin + fDistance2;
            this.mTempRect.set(fCos - fDistance2, f11, fCos + fDistance2, f12);
            path2.arcTo(this.mTempRect, fAtan22, fAtan23 - fAtan22);
            float f13 = (2.0f * f) - fCos;
            float fAtan24 = (float) ((Math.atan2(d2, f - f13) * 180.0d) / 3.141592653589793d);
            float fAtan25 = (float) ((Math.atan2(d, f5 - f13) * 180.0d) / 3.141592653589793d);
            this.mTempRect.set(f13 - fDistance2, f11, f13 + fDistance2, f12);
            path2.arcTo(this.mTempRect, 0.7853982f + fAtan24, fAtan25 - fAtan24);
        }
        path2.close();
        return path2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        float fWidth = (this.mDrawRect.width() * this.mThumbPosition) + this.mDrawRect.left;
        if (this.mIsRtl) {
            fWidth = (this.mDrawRect.centerX() * 2.0f) - fWidth;
        }
        float fCenterY = this.mDrawRect.centerY();
        int middleColor = ColorUtil.getMiddleColor(this.mSecondaryColor, isEnabled() ? this.mPrimaryColor : this.mSecondaryColor, this.mThumbFillPercent);
        getTrackPath(fWidth, fCenterY, this.mThumbCurrentRadius);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mIsRtl ? middleColor : this.mSecondaryColor);
        canvas.drawPath(this.mRightTrackPath, this.mPaint);
        this.mPaint.setColor(this.mIsRtl ? this.mSecondaryColor : middleColor);
        canvas.drawPath(this.mLeftTrackPath, this.mPaint);
        this.mPaint.setColor(middleColor);
        if (this.mDiscreteMode) {
            float f = this.mThumbCurrentRadius;
            int i = this.mThumbRadius;
            float f2 = 1.0f - (f / i);
            if (f2 > 0.0f) {
                this.mMarkPath = getMarkPath(this.mMarkPath, fWidth, fCenterY, i, f2);
                this.mPaint.setStyle(Paint.Style.FILL);
                int iSave = canvas.save();
                canvas.translate(0.0f, (-this.mThumbRadius) * 2 * f2);
                canvas.drawPath(this.mMarkPath, this.mPaint);
                this.mPaint.setColor(ColorUtil.getColor(this.mTextColor, f2));
                canvas.drawText(getValueText(), fWidth, ((this.mTextHeight / 2.0f) + fCenterY) - (this.mThumbRadius * f2), this.mPaint);
                canvas.restoreToCount(iSave);
            }
            float f3 = isEnabled() ? this.mThumbCurrentRadius : this.mThumbCurrentRadius - this.mThumbBorderSize;
            if (f3 > 0.0f) {
                this.mPaint.setColor(middleColor);
                canvas.drawCircle(fWidth, fCenterY, f3, this.mPaint);
                return;
            }
            return;
        }
        float f4 = isEnabled() ? this.mThumbCurrentRadius : this.mThumbCurrentRadius - this.mThumbBorderSize;
        float f5 = this.mThumbFillPercent;
        if (f5 == 1.0f) {
            this.mPaint.setStyle(Paint.Style.FILL);
        } else {
            int i2 = this.mThumbBorderSize;
            float f6 = ((f4 - i2) * f5) + i2;
            f4 -= f6 / 2.0f;
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(f6);
        }
        canvas.drawCircle(fWidth, fCenterY, f4, this.mPaint);
    }

    class ThumbRadiusAnimator implements Runnable {
        int mRadius;
        boolean mRunning = false;
        float mStartRadius;
        long mStartTime;

        ThumbRadiusAnimator() {
        }

        public void resetAnimation() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.mStartRadius = Slider.this.mThumbCurrentRadius;
        }

        public boolean startAnimation(int i) {
            if (Slider.this.mThumbCurrentRadius == i) {
                return false;
            }
            this.mRadius = i;
            if (Slider.this.getHandler() != null) {
                resetAnimation();
                this.mRunning = true;
                Slider.this.getHandler().postAtTime(this, SystemClock.uptimeMillis() + 16);
                Slider.this.invalidate();
                return true;
            }
            Slider.this.mThumbCurrentRadius = this.mRadius;
            Slider.this.invalidate();
            return false;
        }

        public void stopAnimation() {
            this.mRunning = false;
            Slider.this.mThumbCurrentRadius = this.mRadius;
            if (Slider.this.getHandler() != null) {
                Slider.this.getHandler().removeCallbacks(this);
            }
            Slider.this.invalidate();
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMin = Math.min(1.0f, (SystemClock.uptimeMillis() - this.mStartTime) / Slider.this.mTransformAnimationDuration);
            float interpolation = Slider.this.mInterpolator.getInterpolation(fMin);
            Slider slider = Slider.this;
            float f = this.mRadius;
            float f2 = this.mStartRadius;
            slider.mThumbCurrentRadius = ((f - f2) * interpolation) + f2;
            if (fMin == 1.0f) {
                stopAnimation();
            }
            if (this.mRunning) {
                if (Slider.this.getHandler() != null) {
                    Slider.this.getHandler().postAtTime(this, SystemClock.uptimeMillis() + 16);
                } else {
                    stopAnimation();
                }
            }
            Slider.this.invalidate();
        }
    }

    class ThumbStrokeAnimator implements Runnable {
        int mFillPercent;
        boolean mRunning = false;
        float mStartFillPercent;
        long mStartTime;

        ThumbStrokeAnimator() {
        }

        public void resetAnimation() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.mStartFillPercent = Slider.this.mThumbFillPercent;
        }

        public boolean startAnimation(int i) {
            if (Slider.this.mThumbFillPercent == i) {
                return false;
            }
            this.mFillPercent = i;
            if (Slider.this.getHandler() != null) {
                resetAnimation();
                this.mRunning = true;
                Slider.this.getHandler().postAtTime(this, SystemClock.uptimeMillis() + 16);
                Slider.this.invalidate();
                return true;
            }
            Slider slider = Slider.this;
            slider.mThumbFillPercent = slider.mAlwaysFillThumb ? 1.0f : this.mFillPercent;
            Slider.this.invalidate();
            return false;
        }

        public void stopAnimation() {
            this.mRunning = false;
            Slider slider = Slider.this;
            slider.mThumbFillPercent = slider.mAlwaysFillThumb ? 1.0f : this.mFillPercent;
            if (Slider.this.getHandler() != null) {
                Slider.this.getHandler().removeCallbacks(this);
            }
            Slider.this.invalidate();
        }

        @Override // java.lang.Runnable
        public void run() {
            float f;
            float fMin = Math.min(1.0f, (SystemClock.uptimeMillis() - this.mStartTime) / Slider.this.mTransformAnimationDuration);
            float interpolation = Slider.this.mInterpolator.getInterpolation(fMin);
            Slider slider = Slider.this;
            if (slider.mAlwaysFillThumb) {
                f = 1.0f;
            } else {
                float f2 = this.mFillPercent;
                float f3 = this.mStartFillPercent;
                f = ((f2 - f3) * interpolation) + f3;
            }
            slider.mThumbFillPercent = f;
            if (fMin == 1.0f) {
                stopAnimation();
            }
            if (this.mRunning) {
                if (Slider.this.getHandler() != null) {
                    Slider.this.getHandler().postAtTime(this, SystemClock.uptimeMillis() + 16);
                } else {
                    stopAnimation();
                }
            }
            Slider.this.invalidate();
        }
    }

    class ThumbMoveAnimator implements Runnable {
        int mDuration;
        float mFillPercent;
        float mPosition;
        boolean mRunning = false;
        float mStartFillPercent;
        float mStartPosition;
        float mStartRadius;
        long mStartTime;

        ThumbMoveAnimator() {
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void resetAnimation() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.mStartPosition = Slider.this.mThumbPosition;
            this.mStartFillPercent = Slider.this.mThumbFillPercent;
            this.mStartRadius = Slider.this.mThumbCurrentRadius;
            this.mFillPercent = this.mPosition != 0.0f ? 1.0f : 0.0f;
            this.mDuration = (!Slider.this.mDiscreteMode || Slider.this.mIsDragging) ? Slider.this.mTravelAnimationDuration : (Slider.this.mTransformAnimationDuration * 2) + Slider.this.mTravelAnimationDuration;
        }

        public boolean startAnimation(float f) {
            if (Slider.this.mThumbPosition == f) {
                return false;
            }
            this.mPosition = f;
            if (Slider.this.getHandler() == null) {
                Slider.this.mThumbPosition = f;
                Slider.this.invalidate();
                return false;
            }
            resetAnimation();
            this.mRunning = true;
            Slider.this.getHandler().postAtTime(this, SystemClock.uptimeMillis() + 16);
            Slider.this.invalidate();
            return true;
        }

        public void stopAnimation() {
            this.mRunning = false;
            Slider slider = Slider.this;
            slider.mThumbCurrentRadius = (slider.mDiscreteMode && Slider.this.mIsDragging) ? 0.0f : Slider.this.mThumbRadius;
            Slider slider2 = Slider.this;
            slider2.mThumbFillPercent = slider2.mAlwaysFillThumb ? 1.0f : this.mFillPercent;
            Slider.this.mThumbPosition = this.mPosition;
            if (Slider.this.getHandler() != null) {
                Slider.this.getHandler().removeCallbacks(this);
            }
            Slider.this.invalidate();
        }

        @Override // java.lang.Runnable
        public void run() {
            float f;
            float f2;
            float f3;
            float fMin = Math.min(1.0f, (SystemClock.uptimeMillis() - this.mStartTime) / this.mDuration);
            float interpolation = Slider.this.mInterpolator.getInterpolation(fMin);
            if (Slider.this.mDiscreteMode) {
                if (!Slider.this.mIsDragging) {
                    float f4 = Slider.this.mTravelAnimationDuration / this.mDuration;
                    float f5 = (Slider.this.mTravelAnimationDuration + Slider.this.mTransformAnimationDuration) / this.mDuration;
                    if (fMin < f4) {
                        float interpolation2 = Slider.this.mInterpolator.getInterpolation(fMin / f4);
                        Slider.this.mThumbCurrentRadius = this.mStartRadius * (1.0f - interpolation2);
                        Slider slider = Slider.this;
                        float f6 = this.mPosition;
                        float f7 = this.mStartPosition;
                        slider.mThumbPosition = ((f6 - f7) * interpolation2) + f7;
                        Slider slider2 = Slider.this;
                        if (slider2.mAlwaysFillThumb) {
                            f2 = 1.0f;
                        } else {
                            float f8 = this.mFillPercent;
                            float f9 = this.mStartFillPercent;
                            f2 = ((f8 - f9) * interpolation2) + f9;
                        }
                        slider2.mThumbFillPercent = f2;
                    } else if (fMin > f5) {
                        Slider.this.mThumbCurrentRadius = (r2.mThumbRadius * (fMin - f5)) / (1.0f - f5);
                    }
                } else {
                    Slider slider3 = Slider.this;
                    float f10 = this.mPosition;
                    float f11 = this.mStartPosition;
                    slider3.mThumbPosition = ((f10 - f11) * interpolation) + f11;
                    Slider slider4 = Slider.this;
                    if (slider4.mAlwaysFillThumb) {
                        f3 = 1.0f;
                    } else {
                        float f12 = this.mFillPercent;
                        float f13 = this.mStartFillPercent;
                        f3 = ((f12 - f13) * interpolation) + f13;
                    }
                    slider4.mThumbFillPercent = f3;
                }
            } else {
                Slider slider5 = Slider.this;
                float f14 = this.mPosition;
                float f15 = this.mStartPosition;
                slider5.mThumbPosition = ((f14 - f15) * interpolation) + f15;
                Slider slider6 = Slider.this;
                if (slider6.mAlwaysFillThumb) {
                    f = 1.0f;
                } else {
                    float f16 = this.mFillPercent;
                    float f17 = this.mStartFillPercent;
                    f = ((f16 - f17) * interpolation) + f17;
                }
                slider6.mThumbFillPercent = f;
                double d = fMin;
                if (d < 0.2d) {
                    Slider.this.mThumbCurrentRadius = Math.max(r2.mThumbRadius + (Slider.this.mThumbBorderSize * fMin * 5.0f), Slider.this.mThumbCurrentRadius);
                } else if (d >= 0.8d) {
                    Slider.this.mThumbCurrentRadius = r2.mThumbRadius + (Slider.this.mThumbBorderSize * (5.0f - (fMin * 5.0f)));
                }
            }
            if (fMin == 1.0f) {
                stopAnimation();
            }
            if (this.mRunning) {
                if (Slider.this.getHandler() != null) {
                    Slider.this.getHandler().postAtTime(this, SystemClock.uptimeMillis() + 16);
                } else {
                    stopAnimation();
                }
            }
            Slider.this.invalidate();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = getPosition();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setPosition(savedState.position, false);
        requestLayout();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.rey.material.widget.Slider.SavedState.1
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
        float position;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.position = parcel.readFloat();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.position);
        }

        public String toString() {
            return "Slider.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " pos=" + this.position + "}";
        }
    }
}
