package kr.switcher.switcherm.ui.setting.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import antistatic.spinnerwheel.adapters.AbstractWheelTextAdapter;
import java.util.ArrayList;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class ReservationWheelAdapter extends AbstractWheelTextAdapter {
    private ArrayList<String> mList;

    @Override // antistatic.spinnerwheel.adapters.AbstractWheelTextAdapter
    protected CharSequence getItemText(int i) {
        return "";
    }

    public ReservationWheelAdapter(Context context) {
        super(context, R.layout.adapter_timer_wheel, 0);
        this.mList = new ArrayList<>();
        setItemTextResource(R.id.tv_wheel);
    }

    @Override // antistatic.spinnerwheel.adapters.AbstractWheelTextAdapter, antistatic.spinnerwheel.adapters.WheelViewAdapter
    public View getItem(int i, View view, ViewGroup viewGroup) {
        View item = super.getItem(i, view, viewGroup);
        ((TextView) item.findViewById(R.id.tv_wheel)).setText(this.mList.get(i));
        return item;
    }

    @Override // antistatic.spinnerwheel.adapters.WheelViewAdapter
    public int getItemsCount() {
        return this.mList.size();
    }

    public void add(String str) {
        this.mList.add(str);
    }

    public String get(int i) {
        return this.mList.get(i);
    }
}
