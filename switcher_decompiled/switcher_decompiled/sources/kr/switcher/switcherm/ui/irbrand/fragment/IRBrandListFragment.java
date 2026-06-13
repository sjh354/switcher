package kr.switcher.switcherm.ui.irbrand.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;
import kr.switcher.device.remocon.Remocon;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.ui.irbrand.IRBrandActivity;
import kr.switcher.switcherm.ui.irbrand.adapter.BrandItem;
import kr.switcher.switcherm.ui.irbrand.adapter.IRBrandListAdapter;
import kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor;
import kr.switcher.switcherm.ui.irbrand.presenter.IRBrandListPresenter;
import kr.switcher.switcherm.ui.irbrand.view.IRBrandListView;

/* JADX INFO: loaded from: classes2.dex */
public class IRBrandListFragment extends Fragment implements IRBrandListView, IRBrandListInteractor.OnGetBrandListener, IRBrandListAdapter.OnItemClickListener, IRBrandListInteractor.OnMakeRemoconListener, IRBrandListInteractor.OnSetRemoconSettingListener {
    private static final String TAG = "IRBrandListFragment";
    private IRBrandListAdapter adapter;
    private List<BrandItem> brandItems;
    private Remocon.ControllerID controllerId;
    private IRBrandListPresenter presenter;
    private String remoconName;

    @BindView(R.id.rv_ir_brand_list)
    RecyclerView rv_ir_brand_list;
    private int selectedPosition;

    @Override // kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.OnGetBrandListener, kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.OnMakeRemoconListener, kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.OnSetRemoconSettingListener
    public void onError(String str) {
    }

    public static IRBrandListFragment newInstance(Remocon.ControllerID controllerID, String str) {
        IRBrandListFragment iRBrandListFragment = new IRBrandListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IRBrandActivity.PARM_CONTROLLER_ID, controllerID.getValue());
        bundle.putString(IRBrandActivity.PARM_REMOCON_NAME, str);
        iRBrandListFragment.setArguments(bundle);
        return iRBrandListFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ir_brand_list, viewGroup, false);
        ButterKnife.bind(this, viewInflate);
        Bundle arguments = getArguments();
        if (arguments == null) {
            return null;
        }
        this.controllerId = Remocon.convertIntToControllerID(arguments.getInt(IRBrandActivity.PARM_CONTROLLER_ID));
        this.remoconName = arguments.getString(IRBrandActivity.PARM_REMOCON_NAME);
        this.presenter = new IRBrandListPresenter(this, new IRBrandListInteractor(this, this, this));
        ((IRBrandActivity) getActivity()).setActivityTitle("브랜드 선택");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.presenter.onResume(this.controllerId);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandListView
    public void initRecyclerListView() {
        this.brandItems = new ArrayList();
        this.adapter = new IRBrandListAdapter(this.brandItems, this);
        this.rv_ir_brand_list.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_ir_brand_list.setAdapter(this.adapter);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandListView
    public void setBrandItems(List<BrandItem> list) {
        this.brandItems.addAll(list);
        this.adapter.notifyDataSetChanged();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.view.IRBrandListView
    public void acvivityFinish() {
        getActivity().finish();
    }

    @Override // kr.switcher.switcherm.ui.irbrand.adapter.IRBrandListAdapter.OnItemClickListener
    public void onItemClick(int i) {
        this.presenter.onItemClick(this.remoconName, this.controllerId);
        this.selectedPosition = i;
    }

    @Override // kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.OnGetBrandListener
    public void onGetBrandList(List<BrandItem> list) {
        this.presenter.onGetBrandList(list);
    }

    @Override // kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.OnMakeRemoconListener
    public void onMakeRemocon(Remocon remocon) {
        this.presenter.onMakeRemocon(remocon, this.brandItems.get(this.selectedPosition).getId());
    }

    @Override // kr.switcher.switcherm.ui.irbrand.interactor.IRBrandListInteractor.OnSetRemoconSettingListener
    public void onSetRemoconSetting() {
        this.presenter.onSetRemoconSetting();
    }
}
