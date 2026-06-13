package kr.switcher.switcherm.network.http.response;

import kr.switcher.device.IODevice;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAPIResponse extends HttpAPIResponse {
    public static final String PREPARING_PRODUCT = "제품준비중";
    public static final String RELEASE = "출고";
    public static final String RETURN_COMPLETED = "반납완료";
    public static final String RETURN_ING = "반납중";
    public static final String UNKNOWN = "알수없음";
    public String access_token;
    public int checker_id;
    public String connection_status;
    public String created_at;
    public int device_id;
    public boolean is_open;
    public String mac_address;
    public Meta meta;
    public String name;
    public int product_id;
    public String serial_number;
    public String status;
    public String type;
    public int type_id;
    public String warranty_date;

    @Override // kr.switcher.switcherm.network.http.response.HttpAPIResponse
    public Callback<DeviceAPIResponse> response(HttpResponseHandler httpResponseHandler) {
        return super.response(httpResponseHandler);
    }

    public String getType() {
        return this.type;
    }

    public int getTypeId() {
        return this.type_id;
    }

    public String getSerialNumber() {
        return this.serial_number;
    }

    public int getProductType() {
        return this.product_id;
    }

    public String getMacAddress() {
        return this.mac_address;
    }

    public String getShareCode() {
        return this.access_token;
    }

    public String getWarrantyDate() {
        return this.warranty_date;
    }

    public String getUserName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public Boolean getIsOpen() {
        return Boolean.valueOf(this.is_open);
    }

    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public IODevice.ThingConnectionStatus getConnectionStatus() {
        return convertThingConnectionStatus(this.connection_status);
    }

    private IODevice.ThingConnectionStatus convertThingConnectionStatus(String str) {
        if (str == null) {
            return IODevice.ThingConnectionStatus.UNKNOWN;
        }
        str.hashCode();
        if (str.equals("dead")) {
            return IODevice.ThingConnectionStatus.DEAD;
        }
        if (str.equals("alive")) {
            return IODevice.ThingConnectionStatus.ALIVE;
        }
        return IODevice.ThingConnectionStatus.UNKNOWN;
    }

    public static class Meta {
        public String battery_level;
        public String version;

        public String getBattery_level() {
            return this.battery_level;
        }

        public void setBattery_level(String str) {
            this.battery_level = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }
}
