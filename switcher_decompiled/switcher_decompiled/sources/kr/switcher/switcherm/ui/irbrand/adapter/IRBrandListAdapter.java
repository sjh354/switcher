package kr.switcher.switcherm.ui.irbrand.adapter;

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
public class IRBrandListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "IRBrandListAdapter";
    private List<BrandItem> arrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.cv_ir_brand = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_ir_brand, "field 'cv_ir_brand'", CardView.class);
            viewHolder.tv_brand_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_brand_name, "field 'tv_brand_name'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.cv_ir_brand = null;
            viewHolder.tv_brand_name = null;
        }
    }

    public IRBrandListAdapter(List<BrandItem> list, OnItemClickListener onItemClickListener) {
        this.arrayList = list;
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_ir_brand, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        BrandItem brandItem = this.arrayList.get(i);
        viewHolder.cv_ir_brand.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.irbrand.adapter.IRBrandListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IRBrandListAdapter.this.listener.onItemClick(i);
            }
        });
        viewHolder.tv_brand_name.setText(brandItem.getBrandName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public BrandItem getItem(int i) {
        return this.arrayList.get(i);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cv_ir_brand)
        CardView cv_ir_brand;

        @BindView(R.id.tv_brand_name)
        TextView tv_brand_name;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
