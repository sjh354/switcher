package kr.switcher.switcherm.ui.mypage.fragments;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MypageListFragment_ViewBinding implements Unbinder {
    private MypageListFragment target;
    private View view7f0900c4;
    private View view7f0900d1;
    private View view7f0900d2;
    private View view7f09029b;

    public MypageListFragment_ViewBinding(final MypageListFragment mypageListFragment, View view) {
        this.target = mypageListFragment;
        mypageListFragment.et_room_name = (TextView) Utils.findRequiredViewAsType(view, R.id.et_room_name, "field 'et_room_name'", TextView.class);
        mypageListFragment.rv_my_switcher_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_my_switcher_list, "field 'rv_my_switcher_list'", RecyclerView.class);
        mypageListFragment.tv_io_cash = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_io_cash, "field 'tv_io_cash'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.cb_auto_bluetooth, "field 'cb_auto_bluetooth' and method 'onAuthBluetoothButtonClicked'");
        mypageListFragment.cb_auto_bluetooth = (CheckBox) Utils.castView(viewFindRequiredView, R.id.cb_auto_bluetooth, "field 'cb_auto_bluetooth'", CheckBox.class);
        this.view7f0900c4 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.mypage.fragments.MypageListFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mypageListFragment.onAuthBluetoothButtonClicked();
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_auto_bluetooth, "field 'tv_auto_bluetooth' and method 'onAutoBluetoothTextClicked'");
        mypageListFragment.tv_auto_bluetooth = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_auto_bluetooth, "field 'tv_auto_bluetooth'", TextView.class);
        this.view7f09029b = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.mypage.fragments.MypageListFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mypageListFragment.onAutoBluetoothTextClicked();
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.cb_subscription_marketing, "field 'cb_subscription_marketing' and method 'onMarketingSubButtonClicked'");
        mypageListFragment.cb_subscription_marketing = (CheckBox) Utils.castView(viewFindRequiredView3, R.id.cb_subscription_marketing, "field 'cb_subscription_marketing'", CheckBox.class);
        this.view7f0900d2 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.mypage.fragments.MypageListFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mypageListFragment.onMarketingSubButtonClicked();
            }
        });
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.cb_subscription_info, "field 'cb_subscription_info' and method 'onInfoSubButtonClicked'");
        mypageListFragment.cb_subscription_info = (CheckBox) Utils.castView(viewFindRequiredView4, R.id.cb_subscription_info, "field 'cb_subscription_info'", CheckBox.class);
        this.view7f0900d1 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: kr.switcher.switcherm.ui.mypage.fragments.MypageListFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                mypageListFragment.onInfoSubButtonClicked();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MypageListFragment mypageListFragment = this.target;
        if (mypageListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mypageListFragment.et_room_name = null;
        mypageListFragment.rv_my_switcher_list = null;
        mypageListFragment.tv_io_cash = null;
        mypageListFragment.cb_auto_bluetooth = null;
        mypageListFragment.tv_auto_bluetooth = null;
        mypageListFragment.cb_subscription_marketing = null;
        mypageListFragment.cb_subscription_info = null;
        this.view7f0900c4.setOnClickListener(null);
        this.view7f0900c4 = null;
        this.view7f09029b.setOnClickListener(null);
        this.view7f09029b = null;
        this.view7f0900d2.setOnClickListener(null);
        this.view7f0900d2 = null;
        this.view7f0900d1.setOnClickListener(null);
        this.view7f0900d1 = null;
    }
}
