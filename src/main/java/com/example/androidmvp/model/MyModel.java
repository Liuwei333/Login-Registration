package com.example.androidmvp.model;

import com.example.androidmvp.bean.DengBean;
import com.example.androidmvp.presenter.MyPresenterView;
import com.example.androidmvp.utils.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/8.
 */

public class MyModel implements MyModelView{
    @Override
    public void toModel(String name, String pass, final MyPresenterView presenterView) {

        Observable<DengBean> dengBeanObservable = HttpUtils.getInstance().getApi().doGet(name, pass);
        dengBeanObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<DengBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(DengBean value) {


                presenterView.setTime(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
