package com.neovisionaries.bluetooth.ble.advertising;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class ADPayloadParser {
    private static final ADPayloadParser sInstance = new ADPayloadParser();
    private final Map<Integer, List<ADStructureBuilder>> mBuilders;
    private final Map<Integer, List<ADManufacturerSpecificBuilder>> mMSBuilders = new HashMap();

    private ADPayloadParser() {
        registerManufacturerSpecificBuilder(76, new MS004CBuilder());
        registerManufacturerSpecificBuilder(261, new MS0105Builder());
        registerManufacturerSpecificBuilder(410, new MS019ABuilder());
        UUIDsBuilder uUIDsBuilder = new UUIDsBuilder();
        LocalNameBuilder localNameBuilder = new LocalNameBuilder();
        ServiceDataBuilder serviceDataBuilder = new ServiceDataBuilder();
        this.mBuilders = new HashMap();
        registerBuilder(1, new FlagsBuilder());
        registerBuilder(2, uUIDsBuilder);
        registerBuilder(3, uUIDsBuilder);
        registerBuilder(4, uUIDsBuilder);
        registerBuilder(5, uUIDsBuilder);
        registerBuilder(6, uUIDsBuilder);
        registerBuilder(7, uUIDsBuilder);
        registerBuilder(8, localNameBuilder);
        registerBuilder(9, localNameBuilder);
        registerBuilder(10, new TxPowerLevelBuilder());
        registerBuilder(20, uUIDsBuilder);
        registerBuilder(21, uUIDsBuilder);
        registerBuilder(22, serviceDataBuilder);
        registerBuilder(22, new EddystoneBuilder());
        registerBuilder(31, uUIDsBuilder);
        registerBuilder(32, serviceDataBuilder);
        registerBuilder(33, serviceDataBuilder);
        registerBuilder(255, new MSBuilder());
    }

    public static ADPayloadParser getInstance() {
        return sInstance;
    }

    public void registerBuilder(int i, ADStructureBuilder aDStructureBuilder) {
        if (i < 0 || 255 < i) {
            throw new IllegalArgumentException(String.format("'type' is out of the valid range: %d", Integer.valueOf(i)));
        }
        if (aDStructureBuilder == null) {
            return;
        }
        Integer numValueOf = Integer.valueOf(i);
        List<ADStructureBuilder> arrayList = this.mBuilders.get(numValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mBuilders.put(numValueOf, arrayList);
        }
        arrayList.add(0, aDStructureBuilder);
    }

    public void registerManufacturerSpecificBuilder(int i, ADManufacturerSpecificBuilder aDManufacturerSpecificBuilder) {
        if (i < 0 || 65535 < i) {
            throw new IllegalArgumentException(String.format("'companyId' is out of the valid range: %d", Integer.valueOf(i)));
        }
        if (aDManufacturerSpecificBuilder == null) {
            return;
        }
        Integer numValueOf = Integer.valueOf(i);
        List<ADManufacturerSpecificBuilder> arrayList = this.mMSBuilders.get(numValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mMSBuilders.put(numValueOf, arrayList);
        }
        arrayList.add(0, aDManufacturerSpecificBuilder);
    }

    public List<ADStructure> parse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return parse(bArr, 0, bArr.length);
    }

    public List<ADStructure> parse(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (i >= 0 && i2 >= 0 && bArr.length > i) {
            int iMin = Math.min(i2 + i, bArr.length);
            while (i < iMin) {
                int i3 = bArr[i] & 255;
                if (i3 == 0 || (iMin - i) - 1 < i3) {
                    break;
                }
                arrayList.add(buildAds(i3, bArr[i + 1] & UByte.MAX_VALUE, Arrays.copyOfRange(bArr, i + 2, i + i3 + 1)));
                i += i3 + 1;
            }
        }
        return arrayList;
    }

    private ADStructure buildAds(int i, int i2, byte[] bArr) {
        List<ADStructureBuilder> list = this.mBuilders.get(Integer.valueOf(i2));
        if (list == null) {
            return new ADStructure(i, i2, bArr);
        }
        Iterator<ADStructureBuilder> it = list.iterator();
        while (it.hasNext()) {
            ADStructure aDStructureBuild = it.next().build(i, i2, bArr);
            if (aDStructureBuild != null) {
                return aDStructureBuild;
            }
        }
        return new ADStructure(i, i2, bArr);
    }

    private class MSBuilder implements ADStructureBuilder {
        private MSBuilder() {
        }

        @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructureBuilder
        public ADStructure build(int i, int i2, byte[] bArr) {
            if (bArr.length < 2) {
                return null;
            }
            int i3 = ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE);
            List list = (List) ADPayloadParser.this.mMSBuilders.get(Integer.valueOf(i3));
            if (list == null) {
                return new ADManufacturerSpecific(i, i2, bArr, i3);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ADManufacturerSpecific aDManufacturerSpecificBuild = ((ADManufacturerSpecificBuilder) it.next()).build(i, i2, bArr, i3);
                if (aDManufacturerSpecificBuild != null) {
                    return aDManufacturerSpecificBuild;
                }
            }
            return new ADManufacturerSpecific(i, i2, bArr, i3);
        }
    }
}
