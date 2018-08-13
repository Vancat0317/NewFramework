package com.vancat.newframework.ui.widgets;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Vancat on 2018/8/10
 */
public class WaitProgressDialog extends ProgressDialog {

    public WaitProgressDialog(Context context) {
        this(context,0);
    }

    public WaitProgressDialog(Context context, int theme) {
        super(context, theme);
        //设置是否允许外部点击取消
        setCanceledOnTouchOutside(false);
    }
}
