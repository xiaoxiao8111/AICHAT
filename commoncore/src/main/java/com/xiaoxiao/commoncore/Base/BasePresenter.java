package com.xiaoxiao.commoncore.Base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<View extends IView, Model extends IModel> implements IPresenter {

    protected View mView;

    protected Model mModel;

    private CompositeDisposable mCompositeDisposable;

    public BasePresenter(View view, Model model) {
        this.mView = view;
        this.mModel = model;
    }

    protected void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    private void removeDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void onDestory() {
        removeDispose();
        mModel.onDestroy();
        mView = null;
        mModel = null;
        mCompositeDisposable = null;
    }
}
