package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentRemoconInfoBinding extends ViewDataBinding {
    public final TextView btnDeleteRemocon;
    public final ImageView ivRemoconIcon;
    public final LinearLayout linRoot;
    public final TextView tvRemoconName;
    public final TextView tvRemoconType;
    public final TextView using;

    protected FragmentRemoconInfoBinding(Object obj, View view, int i, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.btnDeleteRemocon = textView;
        this.ivRemoconIcon = imageView;
        this.linRoot = linearLayout;
        this.tvRemoconName = textView2;
        this.tvRemoconType = textView3;
        this.using = textView4;
    }

    public static FragmentRemoconInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRemoconInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRemoconInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_remocon_info, viewGroup, z, obj);
    }

    public static FragmentRemoconInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRemoconInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRemoconInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_remocon_info, null, false, obj);
    }

    public static FragmentRemoconInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRemoconInfoBinding bind(View view, Object obj) {
        return (FragmentRemoconInfoBinding) bind(obj, view, R.layout.fragment_remocon_info);
    }
}
