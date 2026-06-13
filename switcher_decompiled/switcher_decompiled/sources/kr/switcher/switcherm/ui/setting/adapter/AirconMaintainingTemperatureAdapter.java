package kr.switcher.switcherm.ui.setting.adapter;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.rey.material.widget.Switch;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;

/* JADX INFO: loaded from: classes2.dex */
public class AirconMaintainingTemperatureAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "AirconMaintainingTemperatureAdapter";
    private OnCheckedChangeListener checkedChangeListener;
    private OnItemClickListener listener;
    private List<Remocon.RemoconMaintenanceTemperature> maintainanceList;

    public interface OnCheckedChangeListener {
        void onCheckedChange(int i, String str);
    }

    public interface OnItemClickListener {
        void onItemClick(int i);

        void onRemoveItemClick(int i);

        void onShowProgressbar();
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.cv_reservation = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_reservation, "field 'cv_reservation'", CardView.class);
            viewHolder.rl_container = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_container, "field 'rl_container'", RelativeLayout.class);
            viewHolder.rl_reservation_temperature = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_reservation_temperature, "field 'rl_reservation_temperature'", RelativeLayout.class);
            viewHolder.tv_temperature = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_temperature, "field 'tv_temperature'", TextView.class);
            viewHolder.tv_temperature_symbol = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_temperature_symbol, "field 'tv_temperature_symbol'", TextView.class);
            viewHolder.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
            viewHolder.tv_start_date_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_start_date_time, "field 'tv_start_date_time'", TextView.class);
            viewHolder.tv_end_date_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_end_date_time, "field 'tv_end_date_time'", TextView.class);
            viewHolder.tv_day_of_the_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day_of_the_week, "field 'tv_day_of_the_week'", TextView.class);
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
            viewHolder.cv_reservation = null;
            viewHolder.rl_container = null;
            viewHolder.rl_reservation_temperature = null;
            viewHolder.tv_temperature = null;
            viewHolder.tv_temperature_symbol = null;
            viewHolder.tv_title = null;
            viewHolder.tv_start_date_time = null;
            viewHolder.tv_end_date_time = null;
            viewHolder.tv_day_of_the_week = null;
            viewHolder.sc_enable = null;
            viewHolder.btn_delete = null;
        }
    }

    public AirconMaintainingTemperatureAdapter(List<Remocon.RemoconMaintenanceTemperature> list, OnItemClickListener onItemClickListener, OnCheckedChangeListener onCheckedChangeListener) {
        this.maintainanceList = list;
        this.listener = onItemClickListener;
        this.checkedChangeListener = onCheckedChangeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_aircon_maintainance, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature = this.maintainanceList.get(i);
        viewHolder.rl_container.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i(AirconMaintainingTemperatureAdapter.TAG, "AirconMaintainanceListAdapter-clicked");
                AirconMaintainingTemperatureAdapter.this.listener.onItemClick(i);
            }
        });
        setTitle(viewHolder.tv_title, remoconMaintenanceTemperature.title);
        setDateTime(viewHolder.tv_start_date_time, remoconMaintenanceTemperature.start_time_at);
        setDateTime(viewHolder.tv_end_date_time, remoconMaintenanceTemperature.end_time_at);
        setDayOfWeek(viewHolder.tv_day_of_the_week, remoconMaintenanceTemperature);
        if (remoconMaintenanceTemperature.is_enabled.booleanValue()) {
            viewHolder.sc_enable.setChecked(true);
        } else {
            viewHolder.sc_enable.setChecked(false);
        }
        setTemperature(viewHolder.tv_temperature, remoconMaintenanceTemperature.goal_temperature);
        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AirconMaintainingTemperatureAdapter.this.listener.onRemoveItemClick(i);
            }
        });
        viewHolder.sc_enable.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureAdapter.3
            @Override // com.rey.material.widget.Switch.OnCheckedChangeListener
            public void onCheckedChanged(Switch r2, boolean z) {
                AirconMaintainingTemperatureAdapter.this.checkedChangeListener.onCheckedChange(i, String.valueOf(z));
                AirconMaintainingTemperatureAdapter.this.setEnable(viewHolder, remoconMaintenanceTemperature);
            }
        });
        setEnable(viewHolder, remoconMaintenanceTemperature);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.maintainanceList.size();
    }

    public void clear() {
        this.maintainanceList.clear();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.btn_delete)
        RelativeLayout btn_delete;

        @BindView(R.id.cv_reservation)
        CardView cv_reservation;

        @BindView(R.id.rl_container)
        RelativeLayout rl_container;

        @BindView(R.id.rl_reservation_temperature)
        RelativeLayout rl_reservation_temperature;

        @BindView(R.id.sc_enable)
        Switch sc_enable;

        @BindView(R.id.tv_day_of_the_week)
        TextView tv_day_of_the_week;

        @BindView(R.id.tv_end_date_time)
        TextView tv_end_date_time;

        @BindView(R.id.tv_start_date_time)
        TextView tv_start_date_time;

        @BindView(R.id.tv_temperature)
        TextView tv_temperature;

        @BindView(R.id.tv_temperature_symbol)
        TextView tv_temperature_symbol;

        @BindView(R.id.tv_title)
        TextView tv_title;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void addItem(Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        this.maintainanceList.add(remoconMaintenanceTemperature);
    }

    public void removeItem(int i) {
        if (i < this.maintainanceList.size() && ((Remocon.RemoconMaintenanceTemperature) IOUtil.getItemInList(this.maintainanceList, i)) != null) {
            this.maintainanceList.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeRemoved(i, this.maintainanceList.size());
        }
    }

    public Remocon.RemoconMaintenanceTemperature getItem(int i) {
        return this.maintainanceList.get(i);
    }

    private void setTitle(TextView textView, String str) {
        if (str == null || str.length() <= 0) {
            str = IOUtil.getStringResource(R.string.reservation_default_title);
        }
        textView.setText(str);
    }

    private void setDateTime(TextView textView, String str) {
        if (str == null || str.length() <= 0) {
            textView.setText(IOUtil.getStringResource(R.string.reservation_default_date_time));
        } else {
            textView.setText(convertTimeFormat(str));
        }
    }

    private void setDayOfWeek(TextView textView, Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        String stringResource = remoconMaintenanceTemperature.mon ? "" + IOUtil.getStringResource(R.string.mon) + " " : "";
        if (remoconMaintenanceTemperature.tue) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.tue) + " ";
        }
        if (remoconMaintenanceTemperature.wed) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.wed) + " ";
        }
        if (remoconMaintenanceTemperature.thu) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.thu) + " ";
        }
        if (remoconMaintenanceTemperature.fri) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.fri) + " ";
        }
        if (remoconMaintenanceTemperature.sat) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.sat) + " ";
        }
        if (remoconMaintenanceTemperature.sun) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.sun);
        }
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(remoconMaintenanceTemperature.mon, remoconMaintenanceTemperature.tue, remoconMaintenanceTemperature.wed, remoconMaintenanceTemperature.thu, remoconMaintenanceTemperature.fri, remoconMaintenanceTemperature.sat, remoconMaintenanceTemperature.sun);
        int status = dayOfWeekRepeater.getStatus();
        if (status == 1) {
            stringResource = IOUtil.getStringResource(R.string.daily);
        } else if (status == 2) {
            stringResource = IOUtil.getStringResource(R.string.weekday);
        } else if (status == 3) {
            stringResource = IOUtil.getStringResource(R.string.weekend);
        }
        textView.setText(stringResource);
    }

    public static String convertTimeFormat(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        try {
            return new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HHmm").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    private void setTemperature(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (strValueOf == null || strValueOf.length() <= 0) {
            return;
        }
        textView.setText(strValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnable(ViewHolder viewHolder, Remocon.RemoconMaintenanceTemperature remoconMaintenanceTemperature) {
        if (remoconMaintenanceTemperature.is_enabled.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 21) {
                viewHolder.cv_reservation.setElevation(10.0f);
            }
            viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_start_date_time.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_end_date_time.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_temperature.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            viewHolder.cv_reservation.setElevation(2.0f);
        }
        viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_start_date_time.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_end_date_time.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_temperature.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
    }
}
