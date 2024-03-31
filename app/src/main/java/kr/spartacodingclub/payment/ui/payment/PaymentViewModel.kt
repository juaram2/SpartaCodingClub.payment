package kr.spartacodingclub.payment.ui.payment

import android.app.Application
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
        userName.value = shared.getStringPreferences(USER_NAME, "")
        email.value = shared.getStringPreferences(EMAIL, "")
        phone.value = shared.getStringPreferences(PHONE, "")
        address.value = shared.getStringPreferences(ADDRESS, "")
    }
}