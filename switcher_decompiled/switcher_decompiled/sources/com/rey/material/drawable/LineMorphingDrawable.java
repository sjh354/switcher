package com.rey.material.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.text.TextUtilsCompat;
import com.rey.material.R;
import com.rey.material.util.ThemeUtil;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LineMorphingDrawable extends Drawable implements Animatable {
    private int mAnimDuration;
    private float mAnimProgress;
    private boolean mClockwise;
    private int mCurState;
    private RectF mDrawBound;
    private int mHeight;
    private Interpolator mInterpolator;
    private boolean mIsRtl;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Paint mPaint;
    private Path mPath;
    private int mPrevState;
    private boolean mRunning;
    private long mStartTime;
    private State[] mStates;
    private Paint.Cap mStrokeCap;
    private int mStrokeColor;
    private Paint.Join mStrokeJoin;
    private int mStrokeSize;
    private final Runnable mUpdater;
    private int mWidth;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private LineMorphingDrawable(State[] stateArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Interpolator interpolator, int i9, int i10, Paint.Cap cap, Paint.Join join, boolean z, boolean z2) {
        this.mRunning = false;
        this.mPaddingLeft = 12;
        this.mPaddingTop = 12;
        this.mPaddingRight = 12;
        this.mPaddingBottom = 12;
        this.mUpdater = new Runnable() { // from class: com.rey.material.drawable.LineMorphingDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                LineMorphingDrawable.this.update();
            }
        };
        this.mStates = stateArr;
        this.mWidth = i2;
        this.mHeight = i3;
        this.mPaddingLeft = i4;
        this.mPaddingTop = i5;
        this.mPaddingRight = i6;
        this.mPaddingBottom = i7;
        this.mAnimDuration = i8;
        this.mInterpolator = interpolator;
        this.mStrokeSize = i9;
        this.mStrokeColor = i10;
        this.mStrokeCap = cap;
        this.mStrokeJoin = join;
        this.mClockwise = z;
        this.mIsRtl = z2;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(this.mStrokeCap);
        this.mPaint.setStrokeJoin(this.mStrokeJoin);
        this.mPaint.setColor(this.mStrokeColor);
        this.mPaint.setStrokeWidth(this.mStrokeSize);
        this.mDrawBound = new RectF();
        this.mPath = new Path();
        switchLineState(i, false);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        float f = (this.mClockwise ? 180 : -180) * ((this.mPrevState < this.mCurState ? 0.0f : 1.0f) + this.mAnimProgress);
        if (this.mIsRtl) {
            canvas.scale(-1.0f, 1.0f, this.mDrawBound.centerX(), this.mDrawBound.centerY());
        }
        canvas.rotate(f, this.mDrawBound.centerX(), this.mDrawBound.centerY());
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mWidth > 0 && this.mHeight > 0) {
            this.mDrawBound.left = rect.left + ((rect.width() - this.mWidth) / 2.0f);
            this.mDrawBound.top = rect.top + ((rect.height() - this.mHeight) / 2.0f);
            RectF rectF = this.mDrawBound;
            rectF.right = rectF.left + this.mWidth;
            RectF rectF2 = this.mDrawBound;
            rectF2.bottom = rectF2.top + this.mHeight;
        } else {
            this.mDrawBound.left = rect.left + this.mPaddingLeft;
            this.mDrawBound.top = rect.top + this.mPaddingTop;
            this.mDrawBound.right = rect.right - this.mPaddingRight;
            this.mDrawBound.bottom = rect.bottom - this.mPaddingBottom;
        }
        updatePath();
    }

    public void switchLineState(int i, boolean z) {
        int i2 = this.mCurState;
        if (i2 == i) {
            if (z) {
                return;
            }
            this.mAnimProgress = 1.0f;
            updatePath();
            return;
        }
        this.mPrevState = i2;
        this.mCurState = i;
        if (z) {
            start();
        } else {
            this.mAnimProgress = 1.0f;
            updatePath();
        }
    }

    public boolean setLineState(int i, float f) {
        int i2 = this.mCurState;
        if (i2 != i) {
            this.mPrevState = i2;
            this.mCurState = i;
            this.mAnimProgress = f;
            updatePath();
            return true;
        }
        if (this.mAnimProgress == f) {
            return false;
        }
        this.mAnimProgress = f;
        updatePath();
        return true;
    }

    public int getLineState() {
        return this.mCurState;
    }

    public int getLineStateCount() {
        State[] stateArr = this.mStates;
        if (stateArr == null) {
            return 0;
        }
        return stateArr.length;
    }

    public float getAnimProgress() {
        return this.mAnimProgress;
    }

    private void updatePath() {
        this.mPath.reset();
        State[] stateArr = this.mStates;
        if (stateArr == null) {
            return;
        }
        if (this.mAnimProgress == 0.0f || (stateArr[this.mPrevState].links != null && this.mAnimProgress < 0.05f)) {
            updatePathWithState(this.mPath, this.mStates[this.mPrevState]);
        } else if (this.mAnimProgress == 1.0f || (this.mStates[this.mCurState].links != null && this.mAnimProgress > 0.95f)) {
            updatePathWithState(this.mPath, this.mStates[this.mCurState]);
        } else {
            Path path = this.mPath;
            State[] stateArr2 = this.mStates;
            updatePathBetweenStates(path, stateArr2[this.mPrevState], stateArr2[this.mCurState], this.mInterpolator.getInterpolation(this.mAnimProgress));
        }
        invalidateSelf();
    }

    private void updatePathWithState(Path path, State state) {
        boolean z;
        if (state.links != null) {
            for (int i = 0; i < state.links.length; i += 2) {
                int i2 = state.links[i] * 4;
                int i3 = state.links[i + 1] * 4;
                float x = getX(state.points[i2]);
                float y = getY(state.points[i2 + 1]);
                float x2 = getX(state.points[i2 + 2]);
                float y2 = getY(state.points[i2 + 3]);
                float x3 = getX(state.points[i3]);
                float y3 = getY(state.points[i3 + 1]);
                float x4 = getX(state.points[i3 + 2]);
                float y4 = getY(state.points[i3 + 3]);
                if (x == x3 && y == y3) {
                    path.moveTo(x2, y2);
                    path.lineTo(x, y);
                    path.lineTo(x4, y4);
                } else if (x == x4 && y == y4) {
                    path.moveTo(x2, y2);
                    path.lineTo(x, y);
                    path.lineTo(x3, y3);
                } else if (x2 == x3 && y2 == y3) {
                    path.moveTo(x, y);
                    path.lineTo(x2, y2);
                    path.lineTo(x4, y4);
                } else {
                    path.moveTo(x, y);
                    path.lineTo(x2, y2);
                    path.lineTo(x3, y3);
                }
            }
            int length = state.points.length / 4;
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = 0;
                while (true) {
                    if (i5 >= state.links.length) {
                        z = false;
                        break;
                    } else {
                        if (state.links[i5] == i4) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z) {
                    int i6 = i4 * 4;
                    path.moveTo(getX(state.points[i6]), getY(state.points[i6 + 1]));
                    path.lineTo(getX(state.points[i6 + 2]), getY(state.points[i6 + 3]));
                }
            }
            return;
        }
        int length2 = state.points.length / 4;
        for (int i7 = 0; i7 < length2; i7++) {
            int i8 = i7 * 4;
            path.moveTo(getX(state.points[i8]), getY(state.points[i8 + 1]));
            path.lineTo(getX(state.points[i8 + 2]), getY(state.points[i8 + 3]));
        }
    }

    private void updatePathBetweenStates(Path path, State state, State state2, float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        int iMax = Math.max(state.points.length, state2.points.length) / 4;
        for (int i = 0; i < iMax; i++) {
            int i2 = i * 4;
            float f9 = 0.5f;
            if (i2 >= state.points.length) {
                f2 = 0.5f;
                f3 = 0.5f;
                f4 = 0.5f;
                f5 = 0.5f;
            } else {
                f2 = state.points[i2];
                f3 = state.points[i2 + 1];
                f4 = state.points[i2 + 2];
                f5 = state.points[i2 + 3];
            }
            if (i2 >= state2.points.length) {
                f8 = 0.5f;
                f6 = 0.5f;
                f7 = 0.5f;
            } else {
                f9 = state2.points[i2];
                f6 = state2.points[i2 + 1];
                f7 = state2.points[i2 + 2];
                f8 = state2.points[i2 + 3];
            }
            this.mPath.moveTo(getX(f2 + ((f9 - f2) * f)), getY(f3 + ((f6 - f3) * f)));
            this.mPath.lineTo(getX(f4 + ((f7 - f4) * f)), getY(f5 + ((f8 - f5) * f)));
        }
    }

    private float getX(float f) {
        return this.mDrawBound.left + (this.mDrawBound.width() * f);
    }

    private float getY(float f) {
        return this.mDrawBound.top + (this.mDrawBound.height() * f);
    }

    private void resetAnimation() {
        this.mStartTime = SystemClock.uptimeMillis();
        this.mAnimProgress = 0.0f;
    }

    public void cancel() {
        stop();
        setLineState(this.mCurState, 1.0f);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        resetAnimation();
        scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.mRunning = false;
            unscheduleSelf(this.mUpdater);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        this.mRunning = true;
        super.scheduleSelf(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        float fMin = Math.min(1.0f, (SystemClock.uptimeMillis() - this.mStartTime) / this.mAnimDuration);
        if (fMin == 1.0f) {
            setLineState(this.mCurState, 1.0f);
            this.mRunning = false;
        } else {
            setLineState(this.mCurState, this.mInterpolator.getInterpolation(fMin));
        }
        if (isRunning()) {
            scheduleSelf(this.mUpdater, SystemClock.uptimeMillis() + 16);
        }
    }

    public static class State {
        int[] links;
        float[] points;

        public State() {
        }

        public State(float[] fArr, int[] iArr) {
            this.points = fArr;
            this.links = iArr;
        }
    }

    public static class Builder {
        private static final String TAG_ITEM = "item";
        private static final String TAG_LINKS = "links";
        private static final String TAG_POINTS = "points";
        private static final String TAG_STATE = "state";
        private static final String TAG_STATE_LIST = "state-list";
        private int mAnimDuration;
        private boolean mClockwise;
        private int mCurState;
        private int mHeight;
        private Interpolator mInterpolator;
        private boolean mIsRtl;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private State[] mStates;
        private Paint.Cap mStrokeCap;
        private int mStrokeColor;
        private Paint.Join mStrokeJoin;
        private int mStrokeSize;
        private int mWidth;

        public Builder() {
        }

        public Builder(Context context, int i) {
            this(context, null, 0, i);
        }

        public Builder(Context context, AttributeSet attributeSet, int i, int i2) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LineMorphingDrawable, i, i2);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LineMorphingDrawable_lmd_state, 0);
            if (resourceId != 0) {
                states(readStates(context, resourceId));
            }
            curState(typedArrayObtainStyledAttributes.getInteger(R.styleable.LineMorphingDrawable_lmd_curState, 0));
            width(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_width, 0));
            height(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_height, 0));
            padding(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_padding, 0));
            paddingLeft(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_paddingLeft, this.mPaddingLeft));
            paddingTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_paddingTop, this.mPaddingTop));
            paddingRight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_paddingRight, this.mPaddingRight));
            paddingBottom(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_paddingBottom, this.mPaddingBottom));
            animDuration(typedArrayObtainStyledAttributes.getInteger(R.styleable.LineMorphingDrawable_lmd_animDuration, context.getResources().getInteger(android.R.integer.config_mediumAnimTime)));
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LineMorphingDrawable_lmd_interpolator, 0);
            if (resourceId2 != 0) {
                interpolator(AnimationUtils.loadInterpolator(context, resourceId2));
            }
            strokeSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LineMorphingDrawable_lmd_strokeSize, ThemeUtil.dpToPx(context, 3)));
            strokeColor(typedArrayObtainStyledAttributes.getColor(R.styleable.LineMorphingDrawable_lmd_strokeColor, -1));
            int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.LineMorphingDrawable_lmd_strokeCap, 0);
            if (integer == 0) {
                strokeCap(Paint.Cap.BUTT);
            } else if (integer == 1) {
                strokeCap(Paint.Cap.ROUND);
            } else {
                strokeCap(Paint.Cap.SQUARE);
            }
            int integer2 = typedArrayObtainStyledAttributes.getInteger(R.styleable.LineMorphingDrawable_lmd_strokeJoin, 0);
            if (integer2 == 0) {
                strokeJoin(Paint.Join.MITER);
            } else if (integer2 == 1) {
                strokeJoin(Paint.Join.ROUND);
            } else {
                strokeJoin(Paint.Join.BEVEL);
            }
            clockwise(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LineMorphingDrawable_lmd_clockwise, true));
            int integer3 = typedArrayObtainStyledAttributes.getInteger(R.styleable.LineMorphingDrawable_lmd_layoutDirection, 0);
            if (integer3 == 3) {
                rtl(TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1);
            } else {
                rtl(integer3 == 1);
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:112:0x018a A[PHI: r2
          0x018a: PHI (r2v2 android.content.res.XmlResourceParser) = (r2v1 android.content.res.XmlResourceParser), (r2v4 android.content.res.XmlResourceParser) binds: [B:111:0x0188, B:101:0x0179] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0142  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private com.rey.material.drawable.LineMorphingDrawable.State[] readStates(android.content.Context r19, int r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 458
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rey.material.drawable.LineMorphingDrawable.Builder.readStates(android.content.Context, int):com.rey.material.drawable.LineMorphingDrawable$State[]");
        }

        public LineMorphingDrawable build() {
            if (this.mStrokeCap == null) {
                this.mStrokeCap = Paint.Cap.BUTT;
            }
            if (this.mStrokeJoin == null) {
                this.mStrokeJoin = Paint.Join.MITER;
            }
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateInterpolator();
            }
            return new LineMorphingDrawable(this.mStates, this.mCurState, this.mWidth, this.mHeight, this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom, this.mAnimDuration, this.mInterpolator, this.mStrokeSize, this.mStrokeColor, this.mStrokeCap, this.mStrokeJoin, this.mClockwise, this.mIsRtl);
        }

        public Builder states(State... stateArr) {
            this.mStates = stateArr;
            return this;
        }

        public Builder curState(int i) {
            this.mCurState = i;
            return this;
        }

        public Builder width(int i) {
            this.mWidth = i;
            return this;
        }

        public Builder height(int i) {
            this.mHeight = i;
            return this;
        }

        public Builder padding(int i) {
            this.mPaddingLeft = i;
            this.mPaddingTop = i;
            this.mPaddingRight = i;
            this.mPaddingBottom = i;
            return this;
        }

        public Builder paddingLeft(int i) {
            this.mPaddingLeft = i;
            return this;
        }

        public Builder paddingTop(int i) {
            this.mPaddingTop = i;
            return this;
        }

        public Builder paddingRight(int i) {
            this.mPaddingRight = i;
            return this;
        }

        public Builder paddingBottom(int i) {
            this.mPaddingBottom = i;
            return this;
        }

        public Builder animDuration(int i) {
            this.mAnimDuration = i;
            return this;
        }

        public Builder interpolator(Interpolator interpolator) {
            this.mInterpolator = interpolator;
            return this;
        }

        public Builder strokeSize(int i) {
            this.mStrokeSize = i;
            return this;
        }

        public Builder strokeColor(int i) {
            this.mStrokeColor = i;
            return this;
        }

        public Builder strokeCap(Paint.Cap cap) {
            this.mStrokeCap = cap;
            return this;
        }

        public Builder strokeJoin(Paint.Join join) {
            this.mStrokeJoin = join;
            return this;
        }

        public Builder clockwise(boolean z) {
            this.mClockwise = z;
            return this;
        }

        public Builder rtl(boolean z) {
            this.mIsRtl = z;
            return this;
        }
    }
}
