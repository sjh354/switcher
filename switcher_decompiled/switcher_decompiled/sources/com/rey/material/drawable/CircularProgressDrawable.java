package com.rey.material.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.rey.material.R;
import com.rey.material.util.ColorUtil;
import com.rey.material.util.ThemeUtil;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int PROGRESS_STATE_HIDE = -1;
    private static final int PROGRESS_STATE_KEEP_SHRINK = 3;
    private static final int PROGRESS_STATE_KEEP_STRETCH = 1;
    private static final int PROGRESS_STATE_SHRINK = 2;
    private static final int PROGRESS_STATE_STRETCH = 0;
    private static final int RUN_STATE_RUNNING = 3;
    private static final int RUN_STATE_STARTED = 2;
    private static final int RUN_STATE_STARTING = 1;
    private static final int RUN_STATE_STOPPED = 0;
    private static final int RUN_STATE_STOPPING = 4;
    private int mInAnimationDuration;
    private int[] mInColors;
    private float mInStepPercent;
    private float mInitialAngle;
    private int mKeepDuration;
    private long mLastProgressStateTime;
    private long mLastRunStateTime;
    private long mLastUpdateTime;
    private float mMaxSweepAngle;
    private float mMinSweepAngle;
    private int mOutAnimationDuration;
    private int mPadding;
    private Paint mPaint;
    private int mProgressMode;
    private float mProgressPercent;
    private int mProgressState;
    private RectF mRect;
    private boolean mReverse;
    private int mRotateDuration;
    private int mRunState;
    private float mSecondaryProgressPercent;
    private float mStartAngle;
    private int mStrokeColorIndex;
    private int[] mStrokeColors;
    private int mStrokeSecondaryColor;
    private int mStrokeSize;
    private float mSweepAngle;
    private int mTransformDuration;
    private Interpolator mTransformInterpolator;
    private final Runnable mUpdater;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private CircularProgressDrawable(int i, float f, float f2, float f3, float f4, float f5, int i2, int[] iArr, int i3, boolean z, int i4, int i5, int i6, Interpolator interpolator, int i7, int i8, float f6, int[] iArr2, int i9) {
        this.mRunState = 0;
        this.mUpdater = new Runnable() { // from class: com.rey.material.drawable.CircularProgressDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                CircularProgressDrawable.this.update();
            }
        };
        this.mPadding = i;
        this.mInitialAngle = f;
        setProgress(f2);
        setSecondaryProgress(f3);
        this.mMaxSweepAngle = f4;
        this.mMinSweepAngle = f5;
        this.mStrokeSize = i2;
        this.mStrokeColors = iArr;
        this.mStrokeSecondaryColor = i3;
        this.mReverse = z;
        this.mRotateDuration = i4;
        this.mTransformDuration = i5;
        this.mKeepDuration = i6;
        this.mTransformInterpolator = interpolator;
        this.mProgressMode = i7;
        this.mInAnimationDuration = i8;
        this.mInStepPercent = f6;
        this.mInColors = iArr2;
        this.mOutAnimationDuration = i9;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mRect = new RectF();
    }

    public void applyStyle(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.CircularProgressDrawable);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        int[] iArr = null;
        boolean z = false;
        int color = 0;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.CircularProgressDrawable_cpd_padding) {
                this.mPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_initialAngle) {
                this.mInitialAngle = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_pv_progress) {
                setProgress(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
            } else if (index == R.styleable.CircularProgressDrawable_pv_secondaryProgress) {
                setSecondaryProgress(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
            } else if (index == R.styleable.CircularProgressDrawable_cpd_maxSweepAngle) {
                this.mMaxSweepAngle = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_minSweepAngle) {
                this.mMinSweepAngle = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_strokeSize) {
                this.mStrokeSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_strokeColor) {
                color = typedArrayObtainStyledAttributes.getColor(index, 0);
                z = true;
            } else if (index == R.styleable.CircularProgressDrawable_cpd_strokeColors) {
                TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(typedArrayObtainStyledAttributes.getResourceId(index, 0));
                int[] iArr2 = new int[typedArrayObtainTypedArray.length()];
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    iArr2[i3] = typedArrayObtainTypedArray.getColor(i3, 0);
                }
                typedArrayObtainTypedArray.recycle();
                iArr = iArr2;
            } else if (index == R.styleable.CircularProgressDrawable_cpd_strokeSecondaryColor) {
                this.mStrokeSecondaryColor = typedArrayObtainStyledAttributes.getColor(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_reverse) {
                this.mReverse = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_rotateDuration) {
                this.mRotateDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_transformDuration) {
                this.mTransformDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_keepDuration) {
                this.mKeepDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_transformInterpolator) {
                this.mTransformInterpolator = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(index, 0));
            } else if (index == R.styleable.CircularProgressDrawable_pv_progressMode) {
                this.mProgressMode = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_inAnimDuration) {
                this.mInAnimationDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_inStepColors) {
                TypedArray typedArrayObtainTypedArray2 = context.getResources().obtainTypedArray(typedArrayObtainStyledAttributes.getResourceId(index, 0));
                this.mInColors = new int[typedArrayObtainTypedArray2.length()];
                for (int i4 = 0; i4 < typedArrayObtainTypedArray2.length(); i4++) {
                    this.mInColors[i4] = typedArrayObtainTypedArray2.getColor(i4, 0);
                }
                typedArrayObtainTypedArray2.recycle();
            } else if (index == R.styleable.CircularProgressDrawable_cpd_inStepPercent) {
                this.mInStepPercent = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
            } else if (index == R.styleable.CircularProgressDrawable_cpd_outAnimDuration) {
                this.mOutAnimationDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        if (iArr != null) {
            this.mStrokeColors = iArr;
        } else if (z) {
            this.mStrokeColors = new int[]{color};
        }
        if (this.mStrokeColorIndex >= this.mStrokeColors.length) {
            this.mStrokeColorIndex = 0;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i = this.mProgressMode;
        if (i == 0) {
            drawDeterminate(canvas);
        } else {
            if (i != 1) {
                return;
            }
            drawIndeterminate(canvas);
        }
    }

    private void drawDeterminate(Canvas canvas) {
        float fMax;
        float f;
        float fMin;
        int iMin;
        int i;
        Rect bounds = getBounds();
        int i2 = this.mRunState;
        if (i2 == 1) {
            fMax = (this.mStrokeSize * Math.min(this.mInAnimationDuration, SystemClock.uptimeMillis() - this.mLastRunStateTime)) / this.mInAnimationDuration;
            if (fMax > 0.0f) {
                iMin = Math.min(bounds.width(), bounds.height()) - (this.mPadding * 2);
                i = this.mStrokeSize;
                fMin = (iMin - (i * 2)) + fMax;
                f = fMin / 2.0f;
            }
            f = 0.0f;
        } else if (i2 == 4) {
            fMax = (this.mStrokeSize * Math.max(0L, (((long) this.mOutAnimationDuration) - SystemClock.uptimeMillis()) + this.mLastRunStateTime)) / this.mOutAnimationDuration;
            if (fMax > 0.0f) {
                iMin = Math.min(bounds.width(), bounds.height()) - (this.mPadding * 2);
                i = this.mStrokeSize;
                fMin = (iMin - (i * 2)) + fMax;
                f = fMin / 2.0f;
            }
            f = 0.0f;
        } else if (i2 != 0) {
            fMax = this.mStrokeSize;
            fMin = (Math.min(bounds.width(), bounds.height()) - (this.mPadding * 2)) - this.mStrokeSize;
            f = fMin / 2.0f;
        } else {
            fMax = 0.0f;
            f = 0.0f;
        }
        if (f > 0.0f) {
            float f2 = (bounds.left + bounds.right) / 2.0f;
            float f3 = (bounds.top + bounds.bottom) / 2.0f;
            this.mPaint.setStrokeWidth(fMax);
            this.mPaint.setStyle(Paint.Style.STROKE);
            float f4 = this.mProgressPercent;
            if (f4 == 1.0f) {
                this.mPaint.setColor(this.mStrokeColors[0]);
                canvas.drawCircle(f2, f3, f, this.mPaint);
            } else {
                if (f4 == 0.0f) {
                    this.mPaint.setColor(this.mStrokeSecondaryColor);
                    canvas.drawCircle(f2, f3, f, this.mPaint);
                    return;
                }
                float f5 = (this.mReverse ? -360 : 360) * f4;
                this.mRect.set(f2 - f, f3 - f, f2 + f, f3 + f);
                this.mPaint.setColor(this.mStrokeSecondaryColor);
                canvas.drawArc(this.mRect, this.mStartAngle + f5, (this.mReverse ? -360 : 360) - f5, false, this.mPaint);
                this.mPaint.setColor(this.mStrokeColors[0]);
                canvas.drawArc(this.mRect, this.mStartAngle, f5, false, this.mPaint);
            }
        }
    }

    private int getIndeterminateStrokeColor() {
        if (this.mProgressState != 3 || this.mStrokeColors.length == 1) {
            return this.mStrokeColors[this.mStrokeColorIndex];
        }
        float fMax = Math.max(0.0f, Math.min(1.0f, (SystemClock.uptimeMillis() - this.mLastProgressStateTime) / this.mKeepDuration));
        int i = this.mStrokeColorIndex;
        int length = i == 0 ? this.mStrokeColors.length - 1 : i - 1;
        int[] iArr = this.mStrokeColors;
        return ColorUtil.getMiddleColor(iArr[length], iArr[i], fMax);
    }

    private void drawIndeterminate(Canvas canvas) {
        int i = this.mRunState;
        float f = 0.0f;
        float f2 = 2.0f;
        if (i != 1) {
            if (i != 4) {
                if (i != 0) {
                    Rect bounds = getBounds();
                    float fMin = ((Math.min(bounds.width(), bounds.height()) - (this.mPadding * 2)) - this.mStrokeSize) / 2.0f;
                    float f3 = (bounds.left + bounds.right) / 2.0f;
                    float f4 = (bounds.top + bounds.bottom) / 2.0f;
                    this.mRect.set(f3 - fMin, f4 - fMin, f3 + fMin, f4 + fMin);
                    this.mPaint.setStrokeWidth(this.mStrokeSize);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setColor(getIndeterminateStrokeColor());
                    canvas.drawArc(this.mRect, this.mStartAngle, this.mSweepAngle, false, this.mPaint);
                    return;
                }
                return;
            }
            float fMax = (this.mStrokeSize * Math.max(0L, (((long) this.mOutAnimationDuration) - SystemClock.uptimeMillis()) + this.mLastRunStateTime)) / this.mOutAnimationDuration;
            if (fMax > 0.0f) {
                Rect bounds2 = getBounds();
                float fMin2 = (((Math.min(bounds2.width(), bounds2.height()) - (this.mPadding * 2)) - (this.mStrokeSize * 2)) + fMax) / 2.0f;
                float f5 = (bounds2.left + bounds2.right) / 2.0f;
                float f6 = (bounds2.top + bounds2.bottom) / 2.0f;
                this.mRect.set(f5 - fMin2, f6 - fMin2, f5 + fMin2, f6 + fMin2);
                this.mPaint.setStrokeWidth(fMax);
                this.mPaint.setStyle(Paint.Style.STROKE);
                this.mPaint.setColor(getIndeterminateStrokeColor());
                canvas.drawArc(this.mRect, this.mStartAngle, this.mSweepAngle, false, this.mPaint);
                return;
            }
            return;
        }
        Rect bounds3 = getBounds();
        float f7 = (bounds3.left + bounds3.right) / 2.0f;
        float f8 = (bounds3.top + bounds3.bottom) / 2.0f;
        float fMin3 = (Math.min(bounds3.width(), bounds3.height()) - (this.mPadding * 2)) / 2.0f;
        float f9 = 1.0f;
        float fUptimeMillis = (SystemClock.uptimeMillis() - this.mLastRunStateTime) / this.mInAnimationDuration;
        float length = fUptimeMillis / (1.0f / ((this.mInStepPercent * (this.mInColors.length + 2)) + 1.0f));
        int iFloor = (int) Math.floor(length);
        float f10 = 0.0f;
        while (iFloor >= 0) {
            float fMin4 = Math.min(f9, (length - iFloor) * this.mInStepPercent) * fMin3;
            int[] iArr = this.mInColors;
            if (iFloor < iArr.length) {
                if (f10 != f) {
                    if (fMin4 <= f10) {
                        break;
                    }
                    float f11 = (f10 + fMin4) / f2;
                    this.mRect.set(f7 - f11, f8 - f11, f7 + f11, f8 + f11);
                    this.mPaint.setStrokeWidth(fMin4 - f10);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setColor(this.mInColors[iFloor]);
                    canvas.drawCircle(f7, f8, f11, this.mPaint);
                } else {
                    this.mPaint.setColor(iArr[iFloor]);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(f7, f8, fMin4, this.mPaint);
                }
            }
            iFloor--;
            f10 = fMin4;
            f = 0.0f;
            f2 = 2.0f;
            f9 = 1.0f;
        }
        if (this.mProgressState == -1) {
            if (length >= 1.0f / this.mInStepPercent || fUptimeMillis >= 1.0f) {
                resetAnimation();
                this.mProgressState = 0;
                return;
            }
            return;
        }
        float f12 = fMin3 - (this.mStrokeSize / 2.0f);
        this.mRect.set(f7 - f12, f8 - f12, f7 + f12, f8 + f12);
        this.mPaint.setStrokeWidth(this.mStrokeSize);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(getIndeterminateStrokeColor());
        canvas.drawArc(this.mRect, this.mStartAngle, this.mSweepAngle, false, this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public int getProgressMode() {
        return this.mProgressMode;
    }

    public void setProgressMode(int i) {
        if (this.mProgressMode != i) {
            this.mProgressMode = i;
            invalidateSelf();
        }
    }

    public float getProgress() {
        return this.mProgressPercent;
    }

    public float getSecondaryProgress() {
        return this.mSecondaryProgressPercent;
    }

    public void setProgress(float f) {
        float fMin = Math.min(1.0f, Math.max(0.0f, f));
        if (this.mProgressPercent != fMin) {
            this.mProgressPercent = fMin;
            if (isRunning()) {
                invalidateSelf();
            } else if (this.mProgressPercent != 0.0f) {
                start();
            }
        }
    }

    public void setSecondaryProgress(float f) {
        float fMin = Math.min(1.0f, Math.max(0.0f, f));
        if (this.mSecondaryProgressPercent != fMin) {
            this.mSecondaryProgressPercent = fMin;
            if (isRunning()) {
                invalidateSelf();
            } else if (this.mSecondaryProgressPercent != 0.0f) {
                start();
            }
        }
    }

    private void resetAnimation() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.mLastUpdateTime = jUptimeMillis;
        this.mLastProgressStateTime = jUptimeMillis;
        this.mStartAngle = this.mInitialAngle;
        this.mStrokeColorIndex = 0;
        this.mSweepAngle = this.mReverse ? -this.mMinSweepAngle : this.mMinSweepAngle;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        start(this.mInAnimationDuration > 0);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        stop(this.mOutAnimationDuration > 0);
    }

    private void start(boolean z) {
        if (isRunning()) {
            return;
        }
        resetAnimation();
        if (z) {
            this.mRunState = 1;
            this.mLastRunStateTime = SystemClock.uptimeMillis();
            this.mProgressState = -1;
        }
        scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
        invalidateSelf();
    }

    private void stop(boolean z) {
        if (isRunning()) {
            if (z) {
                this.mLastRunStateTime = SystemClock.uptimeMillis();
                if (this.mRunState == 2) {
                    scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
                    invalidateSelf();
                }
                this.mRunState = 4;
                return;
            }
            this.mRunState = 0;
            unscheduleSelf(this.mUpdater);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunState != 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.mRunState == 0) {
            this.mRunState = this.mInAnimationDuration > 0 ? 1 : 3;
        }
        super.scheduleSelf(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        int i = this.mProgressMode;
        if (i == 0) {
            updateDeterminate();
        } else {
            if (i != 1) {
                return;
            }
            updateIndeterminate();
        }
    }

    private void updateDeterminate() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = ((jUptimeMillis - this.mLastUpdateTime) * 360.0f) / this.mRotateDuration;
        if (this.mReverse) {
            f = -f;
        }
        this.mLastUpdateTime = jUptimeMillis;
        this.mStartAngle += f;
        int i = this.mRunState;
        if (i == 1) {
            if (jUptimeMillis - this.mLastRunStateTime > this.mInAnimationDuration) {
                this.mRunState = 3;
            }
        } else if (i == 4 && jUptimeMillis - this.mLastRunStateTime > this.mOutAnimationDuration) {
            stop(false);
            return;
        }
        if (isRunning()) {
            scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
        }
        invalidateSelf();
    }

    private void updateIndeterminate() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = ((jUptimeMillis - this.mLastUpdateTime) * 360.0f) / this.mRotateDuration;
        boolean z = this.mReverse;
        if (z) {
            f = -f;
        }
        this.mLastUpdateTime = jUptimeMillis;
        int i = this.mProgressState;
        if (i == 0) {
            int i2 = this.mTransformDuration;
            if (i2 <= 0) {
                this.mSweepAngle = z ? -this.mMinSweepAngle : this.mMinSweepAngle;
                this.mProgressState = 1;
                this.mStartAngle += f;
                this.mLastProgressStateTime = jUptimeMillis;
            } else {
                float f2 = (jUptimeMillis - this.mLastProgressStateTime) / i2;
                float f3 = this.mMaxSweepAngle;
                if (z) {
                    f3 = -f3;
                }
                float f4 = z ? -this.mMinSweepAngle : this.mMinSweepAngle;
                this.mStartAngle += f;
                this.mSweepAngle = (this.mTransformInterpolator.getInterpolation(f2) * (f3 - f4)) + f4;
                if (f2 > 1.0f) {
                    this.mSweepAngle = f3;
                    this.mProgressState = 1;
                    this.mLastProgressStateTime = jUptimeMillis;
                }
            }
        } else if (i == 1) {
            this.mStartAngle += f;
            if (jUptimeMillis - this.mLastProgressStateTime > this.mKeepDuration) {
                this.mProgressState = 2;
                this.mLastProgressStateTime = jUptimeMillis;
            }
        } else if (i == 2) {
            int i3 = this.mTransformDuration;
            if (i3 <= 0) {
                this.mSweepAngle = z ? -this.mMinSweepAngle : this.mMinSweepAngle;
                this.mProgressState = 3;
                this.mStartAngle += f;
                this.mLastProgressStateTime = jUptimeMillis;
                this.mStrokeColorIndex = (this.mStrokeColorIndex + 1) % this.mStrokeColors.length;
            } else {
                float f5 = (jUptimeMillis - this.mLastProgressStateTime) / i3;
                float f6 = this.mMaxSweepAngle;
                if (z) {
                    f6 = -f6;
                }
                float f7 = z ? -this.mMinSweepAngle : this.mMinSweepAngle;
                float interpolation = ((1.0f - this.mTransformInterpolator.getInterpolation(f5)) * (f6 - f7)) + f7;
                this.mStartAngle += (f + this.mSweepAngle) - interpolation;
                this.mSweepAngle = interpolation;
                if (f5 > 1.0f) {
                    this.mSweepAngle = f7;
                    this.mProgressState = 3;
                    this.mLastProgressStateTime = jUptimeMillis;
                    this.mStrokeColorIndex = (this.mStrokeColorIndex + 1) % this.mStrokeColors.length;
                }
            }
        } else if (i == 3) {
            this.mStartAngle += f;
            if (jUptimeMillis - this.mLastProgressStateTime > this.mKeepDuration) {
                this.mProgressState = 0;
                this.mLastProgressStateTime = jUptimeMillis;
            }
        }
        int i4 = this.mRunState;
        if (i4 == 1) {
            if (jUptimeMillis - this.mLastRunStateTime > this.mInAnimationDuration) {
                this.mRunState = 3;
                if (this.mProgressState == -1) {
                    resetAnimation();
                    this.mProgressState = 0;
                }
            }
        } else if (i4 == 4 && jUptimeMillis - this.mLastRunStateTime > this.mOutAnimationDuration) {
            stop(false);
            return;
        }
        if (isRunning()) {
            scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
        }
        invalidateSelf();
    }

    public static class Builder {
        private int mInAnimationDuration;
        private int[] mInColors;
        private float mInStepPercent;
        private float mInitialAngle;
        private int mKeepDuration;
        private float mMaxSweepAngle;
        private float mMinSweepAngle;
        private int mOutAnimationDuration;
        private int mPadding;
        private int mProgressMode;
        private float mProgressPercent;
        private boolean mReverse;
        private int mRotateDuration;
        private float mSecondaryProgressPercent;
        private int[] mStrokeColors;
        private int mStrokeSecondaryColor;
        private int mStrokeSize;
        private int mTransformDuration;
        private Interpolator mTransformInterpolator;

        public Builder() {
        }

        public Builder(Context context, int i) {
            this(context, null, 0, i);
        }

        public Builder(Context context, AttributeSet attributeSet, int i, int i2) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircularProgressDrawable, i, i2);
            padding(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressDrawable_cpd_padding, 0));
            initialAngle(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_initialAngle, 0));
            progressPercent(typedArrayObtainStyledAttributes.getFloat(R.styleable.CircularProgressDrawable_pv_progress, 0.0f));
            secondaryProgressPercent(typedArrayObtainStyledAttributes.getFloat(R.styleable.CircularProgressDrawable_pv_secondaryProgress, 0.0f));
            maxSweepAngle(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_maxSweepAngle, 270));
            minSweepAngle(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_minSweepAngle, 1));
            strokeSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressDrawable_cpd_strokeSize, ThemeUtil.dpToPx(context, 4)));
            strokeColors(typedArrayObtainStyledAttributes.getColor(R.styleable.CircularProgressDrawable_cpd_strokeColor, ThemeUtil.colorPrimary(context, ViewCompat.MEASURED_STATE_MASK)));
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircularProgressDrawable_cpd_strokeColors, 0);
            if (resourceId != 0) {
                TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(resourceId);
                int[] iArr = new int[typedArrayObtainTypedArray.length()];
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    iArr[i3] = typedArrayObtainTypedArray.getColor(i3, 0);
                }
                typedArrayObtainTypedArray.recycle();
                strokeColors(iArr);
            }
            strokeSecondaryColor(typedArrayObtainStyledAttributes.getColor(R.styleable.CircularProgressDrawable_cpd_strokeSecondaryColor, 0));
            reverse(typedArrayObtainStyledAttributes.getBoolean(R.styleable.CircularProgressDrawable_cpd_reverse, false));
            rotateDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_rotateDuration, context.getResources().getInteger(android.R.integer.config_longAnimTime)));
            transformDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_transformDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            keepDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_keepDuration, context.getResources().getInteger(android.R.integer.config_shortAnimTime)));
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircularProgressDrawable_cpd_transformInterpolator, 0);
            if (resourceId2 != 0) {
                transformInterpolator(AnimationUtils.loadInterpolator(context, resourceId2));
            }
            progressMode(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_pv_progressMode, 1));
            inAnimDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_inAnimDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CircularProgressDrawable_cpd_inStepColors, 0);
            if (resourceId3 != 0) {
                TypedArray typedArrayObtainTypedArray2 = context.getResources().obtainTypedArray(resourceId3);
                int[] iArr2 = new int[typedArrayObtainTypedArray2.length()];
                for (int i4 = 0; i4 < typedArrayObtainTypedArray2.length(); i4++) {
                    iArr2[i4] = typedArrayObtainTypedArray2.getColor(i4, 0);
                }
                typedArrayObtainTypedArray2.recycle();
                inStepColors(iArr2);
            }
            inStepPercent(typedArrayObtainStyledAttributes.getFloat(R.styleable.CircularProgressDrawable_cpd_inStepPercent, 0.5f));
            outAnimDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressDrawable_cpd_outAnimDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            typedArrayObtainStyledAttributes.recycle();
        }

        public CircularProgressDrawable build() {
            if (this.mStrokeColors == null) {
                this.mStrokeColors = new int[]{-16737793};
            }
            if (this.mInColors == null && this.mInAnimationDuration > 0) {
                this.mInColors = new int[]{-4860673, -2168068, -327682};
            }
            if (this.mTransformInterpolator == null) {
                this.mTransformInterpolator = new DecelerateInterpolator();
            }
            return new CircularProgressDrawable(this.mPadding, this.mInitialAngle, this.mProgressPercent, this.mSecondaryProgressPercent, this.mMaxSweepAngle, this.mMinSweepAngle, this.mStrokeSize, this.mStrokeColors, this.mStrokeSecondaryColor, this.mReverse, this.mRotateDuration, this.mTransformDuration, this.mKeepDuration, this.mTransformInterpolator, this.mProgressMode, this.mInAnimationDuration, this.mInStepPercent, this.mInColors, this.mOutAnimationDuration);
        }

        public Builder padding(int i) {
            this.mPadding = i;
            return this;
        }

        public Builder initialAngle(float f) {
            this.mInitialAngle = f;
            return this;
        }

        public Builder progressPercent(float f) {
            this.mProgressPercent = f;
            return this;
        }

        public Builder secondaryProgressPercent(float f) {
            this.mSecondaryProgressPercent = f;
            return this;
        }

        public Builder maxSweepAngle(float f) {
            this.mMaxSweepAngle = f;
            return this;
        }

        public Builder minSweepAngle(float f) {
            this.mMinSweepAngle = f;
            return this;
        }

        public Builder strokeSize(int i) {
            this.mStrokeSize = i;
            return this;
        }

        public Builder strokeColors(int... iArr) {
            this.mStrokeColors = iArr;
            return this;
        }

        public Builder strokeSecondaryColor(int i) {
            this.mStrokeSecondaryColor = i;
            return this;
        }

        public Builder reverse(boolean z) {
            this.mReverse = z;
            return this;
        }

        public Builder reverse() {
            return reverse(true);
        }

        public Builder rotateDuration(int i) {
            this.mRotateDuration = i;
            return this;
        }

        public Builder transformDuration(int i) {
            this.mTransformDuration = i;
            return this;
        }

        public Builder keepDuration(int i) {
            this.mKeepDuration = i;
            return this;
        }

        public Builder transformInterpolator(Interpolator interpolator) {
            this.mTransformInterpolator = interpolator;
            return this;
        }

        public Builder progressMode(int i) {
            this.mProgressMode = i;
            return this;
        }

        public Builder inAnimDuration(int i) {
            this.mInAnimationDuration = i;
            return this;
        }

        public Builder inStepPercent(float f) {
            this.mInStepPercent = f;
            return this;
        }

        public Builder inStepColors(int... iArr) {
            this.mInColors = iArr;
            return this;
        }

        public Builder outAnimDuration(int i) {
            this.mOutAnimationDuration = i;
            return this;
        }
    }
}
