package com.google.android.gms.internal.gtm;

import androidx.core.view.PointerIconCompat;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzarl implements zzbfh {
    SIGNAL_UNKNOWN(0),
    SIGNAL_LENGTH(1001),
    SIGNAL_AREA(PointerIconCompat.TYPE_HAND),
    SIGNAL_ADDRESS(PointerIconCompat.TYPE_HELP),
    SIGNAL_LISTING(PointerIconCompat.TYPE_WAIT),
    SIGNAL_ROAD_PRIORITY(WebSocketProtocol.CLOSE_NO_STATUS_CODE),
    SIGNAL_POI_COUNT(PointerIconCompat.TYPE_CELL),
    SIGNAL_WEBSCORE(PointerIconCompat.TYPE_CROSSHAIR),
    SIGNAL_PATHRADIUS_LENGTH_METERS(PointerIconCompat.TYPE_TEXT),
    SIGNAL_PATHRADIUS_LENGTH_SEGMENTS(PointerIconCompat.TYPE_VERTICAL_TEXT),
    SIGNAL_PATHRADIUS_POPULARITY(PointerIconCompat.TYPE_ALIAS),
    SIGNAL_PEAK_ELEVATION_PROMINENCE(PointerIconCompat.TYPE_COPY),
    SIGNAL_ROAD_SEGMENT_COUNT(PointerIconCompat.TYPE_NO_DROP),
    SIGNAL_POI_SCORE(PointerIconCompat.TYPE_ALL_SCROLL),
    SIGNAL_ATTRACTIONS_SCORE(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW),
    SIGNAL_HAND_RANKED_LOCALITY_PROMINENCE(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW),
    SIGNAL_POPULATION(1),
    SIGNAL_GDP(2),
    SIGNAL_EUROPA_CLASS(2000),
    SIGNAL_RMF_SOURCE_RANK(2100),
    SIGNAL_MDS_SOURCE_RANK(2200),
    SIGNAL_MULTINET_SOURCE_RANK(2300),
    SIGNAL_LOCALXML_MANUAL_RANK(2400),
    SIGNAL_TRANSIT_LINE(2500),
    SIGNAL_TRANSIT_TRAIN_DEPARTURE_COUNT(2501),
    SIGNAL_TRANSIT_METRO_DEPARTURE_COUNT(2502),
    SIGNAL_TRANSIT_BUS_DEPARTURE_COUNT(2503),
    SIGNAL_TRANSIT_OTHER_DEPARTURE_COUNT(2504),
    SIGNAL_TRANSIT_TRAIN_LINE_COUNT(2510),
    SIGNAL_TRANSIT_METRO_LINE_COUNT(2511),
    SIGNAL_TRANSIT_BUS_LINE_COUNT(2512),
    SIGNAL_TRANSIT_OTHER_LINE_COUNT(2513),
    SIGNAL_TRANSIT_STATION_LOCAL_RANK(2514),
    SIGNAL_TRANSIT_STATION_GLOBAL_RANK(2515),
    SIGNAL_ORION_LEVEL(2600),
    SIGNAL_GEOCENTRE_ADDRESS_RANK(2700),
    SIGNAL_GOOGLE_3DWAREHOUSE_RANK(2800),
    SIGNAL_SKENERGY_CATEGORY(2900),
    SIGNAL_GOOGLE_GEOWIKI_USER_RANK(3000),
    SIGNAL_WIKIPEDIA_ARTICLES(3100),
    SIGNAL_WIKIPEDIA_ARTICLES_IN_OFFICIAL_LANGUAGE(3101),
    SIGNAL_KML_PLACEMARKS(3102),
    SIGNAL_KML_SOURCES(3103),
    SIGNAL_PANORAMIO_USERS(3104),
    SIGNAL_GOOGLE_MAPSHOP_USERS(3105),
    SIGNAL_GOOGLE_LOCALSEARCH_DIRECTORY_INFOS(3106),
    SIGNAL_GOOGLE_MAPS_NAVBOOST_CLICKS(3107),
    SIGNAL_GOOGLE_MAPS_NAVBOOST_CLICKTHROUGH_RATE(3108),
    SIGNAL_GOOGLE_RBL_CLICKS(3109),
    SIGNAL_GOOGLE_RBL_CLICK_FRACTION(3110),
    SIGNAL_GOOGLE_AUTHORITYPAGE_PAGERANK(3111),
    SIGNAL_GOOGLE_AUTHORITYPAGE_PAGERANK_CONFIDENCE(3112),
    SIGNAL_GOOGLE_REVIEWS(3113),
    SIGNAL_GOOGLE_WEB_QUERYVOL(3114),
    SIGNAL_GOOGLE_WEBPAGE_REFERENCE_DOMAINS(3115),
    SIGNAL_GOOGLE_LISTING_IMPRESSIONS(3116),
    SIGNAL_GOOGLE_INFOWINDOW_VIEWS(3117),
    SIGNAL_GOOGLE_DIRECTION_REQUESTS(3118),
    SIGNAL_GOOGLE_HOMEPAGE_CLICKS(3119),
    SIGNAL_GOOGLE_CHAIN_STORES(3120),
    SIGNAL_FLICKR_USERS(3122),
    SIGNAL_GOOGLE_LEANBACK_TOURS(3123),
    SIGNAL_GOOGLE_LOCALSEARCH_PLACERANK(3200),
    SIGNAL_WIKIPEDIA_WIKI_SCORE(3300),
    SIGNAL_ZENRIN_CITY_CATEGORY(3400),
    SIGNAL_ZENRIN_BUILDING_CLASS(3401),
    SIGNAL_ZENRIN_PEAK_CLASS(3402),
    SIGNAL_PLACE_INSIGHTS_LANDMARK(3500),
    SIGNAL_PLACE_INSIGHTS_POPULARITY(3501),
    SIGNAL_PLACE_INSIGHTS_PROMINENCE(3502),
    SIGNAL_PLACE_INSIGHTS_APPROACHABILITY(3503),
    SIGNAL_PLACE_INSIGHTS_TOTAL_ROAD_SEGMENT_USAGE(3504);

    private static final zzbfi zzau = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzarj
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzarl.zzb(i);
        }
    };
    private final int zzaw;

    zzarl(int i) {
        this.zzaw = i;
    }

    public static zzarl zzb(int i) {
        if (i == 0) {
            return SIGNAL_UNKNOWN;
        }
        if (i == 1) {
            return SIGNAL_POPULATION;
        }
        if (i == 2) {
            return SIGNAL_GDP;
        }
        if (i == 3122) {
            return SIGNAL_FLICKR_USERS;
        }
        if (i == 3123) {
            return SIGNAL_GOOGLE_LEANBACK_TOURS;
        }
        switch (i) {
            case 1001:
                return SIGNAL_LENGTH;
            case PointerIconCompat.TYPE_HAND /* 1002 */:
                return SIGNAL_AREA;
            case PointerIconCompat.TYPE_HELP /* 1003 */:
                return SIGNAL_ADDRESS;
            case PointerIconCompat.TYPE_WAIT /* 1004 */:
                return SIGNAL_LISTING;
            case WebSocketProtocol.CLOSE_NO_STATUS_CODE /* 1005 */:
                return SIGNAL_ROAD_PRIORITY;
            case PointerIconCompat.TYPE_CELL /* 1006 */:
                return SIGNAL_POI_COUNT;
            case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                return SIGNAL_WEBSCORE;
            case PointerIconCompat.TYPE_TEXT /* 1008 */:
                return SIGNAL_PATHRADIUS_LENGTH_METERS;
            case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                return SIGNAL_PATHRADIUS_LENGTH_SEGMENTS;
            case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                return SIGNAL_PATHRADIUS_POPULARITY;
            case PointerIconCompat.TYPE_COPY /* 1011 */:
                return SIGNAL_PEAK_ELEVATION_PROMINENCE;
            case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                return SIGNAL_ROAD_SEGMENT_COUNT;
            case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
                return SIGNAL_POI_SCORE;
            case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                return SIGNAL_ATTRACTIONS_SCORE;
            case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                return SIGNAL_HAND_RANKED_LOCALITY_PROMINENCE;
            default:
                switch (i) {
                    case 2000:
                        return SIGNAL_EUROPA_CLASS;
                    case 2100:
                        return SIGNAL_RMF_SOURCE_RANK;
                    case 2200:
                        return SIGNAL_MDS_SOURCE_RANK;
                    case 2300:
                        return SIGNAL_MULTINET_SOURCE_RANK;
                    case 2400:
                        return SIGNAL_LOCALXML_MANUAL_RANK;
                    case 2600:
                        return SIGNAL_ORION_LEVEL;
                    case 2700:
                        return SIGNAL_GEOCENTRE_ADDRESS_RANK;
                    case 2800:
                        return SIGNAL_GOOGLE_3DWAREHOUSE_RANK;
                    case 2900:
                        return SIGNAL_SKENERGY_CATEGORY;
                    case 3000:
                        return SIGNAL_GOOGLE_GEOWIKI_USER_RANK;
                    case 3200:
                        return SIGNAL_GOOGLE_LOCALSEARCH_PLACERANK;
                    case 3300:
                        return SIGNAL_WIKIPEDIA_WIKI_SCORE;
                    default:
                        switch (i) {
                            case 2500:
                                return SIGNAL_TRANSIT_LINE;
                            case 2501:
                                return SIGNAL_TRANSIT_TRAIN_DEPARTURE_COUNT;
                            case 2502:
                                return SIGNAL_TRANSIT_METRO_DEPARTURE_COUNT;
                            case 2503:
                                return SIGNAL_TRANSIT_BUS_DEPARTURE_COUNT;
                            case 2504:
                                return SIGNAL_TRANSIT_OTHER_DEPARTURE_COUNT;
                            default:
                                switch (i) {
                                    case 2510:
                                        return SIGNAL_TRANSIT_TRAIN_LINE_COUNT;
                                    case 2511:
                                        return SIGNAL_TRANSIT_METRO_LINE_COUNT;
                                    case 2512:
                                        return SIGNAL_TRANSIT_BUS_LINE_COUNT;
                                    case 2513:
                                        return SIGNAL_TRANSIT_OTHER_LINE_COUNT;
                                    case 2514:
                                        return SIGNAL_TRANSIT_STATION_LOCAL_RANK;
                                    case 2515:
                                        return SIGNAL_TRANSIT_STATION_GLOBAL_RANK;
                                    default:
                                        switch (i) {
                                            case 3100:
                                                return SIGNAL_WIKIPEDIA_ARTICLES;
                                            case 3101:
                                                return SIGNAL_WIKIPEDIA_ARTICLES_IN_OFFICIAL_LANGUAGE;
                                            case 3102:
                                                return SIGNAL_KML_PLACEMARKS;
                                            case 3103:
                                                return SIGNAL_KML_SOURCES;
                                            case 3104:
                                                return SIGNAL_PANORAMIO_USERS;
                                            case 3105:
                                                return SIGNAL_GOOGLE_MAPSHOP_USERS;
                                            case 3106:
                                                return SIGNAL_GOOGLE_LOCALSEARCH_DIRECTORY_INFOS;
                                            case 3107:
                                                return SIGNAL_GOOGLE_MAPS_NAVBOOST_CLICKS;
                                            case 3108:
                                                return SIGNAL_GOOGLE_MAPS_NAVBOOST_CLICKTHROUGH_RATE;
                                            case 3109:
                                                return SIGNAL_GOOGLE_RBL_CLICKS;
                                            case 3110:
                                                return SIGNAL_GOOGLE_RBL_CLICK_FRACTION;
                                            case 3111:
                                                return SIGNAL_GOOGLE_AUTHORITYPAGE_PAGERANK;
                                            case 3112:
                                                return SIGNAL_GOOGLE_AUTHORITYPAGE_PAGERANK_CONFIDENCE;
                                            case 3113:
                                                return SIGNAL_GOOGLE_REVIEWS;
                                            case 3114:
                                                return SIGNAL_GOOGLE_WEB_QUERYVOL;
                                            case 3115:
                                                return SIGNAL_GOOGLE_WEBPAGE_REFERENCE_DOMAINS;
                                            case 3116:
                                                return SIGNAL_GOOGLE_LISTING_IMPRESSIONS;
                                            case 3117:
                                                return SIGNAL_GOOGLE_INFOWINDOW_VIEWS;
                                            case 3118:
                                                return SIGNAL_GOOGLE_DIRECTION_REQUESTS;
                                            case 3119:
                                                return SIGNAL_GOOGLE_HOMEPAGE_CLICKS;
                                            case 3120:
                                                return SIGNAL_GOOGLE_CHAIN_STORES;
                                            default:
                                                switch (i) {
                                                    case 3400:
                                                        return SIGNAL_ZENRIN_CITY_CATEGORY;
                                                    case 3401:
                                                        return SIGNAL_ZENRIN_BUILDING_CLASS;
                                                    case 3402:
                                                        return SIGNAL_ZENRIN_PEAK_CLASS;
                                                    default:
                                                        switch (i) {
                                                            case 3500:
                                                                return SIGNAL_PLACE_INSIGHTS_LANDMARK;
                                                            case 3501:
                                                                return SIGNAL_PLACE_INSIGHTS_POPULARITY;
                                                            case 3502:
                                                                return SIGNAL_PLACE_INSIGHTS_PROMINENCE;
                                                            case 3503:
                                                                return SIGNAL_PLACE_INSIGHTS_APPROACHABILITY;
                                                            case 3504:
                                                                return SIGNAL_PLACE_INSIGHTS_TOTAL_ROAD_SEGMENT_USAGE;
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

    public static zzbfj zzc() {
        return zzark.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzaw);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzaw;
    }
}
