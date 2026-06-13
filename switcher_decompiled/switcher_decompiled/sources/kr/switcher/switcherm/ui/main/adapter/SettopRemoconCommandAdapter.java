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
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SettopRemoconCommandAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "SettopRemoconCommandAdapter";
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

    public SettopRemoconCommandAdapter(List<IRCommand> list, OnItemClickListener onItemClickListener) {
        this.arrayList = list;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_settop_remocon_command, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        IRCommand iRCommand = this.arrayList.get(i);
        viewHolder.tv_command_name.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.main.adapter.SettopRemoconCommandAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettopRemoconCommandAdapter.this.listener.onItemClick(i);
            }
        });
        viewHolder.tv_command_name.setOnLongClickListener(new View.OnLongClickListener() { // from class: kr.switcher.switcherm.ui.main.adapter.SettopRemoconCommandAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                SettopRemoconCommandAdapter.this.listener.onItemLongClick(i);
                return true;
            }
        });
        if (iRCommand.getName().equals("버튼 추가")) {
            viewHolder.tv_command_name.setBackground(IOUtil.getDrawable(R.drawable.bg_custom_command_plus));
            viewHolder.tv_command_name.setText("+");
            viewHolder.tv_command_name.setTextSize(20.0f);
            viewHolder.tv_command_name.setTextColor(IOUtil.getColorResource(R.color.white));
            return;
        }
        viewHolder.tv_command_name.setBackgroundResource(R.drawable.selector_remocon_custom_button);
        viewHolder.tv_command_name.setTextColor(IOUtil.getColorResource(R.color.battleshipGrey));
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
