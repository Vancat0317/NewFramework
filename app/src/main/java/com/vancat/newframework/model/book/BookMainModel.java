package com.vancat.newframework.model.book;

import android.support.annotation.NonNull;

import com.vancat.newframework.contract.book.BookMainContract;
import com.vancat.newframework.ui.base.BaseModel;

/**
 * Created by Vancat on 2018/8/14
 */
public class BookMainModel extends BaseModel implements BookMainContract.IBookMainModel {
    @NonNull
    public static BookMainModel newInstance() {
        return new BookMainModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"文学", "文化", "生活"};
    }

}
