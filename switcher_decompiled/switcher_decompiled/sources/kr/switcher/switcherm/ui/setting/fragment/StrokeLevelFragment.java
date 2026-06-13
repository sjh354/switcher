package kr.switcher.switcherm.ui.setting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.setting.SettingActivity;
import kr.switcher.switcherm.ui.setting.adapter.StrokeLevelPagerAdapter;
import kr.switcher.switcherm.ui.setting.helper.PageViewer;
import kr.switcher.switcherm.ui.setting.presenter.StrokeLevelPresenter;
import kr.switcher.switcherm.ui.setting.view.StrokeLevelView;
import kr.switcher.switcherm.ui.setting.viewpager.StrokeLevelViewPager;
import me.relex.circleindicator.CircleIndicator;

/* JADX INFO: loaded from: classes2.dex */
public class StrokeLevelFragment extends Fragment implements StrokeLevelView, IODeviceCallbacks.StrokeLevelReadResultResponseCallback {
    private static final String TAG = "StrokeLevelFragment";
    private static SettingActivity.StrokeTestListener listener;
    private final float OPACITY_HALF = 0.5f;
    private final float OPACITY_ONE = 1.0f;

    @BindView(R.id.cb_long_level)
    CheckBox cb_long_level;

    @BindView(R.id.cb_middle_level)
    CheckBox cb_middle_level;

    @BindView(R.id.cb_small_level)
    CheckBox cb_small_level;

    @BindView(R.id.ci_propose)
    CircleIndicator ci_propose;
    private String connectedMacAddress;

    @BindView(R.id.iv_left_arrow_btn)
    ImageView iv_left_arrow_btn;

    @BindView(R.id.iv_right_arrow_btn)
    ImageView iv_right_arrow_btn;
    private StrokeLevelPagerAdapter pagerAdapter;
    private StrokeLevelPresenter presenter;

    @BindView(R.id.rl_left_arrow_btn)
    RelativeLayout rl_left_arrow_btn;

    @BindView(R.id.rl_right_arrow_btn)
    RelativeLayout rl_right_arrow_btn;
    private Switcher switcher;

    @BindView(R.id.tv_long_level)
    TextView tv_long_level;

    @BindView(R.id.tv_middle_level)
    TextView tv_middle_level;

    @BindView(R.id.tv_small_level)
    TextView tv_small_level;

    @BindView(R.id.vp_propose)
    StrokeLevelViewPager vp_propose;

