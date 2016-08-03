package com.zhuanche.zhuanche788.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.base.BaseActivity;
import com.zhuanche.zhuanche788.base.XHttpClient;
import com.zhuanche.zhuanche788.base.XHttpResponseHandler;
import com.zhuanche.zhuanche788.common.ApiManager;
import com.zhuanche.zhuanche788.common.UrlConfig;
import com.zhuanche.zhuanche788.model.UserModel;
import com.zhuanche.zhuanche788.utils.PreferencesUtils;
import com.zhuanche.zhuanche788.utils.TextUtil;
import com.zhuanche.zhuanche788.view.XEdittext;
import com.zhuanche.zhuanche788.view.XToast;

public class LoginActivity extends BaseActivity {
    private XEdittext mEditText, mEditText2;
    private LinearLayout ll_rember, ll_login;
    private Button mButton;
    private ImageView setting, icon_rember, icon_login;
    private Intent mIntent;
    private String phone, pw;

    @Override
    protected void initTopBar() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void initUi() {
        // TODO Auto-generated method stub
        setContentView(R.layout.activity_login);
        mEditText = findView(R.id.login_phone);
        mEditText2 = findView(R.id.login_paswword);
        ll_rember = findView(R.id.ll_rember);
        ll_login = findView(R.id.ll_login);
        mButton = findView(R.id.login_login);
        setting = findView(R.id.setting);
        icon_rember = findView(R.id.icon_rember);
        icon_login = findView(R.id.icon_login);
        mIntent = new Intent();
        //
        phone = PreferencesUtils.getString(this, "phone");
        mEditText.setText(phone);

        if (PreferencesUtils.getBoolean(this, "ll_rember")) {
            icon_rember.setSelected(true);
            pw = PreferencesUtils.getString(this, "pw");
            mEditText2.setText(pw);
        } else {
            icon_rember.setSelected(false);
        }
        if (PreferencesUtils.getBoolean(this, "ll_login")) {
            phone = PreferencesUtils.getString(this, "phone");
            pw = PreferencesUtils.getString(this, "pw");
            mEditText.setText(phone);
            mEditText2.setText(pw);
            Login();
            icon_login.setSelected(true);
        } else {
            icon_login.setSelected(false);
        }
        // mEditText.setText("13559655921");
        // mEditText2.setText("123456");
        // mEditText.setText("17757169048");
        // mEditText2.setText("123456");
    }

    @Override
    protected void initListener() {
        // TODO Auto-generated method stub
        mButton.setOnClickListener(this);
        ll_rember.setOnClickListener(this);
        ll_login.setOnClickListener(this);
        setting.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
        switch (v.getId()) {
            case R.id.login_login:
                // mIntent = new Intent(LoginActivity.this,
                // PingLunActivity.class);
                // startActivity(mIntent);
                Login();
                break;
            case R.id.login_forgetpasswrd:
                toforgetpassword();
                break;
            case R.id.ll_rember:
                setselect();
                break;
            case R.id.ll_login:
                setselect2();
                break;
            case R.id.setting:
                toforgetpassword();
                break;
            default:
                break;
        }
    }

    private void setselect2() {
        // TODO Auto-generated method stub
        if (PreferencesUtils.getBoolean(this, "ll_login")) {
            PreferencesUtils.putBoolean(this, "ll_login", false);
            icon_login.setSelected(false);
        } else {
            PreferencesUtils.putBoolean(this, "ll_login", true);
            icon_login.setSelected(true);
        }
    }

    private void setselect() {
        // TODO Auto-generated method stub

        if (PreferencesUtils.getBoolean(this, "ll_rember")) {
            PreferencesUtils.putBoolean(this, "ll_rember", false);
            icon_rember.setSelected(false);

        } else {
            PreferencesUtils.putBoolean(this, "ll_rember", true);
            icon_rember.setSelected(true);
        }

    }

    private void toforgetpassword() {
        // TODO Auto-generated method stub
        // mIntent = new Intent(LoginActivity.this, HomeActivity.class);
        // startActivity(mIntent);
        // XToast.show("shezhi");
//		mIntent = new Intent(this, SettingActivity.class);
//		startActivity(mIntent);
    }

    private void Login() {
        phone = mEditText.getText().toString();
        pw = mEditText2.getText().toString();
        PreferencesUtils.putString(this, "phone", phone);
        PreferencesUtils.putString(this, "pw", pw);
        loadingDialog.show();
        XHttpClient.apipost(UrlConfig.login, ApiManager.login(phone, pw),
                new XHttpResponseHandler() {
                    public void success(String responseBody) {
                        // TODO Auto-generated method stub
                        if (!TextUtil.isEmptyString(responseBody)) {
                            UserModel userModel = JSON.parseObject(responseBody, UserModel.class);
                            ApiManager.setUser(userModel);
                            ApiManager.setDriverTel(phone);
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                    }
                    @Override
                    public void onFinish() {
                        // TODO Auto-generated method stub
                        super.onFinish();
                        loadingDialog.dismiss();
                    }

                    @Override
                    public void onshowdialog() {
                        // TODO Auto-generated method stub
                        mLoadingDialog = loadingDialog;
                    }

                });

    }
}
