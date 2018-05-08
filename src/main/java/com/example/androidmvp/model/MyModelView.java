package com.example.androidmvp.model;

import com.example.androidmvp.presenter.MyPresenterView;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface MyModelView {
    void toModel(String name, String pass, MyPresenterView presenterView);
}
