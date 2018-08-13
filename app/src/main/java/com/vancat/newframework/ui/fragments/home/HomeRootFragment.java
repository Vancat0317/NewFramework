package com.vancat.newframework.ui.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vancat.newframework.R;
import com.vancat.newframework.ui.base.BaseMVPCompatFragment;
import com.vancat.newframework.utils.StatusBarUtils;
import com.vancat.newframework.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Vancat on 2018/8/10
 */
public class HomeRootFragment extends BaseMVPCompatFragment {

    protected HomeRootFragment.OnOpenDrawerLayoutListener onOpenDrawerLayoutListener;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabs;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.vp_fragment)
    ViewPager vpFragment;
    @BindView(R.id.fab_download)
    FloatingActionButton fabDownload;
    @BindView(R.id.home_container)
    CoordinatorLayout homeContainer;

    public static HomeRootFragment newInstance() {
        Bundle args = new Bundle();
        HomeRootFragment fragment = new HomeRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof HomeRootFragment.OnOpenDrawerLayoutListener) {
            onOpenDrawerLayoutListener = (HomeRootFragment.OnOpenDrawerLayoutListener) context;
        }
//        fragments = new ArrayList<>();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onOpenDrawerLayoutListener = null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        toolbar = view.findViewById(R.id.toolbar);
        StatusBarUtils.fixToolbar(toolbar,this.mActivity);
        toolbar.setTitle("首页");
        toolbar.setNavigationIcon(R.drawable.ic_vector_drawer_home);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onOpenDrawerLayoutListener != null) {
                    onOpenDrawerLayoutListener.onOpen();
                }
            }
        });
        fabDownload = view.findViewById(R.id.fab_download);
        fabDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("点了我");
            }
        });
    }

    /**
     * fragment打开DrawerLayout监听
     */
    public interface OnOpenDrawerLayoutListener {
        void onOpen();
    }
}
