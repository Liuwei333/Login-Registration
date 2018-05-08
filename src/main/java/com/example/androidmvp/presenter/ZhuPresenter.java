package com.example.androidmvp.presenter;

import android.view.View;

import com.example.androidmvp.bean.ZhuBean;
import com.example.androidmvp.model.MyModel;
import com.example.androidmvp.model.MyModelView;
import com.example.androidmvp.model.ZhuModel;
import com.example.androidmvp.model.ZhuModelView;
import com.example.androidmvp.view.ZhuView;

/**
 * Created by Administrator on 2018/5/8.
 */

public class ZhuPresenter implements ZhuPresenterView {

    public ZhuView zhuView;
    public final ZhuModelView myModelView;

    public  ZhuPresenter(ZhuView zhuView){
        this.zhuView=zhuView;
        myModelView = new ZhuModel();
    }

    @Override
    public void toPresenter(ZhuBean value) {
        zhuView.toBackView(value);
    }

    @Override
    public void setNet(String s, String s1) {
        myModelView.toZhuModel(s,s1,this);
    }

    @Override
    public void onDestory() {
        zhuView=null;
        System.gc();
    }
}
