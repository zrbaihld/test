package com.zhuanche.zhuanche788.activity;

import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.base.BaseActivity;

/**
 * Created by Administrator on 2016/8/3.
 */
public class InfomationActivity extends BaseActivity {
    @Override
    protected void initTopBar() {
        setTopBarLeftBack();
        topBarCenter.setText("我要接单");
    }

    @Override
    protected void initUi() {
        setContentView(R.layout.activity_getorder);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
