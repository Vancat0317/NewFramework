package com.vancat.newframework.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Vancat on 2018/8/8
 *
 * RxManager 管理订阅的注册和取消
 */
public class RxManager {

    // 管理订阅者者
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    //订阅
    public void register(Disposable d) {
        mCompositeDisposable.add(d);
    }

    // 取消订阅
    public void unSubscribe() {
        mCompositeDisposable.dispose();
    }
}
