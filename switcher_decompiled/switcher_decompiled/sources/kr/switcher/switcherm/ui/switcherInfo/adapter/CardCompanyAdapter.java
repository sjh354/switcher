package kr.switcher.switcherm.ui.switcherInfo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class CardCompanyAdapter extends ArrayAdapter<String> {
    private List<String> arrayList;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public CardCompanyAdapter(Context context, int i, List<String> list) {
        super(context, i, list);
        this.arrayList = list;
        this.inflater = ((Activity) context).getLayoutInflater();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.arrayList.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public String getItem(int i) {
        return this.arrayList.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    public View getCustomView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.item_spinner_card_change, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            this.viewHolder = viewHolder;
            viewHolder.tv_company = (TextView) view.findViewById(R.id.tv_company);
            view.setTag(this.viewHolder);
        } else {
            this.viewHolder = (ViewHolder) view.getTag();
        }
        this.viewHolder.tv_company.setText(this.arrayList.get(i));
        return view;
    }

    static class ViewHolder {
        TextView tv_company;

        ViewHolder() {
        }
    }
}
