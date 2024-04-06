package kr.spartacodingclub.payment.model

data class UserInfo(
    val name: String,
    val email: String? = null,
    val phone: String? = null,
    val address: String? = null,
    val isLogin: Boolean = false,
    val point: Int? = null
)
