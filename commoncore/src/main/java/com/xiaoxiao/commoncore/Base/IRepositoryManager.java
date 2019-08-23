package com.xiaoxiao.commoncore.Base;

public interface IRepositoryManager {
    <T> T getRetrofitService(Class<T> service);
}
