package kr.switcher.switcherm.ui.mypage.views;

import kr.switcher.switcherm.ui.mypage.adapter.MySwitcherAdapter;

/* JADX INFO: loaded from: classes2.dex */
public interface MySwitcherAdapterView {
    void hideSerialNumber(MySwitcherAdapter.ViewHolder viewHolder);

    void onItemClickToConnect(int i);

    void setDeviceName(MySwitcherAdapter.ViewHolder viewHolder, String str);

    void setPlanInfo(MySwitcherAdapter.ViewHolder viewHolder, String str);

    void setSerialNumber(MySwitcherAdapter.ViewHolder viewHolder, String str);

    void showSerialNumber(MySwitcherAdapter.ViewHolder viewHolder);
}
