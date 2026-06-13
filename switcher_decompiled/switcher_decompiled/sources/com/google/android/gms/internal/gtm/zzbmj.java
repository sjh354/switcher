package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.0.2 */
/* JADX INFO: loaded from: classes.dex */
public enum zzbmj implements zzbfh {
    UNSPECIFIED(0),
    BOOL_FIELD(1),
    CHANGE_TO_UNSIGNED_INT(2),
    CHANGE_TO_SIGNED_INT(3),
    CHANGED_FIELD_TYPE(4),
    INVALID_MESSAGE_CHANGE(5),
    TYPE_CHANGE(6),
    BOOL_TO_ENUM(7),
    DEFAULT_VALUE_CHANGE(8),
    DELETE_FIELD_RESERVED(9),
    DELETE_NON_DEPRECATED_FIELD(10),
    ENUM_DEFAULT_VALUE_ZERO(11),
    ENUM_DEFAULT_VALUE_NAME(12),
    ENUM_DEFAULT_VALUE_NAME_CONFLICT(13),
    ENUM_VALUE_ADDED(14),
    ENUM_VALUE_CHANGED(15),
    ENUM_VALUE_NAMES(16),
    FIELD_PRESENCE(17),
    GENERATED_CODE_STYLE(18),
    LARGE_ENUM(19),
    MESSAGE_SET_MISMATCH(20),
    PACKED_FIELD(21),
    RENAME_FIELD(22),
    TAG_CHANGE(23),
    TIME_UNIT(24),
    TOO_MANY_FIELDS(25),
    DELETE_REQUIRED_FIELD(26),
    KEYWORD_CONFLICT(27),
    GLOBAL_PACKAGE(28),
    ONEOF_FIELD_CHANGE(29),
    KEEP_PROTO_FILES_SMALL(30),
    LONG_FIELD_JSPB_ANNOTATED(31),
    ENUM_VALUE_DELETE(32),
    REPEATED_FIELD_TRANSITION_PACKED(33),
    REPEATED_FIELD_TRANSITION_MESSAGE(34),
    REQUIRED_TO_OPTIONAL(35);

    private static final zzbfi zzK = new zzbfi() { // from class: com.google.android.gms.internal.gtm.zzbmh
        @Override // com.google.android.gms.internal.gtm.zzbfi
        public final /* synthetic */ zzbfh zza(int i) {
            return zzbmj.zzc(i);
        }
    };
    private final int zzM;

    zzbmj(int i) {
        this.zzM = i;
    }

    public static zzbfj zzb() {
        return zzbmi.zza;
    }

    public static zzbmj zzc(int i) {
        switch (i) {
            case 0:
                return UNSPECIFIED;
            case 1:
                return BOOL_FIELD;
            case 2:
                return CHANGE_TO_UNSIGNED_INT;
            case 3:
                return CHANGE_TO_SIGNED_INT;
            case 4:
                return CHANGED_FIELD_TYPE;
            case 5:
                return INVALID_MESSAGE_CHANGE;
            case 6:
                return TYPE_CHANGE;
            case 7:
                return BOOL_TO_ENUM;
            case 8:
                return DEFAULT_VALUE_CHANGE;
            case 9:
                return DELETE_FIELD_RESERVED;
            case 10:
                return DELETE_NON_DEPRECATED_FIELD;
            case 11:
                return ENUM_DEFAULT_VALUE_ZERO;
            case 12:
                return ENUM_DEFAULT_VALUE_NAME;
            case 13:
                return ENUM_DEFAULT_VALUE_NAME_CONFLICT;
            case 14:
                return ENUM_VALUE_ADDED;
            case 15:
                return ENUM_VALUE_CHANGED;
            case 16:
                return ENUM_VALUE_NAMES;
            case 17:
                return FIELD_PRESENCE;
            case 18:
                return GENERATED_CODE_STYLE;
            case 19:
                return LARGE_ENUM;
            case 20:
                return MESSAGE_SET_MISMATCH;
            case 21:
                return PACKED_FIELD;
            case 22:
                return RENAME_FIELD;
            case 23:
                return TAG_CHANGE;
            case 24:
                return TIME_UNIT;
            case 25:
                return TOO_MANY_FIELDS;
            case 26:
                return DELETE_REQUIRED_FIELD;
            case 27:
                return KEYWORD_CONFLICT;
            case 28:
                return GLOBAL_PACKAGE;
            case 29:
                return ONEOF_FIELD_CHANGE;
            case 30:
                return KEEP_PROTO_FILES_SMALL;
            case 31:
                return LONG_FIELD_JSPB_ANNOTATED;
            case 32:
                return ENUM_VALUE_DELETE;
            case 33:
                return REPEATED_FIELD_TRANSITION_PACKED;
            case 34:
                return REPEATED_FIELD_TRANSITION_MESSAGE;
            case 35:
                return REQUIRED_TO_OPTIONAL;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzM);
    }

    @Override // com.google.android.gms.internal.gtm.zzbfh
    public final int zza() {
        return this.zzM;
    }
}
