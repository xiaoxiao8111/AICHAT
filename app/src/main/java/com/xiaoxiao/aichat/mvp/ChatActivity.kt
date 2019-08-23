package com.xiaoxiao.aichat.mvp

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.View
import com.xiaoxiao.aichat.adapter.ChatAdapter
import com.xiaoxiao.aichat.adapter.ChatAdapter.Companion.CHAT_ROBOT
import com.xiaoxiao.aichat.adapter.ChatAdapter.Companion.CHAT_USER
import com.xiaoxiao.aichat.bean.ChatBean
import com.xiaoxiao.aichat.bean.ChatResponse
import com.xiaoxiao.commoncore.Base.BaseActivity
import com.xiaoxiao.commoncore.Base.RepositoryManager
import kotlinx.android.synthetic.main.activity_chat.*
import java.sql.Date
import java.text.SimpleDateFormat


class ChatActivity : BaseActivity<ChatContract.Presnter>(), ChatContract.View, View.OnClickListener {

    private var chatAdapter: ChatAdapter = ChatAdapter(null)
    private var chatArray: MutableList<ChatBean> = mutableListOf()

    override fun getLayoutId(): Int {
        return com.xiaoxiao.aichat.R.layout.activity_chat
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        presenter = ChatPresenter(this, ChatModel(RepositoryManager()))
    }

    private fun initView() {
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_chat.layoutManager = linearLayoutManager
        rv_chat.adapter = chatAdapter
        btn_send.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            com.xiaoxiao.aichat.R.id.btn_send -> {
                /**
                 * 1，获取输入框的内容
                 * 2，判断是否为空
                 * 3，发送后清空当前的输入框
                 */
//              1,获取输入框的内容
                val text = et_text.text
//              2,判断是否为空
                if (!TextUtils.isEmpty(text)) {
                    var chatBean = ChatBean(CHAT_USER, changeTime(), text.toString())
                    chatArray.add(chatBean)
                    chatAdapter.setNewData(chatArray)
                    //这里假装已经发送了数据，清空输入框
                    presenter.request(0, text.toString(), null, null, null, null)
                    et_text.setText("")
                }
                chatAdapter.setNewData(chatArray)
            }
        }
    }

    override fun requestSuccess(chatResponse: ChatResponse) {
        val mText = chatResponse.results!![0].values!!.text
        var chatBean = ChatBean(CHAT_ROBOT, changeTime(), mText)
        chatArray.add(chatBean)
        chatAdapter.setNewData(chatArray)
    }

    override fun requestFailure(message: String?) {
        et_text.setText(message)
    }

    fun changeTime(): String {
        val simpleDateFormat = SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss")
        val date = Date(System.currentTimeMillis())
        val time = simpleDateFormat.format(date)
        return time
    }


}