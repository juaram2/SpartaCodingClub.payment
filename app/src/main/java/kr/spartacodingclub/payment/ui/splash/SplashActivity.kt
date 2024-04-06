package kr.spartacodingclub.payment.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kr.spartacodingclub.payment.R
import kr.spartacodingclub.payment.ui.MainActivity
import kr.spartacodingclub.payment.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel.showSplash.observe(this) { showSplash ->
            if (!showSplash) {
                if (viewModel.isLogin()) {
                    startMainActivity()
                } else {
                    startLoginActivity()
                }
            }
        }
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}