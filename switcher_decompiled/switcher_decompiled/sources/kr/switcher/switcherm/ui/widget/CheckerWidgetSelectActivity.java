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
import kr.switcher.device.checker.Checker;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;
import kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter;
import kr.switcher.switcherm.ui.widget.interactor.FindCheckerForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.interactor.GetCheckerSurveillanceInfoForWidgetInteractor;
import kr.switcher.switcherm.ui.widget.presenter.CheckerWidgetSelectPresenter;
import kr.switcher.switcherm.ui.widget.view.CheckerWidgetSelectView;

/* JADX INFO: loaded from: classes2.dex */
public class CheckerWidgetSelectActivity extends AppCompatActivity implements CheckerWidgetSelectView, WidgetAdapter.OnItemClickListener, FindCheckerForWidgetInteractor.OnFoundCheckerForWidgetListener {
    private static final String TAG = "CheckerWidgetSelectActivity";
    private AppWidgetManager appWidgetManager;
    private CheckerWidgetSelectPresenter presenter;
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
        setContentView(R.layout.activity_checker_widget_select);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.widgetId = extras.getInt("appWidgetId", 0);
        }
        this.appWidgetManager = AppWidgetManager.getInstance(this);
        this.remoteView = new RemoteViews(getPackageName(), R.layout.widget_checker);
        IOUtil.initialize(this);
        setPresenter(new CheckerWidgetSelectPresenter(this, new FindCheckerForWidgetInteractor(this)));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.presenter.onResume();
    }

    public void setPresenter(CheckerWidgetSelectPresenter checkerWidgetSelectPresenter) {
        this.presenter = checkerWidgetSelectPresenter;
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetSelectView
    public void setRecyclerView(List<IODeviceItem> list) {
        WidgetAdapter widgetAdapter = new WidgetAdapter(list, this, WidgetIdFinder.getExistedCheckerWidgetIds(this));
        this.rv_device_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.rv_device_list.setAdapter(widgetAdapter);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetSelectView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetSelectView
    public void addWidget(String str) {
        new WidgetPreference().setWidgetCheckerAddress(this.widgetId, str);
        IOLog.i(TAG, "Test : " + this.widgetId + "/" + str);
        this.appWidgetManager.updateAppWidget(this.widgetId, this.remoteView);
        Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.widgetId);
        setResult(-1, intent);
        new GetCheckerSurveillanceInfoForWidgetInteractor().getCheckerSurveillanceInfo(str, new GetCheckerSurveillanceInfoForWidgetInteractor.OnGetCheckerSurveillanceListener() { // from class: kr.switcher.switcherm.ui.widget.CheckerWidgetSelectActivity.1
            @Override // kr.switcher.switcherm.ui.widget.interactor.GetCheckerSurveillanceInfoForWidgetInteractor.OnGetCheckerSurveillanceListener
            public void onFind(List<CheckerSurveillanceItem> list) {
                CheckerWidgetSelectActivity.this.presenter.onFind(CheckerWidgetSelectActivity.this.widgetId, list);
            }
        });
        new FindRecentCheckerHistoryInteractor().findRecentCheckerHistoryForWidget(str, new FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener() { // from class: kr.switcher.switcherm.ui.widget.CheckerWidgetSelectActivity.2
            @Override // kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener
            public void onFindNextPageHistories(List<CheckerHistoryItem> list) {
            }

            @Override // kr.switcher.switcherm.ui.setting.interactor.FindRecentCheckerHistoryInteractor.OnFindRecentCheckerHistoryListener
            public void onFindHistories(List<CheckerHistoryItem> list) {
                CheckerWidgetSelectActivity.this.presenter.onFindHistories(CheckerWidgetSelectActivity.this.widgetId, list);
            }
        });
        new GetCheckerIsOpenInteractor().getCheckerInfoForWidget(str, new GetCheckerIsOpenInteractor.OnGetCheckerInfoListener() { // from class: kr.switcher.switcherm.ui.widget.CheckerWidgetSelectActivity.3
            @Override // kr.switcher.switcherm.ui.main.interactors.GetCheckerIsOpenInteractor.OnGetCheckerInfoListener
            public void onGetCheckerInfo(String str2) {
                CheckerWidgetSelectActivity.this.presenter.onGetCheckerInfo(CheckerWidgetSelectActivity.this.widgetId, str2);
            }
        });
        finish();
    }

    @Override // kr.switcher.switcherm.ui.widget.view.CheckerWidgetSelectView
    public void sendBroadcastToWidget() {
        IOUtil.sendBroadcastToCheckerWidget();
    }

    @Override // kr.switcher.switcherm.ui.widget.adapter.WidgetAdapter.OnItemClickListener
    public void onItemClick(String str, boolean z) {
        this.presenter.onItemClick(str, z);
    }

    @Override // kr.switcher.switcherm.ui.widget.interactor.FindCheckerForWidgetInteractor.OnFoundCheckerForWidgetListener
    public void onFoundCheckerList(List<Checker> list) {
        this.presenter.onFoundCheckerList(list);
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
