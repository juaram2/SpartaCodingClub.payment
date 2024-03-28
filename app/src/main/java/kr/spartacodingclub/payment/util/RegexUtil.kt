package kr.spartacodingclub.payment.util

import android.util.Patterns
import java.util.regex.Matcher
import java.util.regex.Pattern


object RegexUtil {
    private const val PASSWORD_MIN_COUNT = 6
    private const val PASSWORD_MAX_COUNT = 20
    private const val PHONE_MIN_COUNT = 11
    private const val NAME_MIN_COUNT = 2
    private const val NAME_MAM_COUNT = 20


    fun checkName(name: String?): String? {
        val pattern =
            "^[ㄱ-ㅎㅏ-ㅣ가-힣ᆞ|ᆢ|ㆍ|ᆢ|ᄀᆞ|ᄂᆞ|ᄃᆞ|ᄅᆞ|ᄆᆞ|ᄇᆞ|ᄉᆞ|ᄋᆞ|ᄌᆞ|ᄎᆞ|ᄏᆞ|ᄐᆞ|ᄑᆞ|ᄒᆞa-zA-Z]{$NAME_MIN_COUNT, $NAME_MAM_COUNT}$"
        val m = Pattern.compile(pattern).matcher(name)

        if (!m.matches() || name?.isEmpty() == true) {
            return "이름은 2글자 이상이어야 합니다."
        }
        return null
    }


    fun checkEmail(email: String?): String? {
        val pattern = Patterns.EMAIL_ADDRESS

        if (!pattern.matcher(email).matches() || email?.isEmpty() == true) {
            return "올바른 이메일을 입력해주세요."
        }
        return null
    }


    fun checkPhone(phone: String?): String? {
        val pattern = "^[0-9]{$PHONE_MIN_COUNT}$"
        val m = Pattern.compile(pattern).matcher(phone)

        if (!m.matches() || phone?.isEmpty() == true) {
            return "연락처는 11자리여야 합니다."
        }
        return null
    }


    fun checkPassword(password: String?): String? {
        val pattern =
            "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_~])[a-zA-Z0-9!@#$%^&*?_~]{$PASSWORD_MIN_COUNT, $PASSWORD_MAX_COUNT}$"
        val m: Matcher = Pattern.compile(pattern).matcher(password)

        if (!m.matches() || password?.isEmpty() == true) {
            return "비밀번호는 최소 6자리 이상, 영문, 숫자, 특수문자를 포함해야 합니다."
        }
        return null
    }


    fun checkConfirmPassword(password: String?, confirm: String?): String? {
        if (password != confirm) {
            return "비밀번호가 일치하지 않습니다."
        }
        return null
    }
}