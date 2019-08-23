package com.xiaoxiao.commoncore.Base

import com.xiaoxiao.commoncore.http.RetrofitHttpUtil
import retrofit2.Retrofit

import java.util.LinkedHashMap

class RepositoryManager : IRepositoryManager {

    private val mRetrofitCache = LinkedHashMap<String, Any?>(100, 0.75f, true)


    override fun <T> getRetrofitService(service: Class<T>): T? {
        var cacheService = mRetrofitCache[service.canonicalName] as T?
        if (cacheService == null) {
            cacheService = RetrofitHttpUtil.instance!!.create(service)
            mRetrofitCache[service.canonicalName] = cacheService
        }
        return cacheService
    }
}
