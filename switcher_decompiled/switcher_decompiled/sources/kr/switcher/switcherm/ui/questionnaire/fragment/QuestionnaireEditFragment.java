package kr.switcher.switcherm.ui.questionnaire.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.questionnaire.OnSelectItemListener;
import kr.switcher.switcherm.ui.questionnaire.QuestionnaireScreenController;
import kr.switcher.switcherm.ui.questionnaire.pager.CardFragmentPagerAdapter;
import kr.switcher.switcherm.ui.questionnaire.pager.ShadowTransformer;
import kr.switcher.switcherm.ui.questionnaire.presenter.QuestionnaireEditPresenter;
import kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireEditView;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireEditFragment extends Fragment implements QuestionnaireEditView, OnSelectItemListener {
    private static final String PARM_POSITION = "POSITION";
    private ShadowTransformer cardShadowTransformer;
    private String connectedMacAddress;
    private CardFragmentPagerAdapter fragmentCardAdapter;
    private int position;
    private QuestionnaireEditPresenter presenter;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    public static QuestionnaireEditFragment newInstance(int i, String str) {
        QuestionnaireEditFragment questionnaireEditFragment = new QuestionnaireEditFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARM_POSITION, i);
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        questionnaireEditFragment.setArguments(bundle);
        return questionnaireEditFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_questionnaire_edit, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
            int i = arguments.getInt(PARM_POSITION, -1);
            this.position = i;
            if (i == -1) {
                return viewInflate;
            }
        }
        QuestionnaireEditPresenter questionnaireEditPresenter = new QuestionnaireEditPresenter(this);
        this.presenter = questionnaireEditPresenter;
        questionnaireEditPresenter.initialize(this.position);
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireEditView
    public void trackEditForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_1_0_1));
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireEditView
    public void initViewPager(CardFragment cardFragment) {
        CardFragmentPagerAdapter cardFragmentPagerAdapter = new CardFragmentPagerAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager(), IOUtil.dpToPixels(2), this);
        this.fragmentCardAdapter = cardFragmentPagerAdapter;
        cardFragmentPagerAdapter.addCardFragment(cardFragment);
        this.cardShadowTransformer = new ShadowTransformer(this.viewpager, this.fragmentCardAdapter);
        this.viewpager.setAdapter(this.fragmentCardAdapter);
        this.viewpager.setPageTransformer(false, this.cardShadowTransformer);
        this.viewpager.setOffscreenPageLimit(3);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireEditView
    public void setPagerListener() {
        this.viewpager.addOnPageChangeListener(this.presenter.onPageChangeListener());
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireEditView
    public void setCurrentItem(int i) {
        this.viewpager.setCurrentItem(i, true);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.views.QuestionnaireEditView
    public void finishFragment() {
        QuestionnaireScreenController.moveSummaryFragment((AppCompatActivity) getActivity(), this.connectedMacAddress);
    }

    @Override // kr.switcher.switcherm.ui.questionnaire.OnSelectItemListener
    public void onSelectItem(int i) {
        this.presenter.selectItem(i);
    }
}
