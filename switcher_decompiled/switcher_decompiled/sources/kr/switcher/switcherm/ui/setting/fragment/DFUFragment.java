package kr.switcher.switcherm.ui.setting.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;
import java.io.File;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentDfuBinding;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.preference.SwitcherVersion;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.setting.service.DfuService;
import kr.switcher.switcherm.viewmodel.DFUFragmentViewModel;
import no.nordicsemi.android.dfu.DfuBaseService;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

/* JADX INFO: loaded from: classes2.dex */
public class DFUFragment extends Fragment {
    private static final String TAG = "DFUFragment";
    private FragmentDfuBinding binder;
    private String connectedMacAddress;
    private String deviceName;
    boolean isSucceedDFU;
    private Switcher switcher;
    private DFUFragmentViewModel viewModel;
    private File zipFile;
    boolean isLastVersion = true;
    BroadcastReceiver mDfuUpdateReceiver = new BroadcastReceiver() { // from class: kr.switcher.switcherm.ui.setting.fragment.DFUFragment.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IOLog.i(DFUFragment.TAG, "receiver :" + intent.toString());
        }
    };
    private DfuProgressListener dfuProgressListener = new DfuProgressListener() { // from class: kr.switcher.switcherm.ui.setting.fragment.DFUFragment.3
        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnecting(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onDeviceConnecting: " + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnected(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onDeviceConnected: " + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarting(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onDfuProcessStarting: " + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarted(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onDfuProcessStarted: " + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onEnablingDfuMode(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onEnablingDfuMode: " + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onProgressChanged(String str, final int i, float f, float f2, int i2, int i3) {
            DFUFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: kr.switcher.switcherm.ui.setting.fragment.DFUFragment.3.1
                @Override // java.lang.Runnable
                public void run() {
                    DFUFragment.this.setProgress(i);
                }
            });
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onFirmwareValidating(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onFirmwareValidating: " + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnecting(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onDeviceDisconnecting: " + str);
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnected(String str) {
            if (DFUFragment.this.isSucceedDFU) {
                return;
            }
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onDeviceDisconnecting: " + str);
            DFUFragment.this.viewModel.setMode(0);
            DFUFragment.this.binder.dpProgress.setProgress(0);
            if (DFUFragment.this.switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
                return;
            }
            IOUtil.showToast(IOUtil.getStringResource(R.string.broken_connection));
            DFUFragment.this.onBrokenConnection();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuCompleted(String str) {
            IOLog.i(DFUFragment.TAG, "DfuProgressListener, onDfuCompleted: " + str);
            if (DFUFragment.this.zipFile.exists()) {
                DFUFragment.this.zipFile.delete();
            }
            DFUFragment.this.onDfuCompleted();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuAborted(String str) {
            IOLog.error(DFUFragment.TAG, new OAuthToken().getOAuthToken(), "onDfuAborted", new Exception("DfuProgressListener, onDfuAborted: " + str));
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListener
        public void onError(String str, int i, int i2, String str2) {
            IOLog.error(DFUFragment.TAG, new OAuthToken().getOAuthToken(), "onDfuAborted", new Exception("DfuProgressListener, onError: " + str2));
        }
    };

    public static DFUFragment newInstance(String str) {
        DFUFragment dFUFragment = new DFUFragment();
        Bundle bundle = new Bundle();
        bundle.putString("CONNECTED_MAC_ADDRESS", str);
        dFUFragment.setArguments(bundle);
        return dFUFragment;
    }

    public void setIsLastVersion(boolean z) {
        this.isLastVersion = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentDfuBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_dfu, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.connectedMacAddress = arguments.getString("CONNECTED_MAC_ADDRESS");
        }
        if (!IOUtil.checkIsIODeviceKey(this.connectedMacAddress)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
            getActivity().finish();
            return null;
        }
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(this.connectedMacAddress);
        this.switcher = switcher;
        if (switcher == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_connected_macaddress));
            getActivity().finish();
            return null;
        }
        if (switcher.getAttachedDevice() != null && this.switcher.getAttachedDevice().getDevice() != null) {
            this.deviceName = this.switcher.getAttachedDevice().getDevice().getName();
        } else {
            this.deviceName = "SWITCHER_M";
        }
        this.isSucceedDFU = false;
        Context context = getContext();
        boolean z = this.isLastVersion;
        DFUFragmentViewModel dFUFragmentViewModel = new DFUFragmentViewModel(context, z ? 1 : 0, this.switcher.getName(), this.switcher.getProductId(), this.switcher.getFirmwareVersion());
        this.viewModel = dFUFragmentViewModel;
        this.binder.setViewModel(dFUFragmentViewModel);
        return this.binder.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DfuServiceListenerHelper.registerProgressListener(getContext(), this.dfuProgressListener);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.mDfuUpdateReceiver, makeDfuUpdateIntentFilter());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterDFUService();
    }

    public void onUpdateFirmwareButtonClicked() {
        if (this.switcher.getConnectionState().equals(Switcher.ConnectionState.CONNECTED)) {
            this.switcher.disconnect();
        }
        startDownloadHexFile();
    }

    public void setProgress(int i) {
        this.viewModel.setProgress(i + "%");
        this.binder.dpProgress.setProgress(i);
        if (i == 99) {
            this.isSucceedDFU = true;
        }
    }

    private void startDownloadHexFile() {
        this.viewModel.setMode(2);
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String link = new SwitcherVersion().getLink();
        IOLog.i(TAG, "switcher version : " + this.switcher.getFirmwareVersion());
        asyncHttpClient.get(link, new FileAsyncHttpResponseHandler(getContext()) { // from class: kr.switcher.switcherm.ui.setting.fragment.DFUFragment.1
            @Override // com.loopj.android.http.FileAsyncHttpResponseHandler
            public void onFailure(int i, Header[] headerArr, Throwable th, File file) {
                Toast.makeText(DFUFragment.this.getContext(), "인터넷 상태를 확인해주세요.\n다운로드에 실패했습니다.", 1).show();
                DFUFragment.this.viewModel.setMode(0);
                DFUFragment.this.binder.dpProgress.setProgress(0);
            }

            @Override // com.loopj.android.http.FileAsyncHttpResponseHandler
            public void onSuccess(int i, Header[] headerArr, File file) {
                DFUFragment.this.zipFile = file;
                IOLog.i(DFUFragment.TAG, file.getAbsolutePath());
                IOLog.i(DFUFragment.TAG, headerArr[6].getName());
                IOLog.i(DFUFragment.TAG, headerArr[6].getValue());
                IOLog.i(DFUFragment.TAG, headerArr[6].getElements().toString());
                IOLog.i(DFUFragment.TAG, "started dfu starter");
                DfuServiceInitiator keepBond = new DfuServiceInitiator(DFUFragment.this.connectedMacAddress).setDeviceName(DFUFragment.this.deviceName).setKeepBond(false);
                keepBond.setZip(null, file.getAbsolutePath());
                IOLog.i(DFUFragment.TAG, "set zip file path");
                keepBond.start(DFUFragment.this.getContext(), DfuService.class);
                IOLog.i(DFUFragment.TAG, "started zip");
                DFUFragment.this.viewModel.setProgress(IOUtil.getStringResource(R.string.update_comming_soon));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDfuCompleted() {
        this.viewModel.setProgress("100%");
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.setting.fragment.DFUFragment.4
            @Override // java.lang.Runnable
            public void run() {
                IOUtil.showToast(IOUtil.getStringResource(R.string.completed_update_firmware));
                DFUFragment.this.onBrokenConnection();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBrokenConnection() {
        Intent intent = new Intent(getContext(), (Class<?>) MainActivity.class);
        intent.putExtra(MainActivity.CONNECTED_SWITCHER_ADDRESS, this.connectedMacAddress);
        getActivity().setResult(103, intent);
        getActivity().finish();
    }

    private void unregisterDFUService() {
        DfuServiceListenerHelper.unregisterProgressListener(getContext(), this.dfuProgressListener);
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.mDfuUpdateReceiver);
    }

    private static IntentFilter makeDfuUpdateIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(DfuBaseService.BROADCAST_PROGRESS);
        intentFilter.addAction(DfuBaseService.BROADCAST_ERROR);
        intentFilter.addAction(DfuBaseService.BROADCAST_LOG);
        return intentFilter;
    }
}
