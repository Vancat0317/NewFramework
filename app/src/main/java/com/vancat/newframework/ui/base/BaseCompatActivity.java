package com.vancat.newframework.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.vancat.newframework.R;
import com.vancat.newframework.base.AppManager;
import com.vancat.newframework.global.GlobalApplication;
import com.vancat.newframework.utils.AppUtils;
import com.vancat.newframework.utils.SpUtils;
import com.vancat.newframework.utils.StatusBarUtils;
import com.vancat.newframework.utils.ThemeUtils;
import com.vancat.newframework.ui.widgets.WaitProgressDialog;

import java.util.Objects;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by Vancat on 2018/8/9
 *
 * Activity积累基类
 */
public abstract class BaseCompatActivity extends SupportActivity {

    protected GlobalApplication mApplication;
    protected WaitProgressDialog mWaitProgressDialog;
    protected Context mContext;//全局上下文对象
    protected boolean isTransAnim;

    static {
        //5.0以下兼容vector
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    public void finish() {
        super.finish();
        if (isTransAnim) {
            overridePendingTransition(R.anim.activity_start_zoom_in,R.anim.activity_start_zoom_out);
        }
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        //fragment切换默认使用Vertical动画
        return new DefaultVerticalAnimator();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                View view = getCurrentFocus();
                //调用方法判断是否需要隐藏键盘
                AppUtils.hideKeyboard(ev, view, this);
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 初始化状态栏 等
     * @param savedInstanceState savedInstanceState
     */
    private void init(Bundle savedInstanceState) {
        setTheme(ThemeUtils.themeArr[SpUtils.getThemeIndex(this)][
                SpUtils.getNightModel(this) ? 1 : 0]);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        StatusBarUtils.setTransparent(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initData();
        initView(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    /**
     * 初始化数据
     * 子类可以复写此方法初始化子类数据
     */
    private void initData() {
        mContext = AppUtils.getContext();
        mApplication = (GlobalApplication) getApplication();
        mWaitProgressDialog = new WaitProgressDialog(this);
        isTransAnim = true;
    }

    /**
     * 初始化View
     * 子类实现 控件绑定、视图初始化等内容
     *
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 设置布局ID
     * 由子类实现
     * @return 布局ID
     */
    protected abstract int getLayoutId();

    /**
     * 显示提示框
     * @param msg 提示框内容
     */
    protected  void showProgressDialog(String msg) {
        mWaitProgressDialog.setMessage(msg);
        mWaitProgressDialog.show();
    }

    /**
     * 关闭提示框
     */
    protected void hideProgressDialog() {
        if (mWaitProgressDialog != null) {
            mWaitProgressDialog.dismiss();
        }
    }

    /**
     * 直接Activity跳转
     * @param clz 要跳转的Activity
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
        if (isTransAnim) {
            //重写activity的进出动画
            overridePendingTransition(R.anim.activity_start_zoom_in,R.anim.activity_start_zoom_out);
        }
    }

    /**
     * 自定义Intent跳转
     * @param clz 要跳转的Activity
     * @param intent intent
     */
    public void startActivity(Class<?> clz, Intent intent) {
        intent.setClass(this, clz);
        startActivity(intent);
        if (isTransAnim) {
            overridePendingTransition(R.anim.activity_start_zoom_in, R.anim.activity_start_zoom_out);
        }
    }

    /**
     * 携带数据的页面跳转
     * @param clz 要跳转的Activity
     * @param bundle bundle数据
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this,clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (isTransAnim) {
            overridePendingTransition(R.anim.activity_start_zoom_in, R.anim.activity_start_zoom_out);
        }
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param clz         要跳转的Activity
     * @param bundle      bundle数据
     * @param requestCode requestCode
     */
    public void startActivityForResult(Class<?> clz, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
        if (isTransAnim)
            overridePendingTransition(R.anim.activity_start_zoom_in, R.anim
                    .activity_start_zoom_out);
    }

    /**
     * 隐藏键盘
     *
     * @return  键盘隐藏结果
     * true 隐藏成功
     * false 隐藏失败
     */
    protected boolean hiddenKeyboard() {
        //点击空白地方 隐藏软键盘
        InputMethodManager methodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        return methodManager != null && methodManager.hideSoftInputFromWindow(Objects.requireNonNull(this.getCurrentFocus()).getWindowToken(), 0);
    }

    /**
     * 初始化标题栏
     */
    protected void initTitleBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    /**
     * 检测是否使用过渡动画
     */
    protected boolean isTransAnim() {
        return isTransAnim;
    }

    /**
     * 设置是否使用过渡动画
     * @param b b
     */
    protected void setIsTransAnim(boolean b) {
        isTransAnim = b;
    }
}
