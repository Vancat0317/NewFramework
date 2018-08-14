package com.vancat.newframework.presenter.book;

import android.support.annotation.NonNull;

import com.vancat.newframework.contract.book.BookMainContract;
import com.vancat.newframework.model.book.BookMainModel;

/**
 * Created by Vancat on 2018/8/14
 */
public class BookMainPresenter extends BookMainContract.BookMainPresenter {

    @NonNull
    public static BookMainPresenter newInstance() {
        return new BookMainPresenter();
    }

    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;

//        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected BookMainContract.IBookMainModel getModel() {
        return BookMainModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
