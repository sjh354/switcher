package com.rey.material.app;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import com.rey.material.app.ThemeManager;
import com.rey.material.drawable.NavigationDrawerDrawable;
import com.rey.material.drawable.ToolbarRippleDrawable;
import com.rey.material.util.ViewUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarManager {
    private ArrayList<Animation> mAnimations;
    private Animator mAnimator;
    private AppCompatDelegate mAppCompatDelegate;
    private ToolbarRippleDrawable.Builder mBuilder;
    private int mCurrentGroup;
    private boolean mGroupChanged;
    private ArrayList<OnToolbarGroupChangedListener> mListeners;
    private boolean mMenuDataChanged;
    private ActionMenuView mMenuView;
    private NavigationManager mNavigationManager;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private Animation.AnimationListener mOutAnimationEndListener;
    private int mRippleStyle;
    private Toolbar mToolbar;

    public interface Animator {
        Animation getInAnimation(View view, int i);

        Animation getOutAnimation(View view, int i);
    }

    public interface OnToolbarGroupChangedListener {
        void onToolbarGroupChanged(int i, int i2);
    }

    public ToolbarManager(AppCompatDelegate appCompatDelegate, Toolbar toolbar, int i, int i2, int i3, int i4) {
        this(appCompatDelegate, toolbar, i, i2, new SimpleAnimator(i3, i4));
    }

    public ToolbarManager(AppCompatDelegate appCompatDelegate, Toolbar toolbar, int i, int i2, Animator animator) {
        this.mCurrentGroup = 0;
        this.mGroupChanged = false;
        this.mMenuDataChanged = true;
        this.mListeners = new ArrayList<>();
        this.mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rey.material.app.ToolbarManager.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ToolbarManager.this.onGlobalLayout();
            }
        };
        this.mAnimations = new ArrayList<>();
        this.mOutAnimationEndListener = new Animation.AnimationListener() { // from class: com.rey.material.app.ToolbarManager.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (ToolbarManager.this.mAppCompatDelegate != null) {
                    ToolbarManager.this.mAppCompatDelegate.invalidateOptionsMenu();
                } else {
                    ToolbarManager.this.onPrepareMenu();
                }
            }
        };
        this.mAppCompatDelegate = appCompatDelegate;
        this.mToolbar = toolbar;
        this.mCurrentGroup = i;
        this.mRippleStyle = i2;
        this.mAnimator = animator;
        appCompatDelegate.setSupportActionBar(toolbar);
    }

    public void registerOnToolbarGroupChangedListener(OnToolbarGroupChangedListener onToolbarGroupChangedListener) {
        if (this.mListeners.contains(onToolbarGroupChangedListener)) {
            return;
        }
        this.mListeners.add(onToolbarGroupChangedListener);
    }

    public void unregisterOnToolbarGroupChangedListener(OnToolbarGroupChangedListener onToolbarGroupChangedListener) {
        this.mListeners.remove(onToolbarGroupChangedListener);
    }

    private void dispatchOnToolbarGroupChanged(int i, int i2) {
        Iterator<OnToolbarGroupChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onToolbarGroupChanged(i, i2);
        }
    }

    public int getCurrentGroup() {
        return this.mCurrentGroup;
    }

    public void setCurrentGroup(int i) {
        int i2 = this.mCurrentGroup;
        if (i2 != i) {
            this.mCurrentGroup = i;
            this.mGroupChanged = true;
            dispatchOnToolbarGroupChanged(i2, i);
            animateOut();
        }
    }

    public void createMenu(int i) {
        this.mToolbar.inflateMenu(i);
        this.mMenuDataChanged = true;
        if (this.mAppCompatDelegate == null) {
            onPrepareMenu();
        }
    }

    public void onPrepareMenu() {
        if (this.mGroupChanged || this.mMenuDataChanged) {
            this.mToolbar.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
            Menu menu = this.mToolbar.getMenu();
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                item.setVisible(item.getGroupId() == this.mCurrentGroup || item.getGroupId() == 0);
            }
            this.mMenuDataChanged = false;
        }
    }

    public void setNavigationManager(NavigationManager navigationManager) {
        this.mNavigationManager = navigationManager;
        notifyNavigationStateInvalidated();
    }

    public void notifyNavigationStateInvalidated() {
        NavigationManager navigationManager = this.mNavigationManager;
        if (navigationManager != null) {
            navigationManager.notifyStateInvalidated();
        }
    }

    public void notifyNavigationStateChanged() {
        NavigationManager navigationManager = this.mNavigationManager;
        if (navigationManager != null) {
            navigationManager.notifyStateChanged();
        }
    }

    public void notifyNavigationStateProgressChanged(boolean z, float f) {
        NavigationManager navigationManager = this.mNavigationManager;
        if (navigationManager != null) {
            navigationManager.notifyStateProgressChanged(z, f);
        }
    }

    public boolean isNavigationBackState() {
        NavigationManager navigationManager = this.mNavigationManager;
        return navigationManager != null && navigationManager.isBackState();
    }

    public boolean isNavigationVisisble() {
        NavigationManager navigationManager = this.mNavigationManager;
        return navigationManager != null && navigationManager.isNavigationVisible();
    }

    public void setNavigationVisisble(boolean z, boolean z2) {
        NavigationManager navigationManager = this.mNavigationManager;
        if (navigationManager != null) {
            navigationManager.setNavigationVisible(z, z2);
        }
    }

    private ToolbarRippleDrawable getBackground() {
        if (this.mBuilder == null) {
            this.mBuilder = new ToolbarRippleDrawable.Builder(this.mToolbar.getContext(), this.mRippleStyle);
        }
        return this.mBuilder.build();
    }

    private ActionMenuView getMenuView() {
        if (this.mMenuView == null) {
            int i = 0;
            while (true) {
                if (i >= this.mToolbar.getChildCount()) {
                    break;
                }
                View childAt = this.mToolbar.getChildAt(i);
                if (childAt instanceof ActionMenuView) {
                    this.mMenuView = (ActionMenuView) childAt;
                    break;
                }
                i++;
            }
        }
        return this.mMenuView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.mToolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        } else {
            this.mToolbar.getViewTreeObserver().removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        ActionMenuView menuView = getMenuView();
        int childCount = menuView == null ? 0 : menuView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = menuView.getChildAt(i);
            if (this.mRippleStyle != 0 && (childAt.getBackground() == null || !(childAt.getBackground() instanceof ToolbarRippleDrawable))) {
                ViewUtil.setBackground(childAt, getBackground());
            }
        }
        if (this.mGroupChanged) {
            animateIn();
            this.mGroupChanged = false;
        }
    }

    private void animateOut() {
        ActionMenuView menuView = getMenuView();
        int childCount = menuView == null ? 0 : menuView.getChildCount();
        this.mAnimations.clear();
        this.mAnimations.ensureCapacity(childCount);
        Animation animation = null;
        for (int i = 0; i < childCount; i++) {
            Animation outAnimation = this.mAnimator.getOutAnimation(menuView.getChildAt(i), i);
            this.mAnimations.add(outAnimation);
            if (outAnimation != null && (animation == null || animation.getStartOffset() + animation.getDuration() < outAnimation.getStartOffset() + outAnimation.getDuration())) {
                animation = outAnimation;
            }
        }
        if (animation == null) {
            this.mOutAnimationEndListener.onAnimationEnd(null);
        } else {
            animation.setAnimationListener(this.mOutAnimationEndListener);
            for (int i2 = 0; i2 < childCount; i2++) {
                Animation animation2 = this.mAnimations.get(i2);
                if (animation2 != null) {
                    menuView.getChildAt(i2).startAnimation(animation2);
                }
            }
        }
        this.mAnimations.clear();
    }

    private void animateIn() {
        ActionMenuView menuView = getMenuView();
        int childCount = menuView == null ? 0 : menuView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = menuView.getChildAt(i);
            Animation inAnimation = this.mAnimator.getInAnimation(childAt, i);
            if (inAnimation != null) {
                childAt.startAnimation(inAnimation);
            }
        }
    }

    private static class SimpleAnimator implements Animator {
        private int mAnimationIn;
        private int mAnimationOut;

        public SimpleAnimator(int i, int i2) {
            this.mAnimationIn = i;
            this.mAnimationOut = i2;
        }

        @Override // com.rey.material.app.ToolbarManager.Animator
        public Animation getOutAnimation(View view, int i) {
            if (this.mAnimationOut == 0) {
                return null;
            }
            return AnimationUtils.loadAnimation(view.getContext(), this.mAnimationOut);
        }

        @Override // com.rey.material.app.ToolbarManager.Animator
        public Animation getInAnimation(View view, int i) {
            if (this.mAnimationIn == 0) {
                return null;
            }
            return AnimationUtils.loadAnimation(view.getContext(), this.mAnimationIn);
        }
    }

    public static abstract class NavigationManager {
        private long mAnimTime;
        protected long mAnimationDuration;
        protected NavigationDrawerDrawable mNavigationIcon;
        protected Toolbar mToolbar;
        protected boolean mNavigationVisible = true;
        private List<Object> mAnimations = new ArrayList();

        public abstract boolean isBackState();

        public abstract void onNavigationClick();

        public NavigationManager(NavigationDrawerDrawable navigationDrawerDrawable, Toolbar toolbar) {
            this.mToolbar = toolbar;
            this.mNavigationIcon = navigationDrawerDrawable;
            toolbar.setNavigationIcon(this.mNavigationVisible ? navigationDrawerDrawable : null);
            this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.rey.material.app.ToolbarManager.NavigationManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NavigationManager.this.onNavigationClick();
                }
            });
            this.mAnimationDuration = toolbar.getResources().getInteger(R.integer.config_shortAnimTime);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void notifyStateInvalidated() {
            this.mNavigationIcon.switchIconState(isBackState() ? 1 : 0, false);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void notifyStateChanged() {
            NavigationDrawerDrawable navigationDrawerDrawable = this.mNavigationIcon;
            boolean zIsBackState = isBackState();
            navigationDrawerDrawable.switchIconState(zIsBackState ? 1 : 0, this.mNavigationVisible);
        }

        public void notifyStateProgressChanged(boolean z, float f) {
            this.mNavigationIcon.setIconState(z ? 1 : 0, f);
        }

        public boolean isNavigationVisible() {
            return this.mNavigationVisible;
        }

        public void setNavigationVisible(boolean z, boolean z2) {
            if (this.mNavigationVisible != z) {
                this.mNavigationVisible = z;
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (!z2) {
                    this.mToolbar.setNavigationIcon(this.mNavigationVisible ? this.mNavigationIcon : null);
                    this.mAnimTime = jUptimeMillis;
                    if (this.mNavigationVisible) {
                        return;
                    }
                    this.mNavigationIcon.cancel();
                    return;
                }
                if (this.mNavigationVisible) {
                    animateNavigationIn(jUptimeMillis);
                } else {
                    animateNavigationOut(jUptimeMillis);
                }
            }
        }

        protected Interpolator getInterpolator(boolean z) {
            return new DecelerateInterpolator();
        }

        private void cancelAllAnimations() {
            for (Object obj : this.mAnimations) {
                if (obj instanceof Animation) {
                    ((Animation) obj).cancel();
                } else if (obj instanceof ValueAnimator) {
                    ((ValueAnimator) obj).cancel();
                }
            }
            this.mAnimations.clear();
        }

        private void animateNavigationOut(long j) {
            this.mAnimTime = j;
            cancelAllAnimations();
            this.mToolbar.setNavigationIcon((Drawable) null);
            doOnPreDraw(this.mToolbar, new AnonymousClass2(j));
        }

        /* JADX INFO: renamed from: com.rey.material.app.ToolbarManager$NavigationManager$2, reason: invalid class name */
        class AnonymousClass2 extends AnimRunnable {
            AnonymousClass2(long j) {
                super(j);
            }

            @Override // com.rey.material.app.ToolbarManager.NavigationManager.AnimRunnable
            void doWork() {
                final ViewData viewData = new ViewData(NavigationManager.this.mToolbar);
                NavigationManager.this.mToolbar.setNavigationIcon(NavigationManager.this.mNavigationIcon);
                NavigationManager navigationManager = NavigationManager.this;
                navigationManager.doOnPreDraw(navigationManager.mToolbar, new AnimRunnable(this.mTime) { // from class: com.rey.material.app.ToolbarManager.NavigationManager.2.1
                    {
                        NavigationManager navigationManager2 = NavigationManager.this;
                    }

                    @Override // com.rey.material.app.ToolbarManager.NavigationManager.AnimRunnable
                    void doWork() {
                        int childCount = NavigationManager.this.mToolbar.getChildCount();
                        boolean z = true;
                        for (int i = 0; i < childCount; i++) {
                            View childAt = NavigationManager.this.mToolbar.getChildAt(i);
                            if (!(childAt instanceof ActionMenuView)) {
                                int left = viewData.getLeft(childAt);
                                if (left < 0) {
                                    left = (-childAt.getLeft()) - childAt.getWidth();
                                }
                                if (z) {
                                    NavigationManager.this.animateViewOut(childAt, left, new Runnable() { // from class: com.rey.material.app.ToolbarManager.NavigationManager.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            NavigationManager.this.mToolbar.setNavigationIcon((Drawable) null);
                                            NavigationManager.this.mNavigationIcon.cancel();
                                        }
                                    });
                                    z = false;
                                } else {
                                    NavigationManager.this.animateViewOut(childAt, left, null);
                                }
                            }
                        }
                        if (z) {
                            NavigationManager.this.mToolbar.setNavigationIcon((Drawable) null);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void animateViewOut(final View view, final int i, final Runnable runnable) {
            final Interpolator interpolator = getInterpolator(false);
            final int left = view.getLeft();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(this.mAnimationDuration);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.rey.material.app.ToolbarManager.NavigationManager.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Runnable runnable2;
                    float interpolation = interpolator.getInterpolation(valueAnimator.getAnimatedFraction());
                    float f = left + ((i - r1) * interpolation);
                    view.offsetLeftAndRight((int) (f - r0.getLeft()));
                    if (valueAnimator.getAnimatedFraction() != 1.0f || (runnable2 = runnable) == null) {
                        return;
                    }
                    runnable2.run();
                }
            });
            valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.rey.material.app.ToolbarManager.NavigationManager.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(android.animation.Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    NavigationManager.this.mAnimations.remove(animator);
                }
            });
            valueAnimatorOfFloat.start();
            this.mAnimations.add(valueAnimatorOfFloat);
        }

        private void animateNavigationIn(long j) {
            this.mAnimTime = j;
            cancelAllAnimations();
            this.mToolbar.setNavigationIcon((Drawable) null);
            doOnPreDraw(this.mToolbar, new AnimRunnable(j) { // from class: com.rey.material.app.ToolbarManager.NavigationManager.5
                @Override // com.rey.material.app.ToolbarManager.NavigationManager.AnimRunnable
                void doWork() {
                    final ViewData viewData = new ViewData(NavigationManager.this.mToolbar);
                    NavigationManager.this.mToolbar.setNavigationIcon(NavigationManager.this.mNavigationIcon);
                    NavigationManager navigationManager = NavigationManager.this;
                    navigationManager.doOnPreDraw(navigationManager.mToolbar, new AnimRunnable(this.mTime) { // from class: com.rey.material.app.ToolbarManager.NavigationManager.5.1
                        {
                            NavigationManager navigationManager2 = NavigationManager.this;
                        }

                        @Override // com.rey.material.app.ToolbarManager.NavigationManager.AnimRunnable
                        void doWork() {
                            int childCount = NavigationManager.this.mToolbar.getChildCount();
                            for (int i = 0; i < childCount; i++) {
                                View childAt = NavigationManager.this.mToolbar.getChildAt(i);
                                if (!(childAt instanceof ActionMenuView)) {
                                    int left = viewData.getLeft(childAt);
                                    if (left < 0) {
                                        left = (-childAt.getLeft()) - childAt.getWidth();
                                    }
                                    NavigationManager.this.animateViewIn(childAt, left);
                                }
                            }
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void animateViewIn(View view, int i) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, i - view.getLeft(), 0, 0.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.rey.material.app.ToolbarManager.NavigationManager.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    NavigationManager.this.mAnimations.remove(animation);
                }
            });
            translateAnimation.setInterpolator(getInterpolator(true));
            translateAnimation.setDuration(this.mAnimationDuration);
            view.startAnimation(translateAnimation);
            this.mAnimations.add(translateAnimation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doOnPreDraw(final View view, final Runnable runnable) {
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.rey.material.app.ToolbarManager.NavigationManager.7
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    runnable.run();
                    view.getViewTreeObserver().removeOnPreDrawListener(this);
                    return false;
                }
            });
        }

        static class ViewData {
            List<Integer> lefts;
            List<View> views;

            public ViewData(Toolbar toolbar) {
                int childCount = toolbar.getChildCount();
                this.views = new ArrayList(childCount);
                this.lefts = new ArrayList(childCount);
                for (int i = 0; i < childCount; i++) {
                    View childAt = toolbar.getChildAt(i);
                    if (!(childAt instanceof ActionMenuView)) {
                        this.views.add(childAt);
                        this.lefts.add(Integer.valueOf(childAt.getLeft()));
                    }
                }
            }

            public int getLeft(View view) {
                int size = this.views.size();
                for (int i = 0; i < size; i++) {
                    if (this.views.get(i) == view) {
                        return this.lefts.get(i).intValue();
                    }
                }
                return -1;
            }
        }

        abstract class AnimRunnable implements Runnable {
            long mTime;

            abstract void doWork();

            public AnimRunnable(long j) {
                this.mTime = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.mTime == NavigationManager.this.mAnimTime) {
                    doWork();
                }
            }
        }
    }

    public static class BaseNavigationManager extends NavigationManager {
        protected DrawerLayout mDrawerLayout;
        protected FragmentManager mFragmentManager;

        protected void onDrawerClosed(View view) {
        }

        protected void onDrawerOpened(View view) {
        }

        protected void onDrawerStateChanged(int i) {
        }

        @Override // com.rey.material.app.ToolbarManager.NavigationManager
        public void onNavigationClick() {
        }

        public BaseNavigationManager(int i, FragmentManager fragmentManager, Toolbar toolbar, DrawerLayout drawerLayout) {
            super(new NavigationDrawerDrawable.Builder(toolbar.getContext(), i).build(), toolbar);
            this.mDrawerLayout = drawerLayout;
            this.mFragmentManager = fragmentManager;
            if (drawerLayout != null) {
                drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() { // from class: com.rey.material.app.ToolbarManager.BaseNavigationManager.1
                    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                    public void onDrawerSlide(View view, float f) {
                        BaseNavigationManager.this.onDrawerSlide(view, f);
                    }

                    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                    public void onDrawerOpened(View view) {
                        BaseNavigationManager.this.onDrawerOpened(view);
                    }

                    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                    public void onDrawerClosed(View view) {
                        BaseNavigationManager.this.onDrawerClosed(view);
                    }

                    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
                    public void onDrawerStateChanged(int i2) {
                        BaseNavigationManager.this.onDrawerStateChanged(i2);
                    }
                });
            }
            this.mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.rey.material.app.ToolbarManager.BaseNavigationManager.2
                @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
                public void onBackStackChanged() {
                    BaseNavigationManager.this.onFragmentChanged();
                }
            });
        }

        @Override // com.rey.material.app.ToolbarManager.NavigationManager
        public boolean isBackState() {
            if (this.mFragmentManager.getBackStackEntryCount() > 1) {
                return true;
            }
            DrawerLayout drawerLayout = this.mDrawerLayout;
            return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
        }

        protected boolean shouldSyncDrawerSlidingProgress() {
            return this.mFragmentManager.getBackStackEntryCount() <= 1;
        }

        protected void onFragmentChanged() {
            notifyStateChanged();
        }

        protected void onDrawerSlide(View view, float f) {
            if (!shouldSyncDrawerSlidingProgress()) {
                notifyStateInvalidated();
            } else if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                notifyStateProgressChanged(false, 1.0f - f);
            } else {
                notifyStateProgressChanged(true, f);
            }
        }
    }

    public static class ThemableNavigationManager extends BaseNavigationManager implements ThemeManager.OnThemeChangedListener {
        private int mCurrentStyle;
        private int mStyleId;

        public ThemableNavigationManager(int i, FragmentManager fragmentManager, Toolbar toolbar, DrawerLayout drawerLayout) {
            super(ThemeManager.getInstance().getCurrentStyle(i), fragmentManager, toolbar, drawerLayout);
            this.mStyleId = i;
            this.mCurrentStyle = ThemeManager.getInstance().getCurrentStyle(i);
            ThemeManager.getInstance().registerOnThemeChangedListener(this);
        }

        @Override // com.rey.material.app.ThemeManager.OnThemeChangedListener
        public void onThemeChanged(ThemeManager.OnThemeChangedEvent onThemeChangedEvent) {
            int currentStyle = ThemeManager.getInstance().getCurrentStyle(this.mStyleId);
            if (this.mCurrentStyle != currentStyle) {
                this.mCurrentStyle = currentStyle;
                NavigationDrawerDrawable navigationDrawerDrawableBuild = new NavigationDrawerDrawable.Builder(this.mToolbar.getContext(), this.mCurrentStyle).build();
                navigationDrawerDrawableBuild.switchIconState(this.mNavigationIcon.getIconState(), false);
                this.mNavigationIcon = navigationDrawerDrawableBuild;
                this.mToolbar.setNavigationIcon(this.mNavigationVisible ? this.mNavigationIcon : null);
            }
        }
    }
}
