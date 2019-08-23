package com.xiaoxiao.aichat.bean

class ChatResponse {

    /**
     * intent : {"code":10005,"intentName":"","actionName":"","parameters":{"nearby_place":"酒店"}}
     * results : [{"groupType":1,"resultType":"url","values":{"url":"http://m.elong.com/hotel/0101/nlist/#indate=2016-12-10&outdate=2016-12-11&keywords=%E4%BF%A1%E6%81%AF%E8%B7%AF"}},{"groupType":1,"resultType":"text","values":{"text":"亲，已帮你找到相关酒店信息"}}]
     */

    var intent: IntentBean? = null
    var results: List<ResultsBean>? = null

    class IntentBean {
        /**
         * code : 10005
         * intentName :
         * actionName :
         * parameters : {"nearby_place":"酒店"}
         */

        var code: Int = 0
        var intentName: String? = null
        var actionName: String? = null
        var parameters: ParametersBean? = null

        class ParametersBean {
            /**
             * nearby_place : 酒店
             */

            var nearby_place: String? = null
        }
    }

    class ResultsBean {
        /**
         * groupType : 1
         * resultType : url
         * values : {"url":"http://m.elong.com/hotel/0101/nlist/#indate=2016-12-10&outdate=2016-12-11&keywords=%E4%BF%A1%E6%81%AF%E8%B7%AF"}
         */

        var groupType: Int = 0
        var resultType: String? = null
        var values: ValuesBean? = null

        class ValuesBean {
            /**
             * url : http://m.elong.com/hotel/0101/nlist/#indate=2016-12-10&outdate=2016-12-11&keywords=%E4%BF%A1%E6%81%AF%E8%B7%AF
             */

            var url: String? = null
            var text: String? = null
        }
    }
}
