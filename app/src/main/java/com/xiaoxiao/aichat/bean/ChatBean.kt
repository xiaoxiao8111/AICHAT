package com.xiaoxiao.aichat.bean

import com.chad.library.adapter.base.entity.MultiItemEntity

class ChatBean : MultiItemEntity {

    var content: String? = ""
    var time: String = ""
    var type: Int = 0

    constructor(type:Int, time: String, content: String?){
        this.type = type
        this.time = time
        this.content = content
    }
    override fun getItemType(): Int {
        return type
    }


}