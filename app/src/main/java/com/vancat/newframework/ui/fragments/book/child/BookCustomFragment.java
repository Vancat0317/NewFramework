package com.vancat.newframework.ui.fragments.book.child;

import android.os.Bundle;

import com.vancat.newframework.ui.base.BaseMVPCompatFragment;

import static com.vancat.newframework.constant.BundleKeyConstant.ARG_KEY_DOUBAN_BOOK_TAGS;

/**
 * Created by Vancat on 2018/8/14
 */
public class BookCustomFragment extends BaseMVPCompatFragment {

    public static BookCustomFragment newInstance(String bookTags) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY_DOUBAN_BOOK_TAGS, bookTags);
        BookCustomFragment fragment = new BookCustomFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
