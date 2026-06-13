package kr.switcher.switcherm.service.widget;

import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.common.IOConfig;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.device.IODeviceHandler;
import kr.switcher.switcherm.device.IODeviceMapper;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.ui.main.presenters.SettopRemoconConnectedPresenter;

/* JADX INFO: loaded from: classes2.dex */
public class WidgetSettopService {
    private static final String TAG = "WidgetSettopService";
    private int commandNumber;
    private IODevice ioDevice;
    private List<IRCommand> irCommandList;
    private String COMMAND_SETTOP_POWER = "ON";
    private String COMMAND_SETTOP_CHANNEL_UP = SettopRemoconConnectedPresenter.BUTTON_CHANNEL_UP;
    private String COMMAND_SETTOP_CHANNEL_DOWN = SettopRemoconConnectedPresenter.BUTTON_CHANNEL_DOWN;
    private String COMMAND_SETTOP_VOLUME_UP = SettopRemoconConnectedPresenter.BUTTON_VOLUME_UP;
    private String COMMAND_SETTOP_VOLUME_DOWN = SettopRemoconConnectedPresenter.BUTTON_VOLUME_DOWN;
    private String irId = "";

    public WidgetSettopService(IODevice iODevice, int i) {
        this.ioDevice = iODevice;
        this.commandNumber = i;
    }

    public void setLinker(IODevice iODevice) {
        this.ioDevice = iODevice;
    }

    public void releaseIR() {
        RestSwitcherAPIStore.requestGetIR(((Remocon) IODeviceHandler.getInstance().getDevice(this.ioDevice.getMacAddress())).getId(), new HttpResponseListHandler() { // from class: kr.switcher.switcherm.service.widget.WidgetSettopService.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                WidgetSettopService.this.irCommandList = IODeviceMapper.parseGetIR(list);
                WidgetSettopService widgetSettopService = WidgetSettopService.this;
                widgetSettopService.matchCommand(widgetSettopService.irCommandList);
                WidgetSettopService.this.releaseIRData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void matchCommand(List<IRCommand> list) {
        int i = this.commandNumber;
        if (i == 0) {
            this.irId = findIrId(this.COMMAND_SETTOP_POWER);
            return;
        }
        if (i == 1) {
            this.irId = findIrId(this.COMMAND_SETTOP_CHANNEL_UP);
            return;
        }
        if (i == 2) {
            this.irId = findIrId(this.COMMAND_SETTOP_CHANNEL_DOWN);
        } else if (i == 3) {
            this.irId = findIrId(this.COMMAND_SETTOP_VOLUME_UP);
        } else {
            if (i != 4) {
                return;
            }
            this.irId = findIrId(this.COMMAND_SETTOP_VOLUME_DOWN);
        }
    }

    private String findIrId(String str) {
        for (IRCommand iRCommand : this.irCommandList) {
            if (iRCommand.getName().equals(str)) {
                return iRCommand.getId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseIRData() {
        String str = this.irId;
        if (str != null) {
            RestSwitcherAPIStore.requestPostRelease(str, new HttpResponseHandler() { // from class: kr.switcher.switcherm.service.widget.WidgetSettopService.2
                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onFailure(String str2, String str3) {
                }

                @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
                public void onSuccess(HttpAPIResponse httpAPIResponse) {
                    String name = "";
                    for (IRCommand iRCommand : WidgetSettopService.this.irCommandList) {
                        if (iRCommand.getId() == WidgetSettopService.this.irId) {
                            name = iRCommand.getName();
                        }
                    }
                    if (name.equals("ON") || name.equals(IOConfig.OFF)) {
                        IOUtil.showToast("전원 명령어를 전송하였습니다.");
                    } else {
                        IOUtil.showToast(name + " 명령어를 전송하였습니다.");
                    }
                }
            });
        } else {
            IOUtil.showToast("명령어를 받아오지 못했습니다.");
        }
    }
}
