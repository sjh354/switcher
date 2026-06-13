package com.rey.material.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.rey.material.R;
import com.rey.material.drawable.RippleDrawable;
import com.rey.material.drawable.ToolbarRippleDrawable;
import com.rey.material.util.ViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class RippleManager implements View.OnClickListener {
    private View.OnClickListener mClickListener;
    private boolean mClickScheduled = false;

    public void onCreate(View view, Context context, AttributeSet attributeSet, int i, int i2) {
        if (view.isInEditMode()) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RippleView, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.RippleView_rd_style, 0);
        RippleDrawable rippleDrawableBuild = null;
        if (resourceId != 0) {
            rippleDrawableBuild = new RippleDrawable.Builder(context, resourceId).backgroundDrawable(getBackground(view)).build();
        } else if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.RippleView_rd_enable, false)) {
            rippleDrawableBuild = new RippleDrawable.Builder(context, attributeSet, i, i2).backgroundDrawable(getBackground(view)).build();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (rippleDrawableBuild != null) {
            ViewUtil.setBackground(view, rippleDrawableBuild);
        }
    }

    private Drawable getBackground(View view) {
        Drawable background = view.getBackground();
        if (background == null) {
            return null;
        }
        return background instanceof RippleDrawable ? ((RippleDrawable) background).getBackgroundDrawable() : background;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public boolean onTouchEvent(View view, MotionEvent motionEvent) {
        Drawable background = view.getBackground();
        return background != null && (background instanceof RippleDrawable) && ((RippleDrawable) background).onTouch(view, motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            android.graphics.drawable.Drawable r0 = r6.getBackground()
            r1 = 0
            if (r0 == 0) goto L1e
            boolean r3 = r0 instanceof com.rey.material.drawable.RippleDrawable
            if (r3 == 0) goto L13
            com.rey.material.drawable.RippleDrawable r0 = (com.rey.material.drawable.RippleDrawable) r0
            long r3 = r0.getClickDelayTime()
            goto L1f
        L13:
            boolean r3 = r0 instanceof com.rey.material.drawable.ToolbarRippleDrawable
            if (r3 == 0) goto L1e
            com.rey.material.drawable.ToolbarRippleDrawable r0 = (com.rey.material.drawable.ToolbarRippleDrawable) r0
            long r3 = r0.getClickDelayTime()
            goto L1f
        L1e:
            r3 = r1
        L1f:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L3d
            android.os.Handler r0 = r6.getHandler()
            if (r0 == 0) goto L3d
            boolean r0 = r5.mClickScheduled
            if (r0 != 0) goto L40
            r0 = 1
            r5.mClickScheduled = r0
            android.os.Handler r0 = r6.getHandler()
            com.rey.material.widget.RippleManager$ClickRunnable r1 = new com.rey.material.widget.RippleManager$ClickRunnable
            r1.<init>(r6)
            r0.postDelayed(r1, r3)
            goto L40
        L3d:
            r5.dispatchClickEvent(r6)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rey.material.widget.RippleManager.onClick(android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchClickEvent(View view) {
        View.OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static void cancelRipple(View view) {
        Drawable background = view.getBackground();
        if (background instanceof RippleDrawable) {
            ((RippleDrawable) background).cancel();
        } else if (background instanceof ToolbarRippleDrawable) {
            ((ToolbarRippleDrawable) background).cancel();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                cancelRipple(viewGroup.getChildAt(i));
            }
        }
    }

    class ClickRunnable implements Runnable {
        View mView;

        public ClickRunnable(View view) {
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            RippleManager.this.mClickScheduled = false;
            RippleManager.this.dispatchClickEvent(this.mView);
        }
    }
}
