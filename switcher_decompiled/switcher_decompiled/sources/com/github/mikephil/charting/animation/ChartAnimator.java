package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.github.mikephil.charting.animation.Easing;

/* JADX INFO: loaded from: classes.dex */
public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    protected float mPhaseY = 1.0f;
    protected float mPhaseX = 1.0f;

    public ChartAnimator() {
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mListener = animatorUpdateListener;
    }

    private ObjectAnimator xAnimator(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(easingFunction);
        objectAnimatorOfFloat.setDuration(i);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator yAnimator(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(easingFunction);
        objectAnimatorOfFloat.setDuration(i);
        return objectAnimatorOfFloat;
    }

    public void animateX(int i) {
        animateX(i, Easing.Linear);
    }

    public void animateX(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorXAnimator = xAnimator(i, easingFunction);
        objectAnimatorXAnimator.addUpdateListener(this.mListener);
        objectAnimatorXAnimator.start();
    }

    public void animateXY(int i, int i2) {
        animateXY(i, i2, Easing.Linear, Easing.Linear);
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorXAnimator = xAnimator(i, easingFunction);
        ObjectAnimator objectAnimatorYAnimator = yAnimator(i2, easingFunction);
        if (i > i2) {
            objectAnimatorXAnimator.addUpdateListener(this.mListener);
        } else {
            objectAnimatorYAnimator.addUpdateListener(this.mListener);
        }
        objectAnimatorXAnimator.start();
        objectAnimatorYAnimator.start();
    }

    public void animateXY(int i, int i2, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator objectAnimatorXAnimator = xAnimator(i, easingFunction);
        ObjectAnimator objectAnimatorYAnimator = yAnimator(i2, easingFunction2);
        if (i > i2) {
            objectAnimatorXAnimator.addUpdateListener(this.mListener);
        } else {
            objectAnimatorYAnimator.addUpdateListener(this.mListener);
        }
        objectAnimatorXAnimator.start();
        objectAnimatorYAnimator.start();
    }

    public void animateY(int i) {
        animateY(i, Easing.Linear);
    }

    public void animateY(int i, Easing.EasingFunction easingFunction) {
        ObjectAnimator objectAnimatorYAnimator = yAnimator(i, easingFunction);
        objectAnimatorYAnimator.addUpdateListener(this.mListener);
        objectAnimatorYAnimator.start();
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseY(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mPhaseY = f;
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public void setPhaseX(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mPhaseX = f;
    }
}
