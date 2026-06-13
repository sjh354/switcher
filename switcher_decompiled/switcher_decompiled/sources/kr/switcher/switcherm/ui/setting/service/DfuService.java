package kr.switcher.switcherm.ui.setting.service;

import android.app.Activity;
import kr.switcher.switcherm.ui.setting.SettingActivity;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes2.dex */
public class DfuService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    protected Class<? extends Activity> getNotificationTarget() {
        return SettingActivity.class;
    }
}
