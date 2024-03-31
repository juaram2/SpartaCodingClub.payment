package kr.spartacodingclub.payment

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.navercorp.nid.NaverIdLoginSDK

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        val OAUTH_CLIENT_ID = "8cWEYtwRpoPkyV4eCLG5"
        val OAUTH_CLIENT_SECRET = "ZN2UoEEa4J"
        val OAUTH_CLIENT_NAME = BuildConfig.APPLICATION_ID

        val KAKAO_APP_KEY = "5f623e886b3a8129a377a1a63c63b015"

        // Naver SDK 초기화
        NaverIdLoginSDK.initialize(this, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME)

        // Kakao SDK 초기화
        KakaoSdk.init(this, KAKAO_APP_KEY)
    }
}