package com.example.androidmvp.presenter;

import android.widget.EditText;

import com.example.androidmvp.bean.DengBean;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface MyPresenterView {
    void setTime(DengBean bean);

    void setNet(String name, String pass);

    void onDetory();
}
