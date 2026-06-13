package kr.switcher.switcherm.viewmodel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PlanFragmentViewModel extends BaseObservable {
    private Context context;
    private List<String> descriptions;
    private List<Integer> isMineList;
    private List<String> prices;
    private String purchasePrice;
    private List<String> titles;

    public PlanFragmentViewModel(Context context) {
        this.context = context;
        initResources();
    }

    private void initResources() {
        this.titles = new ArrayList();
        this.prices = new ArrayList();
        this.descriptions = new ArrayList();
        this.isMineList = new ArrayList();
    }

    public void viewData(String str, String str2, String str3, String str4, boolean z) {
        this.titles.add(str);
        this.prices.add(str2);
        this.descriptions.add(str3);
        this.isMineList.add(Integer.valueOf(z ? 0 : 8));
    }

    private Drawable makeDrawable(int i) {
        return this.context.getResources().getDrawable(i);
    }

    @Bindable
    public List<String> getTitles() {
        return this.titles;
    }

    public void setTitles(List<String> list) {
        this.titles = list;
        notifyPropertyChanged(37);
    }

    @Bindable
    public List<String> getPrices() {
        return this.prices;
    }

    public void setPrices(List<String> list) {
        this.prices = list;
        notifyPropertyChanged(23);
    }

    @Bindable
    public List<String> getDescriptions() {
        return this.descriptions;
    }

    public void setDescriptions(List<String> list) {
        this.descriptions = list;
        notifyPropertyChanged(9);
    }

    @Bindable
    public List<Integer> getIsMineList() {
        return this.isMineList;
    }

    public void setIsMineList(List<Integer> list) {
        this.isMineList = list;
        notifyPropertyChanged(13);
    }

    @Bindable
    public String getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(String str) {
        this.purchasePrice = str;
        notifyPropertyChanged(26);
    }
}
