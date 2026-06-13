package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnairePageFragment_ViewBinding implements Unbinder {
    private QuestionnairePageFragment target;

    public QuestionnairePageFragment_ViewBinding(QuestionnairePageFragment questionnairePageFragment, View view) {
        this.target = questionnairePageFragment;
        questionnairePageFragment.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
        questionnairePageFragment.tv_propose_message = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_propose_message, "field 'tv_propose_message'", TextView.class);
        questionnairePageFragment.tv_situation = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_situation, "field 'tv_situation'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        QuestionnairePageFragment questionnairePageFragment = this.target;
        if (questionnairePageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        questionnairePageFragment.iv_switcher_icon = null;
        questionnairePageFragment.tv_propose_message = null;
        questionnairePageFragment.tv_situation = null;
    }
}
