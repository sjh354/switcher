package kr.switcher.switcherm.ui.irbrand.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.irbrand.IRBrandActivity;
import kr.switcher.switcherm.ui.irbrand.IRBrandProductScreenController;
import kr.switcher.switcherm.ui.irbrand.adapter.IRBrandProductSelectAdapter;
import kr.switcher.switcherm.ui.irbrand.helper.ControllerItem;
import kr.switcher.switcherm.ui.irbrand.helper.PageViewer;
import kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor;
import kr.switcher.switcherm.ui.irbrand.presenter.IRBrandProductSelectPresenter;
import kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView;
import kr.switcher.switcherm.ui.irbrand.viewpager.IRBrandViewPager;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import me.relex.circleindicator.CircleIndicator;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandProductSelectFragment extends Fragment implements IRBrandProductSelectView, IRControllerInteractor.OnGetControllerListener, TextWatcher, TextView.OnEditorActionListener, IRControllerInteractor.OnCreateRemoconListener {
    private final float OPACITY_HALF = 0.5f;
    private final float OPACITY_ONE = 1.0f;

    @BindView(R.id.btn_controller_register)
    TextView btn_controller_register;

    @BindView(R.id.ci_propose)
    CircleIndicator ci_propose;
    private List<ControllerItem> controllerItemList;
    private int currentPosition;

    @BindView(R.id.et_controller_name)
    EditText et_controller_name;

    @BindView(R.id.iv_left_arrow_btn)
    ImageView iv_left_arrow_btn;

    @BindView(R.id.iv_right_arrow_btn)
    ImageView iv_right_arrow_btn;
    private IRBrandProductSelectAdapter pagerAdapter;
    private IRBrandProductSelectPresenter presenter;

    @BindView(R.id.rl_left_arrow_btn)
    RelativeLayout rl_left_arrow_btn;

    @BindView(R.id.rl_right_arrow_btn)
    RelativeLayout rl_right_arrow_btn;

    @BindView(R.id.tv_controller_name)
    TextView tv_controller_name;

    @BindView(R.id.vp_propose)
    IRBrandViewPager vp_propose;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor.OnGetControllerListener, kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor.OnCreateRemoconListener
    public void onError(String str) {
    }

    public static IRBrandProductSelectFragment newInstance() {
        return new IRBrandProductSelectFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ir_brand_product_select, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        IRBrandProductSelectPresenter iRBrandProductSelectPresenter = new IRBrandProductSelectPresenter(this, new IRControllerInteractor(this, this));
        this.presenter = iRBrandProductSelectPresenter;
        iRBrandProductSelectPresenter.initialize();
        this.et_controller_name.addTextChangedListener(this);
        this.et_controller_name.setOnEditorActionListener(this);
        ((IRBrandActivity) getActivity()).setActivityTitle("전자제품 선택");
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void initViewPager(int i) {
        IRBrandProductSelectAdapter iRBrandProductSelectAdapter = new IRBrandProductSelectAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager(), new PageViewer(this.controllerItemList).getPage());
        this.pagerAdapter = iRBrandProductSelectAdapter;
        this.vp_propose.setAdapter(iRBrandProductSelectAdapter);
        this.vp_propose.setCurrentItem(i);
        this.ci_propose.setViewPager(this.vp_propose);
        this.pagerAdapter.notifyDataSetChanged();
        setControllerName(this.pagerAdapter.getControllerName(i));
        this.currentPosition = i;
    }

    @OnClick({R.id.btn_controller_register})
    public void onRegisterBtnClicked() {
        this.presenter.onRegisterBtnClicked(this.currentPosition, this.et_controller_name.getText().toString());
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setPagerListener(int i) {
        this.iv_right_arrow_btn.setOnClickListener(this.presenter.onClickRightArrowButtonClicked(i));
        this.iv_left_arrow_btn.setOnClickListener(this.presenter.onClickLeftArrowButtonClicked());
        this.vp_propose.addOnPageChangeListener(this.presenter.onPageChangeListener());
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setPagingEnable() {
        this.vp_propose.setPagingEnable();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setPagingDisable() {
        this.vp_propose.setPagingDisable();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setOpacityOneLeftArrowButton() {
        this.iv_left_arrow_btn.setAlpha(1.0f);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setOpacityOneRightArrowButton() {
        this.iv_right_arrow_btn.setAlpha(1.0f);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setOpacityHalfLeftArrowButton() {
        this.iv_left_arrow_btn.setAlpha(0.5f);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setOpacityHalfRightArrowButton() {
        this.iv_right_arrow_btn.setAlpha(0.5f);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void onClickRightArrowButtonClicked(int i) {
        this.presenter.setNextPosition(this.vp_propose.getCurrentItem(), i);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void onClickLeftArrowButtonClicked() {
        this.presenter.setPreviousPosition(this.vp_propose.getCurrentItem());
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setProposeCurrentItem(int i) {
        this.vp_propose.setCurrentItem(i, true);
        this.currentPosition = i;
        setControllerName(this.pagerAdapter.getControllerName(i));
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void showRightArrowButton() {
        this.rl_right_arrow_btn.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void hideLeftArrowButton() {
        this.rl_left_arrow_btn.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void showLeftArrowButton() {
        this.rl_left_arrow_btn.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void hideRightArrowButton() {
        this.rl_right_arrow_btn.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void showProposeIndicator() {
        this.ci_propose.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void hideProposeIndicator() {
        this.ci_propose.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void refreshViewPage() {
        this.pagerAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void setControllerName(String str) {
        this.tv_controller_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void inactiveRegisterButton() {
        this.btn_controller_register.setTextColor(IOUtil.getColorResource(R.color.silver_three));
        this.btn_controller_register.setBackground(IOUtil.getDrawable(R.drawable.shape_off_blue_fill));
        this.btn_controller_register.setEnabled(false);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void activeRegisterButton() {
        this.btn_controller_register.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        this.btn_controller_register.setBackground(IOUtil.getDrawable(R.drawable.shape_white_fill));
        this.btn_controller_register.setEnabled(true);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void moveIRBrandListFragment(Remocon.ControllerID controllerID, String str) {
        IRBrandProductScreenController.moveIRBrandListFragment((AppCompatActivity) getActivity(), controllerID, str);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void activityFinish() {
        getActivity().finish();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandProductSelectView
    public void moveIRCommandRegisterActivity(Remocon remocon) {
        Intent intent = new Intent(getContext(), (Class<?>) LinkerCommandRegisterActivity.class);
        intent.putExtra(LinkerCommandRegisterActivity.PARM_REMOCON_KEY, remocon.getMacAddress());
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor.OnGetControllerListener
    public void onGetController(List<ControllerItem> list) {
        this.controllerItemList = list;
        this.presenter.onGetRemoteController(list);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.interactor.IRControllerInteractor.OnCreateRemoconListener
    public void onCreateRemocon(Remocon remocon) {
        this.presenter.onCreateRemocon(remocon);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.presenter.onTextChanged(this.et_controller_name.getText().toString());
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        IOUtil.hideKeyBoard(this.et_controller_name);
        return true;
    }
}
