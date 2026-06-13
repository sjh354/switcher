package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.switcherInfo.SwitcherInfoActivity;
import kr.switcher.switcherm.ui.switcherInfo.interactors.DeleteRemoconInteractor;
import kr.switcher.switcherm.ui.switcherInfo.presenters.RemoconInfoPresenter;
import kr.switcher.switcherm.ui.switcherInfo.views.RemoconInfoView;

/* JADX INFO: loaded from: classes2.dex */
public class RemoconInfoFragment extends Fragment implements RemoconInfoView, DeleteRemoconInteractor.OnDeleteRemoconListener {
    private static final String TAG = "RemoconInfoFragment";
    private static SwitcherInfoActivity.FinishActivityListener listener;

    @BindView(R.id.btn_delete_remocon)
    TextView btn_delete_remocon;

    @BindView(R.id.iv_remocon_icon)
    ImageView iv_remocon_icon;
    private RemoconInfoPresenter presenter;
    private Remocon remocon;

    @BindView(R.id.tv_remocon_name)
    TextView tv_remocon_name;

    @BindView(R.id.tv_remocon_type)
    TextView tv_remocon_type;

    public static RemoconInfoFragment newInstance(String str, SwitcherInfoActivity.FinishActivityListener finishActivityListener) {
        RemoconInfoFragment remoconInfoFragment = new RemoconInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        remoconInfoFragment.setArguments(bundle);
        listener = finishActivityListener;
        return remoconInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_remocon_info, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        this.remocon = (Remocon) IODeviceHandler.getInstance().getDevice(arguments.getString("CONNECTED_MAC_ADDRESS"));
        RemoconInfoPresenter remoconInfoPresenter = new RemoconInfoPresenter(this, new DeleteRemoconInteractor(this));
        this.presenter = remoconInfoPresenter;
        remoconInfoPresenter.onCreateView(this.remocon);
        return viewInflate;
    }

    @OnClick({R.id.btn_delete_remocon})
    public void onDeleteButtonClicked() {
        showDeleteDialog(this.remocon);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.DeleteRemoconInteractor.OnDeleteRemoconListener
    public void onDeleteSuccess() {
        moveMainListScreen();
    }

    private void moveMainListScreen() {
        getActivity().setResult(104, new Intent(getActivity(), (Class<?>) MainActivity.class));
        getActivity().finish();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.interactors.DeleteRemoconInteractor.OnDeleteRemoconListener
    public void onError(String str) {
        this.presenter.onError();
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RemoconInfoView
    public void showErrorMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RemoconInfoView
    public void setRemoconType(String str) {
        this.tv_remocon_type.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RemoconInfoView
    public void setRemoconName(String str) {
        this.tv_remocon_name.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.switcherInfo.views.RemoconInfoView
    public void setRemoconIcon(Drawable drawable) {
        this.iv_remocon_icon.setImageDrawable(drawable);
    }

    public void showDeleteDialog(final Remocon remocon) {
        new MaterialDialog.Builder(getContext()).content("리모컨을 삭제하시겠습니까?").positiveText("네").negativeText("아니오").negativeColor(R.color.periwinkle).positiveColor(R.color.periwinkle).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.RemoconInfoFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                RemoconInfoFragment.this.presenter.onDeleteButtonCliecked(remocon);
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.RemoconInfoFragment.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
            }
        }).cancelable(false).show();
    }
}
