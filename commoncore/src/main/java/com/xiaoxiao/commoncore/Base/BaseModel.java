package com.xiaoxiao.commoncore.Base;

public class BaseModel implements IModel {

    protected IRepositoryManager manager;

    public BaseModel(IRepositoryManager manager) {
        this.manager = manager;
    }

    @Override
    public void onDestroy() {
        manager = null;
    }
}
