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
public class AllOrderActivity extends BaseActivity {
    private int page,pageSize=10;
    @Override
    protected void initTopBar() {
        setTopBarLeftBack();
        topBarCenter.setText("全部订单");
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
        XHttpClient.apiPost(UrlConfig.queryDriverOrders, ApiManager.queryDriverOrders("","","","",page+"",pageSize+""), new XHttpResponseHandler() {
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
