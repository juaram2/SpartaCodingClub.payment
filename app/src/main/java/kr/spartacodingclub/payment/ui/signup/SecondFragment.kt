package kr.spartacodingclub.payment.ui.signup

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tosspayments.paymentsdk.view.PaymentMethod
import kr.spartacodingclub.payment.R
import kr.spartacodingclub.payment.databinding.FragmentSecondBinding
import kr.spartacodingclub.payment.ui.payment.PaymentActivity


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val viewModel: SignUpViewModel by viewModels()

    private var isCheckPwd: Boolean = false
    private var isCheckPwdConfirm: Boolean = false
    private var isCheckPolicy: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrev.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnReg.setOnClickListener {
            pwd()
            pwdConfirm()
            policy()

            if (isCheckPwd && isCheckPwdConfirm && isCheckPolicy) {
                showDialog()
            }
        }
    }


    private fun pwd() {
        with(binding.layoutPwd) {
            isCheckPwd = viewModel.checkPwd(editText?.text)
            if (!isCheckPwd) {
                error = getString(R.string.error_pwd)
            }
            isErrorEnabled = !isCheckPwd

            if (isErrorEnabled) {
                editText?.doOnTextChanged { text, start, before, count ->
                    error = null
                }
            }
        }
    }

    private fun pwdConfirm() {
        with(binding.layoutConfirm) {
            isCheckPwdConfirm = viewModel.checkPwdConfirm(editText?.text)
            if (!isCheckPwdConfirm) {
                error = getString(R.string.error_pwd_confirm)
            }
            isErrorEnabled = !isCheckPwdConfirm

            if (isErrorEnabled) {
                editText?.doOnTextChanged { text, start, before, count ->
                    error = null
                }
            }
        }
    }

    private fun policy() {
        if (!binding.cbPolicy.isChecked) {
            binding.errorPolicy.text = getString(R.string.error_policy)
        } else {
            binding.errorPolicy.text = ""
        }
        isCheckPolicy = binding.cbPolicy.isChecked
    }


    private fun showDialog() {
        val userInfo = viewModel.getUserInfo()

        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setCancelable(false)
            setTitle(getString(R.string.sign_up_dialig_title))
            setMessage(userInfo)
            setPositiveButton(getString(R.string.confirm)) { dialog, _ ->
                val intent = Intent(PaymentActivity.getIntent(
                    requireContext(),
                    amount = 19500,
                    clientKey = "test_ck_P9BRQmyarYDJ0PmaOmJaVJ07KzLN",
                    customerKey = "test_sk_E92LAa5PVbNZJ1D5A5aZV7YmpXyJ",
                    orderId = "orderId",
                    orderName = "orderName",
                    currency = PaymentMethod.Rendering.Currency.KRW,
                    countryCode = "KR",
                    variantKey = "variantKey",
//                    redirectUrl = "redirectUrl"
                ))
                startActivity(intent)
                dialog.dismiss()
            }
            val dialog = create()
            dialog.show()
        }
    }
}