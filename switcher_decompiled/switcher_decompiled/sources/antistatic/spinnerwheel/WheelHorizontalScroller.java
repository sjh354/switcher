package antistatic.spinnerwheel;

import android.content.Context;
import android.view.MotionEvent;
import antistatic.spinnerwheel.WheelScroller;

/* JADX INFO: loaded from: classes.dex */
public class WheelHorizontalScroller extends WheelScroller {
    public WheelHorizontalScroller(Context context, WheelScroller.ScrollingListener scrollingListener) {
        super(context, scrollingListener);
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected int getCurrentScrollerPosition() {
        return this.scroller.getCurrX();
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected int getFinalScrollerPosition() {
        return this.scroller.getFinalX();
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected float getMotionEventPosition(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected void scrollerStartScroll(int i, int i2) {
        this.scroller.startScroll(0, 0, i, 0, i2);
    }

    @Override // antistatic.spinnerwheel.WheelScroller
    protected void scrollerFling(int i, int i2, int i3) {
        this.scroller.fling(i, 0, -i2, 0, -2147483647, Integer.MAX_VALUE, 0, 0);
    }
}
