package kr.switcher.switcherm.ui.widget.adapter;

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
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.widget.helper.WidgetIdChecker;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "WidgetAdapter";
    private WidgetIdChecker checker;
    private List<IODeviceItem> list;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String str, boolean z);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.rl_container = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_container, "field 'rl_container'", RelativeLayout.class);
            viewHolder.iv_switcher_icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_switcher_icon, "field 'iv_switcher_icon'", ImageView.class);
            viewHolder.tv_switcher_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_name, "field 'tv_switcher_name'", TextView.class);
            viewHolder.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
            viewHolder.iv_widget_status = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_widget_status, "field 'iv_widget_status'", ImageView.class);
            viewHolder.tv_widget_status = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_widget_status, "field 'tv_widget_status'", TextView.class);
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
            viewHolder.tv_switcher_name = null;
            viewHolder.tv_serial_number = null;
            viewHolder.iv_widget_status = null;
            viewHolder.tv_widget_status = null;
        }
    }

    public WidgetAdapter(List<IODeviceItem> list, OnItemClickListener onItemClickListener, int[] iArr) {
        this.list = list;
        this.listener = onItemClickListener;
        this.checker = new WidgetIdChecker(iArr);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_widget_switcher, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final IODeviceItem iODeviceItem = this.list.get(i);
        if (iODeviceItem.getProductId() == IODevice.ProductId.SWITCHER_TYPE_ONE) {
            viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_one);
        } else if (iODeviceItem.getProductId() == IODevice.ProductId.SWITCHER_TYPE_TWO) {
            viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_switcher_two);
        } else if (iODeviceItem.getProductId().equals(IODevice.ProductId.REMOCON)) {
            Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(iODeviceItem.getMacAddress());
            if (remocon != null) {
                int i2 = AnonymousClass2.$SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[remocon.getControllerId().ordinal()];
                if (i2 == 1) {
                    setTV(viewHolder);
                } else if (i2 == 2) {
                    setSetTopBox(viewHolder);
                } else if (i2 == 3) {
                    setAircon(viewHolder);
                } else if (i2 == 4) {
                    setRemocon(viewHolder);
                }
            }
        } else if (iODeviceItem.getProductId().equals(IODevice.ProductId.CHECKER)) {
            viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_checker);
        }
        viewHolder.tv_switcher_name.setText(iODeviceItem.getSwitcherName());
        viewHolder.tv_serial_number.setText(iODeviceItem.getSerialNumber());
        final boolean zCheckIsExistedWidgetId = this.checker.checkIsExistedWidgetId(new WidgetPreference().getWidgetId(iODeviceItem.getMacAddress()));
        if (zCheckIsExistedWidgetId) {
            viewHolder.iv_widget_status.setImageResource(R.drawable.ic_widgets_pressed);
            viewHolder.tv_widget_status.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
            viewHolder.tv_widget_status.setText(IOUtil.getStringResource(R.string.using_widget));
        } else {
            viewHolder.iv_widget_status.setImageResource(R.drawable.ic_widgets_default);
            viewHolder.tv_widget_status.setTextColor(IOUtil.getColorResource(R.color.bluegrey_two));
            viewHolder.tv_widget_status.setText(IOUtil.getStringResource(R.string.add_widget));
        }
        viewHolder.rl_container.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WidgetAdapter.this.listener.onItemClick(iODeviceItem.getMacAddress(), zCheckIsExistedWidgetId);
            }
        });
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID;

        static {
            int[] iArr = new int[Remocon.ControllerID.values().length];
            $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID = iArr;
            try {
                iArr[Remocon.ControllerID.TV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.SET_TOP_BOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.AIRCON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$remocon$Remocon$ControllerID[Remocon.ControllerID.REMOCON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void setRemocon(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_remocon);
        viewHolder.tv_serial_number.setVisibility(8);
    }

    private void setAircon(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_aircon);
        viewHolder.tv_serial_number.setVisibility(8);
    }

    private void setSetTopBox(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_set_top_box);
        viewHolder.tv_serial_number.setVisibility(8);
    }

    private void setTV(ViewHolder viewHolder) {
        viewHolder.iv_switcher_icon.setImageResource(R.drawable.ic_list_tv);
        viewHolder.tv_serial_number.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    public void addAll(ArrayList<IODeviceItem> arrayList) {
        this.list = arrayList;
    }

    public IODeviceItem getItem(int i) {
        return this.list.get(i);
    }

    public void clear() {
        this.list.clear();
    }

    public void addItem(IODeviceItem iODeviceItem) {
        this.list.add(iODeviceItem);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_switcher_icon)
        ImageView iv_switcher_icon;

        @BindView(R.id.iv_widget_status)
        ImageView iv_widget_status;

        @BindView(R.id.rl_container)
        RelativeLayout rl_container;

        @BindView(R.id.tv_serial_number)
        TextView tv_serial_number;

        @BindView(R.id.tv_switcher_name)
        TextView tv_switcher_name;

        @BindView(R.id.tv_widget_status)
        TextView tv_widget_status;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
