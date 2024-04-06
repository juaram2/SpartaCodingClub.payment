package kr.spartacodingclub.payment.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kr.spartacodingclub.payment.util.SharedPrefUtil

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val shared = SharedPrefUtil(app)

    val isLogout = MutableLiveData<Boolean>(false)

    fun logout() {
        shared.clearPreferences()
        isLogout.postValue(true)
    }
}