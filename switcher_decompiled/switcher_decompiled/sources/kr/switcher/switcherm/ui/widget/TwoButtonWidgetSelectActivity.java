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
import kr.switcher.device.switcher.Switcher;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter;
import kr.switcher.switcherm.ui.widget.interactor.FindSwitcherForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.presenter.TwoButtonWidgetSelectPresenter;
import kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class TwoButtonWidgetSelectActivity extends AppCompatActivity implements TwoButtonWidgetSelectView, WidgetAdapter.OnItemClickListener, FindSwitcherForWidgetInteractor.OnFoundSwitcherForWidgetListener {
    private static final String TAG = "TwoButtonWidgetSelectActivity";
    private AppWidgetManager appWidgetManager;
    private TwoButtonWidgetSelectPresenter presenter;
    private RemoteViews remoteView;

    @BindView(R.id.rv_device_list)
    RecyclerView rv_device_list;
    private int widgetId;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_two_button_widget_select);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.widgetId = extras.getInt("appWidgetId", 0);
        }
        this.appWidgetManager = AppWidgetManager.getInstance(this);
        this.remoteView = new RemoteViews(getPackageName(), R.layout.widget_two_button);
        IOUtil.initialize(this);
        setPresenter(new TwoButtonWidgetSelectPresenter(this, new FindSwitcherForWidgetInteractor(this)));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.presenter.onResume();
    }

    public void setPresenter(TwoButtonWidgetSelectPresenter twoButtonWidgetSelectPresenter) {
        this.presenter = twoButtonWidgetSelectPresenter;
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetSelectView
    public void setRecyclerView(List<IODeviceItem> list) {
        WidgetAdapter widgetAdapter = new WidgetAdapter(list, this, WidgetIdFinder.getExistedTwoButtonWidgetIds(this));
        this.rv_device_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.rv_device_list.setAdapter(widgetAdapter);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetSelectView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.TwoButtonWidgetSelectView
    public void addWidget(String str) {
        new WidgetPreference().setWidgetSwitcherAddress(this.widgetId, str);
        this.appWidgetManager.updateAppWidget(this.widgetId, this.remoteView);
        Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.widgetId);
        setResult(-1, intent);
        IOUtil.sendBroadcastToTwoButtonWidget();
        finish();
    }

    @Override // kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter.OnItemClickListener
    public void onItemClick(String str, boolean z) {
        this.presenter.onItemClick(str, z);
    }

    @Override // kr.switcher.switcherm.ui.widget.interactor.FindSwitcherForWidgetInteractor.OnFoundSwitcherForWidgetListener
    public void onFoundSwitcherList(List<Switcher> list) {
        this.presenter.onFoundSwitcherList(list);
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
