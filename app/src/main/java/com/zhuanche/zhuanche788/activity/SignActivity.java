package com.zhuanche.zhuanche788.activity;

import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.base.BaseActivity;
import com.zhuanche.zhuanche788.base.XHttpClient;
import com.zhuanche.zhuanche788.base.XHttpResponseHandler;
import com.zhuanche.zhuanche788.common.ApiManager;
import com.zhuanche.zhuanche788.common.UrlConfig;

/**
 * Created by Administrator on 2016/8/3.
 */
public class SignActivity extends BaseActivity {
    @Override
    protected void initTopBar() {
        setTopBarLeftBack();
        topBarCenter.setText("签到");
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
        XHttpClient.apiPost(UrlConfig.updateDriverSign, ApiManager.updateDriverSign(), new XHttpResponseHandler() {
            @Override
            public void onshowdialog() {
                mLoadingDialog = loadingDialog;
            }

            @Override
            public void success(String responseBody) {
                super.success(responseBody);
            }
        });
    }
}
