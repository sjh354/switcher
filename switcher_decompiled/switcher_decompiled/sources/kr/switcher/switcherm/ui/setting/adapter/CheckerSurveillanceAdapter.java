package kr.switcher.switcherm.ui.setting.adapter;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.setting.helper.DayOfWeekRepeater;
import kr.switcher.switcherm.ui.widget.presenter.CheckerWidgetPresenter;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerSurveillanceAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "CheckerSurveillanceAdapter";
    private OnCheckedChangeListener checkedChangeListener;
    private OnItemClickListener listener;
    private List<Checker.Surveillance> surveillanceList;

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
            viewHolder.lin_surveillance_icon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lin_surveillance_icon, "field 'lin_surveillance_icon'", LinearLayout.class);
            viewHolder.iv_siren = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_siren, "field 'iv_siren'", ImageView.class);
            viewHolder.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
            viewHolder.tv_start_date_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_start_date_time, "field 'tv_start_date_time'", TextView.class);
            viewHolder.tv_end_date_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_end_date_time, "field 'tv_end_date_time'", TextView.class);
            viewHolder.tv_day_of_the_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_day_of_the_week, "field 'tv_day_of_the_week'", TextView.class);
            viewHolder.sc_enable = (Switch) Utils.findRequiredViewAsType(view, R.id.sc_enable, "field 'sc_enable'", Switch.class);
            viewHolder.btn_delete = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.btn_delete, "field 'btn_delete'", RelativeLayout.class);
            viewHolder.tv_level = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_level, "field 'tv_level'", TextView.class);
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
            viewHolder.lin_surveillance_icon = null;
            viewHolder.iv_siren = null;
            viewHolder.tv_title = null;
            viewHolder.tv_start_date_time = null;
            viewHolder.tv_end_date_time = null;
            viewHolder.tv_day_of_the_week = null;
            viewHolder.sc_enable = null;
            viewHolder.btn_delete = null;
            viewHolder.tv_level = null;
        }
    }

    public CheckerSurveillanceAdapter(List<Checker.Surveillance> list, OnItemClickListener onItemClickListener, OnCheckedChangeListener onCheckedChangeListener) {
        this.surveillanceList = list;
        this.listener = onItemClickListener;
        this.checkedChangeListener = onCheckedChangeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_checker_surveillance, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final Checker.Surveillance surveillance = this.surveillanceList.get(i);
        viewHolder.rl_container.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i(CheckerSurveillanceAdapter.TAG, "CheckerSurveillanceAdapter-clicked");
                CheckerSurveillanceAdapter.this.listener.onItemClick(i);
            }
        });
        setTitle(viewHolder.tv_title, surveillance.title);
        setDateTime(viewHolder.tv_start_date_time, surveillance.startAt);
        setDateTime(viewHolder.tv_end_date_time, surveillance.endAt);
        setDayOfWeek(viewHolder.tv_day_of_the_week, surveillance);
        if (surveillance.level == 1) {
            viewHolder.iv_siren.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_level_one_active));
            viewHolder.tv_level.setText(CheckerWidgetPresenter.LEVEL_ONE);
        } else if (surveillance.level == 2) {
            viewHolder.iv_siren.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_level_two_active));
            viewHolder.tv_level.setText(CheckerWidgetPresenter.LEVEL_TWO);
        }
        if (surveillance.isActive.equals("True")) {
            viewHolder.sc_enable.setChecked(true);
        } else {
            viewHolder.sc_enable.setChecked(false);
        }
        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheckerSurveillanceAdapter.this.listener.onRemoveItemClick(i);
            }
        });
        viewHolder.sc_enable.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() { // from class: kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceAdapter.3
            @Override // com.rey.material.widget.Switch.OnCheckedChangeListener
            public void onCheckedChanged(Switch r2, boolean z) {
                CheckerSurveillanceAdapter.this.checkedChangeListener.onCheckedChange(i, String.valueOf(z));
                CheckerSurveillanceAdapter.this.setActive(viewHolder, surveillance);
            }
        });
        setActive(viewHolder, surveillance);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.surveillanceList.size();
    }

    public void clear() {
        this.surveillanceList.clear();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.btn_delete)
        RelativeLayout btn_delete;

        @BindView(R.id.cv_reservation)
        CardView cv_reservation;

        @BindView(R.id.iv_siren)
        ImageView iv_siren;

        @BindView(R.id.lin_surveillance_icon)
        LinearLayout lin_surveillance_icon;

        @BindView(R.id.rl_container)
        RelativeLayout rl_container;

        @BindView(R.id.sc_enable)
        Switch sc_enable;

        @BindView(R.id.tv_day_of_the_week)
        TextView tv_day_of_the_week;

        @BindView(R.id.tv_end_date_time)
        TextView tv_end_date_time;

        @BindView(R.id.tv_level)
        TextView tv_level;

        @BindView(R.id.tv_start_date_time)
        TextView tv_start_date_time;

        @BindView(R.id.tv_title)
        TextView tv_title;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void addItem(Checker.Surveillance surveillance) {
        this.surveillanceList.add(surveillance);
    }

    public void removeItem(int i) {
        if (i < this.surveillanceList.size() && ((Checker.Surveillance) IOUtil.getItemInList(this.surveillanceList, i)) != null) {
            this.surveillanceList.remove(i);
            notifyItemRemoved(i);
            notifyItemRangeRemoved(i, this.surveillanceList.size());
        }
    }

    public Checker.Surveillance getItem(int i) {
        return this.surveillanceList.get(i);
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

    private void setDayOfWeek(TextView textView, Checker.Surveillance surveillance) {
        String stringResource = surveillance.mon.booleanValue() ? "" + IOUtil.getStringResource(R.string.mon) + " " : "";
        if (surveillance.tue.booleanValue()) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.tue) + " ";
        }
        if (surveillance.wed.booleanValue()) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.wed) + " ";
        }
        if (surveillance.thu.booleanValue()) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.thu) + " ";
        }
        if (surveillance.fri.booleanValue()) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.fri) + " ";
        }
        if (surveillance.sat.booleanValue()) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.sat) + " ";
        }
        if (surveillance.sun.booleanValue()) {
            stringResource = stringResource + IOUtil.getStringResource(R.string.sun);
        }
        DayOfWeekRepeater dayOfWeekRepeater = new DayOfWeekRepeater();
        dayOfWeekRepeater.setDayOfWeek(surveillance.mon.booleanValue(), surveillance.tue.booleanValue(), surveillance.wed.booleanValue(), surveillance.thu.booleanValue(), surveillance.fri.booleanValue(), surveillance.sat.booleanValue(), surveillance.sun.booleanValue());
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
            return new SimpleDateFormat("HH:mm").format(new SimpleDateFormat("HHmmss").parse(str));
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
    public void setActive(ViewHolder viewHolder, Checker.Surveillance surveillance) {
        if (surveillance.isActive.equals("True")) {
            if (Build.VERSION.SDK_INT >= 21) {
                viewHolder.cv_reservation.setElevation(10.0f);
            }
            viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_start_date_time.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_end_date_time.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            viewHolder.tv_level.setTextColor(IOUtil.getColorResource(R.color.charcoal_grey));
            if (surveillance.level == 1) {
                viewHolder.iv_siren.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_level_one_active));
                return;
            } else {
                if (surveillance.level == 2) {
                    viewHolder.iv_siren.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_level_two_active));
                    return;
                }
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            viewHolder.cv_reservation.setElevation(2.0f);
        }
        viewHolder.tv_title.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_start_date_time.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_end_date_time.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_day_of_the_week.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        viewHolder.tv_level.setTextColor(IOUtil.getColorResource(R.color.blue_grey_two));
        if (surveillance.level == 1) {
            viewHolder.iv_siren.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_level_one_inactive));
        } else if (surveillance.level == 2) {
            viewHolder.iv_siren.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_checker_level_two_inactive));
        }
    }
}
