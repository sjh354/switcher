package kr.switcher.switcherm.ui.switcherInfo.helper;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.database.DBPricingModel;
import kr.switcher.switcherm.database.DBPricingModelDAO;
import kr.switcher.switcherm.ui.switcherInfo.adapter.PlanItem;

/* JADX INFO: loaded from: classes2.dex */
public class ConverterPricingModelDBToPlanItem {
    private List<DBPricingModel> dbPricingModels;
    private int mainPlanCode;

    public ConverterPricingModelDBToPlanItem(List<DBPricingModel> list) {
        this.dbPricingModels = list;
        initialize();
    }

    public ConverterPricingModelDBToPlanItem() {
        setDBPricingModelsFromDB();
        initialize();
    }

    private void initialize() {
        this.mainPlanCode = -1;
    }

    private void setDBPricingModelsFromDB() {
        DBPricingModelDAO dBPricingModelDAO = new DBPricingModelDAO();
        dBPricingModelDAO.open();
        this.dbPricingModels = dBPricingModelDAO.getPricingModels();
        dBPricingModelDAO.close();
    }

    public ArrayList<PlanItem> getPlanItems() {
        ArrayList<PlanItem> arrayList = new ArrayList<>();
        for (int i = 0; i < this.dbPricingModels.size(); i++) {
            DBPricingModel dBPricingModel = this.dbPricingModels.get(i);
            arrayList.add(new PlanItem(dBPricingModel.getCode(), dBPricingModel.getPrice(), dBPricingModel.getPlanName(), dBPricingModel.getPlanInfo(), dBPricingModel.getCode() == this.mainPlanCode));
        }
        return arrayList;
    }

    public ConverterPricingModelDBToPlanItem setMainPlanCode(int i) {
        this.mainPlanCode = i;
        return this;
    }
}
