package kr.switcher.switcherm.device;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.IODevice;
import kr.switcher.device.common.DeviceUtil;
import kr.switcher.device.linker.Linker;
import kr.switcher.device.switcher.Switcher;
import kr.switcher.device.switcher.option.DeviceOption;
import kr.switcher.switcherm.database.DBPricingModel;
import kr.switcher.switcherm.device.checker.CheckerFactory;
import kr.switcher.switcherm.device.switcher.SwitcherFactory;
import kr.switcher.switcherm.device.switcher.handler.SwitcherHandler;
import kr.switcher.switcherm.network.http.response.DeviceAPIResponse;
import kr.switcher.switcherm.network.http.response.HashingKeyAPIResponse;
import kr.switcher.switcherm.network.http.response.PricingModelAPIResponse;
import kr.switcher.switcherm.network.http.response.ProductReturnAPIResponse;

/* JADX INFO: loaded from: classes2.dex */
public class IODeviceJsonParser {
    private static final String TAG = "IODeviceJsonParser";

    public static ArrayList<String> parseSwitcherList(String str) {
        try {
            return (ArrayList) new Gson().fromJson(str, new TypeToken<List<String>>() { // from class: kr.switcher.switcherm.device.IODeviceJsonParser.1
            }.getType());
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            throw e;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            throw e2;
        }
    }

    public static String makeSwitcherListJson(List<String> list) {
        return new Gson().toJson(list);
    }

    public static IODevice parseGetDevice(DeviceAPIResponse deviceAPIResponse, String str) {
        IODevice iODeviceCreateChecker;
        IODevice.ProductId productIdConvertProductId = DeviceUtil.convertProductId(deviceAPIResponse.getProductType());
        if (productIdConvertProductId == IODevice.ProductId.SWITCHER_TYPE_ONE || productIdConvertProductId == IODevice.ProductId.SWITCHER_TYPE_TWO) {
            Switcher switcher = (Switcher) new SwitcherFactory().createIODevice(productIdConvertProductId, str, deviceAPIResponse.getSerialNumber(), deviceAPIResponse.getUserName());
            switcher.setFirmwareVersion("");
            iODeviceCreateChecker = switcher;
        } else if (productIdConvertProductId == IODevice.ProductId.LINKER) {
            Linker linker = new Linker(str);
            linker.setProductId(productIdConvertProductId);
            linker.setSerialNumber(deviceAPIResponse.getSerialNumber());
            linker.setOwner(deviceAPIResponse.getUserName());
            iODeviceCreateChecker = linker;
        } else {
            if (productIdConvertProductId != IODevice.ProductId.CHECKER) {
                return null;
            }
            iODeviceCreateChecker = new CheckerFactory().createChecker(str, deviceAPIResponse.getSerialNumber(), deviceAPIResponse.getUserName(), deviceAPIResponse.getMeta());
        }
        iODeviceCreateChecker.setShareCode(deviceAPIResponse.getShareCode());
        iODeviceCreateChecker.setThingConnectionStatus(deviceAPIResponse.getConnectionStatus());
        DeviceOption deviceOption = new DeviceOption();
        deviceOption.setShippingStatus(convertShippingStatus(deviceAPIResponse.getStatus()));
        deviceOption.setBuyingType(deviceAPIResponse.getType());
        deviceOption.setBuyingId(deviceAPIResponse.getTypeId());
        deviceOption.setWarrantyDate(deviceAPIResponse.getWarrantyDate());
        iODeviceCreateChecker.setOption(deviceOption);
        return iODeviceCreateChecker;
    }

    private static int convertShippingStatus(String str) {
        str.hashCode();
        switch (str) {
            case "출고":
                return 4;
            case "반납중":
                return 6;
            case "반납완료":
                return 8;
            case "제품준비중":
                return 0;
            default:
                return 9;
        }
    }

    private static IODevice.ProductId getSwitcherType(String str) {
        Switcher switcher = SwitcherHandler.getInstance().getSwitcher(str);
        if (switcher != null) {
            return switcher.getProductId();
        }
        return null;
    }

