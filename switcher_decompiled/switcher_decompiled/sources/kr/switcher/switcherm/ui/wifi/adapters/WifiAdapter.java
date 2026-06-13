package kr.switcher.switcherm.ui.wifi.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.network.wifi.WifiData;

/* JADX INFO: loaded from: classes2.dex */
public class WifiAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "WifiAdapter";
    private List<WifiData> arrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClicked(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.btn_item = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.btn_item, "field 'btn_item'", RelativeLayout.class);
            viewHolder.tv_wifi_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_wifi_name, "field 'tv_wifi_name'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.btn_item = null;
            viewHolder.tv_wifi_name = null;
        }
    }

    public WifiAdapter(List<WifiData> list, OnItemClickListener onItemClickListener) {
        this.arrayList = list;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wifi, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        WifiData wifiData = this.arrayList.get(i);
        viewHolder.btn_item.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.wifi.adapters.WifiAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WifiAdapter.this.listener.onItemClicked(i);
            }
        });
        viewHolder.tv_wifi_name.setText(wifiData.getSsid());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public WifiData getItem(int i) {
        return this.arrayList.get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.btn_item)
        RelativeLayout btn_item;

        @BindView(R.id.tv_wifi_name)
        TextView tv_wifi_name;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
