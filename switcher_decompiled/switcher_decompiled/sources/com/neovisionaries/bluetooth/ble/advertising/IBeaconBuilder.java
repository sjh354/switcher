package com.neovisionaries.bluetooth.ble.advertising;

/* JADX INFO: loaded from: classes.dex */
class IBeaconBuilder implements ADManufacturerSpecificBuilder {
    IBeaconBuilder() {
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADManufacturerSpecificBuilder
    public ADManufacturerSpecific build(int i, int i2, byte[] bArr, int i3) {
        return IBeacon.create(i, i2, bArr, i3);
    }
}
