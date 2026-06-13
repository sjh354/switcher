package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireEditFragment_ViewBinding implements Unbinder {
    private QuestionnaireEditFragment target;

    public QuestionnaireEditFragment_ViewBinding(QuestionnaireEditFragment questionnaireEditFragment, View view) {
        this.target = questionnaireEditFragment;
        questionnaireEditFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        QuestionnaireEditFragment questionnaireEditFragment = this.target;
        if (questionnaireEditFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        questionnaireEditFragment.viewpager = null;
    }
}
