package kr.switcher.switcherm.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.List;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class AirconRemoconConnectedAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "AirconRemoconConnectedAdapter";
    private List<IRCommand> arrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i);

        void onItemLongClick(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.tv_command_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_command_name, "field 'tv_command_name'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.tv_command_name = null;
        }
    }

    public AirconRemoconConnectedAdapter(List<IRCommand> list, OnItemClickListener onItemClickListener) {
        this.arrayList = list;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_aircon_remocon_command, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        IRCommand iRCommand = this.arrayList.get(i);
        viewHolder.tv_command_name.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.main.adapter.AirconRemoconConnectedAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AirconRemoconConnectedAdapter.this.listener.onItemClick(i);
            }
        });
        viewHolder.tv_command_name.setOnLongClickListener(new View.OnLongClickListener() { // from class: kr.switcher.switcherm.ui.main.adapter.AirconRemoconConnectedAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AirconRemoconConnectedAdapter.this.listener.onItemLongClick(i);
                return true;
            }
        });
        viewHolder.tv_command_name.setText(iRCommand.getName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public IRCommand getItem(int i) {
        return this.arrayList.get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_command_name)
        TextView tv_command_name;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
