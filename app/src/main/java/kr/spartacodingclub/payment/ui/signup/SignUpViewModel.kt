package kr.spartacodingclub.payment.ui.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.spartacodingclub.payment.util.RegexUtil

class SignUpViewModel() : ViewModel() {
    private val regexUtil = RegexUtil

    var name = MutableLiveData<String>()
    var email = MutableLiveData<String>()
    var phone = MutableLiveData<String>()
    var role = MutableLiveData<String>()

    var nameError = MutableLiveData<String?>()
    var emailError = MutableLiveData<String?>()
    var phoneError = MutableLiveData<String?>()
    var roleError = MutableLiveData<String?>()


    fun inputName(input: CharSequence) {
        name.value = input.toString()
    }

    fun inputEmail(input: CharSequence) {
        email.value = input.toString()
    }

    fun inputPhone(input: CharSequence) {
        phone.value = input.toString()
    }

    fun inputRole(input: CharSequence) {
        role.value = input.toString()
    }

    fun setName(name: String) {

        nameError.value = regexUtil.checkName(name)
    }

    fun setEmail(emile: String) {

        emailError.value = regexUtil.checkEmail(emile)
    }

    fun setPhone(phone: String) {

        phoneError.value = regexUtil.checkPhone(phone)
    }

    fun setRole(role: String) {

    }

    fun check():Boolean {


        return false
    }
}