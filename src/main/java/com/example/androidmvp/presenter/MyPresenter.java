package com.example.androidmvp.presenter;

import android.view.View;

import com.example.androidmvp.bean.DengBean;
import com.example.androidmvp.model.MyModel;
import com.example.androidmvp.model.MyModelView;
import com.example.androidmvp.view.LogView;

/**
 * Created by Administrator on 2018/5/8.
 */

public class MyPresenter implements MyPresenterView{

    LogView logView;
    private final MyModelView myModelView;

    public MyPresenter(LogView logView){
        this.logView=logView;
        myModelView = new MyModel();
    }

    @Override
    public void setTime(DengBean bean) {
        logView.toBackView(bean);
    }

    public void setNet(String name, String pass) {
        myModelView.toModel(name,pass,this);
    }

    //解除
    @Override
    public void onDetory() {
        logView=null;
        System.gc();
    }
}
