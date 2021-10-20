package com.kennie.android.base.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Kennie
 * @desc 描述
 */
public abstract class KennieBaseActivity extends AppCompatActivity {

    private int layoutResId = -1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KennieBaseApp.getPrivateInstance() == null) {
            KennieBaseApp.setPrivateInstance(getApplication());
        }
        setContentView(getLayoutId());
        initView();
        initData();
    }

    public abstract int getLayoutId();

    /**
     * initViews会在启动时首先执行，建议在此方法内进行布局绑定、View初始化等操作
     */
    public abstract void initView();


    /**
     * initData 会在布局加载后执行，建议在此方法内加载数据和处理布局显示数据
     *
     */
    public abstract void initData();
}
