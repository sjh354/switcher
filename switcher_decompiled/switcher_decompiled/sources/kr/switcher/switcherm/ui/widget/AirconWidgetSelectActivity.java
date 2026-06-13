package kr.switcher.switcherm.ui.widget;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.linker.LinkerHandler;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter;
import kr.switcher.switcherm.ui.widget.interactor.FindRemoconForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.presenter.AirconWidgetSelectPresenter;
import kr.switcher.switcherm.ui.widget.view.AirconWidgetSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class AirconWidgetSelectActivity extends AppCompatActivity implements AirconWidgetSelectView, WidgetAdapter.OnItemClickListener, FindRemoconForWidgetInteractor.OnFoundRemoconForWidgetListener {
    private static final String TAG = "AirconWidgetSelectActivity";
    private AppWidgetManager appWidgetManager;
    private AirconWidgetSelectPresenter presenter;
    private RemoteViews remoteView;

    @BindView(R.id.rv_device_list)
    RecyclerView rv_device_list;
    private int widgetId;

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_aircon_widget_select);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.widgetId = extras.getInt("appWidgetId", 0);
        }
        this.appWidgetManager = AppWidgetManager.getInstance(this);
        this.remoteView = new RemoteViews(getPackageName(), R.layout.widget_aircon);
        IOUtil.initialize(this);
        setPresenter(new AirconWidgetSelectPresenter(this, new FindRemoconForWidgetInteractor(this)));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.presenter.onResume();
    }

    public void setPresenter(AirconWidgetSelectPresenter airconWidgetSelectPresenter) {
        this.presenter = airconWidgetSelectPresenter;
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetSelectView
    public void setRecyclerView(List<IODeviceItem> list) {
        WidgetAdapter widgetAdapter = new WidgetAdapter(list, this, WidgetIdFinder.getExistedAirconWidgetIds(this));
        this.rv_device_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.rv_device_list.setAdapter(widgetAdapter);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetSelectView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetSelectView
    public void addWidget(String str) {
        final WidgetPreference widgetPreference = new WidgetPreference();
        widgetPreference.setWidgetSwitcherAddress(this.widgetId, str);
        Linker linker = LinkerHandler.getInstance().getAliveLinkers().size() > 0 ? LinkerHandler.getInstance().getAliveLinkers().get(0) : null;
        if (linker != null) {
            widgetPreference.setWidgetAliveLinker(linker.getMacAddress());
        }
        this.appWidgetManager.updateAppWidget(this.widgetId, this.remoteView);
        Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.widgetId);
        setResult(-1, intent);
        new GetCurrentSensorValueForWidgetInteractor().getCurrentSensorValueListener(str, new GetCurrentSensorValueForWidgetInteractor.OnGetCurrentSensorValueListener() { // from class: kr.switcher.switcherm.ui.widget.AirconWidgetSelectActivity.1
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetCurrentSensorValueListener
            public void onFind(String str2) {
                AirconWidgetSelectActivity.this.presenter.onFind(AirconWidgetSelectActivity.this.widgetId, str2);
            }
        });
        new GetCurrentSensorValueForWidgetInteractor().getAliveLinker(new GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener() { // from class: kr.switcher.switcherm.ui.widget.AirconWidgetSelectActivity.2
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onError() {
            }

            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCurrentSensorValueForWidgetInteractor.OnGetAliveLinkerListener
            public void onFindAliveLinker(String str2) {
                if (str2 != null) {
                    widgetPreference.setWidgetAliveLinker(str2);
                    IOUtil.sendBroadcastToAirconWidget();
                } else {
                    widgetPreference.setWidgetAliveLinker("");
                    IOUtil.sendBroadcastToAirconWidget();
                    IOUtil.showToast("링커의 연결이 끊어져 있습니다. \n 링커의 전원을 확인해 주세요.");
                }
            }
        });
        sendBroadcastToWidget();
        finish();
    }

    @Override // kr.switcher.switcherm.ui.widget.view.AirconWidgetSelectView
    public void sendBroadcastToWidget() {
        IOUtil.sendBroadcastToAirconWidget();
    }

    @Override // kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter.OnItemClickListener
    public void onItemClick(String str, boolean z) {
        this.presenter.onItemClick(str, z);
    }

    @Override // kr.switcher.switcherm.ui.widget.interactor.FindRemoconForWidgetInteractor.OnFoundRemoconForWidgetListener
    public void onFoundRemoconList(List<Remocon> list) {
        this.presenter.onFoundRemoconList(list);
    }

    private class NotificationMessage {
        String content;
        String title;

        public NotificationMessage(String str, String str2) {
            this.title = str;
            this.content = str2;
        }
    }
}
