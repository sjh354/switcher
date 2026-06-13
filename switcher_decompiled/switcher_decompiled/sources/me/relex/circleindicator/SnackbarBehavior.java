package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SnackbarBehavior extends CoordinatorLayout.Behavior<CircleIndicator> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        circleIndicator.setTranslationY(getTranslationYForSnackbar(coordinatorLayout, circleIndicator));
        return true;
    }

    private float getTranslationYForSnackbar(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator) {
        List<View> dependencies = coordinatorLayout.getDependencies(circleIndicator);
        int size = dependencies.size();
        float fMin = 0.0f;
        for (int i = 0; i < size; i++) {
            View view = dependencies.get(i);
            if ((view instanceof Snackbar.SnackbarLayout) && coordinatorLayout.doViewsOverlap(circleIndicator, view)) {
                fMin = Math.min(fMin, ViewCompat.getTranslationY(view) - view.getHeight());
            }
        }
        return fMin;
    }
}
