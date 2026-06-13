package com.rey.material.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.rey.material.drawable.CheckBoxDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class CheckBox extends CompoundButton {
    public CheckBox(Context context) {
        super(context);
    }

    public CheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.rey.material.widget.CompoundButton
    protected void applyStyle(Context context, AttributeSet attributeSet, int i, int i2) {
        super.applyStyle(context, attributeSet, i, i2);
        CheckBoxDrawable checkBoxDrawableBuild = new CheckBoxDrawable.Builder(context, attributeSet, i, i2).build();
        checkBoxDrawableBuild.setInEditMode(isInEditMode());
        checkBoxDrawableBuild.setAnimEnable(false);
        setButtonDrawable(checkBoxDrawableBuild);
        checkBoxDrawableBuild.setAnimEnable(true);
    }

    public void setCheckedImmediately(boolean z) {
        if (getButtonDrawable() instanceof CheckBoxDrawable) {
            CheckBoxDrawable checkBoxDrawable = (CheckBoxDrawable) getButtonDrawable();
            checkBoxDrawable.setAnimEnable(false);
            setChecked(z);
            checkBoxDrawable.setAnimEnable(true);
            return;
        }
        setChecked(z);
    }
}
