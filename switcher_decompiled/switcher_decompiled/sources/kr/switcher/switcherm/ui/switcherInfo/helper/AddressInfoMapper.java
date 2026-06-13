package kr.switcher.switcherm.ui.switcherInfo.helper;

import java.util.List;
import kr.switcher.switcherm.network.http.response.AddressListMeAPIResponse;
import kr.switcher.switcherm.user.AddressInfo;

/* JADX INFO: loaded from: classes2.dex */
public class AddressInfoMapper {
    public static AddressInfo transform(List<AddressListMeAPIResponse> list) {
        for (AddressListMeAPIResponse addressListMeAPIResponse : list) {
            if (addressListMeAPIResponse.is_default) {
                return new AddressInfo(addressListMeAPIResponse.postal_code, addressListMeAPIResponse.main_address, addressListMeAPIResponse.sub_address);
            }
        }
        return new AddressInfo();
    }
}
