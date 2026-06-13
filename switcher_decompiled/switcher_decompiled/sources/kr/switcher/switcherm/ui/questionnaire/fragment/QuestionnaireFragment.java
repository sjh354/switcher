package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.OnSelectItemListener;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireData;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireScreenController;
import kr.switcher.switcherm.ui.questionnaire.indicator.QuestionnaireIndicator;
import kr.switcher.switcherm.ui.questionnaire.pager.CardFragmentPagerAdapter;
import kr.switcher.switcherm.ui.questionnaire.pager.ShadowTransformer;
import kr.switcher.switcherm.ui.questionnaire.presenter.QuestionnairePresenter;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireFragment extends Fragment implements QuestionnaireView, OnSelectItemListener {

    @BindView(R.id.btn_submit)
    TextView btn_submit;
    private ShadowTransformer cardShadowTransformer;
    private String connectedMacAddress;
    private CountDownTimer countDownTimer;
    private CardFragmentPagerAdapter fragmentCardAdapter;

    @BindView(R.id.indicator)
    QuestionnaireIndicator indicator;
    private QuestionnairePresenter presenter;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    public static QuestionnaireFragment newInstance(String str) {
        QuestionnaireFragment questionnaireFragment = new QuestionnaireFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        questionnaireFragment.setArguments(bundle);
        return questionnaireFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_questionnaire, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        QuestionnairePresenter questionnairePresenter = new QuestionnairePresenter(this);
        this.presenter = questionnairePresenter;
        questionnairePresenter.initialize();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.presenter.onPause();
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void trackQuestionnaireForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_0));
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void inactiveSubmit() {
        this.btn_submit.setTextColor(IOUtil.getColorResource(R.color.off_blue));
        this.btn_submit.setSelected(false);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void activeSubmit() {
        this.btn_submit.setTextColor(IOUtil.getColorResource(R.color.white));
        this.btn_submit.setSelected(true);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void initViewPager() {
        CardFragmentPagerAdapter cardFragmentPagerAdapter = new CardFragmentPagerAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager(), IOUtil.dpToPixels(2), this);
        this.fragmentCardAdapter = cardFragmentPagerAdapter;
        cardFragmentPagerAdapter.addCardFragment(new QuestionCard1Fragment());
        this.fragmentCardAdapter.addCardFragment(new QuestionCard2Fragment());
        this.fragmentCardAdapter.addCardFragment(new QuestionCard3Fragment());
        this.fragmentCardAdapter.addCardFragment(new QuestionCard4Fragment());
        this.fragmentCardAdapter.addCardFragment(new QuestionCard5Fragment());
        this.cardShadowTransformer = new ShadowTransformer(this.viewpager, this.fragmentCardAdapter);
        this.viewpager.setAdapter(this.fragmentCardAdapter);
        this.indicator.setViewPager(this.viewpager);
        this.viewpager.setPageTransformer(false, this.cardShadowTransformer);
        this.viewpager.setOffscreenPageLimit(3);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void setPagerListener() {
        this.viewpager.addOnPageChangeListener(this.presenter.onPageChangeListener());
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void setCurrentItem(int i) {
        this.viewpager.setCurrentItem(i, true);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.OnSelectItemListener
    public void onSelectItem(int i) {
        this.presenter.selectItem(i);
    }

    @OnClick({R.id.btn_submit})
    public void onSubmitButtonClicked() {
        this.presenter.onSubmitButtonClicked(this.btn_submit.isSelected());
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [kr.switcher.switcherm.ui.questionnaire.fragment.QuestionnaireFragment$1] */
    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void startTimer() {
        final QuestionnaireData questionnaireData = new QuestionnaireData();
        this.countDownTimer = new CountDownTimer(6000000L, 1000L) { // from class: kr.switcher.switcherm.ui.questionnaire.fragment.QuestionnaireFragment.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                QuestionnaireFragment.this.indicator.checkItem();
                if (questionnaireData.isFull()) {
                    cancel();
                    QuestionnaireFragment.this.presenter.full();
                }
            }
        }.start();
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void cancelTimer() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireView
    public void finishFragment() {
        QuestionnaireScreenController.moveSummaryFragment((AppCompatActivity) getActivity(), this.connectedMacAddress);
    }
}
