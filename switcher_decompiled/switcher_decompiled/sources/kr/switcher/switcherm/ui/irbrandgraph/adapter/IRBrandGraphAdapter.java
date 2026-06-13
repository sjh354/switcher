package kr.switcher.switcherm.ui.irbrandgraph.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.List;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandGraphAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "IRBrandGraphAdapter";
    private List<CommandHistoryItem> arrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.cv_ir_command_history = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_ir_command_history, "field 'cv_ir_command_history'", CardView.class);
            viewHolder.tv_history_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_history_time, "field 'tv_history_time'", TextView.class);
            viewHolder.tv_command_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_command_name, "field 'tv_command_name'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.cv_ir_command_history = null;
            viewHolder.tv_history_time = null;
            viewHolder.tv_command_name = null;
        }
    }

    public IRBrandGraphAdapter(List<CommandHistoryItem> list, OnItemClickListener onItemClickListener) {
        this.arrayList = list;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ir_command_history, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        CommandHistoryItem commandHistoryItem = this.arrayList.get(i);
        viewHolder.cv_ir_command_history.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.irbrandgraph.adapter.IRBrandGraphAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IRBrandGraphAdapter.this.listener.onItemClick(i);
            }
        });
        viewHolder.tv_history_time.setText(commandHistoryItem.getCreated_at());
        viewHolder.tv_command_name.setText(commandHistoryItem.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cv_ir_command_history)
        CardView cv_ir_command_history;

        @BindView(R.id.tv_command_name)
        TextView tv_command_name;

        @BindView(R.id.tv_history_time)
        TextView tv_history_time;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
