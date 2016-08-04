package com.justwayward.reader.ui.presenter;

import android.content.Context;
import android.widget.Toast;

import com.justwayward.reader.api.BookApi;
import com.justwayward.reader.bean.Recommend;
import com.justwayward.reader.ui.contract.MainContract;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author yuyh.
 * @date 2016/8/3.
 */
public class MainActivityPresenter implements MainContract.Presenter {

    private Context context;
    private BookApi bookApi;

    @Inject
    public MainActivityPresenter(Context context, BookApi bookApi) {
        this.context = context;
        this.bookApi = bookApi;
    }

    public void getPlayerList() {
        bookApi.getRecommend("male").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Recommend>() {
                    @Override
                    public void onNext(Recommend recommend) {

                    }

                    @Override
                    public void onCompleted() {
                        Toast.makeText(context, "请求完成", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
