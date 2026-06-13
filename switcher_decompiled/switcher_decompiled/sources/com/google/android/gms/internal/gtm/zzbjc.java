package com.google.android.gms.internal.gtm;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.afollestad.materialdialogs.BuildConfig;
import cz.msebera.android.httpclient.HttpStatus;
import kr.switcher.device.SReturnCode;
import no.nordicsemi.android.dfu.DfuBaseService;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbjc implements zzbfh {
    UC_DEFAULT(0),
    UC_PROTO_METADATA(1),
    UC_DELEGATED(2),
    UC_RESERVED_FOR_TESTING_IN_PRODUCT_CONTROL(197),
    UC_NEVER_COLLECT(3),
    UC_1P_APP_PROVISION_OF_SERVICE(194),
    UC_3P_APP_PROVISION_OF_SERVICE(203),
    UC_PLATFORM_OR_FEATURE_PRODUCT_IMPROVEMENT_WW(100),
    UC_PLATFORM_OR_FEATURE_FUNCTIONAL_DEBUGGING_WW(101),
    UC_PLATFORM_OR_FEATURE_PRODUCT_DEVELOPMENT_WW(102),
    UC_PLATFORM_OR_FEATURE_MEASURING_USER_ENGAGEMENT_WW(103),
    UC_SERVICE_OR_API_FUNCTIONAL_DEBUGGING_WW(104),
    UC_SERVICE_OR_API_PRODUCT_IMPROVEMENT_WW(105),
    UC_SERVICE_OR_API_PRODUCT_DEVELOPMENT_WW(106),
    UC_SERVICE_OR_API_MEASURING_USER_ENGAGEMENT_WW(154),
    UC_UNBRANDED_1P_APP_FUNCTIONAL_DEBUGGING_WW(117),
    UC_UNBRANDED_1P_APP_PRODUCT_IMPROVEMENT_WW(118),
    UC_UNBRANDED_1P_APP_PRODUCT_DEVELOPMENT_WW(119),
    UC_UNBRANDED_1P_APP_MEASURING_USER_ENGAGEMENT_WW(120),
    UC_HEADLESS_1P_APP_FUNCTIONAL_DEBUGGING_WW(121),
    UC_HEADLESS_1P_APP_PRODUCT_IMPROVEMENT_WW(122),
    UC_HEADLESS_1P_APP_PRODUCT_DEVELOPMENT_WW(123),
    UC_HEADLESS_1P_APP_MEASURING_USER_ENGAGEMENT_WW(124),
    UC_APP_USAGE_FOREGROUND_USER_BEHAVIOR_WW(125),
    UC_APP_USAGE_SYSTEM_HEALTH_WW(126),
    UC_SYSTEM_HEALTH_INTERACTION_WITH_PRODUCT_WW(128),
    UC_SYSTEM_HEALTH_FUNCTIONAL_DEBUGGING_WW(129),
    UC_PLATFORM_MARKET_STATISTICS_WW(130),
    UC_CONTEXTUALIZATION_NO_USER_DATA_WW(131),
    UC_1P_HW_FUNCTIONAL_DEBUGGING_WW(173),
    UC_1P_HW_PRODUCT_IMPROVEMENT_WW(174),
    UC_1P_HW_PRODUCT_DEVELOPMENT_WW(175),
    UC_1P_HW_MEASURING_USER_ENGAGEMENT_WW(176),
    UC_APP_USAGE_PERSONALIZATION_WW(127),
    UC_SERVICE_OR_API_FUNCTIONAL_DEBUGGING(116),
    UC_SERVICE_OR_API_PRODUCT_IMPROVEMENT(108),
    UC_SERVICE_OR_API_PRODUCT_DEVELOPMENT(132),
    UC_SERVICE_OR_API_MEASURING_USER_ENGAGEMENT(113),
    UC_HEADLESS_1P_APP_FUNCTIONAL_DEBUGGING(150),
    UC_HEADLESS_1P_APP_PRODUCT_IMPROVEMENT(151),
    UC_HEADLESS_1P_APP_PRODUCT_DEVELOPMENT(152),
    UC_HEADLESS_1P_APP_MEASURING_USER_ENGAGEMENT(153),
    UC_UNBRANDED_1P_APP_FUNCTIONAL_DEBUGGING(111),
    UC_UNBRANDED_1P_APP_PRODUCT_IMPROVEMENT(112),
    UC_UNBRANDED_1P_APP_PRODUCT_DEVELOPMENT(156),
    UC_UNBRANDED_1P_APP_MEASURING_USER_ENGAGEMENT(155),
    UC_PLATFORM_OR_FEATURE_FUNCTIONAL_DEBUGGING(115),
    UC_PLATFORM_OR_FEATURE_PRODUCT_IMPROVEMENT(109),
    UC_PLATFORM_OR_FEATURE_PRODUCT_DEVELOPMENT(133),
    UC_PLATFORM_OR_FEATURE_MEASURING_USER_ENGAGEMENT(134),
    UC_CRITICAL_FLEET_MANAGEMENT(135),
    UC_EXPERIMENT_TARGETING(159),
    UC_INTERNAL_DESCRIPTION(167),
    UC_1P_HW_DEVICE_MANAGEMENT(193),
    UC_DEVICE_FINGERPRINT(142),
    UC_DEVICE_INTEGRITY(143),
    UC_PLATFORM_INTEGRITY(144),
    UC_APP_INTEGRITY(145),
    UC_ACCOUNT_INTEGRITY(107),
    UC_FRAUD_SPAM_ABUSE_PREVENTION(146),
    UC_DROIDGUARD_VERDICT_INPUT(147),
    UC_PLAY_MALWARE_DETECTION(148),
    UC_SIDELOAD_MALWARE_DETECTION(149),
    UC_SERVICE_ABUSE_PREVENTION(158),
    UC_ABUSE_CONTENT_CLASSIFICATION_VERDICTS(231),
    UC_CRITICAL_FUNCTIONAL_FLEET_ISSUES(114),
    UC_ANDROID_ECOSYSTEM_HEALTH(141),
    UC_REFINING_EXPERIMENTS(160),
    UC_CONTEXTUALIZATION(269),
    UC_CONTEXTUALIZATION_RECENT_ACTIVITY(270),
    UC_CONTEXTUALIZATION_DEVICE_CAPABILITIES(271),
    UC_CONTEXTUALIZATION_DEVICE_STATE(272),
    UC_CONTEXTUALIZATION_LANGUAGE_OR_LOCALE(273),
    UC_CONTEXTUALIZATION_COUNTRY(274),
    UC_CONTEXTUALIZATION_1P_INSTALLED_APPS(277),
    UC_CONTEXTUALIZATION_DEFAULT_HANDLER_APPS(278),
    UC_CONTEXTUALIZATION_USER_DATA(275),
    UC_CONTEXTUALIZATION_NO_USER_DATA(140),
    UC_PRIMES_APP_HEALTH(110),
    UC_CHIME_FUNCTIONAL_DEBUGGING(HttpStatus.SC_PARTIAL_CONTENT),
    UC_CHIME_PRODUCT_IMPROVEMENT(HttpStatus.SC_MULTI_STATUS),
    UC_CHIME_MEASURING_USER_ENGAGEMENT(205),
    UC_CHIME_NOTIFICATION_MANAGEMENT(289),
    UC_1P_APP_FUNCTIONAL_DEBUGGING(136),
    UC_1P_APP_PRODUCT_IMPROVEMENT(137),
    UC_1P_APP_PRODUCT_DEVELOPMENT(138),
    UC_1P_APP_MEASURING_USER_ENGAGEMENT(139),
    UC_SDK_FUNCTIONAL_DEBUGGING(199),
    UC_SDK_PRODUCT_IMPROVEMENT(200),
    UC_SDK_PRODUCT_DEVELOPMENT(201),
    UC_SDK_MEASURING_USER_ENGAGEMENT(202),
    UC_FCM_FUNCTIONAL_DEBUGGING(192),
    UC_FCM_MESSAGE_DELIVERY(280),
    UC_FIT_FUNCTIONAL_DEBUGGING(177),
    UC_FIT_PRODUCT_IMPROVEMENT(178),
    UC_FIT_PRODUCT_DEVELOPMENT(BuildConfig.VERSION_CODE),
    UC_FIT_MEASURING_USER_ENGAGEMENT(180),
    UC_FIT_APP_OR_API_FUNCTIONAL_DEBUGGING(188),
    UC_FIT_APP_OR_API_PRODUCT_IMPROVEMENT(189),
    UC_FIT_APP_OR_API_PRODUCT_DEVELOPMENT(190),
    UC_FIT_APP_OR_API_MEASURING_USER_ENGAGEMENT(191),
    UC_GBOARD_FUNCTIONAL_DEBUGGING(161),
    UC_GBOARD_PRODUCT_IMPROVEMENT(162),
    UC_GBOARD_PRODUCT_DEVELOPMENT(163),
    UC_GBOARD_MEASURING_USER_ENGAGEMENT(164),
    UC_PAY_FUNCTIONAL_DEBUGGING(234),
    UC_PAY_PRODUCT_IMPROVEMENT(235),
    UC_PAY_MEASURING_USER_ENGAGEMENT(236),
    UC_PAY_PROVISION_OF_SERVICE(265),
    UC_PAY_DEVICE_FINGERPRINT(266),
    UC_PAY_FRAUD_SPAM_ABUSE_PREVENTION(288),
    UC_GPP_SIDELOADED_UNSAFE_APP_DETECTION(165),
    UC_GPP_UNSAFE_APP_DETECTION(166),
    UC_GPP_UPLOAD_UNSAFE_APP(196),
    UC_CROSS_PRODUCT_PERSONALIZATION_FOOTPRINTS(157),
    UC_SEARCH_HISTORY(238),
    UC_UNBRANDED_CROSS_PRODUCT_PERSONALIZATION_FOOTPRINTS(217),
    UC_BROWSING_HISTORY(239),
    UC_DEVICE_APPS(276),
    UC_FMD_RING(168),
    UC_FMD_LOCATE(169),
    UC_FMD_LOCK(170),
    UC_FMD_UNPAIR(171),
    UC_FMD_LOCATE_ACCESSORY(237),
    UC_FMD_IDENTIFY_DEVICE_STATE_AND_CAPABILITY(181),
    UC_ENX_OPT_OUT_DEIDENTIFIED_TELEMETRY(172),
    UC_FOREGROUND_LOCATION(182),
    UC_IP_LOCATION(222),
    UC_POPULATED_SERVER_SIDE(223),
    UC_LOCATION_HISTORY(183),
    UC_LOCATION_HISTORY_USER_EDIT(184),
    UC_LOCATION_ACCURACY(185),
    UC_LOCATION_ACCURACY_WIFI(186),
    UC_LOCATION_HISTORY_CONSENT_CHANGE(241),
    UC_EARTHQUAKE_ALERTING(187),
    UC_EARTHQUAKE_DETECTION(226),
    UC_BACKUP_USER_DATA(195),
    UC_RESTORE_USER_DATA(240),
    UC_BACKUP_MANAGEMENT(267),
    UC_WEAR_CLOUD_SYNC(204),
    UC_CONTACTS_ACCOUNT_TYPE_LOGGING(208),
    UC_IN_PRODUCT_PERSONALIZATION(209),
    UC_NEARBY_MESSAGES(210),
    UC_FAST_PAIR(211),
    UC_NEARBY_SHARING(212),
    UC_USER_AUTHENTICATION(213),
    UC_GOOGLE_CONTACTS_SYNC(214),
    UC_DEVICE_CONTACT_INFO_COLLECTION(215),
    UC_PEOPLE_DETAILS_SYNC(216),
    UC_WIFI_NETWORK_SCORING(218),
    UC_3P_APP_DEVICE_INTEGRITY(219),
    UC_VERIFY_URL(220),
    UC_FI_FUNCTIONAL_DEBUGGING(224),
    UC_FI_PRODUCT_IMPROVEMENT(225),
    UC_FI_MEASURING_USER_ENGAGEMENT(227),
    UC_FI_CELL_TOWER_HISTORY(233),
    UC_FI_PROVISION_OF_SERVICE(262),
    UC_ADS_TARGETING(228),
    UC_ADS_DELIVERY(245),
    UC_ADS_GENERAL_TARGETING(246),
    UC_ADS_PERSONALIZATION(247),
    UC_ADS_MEASUREMENT(229),
    UC_ADS_EXTERNAL_INTEGRATION(230),
    UC_BRELLA_FUNCTIONAL_DEBUGGING(232),
    UC_BRELLA_FEDERATED_COMPUTE(321),
    UC_UNICORN_SETUP(242),
    UC_UNICORN_MANAGEMENT(243),
    UC_UNICORN_ACTIVITY_SUPERVISION(244),
    UC_FAMILY_ADMIN(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION),
    UC_FAMILY_1P_INTEGRATION(251),
    UC_DIGITAL_WELLBEING_FUNCTIONAL_DEBUGGING(252),
    UC_DIGITAL_WELLBEING_MEASURING_USER_ENGAGEMENT(253),
    UC_DIGITAL_WELLBEING_PRODUCT_IMPROVEMENT(254),
    UC_MARKETING_ENGAGEMENT_GROWTH_COMMS(260),
    UC_MARKETING_ENGAGEMENT_GROWTH_FREQ_CAP(327),
    UC_AUDIT_RECORD(255),
    UC_LOCATION_SHARING(256),
    UC_GMM_PUBLIC_PHOTO(InputDeviceCompat.SOURCE_KEYBOARD),
    UC_GMM_PUBLIC_VIDEO(258),
    UC_GMM_USER_INITIATED_FEEDBACK(259),
    UC_GMM_VOTE(305),
    UC_GMM_UGC_PUBLIC_REPORT(SReturnCode.INVALID_CHECKER_TYPE),
    UC_GMM_OWNER_RESPONSE(312),
    UC_GMM_PUBLIC_REVIEW(313),
    UC_LOCATION_HISTORY_BOTTOM_SHEET_CONSENT_TOGGLE(261),
    UC_HEADLESS_DPC_CLOUD_API_CONFIGURE_APP_POLICIES(279),
    UC_HEADLESS_DPC_CLOUD_API_REPORT_DEVICE_INFO(285),
    UC_HEADLESS_DPC_CLOUD_API_SET_UP_DEVICE_MANAGEMENT(286),
    UC_HEADLESS_DPC_CLOUD_API_RUN_DEVICE_COMMANDS(287),
    UC_HEADLESS_DPC_CLOUD_API_PROVISION_OF_SERVICE(263),
    UC_HEADLESS_DPC_CLOUD_API_FUNCTIONAL_DEBUGGING(264),
    UC_PANELS_APP_PROVISION_OF_SERVICE(281),
    UC_PANELS_APP_FUNCTIONAL_DEBUGGING(282),
    UC_PANELS_APP_IN_APP_DATA(DfuBaseService.NOTIFICATION_ID),
    UC_PLAY_APP_PROVISION_OF_SERVICE(268),
    UC_STACK_COPY_TO_DRIVE(284),
    UC_OPENSKY_PROVISION_OF_SERVICE(290),
    UC_OPENSKY_FUNCTIONAL_DEBUGGING(291),
    UC_OPENSKY_MEASURING_USER_ENGAGEMENT(292),
    UC_OPENSKY_PRODUCT_IMPROVEMENT(293),
    UC_WINGDELIVERY_PROVISION_OF_SERVICE(294),
    UC_WINGDELIVERY_FUNCTIONAL_DEBUGGING(295),
    UC_WINGDELIVERY_PRODUCT_IMPROVEMENT(296),
    UC_WINGDELIVERY_MEASURING_USER_ENGAGEMENT(297),
    UC_PLAY_CONSOLE_PROVISION_OF_SERVICE(298),
    UC_PLAY_CONSOLE_FUNCTIONAL_DEBUGGING(299),
    UC_PLAY_CONSOLE_MEASURING_USER_ENGAGEMENT(HttpStatus.SC_MULTIPLE_CHOICES),
    UC_PLAY_CONSOLE_PRODUCT_IMPROVEMENT(301),
    UC_KEY_EXCHANGE(302),
    UC_DROIDGUARD_ATTESTATION(303),
    UC_BINARY_TRANSPARENCY(304),
    UC_OAUTH_GAIA_SIGNIN(307),
    UC_UNBRANDED_TASKMATE_PROVISION_OF_SERVICE(StatusLine.HTTP_PERM_REDIRECT),
    UC_CHROME_IMAGE_DESCRIPTIONS(309),
    UC_CHROME_AUTH(342),
    UC_CHROME_WEB_BROWSING(341),
    UC_3P_PASSWORD_LEAK_CHECK(340),
    UC_CROWDSOURCE_PUBLIC_PHOTO(310),
    UC_CROWDSOURCE_CONTRIBUTED_AUDIO(311),
    UC_HADES_REQUEST_MODEL_AND_DATA_UPDATES(314),
    UC_HADES_USAGE_INFO(315),
    UC_HADES_OPRF_BLINDED_USER_CONTENT(328),
    UC_ARES_CONTENT_ABUSE_REPORT(316),
    UC_ARES_TAKEDOWN_APPEALS(317),
    UC_FMD_ERASE_DEVICE(318),
    UC_LOCATION_TIME_ZONE(319),
    UC_GMM_NAVIGATION(320),
    UC_PHONE_NUMBER_ACCOUNT_SECURITY(353),
    UC_CONSTELLATION_VERIFICATION(354),
    UC_PHONE_NUMBER_GAIA_REACHABILITY(355),
    UC_PHONE_NUMBER_GAIA_DISCOVERABILITY(356),
    UC_PHONE_NUMBER_BROAD_USE_CONSENT(357),
    UC_CARE_STUDIO_PROVISION_OF_SERVICE(322),
    UC_CARE_STUDIO_PRODUCT_IMPROVEMENT(323),
    UC_CARE_STUDIO_FUNCTIONAL_DEBUGGING(324),
    UC_CARE_STUDIO_MEASURING_USER_ENGAGEMENT(325),
    UC_GMM_VIEW_PORT_LOGGING(326),
    UC_TACHYON_PHONE_NUMBER_IDENTITY(329),
    UC_MDI_INFINITE_DATA(330),
    UC_NOW_PLAYING_CLOUD_SEARCH(331),
    UC_NOW_PLAYING(332),
    UC_MEET_USER_ENGAGEMENT(333),
    UC_GMS_CORE_CHROME_SYNC(334),
    UC_ODLH_NEWFIE_STORE_VISITS(335),
    UC_ODLH_WIFI_PLACE_VISITS(336),
    UC_ODLH_ACTIVITY_TRIPS(337),
    UC_ODLH_LIVE_BUSYNESS(338),
    UC_ODLH_HISTORICAL_BUSYNESS(339),
    UC_PAY_PHONE_NUMBER_DISCOVERABILITY(343),
    UC_PAY_GROUPS(344),
    UC_PAY_CONTACTS_SYNC(345),
    UC_SEMANTIC_LOCATION(358),
    UC_GMM_UGC_PUBLIC_POST_Q_AND_A(359),
    UC_STREET_VIEW_LOCATION_GPS(360),
    UC_STREET_VIEW_IMAGERY(361),
    UC_STREET_VIEW_HARDWARE_TELEMETRY_AND_PERFORMANCE(362),
    UC_GOOGLE_STREET_VIEW_MANAGEMENT(363),
    UC_CROWDSOURCE_GLIDE_TYPING(364),
    UC_CROWDSOURCE_CONTRIBUTED_TEXT_RESPONSE(365),
    UC_CROWDSOURCE_CONTRIBUTED_OPTION_RESPONSE(366),
    UC_ODLH_REQUEST_DEDUPLICATION(367),
    UC_MESSAGES_ASSISTANT_SUGGESTIONS_PRODUCT_IMPROVEMENT(370),
    UC_MESSAGES_ASSISTANT_SUGGESTIONS_USER_ENGAGEMENT(371),
    UC_MESSAGES_ASSISTANT_SUGGESTIONS_PROVISION_OF_SERVICE(372),
    UC_MESSAGES_SMART_REPLY_PRODUCT_IMPROVEMENT(373),
    UC_MESSAGES_SMART_REPLY_USER_ENGAGEMENT(374),
    UC_MESSAGES_SUGGESTED_ACTIONS_USER_ENGAGEMENT(375),
    UC_MESSAGES_SUGGESTED_ACTIONS_PRODUCT_IMPROVEMENT(376),
    UC_MESSAGES_SUGGESTED_STICKERS_USER_ENGAGEMENT(377),
    UC_MESSAGES_SUGGESTED_STICKERS_PRODUCT_IMPROVEMENT(378),
    UC_MESSAGES_LINK_SPAM_ABUSE_PREVENTION(379),
    UC_MESSAGES_LINK_PREVIEW_PROVISION_OF_SERVICE(380),
    UC_MESSAGES_ALL_PREVIEW_PROVISION_OF_SERVICE(381),
    UC_MESSAGES_PREVIEW_USER_ENGAGEMENT(382),
    UC_MESSAGES_PREVIEW_PRODUCT_IMPROVEMENT(383),
    UC_MESSAGES_VERIFIED_SMS_PROVISION_OF_SERVICE(384),
    UC_MESSAGES_VERIFIED_SMS_FUNCTIONAL_DEBUGGING(385),
    UC_MESSAGES_VERIFIED_SMS_PRODUCT_IMPROVEMENT(386),
    UC_MESSAGES_PRODUCT_IMPROVEMENT(387),
    UC_MESSAGES_USER_ENGAGEMENT(388),
    UC_MESSAGES_CMC_PROVISION_OF_SERVICE(389),
    UC_MESSAGES_CMC_USER_ENGAGEMENT(390),
    UC_MESSAGES_CMC_PRODUCT_IMPROVEMENT(391),
    UC_MESSAGES_DEVICE_PAIRING_PRODUCT_IMPROVEMENT(392),
    UC_MESSAGES_DEVICE_PAIRING_PROVISION_OF_SERVICE(393),
    UC_MESSAGES_FI_SYNC_PRODUCT_IMPROVEMENT(394),
    UC_MESSAGES_FI_SYNC_PROVISION_OF_SERVICE(395),
    UC_MESSAGES_RCS_PRODUCT_IMPROVEMENT(396),
    UC_MESSAGES_RCS_PROVISION_OF_SERVICE(397),
    UC_MESSAGES_RCS_USER_ENGAGEMENT(398),
    UC_MESSAGES_SUPERSORT_USER_ENGAGEMENT(399),
    UC_MESSAGES_SUPERSORT_PRODUCT_IMPROVEMENT(HttpStatus.SC_BAD_REQUEST),
    UC_CHROME_SYNC_PASSWORD_CREDENTIAL_GROUPING(369);

    private static final zzbfi zzeH = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbja
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbjc.zzc(i);
        }
    };
    private final int zzeJ;

    zzbjc(int i) {
        this.zzeJ = i;
    }

    public static zzbfj zzb() {
        return zzbjb.zza;
    }

    public static zzbjc zzc(int i) {
        if (i == 0) {
            return UC_DEFAULT;
        }
        if (i == 1) {
            return UC_PROTO_METADATA;
        }
        if (i == 2) {
            return UC_DELEGATED;
        }
        if (i == 3) {
            return UC_NEVER_COLLECT;
        }
        switch (i) {
            case 100:
                return UC_PLATFORM_OR_FEATURE_PRODUCT_IMPROVEMENT_WW;
            case 101:
                return UC_PLATFORM_OR_FEATURE_FUNCTIONAL_DEBUGGING_WW;
            case 102:
                return UC_PLATFORM_OR_FEATURE_PRODUCT_DEVELOPMENT_WW;
            case 103:
                return UC_PLATFORM_OR_FEATURE_MEASURING_USER_ENGAGEMENT_WW;
            case 104:
                return UC_SERVICE_OR_API_FUNCTIONAL_DEBUGGING_WW;
            case 105:
                return UC_SERVICE_OR_API_PRODUCT_IMPROVEMENT_WW;
            case 106:
                return UC_SERVICE_OR_API_PRODUCT_DEVELOPMENT_WW;
            case 107:
                return UC_ACCOUNT_INTEGRITY;
            case 108:
                return UC_SERVICE_OR_API_PRODUCT_IMPROVEMENT;
            case 109:
                return UC_PLATFORM_OR_FEATURE_PRODUCT_IMPROVEMENT;
            case 110:
                return UC_PRIMES_APP_HEALTH;
            case 111:
                return UC_UNBRANDED_1P_APP_FUNCTIONAL_DEBUGGING;
            case 112:
                return UC_UNBRANDED_1P_APP_PRODUCT_IMPROVEMENT;
            case 113:
                return UC_SERVICE_OR_API_MEASURING_USER_ENGAGEMENT;
            case 114:
                return UC_CRITICAL_FUNCTIONAL_FLEET_ISSUES;
            case 115:
                return UC_PLATFORM_OR_FEATURE_FUNCTIONAL_DEBUGGING;
            case 116:
                return UC_SERVICE_OR_API_FUNCTIONAL_DEBUGGING;
            case 117:
                return UC_UNBRANDED_1P_APP_FUNCTIONAL_DEBUGGING_WW;
            case 118:
                return UC_UNBRANDED_1P_APP_PRODUCT_IMPROVEMENT_WW;
            case 119:
                return UC_UNBRANDED_1P_APP_PRODUCT_DEVELOPMENT_WW;
            case 120:
                return UC_UNBRANDED_1P_APP_MEASURING_USER_ENGAGEMENT_WW;
            case 121:
                return UC_HEADLESS_1P_APP_FUNCTIONAL_DEBUGGING_WW;
            case 122:
                return UC_HEADLESS_1P_APP_PRODUCT_IMPROVEMENT_WW;
            case 123:
                return UC_HEADLESS_1P_APP_PRODUCT_DEVELOPMENT_WW;
            case 124:
                return UC_HEADLESS_1P_APP_MEASURING_USER_ENGAGEMENT_WW;
            case 125:
                return UC_APP_USAGE_FOREGROUND_USER_BEHAVIOR_WW;
            case 126:
                return UC_APP_USAGE_SYSTEM_HEALTH_WW;
            case 127:
                return UC_APP_USAGE_PERSONALIZATION_WW;
            case 128:
                return UC_SYSTEM_HEALTH_INTERACTION_WITH_PRODUCT_WW;
            case 129:
                return UC_SYSTEM_HEALTH_FUNCTIONAL_DEBUGGING_WW;
            case 130:
                return UC_PLATFORM_MARKET_STATISTICS_WW;
            case 131:
                return UC_CONTEXTUALIZATION_NO_USER_DATA_WW;
            case 132:
                return UC_SERVICE_OR_API_PRODUCT_DEVELOPMENT;
            case 133:
                return UC_PLATFORM_OR_FEATURE_PRODUCT_DEVELOPMENT;
            case 134:
                return UC_PLATFORM_OR_FEATURE_MEASURING_USER_ENGAGEMENT;
            case 135:
                return UC_CRITICAL_FLEET_MANAGEMENT;
            case 136:
                return UC_1P_APP_FUNCTIONAL_DEBUGGING;
            case 137:
                return UC_1P_APP_PRODUCT_IMPROVEMENT;
            case 138:
                return UC_1P_APP_PRODUCT_DEVELOPMENT;
            case 139:
                return UC_1P_APP_MEASURING_USER_ENGAGEMENT;
            case 140:
                return UC_CONTEXTUALIZATION_NO_USER_DATA;
            case 141:
                return UC_ANDROID_ECOSYSTEM_HEALTH;
            case 142:
                return UC_DEVICE_FINGERPRINT;
            case 143:
                return UC_DEVICE_INTEGRITY;
            case 144:
                return UC_PLATFORM_INTEGRITY;
            case 145:
                return UC_APP_INTEGRITY;
            case 146:
                return UC_FRAUD_SPAM_ABUSE_PREVENTION;
            case 147:
                return UC_DROIDGUARD_VERDICT_INPUT;
            case 148:
                return UC_PLAY_MALWARE_DETECTION;
            case 149:
                return UC_SIDELOAD_MALWARE_DETECTION;
            case 150:
                return UC_HEADLESS_1P_APP_FUNCTIONAL_DEBUGGING;
            case 151:
                return UC_HEADLESS_1P_APP_PRODUCT_IMPROVEMENT;
            case 152:
                return UC_HEADLESS_1P_APP_PRODUCT_DEVELOPMENT;
            case 153:
                return UC_HEADLESS_1P_APP_MEASURING_USER_ENGAGEMENT;
            case 154:
                return UC_SERVICE_OR_API_MEASURING_USER_ENGAGEMENT_WW;
            case 155:
                return UC_UNBRANDED_1P_APP_MEASURING_USER_ENGAGEMENT;
            case 156:
                return UC_UNBRANDED_1P_APP_PRODUCT_DEVELOPMENT;
            case 157:
                return UC_CROSS_PRODUCT_PERSONALIZATION_FOOTPRINTS;
            case 158:
                return UC_SERVICE_ABUSE_PREVENTION;
            case 159:
                return UC_EXPERIMENT_TARGETING;
            case 160:
                return UC_REFINING_EXPERIMENTS;
            case 161:
                return UC_GBOARD_FUNCTIONAL_DEBUGGING;
            case 162:
                return UC_GBOARD_PRODUCT_IMPROVEMENT;
            case 163:
                return UC_GBOARD_PRODUCT_DEVELOPMENT;
            case 164:
                return UC_GBOARD_MEASURING_USER_ENGAGEMENT;
            case 165:
                return UC_GPP_SIDELOADED_UNSAFE_APP_DETECTION;
            case 166:
                return UC_GPP_UNSAFE_APP_DETECTION;
            case 167:
                return UC_INTERNAL_DESCRIPTION;
            case 168:
                return UC_FMD_RING;
            case 169:
                return UC_FMD_LOCATE;
            case 170:
                return UC_FMD_LOCK;
            case 171:
                return UC_FMD_UNPAIR;
            case 172:
                return UC_ENX_OPT_OUT_DEIDENTIFIED_TELEMETRY;
            case 173:
                return UC_1P_HW_FUNCTIONAL_DEBUGGING_WW;
            case 174:
                return UC_1P_HW_PRODUCT_IMPROVEMENT_WW;
            case 175:
                return UC_1P_HW_PRODUCT_DEVELOPMENT_WW;
            case 176:
                return UC_1P_HW_MEASURING_USER_ENGAGEMENT_WW;
            case 177:
                return UC_FIT_FUNCTIONAL_DEBUGGING;
            case 178:
                return UC_FIT_PRODUCT_IMPROVEMENT;
            case BuildConfig.VERSION_CODE /* 179 */:
                return UC_FIT_PRODUCT_DEVELOPMENT;
            case 180:
                return UC_FIT_MEASURING_USER_ENGAGEMENT;
            case 181:
                return UC_FMD_IDENTIFY_DEVICE_STATE_AND_CAPABILITY;
            case 182:
                return UC_FOREGROUND_LOCATION;
            case 183:
                return UC_LOCATION_HISTORY;
            case 184:
                return UC_LOCATION_HISTORY_USER_EDIT;
            case 185:
                return UC_LOCATION_ACCURACY;
            case 186:
                return UC_LOCATION_ACCURACY_WIFI;
            case 187:
                return UC_EARTHQUAKE_ALERTING;
            case 188:
                return UC_FIT_APP_OR_API_FUNCTIONAL_DEBUGGING;
            case 189:
                return UC_FIT_APP_OR_API_PRODUCT_IMPROVEMENT;
            case 190:
                return UC_FIT_APP_OR_API_PRODUCT_DEVELOPMENT;
            case 191:
                return UC_FIT_APP_OR_API_MEASURING_USER_ENGAGEMENT;
            case 192:
                return UC_FCM_FUNCTIONAL_DEBUGGING;
            case 193:
                return UC_1P_HW_DEVICE_MANAGEMENT;
            case 194:
                return UC_1P_APP_PROVISION_OF_SERVICE;
            case 195:
                return UC_BACKUP_USER_DATA;
            case 196:
                return UC_GPP_UPLOAD_UNSAFE_APP;
            case 197:
                return UC_RESERVED_FOR_TESTING_IN_PRODUCT_CONTROL;
            default:
                switch (i) {
                    case 199:
                        return UC_SDK_FUNCTIONAL_DEBUGGING;
                    case 200:
                        return UC_SDK_PRODUCT_IMPROVEMENT;
                    case 201:
                        return UC_SDK_PRODUCT_DEVELOPMENT;
                    case 202:
                        return UC_SDK_MEASURING_USER_ENGAGEMENT;
                    case 203:
                        return UC_3P_APP_PROVISION_OF_SERVICE;
                    case 204:
                        return UC_WEAR_CLOUD_SYNC;
                    case 205:
                        return UC_CHIME_MEASURING_USER_ENGAGEMENT;
                    case HttpStatus.SC_PARTIAL_CONTENT /* 206 */:
                        return UC_CHIME_FUNCTIONAL_DEBUGGING;
                    case HttpStatus.SC_MULTI_STATUS /* 207 */:
                        return UC_CHIME_PRODUCT_IMPROVEMENT;
                    case 208:
                        return UC_CONTACTS_ACCOUNT_TYPE_LOGGING;
                    case 209:
                        return UC_IN_PRODUCT_PERSONALIZATION;
                    case 210:
                        return UC_NEARBY_MESSAGES;
                    case 211:
                        return UC_FAST_PAIR;
                    case 212:
                        return UC_NEARBY_SHARING;
                    case 213:
                        return UC_USER_AUTHENTICATION;
                    case 214:
                        return UC_GOOGLE_CONTACTS_SYNC;
                    case 215:
                        return UC_DEVICE_CONTACT_INFO_COLLECTION;
                    case 216:
                        return UC_PEOPLE_DETAILS_SYNC;
                    case 217:
                        return UC_UNBRANDED_CROSS_PRODUCT_PERSONALIZATION_FOOTPRINTS;
                    case 218:
                        return UC_WIFI_NETWORK_SCORING;
                    case 219:
                        return UC_3P_APP_DEVICE_INTEGRITY;
                    case 220:
                        return UC_VERIFY_URL;
                    default:
                        switch (i) {
                            case 222:
                                return UC_IP_LOCATION;
                            case 223:
                                return UC_POPULATED_SERVER_SIDE;
                            case 224:
                                return UC_FI_FUNCTIONAL_DEBUGGING;
                            case 225:
                                return UC_FI_PRODUCT_IMPROVEMENT;
                            case 226:
                                return UC_EARTHQUAKE_DETECTION;
                            case 227:
                                return UC_FI_MEASURING_USER_ENGAGEMENT;
                            case 228:
                                return UC_ADS_TARGETING;
                            case 229:
                                return UC_ADS_MEASUREMENT;
                            case 230:
                                return UC_ADS_EXTERNAL_INTEGRATION;
                            case 231:
                                return UC_ABUSE_CONTENT_CLASSIFICATION_VERDICTS;
                            case 232:
                                return UC_BRELLA_FUNCTIONAL_DEBUGGING;
                            case 233:
                                return UC_FI_CELL_TOWER_HISTORY;
                            case 234:
                                return UC_PAY_FUNCTIONAL_DEBUGGING;
                            case 235:
                                return UC_PAY_PRODUCT_IMPROVEMENT;
                            case 236:
                                return UC_PAY_MEASURING_USER_ENGAGEMENT;
                            case 237:
                                return UC_FMD_LOCATE_ACCESSORY;
                            case 238:
                                return UC_SEARCH_HISTORY;
                            case 239:
                                return UC_BROWSING_HISTORY;
                            case 240:
                                return UC_RESTORE_USER_DATA;
                            case 241:
                                return UC_LOCATION_HISTORY_CONSENT_CHANGE;
                            case 242:
                                return UC_UNICORN_SETUP;
                            case 243:
                                return UC_UNICORN_MANAGEMENT;
                            case 244:
                                return UC_UNICORN_ACTIVITY_SUPERVISION;
                            case 245:
                                return UC_ADS_DELIVERY;
                            case 246:
                                return UC_ADS_GENERAL_TARGETING;
                            case 247:
                                return UC_ADS_PERSONALIZATION;
                            default:
                                switch (i) {
                                    case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                                        return UC_FAMILY_ADMIN;
                                    case 251:
                                        return UC_FAMILY_1P_INTEGRATION;
                                    case 252:
                                        return UC_DIGITAL_WELLBEING_FUNCTIONAL_DEBUGGING;
                                    case 253:
                                        return UC_DIGITAL_WELLBEING_MEASURING_USER_ENGAGEMENT;
                                    case 254:
                                        return UC_DIGITAL_WELLBEING_PRODUCT_IMPROVEMENT;
                                    case 255:
                                        return UC_AUDIT_RECORD;
                                    case 256:
                                        return UC_LOCATION_SHARING;
                                    case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                                        return UC_GMM_PUBLIC_PHOTO;
                                    case 258:
                                        return UC_GMM_PUBLIC_VIDEO;
                                    case 259:
                                        return UC_GMM_USER_INITIATED_FEEDBACK;
                                    case 260:
                                        return UC_MARKETING_ENGAGEMENT_GROWTH_COMMS;
                                    case 261:
                                        return UC_LOCATION_HISTORY_BOTTOM_SHEET_CONSENT_TOGGLE;
                                    case 262:
                                        return UC_FI_PROVISION_OF_SERVICE;
                                    case 263:
                                        return UC_HEADLESS_DPC_CLOUD_API_PROVISION_OF_SERVICE;
                                    case 264:
                                        return UC_HEADLESS_DPC_CLOUD_API_FUNCTIONAL_DEBUGGING;
                                    case 265:
                                        return UC_PAY_PROVISION_OF_SERVICE;
                                    case 266:
                                        return UC_PAY_DEVICE_FINGERPRINT;
                                    case 267:
                                        return UC_BACKUP_MANAGEMENT;
                                    case 268:
                                        return UC_PLAY_APP_PROVISION_OF_SERVICE;
                                    case 269:
                                        return UC_CONTEXTUALIZATION;
                                    case 270:
                                        return UC_CONTEXTUALIZATION_RECENT_ACTIVITY;
                                    case 271:
                                        return UC_CONTEXTUALIZATION_DEVICE_CAPABILITIES;
                                    case 272:
                                        return UC_CONTEXTUALIZATION_DEVICE_STATE;
                                    case 273:
                                        return UC_CONTEXTUALIZATION_LANGUAGE_OR_LOCALE;
                                    case 274:
                                        return UC_CONTEXTUALIZATION_COUNTRY;
                                    case 275:
                                        return UC_CONTEXTUALIZATION_USER_DATA;
                                    case 276:
                                        return UC_DEVICE_APPS;
                                    case 277:
                                        return UC_CONTEXTUALIZATION_1P_INSTALLED_APPS;
                                    case 278:
                                        return UC_CONTEXTUALIZATION_DEFAULT_HANDLER_APPS;
                                    case 279:
                                        return UC_HEADLESS_DPC_CLOUD_API_CONFIGURE_APP_POLICIES;
                                    case 280:
                                        return UC_FCM_MESSAGE_DELIVERY;
                                    case 281:
                                        return UC_PANELS_APP_PROVISION_OF_SERVICE;
                                    case 282:
                                        return UC_PANELS_APP_FUNCTIONAL_DEBUGGING;
                                    case DfuBaseService.NOTIFICATION_ID /* 283 */:
                                        return UC_PANELS_APP_IN_APP_DATA;
                                    case 284:
                                        return UC_STACK_COPY_TO_DRIVE;
                                    case 285:
                                        return UC_HEADLESS_DPC_CLOUD_API_REPORT_DEVICE_INFO;
                                    case 286:
                                        return UC_HEADLESS_DPC_CLOUD_API_SET_UP_DEVICE_MANAGEMENT;
                                    case 287:
                                        return UC_HEADLESS_DPC_CLOUD_API_RUN_DEVICE_COMMANDS;
                                    case 288:
                                        return UC_PAY_FRAUD_SPAM_ABUSE_PREVENTION;
                                    case 289:
                                        return UC_CHIME_NOTIFICATION_MANAGEMENT;
                                    case 290:
                                        return UC_OPENSKY_PROVISION_OF_SERVICE;
                                    case 291:
                                        return UC_OPENSKY_FUNCTIONAL_DEBUGGING;
                                    case 292:
                                        return UC_OPENSKY_MEASURING_USER_ENGAGEMENT;
                                    case 293:
                                        return UC_OPENSKY_PRODUCT_IMPROVEMENT;
                                    case 294:
                                        return UC_WINGDELIVERY_PROVISION_OF_SERVICE;
                                    case 295:
                                        return UC_WINGDELIVERY_FUNCTIONAL_DEBUGGING;
                                    case 296:
                                        return UC_WINGDELIVERY_PRODUCT_IMPROVEMENT;
                                    case 297:
                                        return UC_WINGDELIVERY_MEASURING_USER_ENGAGEMENT;
                                    case 298:
                                        return UC_PLAY_CONSOLE_PROVISION_OF_SERVICE;
                                    case 299:
                                        return UC_PLAY_CONSOLE_FUNCTIONAL_DEBUGGING;
                                    case HttpStatus.SC_MULTIPLE_CHOICES /* 300 */:
                                        return UC_PLAY_CONSOLE_MEASURING_USER_ENGAGEMENT;
                                    case 301:
                                        return UC_PLAY_CONSOLE_PRODUCT_IMPROVEMENT;
                                    case 302:
                                        return UC_KEY_EXCHANGE;
                                    case 303:
                                        return UC_DROIDGUARD_ATTESTATION;
                                    case 304:
                                        return UC_BINARY_TRANSPARENCY;
                                    case 305:
                                        return UC_GMM_VOTE;
                                    case SReturnCode.INVALID_CHECKER_TYPE /* 306 */:
                                        return UC_GMM_UGC_PUBLIC_REPORT;
                                    case 307:
                                        return UC_OAUTH_GAIA_SIGNIN;
                                    case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                                        return UC_UNBRANDED_TASKMATE_PROVISION_OF_SERVICE;
                                    case 309:
                                        return UC_CHROME_IMAGE_DESCRIPTIONS;
                                    case 310:
                                        return UC_CROWDSOURCE_PUBLIC_PHOTO;
                                    case 311:
                                        return UC_CROWDSOURCE_CONTRIBUTED_AUDIO;
                                    case 312:
                                        return UC_GMM_OWNER_RESPONSE;
                                    case 313:
                                        return UC_GMM_PUBLIC_REVIEW;
                                    case 314:
                                        return UC_HADES_REQUEST_MODEL_AND_DATA_UPDATES;
                                    case 315:
                                        return UC_HADES_USAGE_INFO;
                                    case 316:
                                        return UC_ARES_CONTENT_ABUSE_REPORT;
                                    case 317:
                                        return UC_ARES_TAKEDOWN_APPEALS;
                                    case 318:
                                        return UC_FMD_ERASE_DEVICE;
                                    case 319:
                                        return UC_LOCATION_TIME_ZONE;
                                    case 320:
                                        return UC_GMM_NAVIGATION;
                                    case 321:
                                        return UC_BRELLA_FEDERATED_COMPUTE;
                                    case 322:
                                        return UC_CARE_STUDIO_PROVISION_OF_SERVICE;
                                    case 323:
                                        return UC_CARE_STUDIO_PRODUCT_IMPROVEMENT;
                                    case 324:
                                        return UC_CARE_STUDIO_FUNCTIONAL_DEBUGGING;
                                    case 325:
                                        return UC_CARE_STUDIO_MEASURING_USER_ENGAGEMENT;
                                    case 326:
                                        return UC_GMM_VIEW_PORT_LOGGING;
                                    case 327:
                                        return UC_MARKETING_ENGAGEMENT_GROWTH_FREQ_CAP;
                                    case 328:
                                        return UC_HADES_OPRF_BLINDED_USER_CONTENT;
                                    case 329:
                                        return UC_TACHYON_PHONE_NUMBER_IDENTITY;
                                    case 330:
                                        return UC_MDI_INFINITE_DATA;
                                    case 331:
                                        return UC_NOW_PLAYING_CLOUD_SEARCH;
                                    case 332:
                                        return UC_NOW_PLAYING;
                                    case 333:
                                        return UC_MEET_USER_ENGAGEMENT;
                                    case 334:
                                        return UC_GMS_CORE_CHROME_SYNC;
                                    case 335:
                                        return UC_ODLH_NEWFIE_STORE_VISITS;
                                    case 336:
                                        return UC_ODLH_WIFI_PLACE_VISITS;
                                    case 337:
                                        return UC_ODLH_ACTIVITY_TRIPS;
                                    case 338:
                                        return UC_ODLH_LIVE_BUSYNESS;
                                    case 339:
                                        return UC_ODLH_HISTORICAL_BUSYNESS;
                                    case 340:
                                        return UC_3P_PASSWORD_LEAK_CHECK;
                                    case 341:
                                        return UC_CHROME_WEB_BROWSING;
                                    case 342:
                                        return UC_CHROME_AUTH;
                                    case 343:
                                        return UC_PAY_PHONE_NUMBER_DISCOVERABILITY;
                                    case 344:
                                        return UC_PAY_GROUPS;
                                    case 345:
                                        return UC_PAY_CONTACTS_SYNC;
                                    default:
                                        switch (i) {
                                            case 353:
                                                return UC_PHONE_NUMBER_ACCOUNT_SECURITY;
                                            case 354:
                                                return UC_CONSTELLATION_VERIFICATION;
                                            case 355:
                                                return UC_PHONE_NUMBER_GAIA_REACHABILITY;
                                            case 356:
                                                return UC_PHONE_NUMBER_GAIA_DISCOVERABILITY;
                                            case 357:
                                                return UC_PHONE_NUMBER_BROAD_USE_CONSENT;
                                            case 358:
                                                return UC_SEMANTIC_LOCATION;
                                            case 359:
                                                return UC_GMM_UGC_PUBLIC_POST_Q_AND_A;
                                            case 360:
                                                return UC_STREET_VIEW_LOCATION_GPS;
                                            case 361:
                                                return UC_STREET_VIEW_IMAGERY;
                                            case 362:
                                                return UC_STREET_VIEW_HARDWARE_TELEMETRY_AND_PERFORMANCE;
                                            case 363:
                                                return UC_GOOGLE_STREET_VIEW_MANAGEMENT;
                                            case 364:
                                                return UC_CROWDSOURCE_GLIDE_TYPING;
                                            case 365:
                                                return UC_CROWDSOURCE_CONTRIBUTED_TEXT_RESPONSE;
                                            case 366:
                                                return UC_CROWDSOURCE_CONTRIBUTED_OPTION_RESPONSE;
                                            case 367:
                                                return UC_ODLH_REQUEST_DEDUPLICATION;
                                            default:
                                                switch (i) {
                                                    case 369:
                                                        return UC_CHROME_SYNC_PASSWORD_CREDENTIAL_GROUPING;
                                                    case 370:
                                                        return UC_MESSAGES_ASSISTANT_SUGGESTIONS_PRODUCT_IMPROVEMENT;
                                                    case 371:
                                                        return UC_MESSAGES_ASSISTANT_SUGGESTIONS_USER_ENGAGEMENT;
                                                    case 372:
                                                        return UC_MESSAGES_ASSISTANT_SUGGESTIONS_PROVISION_OF_SERVICE;
                                                    case 373:
                                                        return UC_MESSAGES_SMART_REPLY_PRODUCT_IMPROVEMENT;
                                                    case 374:
                                                        return UC_MESSAGES_SMART_REPLY_USER_ENGAGEMENT;
                                                    case 375:
                                                        return UC_MESSAGES_SUGGESTED_ACTIONS_USER_ENGAGEMENT;
                                                    case 376:
                                                        return UC_MESSAGES_SUGGESTED_ACTIONS_PRODUCT_IMPROVEMENT;
                                                    case 377:
                                                        return UC_MESSAGES_SUGGESTED_STICKERS_USER_ENGAGEMENT;
                                                    case 378:
                                                        return UC_MESSAGES_SUGGESTED_STICKERS_PRODUCT_IMPROVEMENT;
                                                    case 379:
                                                        return UC_MESSAGES_LINK_SPAM_ABUSE_PREVENTION;
                                                    case 380:
                                                        return UC_MESSAGES_LINK_PREVIEW_PROVISION_OF_SERVICE;
                                                    case 381:
                                                        return UC_MESSAGES_ALL_PREVIEW_PROVISION_OF_SERVICE;
                                                    case 382:
                                                        return UC_MESSAGES_PREVIEW_USER_ENGAGEMENT;
                                                    case 383:
                                                        return UC_MESSAGES_PREVIEW_PRODUCT_IMPROVEMENT;
                                                    case 384:
                                                        return UC_MESSAGES_VERIFIED_SMS_PROVISION_OF_SERVICE;
                                                    case 385:
                                                        return UC_MESSAGES_VERIFIED_SMS_FUNCTIONAL_DEBUGGING;
                                                    case 386:
                                                        return UC_MESSAGES_VERIFIED_SMS_PRODUCT_IMPROVEMENT;
                                                    case 387:
                                                        return UC_MESSAGES_PRODUCT_IMPROVEMENT;
                                                    case 388:
                                                        return UC_MESSAGES_USER_ENGAGEMENT;
                                                    case 389:
                                                        return UC_MESSAGES_CMC_PROVISION_OF_SERVICE;
                                                    case 390:
                                                        return UC_MESSAGES_CMC_USER_ENGAGEMENT;
                                                    case 391:
                                                        return UC_MESSAGES_CMC_PRODUCT_IMPROVEMENT;
                                                    case 392:
                                                        return UC_MESSAGES_DEVICE_PAIRING_PRODUCT_IMPROVEMENT;
                                                    case 393:
                                                        return UC_MESSAGES_DEVICE_PAIRING_PROVISION_OF_SERVICE;
                                                    case 394:
                                                        return UC_MESSAGES_FI_SYNC_PRODUCT_IMPROVEMENT;
                                                    case 395:
                                                        return UC_MESSAGES_FI_SYNC_PROVISION_OF_SERVICE;
                                                    case 396:
                                                        return UC_MESSAGES_RCS_PRODUCT_IMPROVEMENT;
                                                    case 397:
                                                        return UC_MESSAGES_RCS_PROVISION_OF_SERVICE;
                                                    case 398:
                                                        return UC_MESSAGES_RCS_USER_ENGAGEMENT;
                                                    case 399:
                                                        return UC_MESSAGES_SUPERSORT_USER_ENGAGEMENT;
                                                    case HttpStatus.SC_BAD_REQUEST /* 400 */:
                                                        return UC_MESSAGES_SUPERSORT_PRODUCT_IMPROVEMENT;
                                                    default:
                                                        return null;
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzeJ);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzeJ;
    }
}