    public static ArrayList<String> parseShareCode(String str) throws Exception {
        try {
            ShareCodeVo shareCodeVo = (ShareCodeVo) new Gson().fromJson(str, ShareCodeVo.class);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(shareCodeVo.shareCode);
            arrayList.add(shareCodeVo.hashingShareCode);
            return arrayList;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static ArrayList<DBPricingModel> parsePricingModels(PricingModelAPIResponse pricingModelAPIResponse) throws Exception {
        try {
            ArrayList<DBPricingModel> arrayList = new ArrayList<>();
            for (PricingModelAPIResponse.PricingModelInfo pricingModelInfo : pricingModelAPIResponse.data) {
                arrayList.add(new DBPricingModel(pricingModelInfo.id, pricingModelInfo.price, pricingModelInfo.title, pricingModelInfo.description));
            }
            return arrayList;
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public static String parseHashingKey(HashingKeyAPIResponse hashingKeyAPIResponse) throws NullPointerException {
        return hashingKeyAPIResponse.getHashingKey();
    }

    public static String parsePayInfo(String str) throws Exception {
        try {
            return ((PayInfoVo) new Gson().fromJson(str, PayInfoVo.class)).name;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static String parseShareCodeResult(String str) throws Exception {
        try {
            return ((ShareCodeResultVo) new Gson().fromJson(str, ShareCodeResultVo.class)).result;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static ArrayList<String> parseFirmwareInfoResult(String str) throws Exception {
        try {
            FirmwareInfoResultVo firmwareInfoResultVo = (FirmwareInfoResultVo) new Gson().fromJson(str, FirmwareInfoResultVo.class);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(firmwareInfoResultVo.version);
            arrayList.add(firmwareInfoResultVo.link);
            return arrayList;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static String parseReturnInvoiceResult(ProductReturnAPIResponse productReturnAPIResponse) throws NullPointerException {
        return productReturnAPIResponse.invoice_number;
    }

    public static List<String> parseLinkerList(String str) throws Exception {
        try {
            List<LinkerData> list = (List) new Gson().fromJson(str, new TypeToken<List<LinkerData>>() { // from class: kr.switcher.switcherm.device.IODeviceJsonParser.2
            }.getType());
            ArrayList arrayList = new ArrayList();
            for (LinkerData linkerData : list) {
                if (linkerData.status.equals("alive")) {
                    arrayList.add(DeviceUtil.makeMacAddressWithSemicolon(linkerData.mac_address));
                }
            }
            return arrayList;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    public static String parseCommandResult(String str) {
        try {
            return ((CommandResult) new Gson().fromJson(str, CommandResult.class)).result;
        } catch (JsonSyntaxException e) {
            throw e;
        } catch (NullPointerException e2) {
            throw e2;
        }
    }

    private class LinkerData {
        String mac_address;
        String status;

        private LinkerData() {
        }
    }

    private class SwitcherStatus {
        int status;

        private SwitcherStatus() {
        }
    }

    private class CommandData {
        long commandId;

        private CommandData() {
        }
    }

    private class CommandResult {
        String result;

        private CommandResult() {
        }
    }

    private class PricingModelsVo {
        String createdAt;
        String description;
        int id;
        int price;
        int status;
        String title;
        String updatedAt;

        private PricingModelsVo() {
        }
    }

    private class HashingKeyVo {
        String hashingKey;

        private HashingKeyVo() {
        }
    }

    private class PayInfoVo {
        String cardNumber;
        String createdAt;
        String expireDate;
        String id;
        String main;
        String name;
        String phoneNumber;
        String updatedAt;

        private PayInfoVo() {
        }
    }

    private class ShareCodeVo {
        String hashingShareCode;
        String shareCode;

        private ShareCodeVo() {
        }
    }

    private class ShareCodeResultVo {
        String result;

        private ShareCodeResultVo() {
        }
    }

    private class FirmwareInfoResultVo {
        String link;
        String version;

        private FirmwareInfoResultVo() {
        }
    }

    private class ReturnResultVo {
        String invoice;

        private ReturnResultVo() {
        }
    }
}
