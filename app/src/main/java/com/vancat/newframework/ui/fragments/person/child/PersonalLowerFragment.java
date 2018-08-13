package com.vancat.newframework.ui.fragments.person.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vancat.newframework.R;
import com.vancat.newframework.ui.base.BaseMVPCompatFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Vancat on 2018/8/13
 */
public class PersonalLowerFragment extends BaseMVPCompatFragment {

    @BindView(R.id.tv_btn_settings)
    TextView tvBtnSettings;
    @BindView(R.id.tv_btn_about)
    TextView tvBtnAbout;

    public static PersonalLowerFragment newInstance() {
        Bundle args = new Bundle();
        PersonalLowerFragment fragment = new PersonalLowerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_lower;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
    }
}
