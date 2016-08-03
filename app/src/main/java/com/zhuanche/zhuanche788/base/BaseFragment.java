package com.zhuanche.zhuanche788.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.utils.LogUtil;
import com.zhuanche.zhuanche788.view.TextImageButton;


public abstract class BaseFragment extends Fragment implements OnClickListener {

    private String className = getClass().getName();
    public View rootView;
    public TextView toptext;
    public TextImageButton topBarLeft, topBarRight, topBarCenter;

    @Override
    public void onAttach(Activity activity) {
        LogUtil.i("onAttach , " + className);
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        LogUtil.i("onDetach , " + className);
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return initContentView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        // if (savedInstanceState != null) {
        // return;
        // }
        LogUtil.i("onCreateView , " + className);
//        if (rootView == null) {
            rootView = getView();
            initView();
            initTopBar();
            initUi();
            setListener();
            initData();
//        } else {
//            if (rootView.getParent() != null) {
//                ((ViewGroup) rootView.getParent()).removeView(rootView);
//            }
//        }

    }

    protected abstract View initContentView();

    protected abstract void initUi();

    protected void initData() {

    }

    protected void setListener() {

    }

    /**
     * 顶部工具�?
     */
    protected abstract void initTopBar();

    private void initView() {
        View top_bar_container = findViewById(R.id.top_bar_container);
        if (top_bar_container != null) {
            topBarLeft = (TextImageButton) rootView
                    .findViewById(R.id.top_bar_left);
            topBarRight = (TextImageButton) rootView
                    .findViewById(R.id.top_bar_right);
            topBarCenter = (TextImageButton) rootView
                    .findViewById(R.id.top_bar_center);
            topBarLeft.setOnClickListener(this);
            topBarRight.setOnClickListener(this);
            topBarCenter.setOnClickListener(this);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(int resId) {
        return (T) rootView.findViewById(resId);
    }

    public View inflateView(int layoutId) {
        return getActivity().getLayoutInflater().inflate(layoutId, null);
    }

    /**
     * 获取主界�?
     * 
     * @return
     */
//    public MainParentsActivity getMainParentsActivity() {
//        if (this.getActivity() instanceof MainParentsActivity) {
//            return (MainParentsActivity) getActivity();
//        }
//        return null;
//    }
//
//    public MainTeacherActivity getMainTeacherActivity() {
//        if (this.getActivity() instanceof MainTeacherActivity) {
//            return (MainTeacherActivity) getActivity();
//        }
//        return null;
//    }

//    /**
//     * 获取FlowActivity
//     * 
//     * @return
//     */
//    public FlowActivity getFlowActivity() {
//        if (this.getActivity() instanceof FlowActivity) {
//            return (FlowActivity) getActivity();
//        }
//        return null;
//    }
//
//    /**
//     * 获取FlowActivity
//     * 
//     * @return
//     */
//    public MainPrinicpalActivity getMainPrinicpalActivity() {
//        if (this.getActivity() instanceof MainPrinicpalActivity) {
//            return (MainPrinicpalActivity) getActivity();
//        }
//        return null;
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.top_bar_left:
            topbarleft();
            break;
        case R.id.top_bar_right:
            topbarright();
            break;
        case R.id.top_bar_center:
            break;

        default:
            break;
        }
    }

    public void topbarright() {
        // TODO Auto-generated method stub

    }

    public void topbarleft() {
        // TODO Auto-generated method stub

    }

    /**
     * 结束parent activity
     */
    public void finish() {
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        LogUtil.e("onDestroyView , " + className);
        super.onDestroyView();
    }

    public void e(String msg) {
        LogUtil.e(msg);
    }

    public void i(String msg) {
        LogUtil.i(msg);
    }

}
