package com.neovisionaries.bluetooth.ble.advertising;

/* JADX INFO: loaded from: classes.dex */
class FlagsBuilder implements ADStructureBuilder {
    FlagsBuilder() {
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructureBuilder
    public ADStructure build(int i, int i2, byte[] bArr) {
        return new Flags(i, i2, bArr);
    }
}
