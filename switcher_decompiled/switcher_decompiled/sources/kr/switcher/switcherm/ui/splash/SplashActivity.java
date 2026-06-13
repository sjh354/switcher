package kr.switcher.switcherm.ui.splash;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.loopj.android.http.AsyncHttpClient;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.ActivityController;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.broadcast.IOBroadcastReceiver;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.preference.FCMPreference;
import kr.switcher.switcherm.ui.dialog.signal.interactor.SendStatusForSignalInteractor;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.ui.splash.interactors.FindTokenInteractorImpl;
import kr.switcher.switcherm.ui.splash.presenters.SplashPresenter;
import kr.switcher.switcherm.ui.splash.presenters.SplashPresenterImpl;
import kr.switcher.switcherm.ui.splash.views.SplashView;
import kr.switcher.switcherm.ui.start.StartActivity;

/* JADX INFO: loaded from: classes2.dex */
public class SplashActivity extends AppCompatActivity implements SplashView {
    private static final int SPLASH_TIME_OUT = 100;
    private static final String TAG = "SplashActivity";
    private SplashPresenter presenter;

    private void setBroadcast() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT < 31 || checkPermission()) {
            setBroadcast();
        }
        this.presenter = new SplashPresenterImpl(this, this, new FindTokenInteractorImpl(), new SendStatusForSignalInteractor());
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_0));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        final int intExtra = getIntent().getIntExtra(IOActivity.ACTION, IOActivity.ACTION_MAIN);
        final Parcelable parcelableExtra = getIntent().getParcelableExtra(IOActivity.ACTION_VALUE);
        new Handler().postDelayed(new Runnable() { // from class: kr.switcher.switcherm.ui.splash.SplashActivity.1
            @Override // java.lang.Runnable
            public void run() {
                SplashActivity.this.presenter.onResume(intExtra, parcelableExtra);
            }
        }, 100L);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.presenter.onPause();
        Intent intent = new Intent();
        intent.putExtra(IOActivity.ACTION, IOActivity.ACTION_MAIN);
        setIntent(intent);
        super.onPause();
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public void moveStartActivity() {
        startActivity(new Intent(this, (Class<?>) StartActivity.class));
        finish();
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public void moveMainActivity() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public void showMessage(String str) {
        IOUtil.showToast(str);
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public void showWebsite(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public void moveSettingStrokeMenu(String str) {
        ActivityController.moveSettingStrokeMenuActivity(this, str);
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public void moveSettingReservationMenu(String str) {
        ActivityController.moveSettingReservationMenuActivity(this, str);
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public void updateFCMToken() {
        final FCMPreference fCMPreference = new FCMPreference();
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: kr.switcher.switcherm.ui.splash.SplashActivity.2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w(SplashActivity.TAG, "토큰 생성 실패", task.getException());
                    return;
                }
                String result = task.getResult();
                fCMPreference.setFCMPreference(result);
                RestSwitcherAPIStore.requestPostFCMMobileDevices(result, new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.splash.SplashActivity.2.1
                    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                    public void onSuccess(HttpAPIResponse httpAPIResponse) {
                        IOLog.i(SplashActivity.TAG, "Updating FCM token to server was succeed");
                    }

                    @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                    public void onFailure(String str, String str2) {
                        IOLog.i(SplashActivity.TAG, "Updating FCM token to server was Failed");
                    }
                });
                AsyncHttpClient.log.d("MessageToken", result);
            }
        });
    }

    private IntentFilter makeIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IOBroadcastReceiver.ACTION_LAUNCH);
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        return intentFilter;
    }

    @Override // kr.switcher.switcherm.ui.splash.views.SplashView
    public boolean checkPermission() {
        boolean z;
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        if (checkSelfPermission("android.permission.BLUETOOTH_SCAN") != 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("블루투스에 대한 액세스가 필요합니다");
            builder.setMessage("어플리케이션이 블루투스를 감지 할 수 있도록 위치 정보 액세스 권한을 부여하십시오.");
            builder.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: kr.switcher.switcherm.ui.splash.SplashActivity.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    SplashActivity.this.requestPermissions(new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", "android.permission.POST_NOTIFICATIONS"}, 1);
                }
            });
            builder.show();
            z = false;
        } else {
            z = true;
        }
        return z && z;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (iArr[0] == 0) {
                Log.d("디버깅", "bluetooth scan permission granted");
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("권한 제한");
            builder.setMessage("위치 정보 및 액세스 권한이 허용되지 않았으므로 블루투스를 검색 및 연결할수 없습니다.");
            builder.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: kr.switcher.switcherm.ui.splash.SplashActivity.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            builder.show();
            return;
        }
        if (i != 2) {
            return;
        }
        if (iArr[0] == 0) {
            Log.d("디버깅", "bluetooth connect permission granted");
            return;
        }
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("권한 제한");
        builder2.setMessage("블루투스 연결 권한이 허용되지 않았습니다.");
        builder2.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
        builder2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: kr.switcher.switcherm.ui.splash.SplashActivity.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        builder2.show();
    }
}
