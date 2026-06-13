package kr.switcher.switcherm.ui.switcherList.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.switcherList.interactors.SwitcherItemListInteractor;
import kr.switcher.switcherm.ui.switcherList.presenters.SwitcherAdapterPresenter;
import kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherAdapter extends RecyclerView.Adapter<ViewHolder> implements SwitcherAdapterView {
    private static final String TAG = "SwitcherAdapter";
    private OnItemClickListener listener;
    private SwitcherAdapterPresenter presenter;

    public interface OnItemClickListener {
        void onItemClickToCheckerWifiSetting(int i);

        void onItemClickToConnect(int i);

        void onItemClickToInfo(String str, int i);

        void onItemClickToLinkerWifiSetting(int i);

        void onItemClickToMainThing(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.rl_container = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_container, "field 'rl_container'", RelativeLayout.class);
            viewHolder.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
            viewHolder.iv_bluetooth_status = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bluetooth_status, "field 'iv_bluetooth_status'", ImageView.class);
            viewHolder.tv_switcher_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_name, "field 'tv_switcher_name'", TextView.class);
            viewHolder.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
            viewHolder.tv_bluetooth_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_bluetooth_status, "field 'tv_bluetooth_status'", TextView.class);
            viewHolder.iv_arrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_arrow, "field 'iv_arrow'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.rl_container = null;
            viewHolder.iv_switcher_icon = null;
            viewHolder.iv_bluetooth_status = null;
            viewHolder.tv_switcher_name = null;
            viewHolder.tv_serial_number = null;
            viewHolder.tv_bluetooth_status = null;
            viewHolder.iv_arrow = null;
        }
    }

    public SwitcherAdapter(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
        this.presenter = new SwitcherAdapterPresenter(this, new SwitcherItemListInteractor());
    }

    public SwitcherAdapter(ArrayList<IODeviceItem> arrayList, OnItemClickListener onItemClickListener) {
        this(onItemClickListener);
        setSwitcherItems(arrayList);
    }

    public void setSwitcherItems(List<IODeviceItem> list) {
        this.presenter.setSwitcherItems(list);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setLinkerItems(List<IODeviceItem> list) {
        this.presenter.setLinkerItems(list);
    }

    public void removeAll() {
        this.presenter.clearSwitcherItems();
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void refresh() {
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_switcher, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IODeviceItem iODeviceItem = this.presenter.getDeviceItems().get(i);
        this.presenter.initialize(iODeviceItem, viewHolder, i);
        this.presenter.setSwitcherType(iODeviceItem);
        this.presenter.setSwitcherStatus(iODeviceItem);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void initialize(IODeviceItem iODeviceItem, ViewHolder viewHolder, int i) {
        viewHolder.rl_container.setOnClickListener(this.presenter.getOnClickListener(i));
        viewHolder.tv_switcher_name.setText(iODeviceItem.getSwitcherName());
        viewHolder.tv_serial_number.setText(iODeviceItem.getSerialNumber());
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.not_connected));
        viewHolder.tv_bluetooth_status.setTextColor(IOUtil.getColorResource(R.color.bluegrey_two));
        viewHolder.iv_arrow.setVisibility(4);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOneAndScanned(ViewHolder viewHolder) {
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_bluetooth_default);
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsTwoAndScanned(ViewHolder viewHolder) {
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_bluetooth_default);
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOneAndConnectable(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one_disable);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.not_connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_default);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsTwoAndConnectable(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two_disable);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.not_connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_default);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOneAndNotScanned(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one_disable);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsTwoAndNotScanned(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two_disable);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setLinkerSwitcherOneType(ViewHolder viewHolder) {
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setLinkerSwitcherTwoType(ViewHolder viewHolder) {
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherStatusIsConnected(ViewHolder viewHolder) {
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.tv_bluetooth_status.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_bluetooth_connected);
        viewHolder.iv_arrow.setVisibility(0);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOneProduction(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one_production);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsTwoProduction(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two_production);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOtherProduction(ViewHolder viewHolder) {
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOneAndDelivery(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one_delivery);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsTwoAndDelivery(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two_delivery);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOneAndReturn(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one_return);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsTwoAndReturn(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two_return);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsOneAndReturnComplete(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one_return_complete);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherTypeIsTwoAndReturnComplete(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two_return_complete);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSwitcherGWStatusIsConnected(ViewHolder viewHolder) {
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.tv_bluetooth_status.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.iv_arrow.setVisibility(0);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setLinkerWifiSetting(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_linker);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.not_connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_bluetooth_default);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setLinker(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_linker);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.tv_serial_number.setText("내 링커");
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setLinkerProduction(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_linker_disable);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setRemocon(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_remocon);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.tv_serial_number.setText("내 리모컨");
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setAircon(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_aircon);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.tv_serial_number.setText("내 에어컨");
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setTV(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_tv);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.tv_serial_number.setText("내 TV");
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setSetTopBox(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_set_top_box);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.tv_serial_number.setText("내 셋톱박스");
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void onItemClickToConnect(int i) {
        this.listener.onItemClickToConnect(i);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void onItemClickToInfo(int i) {
        IODeviceItem iODeviceItem = this.presenter.getDeviceItems().get(i);
        this.listener.onItemClickToInfo(iODeviceItem.getMacAddress(), iODeviceItem.getFreeTrialId());
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void onItemClickToLinker(int i) {
        IODeviceItem iODeviceItem = this.presenter.getDeviceItems().get(i);
        this.listener.onItemClickToInfo(iODeviceItem.getMacAddress(), iODeviceItem.getFreeTrialId());
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void onItemClickToLinkerWifiSetting(int i) {
        this.listener.onItemClickToLinkerWifiSetting(i);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void onItemClickToMainThing(int i) {
        this.listener.onItemClickToMainThing(i);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setCheckerWifiSetting(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_checker);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.not_connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_bluetooth_default);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setChecker(String str, ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_checker);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.connected));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_gateway_connected);
        viewHolder.tv_serial_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void setCheckerProduction(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_checker_disable);
        viewHolder.tv_bluetooth_status.setText(IOUtil.getStringResource(R.string.watch_info));
        viewHolder.iv_bluetooth_status.setImageResource(R.drawable.ic_info);
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void onItemClickToChecker(int i) {
        IODeviceItem iODeviceItem = this.presenter.getDeviceItems().get(i);
        this.listener.onItemClickToInfo(iODeviceItem.getMacAddress(), iODeviceItem.getFreeTrialId());
    }

    @Override // kr.switcher.switcherm.ui.switcherList.views.SwitcherAdapterView
    public void onItemClickToCheckerWifiSetting(int i) {
        this.listener.onItemClickToCheckerWifiSetting(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.presenter.getDeviceItems().size();
    }

    public IODeviceItem getItem(int i) {
        return this.presenter.getDeviceItems().get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_arrow)
        ImageView iv_arrow;

        @BindView(R.id.iv_bluetooth_status)
        ImageView iv_bluetooth_status;

        @BindView(R.id.iv_switcher_icon)
        ImageView iv_switcher_icon;

        @BindView(R.id.rl_container)
        RelativeLayout rl_container;

        @BindView(R.id.tv_bluetooth_status)
        TextView tv_bluetooth_status;

        @BindView(R.id.tv_serial_number)
        TextView tv_serial_number;

        @BindView(R.id.tv_switcher_name)
        TextView tv_switcher_name;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
