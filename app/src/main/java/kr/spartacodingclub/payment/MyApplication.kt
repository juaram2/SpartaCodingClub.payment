package kr.spartacodingclub.payment

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.navercorp.nid.NaverIdLoginSDK

class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        val OAUTH_CLIENT_ID = "8cWEYtwRpoPkyV4eCLG5"
        val OAUTH_CLIENT_SECRET = "ZN2UoEEa4J"
        val OAUTH_CLIENT_NAME = getString(R.string.app_name)

        // Naver SDK 초기화
        NaverIdLoginSDK.initialize(this, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME)

        // Kakao SDK 초기화
        KakaoSdk.init(this, getString(R.string.kakao_app_key))
    }
}