package kr.spartacodingclub.payment.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.spartacodingclub.payment.util.Constants.EMAIL
import kr.spartacodingclub.payment.util.Constants.PHONE
import kr.spartacodingclub.payment.util.Constants.USER_NAME
import kr.spartacodingclub.payment.util.SharedPrefUtil

class MainViewModel(private val app: Application) : AndroidViewModel(app) {

    private val _isSaved = MutableLiveData<Boolean>()
    val isSaved: LiveData<Boolean> = _isSaved

    init {
        Log.d("MainViewModel", "initialized!!!!!")
    }


    /**
     * preference 저장
     */
    fun saveLoginInfo(name: String?, email: String?, phone: String?) {
        val shared = SharedPrefUtil(app)
        shared.setStringPreferences(USER_NAME, name)
        shared.setStringPreferences(EMAIL, email)
        shared.setStringPreferences(PHONE, phone)

        _isSaved.postValue(true)
    }
}