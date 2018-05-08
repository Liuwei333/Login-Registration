package com.example.androidmvp.presenter;

import com.example.androidmvp.bean.ZhuBean;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface ZhuPresenterView {
    void toPresenter(ZhuBean value);

    void setNet(String s, String s1);

    void onDestory();
}
