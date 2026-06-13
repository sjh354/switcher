package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import kr.switcher.device.IODevice;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class DFUFragmentViewModel extends BaseObservable {
    public static final int DFU_NEW_UPDATE_MODE = 0;
    public static final int DFU_UPDATED_MODE = 1;
    public static final int DFU_UPDATING_MODE = 2;
    private Context context;
    private int mode;
    private String progress;
    private String siwtcherName;
    private Drawable switcherIcon;
    private String version;
    private int visibilityOfDFUUpdating;
    private int visibilityOfLastVersion;
    private int visibilityOfUpdate;

    public DFUFragmentViewModel(Context context, int i, String str, IODevice.ProductId productId, String str2) {
        this.context = context;
        setMode(i);
        setSiwtcherName(str);
        setSwitcherType(productId);
        setProgress("0%");
        setVersion(IOUtil.getStringResource(R.string.version) + " " + str2);
    }

    public void setMode(int i) {
        if (i == 0) {
            setVisibilityOfDFUUpdating(8);
            setVisibilityOfUpdate(0);
            setVisibilityOfLastVersion(8);
            IOUtil.getStringResource(R.string.screen_title_4_0_2_0);
            return;
        }
        if (i == 2) {
            setVisibilityOfDFUUpdating(0);
            setVisibilityOfUpdate(8);
            setVisibilityOfLastVersion(8);
            setProgress(IOUtil.getStringResource(R.string.download_firmware));
            IOUtil.getStringResource(R.string.screen_title_4_0_2_1);
            return;
        }
        if (i == 1) {
            setVisibilityOfDFUUpdating(8);
            setVisibilityOfUpdate(8);
            setVisibilityOfLastVersion(0);
            IOUtil.getStringResource(R.string.screen_title_4_0_2_2);
        }
    }

    /* JADX INFO: renamed from: kr.switcher.switcherm.viewmodel.DFUFragmentViewModel$1, reason: invalid class name */
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
        }
    }

    private void setSwitcherType(IODevice.ProductId productId) {
        int i = AnonymousClass1.$SwitchMap$kr$switcher$device$IODevice$ProductId[productId.ordinal()];
        if (i == 1) {
            setSwitcherIcon(makeDrawable(R.drawable.ic_switcher_one));
        } else {
            if (i != 2) {
                return;
            }
            setSwitcherIcon(makeDrawable(R.drawable.ic_switcher_two));
        }
    }

    private Drawable makeDrawable(int i) {
        return this.context.getResources().getDrawable(i);
    }

    @Bindable
    public Drawable getSwitcherIcon() {
        return this.switcherIcon;
    }

    public void setSwitcherIcon(Drawable drawable) {
        this.switcherIcon = drawable;
        notifyPropertyChanged(35);
    }

    @Bindable
    public String getSiwtcherName() {
        return this.siwtcherName;
    }

    public void setSiwtcherName(String str) {
        this.siwtcherName = str;
        notifyPropertyChanged(34);
    }

    @Bindable
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
        notifyPropertyChanged(38);
    }

    @Bindable
    public String getProgress() {
        return this.progress;
    }

    public void setProgress(String str) {
        this.progress = str;
        notifyPropertyChanged(25);
    }

    @Bindable
    public int getVisibilityOfDFUUpdating() {
        return this.visibilityOfDFUUpdating;
    }

    public void setVisibilityOfDFUUpdating(int i) {
        this.visibilityOfDFUUpdating = i;
        notifyPropertyChanged(40);
    }

    @Bindable
    public int getVisibilityOfUpdate() {
        return this.visibilityOfUpdate;
    }

    public void setVisibilityOfUpdate(int i) {
        this.visibilityOfUpdate = i;
        notifyPropertyChanged(52);
    }

    @Bindable
    public int getVisibilityOfLastVersion() {
        return this.visibilityOfLastVersion;
    }

    public void setVisibilityOfLastVersion(int i) {
        this.visibilityOfLastVersion = i;
        notifyPropertyChanged(20);
    }
}
