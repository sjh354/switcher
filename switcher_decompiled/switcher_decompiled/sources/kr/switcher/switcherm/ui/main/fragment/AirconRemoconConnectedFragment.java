package kr.switcher.switcherm.ui.main.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.OnWheelScrollListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.tagmanager.DataLayer;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.adapter.AirconRemoconConnectedAdapter;
import kr.switcher.switcherm.ui.main.adapter.TemperatureWheelAdapter;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor;
import kr.switcher.switcherm.ui.main.presenters.AirconRemoconConnectedPresenter;
import kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconRemoconConnectedFragment extends Fragment implements AirconRemoconConnectedView, AirconRemoconConnectedAdapter.OnItemClickListener, FindAirconIRCommandInteractor.OnFindAirconIRCommandListener, OnWheelScrollListener {
    private static final String PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_ID";
    private static final String TAG = "AirconRemoconConnectedFragment";
    private static MainScreenController.OnMainDataResultCallback callback;
    private IRCommand airconOffCommand;
    private IRCommand airconOnCommand;

    @BindView(R.id.btn_air_volume)
    ImageButton btn_air_volume;

    @BindView(R.id.btn_aircon_off)
    LinearLayout btn_aircon_off;

    @BindView(R.id.btn_aircon_on)
    LinearLayout btn_aircon_on;

    @BindView(R.id.btn_custom)
    ImageButton btn_custom;

    @BindView(R.id.btn_etc)
    ImageButton btn_etc;

    @BindView(R.id.btn_hold_temperature)
    ImageButton btn_hold_temperature;

    @BindView(R.id.btn_mode)
    ImageButton btn_mode;

    @BindView(R.id.btn_reservation)
    ImageButton btn_reservation;

    @BindView(R.id.btn_widget)
    ImageButton btn_widget;
    public String clickedButton;
    private Remocon connectedRemocon;

    @BindView(R.id.pb_registering)
    AVLoadingIndicatorView pb_registering;
    private AirconRemoconConnectedPresenter presenter;
    private AirconRemoconConnectedAdapter remoconAdapter;
    private List<IRCommand> remoconCommandItemList;

    @BindView(R.id.rv_command_list)
    RecyclerView rv_command_list;
    private TemperatureWheelAdapter temperatureWheelAdapter;

    @BindView(R.id.wh_temperature)
    AbstractWheel wh_temperature;
    private List<IRCommand> airconModeCommandList = new ArrayList();
    private List<IRCommand> airconAirVolumeCommandList = new ArrayList();
    private List<IRCommand> airconETCCommandList = new ArrayList();
    private List<IRCommand> airconCustomCommandList = new ArrayList();
    private List<IRCommand> airconTemperatureCommandList = new ArrayList();

    public enum whichClicked {
        MODE,
        AIR_VOLUME,
        ETC,
        CUSTOM
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.OnFindAirconIRCommandListener
    public void onRelease(boolean z) {
    }

    @Override // antistatic.spinnerwheel.OnWheelScrollListener
    public void onScrollingStarted(AbstractWheel abstractWheel) {
    }

    @Override // antistatic.spinnerwheel.OnWheelScrollListener
    public void onScrollingFinished(AbstractWheel abstractWheel) {
        this.presenter.onScrollingFinished(abstractWheel.getCurrentItem());
    }

    public static AirconRemoconConnectedFragment newInstance(String str, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        AirconRemoconConnectedFragment airconRemoconConnectedFragment = new AirconRemoconConnectedFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARM_CONNECTED_MAC_ADDRESS, str);
        airconRemoconConnectedFragment.setArguments(bundle);
        return airconRemoconConnectedFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_aircon_remocon, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(arguments != null ? arguments.getString(PARM_CONNECTED_MAC_ADDRESS) : "");
        this.connectedRemocon = remocon;
        if (remocon == null) {
            return null;
        }
        AirconRemoconConnectedPresenter airconRemoconConnectedPresenter = new AirconRemoconConnectedPresenter(this, new FindAirconIRCommandInteractor(this));
        this.presenter = airconRemoconConnectedPresenter;
        airconRemoconConnectedPresenter.onCreateView();
        this.wh_temperature.addScrollingListener(this);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.OnFindAirconIRCommandListener
    public void onFind(List<IRCommand> list) {
        this.presenter.onFind(list, this.clickedButton);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindAirconIRCommandInteractor.OnFindAirconIRCommandListener
    public void onRemove(boolean z, String str) {
        this.presenter.onRemove(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void initWheel() {
        TemperatureWheelAdapter temperatureWheelAdapter = new TemperatureWheelAdapter(getContext());
        this.temperatureWheelAdapter = temperatureWheelAdapter;
        this.wh_temperature.setViewAdapter(temperatureWheelAdapter);
        this.temperatureWheelAdapter.add("-");
        for (int i = 19; i <= 30; i++) {
            this.temperatureWheelAdapter.add(IOUtil.convertNumberAddZero(i));
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void initRecyclerListView() {
        this.remoconCommandItemList = new ArrayList();
        this.remoconAdapter = new AirconRemoconConnectedAdapter(this.remoconCommandItemList, this);
        this.rv_command_list.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rv_command_list.setAdapter(this.remoconAdapter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setRemoconCommandItems(List<IRCommand> list) {
        this.remoconCommandItemList.clear();
        this.remoconCommandItemList.addAll(list);
        this.remoconAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void initButton() {
        this.btn_mode.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_mode_unclicked));
        this.btn_air_volume.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_air_volume_unclicked));
        this.btn_etc.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_etc_unclicked));
        this.btn_custom.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_custom_unclicked));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setModeButtonClicked() {
        this.btn_mode.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_mode_clicked));
        this.btn_air_volume.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_air_volume_unclicked));
        this.btn_etc.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_etc_unclicked));
        this.btn_custom.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_custom_unclicked));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setAirVolumeButtonClicked() {
        this.btn_mode.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_mode_unclicked));
        this.btn_air_volume.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_air_volume_clicked));
        this.btn_etc.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_etc_unclicked));
        this.btn_custom.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_custom_unclicked));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setETCButtonClicked() {
        this.btn_mode.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_mode_unclicked));
        this.btn_air_volume.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_air_volume_unclicked));
        this.btn_etc.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_etc_clicked));
        this.btn_custom.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_custom_unclicked));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setCustomButtonClicked() {
        this.btn_mode.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_mode_unclicked));
        this.btn_air_volume.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_air_volume_unclicked));
        this.btn_etc.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_etc_unclicked));
        this.btn_custom.setImageDrawable(IOUtil.getDrawable(R.drawable.btn_aircon_custom_clicked));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        callback.onMainData(str, productId, str2, str3, mainBackgroundState);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setAirconOnCommand(IRCommand iRCommand) {
        this.airconOnCommand = iRCommand;
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setAirconOffCommand(IRCommand iRCommand) {
        this.airconOffCommand = iRCommand;
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void moveIRCommandRegisterScreen() {
        Intent intent = new Intent(getContext(), (Class<?>) LinkerCommandRegisterActivity.class);
        intent.putExtra(LinkerCommandRegisterActivity.PARM_REMOCON_KEY, this.connectedRemocon.getMacAddress());
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void initCommandList() {
        this.airconCustomCommandList.clear();
        this.airconModeCommandList.clear();
        this.airconETCCommandList.clear();
        this.airconAirVolumeCommandList.clear();
        this.airconTemperatureCommandList.clear();
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void notifyDataSetChanged() {
        this.remoconAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    @OnClick({R.id.btn_mode})
    public void onModeButtonClicked() {
        String strValueOf = String.valueOf(whichClicked.MODE);
        this.clickedButton = strValueOf;
        this.presenter.commandCategoryButtonClicked(strValueOf, this.airconModeCommandList);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    @OnClick({R.id.btn_air_volume})
    public void onAirVolumeButtonClicked() {
        String strValueOf = String.valueOf(whichClicked.AIR_VOLUME);
        this.clickedButton = strValueOf;
        this.presenter.commandCategoryButtonClicked(strValueOf, this.airconAirVolumeCommandList);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    @OnClick({R.id.btn_etc})
    public void onETCButtonClicked() {
        String strValueOf = String.valueOf(whichClicked.ETC);
        this.clickedButton = strValueOf;
        this.presenter.commandCategoryButtonClicked(strValueOf, this.airconETCCommandList);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    @OnClick({R.id.btn_custom})
    public void onCustomButtonClicked() {
        String strValueOf = String.valueOf(whichClicked.CUSTOM);
        this.clickedButton = strValueOf;
        this.presenter.commandCategoryButtonClicked(strValueOf, this.airconCustomCommandList);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void showInfoDialog(final int i) {
        new MaterialDialog.Builder(getContext()).title(this.remoconCommandItemList.get(i).getName() + " 명령어 삭제").items(DataLayer.listOf("명령어 삭제")).itemsCallback(new MaterialDialog.ListCallback() { // from class: kr.switcher.switcherm.ui.main.fragment.AirconRemoconConnectedFragment.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
            public void onSelection(MaterialDialog materialDialog, View view, int i2, CharSequence charSequence) {
                AirconRemoconConnectedFragment.this.presenter.onSelection(AirconRemoconConnectedFragment.this.remoconAdapter.getItem(i));
            }
        }).show();
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void setCommandList(List<IRCommand> list, List<IRCommand> list2, List<IRCommand> list3, List<IRCommand> list4, List<IRCommand> list5) {
        this.airconModeCommandList = list;
        this.airconAirVolumeCommandList = list2;
        this.airconETCCommandList = list3;
        this.airconCustomCommandList = list4;
        this.airconTemperatureCommandList = list5;
        this.remoconAdapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public List<IRCommand> getAirconTemperatureCommandList() {
        return this.airconTemperatureCommandList;
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public String getCurrentTemperature(int i) {
        return this.temperatureWheelAdapter.get(i);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void showProgressbar(int i) {
        IOUtil.showProgressbarDialog(getActivity(), this.pb_registering, i);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void showProgressbar() {
        this.pb_registering.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void hideProgressbar() {
        IOUtil.hideProgressbarDialog(getActivity(), this.pb_registering);
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public String getCommandName(int i) {
        return this.remoconCommandItemList.get(i).getName();
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void showReservationBadge() {
        this.btn_reservation.setBackground(IOUtil.getDrawable(R.drawable.btn_aircon_reservation_with_new_badge));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void hideReservationBadge() {
        this.btn_reservation.setBackground(IOUtil.getDrawable(R.drawable.btn_alarm_default));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void showMaintenanceBadge() {
        this.btn_hold_temperature.setBackground(IOUtil.getDrawable(R.drawable.btn_maintenance_with_badge));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void hideMaintenanceBadge() {
        this.btn_hold_temperature.setBackground(IOUtil.getDrawable(R.drawable.selector_setting_hold_temperature));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void showWidgetBadge() {
        this.btn_widget.setBackground(IOUtil.getDrawable(R.drawable.btn_aircon_widget_with_badge));
    }

    @Override // kr.switcher.switcherm.ui.main.views.AirconRemoconConnectedView
    public void hideWidgetBadge() {
        this.btn_widget.setBackground(IOUtil.getDrawable(R.drawable.btn_aircon_widget_without_badge));
    }

    @OnClick({R.id.btn_reservation})
    public void onReservationButtonClicked() {
        this.presenter.onReservationButtonClicked();
        ActivityController.moveSettingAirconReservationMenuActivity(getActivity(), this.connectedRemocon.getMacAddress());
    }

    @OnClick({R.id.btn_hold_temperature})
    public void onHoldTemperatureButtonClicked() {
        this.presenter.onHoldTemperatureButtonClicked();
        ActivityController.moveSettingAirconMaintainingTemperatureMenuActivity(getActivity(), this.connectedRemocon.getMacAddress());
    }

    @OnClick({R.id.btn_widget})
    public void onWidgetButtonClicked() {
        this.presenter.onWidgetButtonClicked();
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.widget_cafe_link))));
    }

    @OnClick({R.id.btn_aircon_on})
    public void onAirconONButtonClicked() {
        this.presenter.onAirconONButtonClicked(this.airconOnCommand);
    }

    @OnClick({R.id.btn_aircon_off})
    public void onAirconOFFButtonClicked() {
        this.presenter.onAirconOFFButtonClicked(this.airconOffCommand);
    }

    @Override // kr.switcher.switcherm.ui.main.adapter.AirconRemoconConnectedAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.remoconAdapter.getItem(i));
    }

    @Override // kr.switcher.switcherm.ui.main.adapter.AirconRemoconConnectedAdapter.OnItemClickListener
    public void onItemLongClick(int i) {
        this.presenter.onItemLongClick(i);
    }
}
