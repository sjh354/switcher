package com.rey.material.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes2.dex */
public class CheckedImageView extends ImageView implements Checkable {
    private static final int[] STATE_CHECKED = {R.attr.state_checked};
    private boolean mChecked;

    public CheckedImageView(Context context) {
        super(context);
        this.mChecked = false;
    }

    public CheckedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChecked = false;
    }

    public CheckedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChecked = false;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            this.mChecked = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        int[] iArr = this.mChecked ? STATE_CHECKED : null;
        if (iArr != null) {
            mergeDrawableStates(iArrOnCreateDrawableState, iArr);
        }
        return iArrOnCreateDrawableState;
    }
}
