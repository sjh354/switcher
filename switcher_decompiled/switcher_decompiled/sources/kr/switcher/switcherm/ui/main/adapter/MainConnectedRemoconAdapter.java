package kr.switcher.switcherm.ui.main.adapter;

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
public class MainConnectedRemoconAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "MainConnectedRemoconAdapter";
    private List<CommandItem> arrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i);

        void onItemLongClick(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.cv_command = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_command, "field 'cv_command'", CardView.class);
            viewHolder.tv_command_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_command_title, "field 'tv_command_title'", TextView.class);
            viewHolder.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.cv_command = null;
            viewHolder.tv_command_title = null;
            viewHolder.tv_time = null;
        }
    }

    public MainConnectedRemoconAdapter(List<CommandItem> list, OnItemClickListener onItemClickListener) {
        this.arrayList = list;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_command, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        CommandItem commandItem = this.arrayList.get(i);
        viewHolder.cv_command.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.main.adapter.MainConnectedRemoconAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainConnectedRemoconAdapter.this.listener.onItemClick(i);
            }
        });
        viewHolder.cv_command.setOnLongClickListener(new View.OnLongClickListener() { // from class: kr.switcher.switcherm.ui.main.adapter.MainConnectedRemoconAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                MainConnectedRemoconAdapter.this.listener.onItemLongClick(i);
                return true;
            }
        });
        viewHolder.tv_command_title.setText(commandItem.getCommandTitle());
        viewHolder.tv_time.setText(commandItem.getTime());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public CommandItem getItem(int i) {
        return this.arrayList.get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cv_command)
        CardView cv_command;

        @BindView(R.id.tv_command_title)
        TextView tv_command_title;

        @BindView(R.id.tv_time)
        TextView tv_time;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
