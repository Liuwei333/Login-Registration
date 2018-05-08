package com.example.androidmvp.model;

import com.example.androidmvp.bean.ZhuBean;
import com.example.androidmvp.presenter.ZhuPresenterView;
import com.example.androidmvp.utils.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/8.
 */

public class ZhuModel implements ZhuModelView {
    @Override
    public void toZhuModel(String name, String pass, final ZhuPresenterView presenterView) {

        Observable<ZhuBean> zhuBeanObservable = HttpUtils.getInstance().getApi().doZhu(name, pass);
        zhuBeanObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ZhuBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ZhuBean value) {

                presenterView.toPresenter(value);
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
