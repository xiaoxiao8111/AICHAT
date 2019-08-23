package com.xiaoxiao.aichat.mvp

import com.xiaoxiao.aichat.bean.ChatRequest
import com.xiaoxiao.aichat.bean.ChatResponse
import com.xiaoxiao.commoncore.Base.BasePresenter
import com.xiaoxiao.commoncore.http.HttpConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class ChatPresenter(view: ChatContract.View, model: ChatContract.Model) :
    BasePresenter<ChatContract.View, ChatContract.Model>(view, model), ChatContract.Presnter {

    override fun request(type: Int,text: String?, imgUrl: String?, city: String?, province: String?, street: String?) {
        val request = ChatRequest()
        val info = ChatRequest.UserInfoBean()
        val perceptionBean = ChatRequest.PerceptionBean()
        info.apiKey = HttpConfig.TULING_API_KEY
        info.userId = HttpConfig.USER_ID
        request.userInfo = info
        val pre = ChatRequest.PerceptionBean.InputTextBean()
        pre.text = text
        perceptionBean.inputText = pre
        request.perception = perceptionBean

        //map返回的是原始类型，flatMap返回的是观察者对象
        addDispose(
            mModel!!.request(request)
            .doOnSubscribe { disposable -> mView!!.showLoading() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer{ o -> mView!!.requestSuccess(o as ChatResponse) },
                Consumer { throwable -> mView!!.requestFailure(throwable.message) })
        )
    }
}
