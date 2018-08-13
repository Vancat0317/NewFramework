package com.vancat.newframework.ui.fragments.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.vancat.newframework.R;
import com.vancat.newframework.ui.base.BaseCompatFragment;

/**
 * Created by Vancat on 2018/8/10
 */
public class BookRootFragment extends BaseCompatFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_book;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    public static BookRootFragment newInstance() {
        Bundle args = new Bundle();
        BookRootFragment fragment = new BookRootFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
