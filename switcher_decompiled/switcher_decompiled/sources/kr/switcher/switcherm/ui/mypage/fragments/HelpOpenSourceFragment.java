package kr.switcher.switcherm.ui.mypage.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kr.switcher.switcherm.R;
import kr.switcher.switcherm.common.util.IOLog;
import kr.switcher.switcherm.common.util.IOUtil;

/* JADX INFO: loaded from: classes2.dex */
public class HelpOpenSourceFragment extends Fragment {
    private static final String TAG = "HelpOpenSourceFragment";

    public static HelpOpenSourceFragment newInstance() {
        HelpOpenSourceFragment helpOpenSourceFragment = new HelpOpenSourceFragment();
        helpOpenSourceFragment.setArguments(new Bundle());
        return helpOpenSourceFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_help_open_source, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_opensource1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_opensource2);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_opensource3);
        textView.setText(Html.fromHtml("<u>> " + IOUtil.getStringResource(R.string.opensource_link1) + "</u> "));
        textView2.setText(Html.fromHtml("<u>> " + IOUtil.getStringResource(R.string.opensource_link2) + "</u> "));
        textView3.setText(Html.fromHtml("<u>> " + IOUtil.getStringResource(R.string.opensource_link3) + "</u> "));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IOLog.activity(IOUtil.getStringResource(R.string.screen_title_6_0_0_1));
    }

    public void onOpenSourceLink1ButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.opensource_link1))));
    }

    public void onOpenSourceLink2ButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.opensource_link2))));
    }

    public void onOpenSourceLink3ButtonClicked() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(IOUtil.getStringResource(R.string.opensource_link3))));
    }
}
