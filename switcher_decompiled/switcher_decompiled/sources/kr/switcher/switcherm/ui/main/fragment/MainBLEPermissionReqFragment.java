package kr.switcher.switcherm.ui.main.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.permission.PermissionChecker;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;

/* JADX INFO: loaded from: classes2.dex */
public class MainBLEPermissionReqFragment extends Fragment {
    private static final String TAG = "MainBLEPermissionReqFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    public static MainBLEPermissionReqFragment newInstance(MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainBLEPermissionReqFragment mainBLEPermissionReqFragment = new MainBLEPermissionReqFragment();
        mainBLEPermissionReqFragment.setArguments(new Bundle());
        return mainBLEPermissionReqFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_ble_permission_req, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        callback.onMainData("", null, "-", IOUtil.getStringResource(R.string.can_not_use_bluetooth), MainActivity.MainBackgroundState.NORMAL);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_0_0));
        if (PermissionChecker.checkFineLocationPermission(getContext())) {
            MainScreenController.moveMainScreen(MainScreenController.MainScreen.DEFAULT, new Intent());
        }
    }

    @OnClick({R.id.btn_permission_setting})
    public void onRequestBLEPermissionButtonClicked() {
        try {
            getContext().startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.parse("package:" + getContext().getPackageName())));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            getContext().startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }
}
