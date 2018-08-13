package com.vancat.newframework.ui.fragments.person;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.vancat.newframework.R;
import com.vancat.newframework.ui.base.BaseCompatFragment;
import com.vancat.newframework.ui.fragments.person.child.PersonalLowerFragment;
import com.vancat.newframework.ui.fragments.person.child.PersonalUpperFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Vancat on 2018/8/10
 */
public class PersonalRootFragment extends BaseCompatFragment {

    @BindView(R.id.fl_personal_container_upper)
    FrameLayout flPersonalContainerUpper;
    @BindView(R.id.fl_personal_container_lower)
    FrameLayout flPersonalContainerLower;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static PersonalRootFragment newInstance() {
        Bundle args = new Bundle();
        PersonalRootFragment fragment = new PersonalRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        //Logger.e("onLazyInitView");
        //加载子fragment
        if (savedInstanceState == null) {
            loadFragment();
        } else {  // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
            if (findChildFragment(PersonalUpperFragment.class) == null) {
                loadFragment();
            }
        }
    }

    private void loadFragment() {
        loadRootFragment(R.id.fl_personal_container_upper, PersonalUpperFragment.newInstance());
        loadRootFragment(R.id.fl_personal_container_lower, PersonalLowerFragment.newInstance());
    }
}
