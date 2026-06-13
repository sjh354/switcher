package antistatic.spinnerwheel;

import android.content.Context;
import android.view.MotionEvent;
import antistatic.spinnerwheel.WheelScroller;

/* JADX INFO: loaded from: classes.dex */
public class WheelVerticalScroller extends WheelScroller {
    public WheelVerticalScroller(Context context, WheelScroller.ScrollingListener scrollingListener) {
        super(context, scrollingListener);
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected int getCurrentScrollerPosition() {
        return this.scroller.getCurrY();
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected int getFinalScrollerPosition() {
        return this.scroller.getFinalY();
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected float getMotionEventPosition(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected void scrollerStartScroll(int i, int i2) {
        this.scroller.startScroll(0, 0, 0, i, i2);
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected void scrollerFling(int i, int i2, int i3) {
        this.scroller.fling(0, i, 0, -i3, 0, 0, -2147483647, Integer.MAX_VALUE);
    }
}
