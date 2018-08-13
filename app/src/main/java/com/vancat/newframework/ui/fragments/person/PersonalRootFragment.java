package com.vancat.newframework.ui.fragments.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.vancat.newframework.R;
import com.vancat.newframework.ui.base.BaseCompatFragment;

/**
 * Created by Vancat on 2018/8/10
 */
public class PersonalRootFragment extends BaseCompatFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    public static PersonalRootFragment newInstance() {
        Bundle args = new Bundle();
        PersonalRootFragment fragment = new PersonalRootFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
