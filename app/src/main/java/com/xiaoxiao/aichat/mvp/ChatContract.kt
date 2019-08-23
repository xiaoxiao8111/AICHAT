package com.xiaoxiao.aichat.mvp

import com.xiaoxiao.aichat.bean.ChatRequest
import com.xiaoxiao.aichat.bean.ChatResponse
import com.xiaoxiao.commoncore.Base.IModel
import com.xiaoxiao.commoncore.Base.IPresenter
import com.xiaoxiao.commoncore.Base.IView
import io.reactivex.Observable

interface ChatContract {

    interface View : IView {
        fun requestSuccess(chatResponse: ChatResponse)

        fun requestFailure(message: String?)
    }

    interface Model : IModel {
        fun request(chatRequest: ChatRequest): Observable<*>
    }

    interface Presnter : IPresenter {
        fun request(type: Int, text: String?, imgUrl: String?, city: String?, province: String?, street: String?)
    }
}
