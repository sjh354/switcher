package kr.switcher.switcherm.ui.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.ui.ircommandregister.LinkerCommandRegisterActivity;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.adapter.CommandItem;
import kr.switcher.switcherm.ui.main.adapter.MainConnectedRemoconAdapter;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;
import kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor;
import kr.switcher.switcherm.ui.main.presenters.MainConnectedRemoconPresenter;
import kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView;

/* JADX INFO: loaded from: classes2.dex */
public class MainConnectedRemoconFragment extends Fragment implements MainConnectedRemoconView, FindIRCommandInteractor.OnFindIRCommandListener, MainConnectedRemoconAdapter.OnItemClickListener {
    private static final String PARM_CONNECTED_MAC_ADDRESS = "CONNECTED_ID";
    private static final String TAG = "MainConnectedRemoconFragment";
    private static MainScreenController.OnMainDataResultCallback callback;
    private MainConnectedRemoconAdapter adapter;

    @BindView(R.id.btn_add_command)
    View btn_add_command;
    private List<CommandItem> commandItems;
    private Remocon connectedRemocon;

    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;
    private MainConnectedRemoconPresenter presenter;

    @BindView(R.id.rv_command_list)
    RecyclerView rv_command_list;

    @BindView(R.id.tv_add_command)
    TextView tv_add_command;

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onCHRelease(boolean z, String str, String str2) {
    }

    public static MainConnectedRemoconFragment newInstance(String str, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainConnectedRemoconFragment mainConnectedRemoconFragment = new MainConnectedRemoconFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARM_CONNECTED_MAC_ADDRESS, str);
        mainConnectedRemoconFragment.setArguments(bundle);
        return mainConnectedRemoconFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_connected_remocon, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(arguments != null ? arguments.getString(PARM_CONNECTED_MAC_ADDRESS) : "");
        this.connectedRemocon = remocon;
        if (remocon == null) {
            return null;
        }
        this.btn_add_command.setOnTouchListener(new View.OnTouchListener() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedRemoconFragment.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MainConnectedRemoconFragment.this.tv_add_command.setAlpha(0.5f);
                } else if (action == 1) {
                    MainConnectedRemoconFragment.this.tv_add_command.setAlpha(1.0f);
                    MainConnectedRemoconFragment.this.presenter.onAddCommandButtonClicked();
                }
                return true;
            }
        });
        this.presenter = new MainConnectedRemoconPresenter(this, new FindIRCommandInteractor(this));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.connectedRemocon);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void onMainData(String str, IODevice.ProductId productId, String str2, String str3, MainActivity.MainBackgroundState mainBackgroundState) {
        callback.onMainData(str, productId, str2, str3, mainBackgroundState);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void initRecyclerListView() {
        this.commandItems = new ArrayList();
        this.adapter = new MainConnectedRemoconAdapter(this.commandItems, this);
        this.rv_command_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_command_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void setCommandItems(List<CommandItem> list) {
        this.commandItems.addAll(list);
        this.adapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void removeItem(String str) {
        CommandItem commandItem = null;
        for (CommandItem commandItem2 : this.commandItems) {
            if (commandItem2.getId().equals(str)) {
                commandItem = commandItem2;
            }
        }
        if (commandItem != null) {
            this.commandItems.remove(commandItem);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void showInfoDialog(final int i) {
        new MaterialDialog.Builder(getContext()).title(this.commandItems.get(i).getCommandTitle()).items(DataLayer.listOf("명령어 삭제")).itemsCallback(new MaterialDialog.ListCallback() { // from class: kr.switcher.switcherm.ui.main.fragment.MainConnectedRemoconFragment.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
            public void onSelection(MaterialDialog materialDialog, View view, int i2, CharSequence charSequence) {
                MainConnectedRemoconFragment.this.presenter.onSelection(MainConnectedRemoconFragment.this.adapter.getItem(i));
            }
        }).show();
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onFind(List<IRCommand> list) {
        this.presenter.onFind(list);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onRelease(boolean z) {
        this.presenter.onRelease(z);
    }

    @Override // kr.switcher.switcherm.ui.main.interactors.FindIRCommandInteractor.OnFindIRCommandListener
    public void onRemove(boolean z, String str) {
        this.presenter.onRemove(z, str);
    }

    @Override // kr.switcher.switcherm.ui.main.adapter.MainConnectedRemoconAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.adapter.getItem(i));
    }

    @Override // kr.switcher.switcherm.ui.main.adapter.MainConnectedRemoconAdapter.OnItemClickListener
    public void onItemLongClick(int i) {
        this.presenter.onItemLongClick(i);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void moveIRCommandRegisterScreen() {
        Intent intent = new Intent(getContext(), (Class<?>) LinkerCommandRegisterActivity.class);
        intent.putExtra(LinkerCommandRegisterActivity.PARM_REMOCON_KEY, this.connectedRemocon.getMacAddress());
        startActivity(intent);
    }

    @Override // kr.switcher.switcherm.ui.main.views.MainConnectedRemoconView
    public void showProgressbar() {
        IOUtil.showProgressbarDialog(getActivity(), this.pb_loading, 500);
    }
}
