package kr.switcher.switcherm.ui.mypage.helper;

import java.util.ArrayList;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.database.DBPricingModel;
import kr.switcher.switcherm.database.DBPricingModelDAO;
import kr.switcher.switcherm.database.DBSubscriptionService;
import kr.switcher.switcherm.database.DBSubscriptionServiceDAO;

/* JADX INFO: loaded from: classes2.dex */
public class MySwitcherHelper {
    public String getSwitcherInfo(int i) {
        if (i == 0) {
            return IOUtil.getStringResource(R.string.status_code0);
        }
        if (i == 4) {
            return IOUtil.getStringResource(R.string.status_code4);
        }
        if (i != 6) {
            return i != 8 ? "" : IOUtil.getStringResource(R.string.status_code8);
        }
        return IOUtil.getStringResource(R.string.status_code6);
    }

    public List<String> getPaymentPlanFromDB(String str) {
        DBSubscriptionServiceDAO dBSubscriptionServiceDAO = new DBSubscriptionServiceDAO();
        dBSubscriptionServiceDAO.open();
        DBSubscriptionService service = dBSubscriptionServiceDAO.getService(str);
        dBSubscriptionServiceDAO.close();
        if (service == null) {
            return null;
        }
        DBPricingModelDAO dBPricingModelDAO = new DBPricingModelDAO();
        dBPricingModelDAO.open();
        DBPricingModel pricingModel = dBPricingModelDAO.getPricingModel(service.getPaymentPlan());
        dBPricingModelDAO.close();
        if (pricingModel == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(service.getFreeYN());
        arrayList.add(pricingModel.getPlanName());
        return arrayList;
    }
}
