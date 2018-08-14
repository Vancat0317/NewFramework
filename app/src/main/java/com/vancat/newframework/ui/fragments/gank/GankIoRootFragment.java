package com.vancat.newframework.ui.fragments.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.vancat.newframework.R;
import com.vancat.newframework.contract.book.BookMainContract;
import com.vancat.newframework.ui.base.BasePresenter;
import com.vancat.newframework.ui.base.BaseCompatFragment;


/**
 * Created by Vancat on 2018/8/10
 */
public class GankIoRootFragment extends BaseCompatFragment<BasePresenter<BookMainContract.IBookMainModel, BookMainContract.IBookMainView>> {

    public static GankIoRootFragment newInstance() {
        Bundle args = new Bundle();
        GankIoRootFragment fragment = new GankIoRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }
}
