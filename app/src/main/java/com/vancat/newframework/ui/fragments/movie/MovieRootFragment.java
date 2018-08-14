package com.vancat.newframework.ui.fragments.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.vancat.newframework.R;
import com.vancat.newframework.contract.book.BookMainContract;
import com.vancat.newframework.ui.base.BasePresenter;
import com.vancat.newframework.ui.base.BaseCompatFragment;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Vancat on 2018/8/10
 */
public class MovieRootFragment extends BaseCompatFragment<BasePresenter<BookMainContract.IBookMainModel, BookMainContract.IBookMainView>> {

    public static SupportFragment newInstance() {
        Bundle args = new Bundle();
        SupportFragment fragment = new SupportFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }


}
