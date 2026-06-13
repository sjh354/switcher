package kr.switcher.switcherm.ui.irbrand;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;
import kr.switcher.switcherm.ui.irbrand.presenter.IRBrandPresenter;
import kr.switcher.switcherm.ui.irbrand.view.IRBrandView;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandActivity extends IOActivity implements IRBrandView {
    public static final String PARM_CONTROLLER_ID = "CONTROLLER_ID";
    public static final String PARM_REMOCON_NAME = "REMOCON_NAME";
    private static final String TAG = "SettingActivity";
    private IRBrandPresenter presenter;

    @BindView(R.id.tv_activity_title)
    TextView tv_activity_title;

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ir_brand_product_select);
        ButterKnife.bind(this);
        this.presenter = new IRBrandPresenter(this);
        IRBrandProductScreenController.moveSelectProductFragment(this);
    }

    @OnClick({R.id.btn_previous})
    public void onPreviousButtonClicked() {
        this.presenter.onPreviousButtonClicked(this);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandView
    public void finishActivity() {
        finish();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandView
    public void setActivityTitle(String str) {
        this.tv_activity_title.setText(str);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandView
    public void moveProductSelectFragment() {
        IRBrandProductScreenController.moveSelectProductFragment(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.presenter.onPreviousButtonClicked(this);
    }
}
