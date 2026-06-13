package com.github.lzyzsd.circleprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class DonutProgress extends View {
    private static final String INSTANCE_BACKGROUND_COLOR = "inner_background_color";
    private static final String INSTANCE_FINISHED_STROKE_COLOR = "finished_stroke_color";
    private static final String INSTANCE_FINISHED_STROKE_WIDTH = "finished_stroke_width";
    private static final String INSTANCE_INNER_BOTTOM_TEXT = "inner_bottom_text";
    private static final String INSTANCE_INNER_BOTTOM_TEXT_COLOR = "inner_bottom_text_color";
    private static final String INSTANCE_INNER_BOTTOM_TEXT_SIZE = "inner_bottom_text_size";
    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PREFIX = "prefix";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_UNFINISHED_STROKE_COLOR = "unfinished_stroke_color";
    private static final String INSTANCE_UNFINISHED_STROKE_WIDTH = "unfinished_stroke_width";
    private final int default_finished_color;
    private final int default_inner_background_color;
    private final int default_inner_bottom_text_color;
    private final float default_inner_bottom_text_size;
    private final int default_max;
    private final float default_stroke_width;
    private final int default_text_color;
    private final float default_text_size;
    private final int default_unfinished_color;
    private RectF finishedOuterRect;
    private Paint finishedPaint;
    private int finishedStrokeColor;
    private float finishedStrokeWidth;
    private int innerBackgroundColor;
    private String innerBottomText;
    private int innerBottomTextColor;
    private float innerBottomTextHeight;
    protected Paint innerBottomTextPaint;
    private float innerBottomTextSize;
    private Paint innerCirclePaint;
    private int max;
    private final int min_size;
    private String prefixText;
    private int progress;
    private String suffixText;
    private int textColor;
    protected Paint textPaint;
    private float textSize;
    private RectF unfinishedOuterRect;
    private Paint unfinishedPaint;
    private int unfinishedStrokeColor;
    private float unfinishedStrokeWidth;

    public DonutProgress(Context context) {
        this(context, null);
    }

    public DonutProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DonutProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.finishedOuterRect = new RectF();
        this.unfinishedOuterRect = new RectF();
        this.progress = 0;
        this.prefixText = "";
        this.suffixText = "%";
        this.default_finished_color = Color.rgb(66, 145, 241);
        this.default_unfinished_color = Color.rgb(204, 204, 204);
        this.default_text_color = Color.rgb(66, 145, 241);
        this.default_inner_bottom_text_color = Color.rgb(66, 145, 241);
        this.default_inner_background_color = 0;
        this.default_max = 100;
        this.default_text_size = Utils.sp2px(getResources(), 18.0f);
        this.min_size = (int) Utils.dp2px(getResources(), 100.0f);
        this.default_stroke_width = Utils.dp2px(getResources(), 10.0f);
        this.default_inner_bottom_text_size = Utils.sp2px(getResources(), 18.0f);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DonutProgress, i, 0);
        initByAttributes(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        initPainters();
    }

    protected void initPainters() {
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
        this.textPaint.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.innerBottomTextPaint = textPaint2;
        textPaint2.setColor(this.innerBottomTextColor);
        this.innerBottomTextPaint.setTextSize(this.innerBottomTextSize);
        this.innerBottomTextPaint.setAntiAlias(true);
        Paint paint = new Paint();
        this.finishedPaint = paint;
        paint.setColor(this.finishedStrokeColor);
        this.finishedPaint.setStyle(Paint.Style.STROKE);
        this.finishedPaint.setAntiAlias(true);
        this.finishedPaint.setStrokeWidth(this.finishedStrokeWidth);
        Paint paint2 = new Paint();
        this.unfinishedPaint = paint2;
        paint2.setColor(this.unfinishedStrokeColor);
        this.unfinishedPaint.setStyle(Paint.Style.STROKE);
        this.unfinishedPaint.setAntiAlias(true);
        this.unfinishedPaint.setStrokeWidth(this.unfinishedStrokeWidth);
        Paint paint3 = new Paint();
        this.innerCirclePaint = paint3;
        paint3.setColor(this.innerBackgroundColor);
        this.innerCirclePaint.setAntiAlias(true);
    }

    protected void initByAttributes(TypedArray typedArray) {
        this.finishedStrokeColor = typedArray.getColor(R.styleable.DonutProgress_donut_finished_color, this.default_finished_color);
        this.unfinishedStrokeColor = typedArray.getColor(R.styleable.DonutProgress_donut_unfinished_color, this.default_unfinished_color);
        this.textColor = typedArray.getColor(R.styleable.DonutProgress_donut_text_color, this.default_text_color);
        this.textSize = typedArray.getDimension(R.styleable.DonutProgress_donut_text_size, this.default_text_size);
        setMax(typedArray.getInt(R.styleable.DonutProgress_donut_max, 100));
        setProgress(typedArray.getInt(R.styleable.DonutProgress_donut_progress, 0));
        this.finishedStrokeWidth = typedArray.getDimension(R.styleable.DonutProgress_donut_finished_stroke_width, this.default_stroke_width);
        this.unfinishedStrokeWidth = typedArray.getDimension(R.styleable.DonutProgress_donut_unfinished_stroke_width, this.default_stroke_width);
        if (typedArray.getString(R.styleable.DonutProgress_donut_prefix_text) != null) {
            this.prefixText = typedArray.getString(R.styleable.DonutProgress_donut_prefix_text);
        }
        if (typedArray.getString(R.styleable.DonutProgress_donut_suffix_text) != null) {
            this.suffixText = typedArray.getString(R.styleable.DonutProgress_donut_suffix_text);
        }
        this.innerBackgroundColor = typedArray.getColor(R.styleable.DonutProgress_donut_background_color, 0);
        this.innerBottomTextSize = typedArray.getDimension(R.styleable.DonutProgress_donut_inner_bottom_text_size, this.default_inner_bottom_text_size);
        this.innerBottomTextColor = typedArray.getColor(R.styleable.DonutProgress_donut_inner_bottom_text_color, this.default_inner_bottom_text_color);
        this.innerBottomText = typedArray.getString(R.styleable.DonutProgress_donut_inner_bottom_text);
    }

    @Override // android.view.View
    public void invalidate() {
        initPainters();
        super.invalidate();
    }

    public float getFinishedStrokeWidth() {
        return this.finishedStrokeWidth;
    }

    public void setFinishedStrokeWidth(float f) {
        this.finishedStrokeWidth = f;
        invalidate();
    }

    public float getUnfinishedStrokeWidth() {
        return this.unfinishedStrokeWidth;
    }

    public void setUnfinishedStrokeWidth(float f) {
        this.unfinishedStrokeWidth = f;
        invalidate();
    }

    private float getProgressAngle() {
        return (getProgress() / this.max) * 360.0f;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
        if (i > getMax()) {
            this.progress %= getMax();
        }
        invalidate();
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.max = i;
            invalidate();
        }
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
        invalidate();
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
        invalidate();
    }

    public int getFinishedStrokeColor() {
        return this.finishedStrokeColor;
    }

    public void setFinishedStrokeColor(int i) {
        this.finishedStrokeColor = i;
        invalidate();
    }

    public int getUnfinishedStrokeColor() {
        return this.unfinishedStrokeColor;
    }

    public void setUnfinishedStrokeColor(int i) {
        this.unfinishedStrokeColor = i;
        invalidate();
    }

    public String getSuffixText() {
        return this.suffixText;
    }

    public void setSuffixText(String str) {
        this.suffixText = str;
        invalidate();
    }

    public String getPrefixText() {
        return this.prefixText;
    }

    public void setPrefixText(String str) {
        this.prefixText = str;
        invalidate();
    }

    public int getInnerBackgroundColor() {
        return this.innerBackgroundColor;
    }

    public void setInnerBackgroundColor(int i) {
        this.innerBackgroundColor = i;
        invalidate();
    }

    public String getInnerBottomText() {
        return this.innerBottomText;
    }

    public void setInnerBottomText(String str) {
        this.innerBottomText = str;
        invalidate();
    }

    public float getInnerBottomTextSize() {
        return this.innerBottomTextSize;
    }

    public void setInnerBottomTextSize(float f) {
        this.innerBottomTextSize = f;
        invalidate();
    }

    public int getInnerBottomTextColor() {
        return this.innerBottomTextColor;
    }

    public void setInnerBottomTextColor(int i) {
        this.innerBottomTextColor = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measure(i), measure(i2));
        this.innerBottomTextHeight = getHeight() - ((getHeight() * 3) / 5);
    }

    private int measure(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.min_size;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fMax = Math.max(this.finishedStrokeWidth, this.unfinishedStrokeWidth);
        this.finishedOuterRect.set(fMax, fMax, getWidth() - fMax, getHeight() - fMax);
        this.unfinishedOuterRect.set(fMax, fMax, getWidth() - fMax, getHeight() - fMax);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - Math.min(this.finishedStrokeWidth, this.unfinishedStrokeWidth)) + Math.abs(this.finishedStrokeWidth - this.unfinishedStrokeWidth)) / 2.0f, this.innerCirclePaint);
        canvas.drawArc(this.finishedOuterRect, 0.0f, getProgressAngle(), false, this.finishedPaint);
        canvas.drawArc(this.unfinishedOuterRect, getProgressAngle(), 360.0f - getProgressAngle(), false, this.unfinishedPaint);
        String str = this.prefixText + this.progress + this.suffixText;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (getWidth() - this.textPaint.measureText(str)) / 2.0f, (getWidth() - (this.textPaint.descent() + this.textPaint.ascent())) / 2.0f, this.textPaint);
        }
        if (TextUtils.isEmpty(getInnerBottomText())) {
            return;
        }
        this.innerBottomTextPaint.setTextSize(this.innerBottomTextSize);
        canvas.drawText(getInnerBottomText(), (getWidth() - this.innerBottomTextPaint.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.innerBottomTextHeight) - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.innerBottomTextPaint);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putInt(INSTANCE_TEXT_COLOR, getTextColor());
        bundle.putFloat(INSTANCE_TEXT_SIZE, getTextSize());
        bundle.putFloat(INSTANCE_INNER_BOTTOM_TEXT_SIZE, getInnerBottomTextSize());
        bundle.putFloat(INSTANCE_INNER_BOTTOM_TEXT_COLOR, getInnerBottomTextColor());
        bundle.putString(INSTANCE_INNER_BOTTOM_TEXT, getInnerBottomText());
        bundle.putInt(INSTANCE_INNER_BOTTOM_TEXT_COLOR, getInnerBottomTextColor());
        bundle.putInt(INSTANCE_FINISHED_STROKE_COLOR, getFinishedStrokeColor());
        bundle.putInt(INSTANCE_UNFINISHED_STROKE_COLOR, getUnfinishedStrokeColor());
        bundle.putInt(INSTANCE_MAX, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString(INSTANCE_SUFFIX, getSuffixText());
        bundle.putString(INSTANCE_PREFIX, getPrefixText());
        bundle.putFloat(INSTANCE_FINISHED_STROKE_WIDTH, getFinishedStrokeWidth());
        bundle.putFloat(INSTANCE_UNFINISHED_STROKE_WIDTH, getUnfinishedStrokeWidth());
        bundle.putInt(INSTANCE_BACKGROUND_COLOR, getInnerBackgroundColor());
        return bundle;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.textColor = bundle.getInt(INSTANCE_TEXT_COLOR);
            this.textSize = bundle.getFloat(INSTANCE_TEXT_SIZE);
            this.innerBottomTextSize = bundle.getFloat(INSTANCE_INNER_BOTTOM_TEXT_SIZE);
            this.innerBottomText = bundle.getString(INSTANCE_INNER_BOTTOM_TEXT);
            this.innerBottomTextColor = bundle.getInt(INSTANCE_INNER_BOTTOM_TEXT_COLOR);
            this.finishedStrokeColor = bundle.getInt(INSTANCE_FINISHED_STROKE_COLOR);
            this.unfinishedStrokeColor = bundle.getInt(INSTANCE_UNFINISHED_STROKE_COLOR);
            this.finishedStrokeWidth = bundle.getFloat(INSTANCE_FINISHED_STROKE_WIDTH);
            this.unfinishedStrokeWidth = bundle.getFloat(INSTANCE_UNFINISHED_STROKE_WIDTH);
            this.innerBackgroundColor = bundle.getInt(INSTANCE_BACKGROUND_COLOR);
            initPainters();
            setMax(bundle.getInt(INSTANCE_MAX));
            setProgress(bundle.getInt("progress"));
            this.prefixText = bundle.getString(INSTANCE_PREFIX);
            this.suffixText = bundle.getString(INSTANCE_SUFFIX);
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
