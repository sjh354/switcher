package kr.switcher.switcherm.common.util;

import android.graphics.drawable.Drawable;
import kr.switcher.device.IODevice;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.device.IODeviceHandler;

/* JADX INFO: loaded from: classes2.dex */
public class IODeviceIconMaker {

    public enum IODeviceIconType {
        SWITCHER_ONE,
        SWITCHER_TWO,
        LINKER,
        CHECKER,
        TV,
        AIRCON,
        SET_TOP_BOX,
        REMOCON,
        UNKNOWN
    }

    public static Drawable makeMainIcon(IODevice.ProductId productId, String str) {
        if (productId == null) {
            return null;
        }
        return getMainImage(convertMainIconType(productId, str));
    }

    public static Drawable makeInfoIcon(IODevice.ProductId productId, String str) {
        if (productId == null) {
            return null;
        }
        return getInfoImage(convertMainIconType(productId, str));
    }

    public static Drawable makeInfoButtonIcon(IODevice.ProductId productId, String str) {
        if (productId == null) {
            return null;
        }
        return getInfoButtonImage(convertMainIconType(productId, str));
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.common.util.IODeviceIconMaker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$kr$switcher$device$IODevice$ProductId;

        static {
            int[] iArr = new int[IODevice.ProductId.values().length];
            $SwitchMap$kr$switcher$device$IODevice$ProductId = iArr;
            try {
                iArr[IODevice.ProductId.SWITCHER_TYPE_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.SWITCHER_TYPE_TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.LINKER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.CHECKER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$kr$switcher$device$IODevice$ProductId[IODevice.ProductId.REMOCON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static IODeviceIconType convertMainIconType(IODevice.ProductId productId, String str) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            return IODeviceIconType.SWITCHER_ONE;
        }
        if (i == 2) {
            return IODeviceIconType.SWITCHER_TWO;
        }
        if (i == 3) {
            return IODeviceIconType.LINKER;
        }
        if (i == 4) {
            return IODeviceIconType.CHECKER;
        }
        if (i == 5) {
            Remocon remocon = (Remocon) IODeviceHandler.getInstance().getDevice(str);
            if (remocon == null) {
                return IODeviceIconType.UNKNOWN;
            }
            if (remocon.getControllerId().equals(Remocon.ControllerID.TV)) {
                return IODeviceIconType.TV;
            }
            if (remocon.getControllerId().equals(Remocon.ControllerID.AIRCON)) {
                return IODeviceIconType.AIRCON;
            }
            if (remocon.getControllerId().equals(Remocon.ControllerID.SET_TOP_BOX)) {
                return IODeviceIconType.SET_TOP_BOX;
            }
            if (remocon.getControllerId().equals(Remocon.ControllerID.REMOCON)) {
                return IODeviceIconType.REMOCON;
            }
        }
        return IODeviceIconType.UNKNOWN;
    }

    public static Drawable getMainImage(IODeviceIconType iODeviceIconType) {
        if (IODeviceIconType.SWITCHER_ONE == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_main_switcher_one);
        }
        if (IODeviceIconType.SWITCHER_TWO == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_main_switcher_two);
        }
        if (IODeviceIconType.CHECKER == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_main_checker);
        }
        if (IODeviceIconType.REMOCON == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_main_remocon);
        }
        if (IODeviceIconType.TV == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_main_tv);
        }
        if (IODeviceIconType.SET_TOP_BOX == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_main_set_top_box);
        }
        if (IODeviceIconType.AIRCON == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_main_aircon);
        }
        return null;
    }

    public static Drawable getInfoImage(IODeviceIconType iODeviceIconType) {
        if (IODeviceIconType.SWITCHER_ONE == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_switcher_one);
        }
        if (IODeviceIconType.SWITCHER_TWO == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_switcher_two);
        }
        if (IODeviceIconType.LINKER == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_linker);
        }
        if (IODeviceIconType.CHECKER == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_checker);
        }
        if (IODeviceIconType.REMOCON == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_remocon);
        }
        if (IODeviceIconType.TV == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_tv);
        }
        if (IODeviceIconType.SET_TOP_BOX == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_set_top_box);
        }
        if (IODeviceIconType.AIRCON == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.ic_aircon);
        }
        return null;
    }

    public static Drawable getInfoButtonImage(IODeviceIconType iODeviceIconType) {
        if (IODeviceIconType.SWITCHER_ONE == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_switcher_info);
        }
        if (IODeviceIconType.SWITCHER_TWO == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_switcher_info);
        }
        if (IODeviceIconType.LINKER == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_linker_info);
        }
        if (IODeviceIconType.CHECKER == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_checker_info);
        }
        if (IODeviceIconType.REMOCON == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_linker_info);
        }
        if (IODeviceIconType.TV == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_linker_info);
        }
        if (IODeviceIconType.SET_TOP_BOX == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_linker_info);
        }
        if (IODeviceIconType.AIRCON == iODeviceIconType) {
            return IOUtil.makeDrawable(R.drawable.btn_linker_info);
        }
        return null;
    }
}
