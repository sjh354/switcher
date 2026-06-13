package com.google.android.gms.internal.gtm;

import com.afollestad.materialdialogs.BuildConfig;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzamm implements zzbfh {
    TYPE_ANY(0),
    TYPE_TRANSPORTATION(1),
    TYPE_ROUTE(17),
    TYPE_DEPRECATED_HIGHWAY_DO_NOT_USE(273),
    TYPE_HIGHWAY(274),
    TYPE_HIGHWAY_1(4385),
    TYPE_HIGHWAY_2(4386),
    TYPE_HIGHWAY_3(4387),
    TYPE_HIGHWAY_4(4388),
    TYPE_HIGHWAY_5(4389),
    TYPE_HIGHWAY_6(4390),
    TYPE_HIGHWAY_7(4391),
    TYPE_HIGHWAY_8(4392),
    TYPE_HIGHWAY_9(4393),
    TYPE_BICYCLE_ROUTE(276),
    TYPE_TRAIL(277),
    TYPE_SEGMENT(18),
    TYPE_ROAD(289),
    TYPE_RAILWAY(291),
    TYPE_STANDARD_TRACK(4657),
    TYPE_JR_TRACK(74513),
    TYPE_NARROW_TRACK(4658),
    TYPE_MONORAIL_TRACK(4659),
    TYPE_SUBWAY_TRACK(4660),
    TYPE_LIGHT_RAIL_TRACK(4661),
    TYPE_BROAD_TRACK(4662),
    TYPE_HIGH_SPEED_RAIL(4663),
    TYPE_TROLLEY_TRACK(4664),
    TYPE_FERRY(292),
    TYPE_FERRY_BOAT(4673),
    TYPE_FERRY_TRAIN(4674),
    TYPE_VIRTUAL_SEGMENT(293),
    TYPE_INTERSECTION(19),
    TYPE_TRANSIT(20),
    TYPE_TRANSIT_STATION(321),
    TYPE_BUS_STATION(5137),
    TYPE_TRAMWAY_STATION(5138),
    TYPE_TRAIN_STATION(5139),
    TYPE_SUBWAY_STATION(5140),
    TYPE_FERRY_TERMINAL(5141),
    TYPE_AIRPORT(5142),
    TYPE_AIRPORT_CIVIL(82273),
    TYPE_AIRPORT_MILITARY(82274),
    TYPE_AIRPORT_MIXED(82275),
    TYPE_HELIPORT(82276),
    TYPE_SEAPLANE_BASE(82277),
    TYPE_AIRSTRIP(82278),
    TYPE_CABLE_CAR_STATION(5143),
    TYPE_GONDOLA_LIFT_STATION(5144),
    TYPE_FUNICULAR_STATION(5145),
    TYPE_SPECIAL_STATION(5146),
    TYPE_HORSE_CARRIAGE_STATION(82337),
    TYPE_MONORAIL_STATION(5147),
    TYPE_SEAPORT(5148),
    TYPE_TRANSIT_STOP(322),
    TYPE_TRANSIT_TRIP(323),
    TYPE_TRANSIT_DEPARTURE(324),
    TYPE_TRANSIT_LEG(325),
    TYPE_TRANSIT_LINE(326),
    TYPE_TRANSIT_AGENCY_DEPRECATED_VALUE(327),
    TYPE_TRANSIT_TRANSFER(328),
    TYPE_SEGMENT_PATH(21),
    TYPE_ROAD_SIGN(337),
    TYPE_INTERSECTION_GROUP(22),
    TYPE_PATHWAY(23),
    TYPE_RESTRICTION_GROUP(24),
    TYPE_TOLL_CLUSTER(25),
    TYPE_POLITICAL(2),
    TYPE_COUNTRY(33),
    TYPE_ADMINISTRATIVE_AREA(34),
    TYPE_ADMINISTRATIVE_AREA1(545),
    TYPE_US_STATE(8721),
    TYPE_GB_COUNTRY(8723),
    TYPE_JP_TODOUFUKEN(8724),
    TYPE_ADMINISTRATIVE_AREA2(546),
    TYPE_GB_FORMER_POSTAL_COUNTY(8739),
    TYPE_GB_TRADITIONAL_COUNTY(8740),
    TYPE_ADMINISTRATIVE_AREA3(547),
    TYPE_ADMINISTRATIVE_AREA4(548),
    TYPE_ADMINISTRATIVE_AREA5(549),
    TYPE_ADMINISTRATIVE_AREA6(550),
    TYPE_ADMINISTRATIVE_AREA7(551),
    TYPE_ADMINISTRATIVE_AREA8(552),
    TYPE_ADMINISTRATIVE_AREA9(553),
    TYPE_COLLOQUIAL_AREA(35),
    TYPE_RESERVATION(36),
    TYPE_LOCALITY(37),
    TYPE_GB_POST_TOWN(593),
    TYPE_JP_GUN(594),
    TYPE_JP_SHIKUCHOUSON(595),
    TYPE_JP_SUB_SHIKUCHOUSON(596),
    TYPE_COLLOQUIAL_CITY(597),
    TYPE_SUBLOCALITY(38),
    TYPE_US_BOROUGH(609),
    TYPE_GB_DEPENDENT_LOCALITY(610),
    TYPE_JP_OOAZA(614),
    TYPE_JP_KOAZA(615),
    TYPE_JP_GAIKU(616),
    TYPE_GB_DOUBLE_DEPENDENT_LOCALITY(617),
    TYPE_JP_CHIBAN(618),
    TYPE_JP_EDABAN(620),
    TYPE_SUBLOCALITY1(9937),
    TYPE_SUBLOCALITY2(9938),
    TYPE_SUBLOCALITY3(9939),
    TYPE_SUBLOCALITY4(9940),
    TYPE_SUBLOCALITY5(9941),
    TYPE_NEIGHBORHOOD(39),
    TYPE_CONSTITUENCY(40),
    TYPE_DESIGNATED_MARKET_AREA(41),
    TYPE_SCHOOL_DISTRICT(42),
    TYPE_LAND_PARCEL(43),
    TYPE_DISPUTED_AREA(44),
    TYPE_POLICE_JURISDICTION(45),
    TYPE_STATISTICAL_AREA(11793),
    TYPE_CONSTITUENCY_FUTURE(738),
    TYPE_PARK(3),
    TYPE_GOLF_COURSE(49),
    TYPE_LOCAL_PARK(50),
    TYPE_NATIONAL_PARK(51),
    TYPE_US_NATIONAL_PARK(817),
    TYPE_US_NATIONAL_MONUMENT(818),
    TYPE_NATIONAL_FOREST(819),
    TYPE_PROVINCIAL_PARK(52),
    TYPE_PROVINCIAL_FOREST(833),
    TYPE_CAMPGROUNDS(53),
    TYPE_HIKING_AREA(54),
    TYPE_BUSINESS(4),
    TYPE_GOVERNMENT(1041),
    TYPE_BORDER_CROSSING(16657),
    TYPE_CITY_HALL(16658),
    TYPE_COURTHOUSE(16659),
    TYPE_EMBASSY(16660),
    TYPE_LIBRARY(16661),
    TYPE_SCHOOL(1042),
    TYPE_UNIVERSITY(16673),
    TYPE_EMERGENCY(1043),
    TYPE_HOSPITAL(16689),
    TYPE_PHARMACY(16690),
    TYPE_POLICE(16691),
    TYPE_FIRE(16692),
    TYPE_DOCTOR(16693),
    TYPE_DENTIST(16694),
    TYPE_VETERINARIAN(16695),
    TYPE_TRAVEL_SERVICE(1044),
    TYPE_LODGING(16705),
    TYPE_RESTAURANT(16706),
    TYPE_GAS_STATION(16707),
    TYPE_PARKING(16708),
    TYPE_POST_OFFICE(16709),
    TYPE_REST_AREA(16710),
    TYPE_CASH_MACHINE(16711),
    TYPE_CAR_RENTAL(16712),
    TYPE_CAR_REPAIR(16713),
    TYPE_SHOPPING(1046),
    TYPE_GROCERY(16737),
    TYPE_TOURIST_DESTINATION(1047),
    TYPE_ECO_TOURIST_DESTINATION(16753),
    TYPE_BIRD_WATCHING(268049),
    TYPE_FISHING(268050),
    TYPE_HUNTING(268051),
    TYPE_NATURE_RESERVE(268052),
    TYPE_TEMPLE(1048),
    TYPE_CHURCH(16769),
    TYPE_GURUDWARA(16770),
    TYPE_HINDU_TEMPLE(16771),
    TYPE_MOSQUE(16772),
    TYPE_SYNAGOGUE(16773),
    TYPE_STADIUM(1049),
    TYPE_BAR(1056),
    TYPE_MOVIE_RENTAL(1058),
    TYPE_COFFEE(1059),
    TYPE_GOLF(1060),
    TYPE_BANK(1061),
    TYPE_DOODLE(5),
    TYPE_GROUNDS(6),
    TYPE_AIRPORT_GROUNDS(97),
    TYPE_BUILDING_GROUNDS(98),
    TYPE_CEMETERY(99),
    TYPE_HOSPITAL_GROUNDS(100),
    TYPE_INDUSTRIAL(101),
    TYPE_MILITARY(102),
    TYPE_SHOPPING_CENTER(103),
    TYPE_SPORTS_COMPLEX(104),
    TYPE_UNIVERSITY_GROUNDS(105),
    TYPE_DEPRECATED_TARMAC(106),
    TYPE_ENCLOSED_TRAFFIC_AREA(108),
    TYPE_PARKING_LOT(1729),
    TYPE_PARKING_GARAGE(1730),
    TYPE_OFF_ROAD_AREA(1731),
    TYPE_BORDER(7),
    TYPE_BUILDING(8),
    TYPE_GEOCODED_ADDRESS(9),
    TYPE_NATURAL_FEATURE(10),
    TYPE_TERRAIN(161),
    TYPE_SAND(2577),
    TYPE_BEACH(41233),
    TYPE_DUNE(41234),
    TYPE_ROCKY(2578),
    TYPE_ICE(2579),
    TYPE_GLACIER(41265),
    TYPE_BUILT_UP_AREA(2580),
    TYPE_VEGETATION(2581),
    TYPE_SHRUBBERY(41297),
    TYPE_WOODS(41298),
    TYPE_AGRICULTURAL(41299),
    TYPE_GRASSLAND(41300),
    TYPE_TUNDRA(2582),
    TYPE_DESERT(2583),
    TYPE_SALT_FLAT(2584),
    TYPE_WATER(162),
    TYPE_OCEAN(2593),
    TYPE_BAY(41489),
    TYPE_BIGHT(663825),
    TYPE_LAGOON(663826),
    TYPE_SEA(41490),
    TYPE_STRAIT(41491),
    TYPE_INLET(41492),
    TYPE_FJORD(663873),
    TYPE_LAKE(2594),
    TYPE_SEASONAL_LAKE(41505),
    TYPE_RESERVOIR(41506),
    TYPE_POND(41507),
    TYPE_RIVER(2595),
    TYPE_RAPIDS(41521),
    TYPE_DISTRIBUTARY(41522),
    TYPE_CONFLUENCE(41523),
    TYPE_WATERFALL(41524),
    TYPE_SPRING(41525),
    TYPE_GEYSER(664401),
    TYPE_HOT_SPRING(664402),
    TYPE_SEASONAL_RIVER(41526),
    TYPE_WADI(41527),
    TYPE_ESTUARY(2596),
    TYPE_WETLAND(2597),
    TYPE_WATER_NAVIGATION(2598),
    TYPE_FORD(41569),
    TYPE_CANAL(41570),
    TYPE_HARBOR(41571),
    TYPE_CHANNEL(41572),
    TYPE_REEF(41573),
    TYPE_REEF_FLAT(665169),
    TYPE_REEF_GROWTH(665170),
    TYPE_REEF_EXTENT(665171),
    TYPE_REEF_ROCK_SUBMERGED(665172),
    TYPE_IRRIGATION(2599),
    TYPE_DAM(2600),
    TYPE_DRINKING_WATER(2601),
    TYPE_CURRENT(2603),
    TYPE_WATERING_HOLE(2604),
    TYPE_TECTONIC(163),
    TYPE_WATERING_HOLE_DEPRECATED(2608),
    TYPE_VOLCANO(2609),
    TYPE_LAVA_FIELD(2610),
    TYPE_FISSURE(2611),
    TYPE_FAULT(2612),
    TYPE_LAND_MASS(164),
    TYPE_CONTINENT(2625),
    TYPE_ISLAND(2626),
    TYPE_ATOLL(42017),
    TYPE_OCEAN_ROCK_EXPOSED(42018),
    TYPE_CAY(42019),
    TYPE_PENINSULA(2627),
    TYPE_ISTHMUS(2628),
    TYPE_ELEVATED(165),
    TYPE_PEAK(2641),
    TYPE_NUNATAK(42257),
    TYPE_SPUR(42258),
    TYPE_PASS(2642),
    TYPE_PLATEAU(2643),
    TYPE_RIDGE(2644),
    TYPE_RAVINE(2646),
    TYPE_CRATER(2647),
    TYPE_KARST(42353),
    TYPE_CLIFF(2648),
    TYPE_VISTA(2649),
    TYPE_DIGITAL_ELEVATION_MODEL(2650),
    TYPE_UPLAND(2651),
    TYPE_TERRACE(2652),
    TYPE_SLOPE(2653),
    TYPE_CONTOUR_LINE(2654),
    TYPE_PAN(42481),
    TYPE_UNSTABLE_HILLSIDE(42482),
    TYPE_MOUNTAIN_RANGE(42483),
    TYPE_UNDERSEA(166),
    TYPE_SUBMARINE_SEAMOUNT(2657),
    TYPE_SUBMARINE_RIDGE(2658),
    TYPE_SUBMARINE_GAP(42529),
    TYPE_SUBMARINE_PLATEAU(2659),
    TYPE_SUBMARINE_DEEP(2660),
    TYPE_SUBMARINE_VALLEY(2661),
    TYPE_SUBMARINE_BASIN(2662),
    TYPE_SUBMARINE_SLOPE(2663),
    TYPE_SUBMARINE_CLIFF(42609),
    TYPE_SUBMARINE_PLAIN(2664),
    TYPE_SUBMARINE_FRACTURE_ZONE(2665),
    TYPE_CAVE(42753),
    TYPE_ROCK(42754),
    TYPE_ARCHIPELAGO(42755),
    TYPE_POSTAL(11),
    TYPE_POSTAL_CODE(177),
    TYPE_POSTAL_CODE_PREFIX(2833),
    TYPE_PREMISE(BuildConfig.VERSION_CODE),
    TYPE_SUB_PREMISE(180),
    TYPE_SUITE(2881),
    TYPE_POST_TOWN(182),
    TYPE_POSTAL_ROUND(183),
    TYPE_META_FEATURE(12),
    TYPE_DATA_SOURCE(3089),
    TYPE_LOCALE(194),
    TYPE_TIMEZONE(195),
    TYPE_BUSINESS_CHAIN(196),
    TYPE_PHONE_NUMBER_PREFIX(198),
    TYPE_PHONE_NUMBER_AREA_CODE(3169),
    TYPE_BUSINESS_CORRIDOR(199),
    TYPE_ADDRESS_TEMPLATE(200),
    TYPE_TRANSIT_AGENCY(3217),
    TYPE_FUTURE_GEOMETRY(202),
    TYPE_EVENT(208),
    TYPE_EARTHQUAKE(3329),
    TYPE_HURRICANE(3330),
    TYPE_WEATHER_CONDITION(3331),
    TYPE_TRANSIENT(209),
    TYPE_ENTRANCE(210),
    TYPE_CARTOGRAPHIC(211),
    TYPE_HIGH_TENSION(3377),
    TYPE_SKI_TRAIL(3378),
    TYPE_SKI_LIFT(3379),
    TYPE_SKI_BOUNDARY(3380),
    TYPE_WATERSHED_BOUNDARY(3381),
    TYPE_TARMAC(865809),
    TYPE_WALL(865810),
    TYPE_PICNIC_AREA(865811),
    TYPE_PLAY_GROUND(865812),
    TYPE_TRAIL_HEAD(865813),
    TYPE_GOLF_TEEING_GROUND(865814),
    TYPE_GOLF_PUTTING_GREEN(865815),
    TYPE_GOLF_ROUGH(865816),
    TYPE_GOLF_SAND_BUNKER(865817),
    TYPE_GOLF_FAIRWAY(865818),
    TYPE_GOLF_HOLE(865819),
    TYPE_DEPRECATED_GOLF_SHOP(865820),
    TYPE_CAMPING_SITE(865821),
    TYPE_DESIGNATED_BARBECUE_PIT(865822),
    TYPE_DESIGNATED_COOKING_AREA(865823),
    TYPE_CAMPFIRE_PIT(865824),
    TYPE_WATER_FOUNTAIN(865825),
    TYPE_LITTER_RECEPTACLE(865826),
    TYPE_LOCKER_AREA(865827),
    TYPE_ANIMAL_ENCLOSURE(865828),
    TYPE_CARTOGRAPHIC_LINE(865829),
    TYPE_ESTABLISHMENT(212),
    TYPE_ESTABLISHMENT_GROUNDS(3393),
    TYPE_ESTABLISHMENT_BUILDING(3394),
    TYPE_ESTABLISHMENT_POI(3395),
    TYPE_ESTABLISHMENT_SERVICE(54337),
    TYPE_CELESTIAL(213),
    TYPE_ROAD_MONITOR(214),
    TYPE_PUBLIC_SPACES_AND_MONUMENTS(215),
    TYPE_STATUE(3441),
    TYPE_TOWN_SQUARE(3442),
    TYPE_LEVEL(216),
    TYPE_COMPOUND(217),
    TYPE_COMPOUND_GROUNDS(3473),
    TYPE_COMPOUND_BUILDING(3474),
    TYPE_COMPOUND_SECTION(3475),
    TYPE_TERMINAL_POINT(218),
    TYPE_REGULATED_AREA(219),
    TYPE_LOGICAL_BORDER(220),
    TYPE_DO_NOT_USE_RESERVED_TO_CATCH_GENERATED_FILES(254),
    TYPE_UNKNOWN(255);

    private static final zzbfi zzgg = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzamk
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzamm.zzb(i);
        }
    };
    private final int zzgi;

    zzamm(int i) {
        this.zzgi = i;
    }

    public static zzamm zzb(int i) {
        if (i == 0) {
            return TYPE_ANY;
        }
        if (i == 1) {
            return TYPE_TRANSPORTATION;
        }
        if (i == 2) {
            return TYPE_POLITICAL;
        }
        if (i == 3) {
            return TYPE_PARK;
        }
        if (i == 4) {
            return TYPE_BUSINESS;
        }
        if (i == 5) {
            return TYPE_DOODLE;
        }
        if (i == 6) {
            return TYPE_GROUNDS;
        }
        if (i != 7) {
            if (i == 179) {
                return TYPE_PREMISE;
            }
            if (i == 180) {
                return TYPE_SUB_PREMISE;
            }
            if (i == 182) {
                return TYPE_POST_TOWN;
            }
            if (i == 183) {
                return TYPE_POSTAL_ROUND;
            }
            switch (i) {
                case 7:
                    break;
                case 8:
                    return TYPE_BUILDING;
                case 9:
                    return TYPE_GEOCODED_ADDRESS;
                case 10:
                    return TYPE_NATURAL_FEATURE;
                case 11:
                    return TYPE_POSTAL;
                case 12:
                    return TYPE_META_FEATURE;
                case 108:
                    return TYPE_ENCLOSED_TRAFFIC_AREA;
                case 177:
                    return TYPE_POSTAL_CODE;
                case 202:
                    return TYPE_FUTURE_GEOMETRY;
                case 208:
                    return TYPE_EVENT;
                case 209:
                    return TYPE_TRANSIENT;
                case 210:
                    return TYPE_ENTRANCE;
                case 211:
                    return TYPE_CARTOGRAPHIC;
                case 212:
                    return TYPE_ESTABLISHMENT;
                case 213:
                    return TYPE_CELESTIAL;
                case 214:
                    return TYPE_ROAD_MONITOR;
                case 215:
                    return TYPE_PUBLIC_SPACES_AND_MONUMENTS;
                case 216:
                    return TYPE_LEVEL;
                case 217:
                    return TYPE_COMPOUND;
                case 218:
                    return TYPE_TERMINAL_POINT;
                case 219:
                    return TYPE_REGULATED_AREA;
                case 220:
                    return TYPE_LOGICAL_BORDER;
                case 254:
                    return TYPE_DO_NOT_USE_RESERVED_TO_CATCH_GENERATED_FILES;
                case 255:
                    return TYPE_UNKNOWN;
                case 273:
                    return TYPE_DEPRECATED_HIGHWAY_DO_NOT_USE;
                case 274:
                    return TYPE_HIGHWAY;
                case 276:
                    return TYPE_BICYCLE_ROUTE;
                case 277:
                    return TYPE_TRAIL;
                case 289:
                    return TYPE_ROAD;
                case 291:
                    return TYPE_RAILWAY;
                case 292:
                    return TYPE_FERRY;
                case 293:
                    return TYPE_VIRTUAL_SEGMENT;
                case 321:
                    return TYPE_TRANSIT_STATION;
                case 322:
                    return TYPE_TRANSIT_STOP;
                case 323:
                    return TYPE_TRANSIT_TRIP;
                case 324:
                    return TYPE_TRANSIT_DEPARTURE;
                case 325:
                    return TYPE_TRANSIT_LEG;
                case 326:
                    return TYPE_TRANSIT_LINE;
                case 327:
                    return TYPE_TRANSIT_AGENCY_DEPRECATED_VALUE;
                case 328:
                    return TYPE_TRANSIT_TRANSFER;
                case 337:
                    return TYPE_ROAD_SIGN;
                case 545:
                    return TYPE_ADMINISTRATIVE_AREA1;
                case 546:
                    return TYPE_ADMINISTRATIVE_AREA2;
                case 547:
                    return TYPE_ADMINISTRATIVE_AREA3;
                case 548:
                    return TYPE_ADMINISTRATIVE_AREA4;
                case 549:
                    return TYPE_ADMINISTRATIVE_AREA5;
                case 550:
                    return TYPE_ADMINISTRATIVE_AREA6;
                case 551:
                    return TYPE_ADMINISTRATIVE_AREA7;
                case 552:
                    return TYPE_ADMINISTRATIVE_AREA8;
                case 553:
                    return TYPE_ADMINISTRATIVE_AREA9;
                case 593:
                    return TYPE_GB_POST_TOWN;
                case 594:
                    return TYPE_JP_GUN;
                case 595:
                    return TYPE_JP_SHIKUCHOUSON;
                case 596:
                    return TYPE_JP_SUB_SHIKUCHOUSON;
                case 597:
                    return TYPE_COLLOQUIAL_CITY;
                case 609:
                    return TYPE_US_BOROUGH;
                case 610:
                    return TYPE_GB_DEPENDENT_LOCALITY;
                case 614:
                    return TYPE_JP_OOAZA;
                case 615:
                    return TYPE_JP_KOAZA;
                case 616:
                    return TYPE_JP_GAIKU;
                case 617:
                    return TYPE_GB_DOUBLE_DEPENDENT_LOCALITY;
                case 618:
                    return TYPE_JP_CHIBAN;
                case 620:
                    return TYPE_JP_EDABAN;
                case 738:
                    return TYPE_CONSTITUENCY_FUTURE;
                case 817:
                    return TYPE_US_NATIONAL_PARK;
                case 818:
                    return TYPE_US_NATIONAL_MONUMENT;
                case 819:
                    return TYPE_NATIONAL_FOREST;
                case 833:
                    return TYPE_PROVINCIAL_FOREST;
                case 1041:
                    return TYPE_GOVERNMENT;
                case 1042:
                    return TYPE_SCHOOL;
                case 1043:
                    return TYPE_EMERGENCY;
                case 1044:
                    return TYPE_TRAVEL_SERVICE;
                case 1046:
                    return TYPE_SHOPPING;
                case 1047:
                    return TYPE_TOURIST_DESTINATION;
                case 1048:
                    return TYPE_TEMPLE;
                case 1049:
                    return TYPE_STADIUM;
                case 1056:
                    return TYPE_BAR;
                case 1058:
                    return TYPE_MOVIE_RENTAL;
                case 1059:
                    return TYPE_COFFEE;
                case 1060:
                    return TYPE_GOLF;
                case 1061:
                    return TYPE_BANK;
                case 1729:
                    return TYPE_PARKING_LOT;
                case 1730:
                    return TYPE_PARKING_GARAGE;
                case 1731:
                    return TYPE_OFF_ROAD_AREA;
                case 2577:
                    return TYPE_SAND;
                case 2578:
                    return TYPE_ROCKY;
                case 2579:
                    return TYPE_ICE;
                case 2580:
                    return TYPE_BUILT_UP_AREA;
                case 2581:
                    return TYPE_VEGETATION;
                case 2582:
                    return TYPE_TUNDRA;
                case 2583:
                    return TYPE_DESERT;
                case 2584:
                    return TYPE_SALT_FLAT;
                case 2593:
                    return TYPE_OCEAN;
                case 2594:
                    return TYPE_LAKE;
                case 2595:
                    return TYPE_RIVER;
                case 2596:
                    return TYPE_ESTUARY;
                case 2597:
                    return TYPE_WETLAND;
                case 2598:
                    return TYPE_WATER_NAVIGATION;
                case 2599:
                    return TYPE_IRRIGATION;
                case 2600:
                    return TYPE_DAM;
                case 2601:
                    return TYPE_DRINKING_WATER;
                case 2603:
                    return TYPE_CURRENT;
                case 2604:
                    return TYPE_WATERING_HOLE;
                case 2608:
                    return TYPE_WATERING_HOLE_DEPRECATED;
                case 2609:
                    return TYPE_VOLCANO;
                case 2610:
                    return TYPE_LAVA_FIELD;
                case 2611:
                    return TYPE_FISSURE;
                case 2612:
                    return TYPE_FAULT;
                case 2625:
                    return TYPE_CONTINENT;
                case 2626:
                    return TYPE_ISLAND;
                case 2627:
                    return TYPE_PENINSULA;
                case 2628:
                    return TYPE_ISTHMUS;
                case 2641:
                    return TYPE_PEAK;
                case 2642:
                    return TYPE_PASS;
                case 2643:
                    return TYPE_PLATEAU;
                case 2644:
                    return TYPE_RIDGE;
                case 2646:
                    return TYPE_RAVINE;
                case 2647:
                    return TYPE_CRATER;
                case 2648:
                    return TYPE_CLIFF;
                case 2649:
                    return TYPE_VISTA;
                case 2650:
                    return TYPE_DIGITAL_ELEVATION_MODEL;
                case 2651:
                    return TYPE_UPLAND;
                case 2652:
                    return TYPE_TERRACE;
                case 2653:
                    return TYPE_SLOPE;
                case 2654:
                    return TYPE_CONTOUR_LINE;
                case 2657:
                    return TYPE_SUBMARINE_SEAMOUNT;
                case 2658:
                    return TYPE_SUBMARINE_RIDGE;
                case 2659:
                    return TYPE_SUBMARINE_PLATEAU;
                case 2660:
                    return TYPE_SUBMARINE_DEEP;
                case 2661:
                    return TYPE_SUBMARINE_VALLEY;
                case 2662:
                    return TYPE_SUBMARINE_BASIN;
                case 2663:
                    return TYPE_SUBMARINE_SLOPE;
                case 2664:
                    return TYPE_SUBMARINE_PLAIN;
                case 2665:
                    return TYPE_SUBMARINE_FRACTURE_ZONE;
                case 2833:
                    return TYPE_POSTAL_CODE_PREFIX;
                case 2881:
                    return TYPE_SUITE;
                case 3089:
                    return TYPE_DATA_SOURCE;
                case 3169:
                    return TYPE_PHONE_NUMBER_AREA_CODE;
                case 3217:
                    return TYPE_TRANSIT_AGENCY;
                case 3329:
                    return TYPE_EARTHQUAKE;
                case 3330:
                    return TYPE_HURRICANE;
                case 3331:
                    return TYPE_WEATHER_CONDITION;
                case 3377:
                    return TYPE_HIGH_TENSION;
                case 3378:
                    return TYPE_SKI_TRAIL;
                case 3379:
                    return TYPE_SKI_LIFT;
                case 3380:
                    return TYPE_SKI_BOUNDARY;
                case 3381:
                    return TYPE_WATERSHED_BOUNDARY;
                case 3393:
                    return TYPE_ESTABLISHMENT_GROUNDS;
                case 3394:
                    return TYPE_ESTABLISHMENT_BUILDING;
                case 3395:
                    return TYPE_ESTABLISHMENT_POI;
                case 3441:
                    return TYPE_STATUE;
                case 3442:
                    return TYPE_TOWN_SQUARE;
                case 3473:
                    return TYPE_COMPOUND_GROUNDS;
                case 3474:
                    return TYPE_COMPOUND_BUILDING;
                case 3475:
                    return TYPE_COMPOUND_SECTION;
                case 4385:
                    return TYPE_HIGHWAY_1;
                case 4386:
                    return TYPE_HIGHWAY_2;
                case 4387:
                    return TYPE_HIGHWAY_3;
                case 4388:
                    return TYPE_HIGHWAY_4;
                case 4389:
                    return TYPE_HIGHWAY_5;
                case 4390:
                    return TYPE_HIGHWAY_6;
                case 4391:
                    return TYPE_HIGHWAY_7;
                case 4392:
                    return TYPE_HIGHWAY_8;
                case 4393:
                    return TYPE_HIGHWAY_9;
                case 4657:
                    return TYPE_STANDARD_TRACK;
                case 4658:
                    return TYPE_NARROW_TRACK;
                case 4659:
                    return TYPE_MONORAIL_TRACK;
                case 4660:
                    return TYPE_SUBWAY_TRACK;
                case 4661:
                    return TYPE_LIGHT_RAIL_TRACK;
                case 4662:
                    return TYPE_BROAD_TRACK;
                case 4663:
                    return TYPE_HIGH_SPEED_RAIL;
                case 4664:
                    return TYPE_TROLLEY_TRACK;
                case 4673:
                    return TYPE_FERRY_BOAT;
                case 4674:
                    return TYPE_FERRY_TRAIN;
                case 5137:
                    return TYPE_BUS_STATION;
                case 5138:
                    return TYPE_TRAMWAY_STATION;
                case 5139:
                    return TYPE_TRAIN_STATION;
                case 5140:
                    return TYPE_SUBWAY_STATION;
                case 5141:
                    return TYPE_FERRY_TERMINAL;
                case 5142:
                    return TYPE_AIRPORT;
                case 5143:
                    return TYPE_CABLE_CAR_STATION;
                case 5144:
                    return TYPE_GONDOLA_LIFT_STATION;
                case 5145:
                    return TYPE_FUNICULAR_STATION;
                case 5146:
                    return TYPE_SPECIAL_STATION;
                case 5147:
                    return TYPE_MONORAIL_STATION;
                case 5148:
                    return TYPE_SEAPORT;
                case 8721:
                    return TYPE_US_STATE;
                case 8723:
                    return TYPE_GB_COUNTRY;
                case 8724:
                    return TYPE_JP_TODOUFUKEN;
                case 8739:
                    return TYPE_GB_FORMER_POSTAL_COUNTY;
                case 8740:
                    return TYPE_GB_TRADITIONAL_COUNTY;
                case 9937:
                    return TYPE_SUBLOCALITY1;
                case 9938:
                    return TYPE_SUBLOCALITY2;
                case 9939:
                    return TYPE_SUBLOCALITY3;
                case 9940:
                    return TYPE_SUBLOCALITY4;
                case 9941:
                    return TYPE_SUBLOCALITY5;
                case 11793:
                    return TYPE_STATISTICAL_AREA;
                case 16657:
                    return TYPE_BORDER_CROSSING;
                case 16658:
                    return TYPE_CITY_HALL;
                case 16659:
                    return TYPE_COURTHOUSE;
                case 16660:
                    return TYPE_EMBASSY;
                case 16661:
                    return TYPE_LIBRARY;
                case 16673:
                    return TYPE_UNIVERSITY;
                case 16689:
                    return TYPE_HOSPITAL;
                case 16690:
                    return TYPE_PHARMACY;
                case 16691:
                    return TYPE_POLICE;
                case 16692:
                    return TYPE_FIRE;
                case 16693:
                    return TYPE_DOCTOR;
                case 16694:
                    return TYPE_DENTIST;
                case 16695:
                    return TYPE_VETERINARIAN;
                case 16705:
                    return TYPE_LODGING;
                case 16706:
                    return TYPE_RESTAURANT;
                case 16707:
                    return TYPE_GAS_STATION;
                case 16708:
                    return TYPE_PARKING;
                case 16709:
                    return TYPE_POST_OFFICE;
                case 16710:
                    return TYPE_REST_AREA;
                case 16711:
                    return TYPE_CASH_MACHINE;
                case 16712:
                    return TYPE_CAR_RENTAL;
                case 16713:
                    return TYPE_CAR_REPAIR;
                case 16737:
                    return TYPE_GROCERY;
                case 16753:
                    return TYPE_ECO_TOURIST_DESTINATION;
                case 16769:
                    return TYPE_CHURCH;
                case 16770:
                    return TYPE_GURUDWARA;
                case 16771:
                    return TYPE_HINDU_TEMPLE;
                case 16772:
                    return TYPE_MOSQUE;
                case 16773:
                    return TYPE_SYNAGOGUE;
                case 41233:
                    return TYPE_BEACH;
                case 41234:
                    return TYPE_DUNE;
                case 41265:
                    return TYPE_GLACIER;
                case 41297:
                    return TYPE_SHRUBBERY;
                case 41298:
                    return TYPE_WOODS;
                case 41299:
                    return TYPE_AGRICULTURAL;
                case 41300:
                    return TYPE_GRASSLAND;
                case 41489:
                    return TYPE_BAY;
                case 41490:
                    return TYPE_SEA;
                case 41491:
                    return TYPE_STRAIT;
                case 41492:
                    return TYPE_INLET;
                case 41505:
                    return TYPE_SEASONAL_LAKE;
                case 41506:
                    return TYPE_RESERVOIR;
                case 41507:
                    return TYPE_POND;
                case 41521:
                    return TYPE_RAPIDS;
                case 41522:
                    return TYPE_DISTRIBUTARY;
                case 41523:
                    return TYPE_CONFLUENCE;
                case 41524:
                    return TYPE_WATERFALL;
                case 41525:
                    return TYPE_SPRING;
                case 41526:
                    return TYPE_SEASONAL_RIVER;
                case 41527:
                    return TYPE_WADI;
                case 41569:
                    return TYPE_FORD;
                case 41570:
                    return TYPE_CANAL;
                case 41571:
                    return TYPE_HARBOR;
                case 41572:
                    return TYPE_CHANNEL;
                case 41573:
                    return TYPE_REEF;
                case 42017:
                    return TYPE_ATOLL;
                case 42018:
                    return TYPE_OCEAN_ROCK_EXPOSED;
                case 42019:
                    return TYPE_CAY;
                case 42257:
                    return TYPE_NUNATAK;
                case 42258:
                    return TYPE_SPUR;
                case 42353:
                    return TYPE_KARST;
                case 42481:
                    return TYPE_PAN;
                case 42482:
                    return TYPE_UNSTABLE_HILLSIDE;
                case 42483:
                    return TYPE_MOUNTAIN_RANGE;
                case 42529:
                    return TYPE_SUBMARINE_GAP;
                case 42609:
                    return TYPE_SUBMARINE_CLIFF;
                case 42753:
                    return TYPE_CAVE;
                case 42754:
                    return TYPE_ROCK;
                case 42755:
                    return TYPE_ARCHIPELAGO;
                case 54337:
                    return TYPE_ESTABLISHMENT_SERVICE;
                case 74513:
                    return TYPE_JR_TRACK;
                case 82273:
                    return TYPE_AIRPORT_CIVIL;
                case 82274:
                    return TYPE_AIRPORT_MILITARY;
                case 82275:
                    return TYPE_AIRPORT_MIXED;
                case 82276:
                    return TYPE_HELIPORT;
                case 82277:
                    return TYPE_SEAPLANE_BASE;
                case 82278:
                    return TYPE_AIRSTRIP;
                case 82337:
                    return TYPE_HORSE_CARRIAGE_STATION;
                case 268049:
                    return TYPE_BIRD_WATCHING;
                case 268050:
                    return TYPE_FISHING;
                case 268051:
                    return TYPE_HUNTING;
                case 268052:
                    return TYPE_NATURE_RESERVE;
                case 663825:
                    return TYPE_BIGHT;
                case 663826:
                    return TYPE_LAGOON;
                case 663873:
                    return TYPE_FJORD;
                case 664401:
                    return TYPE_GEYSER;
                case 664402:
                    return TYPE_HOT_SPRING;
                case 665169:
                    return TYPE_REEF_FLAT;
                case 665170:
                    return TYPE_REEF_GROWTH;
                case 665171:
                    return TYPE_REEF_EXTENT;
                case 665172:
                    return TYPE_REEF_ROCK_SUBMERGED;
                case 865809:
                    return TYPE_TARMAC;
                case 865810:
                    return TYPE_WALL;
                case 865811:
                    return TYPE_PICNIC_AREA;
                case 865812:
                    return TYPE_PLAY_GROUND;
                case 865813:
                    return TYPE_TRAIL_HEAD;
                case 865814:
                    return TYPE_GOLF_TEEING_GROUND;
                case 865815:
                    return TYPE_GOLF_PUTTING_GREEN;
                case 865816:
                    return TYPE_GOLF_ROUGH;
                case 865817:
                    return TYPE_GOLF_SAND_BUNKER;
                case 865818:
                    return TYPE_GOLF_FAIRWAY;
                case 865819:
                    return TYPE_GOLF_HOLE;
                case 865820:
                    return TYPE_DEPRECATED_GOLF_SHOP;
                case 865821:
                    return TYPE_CAMPING_SITE;
                case 865822:
                    return TYPE_DESIGNATED_BARBECUE_PIT;
                case 865823:
                    return TYPE_DESIGNATED_COOKING_AREA;
                case 865824:
                    return TYPE_CAMPFIRE_PIT;
                case 865825:
                    return TYPE_WATER_FOUNTAIN;
                case 865826:
                    return TYPE_LITTER_RECEPTACLE;
                case 865827:
                    return TYPE_LOCKER_AREA;
                case 865828:
                    return TYPE_ANIMAL_ENCLOSURE;
                case 865829:
                    return TYPE_CARTOGRAPHIC_LINE;
                default:
                    switch (i) {
                        case 17:
                            return TYPE_ROUTE;
                        case 18:
                            return TYPE_SEGMENT;
                        case 19:
                            return TYPE_INTERSECTION;
                        case 20:
                            return TYPE_TRANSIT;
                        case 21:
                            return TYPE_SEGMENT_PATH;
                        case 22:
                            return TYPE_INTERSECTION_GROUP;
                        case 23:
                            return TYPE_PATHWAY;
                        case 24:
                            return TYPE_RESTRICTION_GROUP;
                        case 25:
                            return TYPE_TOLL_CLUSTER;
                        default:
                            switch (i) {
                                case 33:
                                    return TYPE_COUNTRY;
                                case 34:
                                    return TYPE_ADMINISTRATIVE_AREA;
                                case 35:
                                    return TYPE_COLLOQUIAL_AREA;
                                case 36:
                                    return TYPE_RESERVATION;
                                case 37:
                                    return TYPE_LOCALITY;
                                case 38:
                                    return TYPE_SUBLOCALITY;
                                case 39:
                                    return TYPE_NEIGHBORHOOD;
                                case 40:
                                    return TYPE_CONSTITUENCY;
                                case 41:
                                    return TYPE_DESIGNATED_MARKET_AREA;
                                case 42:
                                    return TYPE_SCHOOL_DISTRICT;
                                case 43:
                                    return TYPE_LAND_PARCEL;
                                case 44:
                                    return TYPE_DISPUTED_AREA;
                                case 45:
                                    return TYPE_POLICE_JURISDICTION;
                                default:
                                    switch (i) {
                                        case 49:
                                            return TYPE_GOLF_COURSE;
                                        case 50:
                                            return TYPE_LOCAL_PARK;
                                        case 51:
                                            return TYPE_NATIONAL_PARK;
                                        case 52:
                                            return TYPE_PROVINCIAL_PARK;
                                        case 53:
                                            return TYPE_CAMPGROUNDS;
                                        case 54:
                                            return TYPE_HIKING_AREA;
                                        default:
                                            switch (i) {
                                                case 97:
                                                    return TYPE_AIRPORT_GROUNDS;
                                                case 98:
                                                    return TYPE_BUILDING_GROUNDS;
                                                case 99:
                                                    return TYPE_CEMETERY;
                                                case 100:
                                                    return TYPE_HOSPITAL_GROUNDS;
                                                case 101:
                                                    return TYPE_INDUSTRIAL;
                                                case 102:
                                                    return TYPE_MILITARY;
                                                case 103:
                                                    return TYPE_SHOPPING_CENTER;
                                                case 104:
                                                    return TYPE_SPORTS_COMPLEX;
                                                case 105:
                                                    return TYPE_UNIVERSITY_GROUNDS;
                                                case 106:
                                                    return TYPE_DEPRECATED_TARMAC;
                                                default:
                                                    switch (i) {
                                                        case 161:
                                                            return TYPE_TERRAIN;
                                                        case 162:
                                                            return TYPE_WATER;
                                                        case 163:
                                                            return TYPE_TECTONIC;
                                                        case 164:
                                                            return TYPE_LAND_MASS;
                                                        case 165:
                                                            return TYPE_ELEVATED;
                                                        case 166:
                                                            return TYPE_UNDERSEA;
                                                        default:
                                                            switch (i) {
                                                                case 194:
                                                                    return TYPE_LOCALE;
                                                                case 195:
                                                                    return TYPE_TIMEZONE;
                                                                case 196:
                                                                    return TYPE_BUSINESS_CHAIN;
                                                                default:
                                                                    switch (i) {
                                                                        case 198:
                                                                            return TYPE_PHONE_NUMBER_PREFIX;
                                                                        case 199:
                                                                            return TYPE_BUSINESS_CORRIDOR;
                                                                        case 200:
                                                                            return TYPE_ADDRESS_TEMPLATE;
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
        return TYPE_BORDER;
    }

    public static zzbfj zzc() {
        return zzaml.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzgi);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzgi;
    }
}
