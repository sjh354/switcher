package kr.switcher.switcherm.device;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.checker.Checker;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.remocon.IRCommand;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.device.switcher.ble.SwitcherBLE;
import kr.switcher.device.switcher.option.PaymentInfo;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.network.http.response.AppliancesAPIResponse;
import kr.switcher.switcherm.network.http.response.BrandsAPIResponse;
import kr.switcher.switcherm.network.http.response.CheckerHistoriesAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateApplianceMeAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateIRDBRequestAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateIRDBTestAPIResponse;
import kr.switcher.switcherm.network.http.response.CreateModifyIRInfoAPIResponse;
import kr.switcher.switcherm.network.http.response.DevicesMeAPIResponse;
import kr.switcher.switcherm.network.http.response.IRAPIResponse;
import kr.switcher.switcherm.network.http.response.PostSurveillanceAPIResponse;
import kr.switcher.switcherm.network.http.response.RemoconMaintenanceAPIResponse;
import kr.switcher.switcherm.network.http.response.RemoconReservationAPIResponse;
import kr.switcher.switcherm.network.http.response.RemoteControllersAPIResponse;
import kr.switcher.switcherm.preference.WidgetPreference;
import kr.switcher.switcherm.ui.irbrand.adapter.BrandItem;
import kr.switcher.switcherm.ui.irbrand.helper.ControllerItem;
import kr.switcher.switcherm.ui.setting.adapter.AirconMaintainingTemperatureItem;
import kr.switcher.switcherm.ui.setting.adapter.AirconReservationItem;
import kr.switcher.switcherm.ui.setting.adapter.CheckerHistoryItem;
import kr.switcher.switcherm.ui.setting.adapter.CheckerSurveillanceItem;

/* JADX INFO: loaded from: classes2.dex */
public class IODeviceMapper {
    private static final String CHECKER = "4";
    private static final String LINKER = "3";
    private static final String SWITCHER_TYPE_ONE = "1";
    private static final String SWITCHER_TYPE_TWO = "2";
    private static String TAG = "IODeviceMapper";

