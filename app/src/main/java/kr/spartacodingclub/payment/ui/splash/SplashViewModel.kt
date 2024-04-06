package kr.spartacodingclub.payment.ui.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.spartacodingclub.payment.util.Constants.IS_LOGIN
import kr.spartacodingclub.payment.util.SharedPrefUtil

class SplashViewModel(app: Application) : AndroidViewModel(app) {

    private val shared = SharedPrefUtil(app)

    private val _showSplash = MutableLiveData<Boolean>(true)
    val showSplash: LiveData<Boolean> = _showSplash

    init {
        viewModelScope.launch {
            delay(3000)
            _showSplash.postValue(false)
        }
    }

    fun isLogin(): Boolean {
        return shared.getBooleanPreferences(IS_LOGIN, false)
    }
}