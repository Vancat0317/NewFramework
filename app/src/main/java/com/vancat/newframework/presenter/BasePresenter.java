package com.vancat.newframework.presenter;

import android.support.annotation.NonNull;

import com.vancat.newframework.base.RxManager;

/**
 * Created by Vancat on 2018/8/10
 */
public abstract class BasePresenter<M, V> {

    protected M mIModel;
    protected V mIView;
    protected RxManager mRxManager = new RxManager();

    /**
     * 返回presenter想持有的Model引用
     *
     * @return presenter持有的Model引用
     */
    protected abstract M getModel();

    /**
     * 绑定IModel和IView的引用
     *
     * @param v view
     */
    public void attachMV(@NonNull V v) {
        this.mIModel = getModel();
        this.mIView = v;
        this.onStart();
    }

    /**
     * 解绑IModel和IView
     */
    public void detachMV() {
        mRxManager.unSubscribe();
        mIView = null;
        mIModel = null;
    }

    /**
     * IView和IModel绑定完成立即执行
     * <p>
     * 实现类实现绑定完成后的逻辑,例如数据初始化等,界面初始化, 更新等
     */
    public abstract void onStart();
}
