package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class AnalysisFragment_ViewBinding implements Unbinder {
    private AnalysisFragment target;

    public AnalysisFragment_ViewBinding(AnalysisFragment analysisFragment, View view) {
        this.target = analysisFragment;
        analysisFragment.tv_loading = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_loading, "field 'tv_loading'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AnalysisFragment analysisFragment = this.target;
        if (analysisFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        analysisFragment.tv_loading = null;
    }
}
