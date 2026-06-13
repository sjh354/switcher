package com.rey.material.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.rey.material.R;
import com.rey.material.util.ColorUtil;
import com.rey.material.util.ThemeUtil;
import cz.msebera.android.httpclient.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class LinearProgressDrawable extends Drawable implements Animatable {
    public static final int ALIGN_BOTTOM = 2;
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_TOP = 0;
    private static final int PROGRESS_STATE_KEEP_SHRINK = 3;
    private static final int PROGRESS_STATE_KEEP_STRETCH = 1;
    private static final int PROGRESS_STATE_SHRINK = 2;
    private static final int PROGRESS_STATE_STRETCH = 0;
    private static final int RUN_STATE_RUNNING = 3;
    private static final int RUN_STATE_STARTED = 2;
    private static final int RUN_STATE_STARTING = 1;
    private static final int RUN_STATE_STOPPED = 0;
    private static final int RUN_STATE_STOPPING = 4;
    private float mAnimTime;
    private int mInAnimationDuration;
    private int mKeepDuration;
    private long mLastProgressStateTime;
    private long mLastRunStateTime;
    private long mLastUpdateTime;
    private float mLineWidth;
    private int mMaxLineWidth;
    private float mMaxLineWidthPercent;
    private int mMinLineWidth;
    private float mMinLineWidthPercent;
    private int mOutAnimationDuration;
    private Paint mPaint;
    private Path mPath;
    private DashPathEffect mPathEffect;
    private int mProgressMode;
    private float mProgressPercent;
    private int mProgressState;
    private boolean mReverse;
    private int mRunState;
    private float mSecondaryProgressPercent;
    private float mStartLine;
    private int mStrokeColorIndex;
    private int[] mStrokeColors;
    private int mStrokeSecondaryColor;
    private int mStrokeSize;
    private int mTransformDuration;
    private Interpolator mTransformInterpolator;
    private int mTravelDuration;
    private final Runnable mUpdater;
    private int mVerticalAlign;

    private float offset(float f, float f2, float f3) {
        float f4 = f + f2;
        return f4 > f3 ? f4 - f3 : f4 < 0.0f ? f3 + f4 : f4;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private LinearProgressDrawable(float f, float f2, int i, float f3, int i2, float f4, int i3, int i4, int[] iArr, int i5, boolean z, int i6, int i7, int i8, Interpolator interpolator, int i9, int i10, int i11) {
        this.mRunState = 0;
        this.mUpdater = new Runnable() { // from class: com.rey.material.drawable.LinearProgressDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                LinearProgressDrawable.this.update();
            }
        };
        setProgress(f);
        setSecondaryProgress(f2);
        this.mMaxLineWidth = i;
        this.mMaxLineWidthPercent = f3;
        this.mMinLineWidth = i2;
        this.mMinLineWidthPercent = f4;
        this.mStrokeSize = i3;
        this.mVerticalAlign = i4;
        this.mStrokeColors = iArr;
        this.mStrokeSecondaryColor = i5;
        this.mReverse = z;
        this.mTravelDuration = i6;
        this.mTransformDuration = i7;
        this.mKeepDuration = i8;
        this.mTransformInterpolator = interpolator;
        this.mProgressMode = i9;
        this.mInAnimationDuration = i10;
        this.mOutAnimationDuration = i11;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPath = new Path();
    }

    public void applyStyle(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.LinearProgressDrawable);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        int[] iArr = null;
        boolean z = false;
        int color = 0;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.LinearProgressDrawable_pv_progress) {
                setProgress(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
            } else if (index == R.styleable.LinearProgressDrawable_pv_secondaryProgress) {
                setSecondaryProgress(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
            } else if (index == R.styleable.LinearProgressDrawable_lpd_maxLineWidth) {
                if (typedArrayObtainStyledAttributes.peekValue(index).type == 6) {
                    this.mMaxLineWidthPercent = typedArrayObtainStyledAttributes.getFraction(index, 1, 1, 0.75f);
                    this.mMaxLineWidth = 0;
                } else {
                    this.mMaxLineWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    this.mMaxLineWidthPercent = 0.0f;
                }
            } else if (index == R.styleable.LinearProgressDrawable_lpd_minLineWidth) {
                if (typedArrayObtainStyledAttributes.peekValue(index).type == 6) {
                    this.mMinLineWidthPercent = typedArrayObtainStyledAttributes.getFraction(index, 1, 1, 0.25f);
                    this.mMinLineWidth = 0;
                } else {
                    this.mMinLineWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    this.mMinLineWidthPercent = 0.0f;
                }
            } else if (index == R.styleable.LinearProgressDrawable_lpd_strokeSize) {
                this.mStrokeSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_verticalAlign) {
                this.mVerticalAlign = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_strokeColor) {
                color = typedArrayObtainStyledAttributes.getColor(index, 0);
                z = true;
            } else if (index == R.styleable.LinearProgressDrawable_lpd_strokeColors) {
                TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(typedArrayObtainStyledAttributes.getResourceId(index, 0));
                int[] iArr2 = new int[typedArrayObtainTypedArray.length()];
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    iArr2[i3] = typedArrayObtainTypedArray.getColor(i3, 0);
                }
                typedArrayObtainTypedArray.recycle();
                iArr = iArr2;
            } else if (index == R.styleable.LinearProgressDrawable_lpd_strokeSecondaryColor) {
                this.mStrokeSecondaryColor = typedArrayObtainStyledAttributes.getColor(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_reverse) {
                this.mReverse = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_travelDuration) {
                this.mTravelDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_transformDuration) {
                this.mTransformDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_keepDuration) {
                this.mKeepDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_transformInterpolator) {
                this.mTransformInterpolator = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(index, 0));
            } else if (index == R.styleable.LinearProgressDrawable_pv_progressMode) {
                this.mProgressMode = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_inAnimDuration) {
                this.mInAnimationDuration = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.LinearProgressDrawable_lpd_outAnimDuration) {
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
            return;
        }
        if (i == 1) {
            drawIndeterminate(canvas);
        } else if (i == 2) {
            drawBuffer(canvas);
        } else {
            if (i != 3) {
                return;
            }
            drawQuery(canvas);
        }
    }

    private void drawLinePath(Canvas canvas, float f, float f2, float f3, float f4, Paint paint) {
        this.mPath.reset();
        this.mPath.moveTo(f, f2);
        this.mPath.lineTo(f3, f4);
        canvas.drawPath(this.mPath, paint);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawDeterminate(android.graphics.Canvas r14) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rey.material.drawable.LinearProgressDrawable.drawDeterminate(android.graphics.Canvas):void");
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawIndeterminate(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rey.material.drawable.LinearProgressDrawable.drawIndeterminate(android.graphics.Canvas):void");
    }

    private PathEffect getPathEffect() {
        if (this.mPathEffect == null) {
            this.mPathEffect = new DashPathEffect(new float[]{0.1f, this.mStrokeSize * 2}, 0.0f);
        }
        return this.mPathEffect;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawBuffer(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rey.material.drawable.LinearProgressDrawable.drawBuffer(android.graphics.Canvas):void");
    }

    private int getQueryStrokeColor() {
        return ColorUtil.getColor(this.mStrokeColors[0], this.mAnimTime);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawQuery(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rey.material.drawable.LinearProgressDrawable.drawQuery(android.graphics.Canvas):void");
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
        int i = this.mProgressMode;
        if (i == 1) {
            this.mStartLine = this.mReverse ? getBounds().width() : 0.0f;
            this.mStrokeColorIndex = 0;
            this.mLineWidth = this.mReverse ? -this.mMinLineWidth : this.mMinLineWidth;
            this.mProgressState = 0;
            return;
        }
        if (i == 2) {
            this.mStartLine = 0.0f;
        } else if (i == 3) {
            this.mStartLine = this.mReverse ? 0.0f : getBounds().width();
            this.mStrokeColorIndex = 0;
            this.mLineWidth = !this.mReverse ? -this.mMaxLineWidth : this.mMaxLineWidth;
        }
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
        if (z) {
            this.mRunState = 1;
            this.mLastRunStateTime = SystemClock.uptimeMillis();
        }
        resetAnimation();
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
            return;
        }
        if (i == 1) {
            updateIndeterminate();
        } else if (i == 2) {
            updateBuffer();
        } else {
            if (i != 3) {
                return;
            }
            updateQuery();
        }
    }

    private void updateDeterminate() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.mRunState;
        if (i == 1) {
            if (jUptimeMillis - this.mLastRunStateTime > this.mInAnimationDuration) {
                this.mRunState = 2;
                return;
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
        int iWidth = getBounds().width();
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = iWidth;
        float f2 = ((jUptimeMillis - this.mLastUpdateTime) * f) / this.mTravelDuration;
        boolean z = this.mReverse;
        if (z) {
            f2 = -f2;
        }
        this.mLastUpdateTime = jUptimeMillis;
        int i = this.mProgressState;
        if (i == 0) {
            int i2 = this.mTransformDuration;
            if (i2 <= 0) {
                int i3 = this.mMinLineWidth;
                float f3 = i3 == 0 ? this.mMinLineWidthPercent * f : i3;
                this.mLineWidth = f3;
                if (z) {
                    this.mLineWidth = -f3;
                }
                this.mStartLine = offset(this.mStartLine, f2, f);
                this.mProgressState = 1;
                this.mLastProgressStateTime = jUptimeMillis;
            } else {
                float f4 = (jUptimeMillis - this.mLastProgressStateTime) / i2;
                int i4 = this.mMaxLineWidth;
                float f5 = i4 == 0 ? this.mMaxLineWidthPercent * f : i4;
                int i5 = this.mMinLineWidth;
                float f6 = i5 == 0 ? this.mMinLineWidthPercent * f : i5;
                this.mStartLine = offset(this.mStartLine, f2, f);
                float interpolation = (this.mTransformInterpolator.getInterpolation(f4) * (f5 - f6)) + f6;
                this.mLineWidth = interpolation;
                boolean z2 = this.mReverse;
                if (z2) {
                    this.mLineWidth = -interpolation;
                }
                if (f4 > 1.0f) {
                    if (z2) {
                        f5 = -f5;
                    }
                    this.mLineWidth = f5;
                    this.mProgressState = 1;
                    this.mLastProgressStateTime = jUptimeMillis;
                }
            }
        } else if (i == 1) {
            this.mStartLine = offset(this.mStartLine, f2, f);
            if (jUptimeMillis - this.mLastProgressStateTime > this.mKeepDuration) {
                this.mProgressState = 2;
                this.mLastProgressStateTime = jUptimeMillis;
            }
        } else if (i == 2) {
            int i6 = this.mTransformDuration;
            if (i6 <= 0) {
                int i7 = this.mMinLineWidth;
                float f7 = i7 == 0 ? this.mMinLineWidthPercent * f : i7;
                this.mLineWidth = f7;
                if (z) {
                    this.mLineWidth = -f7;
                }
                this.mStartLine = offset(this.mStartLine, f2, f);
                this.mProgressState = 3;
                this.mLastProgressStateTime = jUptimeMillis;
                this.mStrokeColorIndex = (this.mStrokeColorIndex + 1) % this.mStrokeColors.length;
            } else {
                float f8 = (jUptimeMillis - this.mLastProgressStateTime) / i6;
                int i8 = this.mMaxLineWidth;
                float f9 = i8 == 0 ? this.mMaxLineWidthPercent * f : i8;
                int i9 = this.mMinLineWidth;
                float f10 = i9 == 0 ? this.mMinLineWidthPercent * f : i9;
                float interpolation2 = ((1.0f - this.mTransformInterpolator.getInterpolation(f8)) * (f9 - f10)) + f10;
                if (this.mReverse) {
                    interpolation2 = -interpolation2;
                }
                this.mStartLine = offset(this.mStartLine, (f2 + this.mLineWidth) - interpolation2, f);
                this.mLineWidth = interpolation2;
                if (f8 > 1.0f) {
                    if (this.mReverse) {
                        f10 = -f10;
                    }
                    this.mLineWidth = f10;
                    this.mProgressState = 3;
                    this.mLastProgressStateTime = jUptimeMillis;
                    this.mStrokeColorIndex = (this.mStrokeColorIndex + 1) % this.mStrokeColors.length;
                }
            }
        } else if (i == 3) {
            this.mStartLine = offset(this.mStartLine, f2, f);
            if (jUptimeMillis - this.mLastProgressStateTime > this.mKeepDuration) {
                this.mProgressState = 0;
                this.mLastProgressStateTime = jUptimeMillis;
            }
        }
        int i10 = this.mRunState;
        if (i10 == 1) {
            if (jUptimeMillis - this.mLastRunStateTime > this.mInAnimationDuration) {
                this.mRunState = 3;
            }
        } else if (i10 == 4 && jUptimeMillis - this.mLastRunStateTime > this.mOutAnimationDuration) {
            stop(false);
            return;
        }
        if (isRunning()) {
            scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
        }
        invalidateSelf();
    }

    private void updateBuffer() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = this.mStrokeSize * 2;
        this.mStartLine += ((jUptimeMillis - this.mLastUpdateTime) * f) / this.mTravelDuration;
        while (true) {
            float f2 = this.mStartLine;
            if (f2 <= f) {
                break;
            } else {
                this.mStartLine = f2 - f;
            }
        }
        this.mLastUpdateTime = jUptimeMillis;
        int i = this.mProgressState;
        if (i == 0) {
            int i2 = this.mTransformDuration;
            if (i2 <= 0) {
                this.mProgressState = 1;
                this.mLastProgressStateTime = jUptimeMillis;
            } else {
                float f3 = (jUptimeMillis - this.mLastProgressStateTime) / i2;
                float interpolation = this.mTransformInterpolator.getInterpolation(f3);
                int i3 = this.mStrokeSize;
                this.mLineWidth = interpolation * i3;
                if (f3 > 1.0f) {
                    this.mLineWidth = i3;
                    this.mProgressState = 1;
                    this.mLastProgressStateTime = jUptimeMillis;
                }
            }
        } else if (i != 1) {
            if (i == 2) {
                int i4 = this.mTransformDuration;
                if (i4 <= 0) {
                    this.mProgressState = 3;
                    this.mLastProgressStateTime = jUptimeMillis;
                } else {
                    float f4 = (jUptimeMillis - this.mLastProgressStateTime) / i4;
                    this.mLineWidth = (1.0f - this.mTransformInterpolator.getInterpolation(f4)) * this.mStrokeSize;
                    if (f4 > 1.0f) {
                        this.mLineWidth = 0.0f;
                        this.mProgressState = 3;
                        this.mLastProgressStateTime = jUptimeMillis;
                    }
                }
            } else if (i == 3 && jUptimeMillis - this.mLastProgressStateTime > this.mKeepDuration) {
                this.mProgressState = 0;
                this.mLastProgressStateTime = jUptimeMillis;
            }
        } else if (jUptimeMillis - this.mLastProgressStateTime > this.mKeepDuration) {
            this.mProgressState = 2;
            this.mLastProgressStateTime = jUptimeMillis;
        }
        int i5 = this.mRunState;
        if (i5 == 1) {
            if (jUptimeMillis - this.mLastRunStateTime > this.mInAnimationDuration) {
                this.mRunState = 3;
            }
        } else if (i5 == 4 && jUptimeMillis - this.mLastRunStateTime > this.mOutAnimationDuration) {
            stop(false);
            return;
        }
        if (isRunning()) {
            scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
        }
        invalidateSelf();
    }

    private void updateQuery() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = (jUptimeMillis - this.mLastProgressStateTime) / this.mTravelDuration;
        this.mAnimTime = f;
        boolean z = this.mRunState == 4 || this.mProgressPercent == 0.0f || f < 1.0f;
        if (f > 1.0f) {
            this.mLastProgressStateTime = Math.round(jUptimeMillis - ((f - 1.0f) * r3));
            this.mAnimTime -= 1.0f;
        }
        if (z && this.mRunState != 4) {
            int iWidth = getBounds().width();
            int i = this.mMaxLineWidth;
            float f2 = i == 0 ? iWidth * this.mMaxLineWidthPercent : i;
            int i2 = this.mMinLineWidth;
            float f3 = i2 == 0 ? iWidth * this.mMinLineWidthPercent : i2;
            float interpolation = (this.mTransformInterpolator.getInterpolation(this.mAnimTime) * (f3 - f2)) + f2;
            this.mLineWidth = interpolation;
            boolean z2 = this.mReverse;
            if (z2) {
                this.mLineWidth = -interpolation;
            }
            this.mStartLine = z2 ? this.mTransformInterpolator.getInterpolation(this.mAnimTime) * (iWidth + f3) : ((1.0f - this.mTransformInterpolator.getInterpolation(this.mAnimTime)) * (iWidth + f3)) - f3;
        }
        int i3 = this.mRunState;
        if (i3 == 1) {
            if (jUptimeMillis - this.mLastRunStateTime > this.mInAnimationDuration) {
                this.mRunState = 3;
            }
        } else if (i3 == 4 && jUptimeMillis - this.mLastRunStateTime > this.mOutAnimationDuration) {
            stop(false);
            return;
        }
        if (isRunning()) {
            if (z) {
                scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
            } else if (this.mRunState == 3) {
                this.mRunState = 2;
            }
        }
        invalidateSelf();
    }

    public static class Builder {
        private int mInAnimationDuration;
        private int mKeepDuration;
        private int mMaxLineWidth;
        private float mMaxLineWidthPercent;
        private int mMinLineWidth;
        private float mMinLineWidthPercent;
        private int mOutAnimationDuration;
        private int mProgressMode;
        private float mProgressPercent;
        private boolean mReverse;
        private float mSecondaryProgressPercent;
        private int[] mStrokeColors;
        private int mStrokeSecondaryColor;
        private int mStrokeSize;
        private int mTransformDuration;
        private Interpolator mTransformInterpolator;
        private int mTravelDuration;
        private int mVerticalAlign;

        public Builder() {
            this.mProgressPercent = 0.0f;
            this.mSecondaryProgressPercent = 0.0f;
            this.mStrokeSize = 8;
            this.mVerticalAlign = 2;
            this.mReverse = false;
            this.mTravelDuration = 1000;
            this.mTransformDuration = 800;
            this.mKeepDuration = 200;
            this.mProgressMode = 1;
            this.mInAnimationDuration = HttpStatus.SC_BAD_REQUEST;
            this.mOutAnimationDuration = HttpStatus.SC_BAD_REQUEST;
        }

        public Builder(Context context, int i) {
            this(context, null, 0, i);
        }

        public Builder(Context context, AttributeSet attributeSet, int i, int i2) {
            this.mProgressPercent = 0.0f;
            this.mSecondaryProgressPercent = 0.0f;
            this.mStrokeSize = 8;
            this.mVerticalAlign = 2;
            this.mReverse = false;
            this.mTravelDuration = 1000;
            this.mTransformDuration = 800;
            this.mKeepDuration = 200;
            this.mProgressMode = 1;
            this.mInAnimationDuration = HttpStatus.SC_BAD_REQUEST;
            this.mOutAnimationDuration = HttpStatus.SC_BAD_REQUEST;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearProgressDrawable, i, i2);
            progressPercent(typedArrayObtainStyledAttributes.getFloat(R.styleable.LinearProgressDrawable_pv_progress, 0.0f));
            secondaryProgressPercent(typedArrayObtainStyledAttributes.getFloat(R.styleable.LinearProgressDrawable_pv_secondaryProgress, 0.0f));
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R.styleable.LinearProgressDrawable_lpd_maxLineWidth);
            if (typedValuePeekValue == null) {
                maxLineWidth(0.75f);
            } else if (typedValuePeekValue.type == 6) {
                maxLineWidth(typedArrayObtainStyledAttributes.getFraction(R.styleable.LinearProgressDrawable_lpd_maxLineWidth, 1, 1, 0.75f));
            } else {
                maxLineWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearProgressDrawable_lpd_maxLineWidth, 0));
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(R.styleable.LinearProgressDrawable_lpd_minLineWidth);
            if (typedValuePeekValue2 == null) {
                minLineWidth(0.25f);
            } else if (typedValuePeekValue2.type == 6) {
                minLineWidth(typedArrayObtainStyledAttributes.getFraction(R.styleable.LinearProgressDrawable_lpd_minLineWidth, 1, 1, 0.25f));
            } else {
                minLineWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearProgressDrawable_lpd_minLineWidth, 0));
            }
            strokeSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearProgressDrawable_lpd_strokeSize, ThemeUtil.dpToPx(context, 4)));
            verticalAlign(typedArrayObtainStyledAttributes.getInteger(R.styleable.LinearProgressDrawable_lpd_verticalAlign, 2));
            strokeColors(typedArrayObtainStyledAttributes.getColor(R.styleable.LinearProgressDrawable_lpd_strokeColor, ThemeUtil.colorPrimary(context, ViewCompat.MEASURED_STATE_MASK)));
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LinearProgressDrawable_lpd_strokeColors, 0);
            if (resourceId != 0) {
                TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(resourceId);
                int[] iArr = new int[typedArrayObtainTypedArray.length()];
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    iArr[i3] = typedArrayObtainTypedArray.getColor(i3, 0);
                }
                typedArrayObtainTypedArray.recycle();
                strokeColors(iArr);
            }
            strokeSecondaryColor(typedArrayObtainStyledAttributes.getColor(R.styleable.LinearProgressDrawable_lpd_strokeSecondaryColor, 0));
            reverse(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LinearProgressDrawable_lpd_reverse, false));
            travelDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.LinearProgressDrawable_lpd_travelDuration, context.getResources().getInteger(android.R.integer.config_longAnimTime)));
            transformDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.LinearProgressDrawable_lpd_transformDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            keepDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.LinearProgressDrawable_lpd_keepDuration, context.getResources().getInteger(android.R.integer.config_shortAnimTime)));
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LinearProgressDrawable_lpd_transformInterpolator, 0);
            if (resourceId2 != 0) {
                transformInterpolator(AnimationUtils.loadInterpolator(context, resourceId2));
            }
            progressMode(typedArrayObtainStyledAttributes.getInteger(R.styleable.LinearProgressDrawable_pv_progressMode, 1));
            inAnimDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.LinearProgressDrawable_lpd_inAnimDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            outAnimDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.LinearProgressDrawable_lpd_outAnimDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            typedArrayObtainStyledAttributes.recycle();
        }

        public LinearProgressDrawable build() {
            if (this.mStrokeColors == null) {
                this.mStrokeColors = new int[]{-16737793};
            }
            if (this.mTransformInterpolator == null) {
                this.mTransformInterpolator = new DecelerateInterpolator();
            }
            return new LinearProgressDrawable(this.mProgressPercent, this.mSecondaryProgressPercent, this.mMaxLineWidth, this.mMaxLineWidthPercent, this.mMinLineWidth, this.mMinLineWidthPercent, this.mStrokeSize, this.mVerticalAlign, this.mStrokeColors, this.mStrokeSecondaryColor, this.mReverse, this.mTravelDuration, this.mTransformDuration, this.mKeepDuration, this.mTransformInterpolator, this.mProgressMode, this.mInAnimationDuration, this.mOutAnimationDuration);
        }

        public Builder secondaryProgressPercent(float f) {
            this.mSecondaryProgressPercent = f;
            return this;
        }

        public Builder progressPercent(float f) {
            this.mProgressPercent = f;
            return this;
        }

        public Builder maxLineWidth(int i) {
            this.mMaxLineWidth = i;
            return this;
        }

        public Builder maxLineWidth(float f) {
            this.mMaxLineWidthPercent = Math.max(0.0f, Math.min(1.0f, f));
            this.mMaxLineWidth = 0;
            return this;
        }

        public Builder minLineWidth(int i) {
            this.mMinLineWidth = i;
            return this;
        }

        public Builder minLineWidth(float f) {
            this.mMinLineWidthPercent = Math.max(0.0f, Math.min(1.0f, f));
            this.mMinLineWidth = 0;
            return this;
        }

        public Builder strokeSize(int i) {
            this.mStrokeSize = i;
            return this;
        }

        public Builder verticalAlign(int i) {
            this.mVerticalAlign = i;
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

        public Builder travelDuration(int i) {
            this.mTravelDuration = i;
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

        public Builder outAnimDuration(int i) {
            this.mOutAnimationDuration = i;
            return this;
        }
    }
}
