package kr.switcher.switcherm.ui.start;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.ui.auth.AuthActivity;

/* JADX INFO: loaded from: classes2.dex */
public class StartActivity extends AppCompatActivity {
    private static final int PERMISSION_ACCESS_FINE_LOCATION = 1;
    private static final String TAG = "StartActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        checkPermission();
        setContentView(R.layout.activity_start);
    }

    public void checkPermission() {
        if (Build.VERSION.SDK_INT < 31 || checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) {
            return;
        }
        requestPermissions(new String[]{"android.permission.BLUETOOTH_CONNECT"}, 1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            if (iArr[0] == 0) {
                Log.d("디버깅", "coarse location permission granted");
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("권한 제한");
            builder.setMessage("위치 정보 및 액세스 권한이 허용되지 않았으므로 블루투스를 검색 및 연결할수 없습니다.");
            builder.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: kr.switcher.switcherm.ui.start.StartActivity.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            builder.show();
            return;
        }
        if (i == 2) {
            if (iArr[0] == 0) {
                Log.d("디버깅", "coarse location permission granted");
                return;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setTitle("권한 제한");
            builder2.setMessage("블루투스 스캔권한이 허용되지 않았습니다.");
            builder2.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
            builder2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: kr.switcher.switcherm.ui.start.StartActivity.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            builder2.show();
            return;
        }
        if (i != 3) {
            return;
        }
        if (iArr[0] == 0) {
            Log.d("디버깅", "coarse location permission granted");
            return;
        }
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        builder3.setTitle("권한 제한");
        builder3.setMessage("블루투스 연결 권한이 허용되지 않았습니다.");
        builder3.setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) null);
        builder3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: kr.switcher.switcherm.ui.start.StartActivity.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        });
        builder3.show();
    }

    private void moveActivity(Class cls) {
        startActivity(new Intent(this, (Class<?>) cls));
        finish();
    }

    public void onAuthMenuButtonClicked(View view) {
        moveActivity(AuthActivity.class);
    }

    public void onTermsOfUseButtonClicked(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_TERMS_OF_USE)));
    }
}
