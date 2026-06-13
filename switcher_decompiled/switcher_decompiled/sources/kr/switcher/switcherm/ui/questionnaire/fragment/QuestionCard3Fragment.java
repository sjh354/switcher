package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.presenter.QuestionCard3Presenter;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionCard3View;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionCard3Fragment extends CardFragment implements QuestionCard3View {

    @BindView(R.id.btn_no)
    TextView btn_no;

    @BindView(R.id.btn_yes)
    TextView btn_yes;

    @BindView(R.id.cardview)
    CardView cardview;
    private QuestionCard3Presenter presenter;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.layoutResource = R.layout.fragment_question_card3_adapter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QuestionCard3Presenter questionCard3Presenter = new QuestionCard3Presenter(this);
        this.presenter = questionCard3Presenter;
        questionCard3Presenter.initialize();
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionCard3View
    public void unSelectAll() {
        this.btn_yes.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
        this.btn_no.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionCard3View
    public void selectYes() {
        this.btn_yes.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_no.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionCard3View
    public void selectNo() {
        this.btn_no.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_yes.setTextColor(IOUtil.getColorResource(R.color.slate_grey));
    }

    @OnClick({R.id.btn_yes})
    public void onYesButtonClicked() {
        this.presenter.onYesButtonClicked();
    }

    @OnClick({R.id.btn_no})
    public void onNoButtonClicked() {
        this.presenter.onNoButtonClicked();
    }
}
