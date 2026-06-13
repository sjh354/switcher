package kr.switcher.switcherm.common.listview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleSectionedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int SECTION_TYPE = 0;
    private RecyclerView.Adapter mBaseAdapter;
    private final Context mContext;
    private LayoutInflater mLayoutInflater;
    private int mSectionResourceId;
    private int mTextResourceId;
    private boolean mValid = true;
    private SparseArray<Section> mSections = new SparseArray<>();

    public SimpleSectionedRecyclerViewAdapter(Context context, int i, int i2, RecyclerView.Adapter adapter) {
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mSectionResourceId = i;
        this.mTextResourceId = i2;
        this.mBaseAdapter = adapter;
        this.mContext = context;
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: kr.switcher.switcherm.common.listview.SimpleSectionedRecyclerViewAdapter.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                SimpleSectionedRecyclerViewAdapter simpleSectionedRecyclerViewAdapter = SimpleSectionedRecyclerViewAdapter.this;
                simpleSectionedRecyclerViewAdapter.mValid = simpleSectionedRecyclerViewAdapter.mBaseAdapter.getItemCount() > 0;
                SimpleSectionedRecyclerViewAdapter.this.notifyDataSetChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i3, int i4) {
                SimpleSectionedRecyclerViewAdapter simpleSectionedRecyclerViewAdapter = SimpleSectionedRecyclerViewAdapter.this;
                simpleSectionedRecyclerViewAdapter.mValid = simpleSectionedRecyclerViewAdapter.mBaseAdapter.getItemCount() > 0;
                SimpleSectionedRecyclerViewAdapter.this.notifyItemRangeChanged(i3, i4);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i3, int i4) {
                SimpleSectionedRecyclerViewAdapter simpleSectionedRecyclerViewAdapter = SimpleSectionedRecyclerViewAdapter.this;
                simpleSectionedRecyclerViewAdapter.mValid = simpleSectionedRecyclerViewAdapter.mBaseAdapter.getItemCount() > 0;
                SimpleSectionedRecyclerViewAdapter.this.notifyItemRangeInserted(i3, i4);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i3, int i4) {
                SimpleSectionedRecyclerViewAdapter simpleSectionedRecyclerViewAdapter = SimpleSectionedRecyclerViewAdapter.this;
                simpleSectionedRecyclerViewAdapter.mValid = simpleSectionedRecyclerViewAdapter.mBaseAdapter.getItemCount() > 0;
                SimpleSectionedRecyclerViewAdapter.this.notifyItemRangeRemoved(i3, i4);
            }
        });
    }

    public static class SectionViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public SectionViewHolder(View view, int i) {
            super(view);
            this.title = (TextView) view.findViewById(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new SectionViewHolder(LayoutInflater.from(this.mContext).inflate(this.mSectionResourceId, viewGroup, false), this.mTextResourceId);
        }
        return this.mBaseAdapter.onCreateViewHolder(viewGroup, i - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (isSectionHeaderPosition(i)) {
            ((SectionViewHolder) viewHolder).title.setText(this.mSections.get(i).title);
        } else {
            this.mBaseAdapter.onBindViewHolder(viewHolder, sectionedPositionToPosition(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (isSectionHeaderPosition(i)) {
            return 0;
        }
        return this.mBaseAdapter.getItemViewType(sectionedPositionToPosition(i)) + 1;
    }

    public static class Section {
        int firstPosition;
        int sectionedPosition;
        CharSequence title;

        public Section(int i, CharSequence charSequence) {
            this.firstPosition = i;
            this.title = charSequence;
        }

        public CharSequence getTitle() {
            return this.title;
        }
    }

    public void setSections(Section[] sectionArr) {
        this.mSections.clear();
        Arrays.sort(sectionArr, new Comparator<Section>() { // from class: kr.switcher.switcherm.common.listview.SimpleSectionedRecyclerViewAdapter.2
            @Override // java.util.Comparator
            public int compare(Section section, Section section2) {
                if (section.firstPosition == section2.firstPosition) {
                    return 0;
                }
                return section.firstPosition < section2.firstPosition ? -1 : 1;
            }
        });
        int i = 0;
        for (Section section : sectionArr) {
            section.sectionedPosition = section.firstPosition + i;
            this.mSections.append(section.sectionedPosition, section);
            i++;
        }
        notifyDataSetChanged();
    }

    public int positionToSectionedPosition(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.mSections.size() && this.mSections.valueAt(i3).firstPosition <= i; i3++) {
            i2++;
        }
        return i + i2;
    }

    public int sectionedPositionToPosition(int i) {
        if (isSectionHeaderPosition(i)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.mSections.size() && this.mSections.valueAt(i3).sectionedPosition <= i; i3++) {
            i2--;
        }
        return i + i2;
    }

    public boolean isSectionHeaderPosition(int i) {
        return this.mSections.get(i) != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (isSectionHeaderPosition(i)) {
            return Integer.MAX_VALUE - this.mSections.indexOfKey(i);
        }
        return this.mBaseAdapter.getItemId(sectionedPositionToPosition(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mValid) {
            return this.mBaseAdapter.getItemCount() + this.mSections.size();
        }
        return 0;
    }
}
