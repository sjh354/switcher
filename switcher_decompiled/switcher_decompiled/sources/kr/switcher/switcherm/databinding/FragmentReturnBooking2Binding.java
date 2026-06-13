package kr.switcher.switcherm.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.rey.material.widget.RadioButton;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.viewmodel.ReturnBooking2FragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentReturnBooking2Binding extends ViewDataBinding {
    public final ImageView ivCalendar;

    @Bindable
    protected ReturnBooking2FragmentViewModel mViewModel;
    public final ProgressBar pbSearching;
    public final RadioButton rbVisitDay1;
    public final RadioButton rbVisitDay2;
    public final RadioButton rbVisitDay3;
    public final RadioButton rbVisitDay4;
    public final RadioButton rbVisitDay5;
    public final RelativeLayout rlRoot;
    public final TextView tvReturnMessage1;
    public final TextView tvReturnMessage2;
    public final TextView tvReturnMessage3;
    public final TextView tvReturnMessage4;
    public final TextView tvVisitDay1;
    public final TextView tvVisitDay2;
    public final TextView tvVisitDay3;
    public final TextView tvVisitDay4;
    public final TextView tvVisitDay5;

    public abstract void setViewModel(ReturnBooking2FragmentViewModel returnBooking2FragmentViewModel);

    protected FragmentReturnBooking2Binding(Object obj, View view, int i, ImageView imageView, ProgressBar progressBar, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.ivCalendar = imageView;
        this.pbSearching = progressBar;
        this.rbVisitDay1 = radioButton;
        this.rbVisitDay2 = radioButton2;
        this.rbVisitDay3 = radioButton3;
        this.rbVisitDay4 = radioButton4;
        this.rbVisitDay5 = radioButton5;
        this.rlRoot = relativeLayout;
        this.tvReturnMessage1 = textView;
        this.tvReturnMessage2 = textView2;
        this.tvReturnMessage3 = textView3;
        this.tvReturnMessage4 = textView4;
        this.tvVisitDay1 = textView5;
        this.tvVisitDay2 = textView6;
        this.tvVisitDay3 = textView7;
        this.tvVisitDay4 = textView8;
        this.tvVisitDay5 = textView9;
    }

    public ReturnBooking2FragmentViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentReturnBooking2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnBooking2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentReturnBooking2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_return_booking2, viewGroup, z, obj);
    }

    public static FragmentReturnBooking2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnBooking2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentReturnBooking2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_return_booking2, null, false, obj);
    }

    public static FragmentReturnBooking2Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentReturnBooking2Binding bind(View view, Object obj) {
        return (FragmentReturnBooking2Binding) bind(obj, view, R.layout.fragment_return_booking2);
    }
}
