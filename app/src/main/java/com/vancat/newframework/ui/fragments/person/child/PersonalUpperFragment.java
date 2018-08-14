package com.vancat.newframework.ui.fragments.person.child;

import android.os.Bundle;

import com.vancat.newframework.R;
import com.vancat.newframework.ui.base.BaseMVPCompatFragment;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Vancat on 2018/8/13
 */
public class PersonalUpperFragment extends BaseMVPCompatFragment {

    @BindView(R.id.civ_head)
    CircleImageView civHead;

    public static PersonalUpperFragment newInstance() {
        Bundle args = new Bundle();
        PersonalUpperFragment fragment = new PersonalUpperFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_upper;
    }

    @OnClick(R.id.civ_head)
    public void onViewClicked() {
//        mPresenter.btnHeadClicked();
    }
}