    public static List<IODevice> parseGetDevicesMe(List<DevicesMeAPIResponse> list) {
        IODevice switcherBLE;
        ArrayList arrayList = new ArrayList();
        for (DevicesMeAPIResponse devicesMeAPIResponse : list) {
            String strMakeLocalMacAddressFormat = IOUtil.makeLocalMacAddressFormat(devicesMeAPIResponse.getMacAddress());
            IODevice.ProductId productIdConvertProductId = DeviceUtil.convertProductId(Integer.parseInt(devicesMeAPIResponse.product_id));
            int i = AnonymousClass2.$SwitchMap$kr$switcher$device$IODevice$ProductId[productIdConvertProductId.ordinal()];
            if (i == 1 || i == 2) {
                switcherBLE = new SwitcherBLE(strMakeLocalMacAddressFormat, productIdConvertProductId);
                arrayList.add(switcherBLE);
            } else {
                if (i == 3) {
                    switcherBLE = new Linker(strMakeLocalMacAddressFormat);
                } else if (i == 4) {
                    switcherBLE = new Checker(strMakeLocalMacAddressFormat);
                }
                arrayList.add(switcherBLE);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.device.IODeviceMapper$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;

        static {
            int[] iArr = new int[IODevice.ProductId.values().length];
            $SwitchMap$kr$switcher$device$IODevice$ProductId = iArr;
            try {
                iArr[IODevice.ProductId.SWITCHER_TYPE_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.SWITCHER_TYPE_TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.LINKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.CHECKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static Linker parseGetAliveLinker(List<DevicesMeAPIResponse> list) {
        for (DevicesMeAPIResponse devicesMeAPIResponse : list) {
            if (devicesMeAPIResponse.product_id.equals("3") && devicesMeAPIResponse.connection_status.equals("alive")) {
                new WidgetPreference().setWidgetAliveLinker(devicesMeAPIResponse.mac_address);
                return (Linker) IODeviceHandler.getInstance().getDevice(devicesMeAPIResponse.mac_address);
            }
        }
        return null;
    }

    public static String parseGetAliveLinkerMacAddress(List<DevicesMeAPIResponse> list) {
        for (DevicesMeAPIResponse devicesMeAPIResponse : list) {
            if (devicesMeAPIResponse.product_id.equals("3") && devicesMeAPIResponse.connection_status.equals("alive")) {
                new WidgetPreference().setWidgetAliveLinker(devicesMeAPIResponse.mac_address);
                return IOUtil.makeLocalMacAddressFormat(devicesMeAPIResponse.mac_address);
            }
        }
        return null;
    }

    public static List<IODevice> parseLinkers(String str) {
        try {
            List<LinkerData> list = (List) new Gson().fromJson(str, new TypeToken<List<LinkerData>>() { // from class: kr.switcher.switcherm.device.IODeviceMapper.1
            }.getType());
            ArrayList arrayList = new ArrayList();
            for (LinkerData linkerData : list) {
                if (linkerData.status.equals("alive")) {
                    Linker linker = new Linker(DeviceUtil.makeMacAddressWithSemicolon(linkerData.mac_address));
                    linker.setName(DeviceUtil.getDefaultDeviceName(linker));
                    linker.setSerialNumber("AAAAAAAA");
                    linker.setOwner("Gudnam");
                    linker.setShareCode("1111");
                    linker.getOption().setShippingStatus(4);
                    linker.getOption().setPaymentMethod(2, "2019-03-23");
                    linker.getOption().getPaymentInfo().setType(PaymentInfo.BUYING_TYPE_CONTRACT);
                    arrayList.add(linker);
                }
            }
            return arrayList;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static List<IRCommand> parseGetIR(List<IRAPIResponse> list) {
        ArrayList arrayList = new ArrayList();
        for (IRAPIResponse iRAPIResponse : list) {
            arrayList.add(new IRCommand(String.valueOf(iRAPIResponse.id), iRAPIResponse.name));
        }
        return arrayList;
    }

    public static List<ControllerItem> parseGetController(RemoteControllersAPIResponse remoteControllersAPIResponse) {
        ArrayList arrayList = new ArrayList();
        for (RemoteControllersAPIResponse.ControllerResult controllerResult : remoteControllersAPIResponse.results) {
            ControllerItem controllerItem = new ControllerItem(controllerResult.getId(), controllerResult.getName());
            if (controllerResult.getId() == 1) {
                controllerItem.setItemImage(IOUtil.makeDrawable(R.drawable.ic_ir_tv_small));
            } else if (controllerResult.getId() == 2) {
                controllerItem.setItemImage(IOUtil.makeDrawable(R.drawable.ic_ir_aircon_small));
            } else if (controllerResult.getId() == 3) {
                controllerItem.setItemImage(IOUtil.makeDrawable(R.drawable.ic_ir_settop_small));
            }
            arrayList.add(controllerItem);
        }
        ControllerItem controllerItem2 = new ControllerItem(arrayList.size() + 1, "리모컨 학습");
        controllerItem2.setItemImage(IOUtil.makeDrawable(R.drawable.ic_ir_remocon_small));
        arrayList.add(controllerItem2);
        return arrayList;
    }

    public static List<BrandItem> parseGetBrands(List<BrandsAPIResponse> list) {
        ArrayList arrayList = new ArrayList();
        for (BrandsAPIResponse brandsAPIResponse : list) {
            arrayList.add(new BrandItem(brandsAPIResponse.id, brandsAPIResponse.name));
        }
        return arrayList;
    }

    public static List<AirconReservationItem> parseGetRemoconResrvation(List<RemoconReservationAPIResponse> list) {
        ArrayList arrayList = new ArrayList();
        for (RemoconReservationAPIResponse remoconReservationAPIResponse : list) {
            arrayList.add(new AirconReservationItem(remoconReservationAPIResponse.mac_address, remoconReservationAPIResponse.week, remoconReservationAPIResponse.created_at, remoconReservationAPIResponse.time, remoconReservationAPIResponse.week_time, remoconReservationAPIResponse.is_enabled, remoconReservationAPIResponse.appliance_id, remoconReservationAPIResponse.title, remoconReservationAPIResponse.tag, remoconReservationAPIResponse.ir_id_list));
        }
        return arrayList;
    }

    public static List<AirconMaintainingTemperatureItem> parseGetRemoconMaintenance(List<RemoconMaintenanceAPIResponse> list) {
        ArrayList arrayList = new ArrayList();
        for (RemoconMaintenanceAPIResponse remoconMaintenanceAPIResponse : list) {
            arrayList.add(new AirconMaintainingTemperatureItem(remoconMaintenanceAPIResponse.id, remoconMaintenanceAPIResponse.title, remoconMaintenanceAPIResponse.is_enabled, remoconMaintenanceAPIResponse.goal_temperature, remoconMaintenanceAPIResponse.week_days, remoconMaintenanceAPIResponse.start_time_at, remoconMaintenanceAPIResponse.end_time_at, remoconMaintenanceAPIResponse.created_at, remoconMaintenanceAPIResponse.appliances));
        }
        return arrayList;
    }

    public static List<CheckerSurveillanceItem> parseGetCheckersSurveillance(List<PostSurveillanceAPIResponse> list) {
        ArrayList arrayList = new ArrayList();
        for (PostSurveillanceAPIResponse postSurveillanceAPIResponse : list) {
            arrayList.add(new CheckerSurveillanceItem(postSurveillanceAPIResponse.id, postSurveillanceAPIResponse.title, postSurveillanceAPIResponse.is_active.booleanValue() ? "True" : "False", postSurveillanceAPIResponse.trespass_duration_min, postSurveillanceAPIResponse.alarm_duration_min, postSurveillanceAPIResponse.level, postSurveillanceAPIResponse.week_days, postSurveillanceAPIResponse.start_at.replace(":", ""), postSurveillanceAPIResponse.end_at.replace(":", ""), postSurveillanceAPIResponse.created_at, postSurveillanceAPIResponse.chekcer));
        }
        return arrayList;
    }

    public static Remocon parseGetRemocon(CreateApplianceMeAPIResponse createApplianceMeAPIResponse) {
        if (createApplianceMeAPIResponse == null) {
            return null;
        }
        return new Remocon(String.valueOf(createApplianceMeAPIResponse.id), createApplianceMeAPIResponse.name, Remocon.convertIntToControllerID(createApplianceMeAPIResponse.remote_controller));
    }

    public static List<Remocon> parseGetAppliances(List<AppliancesAPIResponse> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        for (AppliancesAPIResponse appliancesAPIResponse : list) {
            arrayList.add(new Remocon(String.valueOf(appliancesAPIResponse.id), appliancesAPIResponse.name, Remocon.convertIntToControllerID(appliancesAPIResponse.remote_controller)));
        }
        return arrayList;
    }

    public static List<Remocon> parseGetAppliances(List<AppliancesAPIResponse> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        for (AppliancesAPIResponse appliancesAPIResponse : list) {
            if (appliancesAPIResponse.remote_controller == i) {
                arrayList.add(new Remocon(String.valueOf(appliancesAPIResponse.id), appliancesAPIResponse.name, Remocon.convertIntToControllerID(appliancesAPIResponse.remote_controller)));
            }
        }
        return arrayList;
    }

    public static IRCommand parseGetIRCommand(CreateIRDBRequestAPIResponse createIRDBRequestAPIResponse) {
        if (createIRDBRequestAPIResponse == null) {
            return null;
        }
        return new IRCommand(String.valueOf(createIRDBRequestAPIResponse.ir_id), null);
    }

    public static IRCommand parseGetIRCommandFromTest(CreateIRDBTestAPIResponse createIRDBTestAPIResponse) {
        if (createIRDBTestAPIResponse == null) {
            return null;
        }
        return new IRCommand(String.valueOf(createIRDBTestAPIResponse.ir_id), null);
    }

    public static IRCommand parseGetIRCommandFromMatching(CreateModifyIRInfoAPIResponse createModifyIRInfoAPIResponse) {
        if (createModifyIRInfoAPIResponse == null) {
            return null;
        }
        return new IRCommand(String.valueOf(createModifyIRInfoAPIResponse.ir_id), null);
    }

    public static List<CheckerHistoryItem> parseGetCheckerHistories(CheckerHistoriesAPIResponse checkerHistoriesAPIResponse) {
        if (checkerHistoriesAPIResponse == null) {
            return null;
        }
        return checkerHistoriesAPIResponse.results;
    }

    private class LinkerData {
        String mac_address;
        String status;

        private LinkerData() {
        }
    }
}
