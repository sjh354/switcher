package kr.switcher.switcherm.common.util.progress;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes2.dex */
public class CircleAngleAnimation extends Animation {
    private Circle circle;
    private float newAngle;
    private float oldAngle;

    public CircleAngleAnimation(Circle circle, int i) {
        this.oldAngle = circle.getAngle();
        this.newAngle = i;
        this.circle = circle;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.oldAngle;
        this.circle.setAngle(f2 + ((this.newAngle - f2) * f));
        this.circle.requestLayout();
    }
}
