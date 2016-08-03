package com.zhuanche.zhuanche788.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.base.BaseActivity;
import com.zhuanche.zhuanche788.common.ApiManager;
import com.zhuanche.zhuanche788.utils.TextUtil;
import com.zhuanche.zhuanche788.view.CircleImageView;

public class MainActivity extends BaseActivity {
    private TextView tv_phone;
    private CircleImageView iv_image;

    @Override
    protected void initTopBar() {

    }

    @Override
    protected void initUi() {
        setContentView(R.layout.activity_main);
        tv_phone=findView(R.id.activity_main_phone);
        iv_image=findView(R.id.activity_main_heart_iv);
        findView(R.id.activity_main_all_order).setOnClickListener(this);
        findView(R.id.activity_main_change_password).setOnClickListener(this);
        findView(R.id.activity_main_get_esc).setOnClickListener(this);
        findView(R.id.activity_main_get_order).setOnClickListener(this);
        findView(R.id.activity_main_infomation).setOnClickListener(this);
        findView(R.id.activity_main_sign).setOnClickListener(this);
        if (TextUtil.isEmptyString(ApiManager.getUser().getDriverObject().getMobile())) {
            tv_phone.setText("");
        }else {
            tv_phone.setText(  ApiManager.getUser().getDriverObject().getMobile());
        }
        if (TextUtil.isEmptyString(ApiManager.getUser().getDriverObject().getHeadimgurl())) {
//            Glide.with(this).load()
        }else {
            Glide.with(this).load(ApiManager.getUser().getDriverObject().getHeadimgurl()).into(iv_image);
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.activity_main_get_order:
                //接单;
                startActivity(new Intent(this,GetOrderActivity.class));
                break;
            case R.id.activity_main_sign:
                //签到
                startActivity(new Intent(this,SignActivity.class));
                break;
            case R.id.activity_main_all_order:
                //所有订单
                startActivity(new Intent(this,AllOrderActivity.class));
                break;
            case R.id.activity_main_infomation:
                //车主信息
                startActivity(new Intent(this,InfomationActivity.class));
                break;
            case R.id.activity_main_change_password:
                //密码修改
                startActivity(new Intent(this,ChangePasswordActivity.class));
                break;
            case R.id.activity_main_get_esc:
                //退出
                startActivity(new Intent(this,ExitActivity.class));
                break;
        }
    }
}
