package com.xiaoxiao.aichat.http

import com.xiaoxiao.aichat.bean.ChatRequest
import com.xiaoxiao.aichat.bean.ChatResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface ChatService{

    @POST("openapi/api/v2")
    abstract fun chatRequest(
        @Body chatRequest:ChatRequest
    ): Observable<ChatResponse>

}
