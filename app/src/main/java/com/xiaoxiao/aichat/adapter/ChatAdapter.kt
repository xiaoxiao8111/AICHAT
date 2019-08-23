package com.xiaoxiao.aichat.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.xiaoxiao.aichat.R
import com.xiaoxiao.aichat.bean.ChatBean
import com.xiaoxiao.commoncore.http.HttpConfig
import com.xiaoxiao.commoncore.utils.GlideUtils

class ChatAdapter(data: MutableList<ChatBean>?) : BaseMultiItemQuickAdapter<ChatBean, BaseViewHolder>(data) {

    companion object {
        val CHAT_ROBOT = 1
        val CHAT_USER = 2
    }

    init {
        addItemType(CHAT_ROBOT, R.layout.item_left_chat)
        addItemType(CHAT_USER, R.layout.item_right_chat)
    }

    override fun convert(helper: BaseViewHolder, item: ChatBean) {
        helper.setText(R.id.tv_chat,item.content)
            .setText(R.id.tv_time,item.time)
        var ivHead = helper.getView<ImageView>(R.id.iv_head)
        var url = HttpConfig.ROBOT_URL
        if(item.type == CHAT_ROBOT){
           url =  HttpConfig.HEAD_URL
        }
        GlideUtils.loadRoundedCenterCropUrl(mContext,ivHead,url,15)
    }
  

}