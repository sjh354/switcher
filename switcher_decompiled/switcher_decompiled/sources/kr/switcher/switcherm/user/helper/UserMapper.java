package kr.switcher.switcherm.user.helper;

import kr.switcher.switcherm.network.http.response.CustomerMeAPIResponse;
import kr.switcher.switcherm.user.User;

/* JADX INFO: loaded from: classes2.dex */
public class UserMapper {
    private static final String TAG = "UserMapper";

    public static User parseGetUserMe(CustomerMeAPIResponse customerMeAPIResponse) throws NullPointerException {
        User user = new User();
        user.setUserName(customerMeAPIResponse.name);
        user.setPhoneNumber(customerMeAPIResponse.phone_number);
        return user;
    }
}
