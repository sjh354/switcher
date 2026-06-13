package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.mEntryLabelsPaint = paint3;
        paint3.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint4 = new Paint(1);
        this.mValueLinePaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != chartWidth || bitmapCreateBitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mDrawBitmap = new WeakReference<>(bitmapCreateBitmap);
            this.mBitmapCanvas = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float fCos = mPPointF.x + (((float) Math.cos(d)) * f);
        float fSin = mPPointF.y + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        return (float) (((double) (f - ((float) ((Math.sqrt(Math.pow(fCos - f3, 2.0d) + Math.pow(fSin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f2)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((mPPointF.x + (((float) Math.cos(d2)) * f)) - ((fCos + f3) / 2.0f), 2.0d) + Math.pow((mPPointF.y + (((float) Math.sin(d2)) * f)) - ((fSin + f4) / 2.0f), 2.0d)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    protected void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        float[] fArr;
        float f3;
        float f4;
        int i4;
        RectF rectF;
        RectF rectF2;
        MPPointF mPPointF;
        float f5;
        MPPointF mPPointF2;
        int i5;
        float fMax;
        MPPointF mPPointF3;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = this.mChart.getRotationAngle();
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        RectF circleBox = this.mChart.getCircleBox();
        int entryCount = iPieDataSet.getEntryCount();
        float[] drawAngles = this.mChart.getDrawAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF3 = new RectF();
        boolean z2 = z && this.mChart.isDrawRoundedSlicesEnabled();
        int i6 = 0;
        for (int i7 = 0; i7 < entryCount; i7++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i7).getY()) > Utils.FLOAT_EPSILON) {
                i6++;
            }
        }
        float sliceSpace = i6 <= 1 ? 0.0f : getSliceSpace(iPieDataSet2);
        int i8 = 0;
        float f6 = 0.0f;
        while (i8 < entryCount) {
            float f7 = drawAngles[i8];
            if (Math.abs(iPieDataSet2.getEntryForIndex(i8).getY()) > Utils.FLOAT_EPSILON && (!this.mChart.needsHighlight(i8) || z2)) {
                boolean z3 = sliceSpace > 0.0f && f7 <= 180.0f;
                i = entryCount;
                this.mRenderPaint.setColor(iPieDataSet2.getColor(i8));
                float f8 = i6 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f9 = rotationAngle + ((f6 + (f8 / 2.0f)) * phaseY);
                float f10 = (f7 - f8) * phaseY;
                float f11 = f10 < 0.0f ? 0.0f : f10;
                this.mPathBuffer.reset();
                if (z2) {
                    float f12 = radius - holeRadius2;
                    i2 = i8;
                    i3 = i6;
                    double d = f9 * 0.017453292f;
                    f = rotationAngle;
                    f2 = phaseX;
                    float fCos = centerCircleBox.x + (((float) Math.cos(d)) * f12);
                    float fSin = centerCircleBox.y + (f12 * ((float) Math.sin(d)));
                    rectF3.set(fCos - holeRadius2, fSin - holeRadius2, fCos + holeRadius2, fSin + holeRadius2);
                } else {
                    i2 = i8;
                    i3 = i6;
                    f = rotationAngle;
                    f2 = phaseX;
                }
                double d2 = f9 * 0.017453292f;
                float f13 = holeRadius;
                float fCos2 = centerCircleBox.x + (((float) Math.cos(d2)) * radius);
                float fSin2 = centerCircleBox.y + (((float) Math.sin(d2)) * radius);
                if (f11 >= 360.0f && f11 % 360.0f <= Utils.FLOAT_EPSILON) {
                    fArr = drawAngles;
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Path.Direction.CW);
                } else {
                    fArr = drawAngles;
                    if (z2) {
                        this.mPathBuffer.arcTo(rectF3, f9 + 180.0f, -180.0f);
                    }
                    this.mPathBuffer.arcTo(circleBox, f9, f11);
                }
                RectF rectF4 = rectF3;
                this.mInnerRectBuffer.set(centerCircleBox.x - f13, centerCircleBox.y - f13, centerCircleBox.x + f13, centerCircleBox.y + f13);
                if (!z) {
                    f3 = radius;
                    f4 = f13;
                    i4 = i3;
                    rectF = rectF4;
                    rectF2 = circleBox;
                    mPPointF = centerCircleBox;
                    f5 = 360.0f;
                } else if (f13 > 0.0f || z3) {
                    if (z3) {
                        i4 = i3;
                        rectF2 = circleBox;
                        f4 = f13;
                        i5 = 1;
                        f3 = radius;
                        mPPointF2 = centerCircleBox;
                        float fCalculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f7 * phaseY, fCos2, fSin2, f9, f11);
                        if (fCalculateMinimumRadiusForSpacedSlice < 0.0f) {
                            fCalculateMinimumRadiusForSpacedSlice = -fCalculateMinimumRadiusForSpacedSlice;
                        }
                        fMax = Math.max(f4, fCalculateMinimumRadiusForSpacedSlice);
                    } else {
                        f3 = radius;
                        mPPointF2 = centerCircleBox;
                        f4 = f13;
                        i4 = i3;
                        rectF2 = circleBox;
                        i5 = 1;
                        fMax = f4;
                    }
                    float f14 = (i4 == i5 || fMax == 0.0f) ? 0.0f : sliceSpace / (fMax * 0.017453292f);
                    float f15 = f + ((f6 + (f14 / 2.0f)) * phaseY);
                    float f16 = (f7 - f14) * phaseY;
                    if (f16 < 0.0f) {
                        f16 = 0.0f;
                    }
                    float f17 = f15 + f16;
                    if (f11 >= 360.0f && f11 % 360.0f <= Utils.FLOAT_EPSILON) {
                        this.mPathBuffer.addCircle(mPPointF2.x, mPPointF2.y, fMax, Path.Direction.CCW);
                        mPPointF3 = mPPointF2;
                        rectF = rectF4;
                    } else {
                        if (z2) {
                            float f18 = f3 - holeRadius2;
                            double d3 = 0.017453292f * f17;
                            mPPointF3 = mPPointF2;
                            float fCos3 = mPPointF2.x + (((float) Math.cos(d3)) * f18);
                            float fSin3 = mPPointF3.y + (f18 * ((float) Math.sin(d3)));
                            rectF = rectF4;
                            rectF.set(fCos3 - holeRadius2, fSin3 - holeRadius2, fCos3 + holeRadius2, fSin3 + holeRadius2);
                            this.mPathBuffer.arcTo(rectF, f17, 180.0f);
                        } else {
                            mPPointF3 = mPPointF2;
                            rectF = rectF4;
                            double d4 = f17 * 0.017453292f;
                            this.mPathBuffer.lineTo(mPPointF3.x + (((float) Math.cos(d4)) * fMax), mPPointF3.y + (fMax * ((float) Math.sin(d4))));
                        }
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f17, -f16);
                    }
                    mPPointF = mPPointF3;
                    this.mPathBuffer.close();
                    this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                    f6 += f7 * f2;
                } else {
                    f3 = radius;
                    f4 = f13;
                    i4 = i3;
                    rectF = rectF4;
                    f5 = 360.0f;
                    rectF2 = circleBox;
                    mPPointF = centerCircleBox;
                }
                if (f11 % f5 > Utils.FLOAT_EPSILON) {
                    if (z3) {
                        float fCalculateMinimumRadiusForSpacedSlice2 = calculateMinimumRadiusForSpacedSlice(mPPointF, f3, f7 * phaseY, fCos2, fSin2, f9, f11);
                        double d5 = 0.017453292f * (f9 + (f11 / 2.0f));
                        this.mPathBuffer.lineTo(mPPointF.x + (((float) Math.cos(d5)) * fCalculateMinimumRadiusForSpacedSlice2), mPPointF.y + (fCalculateMinimumRadiusForSpacedSlice2 * ((float) Math.sin(d5))));
                    } else {
                        this.mPathBuffer.lineTo(mPPointF.x, mPPointF.y);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
                f6 += f7 * f2;
            } else {
                f6 += f7 * phaseX;
                i2 = i8;
                f3 = radius;
                f = rotationAngle;
                f2 = phaseX;
                rectF2 = circleBox;
                i = entryCount;
                fArr = drawAngles;
                i4 = i6;
                rectF = rectF3;
                f4 = holeRadius;
                mPPointF = centerCircleBox;
            }
            i8 = i2 + 1;
            iPieDataSet2 = iPieDataSet;
            holeRadius = f4;
            rectF3 = rectF;
            centerCircleBox = mPPointF;
            i6 = i4;
            radius = f3;
            entryCount = i;
            circleBox = rectF2;
            rotationAngle = f;
            phaseX = f2;
            drawAngles = fArr;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03ce  */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawValues(android.graphics.Canvas r53) {
        /*
            Method dump skipped, instruction units count: 1069
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.drawValues(android.graphics.Canvas):void");
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    protected void drawHole(Canvas canvas) {
        if (!this.mChart.isDrawHoleEnabled() || this.mBitmapCanvas == null) {
            return;
        }
        float radius = this.mChart.getRadius();
        float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) > 0) {
            this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawCenterText(Canvas canvas) {
        float radius;
        MPPointF mPPointF;
        CharSequence centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
        float f = centerCircleBox.x + centerTextOffset.x;
        float f2 = centerCircleBox.y + centerTextOffset.y;
        if (this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled()) {
            radius = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        } else {
            radius = this.mChart.getRadius();
        }
        RectF rectF = this.mRectBuffer[0];
        rectF.left = f - radius;
        rectF.top = f2 - radius;
        rectF.right = f + radius;
        rectF.bottom = f2 + radius;
        RectF rectF2 = this.mRectBuffer[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (centerText.equals(this.mCenterTextLastValue) && rectF2.equals(this.mCenterTextLastBounds)) {
            mPPointF = centerTextOffset;
        } else {
            this.mCenterTextLastBounds.set(rectF2);
            this.mCenterTextLastValue = centerText;
            mPPointF = centerTextOffset;
            this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        if (Build.VERSION.SDK_INT >= 18) {
            Path path = this.mDrawCenterTextPathBuffer;
            path.reset();
            path.addOval(rectF, Path.Direction.CW);
            canvas.clipPath(path);
        }
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox);
        MPPointF.recycleInstance(mPPointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        int i;
        RectF rectF;
        float f;
        float[] fArr;
        boolean z;
        float f2;
        float f3;
        MPPointF mPPointF;
        IPieDataSet dataSetByIndex;
        float f4;
        int i2;
        float[] fArr2;
        float f5;
        int i3;
        float fCalculateMinimumRadiusForSpacedSlice;
        float fMax;
        Highlight[] highlightArr2 = highlightArr;
        boolean z2 = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (z2 && this.mChart.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float holeRadius = z2 ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 0;
        while (i4 < highlightArr2.length) {
            int x = (int) highlightArr2[i4].getX();
            if (x < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i4].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i5 = 0;
                for (int i6 = 0; i6 < entryCount; i6++) {
                    if (Math.abs(dataSetByIndex.getEntryForIndex(i6).getY()) > Utils.FLOAT_EPSILON) {
                        i5++;
                    }
                }
                if (x == 0) {
                    i2 = 1;
                    f4 = 0.0f;
                } else {
                    f4 = absoluteAngles[x - 1] * phaseX;
                    i2 = 1;
                }
                float sliceSpace = i5 <= i2 ? 0.0f : dataSetByIndex.getSliceSpace();
                float f6 = drawAngles[x];
                float selectionShift = dataSetByIndex.getSelectionShift();
                int i7 = i4;
                float f7 = radius + selectionShift;
                float f8 = holeRadius;
                rectF2.set(this.mChart.getCircleBox());
                float f9 = -selectionShift;
                rectF2.inset(f9, f9);
                boolean z3 = sliceSpace > 0.0f && f6 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x));
                float f10 = i5 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f11 = i5 == 1 ? 0.0f : sliceSpace / (f7 * 0.017453292f);
                float f12 = rotationAngle + (((f10 / 2.0f) + f4) * phaseY);
                float f13 = (f6 - f10) * phaseY;
                float f14 = f13 < 0.0f ? 0.0f : f13;
                float f15 = (((f11 / 2.0f) + f4) * phaseY) + rotationAngle;
                float f16 = (f6 - f11) * phaseY;
                if (f16 < 0.0f) {
                    f16 = 0.0f;
                }
                this.mPathBuffer.reset();
                if (f14 >= 360.0f && f14 % 360.0f <= Utils.FLOAT_EPSILON) {
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f7, Path.Direction.CW);
                    fArr2 = drawAngles;
                    f5 = f4;
                    i3 = i5;
                    z = z2;
                } else {
                    fArr2 = drawAngles;
                    f5 = f4;
                    double d = f15 * 0.017453292f;
                    i3 = i5;
                    z = z2;
                    this.mPathBuffer.moveTo(centerCircleBox.x + (((float) Math.cos(d)) * f7), centerCircleBox.y + (f7 * ((float) Math.sin(d))));
                    this.mPathBuffer.arcTo(rectF2, f15, f16);
                }
                if (z3) {
                    double d2 = f12 * 0.017453292f;
                    i = i7;
                    rectF = rectF2;
                    f = f8;
                    mPPointF = centerCircleBox;
                    fArr = fArr2;
                    fCalculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f6 * phaseY, (((float) Math.cos(d2)) * radius) + centerCircleBox.x, centerCircleBox.y + (((float) Math.sin(d2)) * radius), f12, f14);
                } else {
                    rectF = rectF2;
                    mPPointF = centerCircleBox;
                    i = i7;
                    f = f8;
                    fArr = fArr2;
                    fCalculateMinimumRadiusForSpacedSlice = 0.0f;
                }
                this.mInnerRectBuffer.set(mPPointF.x - f, mPPointF.y - f, mPPointF.x + f, mPPointF.y + f);
                if (!z || (f <= 0.0f && !z3)) {
                    f2 = phaseX;
                    f3 = phaseY;
                    if (f14 % 360.0f > Utils.FLOAT_EPSILON) {
                        if (z3) {
                            double d3 = (f12 + (f14 / 2.0f)) * 0.017453292f;
                            this.mPathBuffer.lineTo(mPPointF.x + (((float) Math.cos(d3)) * fCalculateMinimumRadiusForSpacedSlice), mPPointF.y + (fCalculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d3))));
                        } else {
                            this.mPathBuffer.lineTo(mPPointF.x, mPPointF.y);
                        }
                    }
                } else {
                    if (z3) {
                        if (fCalculateMinimumRadiusForSpacedSlice < 0.0f) {
                            fCalculateMinimumRadiusForSpacedSlice = -fCalculateMinimumRadiusForSpacedSlice;
                        }
                        fMax = Math.max(f, fCalculateMinimumRadiusForSpacedSlice);
                    } else {
                        fMax = f;
                    }
                    float f17 = (i3 == 1 || fMax == 0.0f) ? 0.0f : sliceSpace / (fMax * 0.017453292f);
                    float f18 = ((f5 + (f17 / 2.0f)) * phaseY) + rotationAngle;
                    float f19 = (f6 - f17) * phaseY;
                    if (f19 < 0.0f) {
                        f19 = 0.0f;
                    }
                    float f20 = f18 + f19;
                    if (f14 >= 360.0f && f14 % 360.0f <= Utils.FLOAT_EPSILON) {
                        this.mPathBuffer.addCircle(mPPointF.x, mPPointF.y, fMax, Path.Direction.CCW);
                        f2 = phaseX;
                        f3 = phaseY;
                    } else {
                        double d4 = f20 * 0.017453292f;
                        f2 = phaseX;
                        f3 = phaseY;
                        this.mPathBuffer.lineTo(mPPointF.x + (((float) Math.cos(d4)) * fMax), mPPointF.y + (fMax * ((float) Math.sin(d4))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f20, -f19);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                i = i4;
                rectF = rectF2;
                f = holeRadius;
                fArr = drawAngles;
                z = z2;
                f2 = phaseX;
                f3 = phaseY;
                mPPointF = centerCircleBox;
            }
            i4 = i + 1;
            phaseX = f2;
            rectF2 = rectF;
            holeRadius = f;
            centerCircleBox = mPPointF;
            phaseY = f3;
            drawAngles = fArr;
            z2 = z;
            highlightArr2 = highlightArr;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawRoundedSlices(Canvas canvas) {
        float f;
        float[] fArr;
        float f2;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < dataSet.getEntryCount()) {
                    float f3 = drawAngles[i];
                    if (Math.abs(dataSet.getEntryForIndex(i).getY()) > Utils.FLOAT_EPSILON) {
                        double d = radius - holeRadius;
                        double d2 = (rotationAngle + f3) * phaseY;
                        f = phaseY;
                        fArr = drawAngles;
                        f2 = rotationAngle;
                        float fCos = (float) (((double) centerCircleBox.x) + (Math.cos(Math.toRadians(d2)) * d));
                        float fSin = (float) ((d * Math.sin(Math.toRadians(d2))) + ((double) centerCircleBox.y));
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle(fCos, fSin, holeRadius, this.mRenderPaint);
                    } else {
                        f = phaseY;
                        fArr = drawAngles;
                        f2 = rotationAngle;
                    }
                    rotationAngle = f2 + (f3 * phaseX);
                    i++;
                    phaseY = f;
                    drawAngles = fArr;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
