package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.DFUFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentLinkerInsertIrCommandBinding extends ViewDataBinding {
    public final Button btnInsertCommand;

    @Bindable
    protected DFUFragmentViewModel mViewModel;
    public final LinearLayout rlRoot;
    public final TextView tvCommandName;

    public abstract void setViewModel(DFUFragmentViewModel dFUFragmentViewModel);

    protected FragmentLinkerInsertIrCommandBinding(Object obj, View view, int i, Button button, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.btnInsertCommand = button;
        this.rlRoot = linearLayout;
        this.tvCommandName = textView;
    }

    public DFUFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentLinkerInsertIrCommandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLinkerInsertIrCommandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentLinkerInsertIrCommandBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_linker_insert_ir_command, viewGroup, z, obj);
    }

    public static FragmentLinkerInsertIrCommandBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLinkerInsertIrCommandBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentLinkerInsertIrCommandBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_linker_insert_ir_command, null, false, obj);
    }

    public static FragmentLinkerInsertIrCommandBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLinkerInsertIrCommandBinding bind(View view, Object obj) {
        return (FragmentLinkerInsertIrCommandBinding) bind(obj, view, R.layout.fragment_linker_insert_ir_command);
    }
}
