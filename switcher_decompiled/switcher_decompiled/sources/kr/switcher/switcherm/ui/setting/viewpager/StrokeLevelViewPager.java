package kr.switcher.switcherm.ui.setting.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public class StrokeLevelViewPager extends ViewPager {
    private boolean isEnabled;

    public StrokeLevelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isEnabled = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.isEnabled) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            Log.e("INFO", stringWriter.toString());
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setPagingEnable() {
        this.isEnabled = true;
    }

    public void setPagingDisable() {
        this.isEnabled = false;
    }
}
