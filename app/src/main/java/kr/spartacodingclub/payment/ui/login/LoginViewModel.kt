package kr.spartacodingclub.payment.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.spartacodingclub.payment.util.Constants
import kr.spartacodingclub.payment.util.SharedPrefUtil

class LoginViewModel(private val app: Application) : AndroidViewModel(app) {

    private val _isSaved = MutableLiveData<Boolean>()
    val isSaved: LiveData<Boolean> = _isSaved


    /**
     * preference 저장
     */
    fun saveLoginInfo(name: String?, email: String?, phone: String?) {
        val shared = SharedPrefUtil(app)
        shared.setStringPreferences(Constants.USER_NAME, name)
        shared.setStringPreferences(Constants.EMAIL, email)
        shared.setStringPreferences(Constants.PHONE, phone)
        shared.setBooleanPreferences(Constants.IS_LOGIN, true)
        shared.setIntPreferences(Constants.POINT, 5000)

        _isSaved.postValue(true)
    }
}