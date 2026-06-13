package kr.switcher.device.switcher;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SwitcherVersions {
    private static final int EQUAL = 0;
    public static final int FEATURE_STROKE = 6;
    public static final String FIRMWARE_DOWNLOAD_LINK_1_SET = "https://docs.google.com/uc?export=download&id=1dknxnxFlXvnYJZwGIRNpJ_0gTw70ckKx";
    public static final String FIRMWARE_DOWNLOAD_LINK_2_SET = "https://docs.google.com/uc?export=download&id=1dFic2_AgQmClqOqS1p7OR6MbsRqudej3";
    private static final int HIGHER = 1;
    public static final String LAST_SWITCHER_VERSION = "0.8.8";
    private static final int LOWER = 2;
    public static final int VERSION_PIECE_APP = 0;
    public static final int VERSION_PIECE_FEATURE = 1;
    public static final int VERSION_PIECE_HOTFIX = 2;

    private int compare(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i < i2 ? 2 : 0;
    }

    public boolean isHigherOrEqualThanLastVersion(String str) {
        ArrayList<Integer> versionPieces = getVersionPieces(LAST_SWITCHER_VERSION);
        ArrayList<Integer> versionPieces2 = getVersionPieces(str);
        int iCompare = compare(versionPieces2.get(0).intValue(), versionPieces.get(0).intValue());
        if (iCompare == 1) {
            return true;
        }
        if (iCompare == 2) {
            return false;
        }
        int iCompare2 = compare(versionPieces2.get(1).intValue(), versionPieces.get(1).intValue());
        if (iCompare2 == 1) {
            return true;
        }
        if (iCompare2 == 2) {
            return false;
        }
        int iCompare3 = compare(versionPieces2.get(2).intValue(), versionPieces.get(2).intValue());
        return iCompare3 == 1 || iCompare3 == 0;
    }

    public boolean isHigherFeature(int i) {
        return isHigherFeature(LAST_SWITCHER_VERSION, i);
    }

    public boolean isHigherFeature(String str, int i) {
        return compare(i, getVersionPieces(str).get(1).intValue()) == 1;
    }

    private ArrayList<Integer> getVersionPieces(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            arrayList.add(Integer.valueOf(Integer.parseInt(str.split("\\.")[0])));
            arrayList.add(Integer.valueOf(Integer.parseInt(str.split("\\.")[1])));
            arrayList.add(Integer.valueOf(Integer.parseInt(str.split("\\.")[2])));
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList.add(0);
            arrayList.add(0);
            arrayList.add(0);
        } catch (NumberFormatException unused2) {
            arrayList.add(0);
            arrayList.add(0);
            arrayList.add(0);
        }
        return arrayList;
    }
}
