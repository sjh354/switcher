package kr.switcher.switcherm.ui.troubleshooting.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.switcher.handler.SwitcherUtil;
import kr.switcher.switcherm.ui.dialog.IODialogController;
import kr.switcher.switcherm.ui.mypage.adapter.TroubleshootingAdapter;
import kr.switcher.switcherm.ui.troubleshooting.TroubleshootingActivity;

/* JADX INFO: loaded from: classes2.dex */
public class HelpTroubleshootingFragment extends Fragment {
    private static final String TAG = "HelpTroubleshootingFragment";

    @BindView(R.id.btn_gps_setting)
    RelativeLayout btn_gps_setting;

    @BindView(R.id.cb_bluetooth)
    CheckBox cb_bluetooth;

    @BindView(R.id.cb_gps)
    CheckBox cb_gps;
    private Map<String, List<String>> children;
    private String from;
    private List<String> groups;

    @BindView(R.id.tv_cafe_link)
    TextView tv_cafe_link;

    @BindView(R.id.tv_gps_setting)
    TextView tv_gps_setting;

    @BindView(R.id.tv_yello_id_link)
    TextView tv_yello_id_link;

    public static HelpTroubleshootingFragment newInstance(String str) {
        HelpTroubleshootingFragment helpTroubleshootingFragment = new HelpTroubleshootingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TroubleshootingActivity.AI_FROM, str);
        helpTroubleshootingFragment.setArguments(bundle);
        return helpTroubleshootingFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_help_troubleshooting, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.from = arguments.getString(TroubleshootingActivity.AI_FROM);
        }
        this.tv_cafe_link.setText(Html.fromHtml("<u>블루투스 문제 카페 이동</u>"));
        this.tv_gps_setting.setText(Html.fromHtml("<u>GPS 활성화</u>"));
        this.tv_yello_id_link.setText(Html.fromHtml("<u>카카오톡으로 문의하기</u>"));
        if (TroubleshootingActivity.FROM_SCANNED_SWITCHER.equals(this.from)) {
            IOLog.activity(IOUtil.getStringResource(R.string.screen_title_3_1_1_0));
        } else if (TroubleshootingActivity.FROM_USER_INFO.equals(this.from)) {
            IOLog.activity(IOUtil.getStringResource(R.string.screen_title_6_0_0_0));
        }
        initResource();
        initView(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.cb_gps.setChecked(IOUtil.checkGPSIsEnabled());
        this.cb_bluetooth.setChecked(SwitcherUtil.isBluetoothActive());
    }

    private void initResource() {
        ArrayList arrayList = new ArrayList();
        this.groups = arrayList;
        arrayList.add("    " + IOUtil.getStringResource(R.string.troubleshooting_topic1));
        this.groups.add("    " + IOUtil.getStringResource(R.string.troubleshooting_topic2));
        this.groups.add("    " + IOUtil.getStringResource(R.string.troubleshooting_topic3));
        this.groups.add("    " + IOUtil.getStringResource(R.string.troubleshooting_topic4));
        this.groups.add("    " + IOUtil.getStringResource(R.string.troubleshooting_topic5));
        this.groups.add("    " + IOUtil.getStringResource(R.string.troubleshooting_topic6));
        this.groups.add("    " + IOUtil.getStringResource(R.string.troubleshooting_topic7));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        arrayList2.add(IOUtil.getStringResource(R.string.troubleshooting_info1_0));
        arrayList2.add(IOUtil.getStringResource(R.string.troubleshooting_info1_1));
        arrayList2.add(IOUtil.getStringResource(R.string.troubleshooting_info1_2));
        arrayList2.add(IOUtil.getStringResource(R.string.troubleshooting_info1_3));
        arrayList2.add(IOUtil.getStringResource(R.string.troubleshooting_info1_4));
        arrayList3.add(IOUtil.getStringResource(R.string.troubleshooting_info2_1));
        arrayList3.add(IOUtil.getStringResource(R.string.troubleshooting_info2_2));
        arrayList3.add(IOUtil.getStringResource(R.string.troubleshooting_info2_3));
        arrayList3.add(IOUtil.getStringResource(R.string.troubleshooting_info2_4));
        HashMap map = new HashMap();
        this.children = map;
        map.put(this.groups.get(0), arrayList2);
        this.children.put(this.groups.get(1), arrayList3);
        this.children.put(this.groups.get(2), Arrays.asList(IOUtil.getStringResource(R.string.troubleshooting_info3)));
        this.children.put(this.groups.get(3), Arrays.asList(IOUtil.getStringResource(R.string.troubleshooting_info4)));
        this.children.put(this.groups.get(4), Arrays.asList(IOUtil.getStringResource(R.string.troubleshooting_info5)));
        this.children.put(this.groups.get(5), Arrays.asList(IOUtil.getStringResource(R.string.troubleshooting_info6)));
        this.children.put(this.groups.get(6), Arrays.asList(IOUtil.getStringResource(R.string.troubleshooting_info7)));
    }

    private void initView(View view) {
        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.rv_troubleshooting);
        expandableListView.setAdapter(new TroubleshootingAdapter(getContext(), this.groups, this.children));
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment.1
            @Override // android.widget.ExpandableListView.OnChildClickListener
            public boolean onChildClick(ExpandableListView expandableListView2, View view2, int i, int i2, long j) {
                return false;
            }
        });
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment.2
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public boolean onGroupClick(ExpandableListView expandableListView2, View view2, int i, long j) {
                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment.3
            @Override // android.widget.ExpandableListView.OnGroupExpandListener
            public void onGroupExpand(int i) {
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() { // from class: kr.switcher.switcherm.ui.troubleshooting.fragment.HelpTroubleshootingFragment.4
            @Override // android.widget.ExpandableListView.OnGroupCollapseListener
            public void onGroupCollapse(int i) {
            }
        });
    }

    @OnClick({R.id.btn_cafe_link})
    public void onCafeLinkButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.cafe_link_bluetooth_trouble))));
    }

    @OnClick({R.id.btn_yello_id_link})
    public void onYelloIDLinkButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.yello_id_link))));
    }

    @OnClick({R.id.btn_gps_setting})
    public void onGPSSettingTextClicked() {
        IODialogController.showConfirmDialog(getContext(), "구글 정책으로 스위처를 블루투스로 검색하기 위해서는 GPS를 꼭 활성화 해주셔야 돼요", null);
    }

    @OnClick({R.id.cb_gps})
    public void onGPSSettingChecked() {
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);
    }

    @OnClick({R.id.cb_bluetooth})
    public void onBluetoothSettingChecked() {
        if (this.cb_bluetooth.isChecked()) {
            SwitcherUtil.activeBluetooth();
        } else {
            SwitcherUtil.unactiveBluetooth();
        }
    }
}
