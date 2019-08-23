package com.xiaoxiao.commoncore.http

import com.xiaoxiao.commoncore.BuildConfig
import com.xiaoxiao.commoncore.http.RetrofitHttpUtil.Companion.mInstance
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

class RetrofitHttpUtil private constructor() {

    private var mRetrofit: Retrofit? = null

    init {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout(HttpConfig.HTTP_TIME.toLong(), TimeUnit.SECONDS)
            .readTimeout(HttpConfig.HTTP_TIME.toLong(), TimeUnit.SECONDS)
            .writeTimeout(HttpConfig.HTTP_TIME.toLong(), TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }
        mRetrofit = Retrofit.Builder()
            .baseUrl(HttpConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
            .client(builder.build())
            .build()
    }

    companion object {

        @Volatile
        private var mInstance: RetrofitHttpUtil? = null

        val instance: Retrofit?
            get() {
                if (mInstance == null) {
                    synchronized(RetrofitHttpUtil::class.java) {
                        if (mInstance == null)
                            mInstance = RetrofitHttpUtil()
                    }
                }
                return mInstance!!.mRetrofit
            }
    }
}
