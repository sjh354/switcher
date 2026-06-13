package kr.switcher.switcherm.ui.setting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerHistoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "CheckerHistoryAdapter";
    private List<CheckerHistoryItem> arrayList;
    private OnBottomReachedListener onBottomReachedListener;

    public interface OnBottomReachedListener {
        void onBottomReached();
    }

    public interface OnItemClickListener {
        void onItemClick(int i);
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.cv_checker_history = (CardView) Utils.findRequiredViewAsType(view, R.id.cv_checker_history, "field 'cv_checker_history'", CardView.class);
            viewHolder.iv_badge_history_open = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_badge_history_open, "field 'iv_badge_history_open'", ImageView.class);
            viewHolder.tv_history_comment = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_history_comment, "field 'tv_history_comment'", TextView.class);
            viewHolder.tv_date = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_date, "field 'tv_date'", TextView.class);
            viewHolder.tv_time = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tv_time'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.target = null;
            viewHolder.cv_checker_history = null;
            viewHolder.iv_badge_history_open = null;
            viewHolder.tv_history_comment = null;
            viewHolder.tv_date = null;
            viewHolder.tv_time = null;
        }
    }

    public CheckerHistoryAdapter(ArrayList<CheckerHistoryItem> arrayList, OnBottomReachedListener onBottomReachedListener) {
        this.arrayList = arrayList;
        this.onBottomReachedListener = onBottomReachedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_checker_history, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        CheckerHistoryItem checkerHistoryItem = this.arrayList.get(i);
        if (checkerHistoryItem.getTransition_type().equals("TYPE_OPEN")) {
            viewHolder.iv_badge_history_open.setImageDrawable(IOUtil.getDrawable(R.drawable.ic_badge_history_opened));
            viewHolder.tv_history_comment.setText("(창)문이 열렸습니다.");
        } else if (checkerHistoryItem.getTransition_type().equals("TYPE_CLOSE")) {
            viewHolder.iv_badge_history_open.setImageResource(R.drawable.ic_badge_history_closed);
            viewHolder.tv_history_comment.setText("(창)문이 닫혔습니다.");
        } else {
            viewHolder.tv_history_comment.setText(NotificationCompat.CATEGORY_ERROR);
        }
        String created_at = checkerHistoryItem.getCreated_at();
        if (created_at.contains(".")) {
            created_at.substring(0, created_at.lastIndexOf("."));
        }
        String[] strArrSplit = created_at.split("T");
        viewHolder.tv_date.setText(IOUtil.convertDateFormat(strArrSplit[0]));
        viewHolder.tv_time.setText(IOUtil.convertTimeFormatForCheckerHistory(strArrSplit[1]));
        if (i == this.arrayList.size() - 1) {
            this.onBottomReachedListener.onBottomReached();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public void clear() {
        this.arrayList.clear();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cv_checker_history)
        CardView cv_checker_history;

        @BindView(R.id.iv_badge_history_open)
        ImageView iv_badge_history_open;

        @BindView(R.id.tv_date)
        TextView tv_date;

        @BindView(R.id.tv_history_comment)
        TextView tv_history_comment;

        @BindView(R.id.tv_time)
        TextView tv_time;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
