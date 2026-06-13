package kr.switcher.switcherm.ui.mypage.presenters;

import android.view.View;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.ui.mypage.MyPageItem;
import kr.switcher.switcherm.ui.mypage.adapter.MySwitcherAdapter;
import kr.switcher.switcherm.ui.mypage.helper.MySwitcherHelper;
import kr.switcher.switcherm.ui.mypage.views.MySwitcherAdapterView;

/* JADX INFO: loaded from: classes2.dex */
public class MySwitcherAdapterPresenter {
    private MySwitcherHelper helper = new MySwitcherHelper();
    private MySwitcherAdapterView view;

    public MySwitcherAdapterPresenter(MySwitcherAdapterView mySwitcherAdapterView) {
        this.view = mySwitcherAdapterView;
    }

    public View.OnClickListener getOnClickListener(final int i) {
        return new View.OnClickListener() { // from class: kr.switcher.switcherm.ui.mypage.presenters.MySwitcherAdapterPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MySwitcherAdapterPresenter.this.view.onItemClickToConnect(i);
            }
        };
    }

    public void setSwitcherName(MyPageItem myPageItem, MySwitcherAdapter.ViewHolder viewHolder) {
        if (myPageItem.getName() != null) {
            this.view.setDeviceName(viewHolder, myPageItem.getName());
        } else {
            this.view.setDeviceName(viewHolder, DeviceUtil.getDefaultDeviceName(myPageItem.getProductId()));
        }
    }

    public void setSerialNumber(MyPageItem myPageItem, MySwitcherAdapter.ViewHolder viewHolder) {
        String serialNumber = myPageItem.getSerialNumber();
        if (serialNumber != null) {
            this.view.setSerialNumber(viewHolder, IOUtil.getStringResource(R.string.serial_number) + serialNumber);
            this.view.showSerialNumber(viewHolder);
        } else {
            this.view.setPlanInfo(viewHolder, IOUtil.getStringResource(R.string.status_code0));
            this.view.hideSerialNumber(viewHolder);
        }
    }

    public void setPlanInfo(MyPageItem myPageItem, int i, MySwitcherAdapter.ViewHolder viewHolder) {
        this.view.setPlanInfo(viewHolder, new MySwitcherHelper().getSwitcherInfo(i));
    }
}
