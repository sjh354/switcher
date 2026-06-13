package com.neovisionaries.bluetooth.ble.advertising;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MSBuilder implements ADManufacturerSpecificBuilder {
    private final List<ADManufacturerSpecificBuilder> mBuilders = new ArrayList();

    public MSBuilder() {
    }

    public MSBuilder(ADManufacturerSpecificBuilder... aDManufacturerSpecificBuilderArr) {
        for (ADManufacturerSpecificBuilder aDManufacturerSpecificBuilder : aDManufacturerSpecificBuilderArr) {
            this.mBuilders.add(aDManufacturerSpecificBuilder);
        }
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADManufacturerSpecificBuilder
    public ADManufacturerSpecific build(int i, int i2, byte[] bArr, int i3) {
        Iterator<ADManufacturerSpecificBuilder> it = this.mBuilders.iterator();
        while (it.hasNext()) {
            ADManufacturerSpecific aDManufacturerSpecificBuild = it.next().build(i, i2, bArr, i3);
            if (aDManufacturerSpecificBuild != null) {
                return aDManufacturerSpecificBuild;
            }
        }
        return null;
    }

    public void addBuilder(ADManufacturerSpecificBuilder aDManufacturerSpecificBuilder) {
        if (aDManufacturerSpecificBuilder == null) {
            return;
        }
        this.mBuilders.add(aDManufacturerSpecificBuilder);
    }

    public void removeBuilder(ADManufacturerSpecificBuilder aDManufacturerSpecificBuilder) {
        if (aDManufacturerSpecificBuilder == null) {
            return;
        }
        this.mBuilders.remove(aDManufacturerSpecificBuilder);
    }
}
