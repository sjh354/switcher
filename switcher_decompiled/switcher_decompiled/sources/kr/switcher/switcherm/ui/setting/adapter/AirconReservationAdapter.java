package kr.switcher.switcherm.ui.setting.adapter;

import android.os.Build;
import android.util.Log;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;

/* JADX INFO: loaded from: classes2.dex */
public class AirconReservationAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "AirconReservationAdapter";
    private OnCheckedChangeListener checkedChangeListener;
    private OnItemClickListener listener;
    private List<Remocon.RemoconReservation> remoconReservationList;

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
            viewHolder.rl_container = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_container, "field 'rl_container'", RelativeLayout.class);
            viewHolder.rl_reservation_temperature = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_reservation_temperature, "field 'rl_reservation_temperature'", RelativeLayout.class);
            viewHolder.cv_reservation = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_reservation, "field 'cv_reservation'", CardView.class);
            viewHolder.tv_temperature = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_temperature, "field 'tv_temperature'", TextView.class);
            viewHolder.tv_temperature_symbol = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_temperature_symbol, "field 'tv_temperature_symbol'", TextView.class);
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
            viewHolder.rl_reservation_temperature = null;
            viewHolder.cv_reservation = null;
            viewHolder.tv_temperature = null;
            viewHolder.tv_temperature_symbol = null;
            viewHolder.tv_title = null;
            viewHolder.tv_datetime = null;
            viewHolder.tv_day_of_the_week = null;
            viewHolder.iv_target = null;
            viewHolder.sc_enable = null;
            viewHolder.btn_delete = null;
        }
    }

    public AirconReservationAdapter(List<Remocon.RemoconReservation> list, OnItemClickListener onItemClickListener, OnCheckedChangeListener onCheckedChangeListener) {
        this.remoconReservationList = list;
        this.listener = onItemClickListener;
        this.checkedChangeListener = onCheckedChangeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_aircon_reservation, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final Remocon.RemoconReservation remoconReservation = this.remoconReservationList.get(i);
        viewHolder.rl_container.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i(AirconReservationAdapter.TAG, "AirconReservationListAdapter-clicked");
                AirconReservationAdapter.this.listener.onItemClick(i);
            }
        });
        setTitle(viewHolder.tv_title, remoconReservation.title);
        setDayOfWeek(viewHolder.tv_day_of_the_week, remoconReservation);
        setDateTime(viewHolder.tv_datetime, remoconReservation.time);
        if (remoconReservation.isEnabled.equals("true")) {
            viewHolder.sc_enable.setChecked(true);
        } else {
            viewHolder.sc_enable.setChecked(false);
        }
        setTargetImage(viewHolder.iv_target, remoconReservation.tag);
        setTemperature(viewHolder.tv_temperature, viewHolder.tv_temperature_symbol, remoconReservation.tag);
        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AirconReservationAdapter.this.listener.onRemoveItemClick(i);
            }
        });
        viewHolder.sc_enable.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.AirconReservationAdapter.3
            @Override // com.rey.material.widget.Switch.OnCheckedChangeListener
            public void onCheckedChanged(Switch r2, boolean z) {
                AirconReservationAdapter.this.checkedChangeListener.onCheckedChange(i, String.valueOf(z));
                AirconReservationAdapter.this.setEnable(viewHolder, remoconReservation);
            }
        });
        setEnable(viewHolder, remoconReservation);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.remoconReservationList.size();
    }

    public void clear() {
        this.remoconReservationList.clear();
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

        @BindView(R.id.rl_reservation_temperature)
        RelativeLayout rl_reservation_temperature;

        @BindView(R.id.sc_enable)
        Switch sc_enable;

        @BindView(R.id.tv_datetime)
        TextView tv_datetime;

        @BindView(R.id.tv_day_of_the_week)
        TextView tv_day_of_the_week;

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

    public void addItem(Remocon.RemoconReservation remoconReservation) {
        this.remoconReservationList.add(remoconReservation);
    }

    public Remocon.RemoconReservation getItem(int i) {
        return this.remoconReservationList.get(i);
    }

    private void setTitle(TextView textView, String str) {
        if (str == null || str.length() <= 0) {
            str = IOUtil.getStringResource(R.string.reservation_default_title);
        }
        textView.setText(str);
    }

    private void setDateTime(TextView textView, String str) {
        if (str == null || str.length() <= 0) {
            textView.setText(IOUtil.getStringResource(R.string.reservation_default_title));
        } else {
            textView.setText(convertTimeFormat(str));
        }
    }

    private void setDayOfWeek(TextView textView, Remocon.RemoconReservation remoconReservation) {
        String stringResource = remoconReservation.mon ? "" + IOUtil.getStringResource(R.string.mon) + " " : "";
        if (remoconReservation.tue) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.tue) + " ";
        }
        if (remoconReservation.wed) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.wed) + " ";
        }
        if (remoconReservation.thu) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.thu) + " ";
        }
        if (remoconReservation.fri) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.fri) + " ";
        }
        if (remoconReservation.sat) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.sat) + " ";
        }
        if (remoconReservation.sun) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.sun);
        }
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(remoconReservation.mon, remoconReservation.tue, remoconReservation.wed, remoconReservation.thu, remoconReservation.fri, remoconReservation.sat, remoconReservation.sun);
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

    private void setTargetImage(ImageView imageView, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            imageView.setImageResource(R.drawable.ic_aircon_reservation_off);
        } else {
            imageView.setImageResource(R.drawable.ic_aircon_reservation_on);
        }
    }

    private void setTemperature(TextView textView, TextView textView2, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (str.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView2.setVisibility(0);
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnable(ViewHolder viewHolder, Remocon.RemoconReservation remoconReservation) {
        if (remoconReservation.isEnabled.equals("true")) {
            if (Build.VERSION.SDK_INT >= 21) {
                viewHolder.cv_reservation.setElevation(10.0f);
            }
            viewHolder.iv_target.setAlpha(1.0f);
            viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_datetime.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_temperature.setTextColor(IOUtil.getColorResource(R.color.periwinkle));
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            viewHolder.cv_reservation.setElevation(2.0f);
        }
        viewHolder.iv_target.setAlpha(0.5f);
        viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_datetime.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_temperature.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
    }
}
