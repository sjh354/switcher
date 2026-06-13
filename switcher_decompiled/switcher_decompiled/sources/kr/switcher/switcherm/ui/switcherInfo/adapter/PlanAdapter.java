package kr.switcher.switcherm.ui.switcherInfo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.rey.material.widget.RadioButton;
import java.util.ArrayList;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class PlanAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "PlanAdapter";
    private ArrayList<PlanItem> arrayList;
    private OnItemCheckedChangeListener listener;

    public interface OnItemCheckedChangeListener {
        void onItemChecked(int i);
    }

    public PlanAdapter(ArrayList<PlanItem> arrayList, OnItemCheckedChangeListener onItemCheckedChangeListener) {
        this.arrayList = arrayList;
        this.listener = onItemCheckedChangeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_plan, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        PlanItem planItem = this.arrayList.get(i);
        viewHolder.rb_using.setChecked(planItem.isMain());
        viewHolder.rb_using.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.switcherInfo.adapter.PlanAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                viewHolder.rb_using.setChecked(false);
                PlanAdapter.this.listener.onItemChecked(i);
            }
        });
        viewHolder.tv_plan_name.setText(planItem.getPlanName());
        viewHolder.tv_plan_info.setText(planItem.getPlanInfo());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public PlanItem getItem(int i) {
        return this.arrayList.get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton rb_using;
        RelativeLayout rl_container;
        TextView tv_plan_info;
        TextView tv_plan_name;

        public ViewHolder(View view) {
            super(view);
            this.rl_container = (RelativeLayout) view.findViewById(R.id.rl_container);
            this.tv_plan_name = (TextView) view.findViewById(R.id.tv_plan_name);
            this.tv_plan_info = (TextView) view.findViewById(R.id.tv_plan_info);
            this.rb_using = (RadioButton) view.findViewById(R.id.rb_using);
        }
    }
}
