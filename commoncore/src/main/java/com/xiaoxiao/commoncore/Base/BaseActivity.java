package com.xiaoxiao.commoncore.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends IPresenter> extends AppCompatActivity implements IView {

    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFailure() {

    }

    @Override
    public void showEmpty() {

    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestory();
    }
}
