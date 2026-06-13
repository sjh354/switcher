package com.google.android.gms.internal.gtm;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbry implements zzbfh {
    ACCESS_REQUIREMENT_UNSPECIFIED(0),
    LEGACY_RESTRICTION(1),
    LEGAL_UNSERVABLE_UNTIL_FURTHER_REVIEW(5),
    CONTRACTUAL_PRERELEASE_MUSIC_DATA(2),
    CONTRACTUAL_PRERELEASE_MUSIC_DATA_GPM(7),
    CONTRACTUAL_STATS_LLC_DATA(3),
    LEGAL_PUBLIC_DOMAIN_US(4),
    LEGAL_GEO_NOT_SERVABLE_IN_CHINA(6),
    ACCESS_REQUIREMENT_OUT_OF_RANGE(999),
    SPII_SEARCH_PUBLIC_INTEREST(18),
    SPII_KGO(20),
    SPII_WALDREF(21),
    CONTRACTUAL_OPTA_DATA_MIGRATION(1000),
    CONTRACTUAL_STATS_DATA_MIGRATION(1001),
    TECHNICAL_DEBT_SIRIUS_MIGRATION(PointerIconCompat.TYPE_HAND),
    TECHNICAL_IN_DEVELOPMENT_GEO_KG_UGC(PointerIconCompat.TYPE_HELP),
    MOMA_RESTRICTED_TVC(2000),
    MOMA_UNRESTRICTED_TVC(2001),
    MOMA_FTE(2002),
    AOG_TEST_DATA(2003),
    CONTRACTUAL_NETFLIX_DATA(3001),
    CONTRACTUAL_NETFLIX_GRACENOTE(3010),
    CONTRACTUAL_SPOTIFY_PODCAST_DATA(93),
    CONTRACTUAL_IPG_DATA(100),
    CONTRACTUAL_YOUVIEW_DATA(101),
    CREATOR_PRESENCE_DATA(104),
    TECHNICAL_UNRECONCILED_MEDIA_ACTION(3002),
    CONTRACTUAL_AUDIBLE_DATA(3003),
    CONTRACTUAL_SEARCH_NETFLIX_DATA(3004),
    CONTRACTUAL_ASSISTANT_MEDIA_ACTIONS(3005),
    CONTRACTUAL_ANDROID_TV_NETFLIX_DATA(3006),
    CONTRACTUAL_GOOGLE_PLAY_MOVIES_DATA(3007),
    CONTRACTUAL_RANKING_PROVIDER_POPULARITY_DATA(3008),
    CONTRACTUAL_CARBON_INDEX_DATA(105),
    CONTRACTUAL_CARBON_INDEX_APP(106),
    TRAVEL_ACTIVITY_DATA(3009),
    CONTRACTUAL_AOG_FOOD_ORDERING_DATA(4000),
    CONTRACTUAL_YETI_DATA(94),
    CONTRACTUAL_BBC_PROVIDER_METADATA(92),
    JANATA_USER_GENERATED_DATA(8),
    TRIANGULATION_LOSERS_FOR_REFX(9),
    CONTRACTUAL_PRERELEASE_YT_SHOWS(10),
    SPII_LOSERS_FOR_REFX(11),
    SHOPPING_PRODUCT_IMAGE(22),
    SHOPPING_PRODUCT_DESCRIPTION(23),
    SHOPPING_PRODUCT_ATTRIBUTE(24),
    SHOPPING_ON_DOT_COM_ONLY(25),
    SHOPPING_ORGANIC_ONLY(26),
    SHOPPING_ORGANIC_ON_DOT_COM_ONLY(27),
    SHOPPING_PRE_RELEASE_PRODUCT(29),
    SHOPPING_DO_NOT_PUBLISH_TO_TOPIC_SERVER(67),
    LMS_POLICY_ACKED_ONLY(28),
    MINED_PEOPLE(12),
    LIMITED_FOR_SEMANTIC_UNDERSTANDING(13),
    ISOLATION_S3_MEDIA_ACTION(14),
    ISOLATION_S3_REAL_ESTATE(15),
    ISOLATION_S3_AUTOS(30),
    ISOLATION_S3_NLWEB(31),
    ISOLATION_S3_RECOMEDIA(80),
    ISOLATION_S3_GEO_CARS(10000),
    ISOLATION_YOUTUBE_OTT(99),
    ISOLATION_YOUTUBE_MUSIC_BASS_ENTITIES(102),
    ISOLATION_FINANCIAL_DATA(97),
    ISOLATION_MEDICAL(10004),
    ISOLATION_G4C(103),
    ISOLATION_EXPERIMENT_ONLY(16),
    ISOLATION_KE_INTERNAL(86),
    ISOLATION_WEB_CHANNELS(10001),
    ISOLATION_ONRAMP_DICTIONARY_EXPERIMENT(10002),
    ISOLATION_PKG_ANDROID_AUTO_EMBEDDED_SIGNED_IN(15034),
    ISOLATION_PKG_ANDROID_AUTO_EMBEDDED_SIGNED_OUT(15035),
    ISOLATION_PKG_APP_NAMES(15002),
    ISOLATION_PKG_ASSISTANT_CONTACT_AFFINITY_WITH_METADATA(15011),
    ISOLATION_PKG_ASSISTANT_DEVICE_SETTINGS(49),
    ISOLATION_PKG_ASSISTANT_LIST_NAMES_FOR_SPEECH_BIASING(15039),
    ISOLATION_PKG_ASSISTANT_SETTINGS_FOOTPRINTS(37),
    ISOLATION_PKG_ASSISTANT_SETTINGS_NICKNAME(15026),
    ISOLATION_PKG_CALENDAR_EVENTS_FOR_QUERY_ANNOTATION(15006),
    ISOLATION_PKG_CALENDAR_EVENTS_FOR_SPEECH_BIASING(15005),
    ISOLATION_PKG_CALENDARS_FOR_QUERY_ANNOTATION(15021),
    ISOLATION_PKG_CALENDARS_FOR_SPEECH_BIASING(15022),
    PKG_ASSISTANT_CONTACT_AFFINITY_FOOTPRINTS(73),
    ISOLATION_PKG_CONTACT_AGGREGATED_SIGNALS(63),
    ISOLATION_PKG_CONTENT_INTERESTS(35),
    ISOLATION_PKG_DEVICE_INSTALLED_APPS(66),
    ISOLATION_PKG_DISCOVER_SMART_HOME_DEVICES(43),
    ISOLATION_PKG_DYNAMIC_ENTITIES(54),
    ISOLATION_PKG_FLIGHT_LEG_RESERVATIONS(50),
    ISOLATION_PKG_FOCUS_OWNER_PROFILE(56),
    ISOLATION_PKG_FORMATTED_ADDRESS(83),
    ISOLATION_PKG_GAIA(59),
    ISOLATION_PKG_GELLER_ANSWERS(55),
    ISOLATION_PKG_GMAIL_BILLS(15009),
    ISOLATION_PKG_GMAIL_ORDERS(15010),
    ISOLATION_PKG_HABITS(15015),
    ISOLATION_PKG_HANDBAG_ENTITIES(40),
    ISOLATION_PKG_HERON_INTENTS_AND_TYPES(15008),
    ISOLATION_PKG_HOTEL_RESERVATIONS(51),
    ISOLATION_PKG_HOUSEHOLD(41),
    ISOLATION_PKG_LAMS_PREFERENCES(34),
    ISOLATION_PKG_LOCATION_SHARING_CONTACTS(85),
    ISOLATION_PKG_MAPS_ALIAS_FOOTPRINTS(39),
    ISOLATION_PKG_MAPS_SEARCH_LOCATIONS(84),
    ISOLATION_PKG_LOCAL_LEAF_PAGE_VIEW_LOCATIONS(15040),
    ISOLATION_PKG_MEDIA_HABITUAL_CACHE(58),
    ISOLATION_PKG_MEDIA_LIBRARY(15004),
    ISOLATION_PKG_MEDIA_USER_CONTEXT_INFO(15001),
    ISOLATION_PKG_MEDIA_USER_ENTITIES(15007),
    ISOLATION_PKG_PARKING_LOCATIONS(57),
    ISOLATION_PKG_PEOPLE_API(36),
    ISOLATION_PKG_PEOPLE_API_CONTACT_ANNOTATIONS(15023),
    ISOLATION_PKG_PEOPLE_API_GET_PEOPLE_BY_IDS(15037),
    ISOLATION_PKG_PERSONAL_CONTACT_ANNOTATIONS(15019),
    ISOLATION_PKG_PERSONAL_PLACES(76),
    ISOLATION_PKG_PERSONAL_SHARED_CONTACT_ANNOTATIONS(15024),
    ISOLATION_PKG_PERSONALIZED_PRONUNCIATIONS(68),
    ISOLATION_PKG_PLAY_AUDIO_BOOKS(65),
    ISOLATION_PKG_PWS_ASSISTANT_CONTACTS_FOOTPRINTS(38),
    ISOLATION_PKG_ASSISTANT_UPP_PERSONAL_TOP_ENTITIES(15041),
    PKG_RESERVATION_DATA(89),
    ISOLATION_PKG_GI_HOTEL_RESERVATION_DATA(15029),
    ISOLATION_PKG_GI_FLIGHT_RESERVATION_DATA(15030),
    ISOLATION_PKG_GI_CAR_RENTAL_RESERVATION_DATA(15031),
    ISOLATION_PKG_GI_TRANSPORTATION_RESERVATION_DATA(15032),
    ISOLATION_PKG_GI_RESTAURANT_RESERVATION_DATA(15033),
    ISOLATION_PKG_RESTAURANT_RESERVATIONS(52),
    ISOLATION_PKG_SELF_ENTITIES(15020),
    ISOLATION_PKG_SOCIAL_EVENT_RESERVATIONS(53),
    ISOLATION_PKG_SOCIAL_GRAPH_PEOPLE_API(15012),
    ISOLATION_PKG_STADIA_CONTACTS(77),
    ISOLATION_PKG_STARLIGHT_BULK_LOOKUP(44),
    ISOLATION_PKG_STARLIGHT_BULK_LOOKUP_CONSISTENT(45),
    ISOLATION_PKG_STARLIGHT_BULK_LOOKUP_CONSISTENT_CONTACTS(15003),
    ISOLATION_PKG_STARLIGHT_COMPOSITE(60),
    ISOLATION_PKG_STARLIGHT_COMPOSITE_FACE_LABELS(61),
    ISOLATION_PKG_STARLIGHT_FACE_LABELS(46),
    ISOLATION_PKG_STARLIGHT_QUERY(15016),
    ISOLATION_PKG_STARLIGHT_TOP_CONTACTS(47),
    ISOLATION_PKG_STARLIGHT_VISIBLE_TO_GUESTS(82),
    ISOLATION_PKG_STRUCTURED_MEMORY_FOOTPRINTS(42),
    ISOLATION_PKG_TEACH_AND_LEARN_ENTITIES(48),
    ISOLATION_PKG_ASSISTANT_ROUTINES(15038),
    ISOLATION_PKG_VANITY_COLLECTIONS(15013),
    ISOLATION_PKG_WEBSEARCH(15027),
    ISOLATION_PKG_WHITEPAGES_PHONE_NUMBER(33),
    ISOLATION_PKG_VOICE_PROFILE(15036),
    ISOLATION_PKG_YOUTUBE_ASSISTANT_CONTEXT(74),
    ISOLATION_PKG_YOUTUBE_ASSISTANT_XWALKSAFE_CONTEXT(15014),
    ISOLATION_PKG_YOUTUBE_MUSIC_LOCKER(79),
    ISOLATION_PKG_YOUTUBE_PLAYLISTS(15017),
    ISOLATION_PKG_YOUTUBE_PLAYLIST_SEARCH(15028),
    ISOLATION_PKG_YOUTUBE_PRIVATE_PLAYLISTS(15018),
    ISOLATION_PKG_YOUTUBE_PUBLIC_AND_PRIVATE_PLAYLISTS(15025),
    ISOLATION_S3_CREATOR_PRESENCE(10003),
    UMP_TESTING_ONLY(32),
    INTENTJOINS_NB_SIGNALS(62),
    ADS_INTEGRITY_ANNOTATION(64),
    COVID_MAPS_SENSITIVE(69),
    KE_TRUST(70),
    SENSITIVE_ENTITIES_CLASSIFICATION(71),
    ISOLATION_S3_DATASEARCH(72),
    VIRTUALCARE_US(75),
    NETFLIX_AVAILABILITY_MEDIA_ACTION(78),
    ACCC_RISKY_DATA(87),
    AU_ACCC_RISKY_FOR_DISPLAY(88),
    GEO_FEATURE_RESTRICTION(98),
    RIGHTS_MANAGEMENT_100(20101),
    RIGHTS_MANAGEMENT_101(20102),
    RIGHTS_MANAGEMENT_102(20103),
    DICTIONARY_DATA_OXFORD(95),
    DICTIONARY_DATA_LE_ROBERT(96),
    AR_ONBOARDING_TEST(90),
    AR_ONBOARDING_TEST_2(91),
    MATERIALIZED_ENRICHER_INTERNAL(1701),
    MATERIALIZED_SCUBED_INTERNAL(1702);

    private static final zzbfi zzct = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbrw
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbry.zzc(i);
        }
    };
    private final int zzcv;

    zzbry(int i) {
        this.zzcv = i;
    }

    public static zzbfj zzb() {
        return zzbrx.zza;
    }

    public static zzbry zzc(int i) {
        if (i == 1701) {
            return MATERIALIZED_ENRICHER_INTERNAL;
        }
        if (i == 1702) {
            return MATERIALIZED_SCUBED_INTERNAL;
        }
        switch (i) {
            case 0:
                return ACCESS_REQUIREMENT_UNSPECIFIED;
            case 1:
                return LEGACY_RESTRICTION;
            case 2:
                return CONTRACTUAL_PRERELEASE_MUSIC_DATA;
            case 3:
                return CONTRACTUAL_STATS_LLC_DATA;
            case 4:
                return LEGAL_PUBLIC_DOMAIN_US;
            case 5:
                return LEGAL_UNSERVABLE_UNTIL_FURTHER_REVIEW;
            case 6:
                return LEGAL_GEO_NOT_SERVABLE_IN_CHINA;
            case 7:
                return CONTRACTUAL_PRERELEASE_MUSIC_DATA_GPM;
            case 8:
                return JANATA_USER_GENERATED_DATA;
            case 9:
                return TRIANGULATION_LOSERS_FOR_REFX;
            case 10:
                return CONTRACTUAL_PRERELEASE_YT_SHOWS;
            case 11:
                return SPII_LOSERS_FOR_REFX;
            case 12:
                return MINED_PEOPLE;
            case 13:
                return LIMITED_FOR_SEMANTIC_UNDERSTANDING;
            case 14:
                return ISOLATION_S3_MEDIA_ACTION;
            case 15:
                return ISOLATION_S3_REAL_ESTATE;
            case 16:
                return ISOLATION_EXPERIMENT_ONLY;
            default:
                switch (i) {
                    case 18:
                        return SPII_SEARCH_PUBLIC_INTEREST;
                    case 20:
                        return SPII_KGO;
                    case 21:
                        return SPII_WALDREF;
                    case 22:
                        return SHOPPING_PRODUCT_IMAGE;
                    case 23:
                        return SHOPPING_PRODUCT_DESCRIPTION;
                    case 24:
                        return SHOPPING_PRODUCT_ATTRIBUTE;
                    case 25:
                        return SHOPPING_ON_DOT_COM_ONLY;
                    case 26:
                        return SHOPPING_ORGANIC_ONLY;
                    case 27:
                        return SHOPPING_ORGANIC_ON_DOT_COM_ONLY;
                    case 28:
                        return LMS_POLICY_ACKED_ONLY;
                    case 29:
                        return SHOPPING_PRE_RELEASE_PRODUCT;
                    case 30:
                        return ISOLATION_S3_AUTOS;
                    case 31:
                        return ISOLATION_S3_NLWEB;
                    case 32:
                        return UMP_TESTING_ONLY;
                    case 33:
                        return ISOLATION_PKG_WHITEPAGES_PHONE_NUMBER;
                    case 34:
                        return ISOLATION_PKG_LAMS_PREFERENCES;
                    case 35:
                        return ISOLATION_PKG_CONTENT_INTERESTS;
                    case 36:
                        return ISOLATION_PKG_PEOPLE_API;
                    case 37:
                        return ISOLATION_PKG_ASSISTANT_SETTINGS_FOOTPRINTS;
                    case 38:
                        return ISOLATION_PKG_PWS_ASSISTANT_CONTACTS_FOOTPRINTS;
                    case 39:
                        return ISOLATION_PKG_MAPS_ALIAS_FOOTPRINTS;
                    case 40:
                        return ISOLATION_PKG_HANDBAG_ENTITIES;
                    case 41:
                        return ISOLATION_PKG_HOUSEHOLD;
                    case 42:
                        return ISOLATION_PKG_STRUCTURED_MEMORY_FOOTPRINTS;
                    case 43:
                        return ISOLATION_PKG_DISCOVER_SMART_HOME_DEVICES;
                    case 44:
                        return ISOLATION_PKG_STARLIGHT_BULK_LOOKUP;
                    case 45:
                        return ISOLATION_PKG_STARLIGHT_BULK_LOOKUP_CONSISTENT;
                    case 46:
                        return ISOLATION_PKG_STARLIGHT_FACE_LABELS;
                    case 47:
                        return ISOLATION_PKG_STARLIGHT_TOP_CONTACTS;
                    case 48:
                        return ISOLATION_PKG_TEACH_AND_LEARN_ENTITIES;
                    case 49:
                        return ISOLATION_PKG_ASSISTANT_DEVICE_SETTINGS;
                    case 50:
                        return ISOLATION_PKG_FLIGHT_LEG_RESERVATIONS;
                    case 51:
                        return ISOLATION_PKG_HOTEL_RESERVATIONS;
                    case 52:
                        return ISOLATION_PKG_RESTAURANT_RESERVATIONS;
                    case 53:
                        return ISOLATION_PKG_SOCIAL_EVENT_RESERVATIONS;
                    case 54:
                        return ISOLATION_PKG_DYNAMIC_ENTITIES;
                    case 55:
                        return ISOLATION_PKG_GELLER_ANSWERS;
                    case 56:
                        return ISOLATION_PKG_FOCUS_OWNER_PROFILE;
                    case 57:
                        return ISOLATION_PKG_PARKING_LOCATIONS;
                    case 58:
                        return ISOLATION_PKG_MEDIA_HABITUAL_CACHE;
                    case 59:
                        return ISOLATION_PKG_GAIA;
                    case 60:
                        return ISOLATION_PKG_STARLIGHT_COMPOSITE;
                    case 61:
                        return ISOLATION_PKG_STARLIGHT_COMPOSITE_FACE_LABELS;
                    case 62:
                        return INTENTJOINS_NB_SIGNALS;
                    case 63:
                        return ISOLATION_PKG_CONTACT_AGGREGATED_SIGNALS;
                    case 64:
                        return ADS_INTEGRITY_ANNOTATION;
                    case 65:
                        return ISOLATION_PKG_PLAY_AUDIO_BOOKS;
                    case 66:
                        return ISOLATION_PKG_DEVICE_INSTALLED_APPS;
                    case 67:
                        return SHOPPING_DO_NOT_PUBLISH_TO_TOPIC_SERVER;
                    case 68:
                        return ISOLATION_PKG_PERSONALIZED_PRONUNCIATIONS;
                    case 69:
                        return COVID_MAPS_SENSITIVE;
                    case 70:
                        return KE_TRUST;
                    case 71:
                        return SENSITIVE_ENTITIES_CLASSIFICATION;
                    case 72:
                        return ISOLATION_S3_DATASEARCH;
                    case 73:
                        return PKG_ASSISTANT_CONTACT_AFFINITY_FOOTPRINTS;
                    case 74:
                        return ISOLATION_PKG_YOUTUBE_ASSISTANT_CONTEXT;
                    case 75:
                        return VIRTUALCARE_US;
                    case 76:
                        return ISOLATION_PKG_PERSONAL_PLACES;
                    case 77:
                        return ISOLATION_PKG_STADIA_CONTACTS;
                    case 78:
                        return NETFLIX_AVAILABILITY_MEDIA_ACTION;
                    case 79:
                        return ISOLATION_PKG_YOUTUBE_MUSIC_LOCKER;
                    case 80:
                        return ISOLATION_S3_RECOMEDIA;
                    case 4000:
                        return CONTRACTUAL_AOG_FOOD_ORDERING_DATA;
                    default:
                        switch (i) {
                            case 82:
                                return ISOLATION_PKG_STARLIGHT_VISIBLE_TO_GUESTS;
                            case 83:
                                return ISOLATION_PKG_FORMATTED_ADDRESS;
                            case 84:
                                return ISOLATION_PKG_MAPS_SEARCH_LOCATIONS;
                            case 85:
                                return ISOLATION_PKG_LOCATION_SHARING_CONTACTS;
                            case 86:
                                return ISOLATION_KE_INTERNAL;
                            case 87:
                                return ACCC_RISKY_DATA;
                            case 88:
                                return AU_ACCC_RISKY_FOR_DISPLAY;
                            case 89:
                                return PKG_RESERVATION_DATA;
                            case 90:
                                return AR_ONBOARDING_TEST;
                            case 91:
                                return AR_ONBOARDING_TEST_2;
                            case 92:
                                return CONTRACTUAL_BBC_PROVIDER_METADATA;
                            case 93:
                                return CONTRACTUAL_SPOTIFY_PODCAST_DATA;
                            case 94:
                                return CONTRACTUAL_YETI_DATA;
                            case 95:
                                return DICTIONARY_DATA_OXFORD;
                            case 96:
                                return DICTIONARY_DATA_LE_ROBERT;
                            case 97:
                                return ISOLATION_FINANCIAL_DATA;
                            case 98:
                                return GEO_FEATURE_RESTRICTION;
                            case 99:
                                return ISOLATION_YOUTUBE_OTT;
                            case 100:
                                return CONTRACTUAL_IPG_DATA;
                            case 101:
                                return CONTRACTUAL_YOUVIEW_DATA;
                            case 102:
                                return ISOLATION_YOUTUBE_MUSIC_BASS_ENTITIES;
                            case 103:
                                return ISOLATION_G4C;
                            case 104:
                                return CREATOR_PRESENCE_DATA;
                            case 105:
                                return CONTRACTUAL_CARBON_INDEX_DATA;
                            case 106:
                                return CONTRACTUAL_CARBON_INDEX_APP;
                            default:
                                switch (i) {
                                    case 999:
                                        return ACCESS_REQUIREMENT_OUT_OF_RANGE;
                                    case 1000:
                                        return CONTRACTUAL_OPTA_DATA_MIGRATION;
                                    case 1001:
                                        return CONTRACTUAL_STATS_DATA_MIGRATION;
                                    case PointerIconCompat.TYPE_HAND /* 1002 */:
                                        return TECHNICAL_DEBT_SIRIUS_MIGRATION;
                                    case PointerIconCompat.TYPE_HELP /* 1003 */:
                                        return TECHNICAL_IN_DEVELOPMENT_GEO_KG_UGC;
                                    default:
                                        switch (i) {
                                            case 2000:
                                                return MOMA_RESTRICTED_TVC;
                                            case 2001:
                                                return MOMA_UNRESTRICTED_TVC;
                                            case 2002:
                                                return MOMA_FTE;
                                            case 2003:
                                                return AOG_TEST_DATA;
                                            default:
                                                switch (i) {
                                                    case 3001:
                                                        return CONTRACTUAL_NETFLIX_DATA;
                                                    case 3002:
                                                        return TECHNICAL_UNRECONCILED_MEDIA_ACTION;
                                                    case 3003:
                                                        return CONTRACTUAL_AUDIBLE_DATA;
                                                    case 3004:
                                                        return CONTRACTUAL_SEARCH_NETFLIX_DATA;
                                                    case 3005:
                                                        return CONTRACTUAL_ASSISTANT_MEDIA_ACTIONS;
                                                    case 3006:
                                                        return CONTRACTUAL_ANDROID_TV_NETFLIX_DATA;
                                                    case 3007:
                                                        return CONTRACTUAL_GOOGLE_PLAY_MOVIES_DATA;
                                                    case 3008:
                                                        return CONTRACTUAL_RANKING_PROVIDER_POPULARITY_DATA;
                                                    case 3009:
                                                        return TRAVEL_ACTIVITY_DATA;
                                                    case 3010:
                                                        return CONTRACTUAL_NETFLIX_GRACENOTE;
                                                    default:
                                                        switch (i) {
                                                            case 10000:
                                                                return ISOLATION_S3_GEO_CARS;
                                                            case 10001:
                                                                return ISOLATION_WEB_CHANNELS;
                                                            case 10002:
                                                                return ISOLATION_ONRAMP_DICTIONARY_EXPERIMENT;
                                                            case 10003:
                                                                return ISOLATION_S3_CREATOR_PRESENCE;
                                                            case 10004:
                                                                return ISOLATION_MEDICAL;
                                                            default:
                                                                switch (i) {
                                                                    case 15001:
                                                                        return ISOLATION_PKG_MEDIA_USER_CONTEXT_INFO;
                                                                    case 15002:
                                                                        return ISOLATION_PKG_APP_NAMES;
                                                                    case 15003:
                                                                        return ISOLATION_PKG_STARLIGHT_BULK_LOOKUP_CONSISTENT_CONTACTS;
                                                                    case 15004:
                                                                        return ISOLATION_PKG_MEDIA_LIBRARY;
                                                                    case 15005:
                                                                        return ISOLATION_PKG_CALENDAR_EVENTS_FOR_SPEECH_BIASING;
                                                                    case 15006:
                                                                        return ISOLATION_PKG_CALENDAR_EVENTS_FOR_QUERY_ANNOTATION;
                                                                    case 15007:
                                                                        return ISOLATION_PKG_MEDIA_USER_ENTITIES;
                                                                    case 15008:
                                                                        return ISOLATION_PKG_HERON_INTENTS_AND_TYPES;
                                                                    case 15009:
                                                                        return ISOLATION_PKG_GMAIL_BILLS;
                                                                    case 15010:
                                                                        return ISOLATION_PKG_GMAIL_ORDERS;
                                                                    case 15011:
                                                                        return ISOLATION_PKG_ASSISTANT_CONTACT_AFFINITY_WITH_METADATA;
                                                                    case 15012:
                                                                        return ISOLATION_PKG_SOCIAL_GRAPH_PEOPLE_API;
                                                                    case 15013:
                                                                        return ISOLATION_PKG_VANITY_COLLECTIONS;
                                                                    case 15014:
                                                                        return ISOLATION_PKG_YOUTUBE_ASSISTANT_XWALKSAFE_CONTEXT;
                                                                    case 15015:
                                                                        return ISOLATION_PKG_HABITS;
                                                                    case 15016:
                                                                        return ISOLATION_PKG_STARLIGHT_QUERY;
                                                                    case 15017:
                                                                        return ISOLATION_PKG_YOUTUBE_PLAYLISTS;
                                                                    case 15018:
                                                                        return ISOLATION_PKG_YOUTUBE_PRIVATE_PLAYLISTS;
                                                                    case 15019:
                                                                        return ISOLATION_PKG_PERSONAL_CONTACT_ANNOTATIONS;
                                                                    case 15020:
                                                                        return ISOLATION_PKG_SELF_ENTITIES;
                                                                    case 15021:
                                                                        return ISOLATION_PKG_CALENDARS_FOR_QUERY_ANNOTATION;
                                                                    case 15022:
                                                                        return ISOLATION_PKG_CALENDARS_FOR_SPEECH_BIASING;
                                                                    case 15023:
                                                                        return ISOLATION_PKG_PEOPLE_API_CONTACT_ANNOTATIONS;
                                                                    case 15024:
                                                                        return ISOLATION_PKG_PERSONAL_SHARED_CONTACT_ANNOTATIONS;
                                                                    case 15025:
                                                                        return ISOLATION_PKG_YOUTUBE_PUBLIC_AND_PRIVATE_PLAYLISTS;
                                                                    case 15026:
                                                                        return ISOLATION_PKG_ASSISTANT_SETTINGS_NICKNAME;
                                                                    case 15027:
                                                                        return ISOLATION_PKG_WEBSEARCH;
                                                                    case 15028:
                                                                        return ISOLATION_PKG_YOUTUBE_PLAYLIST_SEARCH;
                                                                    case 15029:
                                                                        return ISOLATION_PKG_GI_HOTEL_RESERVATION_DATA;
                                                                    case 15030:
                                                                        return ISOLATION_PKG_GI_FLIGHT_RESERVATION_DATA;
                                                                    case 15031:
                                                                        return ISOLATION_PKG_GI_CAR_RENTAL_RESERVATION_DATA;
                                                                    case 15032:
                                                                        return ISOLATION_PKG_GI_TRANSPORTATION_RESERVATION_DATA;
                                                                    case 15033:
                                                                        return ISOLATION_PKG_GI_RESTAURANT_RESERVATION_DATA;
                                                                    case 15034:
                                                                        return ISOLATION_PKG_ANDROID_AUTO_EMBEDDED_SIGNED_IN;
                                                                    case 15035:
                                                                        return ISOLATION_PKG_ANDROID_AUTO_EMBEDDED_SIGNED_OUT;
                                                                    case 15036:
                                                                        return ISOLATION_PKG_VOICE_PROFILE;
                                                                    case 15037:
                                                                        return ISOLATION_PKG_PEOPLE_API_GET_PEOPLE_BY_IDS;
                                                                    case 15038:
                                                                        return ISOLATION_PKG_ASSISTANT_ROUTINES;
                                                                    case 15039:
                                                                        return ISOLATION_PKG_ASSISTANT_LIST_NAMES_FOR_SPEECH_BIASING;
                                                                    case 15040:
                                                                        return ISOLATION_PKG_LOCAL_LEAF_PAGE_VIEW_LOCATIONS;
                                                                    case 15041:
                                                                        return ISOLATION_PKG_ASSISTANT_UPP_PERSONAL_TOP_ENTITIES;
                                                                    default:
                                                                        switch (i) {
                                                                            case 20101:
                                                                                return RIGHTS_MANAGEMENT_100;
                                                                            case 20102:
                                                                                return RIGHTS_MANAGEMENT_101;
                                                                            case 20103:
                                                                                return RIGHTS_MANAGEMENT_102;
                                                                            default:
                                                                                return null;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzcv);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzcv;
    }
}
