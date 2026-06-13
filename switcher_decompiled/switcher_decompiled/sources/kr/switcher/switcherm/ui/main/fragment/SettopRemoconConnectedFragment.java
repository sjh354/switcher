package kr.switcher.switcherm.ui.main.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.adapter.SettopRemoconCommandAdapter;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor;
import kr.switcher.switcherm.ui.main.presenters.SettopRemoconConnectedPresenter;
import kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView;

/* JADX INFO: loaded from: classes2.dex */
public class SettopRemoconConnectedFragment extends Fragment implements SettopRemoconConnectedView, SettopRemoconCommandAdapter.OnItemClickListener, FindIRCommandInteractor.OnFindIRCommandListener {
    private static final String PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_ID";
    private static final String TAG = "SettopRemoconConnectedFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    @BindView(R.id.btn_reservation)
    ImageButton btn_reservation;

    @BindView(R.id.btn_tv_cancel)
    ImageButton btn_tv_cancel;

    @BindView(R.id.btn_tv_channel)
    ImageButton btn_tv_channel;

    @BindView(R.id.btn_tv_channel_down)
    ImageButton btn_tv_channel_down;

    @BindView(R.id.btn_tv_channel_up)
    ImageButton btn_tv_channel_up;

    @BindView(R.id.btn_tv_confirm)
    ImageButton btn_tv_confirm;

    @BindView(R.id.btn_tv_down)
    ImageButton btn_tv_down;

    @BindView(R.id.btn_tv_left)
    ImageButton btn_tv_left;

    @BindView(R.id.btn_tv_power)
    ImageButton btn_tv_power;

    @BindView(R.id.btn_tv_previous)
    ImageButton btn_tv_previous;

    @BindView(R.id.btn_tv_right)
    ImageButton btn_tv_right;

    @BindView(R.id.btn_tv_timetable)
    ImageButton btn_tv_timetable;

    @BindView(R.id.btn_tv_up)
    ImageButton btn_tv_up;

    @BindView(R.id.btn_tv_volume_down)
    ImageButton btn_tv_volume_down;

    @BindView(R.id.btn_tv_volume_up)
    ImageButton btn_tv_volume_up;

    @BindView(R.id.btn_widget)
    ImageButton btn_widget;
    private Remocon connectedRemocon;
    private List<IRCommand> customTestCommands;

    @BindView(R.id.pb_registering)
    AVLoadingIndicatorView pb_registering;
    private SettopRemoconConnectedPresenter presenter;
    private SettopRemoconCommandAdapter remoconAdapter;

    @BindView(R.id.rv_command_list)
    RecyclerView rv_command_list;
    private List<IRCommand> manualCommands = new ArrayList();
    private List<IRCommand> customCommands = new ArrayList();
    private List<IRCommand> numberCommands = new ArrayList();

