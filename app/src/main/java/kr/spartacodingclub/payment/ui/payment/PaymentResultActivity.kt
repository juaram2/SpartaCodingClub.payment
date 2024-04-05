package kr.spartacodingclub.payment.ui.payment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.spartacodingclub.payment.R

class PaymentResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_result)
    }

    companion object {
        private const val EXTRA_RESULT = "extraResult"
        private const val EXTRA_DATA = "extraData"

        fun getIntent(context: Context, result: Boolean, data: ArrayList<String>): Intent {
            return Intent(context, PaymentResultActivity::class.java).apply {
                putExtra(EXTRA_RESULT, result)
                putStringArrayListExtra(EXTRA_DATA, data)
            }
        }
    }
}