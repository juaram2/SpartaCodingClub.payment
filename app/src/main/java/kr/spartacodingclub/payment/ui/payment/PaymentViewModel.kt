package kr.spartacodingclub.payment.ui.payment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kr.spartacodingclub.payment.util.Constants.ADDRESS
import kr.spartacodingclub.payment.util.Constants.EMAIL
import kr.spartacodingclub.payment.util.Constants.PHONE
import kr.spartacodingclub.payment.util.Constants.USER_NAME
import kr.spartacodingclub.payment.util.SharedPrefUtil

class PaymentViewModel(app: Application): AndroidViewModel(app) {

    private val shared = SharedPrefUtil(app)

    val userName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val address = MutableLiveData<String>()


    init {
        Log.d("username", shared.getStringPreferences(USER_NAME, null).toString())
        userName.value = shared.getStringPreferences(USER_NAME, null)
        email.value = shared.getStringPreferences(EMAIL, null)
        phone.value = shared.getStringPreferences(PHONE, null)
        address.value = shared.getStringPreferences(ADDRESS, null)
    }
}