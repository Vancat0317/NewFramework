package com.vancat.newframework.contract.book;

import com.vancat.newframework.ui.base.IBaseModel;
import com.vancat.newframework.ui.base.BasePresenter;
import com.vancat.newframework.ui.base.IBaseFragment;

/**
 * Created by Vancat on 2018/8/14
 */
public interface BookMainContract {

    //book主页接口
    abstract class BookMainPresenter extends BasePresenter<IBookMainModel, IBookMainView> {
        public abstract void getTabList();
    }

    interface IBookMainModel extends IBaseModel {
        String[] getTabs();
    }

    interface IBookMainView extends IBaseFragment {
        void showTabList(String[] tabs);
    }

}
