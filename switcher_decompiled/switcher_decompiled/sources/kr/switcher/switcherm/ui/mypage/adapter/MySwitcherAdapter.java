package kr.switcher.switcherm.ui.mypage.adapter;

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
import java.util.ArrayList;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.mypage.MyPageItem;
import kr.switcher.switcherm.ui.mypage.presenters.MySwitcherAdapterPresenter;
import kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView;

/* JADX INFO: loaded from: classes2.dex */
public class MySwitcherAdapter extends RecyclerView.Adapter<ViewHolder> implements MySwitcherAdapterView {
    private static final String TAG = "MySwitcherAdapter";
    private ArrayList<MyPageItem> arrayList;
    private OnItemClickListener listener;
    private MySwitcherAdapterPresenter presenter = new MySwitcherAdapterPresenter(this);

    public interface OnItemClickListener {
        void onItemClickToConnect(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.rl_container = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_container, "field 'rl_container'", RelativeLayout.class);
            viewHolder.tv_switcher_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_switcher_name, "field 'tv_switcher_name'", TextView.class);
            viewHolder.tv_serial_number = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_serial_number, "field 'tv_serial_number'", TextView.class);
            viewHolder.tv_plan_info = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_plan_info, "field 'tv_plan_info'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.rl_container = null;
            viewHolder.tv_switcher_name = null;
            viewHolder.tv_serial_number = null;
            viewHolder.tv_plan_info = null;
        }
    }

    public MySwitcherAdapter(ArrayList<MyPageItem> arrayList, OnItemClickListener onItemClickListener) {
        this.arrayList = arrayList;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_switcher, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        MyPageItem myPageItem = this.arrayList.get(i);
        viewHolder.rl_container.setOnClickListener(this.presenter.getOnClickListener(i));
        this.presenter.setSwitcherName(myPageItem, viewHolder);
        this.presenter.setSerialNumber(myPageItem, viewHolder);
        IODevice device = IODeviceHandler.getInstance().getDevice(myPageItem.getMacAddress());
        if (device != null) {
            this.presenter.setPlanInfo(myPageItem, device.getOption().getShipping().getStatus(), viewHolder);
        }
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView
    public void setDeviceName(ViewHolder viewHolder, String str) {
        viewHolder.tv_switcher_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView
    public void setSerialNumber(ViewHolder viewHolder, String str) {
        viewHolder.tv_serial_number.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView
    public void setPlanInfo(ViewHolder viewHolder, String str) {
        viewHolder.tv_plan_info.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView
    public void showSerialNumber(ViewHolder viewHolder) {
        viewHolder.tv_serial_number.setVisibility(0);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView
    public void hideSerialNumber(ViewHolder viewHolder) {
        viewHolder.tv_serial_number.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView
    public void onItemClickToConnect(int i) {
        this.listener.onItemClickToConnect(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public MyPageItem getItem(int i) {
        return this.arrayList.get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rl_container)
        RelativeLayout rl_container;

        @BindView(R.id.tv_plan_info)
        TextView tv_plan_info;

        @BindView(R.id.tv_serial_number)
        TextView tv_serial_number;

        @BindView(R.id.tv_switcher_name)
        TextView tv_switcher_name;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
