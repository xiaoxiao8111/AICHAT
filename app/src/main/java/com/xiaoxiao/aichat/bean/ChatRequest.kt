package com.xiaoxiao.aichat.bean

class ChatRequest {

    /**
     * reqType : 0
     * perception : {"inputText":{"text":"附近的酒店"},"inputImage":{"url":"imageUrl"},"selfInfo":{"location":{"city":"北京","province":"北京","street":"信息路"}}}
     * userInfo : {"apiKey":"","userId":""}
     */

    var reqType: Int = 0
    var perception: PerceptionBean? = null
    var userInfo: UserInfoBean? = null

    class PerceptionBean {
        /**
         * inputText : {"text":"附近的酒店"}
         * inputImage : {"url":"imageUrl"}
         * selfInfo : {"location":{"city":"北京","province":"北京","street":"信息路"}}
         */

        var inputText: InputTextBean? = null
        var inputImage: InputImageBean? = null
        var selfInfo: SelfInfoBean? = null

        class InputTextBean {
            /**
             * text : 附近的酒店
             */

            var text: String? = null
        }

        class InputImageBean {
            /**
             * url : imageUrl
             */

            var url: String? = null

        }

        class SelfInfoBean {
            /**
             * location : {"city":"北京","province":"北京","street":"信息路"}
             */

            var location: LocationBean? = null

            class LocationBean {
                /**
                 * city : 北京
                 * province : 北京
                 * street : 信息路
                 */

                var city: String? = null
                var province: String? = null
                var street: String? = null
            }
        }
    }

    class UserInfoBean {
        /**
         * apiKey :
         * userId :
         */

        var apiKey: String? = null
        var userId: String? = null
    }
}