    public static StrokeLevelFragment newInstance(String str, SettingActivity.StrokeTestListener strokeTestListener) {
        StrokeLevelFragment strokeLevelFragment = new StrokeLevelFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        strokeLevelFragment.setArguments(bundle);
        listener = strokeTestListener;
        return strokeLevelFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_stroke_level, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        if (!IOUtil.checkIsIODeviceKey(this.connectedMacAddress)) {
            return viewInflate;
        }
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(this.connectedMacAddress);
        this.switcher = switcher;
        if (switcher == null) {
            return viewInflate;
        }
        StrokeLevelPresenter strokeLevelPresenter = new StrokeLevelPresenter(this);
        this.presenter = strokeLevelPresenter;
        strokeLevelPresenter.initialize(this.switcher.getStrokeLevel());
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackStrokeShortLevelFotGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_2_1));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackStrokeMiddleLevelFotGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_2_0));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackStrokeLongLevelFotGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3_2_2));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackTestFingerLengthShortForGA() {
        IOLog.event(GALogger.CATEGORY_TEST_FINGER_LENGTH, GALogger.ACTION_FINGER_LENGTH_SHORT);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackTestFingerLengthMiddleForGA() {
        IOLog.event(GALogger.CATEGORY_TEST_FINGER_LENGTH, "default");
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackTestFingerLengthLongForGA() {
        IOLog.event(GALogger.CATEGORY_TEST_FINGER_LENGTH, GALogger.ACTION_FINGER_LENGTH_LONG);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackSaveFingerLengthShortForGA() {
        IOLog.event(GALogger.CATEGORY_SAVE_FINGER_LENGTH, GALogger.ACTION_FINGER_LENGTH_SHORT);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackSaveFingerLengthMiddleForGA() {
        IOLog.event(GALogger.CATEGORY_SAVE_FINGER_LENGTH, "default");
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void trackSaveFingerLengthLongForGA() {
        IOLog.event(GALogger.CATEGORY_SAVE_FINGER_LENGTH, GALogger.ACTION_FINGER_LENGTH_LONG);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void getStrokeLevel() {
        this.switcher.readStrokeLevel(this);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void initViewPager(int i) {
        StrokeLevelPagerAdapter strokeLevelPagerAdapter = new StrokeLevelPagerAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager(), new PageViewer(i).getPage());
        this.pagerAdapter = strokeLevelPagerAdapter;
        this.vp_propose.setAdapter(strokeLevelPagerAdapter);
        this.vp_propose.setPagingDisable();
        this.vp_propose.setCurrentItem(i);
        this.ci_propose.setViewPager(this.vp_propose);
        this.pagerAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setPagerListener(int i) {
        this.iv_right_arrow_btn.setOnClickListener(this.presenter.onClickRightArrowButtonClicked(i));
        this.iv_left_arrow_btn.setOnClickListener(this.presenter.onClickLeftArrowButtonClicked());
        this.vp_propose.addOnPageChangeListener(this.presenter.onPageChangeListener(this.switcher.getStrokeLevel()));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setOpacityOneLeftArrowButton() {
        this.iv_left_arrow_btn.setAlpha(1.0f);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setOpacityOneRightArrowButton() {
        this.iv_right_arrow_btn.setAlpha(1.0f);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setOpacityHalfLeftArrowButton() {
        this.iv_left_arrow_btn.setAlpha(0.5f);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setOpacityHalfRightArrowButton() {
        this.iv_right_arrow_btn.setAlpha(0.5f);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void activeSmallLevelText() {
        this.tv_small_level.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void activeMiddleLevelText() {
        this.tv_middle_level.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void activeLongLevelText() {
        this.tv_long_level.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void inactiveSmallLevelText() {
        this.tv_small_level.setTextColor(IOUtil.getColorResource(R.color.cloudy_blue_three));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void inactiveMiddleLevelText() {
        this.tv_middle_level.setTextColor(IOUtil.getColorResource(R.color.cloudy_blue_three));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void inactiveLongLevelText() {
        this.tv_long_level.setTextColor(IOUtil.getColorResource(R.color.cloudy_blue_three));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void selectSmallLevel() {
        this.cb_small_level.setBackground(IOUtil.makeDrawable(R.drawable.btn_check_box_selected));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void unselectSmallLevel() {
        this.cb_small_level.setBackground(IOUtil.makeDrawable(R.drawable.btn_check_box_empty));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void selectMiddleLevel() {
        this.cb_middle_level.setBackground(IOUtil.makeDrawable(R.drawable.btn_check_box_selected));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void unselectMiddleLevel() {
        this.cb_middle_level.setBackground(IOUtil.makeDrawable(R.drawable.btn_check_box_empty));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void selectLongLevel() {
        this.cb_long_level.setBackground(IOUtil.makeDrawable(R.drawable.btn_check_box_selected));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void unselectLongLevel() {
        this.cb_long_level.setBackground(IOUtil.makeDrawable(R.drawable.btn_check_box_empty));
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void saveStrokeLevelToDB(int i) {
        this.switcher.setStrokeLevel(i);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void checkSmallLevel() {
        this.cb_small_level.setChecked(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void uncheckSmallLevel() {
        this.cb_small_level.setChecked(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void checkMiddleLevel() {
        this.cb_middle_level.setChecked(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void uncheckMiddleLevel() {
        this.cb_middle_level.setChecked(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void checkLongLevel() {
        this.cb_long_level.setChecked(true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void uncheckLongLevel() {
        this.cb_long_level.setChecked(false);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void showLeftArrowButton() {
        this.rl_left_arrow_btn.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void showRightArrowButton() {
        this.rl_right_arrow_btn.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void hideLeftArrowButton() {
        this.rl_left_arrow_btn.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void hideRightArrowButton() {
        this.rl_right_arrow_btn.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void showProposeIndicator() {
        this.ci_propose.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void hideProposeIndicator() {
        this.ci_propose.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setPagingEnable() {
        this.vp_propose.setPagingEnable();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setPagingDisable() {
        this.vp_propose.setPagingDisable();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void onStartTest() {
        listener.onStartTest();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void onFinishTest() {
        listener.onFinishTest();
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void onClickRightArrowButtonClicked(int i) {
        this.presenter.setNextPosition(this.vp_propose.getCurrentItem(), i, this.switcher.getStrokeLevel());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void onClickLeftArrowButtonClicked() {
        this.presenter.setPreviousPosition(this.vp_propose.getCurrentItem(), this.switcher.getStrokeLevel());
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void setProposeCurrentItem(int i) {
        this.vp_propose.setCurrentItem(i, true);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void testStrokeLevel(int i) {
        this.switcher.updateStrokeLevel(i, true, null);
    }

    @Override // kr.switcher.switcherm.ui.setting.view.StrokeLevelView
    public void saveStrokeLevel(int i) {
        this.switcher.updateStrokeLevel(i, false, this.presenter);
    }

    @OnClick({R.id.cb_small_level})
    public void onStrokeLevelSmallButtonClicked() {
        this.presenter.selectItem(0, this.switcher.getStrokeLevel());
    }

    @OnClick({R.id.cb_middle_level})
    public void onStrokeLevelMiddleButtonClicked() {
        this.presenter.selectItem(1, this.switcher.getStrokeLevel());
    }

    @OnClick({R.id.cb_long_level})
    public void onStrokeLevelLongButtonClicked() {
        this.presenter.selectItem(2, this.switcher.getStrokeLevel());
    }

    public void onSaveButtonClicked() {
        this.presenter.onSaveButtonClicked();
    }

    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.StrokeLevelReadResultResponseCallback
    public void onStrokeLevelResult(int i) {
        this.presenter.onStrokeLevelResult(i);
    }
}
