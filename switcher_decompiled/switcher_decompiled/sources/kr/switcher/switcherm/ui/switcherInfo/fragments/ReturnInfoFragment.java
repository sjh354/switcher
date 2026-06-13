package kr.switcher.switcherm.ui.switcherInfo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import java.util.List;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;
import kr.switcher.switcherm.databinding.FragmentReturnInfoBinding;
import kr.switcher.switcherm.network.http.RestSwitcherAPIStore;
import kr.switcher.switcherm.network.http.response.CustomerMeAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpAPIResponse;
import kr.switcher.switcherm.network.http.response.HttpResponseHandler;
import kr.switcher.switcherm.network.http.response.HttpResponseListHandler;
import kr.switcher.switcherm.preference.OAuthToken;
import kr.switcher.switcherm.ui.switcherInfo.helper.AddressInfoMapper;
import kr.switcher.switcherm.user.AddressInfo;
import kr.switcher.switcherm.user.User;
import kr.switcher.switcherm.user.UserStateManager;
import kr.switcher.switcherm.user.helper.UserMapper;
import kr.switcher.switcherm.viewmodel.ReturnInfoFragmentViewModel;

/* JADX INFO: loaded from: classes2.dex */
public class ReturnInfoFragment extends Fragment {
    private static final String TAG = "ReturnInfoFragment";
    private FragmentReturnInfoBinding binder;
    private ReturnInfoFragmentViewModel viewModel;

    public static ReturnInfoFragment newInstance() {
        ReturnInfoFragment returnInfoFragment = new ReturnInfoFragment();
        returnInfoFragment.setArguments(new Bundle());
        return returnInfoFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binder = (FragmentReturnInfoBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_return_info, viewGroup, false);
        final User currentUserFromDB = UserStateManager.getInstance().getCurrentUserFromDB();
        if (currentUserFromDB == null) {
            IOUtil.showToast(IOUtil.getStringResource(R.string.not_found_user));
            getActivity().finish();
            return null;
        }
        ReturnInfoFragmentViewModel returnInfoFragmentViewModel = new ReturnInfoFragmentViewModel(getContext());
        this.viewModel = returnInfoFragmentViewModel;
        this.binder.setViewModel(returnInfoFragmentViewModel);
        RestSwitcherAPIStore.requestGetCustomerMe(new HttpResponseHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnInfoFragment.1
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onSuccess(HttpAPIResponse httpAPIResponse) {
                try {
                    UserStateManager.getInstance().setUserToDB(UserMapper.parseGetUserMe((CustomerMeAPIResponse) httpAPIResponse));
                } catch (Exception e) {
                    IOLog.error(ReturnInfoFragment.TAG, new OAuthToken().getOAuthToken(), "failed user json parse", e);
                }
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseHandler
            public void onFailure(String str, String str2) {
                IOLog.error(ReturnInfoFragment.TAG, new OAuthToken().getOAuthToken(), "requestGetAddressesMe", new Exception("code:" + str + ", message:" + str2));
            }
        });
        RestSwitcherAPIStore.requestGetAddressesMe(new HttpResponseListHandler() { // from class: kr.switcher.switcherm.ui.switcherInfo.fragments.ReturnInfoFragment.2
            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onSuccess(List list) {
                AddressInfo addressInfoTransform = AddressInfoMapper.transform(list);
                currentUserFromDB.setAddress1(addressInfoTransform.getAddress1());
                currentUserFromDB.setAddress2(addressInfoTransform.getAddress2());
                currentUserFromDB.setPostNumber(addressInfoTransform.getPostNumber());
                UserStateManager.getInstance().setUserToDB(currentUserFromDB);
            }

            @Override // kr.switcher.switcherm.network.http.response.HttpResponseListHandler
            public void onFailure(String str, String str2) {
                IOLog.error(ReturnInfoFragment.TAG, new OAuthToken().getOAuthToken(), "requestGetAddressesMe", new Exception("code:" + str + ", message:" + str2));
            }
        });
        return this.binder.getRoot();
    }
}
