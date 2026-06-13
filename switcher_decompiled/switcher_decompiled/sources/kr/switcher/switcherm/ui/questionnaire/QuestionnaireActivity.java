package kr.switcher.switcherm.ui.questionnaire;

import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;

/* JADX INFO: loaded from: classes2.dex */
public class QuestionnaireActivity extends IOActivity implements OnFinishFragmentListener {
    private static final String TAG = "QuestionnaireActivity";
    private String connectedMacAddress;

    @Override // kr.switcher.switcherm.ui.questionnaire.OnFinishFragmentListener
    public void onFinish() {
    }

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_questionnaire);
        ButterKnife.bind(this);
        this.connectedMacAddress = getIntent().getStringExtra("CONNECTED_MAC_ADDRESS");
        new QuestionnaireData().initialize();
        QuestionnaireScreenController.moveQuestionnaireFragment(this, this.connectedMacAddress);
    }

    @OnClick({R.id.btn_cancel})
    public void onCancelButtonClicked() {
        finish();
    }
}
