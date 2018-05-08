package com.example.androidmvp.model;

import com.example.androidmvp.presenter.ZhuPresenterView;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface ZhuModelView {
    void toZhuModel(String name, String pass, ZhuPresenterView presenterView);
}