    public static SettopRemoconConnectedFragment newInstance(String str, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        SettopRemoconConnectedFragment settopRemoconConnectedFragment = new SettopRemoconConnectedFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARM_CONNECTED_MAC_ADDRESS, str);
        settopRemoconConnectedFragment.setArguments(bundle);
        return settopRemoconConnectedFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_settop_remocon, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(arguments != null ? arguments.getString(PARM_CONNECTED_MAC_ADDRESS) : "");
        this.connectedRemocon = remocon;
        if (remocon == null) {
            return null;
        }
        SettopRemoconConnectedPresenter settopRemoconConnectedPresenter = new SettopRemoconConnectedPresenter(this, new FindIRCommandInteractor(this));
        this.presenter = settopRemoconConnectedPresenter;
        settopRemoconConnectedPresenter.onCreateView();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onFind(List<IRCommand> list) {
        this.presenter.onFind(list);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onRelease(boolean z) {
        showProgressbar(1000);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onRemove(boolean z, String str) {
        this.presenter.onRemove(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onCHRelease(boolean z, String str, String str2) {
        this.presenter.onChannelIRRelease(str2);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void initRecyclerListView() {
        this.customTestCommands = new ArrayList();
        this.remoconAdapter = new SettopRemoconCommandAdapter(this.customTestCommands, this);
        this.rv_command_list.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rv_command_list.setAdapter(this.remoconAdapter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void setRemoconCommandItems(List<IRCommand> list) {
        for (int i = 0; i < list.size(); i++) {
            IOLog.i(TAG, "custom commands : " + list.size() + "name : " + list.get(i).getName());
        }
        this.customTestCommands.clear();
        this.customTestCommands.addAll(list);
        this.remoconAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        callback.onMainData(str, productId, str2, str3, mainBackgroundState);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void moveIRCommandRegisterScreen() {
        Intent intent = new Intent(getContext(), (Class<?>) LinkerCommandRegisterActivity.class);
        intent.putExtra(LinkerCommandRegisterActivity.PARM_REMOCON_KEY, this.connectedRemocon.getMacAddress());
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void initCommandList() {
        this.customTestCommands.clear();
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void notifyDataSetChanged() {
        this.remoconAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showInfoDialog(final int i) {
        new MaterialDialog.Builder(getContext()).content(this.customTestCommands.get(i).getName() + " 명령어를 삭제 하시겠습니까?").positiveText("예").negativeText("아니오").negativeColor(getResources().getColor(R.color.periwinkle)).positiveColor(getResources().getColor(R.color.periwinkle)).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                SettopRemoconConnectedFragment.this.presenter.onSelection(SettopRemoconConnectedFragment.this.remoconAdapter.getItem(i));
                SettopRemoconConnectedFragment.this.showProgressbar(1000);
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void setCommandList(List<IRCommand> list, List<IRCommand> list2, List<IRCommand> list3) {
        this.manualCommands = list;
        this.numberCommands = list2;
        this.customCommands = list3;
        this.remoconAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showProgressbar(int i) {
        IOUtil.showProgressbarDialog(getActivity(), this.pb_registering, i);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showProgressbar() {
        this.pb_registering.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void hideProgressbar() {
        IOUtil.hideProgressbarDialog(getActivity(), this.pb_registering);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public String getCommandName(int i) {
        return this.customTestCommands.get(i).getName();
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showReservationBadge() {
        this.btn_reservation.setBackground(IOUtil.getDrawable(R.drawable.btn_aircon_reservation_with_new_badge));
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void hideReservationBadge() {
        this.btn_reservation.setBackground(IOUtil.getDrawable(R.drawable.btn_alarm_default));
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showWidgetBadge() {
        this.btn_widget.setBackground(IOUtil.getDrawable(R.drawable.btn_aircon_widget_with_badge));
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void hideWidgetBadge() {
        this.btn_widget.setBackground(IOUtil.getDrawable(R.drawable.btn_aircon_widget_without_badge));
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showVolumeUpButtonDefault() {
        this.btn_tv_volume_up.setBackgroundResource(R.drawable.btn_volume_up);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showVolumeUpButtonPressed() {
        this.btn_tv_volume_up.setBackgroundResource(R.drawable.btn_volume_up_pressed);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showVolumeUpButtonSpring() {
        this.btn_tv_volume_up.setBackgroundResource(R.drawable.btn_volume_up_spring);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showVolumeDownButtonDefault() {
        this.btn_tv_volume_down.setBackgroundResource(R.drawable.btn_volume_down);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showVolumeDwonButtonPressed() {
        this.btn_tv_volume_down.setBackgroundResource(R.drawable.btn_volume_down_pressed);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showVolumeDownButtonSpring() {
        this.btn_tv_volume_down.setBackgroundResource(R.drawable.btn_volume_down_spring);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showChannelUpButtonDefault() {
        this.btn_tv_channel_up.setBackgroundResource(R.drawable.btn_channel_up);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showChannelUpButtonPressed() {
        this.btn_tv_channel_up.setBackgroundResource(R.drawable.btn_channel_up_pressed);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showChannelUpButtonSpring() {
        this.btn_tv_channel_up.setBackgroundResource(R.drawable.btn_channel_up_spring);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showChannelDownButtonDefault() {
        this.btn_tv_channel_down.setBackgroundResource(R.drawable.btn_channel_down);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showChannelDownButtonPressed() {
        this.btn_tv_channel_down.setBackgroundResource(R.drawable.btn_channel_down_pressed);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showChannelDownButtonSpring() {
        this.btn_tv_channel_down.setBackgroundResource(R.drawable.btn_channel_down_spring);
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void onReleaseIR(String str) {
        this.presenter.onReleaseIR(str);
    }

    @Override // kr.switcher.switcherm.ui.main.adapter.SettopRemoconCommandAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.remoconAdapter.getItem(i));
    }

    @Override // kr.switcher.switcherm.ui.main.adapter.SettopRemoconCommandAdapter.OnItemClickListener
    public void onItemLongClick(int i) {
        this.presenter.onItemLongClick(i);
    }

    @OnClick({R.id.btn_reservation})
    public void onReservationButtonClicked() {
        this.presenter.onReservationButtonClicked();
        ActivityController.moveSettingSettopReservationMenuActivity(getActivity(), this.connectedRemocon.getMacAddress());
    }

    @OnClick({R.id.btn_widget})
    public void onWidgetButtonClicked() {
        this.presenter.onWidgetButtonClicked();
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.widget_cafe_link))));
    }

    @OnClick({R.id.btn_tv_up})
    public void onUpButtonClicked() {
        this.presenter.onUpButtonClicked();
    }

    @OnClick({R.id.btn_tv_down})
    public void onDownButtonClicked() {
        this.presenter.onDownButtonClicked();
    }

    @OnClick({R.id.btn_tv_left})
    public void onLeftButtonClicked() {
        this.presenter.onLeftButtonClicked();
    }

    @OnClick({R.id.btn_tv_right})
    public void onRightButtonClicked() {
        this.presenter.onRightButtonClicked();
    }

    @OnClick({R.id.btn_tv_confirm})
    public void onConfirmButtonClicked() {
        this.presenter.onConfirmButtonClicked();
    }

    @OnClick({R.id.btn_tv_previous})
    public void onPreviousButtonClicked() {
        this.presenter.onPreviousButtonClicked();
    }

    @OnClick({R.id.btn_tv_cancel})
    public void onCancelButtonClicked() {
        this.presenter.onCancelButtonClicked();
    }

    @OnClick({R.id.btn_tv_timetable})
    public void onTimeTableButtonClicked() {
        this.presenter.onTimeTableButtonClicked();
    }

    @OnClick({R.id.btn_tv_power})
    public void onPowerButtonClicked() {
        this.presenter.onPowerButtonClicked();
    }

    @OnClick({R.id.btn_tv_channel})
    public void onChannelButtonClicked() {
        this.presenter.onChannelButtonClicked();
    }

    @OnTouch({R.id.btn_tv_volume_up})
    public boolean onVolumeUpButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onVolumeUpButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_tv_volume_down})
    public boolean onVolumeDownButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onVolumeDownButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_tv_channel_up})
    public boolean onChannelUpButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onChannelUpButtonTouched(motionEvent.getAction());
        return true;
    }

    @OnTouch({R.id.btn_tv_channel_down})
    public boolean onChannelDownButtonTouched(View view, MotionEvent motionEvent) {
        this.presenter.onChannelDownButtonTouched(motionEvent.getAction());
        return true;
    }

    @Override // kr.switcher.switcherm.ui.main.views.SettopRemoconConnectedView
    public void showChannelDialog() {
        new MaterialDialog.Builder(getContext()).content("채널을 입력하세요").input((CharSequence) "숫자만입력하세요", (CharSequence) null, true, new MaterialDialog.InputCallback() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment.4
            @Override // com.afollestad.materialdialogs.MaterialDialog.InputCallback
            public void onInput(MaterialDialog materialDialog, CharSequence charSequence) {
            }
        }).inputType(2).positiveText("전송").negativeColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.main.fragment.SettopRemoconConnectedFragment.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                String strValueOf = String.valueOf(materialDialog.getInputEditText().getText());
                if (strValueOf.length() > 0) {
                    SettopRemoconConnectedFragment.this.presenter.onChannelIRRelease(strValueOf);
                } else {
                    IOUtil.showToast("채널을 입력해주세요");
                }
            }
        }).show();
    }
}
