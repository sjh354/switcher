package kr.switcher.switcherm.ui.mypage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class TroubleshootingAdapter extends BaseExpandableListAdapter {
    private Map<String, List<String>> children;
    private Context context;
    private List<String> groups;

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public TroubleshootingAdapter(Context context, List<String> list, Map<String, List<String>> map) {
        this.groups = new ArrayList();
        new HashMap();
        this.context = context;
        this.groups = list;
        this.children = map;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.children.get(this.groups.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.item_help, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.tv_info)).setText(this.children.get(this.groups.get(i)).get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.children.get(this.groups.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.groups.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.groups.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.item_help_parent, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.tv_topic)).setText(this.groups.get(i));
        return view;
    }
}
