package kr.switcher.switcherm.ui.switcherList.views;

import java.util.List;
import kr.switcher.switcherm.ui.switcherList.adapter.IODeviceItem;
import kr.switcher.switcherm.ui.switcherList.adapter.SwitcherAdapter;

/* JADX INFO: loaded from: classes2.dex */
public interface SwitcherAdapterView {
    void initialize(IODeviceItem iODeviceItem, SwitcherAdapter.ViewHolder viewHolder, int i);

    void onItemClickToChecker(int i);

    void onItemClickToCheckerWifiSetting(int i);

    void onItemClickToConnect(int i);

    void onItemClickToInfo(int i);

    void onItemClickToLinker(int i);

    void onItemClickToLinkerWifiSetting(int i);

    void onItemClickToMainThing(int i);

    void refresh();

    void setAircon(SwitcherAdapter.ViewHolder viewHolder);

    void setChecker(String str, SwitcherAdapter.ViewHolder viewHolder);

    void setCheckerProduction(SwitcherAdapter.ViewHolder viewHolder);

    void setCheckerWifiSetting(SwitcherAdapter.ViewHolder viewHolder);

    void setLinker(SwitcherAdapter.ViewHolder viewHolder);

    void setLinkerItems(List<IODeviceItem> list);

    void setLinkerProduction(SwitcherAdapter.ViewHolder viewHolder);

    void setLinkerSwitcherOneType(SwitcherAdapter.ViewHolder viewHolder);

    void setLinkerSwitcherTwoType(SwitcherAdapter.ViewHolder viewHolder);

    void setLinkerWifiSetting(SwitcherAdapter.ViewHolder viewHolder);

    void setRemocon(SwitcherAdapter.ViewHolder viewHolder);

    void setSetTopBox(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherGWStatusIsConnected(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherStatusIsConnected(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOneAndConnectable(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOneAndDelivery(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOneAndNotScanned(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOneAndReturn(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOneAndReturnComplete(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOneAndScanned(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOneProduction(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsOtherProduction(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsTwoAndConnectable(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsTwoAndDelivery(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsTwoAndNotScanned(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsTwoAndReturn(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsTwoAndReturnComplete(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsTwoAndScanned(SwitcherAdapter.ViewHolder viewHolder);

    void setSwitcherTypeIsTwoProduction(SwitcherAdapter.ViewHolder viewHolder);

    void setTV(SwitcherAdapter.ViewHolder viewHolder);
}
