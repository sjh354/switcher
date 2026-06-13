package com.neovisionaries.bluetooth.ble.advertising;

/* JADX INFO: loaded from: classes.dex */
public class ADManufacturerSpecific extends ADStructure {
    private static final String STRING_FORMAT = "ADManufacturerSpecific(Length=%d,Type=0x%02X,CompanyID=0x%04X)";
    private static final long serialVersionUID = 1;
    private int mCompanyId;

    public ADManufacturerSpecific() {
        this(3, 255, new byte[]{-1, -1}, 65535);
    }

    public ADManufacturerSpecific(int i, int i2, byte[] bArr, int i3) {
        super(i, i2, bArr);
        this.mCompanyId = i3;
    }

    public int getCompanyId() {
        return this.mCompanyId;
    }

    public void setCompanyId(int i) {
        this.mCompanyId = i;
    }

    @Override // com.neovisionaries.bluetooth.ble.advertising.ADStructure
    public String toString() {
        return String.format(STRING_FORMAT, Integer.valueOf(getLength()), Integer.valueOf(getType()), Integer.valueOf(this.mCompanyId));
    }
}
