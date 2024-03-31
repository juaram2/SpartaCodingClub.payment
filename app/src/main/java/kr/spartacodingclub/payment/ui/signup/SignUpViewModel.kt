package kr.spartacodingclub.payment.ui.signup

import android.app.Application
import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kr.spartacodingclub.payment.ui.signup.SignUpActivity.Companion.EMAIL
import kr.spartacodingclub.payment.ui.signup.SignUpActivity.Companion.PASSWORD
import kr.spartacodingclub.payment.ui.signup.SignUpActivity.Companion.PHONE
import kr.spartacodingclub.payment.ui.signup.SignUpActivity.Companion.ROLE
import kr.spartacodingclub.payment.ui.signup.SignUpActivity.Companion.USER_NAME
import kr.spartacodingclub.payment.util.RegexUtil
import kr.spartacodingclub.payment.util.SharedPrefUtil

class SignUpViewModel(app: Application) : AndroidViewModel(app) {

    private val shared = SharedPrefUtil(app)

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var phone = MutableLiveData<String>()
    var role = MutableLiveData<String>()
    var pwd = MutableLiveData<String>()


    fun checkName(input: Editable?): Boolean {
        saveUserInfo(USER_NAME, input.toString())
        return RegexUtil.checkName(input.toString())
    }

    fun checkEmail(input: Editable?): Boolean {
        saveUserInfo(EMAIL, input.toString())
        return RegexUtil.checkEmail(input.toString())
    }

    fun checkPhone(input: Editable?): Boolean {
        saveUserInfo(PHONE, input.toString())
        return RegexUtil.checkPhone(input.toString())
    }

    fun checkRole(item: String): Boolean {
        saveUserInfo(ROLE, item)
        return item != "역할을 선택해주세요"
    }

    fun checkPwd(input: Editable?): Boolean {
        pwd.value = input.toString()
        return RegexUtil.checkPassword(input.toString())
    }

    fun checkPwdConfirm(input: Editable?): Boolean {
        pwd.value?.let {
            saveUserInfo(PASSWORD, input.toString())
            return RegexUtil.checkConfirmPassword(it, input.toString())
        }
        return false
    }

    private fun saveUserInfo(key: String, value: String) {
        shared.setStringPreferences(key, value)
    }

    fun getUserInfo(): String {
        val name = shared.getStringPreferences(USER_NAME, "")
        val email = shared.getStringPreferences(EMAIL, "")
        val phone = shared.getStringPreferences(PHONE, "")
        val role = shared.getStringPreferences(ROLE, "")
        val pwd = shared.getStringPreferences(PASSWORD, "")
        return "$name\n$email\n$phone\n$role\n$pwd"
    }
}