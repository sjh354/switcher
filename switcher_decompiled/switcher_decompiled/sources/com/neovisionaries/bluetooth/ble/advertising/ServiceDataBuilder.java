package com.neovisionaries.bluetooth.ble.advertising;

/* JADX INFO: loaded from: classes.dex */
class ServiceDataBuilder implements ADStructureBuilder {
    ServiceDataBuilder() {
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructureBuilder
    public ADStructure build(int i, int i2, byte[] bArr) {
        return new ServiceData(i, i2, bArr);
    }
}
