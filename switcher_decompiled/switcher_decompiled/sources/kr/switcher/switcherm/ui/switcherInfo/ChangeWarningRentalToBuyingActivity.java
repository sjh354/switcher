package kr.switcher.switcherm.ui.switcherInfo;

import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.activity.IOActivity;

/* JADX INFO: loaded from: classes2.dex */
public class ChangeWarningRentalToBuyingActivity extends IOActivity {
    public static final int ALL = 0;
    public static final int DEVICE_PRICE = 1;
    public static final int EXCHANGING_NUMBER = 3;
    public static final String PARM_PAGE = "PAGE";
    public static final int SALE_PRICE = 2;

    @Override // kr.switcher.switcherm.common.activity.IOActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(PARM_PAGE, 0);
        if (intExtra == 1) {
            setContentView(R.layout.activity_change_warning_rental_to_buying_for_device_price);
        } else if (intExtra == 2) {
            setContentView(R.layout.activity_change_warning_rental_to_buying_for_sale_price);
        } else if (intExtra == 3) {
            setContentView(R.layout.activity_change_warning_rental_to_buying_for_exchaning_number);
        } else {
            setContentView(R.layout.activity_change_warning_rental_to_buying);
        }
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_close})
    public void onCloseButtonClicked() {
        finish();
    }
}
