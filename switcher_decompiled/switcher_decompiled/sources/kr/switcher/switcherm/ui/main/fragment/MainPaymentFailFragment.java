package kr.switcher.switcherm.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.main.helper.MainScreenController;

/* JADX INFO: loaded from: classes2.dex */
public class MainPaymentFailFragment extends Fragment {
    private static final String TAG = "MainPaymentFailFragment";
    private static MainScreenController.OnMainDataResultCallback callback;

    @BindView(R.id.tv_end_date_time)
    TextView tv_end_date_time;

    @BindView(R.id.tv_start_date_time)
    TextView tv_start_date_time;

    public static MainPaymentFailFragment newInstance(String str, MainScreenController.OnMainDataResultCallback onMainDataResultCallback) {
        callback = onMainDataResultCallback;
        MainPaymentFailFragment mainPaymentFailFragment = new MainPaymentFailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        mainPaymentFailFragment.setArguments(bundle);
        return mainPaymentFailFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_2_1_1));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Switcher switcher;
        View viewInflate = layoutInflater.inflate(R.layout.fragment_main_payment_fail, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return viewInflate;
        }
        String string = arguments.getString("CONNECTED_MAC_ADDRESS");
        if (!IOUtil.checkIsIODeviceKey(string) || (switcher = SwitcherHandler.getInstance().getSwitcher(string)) == null) {
            return viewInflate;
        }
        this.tv_start_date_time.setText("");
        this.tv_end_date_time.setText("");
        callback.onMainData(switcher.getMacAddress(), switcher.getProductId(), switcher.getName(), IOUtil.getStringResource(R.string.serial_number) + switcher.getSerialNumber(), MainActivity.MainBackgroundState.NORMAL);
        return viewInflate;
    }
}
