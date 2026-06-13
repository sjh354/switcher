package kr.switcher.switcherm.ui.main.fragment;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import kr.switcher.switcherm.R;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedRemoconFragment_ViewBinding implements Unbinder {
    private MainConnectedRemoconFragment target;

    public MainConnectedRemoconFragment_ViewBinding(MainConnectedRemoconFragment mainConnectedRemoconFragment, View view) {
        this.target = mainConnectedRemoconFragment;
        mainConnectedRemoconFragment.rv_command_list = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_command_list, "field 'rv_command_list'", RecyclerView.class);
        mainConnectedRemoconFragment.btn_add_command = Utils.findRequiredView(view, R.id.btn_add_command, "field 'btn_add_command'");
        mainConnectedRemoconFragment.tv_add_command = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add_command, "field 'tv_add_command'", TextView.class);
        mainConnectedRemoconFragment.pb_loading = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_loading, "field 'pb_loading'", ProgressBar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        MainConnectedRemoconFragment mainConnectedRemoconFragment = this.target;
        if (mainConnectedRemoconFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mainConnectedRemoconFragment.rv_command_list = null;
        mainConnectedRemoconFragment.btn_add_command = null;
        mainConnectedRemoconFragment.tv_add_command = null;
        mainConnectedRemoconFragment.pb_loading = null;
    }
}
