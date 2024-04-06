package kr.spartacodingclub.payment.util

import android.app.Activity
import android.widget.Toast

object Extension {

    fun Activity.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}