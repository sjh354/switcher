package antistatic.spinnerwheel;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes.dex */
public abstract class WheelScroller {
    public static final int MIN_DELTA_FOR_SCROLLING = 1;
    private static final int SCROLLING_DURATION = 400;
    private Context context;
    private GestureDetector gestureDetector;
    private boolean isScrollingPerformed;
    private int lastScrollPosition;
    private float lastTouchedPosition;
    private ScrollingListener listener;
    protected Scroller scroller;
    private final int MESSAGE_SCROLL = 0;
    private final int MESSAGE_JUSTIFY = 1;
    private Handler animationHandler = new Handler() { // from class: antistatic.spinnerwheel.WheelScroller.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WheelScroller.this.scroller.computeScrollOffset();
            int currentScrollerPosition = WheelScroller.this.getCurrentScrollerPosition();
            int i = WheelScroller.this.lastScrollPosition - currentScrollerPosition;
            WheelScroller.this.lastScrollPosition = currentScrollerPosition;
            if (i != 0) {
                WheelScroller.this.listener.onScroll(i);
            }
            if (Math.abs(currentScrollerPosition - WheelScroller.this.getFinalScrollerPosition()) < 1) {
                WheelScroller.this.scroller.forceFinished(true);
            }
            if (!WheelScroller.this.scroller.isFinished()) {
                WheelScroller.this.animationHandler.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                WheelScroller.this.justify();
            } else {
                WheelScroller.this.finishScrolling();
            }
        }
    };

    public interface ScrollingListener {
        void onFinished();

        void onJustify();

        void onScroll(int i);

        void onStarted();

        void onTouch();

        void onTouchUp();
    }

    protected abstract int getCurrentScrollerPosition();

    protected abstract int getFinalScrollerPosition();

    protected abstract float getMotionEventPosition(MotionEvent motionEvent);

    protected abstract void scrollerFling(int i, int i2, int i3);

    protected abstract void scrollerStartScroll(int i, int i2);

    public WheelScroller(Context context, ScrollingListener scrollingListener) {
        GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: antistatic.spinnerwheel.WheelScroller.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                WheelScroller.this.lastScrollPosition = 0;
                WheelScroller wheelScroller = WheelScroller.this;
                wheelScroller.scrollerFling(wheelScroller.lastScrollPosition, (int) f, (int) f2);
                WheelScroller.this.setNextMessage(0);
                return true;
            }
        });
        this.gestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.scroller = new Scroller(context);
        this.listener = scrollingListener;
        this.context = context;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.scroller.forceFinished(true);
        this.scroller = new Scroller(this.context, interpolator);
    }

    public void scroll(int i, int i2) {
        this.scroller.forceFinished(true);
        this.lastScrollPosition = 0;
        if (i2 == 0) {
            i2 = 400;
        }
        scrollerStartScroll(i, i2);
        setNextMessage(0);
        startScrolling();
    }

    public void stopScrolling() {
        this.scroller.forceFinished(true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int motionEventPosition;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastTouchedPosition = getMotionEventPosition(motionEvent);
            this.scroller.forceFinished(true);
            clearMessages();
            this.listener.onTouch();
        } else if (action != 1) {
            if (action == 2 && (motionEventPosition = (int) (getMotionEventPosition(motionEvent) - this.lastTouchedPosition)) != 0) {
                startScrolling();
                this.listener.onScroll(motionEventPosition);
                this.lastTouchedPosition = getMotionEventPosition(motionEvent);
            }
        } else if (this.scroller.isFinished()) {
            this.listener.onTouchUp();
        }
        if (!this.gestureDetector.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            justify();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextMessage(int i) {
        clearMessages();
        this.animationHandler.sendEmptyMessage(i);
    }

    private void clearMessages() {
        this.animationHandler.removeMessages(0);
        this.animationHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void justify() {
        this.listener.onJustify();
        setNextMessage(1);
    }

    private void startScrolling() {
        if (this.isScrollingPerformed) {
            return;
        }
        this.isScrollingPerformed = true;
        this.listener.onStarted();
    }

    protected void finishScrolling() {
        if (this.isScrollingPerformed) {
            this.listener.onFinished();
            this.isScrollingPerformed = false;
        }
    }
}
