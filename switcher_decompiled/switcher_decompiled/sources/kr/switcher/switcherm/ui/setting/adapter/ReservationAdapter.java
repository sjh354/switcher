package kr.switcher.switcherm.ui.setting.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rey.material.widget.Switch;
import java.util.ArrayList;
import kr.switcher.device.IODevice;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.interfaces.IODeviceCallbacks;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherDBProvider;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.setting.event.ReservationGA;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "ReservationAdapter";
    private ArrayList<ReservationItem> arrayList;
    private ReservationGA event = new ReservationGA();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i);

        void onRemoveItemClick(int i);

        void onShowProgressbar();
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.rl_container = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_container, "field 'rl_container'", RelativeLayout.class);
            viewHolder.cv_reservation = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_reservation, "field 'cv_reservation'", CardView.class);
            viewHolder.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
            viewHolder.tv_datetime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_datetime, "field 'tv_datetime'", TextView.class);
            viewHolder.tv_day_of_the_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day_of_the_week, "field 'tv_day_of_the_week'", TextView.class);
            viewHolder.iv_target = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_target, "field 'iv_target'", ImageView.class);
            viewHolder.sc_enable = (Switch) Utils.findRequiredViewAsType(view, R.id.sc_enable, "field 'sc_enable'", Switch.class);
            viewHolder.btn_delete = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.btn_delete, "field 'btn_delete'", RelativeLayout.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.rl_container = null;
            viewHolder.cv_reservation = null;
            viewHolder.tv_title = null;
            viewHolder.tv_datetime = null;
            viewHolder.tv_day_of_the_week = null;
            viewHolder.iv_target = null;
            viewHolder.sc_enable = null;
            viewHolder.btn_delete = null;
        }
    }

    public ReservationAdapter(ArrayList<ReservationItem> arrayList, OnItemClickListener onItemClickListener) {
        this.arrayList = arrayList;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_reservation, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        String str;
        ReservationItem reservationItem = this.arrayList.get(i);
        final Switcher.SwitcherReservation switcherReservation = reservationItem.getSwitcherReservation();
        viewHolder.rl_container.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IOLog.i(ReservationAdapter.TAG, "SwitcherListAdapter-clicked");
                ReservationAdapter.this.listener.onItemClick(i);
            }
        });
        final Switcher switcher = SwitcherHandler.getInstance().getSwitcher(reservationItem.getConnectedMacAddress());
        if (switcher == null) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "switcher is null", new NullPointerException("switcher is null"));
            return;
        }
        setTitle(viewHolder.tv_title, switcherReservation.title);
        setTargetImage(viewHolder.iv_target, switcherReservation.switcherTarget, switcher.getProductId(), reservationItem.getSwitcherReservation().light);
        if (switcherReservation.ampm.equalsIgnoreCase(IODeviceConfig.AM)) {
            str = IOUtil.getStringResource(R.string.am) + " ";
        } else if (switcherReservation.ampm.equalsIgnoreCase("pm")) {
            str = IOUtil.getStringResource(R.string.pm) + " ";
        } else {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "am/pm is null", new NullPointerException("am/pm is null"));
            return;
        }
        viewHolder.tv_datetime.setText(str + IOUtil.convertNumberAddZero(switcherReservation.hour) + ":" + IOUtil.convertNumberAddZero(switcherReservation.min));
        viewHolder.tv_day_of_the_week.setText(getDayOfWeek(switcherReservation));
        viewHolder.sc_enable.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.2
            @Override // com.rey.material.widget.Switch.OnCheckedChangeListener
            public void onCheckedChanged(Switch r3, final boolean z) {
                if (switcherReservation.enable == z) {
                    return;
                }
                switcherReservation.enable = z;
                switcher.updateReservation(switcherReservation, new IODeviceCallbacks.ReservationUpdateResultCallback() { // from class: kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.2.1
                    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
                    public void onUpdatedReservation(boolean z2) {
                        if (z2) {
                            IOLog.i(ReservationAdapter.TAG, "success update timer");
                            ReservationAdapter.this.setEnable(viewHolder, switcherReservation);
                            ReservationAdapter.this.event.setGAActivateAlarm(switcherReservation.enable, switcherReservation.light);
                        } else {
                            IOLog.i(ReservationAdapter.TAG, "failed update timer");
                            viewHolder.sc_enable.setChecked(!z);
                            ReservationAdapter.this.setEnable(viewHolder, switcherReservation);
                        }
                    }
                });
            }
        });
        setEnable(viewHolder, switcherReservation);
        viewHolder.sc_enable.setChecked(switcherReservation.enable);
        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ReservationAdapter.this.listener.onShowProgressbar();
                switcher.removeReservation(switcherReservation.id, new IODeviceCallbacks.ReservationUpdateResultCallback() { // from class: kr.switcher.switcherm.ui.setting.adapter.ReservationAdapter.3.1
                    @Override // kr.switcher.device.switcher.interfaces.IODeviceCallbacks.ReservationUpdateResultCallback
                    public void onUpdatedReservation(boolean z) {
                        new SwitcherDBProvider().deleteReservationToDB(switcher.getMacAddress(), switcherReservation.id);
                        ReservationAdapter.this.listener.onRemoveItemClick(i);
                    }
                });
            }
        });
    }

    private void setTitle(TextView textView, String str) {
        if (str == null || str.length() <= 0) {
            str = IOUtil.getStringResource(R.string.reservation_default_title);
        }
        textView.setText(str);
    }

    private void setTargetImage(ImageView imageView, String str, IODevice.ProductId productId, boolean z) {
        if (productId == IODevice.ProductId.SWITCHER_TYPE_ONE) {
            if (z) {
                imageView.setBackground(IOUtil.makeDrawable(R.drawable.ic_single_on_default));
                return;
            } else {
                imageView.setBackground(IOUtil.makeDrawable(R.drawable.ic_single_off_default));
                return;
            }
        }
        if (productId == IODevice.ProductId.SWITCHER_TYPE_TWO) {
            if (str.equals(Switcher.SwitcherReservation.SWITCH_1WAY_FIRMWARE)) {
                if (z) {
                    imageView.setBackground(IOUtil.makeDrawable(R.drawable.ic_top_on_default));
                    return;
                } else {
                    imageView.setBackground(IOUtil.makeDrawable(R.drawable.ic_top_off_default));
                    return;
                }
            }
            if (str.equals("1")) {
                if (z) {
                    imageView.setBackground(IOUtil.makeDrawable(R.drawable.ic_bottom_on_default));
                } else {
                    imageView.setBackground(IOUtil.makeDrawable(R.drawable.ic_bottom_off_default));
                }
            }
        }
    }

    private String getDayOfWeek(Switcher.SwitcherReservation switcherReservation) {
        String str = switcherReservation.mon ? "" + IOUtil.getStringResource(R.string.mon) + " " : "";
        if (switcherReservation.tue) {
            str = str + IOUtil.getStringResource(R.string.tue) + " ";
        }
        if (switcherReservation.wed) {
            str = str + IOUtil.getStringResource(R.string.wed) + " ";
        }
        if (switcherReservation.thu) {
            str = str + IOUtil.getStringResource(R.string.thu) + " ";
        }
        if (switcherReservation.fri) {
            str = str + IOUtil.getStringResource(R.string.fri) + " ";
        }
        if (switcherReservation.sat) {
            str = str + IOUtil.getStringResource(R.string.sat) + " ";
        }
        if (switcherReservation.sun) {
            str = str + IOUtil.getStringResource(R.string.sun);
        }
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(switcherReservation.mon, switcherReservation.tue, switcherReservation.wed, switcherReservation.thu, switcherReservation.fri, switcherReservation.sat, switcherReservation.sun);
        int status = dayOfWeekRepeater.getStatus();
        if (status == 1) {
            return IOUtil.getStringResource(R.string.daily);
        }
        if (status != 2) {
            return status != 3 ? str : IOUtil.getStringResource(R.string.weekend);
        }
        return IOUtil.getStringResource(R.string.weekday);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnable(ViewHolder viewHolder, Switcher.SwitcherReservation switcherReservation) {
        if (switcherReservation.enable) {
            if (Build.VERSION.SDK_INT >= 21) {
                viewHolder.cv_reservation.setElevation(10.0f);
            }
            viewHolder.iv_target.setAlpha(1.0f);
            viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_datetime.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            viewHolder.cv_reservation.setElevation(2.0f);
        }
        viewHolder.iv_target.setAlpha(0.5f);
        viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_datetime.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public void addAll(ArrayList<ReservationItem> arrayList) {
        this.arrayList = arrayList;
    }

    public ReservationItem getItem(int i) {
        return this.arrayList.get(i);
    }

    public void clear() {
        this.arrayList.clear();
    }

    public void addItem(ReservationItem reservationItem) {
        this.arrayList.add(reservationItem);
    }

    public void removeItem(int i) {
        ReservationItem reservationItem;
        if (i < this.arrayList.size() && (reservationItem = (ReservationItem) IOUtil.getItemInList(this.arrayList, i)) != null) {
            this.arrayList.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeRemoved(i, this.arrayList.size());
            this.event.setGADeleteAlarm(reservationItem.getSwitcherReservation().light);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.btn_delete)
        RelativeLayout btn_delete;

        @BindView(R.id.cv_reservation)
        CardView cv_reservation;

        @BindView(R.id.iv_target)
        ImageView iv_target;

        @BindView(R.id.rl_container)
        RelativeLayout rl_container;

        @BindView(R.id.sc_enable)
        Switch sc_enable;

        @BindView(R.id.tv_datetime)
        TextView tv_datetime;

        @BindView(R.id.tv_day_of_the_week)
        TextView tv_day_of_the_week;

        @BindView(R.id.tv_title)
        TextView tv_title;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
