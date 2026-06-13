package kr.switcher.switcherm.ui.wifi.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODeviceConfig;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.wifi.WifiData;
import kr.switcher.switcherm.network.wifi.WifiScanner;
import kr.switcher.switcherm.ui.wifi.adapters.WifiAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class WifiListFragment extends Fragment implements WifiAdapter.OnItemClickListener, WifiScanner.OnWifiResultCallback {
    private static OnWifiDataResultCallback callback;
    private WifiAdapter adapter;

    @BindView(R.id.rl_find_wifi)
    RelativeLayout rl_find_wifi;

    @BindView(R.id.rl_gps_suggest)
    RelativeLayout rl_gps_suggest;

    @BindView(R.id.rl_wifi_list)
    RelativeLayout rl_wifi_list;

    @BindView(R.id.rv_wifi_list)
    RecyclerView rv_wifi_list;
    private WifiScanner scanner;

    @BindView(R.id.tv_gps_setting)
    TextView tv_gps_setting;

    @BindView(R.id.tv_issue)
    TextView tv_issue;
    private List<WifiData> wifiDatas;

    public interface OnWifiDataResultCallback {
        void onWifiDataResult(WifiData wifiData);
    }

    public static WifiListFragment newInstance(OnWifiDataResultCallback onWifiDataResultCallback) {
        callback = onWifiDataResultCallback;
        return new WifiListFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_wifi_list, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        if (IOUtil.checkWifiIsEnabled() && IOUtil.checkGPSIsEnabled()) {
            showFindWifi();
        } else {
            showWifiNotFound();
        }
        WifiScanner wifiScanner = new WifiScanner(getContext());
        this.scanner = wifiScanner;
        wifiScanner.setWifiResultCallback(this);
        initRecyclerListView();
        startScan();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopScan();
    }

    public void initRecyclerListView() {
        this.wifiDatas = new ArrayList();
        this.adapter = new WifiAdapter(this.wifiDatas, this);
        this.rv_wifi_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_wifi_list.setAdapter(this.adapter);
    }

    public void startScan() {
        this.scanner.startScan();
    }

    public void stopScan() {
        this.scanner.stopScan();
    }

    public void refresh() {
        this.adapter.notifyDataSetChanged();
    }

    public void showWifiList() {
        this.rl_wifi_list.setVisibility(0);
        this.rl_find_wifi.setVisibility(8);
        this.rl_gps_suggest.setVisibility(8);
    }

    public void showWifiNotFound() {
        this.tv_gps_setting.setVisibility(8);
        if (!IOUtil.checkGPSIsEnabled()) {
            this.tv_issue.setText("GPS가 꺼져있군요!\nWi-Fi를 검색하려면 GPS가 켜져있어야 해요");
            this.tv_gps_setting.setVisibility(0);
        } else {
            this.tv_issue.setText("주변에 Wi-Fi를 찾지 못했습니다");
        }
        this.rl_gps_suggest.setVisibility(0);
        this.rl_wifi_list.setVisibility(8);
        this.rl_find_wifi.setVisibility(8);
    }

    public void showFindWifi() {
        this.rl_find_wifi.setVisibility(0);
        this.rl_wifi_list.setVisibility(8);
        this.rl_gps_suggest.setVisibility(8);
    }

    @Override // kr.switcher.switcherm.ui.wifi.adapters.WifiAdapter.OnItemClickListener
    public void onItemClicked(int i) {
        callback.onWifiDataResult(this.adapter.getItem(i));
    }

    @Override // kr.switcher.switcherm.network.wifi.WifiScanner.OnWifiResultCallback
    public void onWifiResult(List<WifiData> list) {
        for (WifiData wifiData : list) {
            if (!wifiData.getSsid().contains(IODeviceConfig.IO_WIFI_NAME) && wifiData.getSsid().length() > 0 && !wifiData.getSsid().equals("")) {
                this.wifiDatas.add(wifiData);
            }
        }
        refresh();
        if (this.wifiDatas.size() > 0) {
            showWifiList();
        } else {
            showWifiNotFound();
        }
    }

    @OnClick({R.id.tv_gps_setting})
    public void onGPSSettingButtonClicked() {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);
    }
}
