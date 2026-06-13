package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.wang.avi.AVLoadingIndicatorView;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.DFUFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentLinkerTestIrCommandBinding extends ViewDataBinding {
    public final Button btnTestCommand;

    @Bindable
    protected DFUFragmentViewModel mViewModel;
    public final AVLoadingIndicatorView pbRegistering;
    public final LinearLayout rlRoot;

    public abstract void setViewModel(DFUFragmentViewModel dFUFragmentViewModel);

    protected FragmentLinkerTestIrCommandBinding(Object obj, View view, int i, Button button, AVLoadingIndicatorView aVLoadingIndicatorView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.btnTestCommand = button;
        this.pbRegistering = aVLoadingIndicatorView;
        this.rlRoot = linearLayout;
    }

    public DFUFragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentLinkerTestIrCommandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLinkerTestIrCommandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentLinkerTestIrCommandBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_linker_test_ir_command, viewGroup, z, obj);
    }

    public static FragmentLinkerTestIrCommandBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLinkerTestIrCommandBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentLinkerTestIrCommandBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_linker_test_ir_command, null, false, obj);
    }

    public static FragmentLinkerTestIrCommandBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentLinkerTestIrCommandBinding bind(View view, Object obj) {
        return (FragmentLinkerTestIrCommandBinding) bind(obj, view, R.layout.fragment_linker_test_ir_command);
    }
}
