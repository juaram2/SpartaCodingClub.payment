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

    val price = MutableLiveData<String>()

    init {
        Log.d("PHONE", "${shared.getStringPreferences(PHONE, "연락처를 입력해 주세요")}")
        userName.value = shared.getStringPreferences(USER_NAME, "이름은 입력해 주세요")
        email.value = shared.getStringPreferences(EMAIL, "이메일을 입력해 주세요")
        phone.value = shared.getStringPreferences(PHONE, "연락처를 입력해 주세요")
        address.value = shared.getStringPreferences(ADDRESS, "주소를 입력해 주세요")
    }

    fun setPrice(price: String) {
        this.price.value = price
    }
}