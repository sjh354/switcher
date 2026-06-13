package kr.switcher.switcherm.ui.start;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.IOUri;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.main.MainActivity;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;

/* JADX INFO: loaded from: classes2.dex */
public class HelloActivity extends AppCompatActivity {
    private static final String TAG = "HelloActivity";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hello);
        User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        String userName = currentUserFromDB != null ? currentUserFromDB.getUserName() : "";
        TextView textView = (TextView) findViewById(R.id.btn_confirm);
        TextView textView2 = (TextView) findViewById(R.id.tv_welcome_name);
        TextView textView3 = (TextView) findViewById(R.id.tv_welcome_info);
        TextView textView4 = (TextView) findViewById(R.id.tv_bottom);
        if (!userName.equals(IOUtil.getStringResource(R.string.default_user_name))) {
            textView3.setText(IOUtil.getStringResource(R.string.welcome_info1));
            textView4.setVisibility(4);
        } else {
            textView3.setText(IOUtil.getStringResource(R.string.welcome_info2));
            textView4.setVisibility(0);
            textView4.setText("스위처 공식 웹사이트");
            textView4.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.start.HelloActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    HelloActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUri.URI_IO)));
                }
            });
        }
        textView.setText(IOUtil.getStringResource(R.string.confirm));
        textView.setOnClickListener(new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.start.HelloActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HelloActivity.this.moveActivity(MainActivity.class);
            }
        });
        textView2.setText(userName + "님 " + IOUtil.getStringResource(R.string.welcome));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveActivity(Class cls) {
        startActivity(new Intent(this, (Class<?>) cls));
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        moveActivity(MainActivity.class);
    }
}
