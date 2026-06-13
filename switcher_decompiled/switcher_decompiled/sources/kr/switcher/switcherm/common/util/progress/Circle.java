package kr.switcher.switcherm.common.util.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class Circle extends View {
    private static final int START_ANGLE_POINT = 90;
    private float angle;
    private final Paint paint;
    private final RectF rect;

    public Circle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int integer = context.getResources().getInteger(R.integer.circle_stroke_width);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(integer);
        paint.setColor(context.getResources().getColor(R.color.periwinkle));
        this.rect = new RectF(3.0f, 3.0f, 200.0f, 200.0f);
        this.angle = 0.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.rect, 90.0f, this.angle, false, this.paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
        float f = size - 3;
        this.rect.set(3.0f, 3.0f, f, f);
    }

    public float getAngle() {
        return this.angle;
    }

    public void setAngle(float f) {
        this.angle = f;
    }

    public void setColor(int i) {
        this.paint.setColor(i);
    }
}
