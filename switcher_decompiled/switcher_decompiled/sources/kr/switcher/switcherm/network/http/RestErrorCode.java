package kr.switcher.switcherm.network.http;

import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.preference.OAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class RestErrorCode {
    public static final String ACCESSTOKEN_DOES_NOT_EXIST = "6";
    public static final String ACCESSTOKEN_IS_NOT_MATCHED = "7";
    public static final String ACCESS_TOKEN_IS_EMPTY = "5";
    public static final String AUTHNUMBER_IS_WRONG = "4";
    public static final String CARD_NUMBER_IS_WRONG = "12";
    public static final String CUSTOMER_DOES_NOT_EXIST = "3";
    public static final String DUPLICATED_ADDRESS = "60";
    public static final String GETTING_INVOICE_FROM_POSTOFFICE_IS_FAIL = "16";
    public static final String INITIALIZING_SWITCHER_IS_REJECTED = "PC05";
    public static final String MACADDRESS_DOES_NOT_EXIST = "9";
    public static final String MACADDRESS_IS_EMPTY = "8";
    public static final String MACADDRESS_OR_SHARE_CODE_IS_WRONG = "121";
    public static final String MODEL_TYPE_IS_EMPTY = "SC20";
    public static final String MODEL_TYPE_IS_SAME_WITH_ORIGINAL_TYPE = "US37";
    public static final String NOT_CONNECTED_INTERNET = "998";
    public static final String PHONE_NUMBER_IS_WRONG = "2";
    public static final String REQUEST_ID_IS_EMPTY = "US22";
    public static final String REQUEST_INFO_DOES_NOT_EXIST = "US24";
    public static final String REQUEST_PARAMS_ARE_NOT_ENOUGH = "1";
    public static final String SENDING_SMS_IS_FAIL = "15";
    public static final String SHARE_CODE_IS_EMPTY = "10";
    public static final String SHARE_CODE_IS_NOT_VALID = "14";
    public static final String SIGNAL_DOES_NOT_EXIST = "SG01";
    public static final String SIGNAL_STATUS_IS_EMPTY = "SG03";
    public static final String SIGNAL_STATUS_IS_WRONG = "SG04";
    public static final String SIGNAL_TYPE_IS_EMPTY = "SG02";
    public static final String SWITCHER_IS_NOT_USED = "SC19";
    public static final String SWITCHER_USE_INFO_DOES_NOT_EXIST = "13";
    private static final String TAG = "RestErrorCode";
    public static final String THE_OWNER_OF_PURCHASE_ALREADY_EXISTS = "PC02";
    public static final String THE_PURCHASE_INFO_DOES_NOT_EXIST = "PC01";
    public static final String THE_PURCHASE_OWNER_DOES_NOT_EXIST = "PC04";
    public static final String THE_TIME_FORMAT_OF_RESERVATION_DOES_NOT_MATCH = "RV03";
    public static final String THE_UPDATE_FOR_PURCHASE_OR_PURCHASE_OWNER_IS_FAILED = "PC03";
    public static final String THE_UPDATE_FOR_RESERVATION_IS_FAILED = "RV06";
    public static final String UNAUTHORIZED = "401";
    public static final String UNHANDLED_INTERNAL_SERVER_ERROR = "999";

    public static void showReason(String str) {
        if ("1".equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.request_params_are_not_enough));
            return;
        }
        if (UNHANDLED_INTERNAL_SERVER_ERROR.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.unhandled_internal_server_error));
            return;
        }
        if (PHONE_NUMBER_IS_WRONG.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.phone_number_is_wrong));
            return;
        }
        if (CUSTOMER_DOES_NOT_EXIST.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.customer_does_not_exist));
            return;
        }
        if (AUTHNUMBER_IS_WRONG.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.authnumber_is_wrong));
            return;
        }
        if (ACCESS_TOKEN_IS_EMPTY.equals(str)) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showReason", new Exception(IOUtil.getStringResource(R.string.access_token_is_empty)));
            return;
        }
        if (UNAUTHORIZED.equals(str)) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showReason", new Exception(IOUtil.getStringResource(R.string.accesstoken_does_not_exist)));
            return;
        }
        if (ACCESSTOKEN_IS_NOT_MATCHED.equals(str)) {
            IOLog.error(TAG, new OAuthToken().getOAuthToken(), "showReason", new Exception(IOUtil.getStringResource(R.string.accesstoken_is_not_matched)));
            return;
        }
        if (MACADDRESS_IS_EMPTY.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.mac_address_is_empty));
            return;
        }
        if (MACADDRESS_DOES_NOT_EXIST.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.macaddress_does_not_exist));
            return;
        }
        if (SHARE_CODE_IS_EMPTY.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.share_code_is_empty));
            return;
        }
        if (MACADDRESS_OR_SHARE_CODE_IS_WRONG.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.macaddress_or_share_code_is_wrong));
            return;
        }
        if (CARD_NUMBER_IS_WRONG.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.card_number_is_wrong));
            return;
        }
        if (SWITCHER_USE_INFO_DOES_NOT_EXIST.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.switcher_use_info_does_not_exist));
            return;
        }
        if (SHARE_CODE_IS_NOT_VALID.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.share_code_is_not_valid));
            return;
        }
        if (SENDING_SMS_IS_FAIL.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.sending_sms_is_fail));
            return;
        }
        if (GETTING_INVOICE_FROM_POSTOFFICE_IS_FAIL.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.getting_invoice_from_postoffice_is_fail));
            return;
        }
        if (SWITCHER_IS_NOT_USED.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.switcher_is_not_used));
            return;
        }
        if (REQUEST_ID_IS_EMPTY.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.request_id_is_empty));
            return;
        }
        if (MODEL_TYPE_IS_EMPTY.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.model_type_is_empty));
            return;
        }
        if (REQUEST_INFO_DOES_NOT_EXIST.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.request_info_does_not_exist));
            return;
        }
        if (MODEL_TYPE_IS_SAME_WITH_ORIGINAL_TYPE.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.model_type_is_same_with_original_type));
            return;
        }
        if (SIGNAL_DOES_NOT_EXIST.equals(str)) {
            IOLog.i(TAG, IOUtil.getStringResource(R.string.signal_does_not_exist));
            return;
        }
        if (SIGNAL_TYPE_IS_EMPTY.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.signal_type_is_empty));
            return;
        }
        if (SIGNAL_STATUS_IS_EMPTY.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.signal_status_is_empty));
            return;
        }
        if (SIGNAL_STATUS_IS_WRONG.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.signal_status_is_wrong));
            return;
        }
        if (THE_PURCHASE_INFO_DOES_NOT_EXIST.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.the_purchase_info_does_not_exist));
            return;
        }
        if (THE_OWNER_OF_PURCHASE_ALREADY_EXISTS.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.the_owner_of_purchase_already_exists));
            return;
        }
        if (THE_UPDATE_FOR_PURCHASE_OR_PURCHASE_OWNER_IS_FAILED.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.the_update_for_purchase_or_purchase_owner_is_failed));
            return;
        }
        if (THE_PURCHASE_OWNER_DOES_NOT_EXIST.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.the_purchase_owner_does_not_exist));
            return;
        }
        if (INITIALIZING_SWITCHER_IS_REJECTED.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.initializing_switcher_is_rejected));
            return;
        }
        if (THE_UPDATE_FOR_RESERVATION_IS_FAILED.equals(str) || THE_TIME_FORMAT_OF_RESERVATION_DOES_NOT_MATCH.equals(str)) {
            return;
        }
        if (NOT_CONNECTED_INTERNET.equals(str)) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_connected_internet));
        } else {
            if (DUPLICATED_ADDRESS.equals(str)) {
                return;
            }
            IOUtil.showToast(IOUtil.getStringResource(R.string.unhandled_internal_server_error));
        }
    }
}
