package kr.switcher.switcherm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.databinding.FragmentRentalPlanFreeBinding;

/* JADX INFO: loaded from: classes2.dex */
public class PlanFreeFragmentViewModel extends BaseObservable {
    public static final int PLAN1 = 1;
    public static final int PLAN2 = 2;
    public static final int PLAN3 = 3;
    public static final int PLAN4 = 4;
    private FragmentRentalPlanFreeBinding binder;
    private List<String> descriptions;
    private List<String> discounts;
    private List<Boolean> isCheckedPlans;
    private List<Integer> isMineList;
    private List<String> prices;
    private List<String> titles;

    public PlanFreeFragmentViewModel(FragmentRentalPlanFreeBinding fragmentRentalPlanFreeBinding) {
        this.binder = fragmentRentalPlanFreeBinding;
        initResources();
    }

    private void initResources() {
        this.titles = new ArrayList();
        this.prices = new ArrayList();
        this.descriptions = new ArrayList();
        this.discounts = new ArrayList();
        this.isMineList = new ArrayList();
        this.isCheckedPlans = new ArrayList();
    }

    public void viewData(String str, String str2, String str3, String str4, boolean z) {
        this.titles.add(str);
        this.prices.add(str2);
        this.descriptions.add(str3);
        this.discounts.add(str4);
        this.isMineList.add(Integer.valueOf(z ? 0 : 8));
        this.isCheckedPlans.add(Boolean.valueOf(z));
    }

    public void checkPlan(int i) {
        this.binder.cbPlan1.setChecked(false);
        this.binder.cbPlan2.setChecked(false);
        this.binder.cbPlan3.setChecked(false);
        this.binder.cbPlan4.setChecked(false);
        if (i == 1) {
            this.binder.cbPlan1.setChecked(true);
            return;
        }
        if (i == 2) {
            this.binder.cbPlan2.setChecked(true);
        } else if (i == 3) {
            this.binder.cbPlan3.setChecked(true);
        } else {
            if (i != 4) {
                return;
            }
            this.binder.cbPlan4.setChecked(true);
        }
    }

    public int getCheckedPlan() {
        if (this.binder.cbPlan1.isChecked()) {
            return 1;
        }
        if (this.binder.cbPlan2.isChecked()) {
            return 2;
        }
        if (this.binder.cbPlan3.isChecked()) {
            return 3;
        }
        return this.binder.cbPlan4.isChecked() ? 4 : 1;
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
    public List<String> getDiscounts() {
        return this.discounts;
    }

    public void setDiscounts(List<String> list) {
        this.discounts = list;
        notifyPropertyChanged(10);
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
    public List<Boolean> getIsCheckedPlans() {
        return this.isCheckedPlans;
    }

    public void setIsCheckedPlans(List<Boolean> list) {
        this.isCheckedPlans = list;
        notifyPropertyChanged(12);
    }
}
