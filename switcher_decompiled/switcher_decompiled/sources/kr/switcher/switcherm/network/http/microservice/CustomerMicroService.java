package kr.switcher.switcherm.network.http.microservice;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerMicroService extends MicroService {
    private final String HOST_PROD_URL = "customer-prod.i-o.studio/";
    private final String HOST_DEV_URL = "customer-dev.i-o.studio/";
    private final String API_VERSION = "v1/";

    public CustomerMicroService() {
        makeUrl("customer-prod.i-o.studio/", "customer-dev.i-o.studio/", "v1/");
    }

    @Override // kr.switcher.switcherm.network.http.microservice.MicroService
    public String getBaseUrl() {
        return super.getBaseUrl();
    }
}
