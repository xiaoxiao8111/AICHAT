package com.xiaoxiao.aichat.mvp

import com.xiaoxiao.aichat.bean.ChatRequest
import com.xiaoxiao.aichat.http.ChatService
import com.xiaoxiao.commoncore.Base.BaseModel
import com.xiaoxiao.commoncore.Base.IRepositoryManager
import io.reactivex.Observable

class ChatModel(manager: IRepositoryManager) : BaseModel(manager), ChatContract.Model {

    override fun request(chatRequest: ChatRequest): Observable<*> {
        return manager.getRetrofitService(ChatService::class.java)
            .chatRequest(chatRequest)
    }
}
