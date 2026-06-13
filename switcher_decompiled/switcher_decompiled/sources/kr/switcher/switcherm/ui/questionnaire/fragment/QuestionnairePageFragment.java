package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.setting.helper.PageHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnairePageFragment extends Fragment {
    private static final String PARM_POSITION = "position";
    private static PageHashMap pageHashMap;

    @BindView(R.id.iv_switcher_icon)
    ImageView iv_switcher_icon;

    @BindView(R.id.tv_propose_message)
    TextView tv_propose_message;

    @BindView(R.id.tv_situation)
    TextView tv_situation;

    public static QuestionnairePageFragment newInstance(int i, PageHashMap pageHashMap2) {
        QuestionnairePageFragment questionnairePageFragment = new QuestionnairePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARM_POSITION, i);
        questionnairePageFragment.setArguments(bundle);
        pageHashMap = pageHashMap2;
        return questionnairePageFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        int id = arguments != null ? arguments.getInt(PARM_POSITION) : 0;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_questionnaire_page, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        if (pageHashMap.getSize() <= 1) {
            id = pageHashMap.getId();
        }
        this.tv_propose_message.setText(pageHashMap.getProposeMessage(id));
        this.tv_situation.setText(pageHashMap.getSituationMessage(id));
        this.iv_switcher_icon.setImageDrawable(pageHashMap.getPageDrawable(id));
        return viewInflate;
    }
}
