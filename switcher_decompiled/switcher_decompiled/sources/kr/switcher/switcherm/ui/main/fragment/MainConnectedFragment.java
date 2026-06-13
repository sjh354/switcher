package kr.switcher.switcherm.ui.main.fragment;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import kr.switcher.device.IODevice;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.linker.SwitcherLinker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.ga.GALogger;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.MirrorSwitchButtonPreference;
import kr.switcher.switcherm.signal.SignalFragment;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.event.SwitcherOnOffController;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.presenters.MainConnectedPresenter;
import kr.switcher.switcherm.ui.main.views.MainConnectedView;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedFragment extends SignalFragment implements MainConnectedView {
    private static final String TAG = "MainConnectedFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    @BindView(R.id.btn_one_set_off)
    ImageButton btn_one_set_off;

    @BindView(R.id.btn_one_set_on)
    ImageButton btn_one_set_on;

    @BindView(R.id.btn_two_set_bottom_off)
    ImageButton btn_two_set_bottom_off;

    @BindView(R.id.btn_two_set_bottom_on)
    ImageButton btn_two_set_bottom_on;

    @BindView(R.id.btn_two_set_top_off)
    ImageButton btn_two_set_top_off;

    @BindView(R.id.btn_two_set_top_on)
    ImageButton btn_two_set_top_on;
    private SwitcherOnOffController controller;
    private boolean isMirror;
    MirrorSwitchButtonPreference isMirrorPreference;

    @BindView(R.id.iv_model_type)
    ImageView iv_model_type;

    @BindView(R.id.lin_1set)
    LinearLayout lin_1set;

    @BindView(R.id.lin_2set)
    LinearLayout lin_2set;

    @BindView(R.id.pb_waiting)
    ProgressBar pb_waiting;
    private MainConnectedPresenter presenter;

    @BindView(R.id.rl_stroke_setting)
    RelativeLayout rl_stroke_setting;

    @BindView(R.id.rl_timer_setting)
    RelativeLayout rl_timer_setting;
    private Switcher switcher;

    public MainConnectedFragment() {
        MirrorSwitchButtonPreference mirrorSwitchButtonPreference = new MirrorSwitchButtonPreference();
        this.isMirrorPreference = mirrorSwitchButtonPreference;
        this.isMirror = mirrorSwitchButtonPreference.getMirrorSwitchButtonChecked();
    }

    public static MainConnectedFragment newInstance(String str, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainConnectedFragment mainConnectedFragment = new MainConnectedFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        mainConnectedFragment.setArguments(bundle);
        return mainConnectedFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_connected, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("CONNECTED_MAC_ADDRESS") : null;
        if (string == null) {
            return viewInflate;
        }
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(string);
        this.switcher = switcher;
        if (switcher == null) {
            return viewInflate;
        }
        this.controller = new SwitcherOnOffController(this.switcher);
        MainConnectedPresenter mainConnectedPresenter = new MainConnectedPresenter(this);
        this.presenter = mainConnectedPresenter;
        mainConnectedPresenter.initialize(this.switcher.getMacAddress(), this.switcher.getProductId(), this.switcher.getBattery());
        return viewInflate;
    }

    @Override // kr.switcher.switcherm.signal.SignalFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.switcher.getMacAddress(), this.switcher.getProductId(), this.switcher.getBattery());
        this.presenter.initialize(this.switcher.getMacAddress(), this.switcher.getProductId(), this.switcher.getBattery());
        this.isMirror = this.isMirrorPreference.getMirrorSwitchButtonChecked();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MainConnectedPresenter mainConnectedPresenter = this.presenter;
        if (mainConnectedPresenter != null) {
            mainConnectedPresenter.onDestroyView();
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackConnectedForGA() {
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_3));
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackConnectingTimeForGA() {
        IOLog.reportConnectingTime(this.switcher.getMacAddress());
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackLightingOneSetOff() {
        IOLog.i(TAG, "onOneSetOffButtonTouched", GALogger.SWITCH_LIGHTING_TYPE1_OFF);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackLightingOneSetOn() {
        IOLog.i(TAG, "onOneSetOffButtonTouched", GALogger.SWITCH_LIGHTING_TYPE1_ON);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackLightingTwoSetOneOff() {
        IOLog.i(TAG, "onTwoSetTopOffButtonTouched", GALogger.SWITCH_LIGHTING_TYPE2_1WAY_OFF);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackLightingTwoSetOneOn() {
        IOLog.i(TAG, "onTwoSetTopOnButtonTouched", GALogger.SWITCH_LIGHTING_TYPE2_1WAY_ON);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackLightingTwoSetTwoOff() {
        IOLog.i(TAG, "onTwoSetBottomOffButtonTouched", GALogger.SWITCH_LIGHTING_TYPE2_2WAY_OFF);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void trackLightingTwoSetTwoOn() {
        IOLog.i(TAG, "onTwoSetBottomOnButtonTouched", GALogger.SWITCH_LIGHTING_TYPE2_2WAY_ON);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showOneSetView() {
        this.lin_1set.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void hideOneSetView() {
        this.lin_1set.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetView() {
        this.lin_2set.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void hideTwoSetView() {
        this.lin_2set.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showChangedOneButtonImage() {
        float rotationY = this.btn_one_set_on.getRotationY();
        float rotationY2 = this.btn_one_set_off.getRotationY();
        if (rotationY != 180.0f) {
            this.btn_one_set_on.setRotationY(180.0f);
        }
        this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_off_default);
        if (rotationY2 != 180.0f) {
            this.btn_one_set_off.setRotationY(180.0f);
        }
        this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_on_default);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showChangedTwoButtonImage() {
        float rotationY = this.btn_two_set_top_on.getRotationY();
        float rotationY2 = this.btn_two_set_top_off.getRotationY();
        float rotationY3 = this.btn_two_set_bottom_on.getRotationY();
        float rotationY4 = this.btn_two_set_bottom_off.getRotationY();
        if (rotationY != 180.0f) {
            this.btn_two_set_top_on.setRotationY(180.0f);
        }
        this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_off_default);
        if (rotationY2 != 180.0f) {
            this.btn_two_set_top_off.setRotationY(180.0f);
        }
        this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_on_default);
        if (rotationY3 != 180.0f) {
            this.btn_two_set_bottom_on.setRotationY(180.0f);
        }
        this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_off_default);
        if (rotationY4 != 180.0f) {
            this.btn_two_set_bottom_off.setRotationY(180.0f);
        }
        this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_on_default);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showNormalOneButtonImage() {
        float rotationY = this.btn_one_set_on.getRotationY();
        float rotationY2 = this.btn_one_set_off.getRotationY();
        if (rotationY == 180.0f) {
            this.btn_one_set_on.setRotationY(0.0f);
        }
        this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_off_default);
        if (rotationY2 == 180.0f) {
            this.btn_one_set_off.setRotationY(0.0f);
        }
        this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_on_default);
        this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_on_default);
        this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_off_default);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showNormalTwoButtonImage() {
        float rotationY = this.btn_two_set_top_on.getRotationY();
        float rotationY2 = this.btn_two_set_top_off.getRotationY();
        float rotationY3 = this.btn_two_set_bottom_on.getRotationY();
        float rotationY4 = this.btn_two_set_bottom_off.getRotationY();
        if (rotationY == 180.0f) {
            this.btn_two_set_top_on.setRotationY(0.0f);
        }
        this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_on_default);
        if (rotationY2 == 180.0f) {
            this.btn_two_set_top_off.setRotationY(0.0f);
        }
        this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_off_default);
        if (rotationY3 == 180.0f) {
            this.btn_two_set_bottom_on.setRotationY(0.0f);
        }
        this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_on_default);
        if (rotationY4 == 180.0f) {
            this.btn_two_set_bottom_off.setRotationY(0.0f);
        }
        this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_off_default);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showOneSetOffSwitchDefault() {
        if (!this.isMirror) {
            this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_off_default);
        } else {
            this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_on_default);
            this.btn_one_set_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showOneSetOffSwitchPressed() {
        if (!this.isMirror) {
            this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_off_pressed);
        } else {
            this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_on_pressed);
            this.btn_one_set_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showOneSetOffSwitchSpring() {
        if (!this.isMirror) {
            this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_off_spring);
        } else {
            this.btn_one_set_off.setBackgroundResource(R.drawable.btn_one_on_spring);
            this.btn_one_set_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showOneSetOnSwitchDefault() {
        if (!this.isMirror) {
            this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_on_default);
        } else {
            this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_off_default);
            this.btn_one_set_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showOneSetOnSwitchPressed() {
        if (!this.isMirror) {
            this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_on_pressed);
        } else {
            this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_off_pressed);
            this.btn_one_set_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showOneSetOnSwitchSpring() {
        if (!this.isMirror) {
            this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_on_spring);
        } else {
            this.btn_one_set_on.setBackgroundResource(R.drawable.btn_one_off_spring);
            this.btn_one_set_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetTopOffSwitchDefault() {
        if (!this.isMirror) {
            this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_off_default);
        } else {
            this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_on_default);
            this.btn_two_set_top_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetTopOffSwitchPressed() {
        if (!this.isMirror) {
            this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_off_pressed);
        } else {
            this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_on_pressed);
            this.btn_two_set_top_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetTopOffSwitchSpring() {
        if (!this.isMirror) {
            this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_off_spring);
        } else {
            this.btn_two_set_top_off.setBackgroundResource(R.drawable.btn_two_on_spring);
            this.btn_two_set_top_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetTopOnSwitchDefault() {
        if (!this.isMirror) {
            this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_on_default);
        } else {
            this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_off_default);
            this.btn_two_set_top_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetTopOnSwitchPressed() {
        if (!this.isMirror) {
            this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_on_pressed);
        } else {
            this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_off_pressed);
            this.btn_two_set_top_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetTopOnSwitchSpring() {
        if (!this.isMirror) {
            this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_on_spring);
        } else {
            this.btn_two_set_top_on.setBackgroundResource(R.drawable.btn_two_off_spring);
            this.btn_two_set_top_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetBottomOffSwitchDefault() {
        if (!this.isMirror) {
            this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_off_default);
        } else {
            this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_on_default);
            this.btn_two_set_bottom_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetBottomOffSwitchPressed() {
        if (!this.isMirror) {
            this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_off_pressed);
        } else {
            this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_on_pressed);
            this.btn_two_set_bottom_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetBottomOffSwitchSpring() {
        if (!this.isMirror) {
            this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_off_spring);
        } else {
            this.btn_two_set_bottom_off.setBackgroundResource(R.drawable.btn_two_on_spring);
            this.btn_two_set_bottom_off.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetBottomOnSwitchDefault() {
        if (!this.isMirror) {
            this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_on_default);
        } else {
            this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_off_default);
            this.btn_two_set_bottom_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetBottomOnSwitchPressed() {
        if (!this.isMirror) {
            this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_on_pressed);
        } else {
            this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_off_pressed);
            this.btn_two_set_bottom_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showTwoSetBottomOnSwitchSpring() {
        if (!this.isMirror) {
            this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_on_spring);
        } else {
            this.btn_two_set_bottom_on.setBackgroundResource(R.drawable.btn_two_off_spring);
            this.btn_two_set_bottom_on.setRotationY(180.0f);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showLowBatteryDialogView(int i) {
        try {
            IODialogController.showLowBatteryDialog(getContext(), i);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showProgressbar() {
        if (this.switcher.getClass().equals(SwitcherLinker.class)) {
            IOUtil.showProgressbarDialog(getActivity(), this.pb_waiting, 10000);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void sendMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        MainScreenController.OnMainDataResultCallback onMainDataResultCallback = callback;
        if (onMainDataResultCallback != null) {
            onMainDataResultCallback.onMainData(str, productId, str2, str3, mainBackgroundState);
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void hideProgressbar() {
        IOUtil.hideProgressbarDialog(getActivity(), this.pb_waiting);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void onOneSetOff() {
        this.controller.onOneSetOff(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void onOneSetOn() {
        this.controller.onOneSetOn(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void onTwoSetOneOff() {
        this.controller.onTwoSetOneOff(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void onTwoSetOneOn() {
        this.controller.onTwoSetOneOn(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void onTwoSetTwoOff() {
        this.controller.onTwoSetTwoOff(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void onTwoSetTwoOn() {
        this.controller.onTwoSetTwoOn(this.presenter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void setBluetoothIcon() {
        this.iv_model_type.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void setGatewayIcon() {
        this.iv_model_type.setBackground(IOUtil.makeDrawable(R.drawable.ic_gateway_default));
    }

    @OnTouch({R.id.btn_one_set_off})
    public boolean onOneSetOffButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onOneSetOffButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_one_set_on})
    public boolean onOneSetOnButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onOneSetOnButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_two_set_top_off})
    public boolean onTwoSetTopOffButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onTwoSetTopOffButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_two_set_top_on})
    public boolean onTwoSetTopOnButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onTwoSetTopOnButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_two_set_bottom_off})
    public boolean onTwoSetBottomOffButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onTwoSetBottomOffButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_two_set_bottom_on})
    public boolean onTwoSetBottomOnButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onTwoSetBottomOnButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnClick({R.id.btn_timer_setting})
    public void onMoveTimerSettingMenuButtonClicked() {
        ActivityController.moveSettingReservationMenuActivity(getActivity(), this.switcher.getMacAddress());
    }

    @OnClick({R.id.btn_stroke_setting})
    public void onMoveStrokeSettingMenuButtonClicked() {
        ActivityController.moveSettingStrokeMenuActivity(getActivity(), this.switcher.getMacAddress());
    }

    @OnClick({R.id.btn_setting})
    public void onMoveSettingMenuButtonClicked() {
        ActivityController.moveSettingMenuActivity(getActivity(), this.switcher.getMacAddress());
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void hideTimerSettingMenu() {
        this.rl_timer_setting.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public void hideStrokeSettingMenu() {
        this.rl_stroke_setting.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedView
    public Bitmap rotateImage(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
