package kr.switcher.device.switcher.linker.http.response;

import retrofit2.Callback;

/* JADX INFO: loaded from: classes2.dex */
public class ThingAPIResponse extends HttpAPIResponse {
    public static final String PREPARING_PRODUCT = "제품준비중";
    public static final String RELEASE = "출고";
    public static final String RETURN_COMPLETED = "반납완료";
    public static final String RETURN_ING = "반납중";
    public static final String UNKNOWN = "알수없음";
    public String access_token;
    public String connection_status;
    public String mac_address;
    public String name;
    public int product_id;
    public String serial_number;
    public String status;
    public String type;
    public int type_id;
    public String warranty_date;

    @Override // kr.switcher.device.switcher.linker.http.response.HttpAPIResponse
    public Callback<ThingAPIResponse> response(HttpResponseHandler httpResponseHandler) {
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

    public String getConnectionStatus() {
        return this.connection_status;
    }
}
