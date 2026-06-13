package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireScreenController;
import kr.switcher.switcherm.ui.questionnaire.presenter.SummaryPresenter;
import kr.switcher.switcherm.ui.questionnaire.views.SummaryView;

/* JADX INFO: loaded from: classes2.dex */
public class SummaryFragment extends Fragment implements SummaryView {

    @BindView(R.id.btn_answer1)
    TextView btn_answer1;

    @BindView(R.id.btn_answer2)
    TextView btn_answer2;

    @BindView(R.id.btn_answer3)
    TextView btn_answer3;

    @BindView(R.id.btn_answer4)
    TextView btn_answer4;

    @BindView(R.id.btn_answer5)
    TextView btn_answer5;
    private String connectedMacAddress;
    private SummaryPresenter presenter;

    public static SummaryFragment newInstance(String str) {
        SummaryFragment summaryFragment = new SummaryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        summaryFragment.setArguments(bundle);
        return summaryFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_summary, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        SummaryPresenter summaryPresenter = new SummaryPresenter(this);
        this.presenter = summaryPresenter;
        summaryPresenter.initialize();
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void trackSummaryForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_0_0));
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void setAnswer1Text(String str) {
        this.btn_answer1.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void setAnswer2Text(String str) {
        this.btn_answer2.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void setAnswer3Text(String str) {
        this.btn_answer3.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void setAnswer4Text(String str) {
        this.btn_answer4.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void setAnswer5Text(String str) {
        this.btn_answer5.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void moveAnalysisFragment() {
        QuestionnaireScreenController.moveAnalysisFragment((AppCompatActivity) getActivity(), this.connectedMacAddress);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.SummaryView
    public void moveQuestionEditFragment(int i) {
        QuestionnaireScreenController.moveQuestionEditFragment((AppCompatActivity) getActivity(), i, this.connectedMacAddress);
    }

    @OnClick({R.id.btn_answer1})
    public void onClickAnswer1ButtonClicked() {
        this.presenter.onClickAnswer1ButtonClicked();
    }

    @OnClick({R.id.btn_answer2})
    public void onClickAnswer2ButtonClicked() {
        this.presenter.onClickAnswer2ButtonClicked();
    }

    @OnClick({R.id.btn_answer3})
    public void onClickAnswer3ButtonClicked() {
        this.presenter.onClickAnswer3ButtonClicked();
    }

    @OnClick({R.id.btn_answer4})
    public void onClickAnswer4ButtonClicked() {
        this.presenter.onClickAnswer4ButtonClicked();
    }

    @OnClick({R.id.btn_answer5})
    public void onClickAnswer5ButtonClicked() {
        this.presenter.onClickAnswer5ButtonClicked();
    }

    @OnClick({R.id.btn_analysis})
    public void onAnalysisButtonClicked() {
        this.presenter.onAnalysisButtonClicked();
    }
}
