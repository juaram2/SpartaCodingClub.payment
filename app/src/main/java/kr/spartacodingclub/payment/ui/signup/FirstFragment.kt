package kr.spartacodingclub.payment.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.spartacodingclub.payment.R
import kr.spartacodingclub.payment.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var _binding: FragmentFirstBinding
    private val binding get() = _binding

    private val viewModel: SignUpViewModel by viewModels()

    private var isCheckName: Boolean = false
    private var isCheckEmail: Boolean = false
    private var isCheckPhone: Boolean = false
    private var isCheckRole: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * 스피너
         */
        with(binding.role) {
            ArrayAdapter.createFromResource(
                requireContext(), R.array.role_array, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                this.adapter = adapter
            }

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(spinner: AdapterView<*>?, item: View?, p2: Int, p3: Long) {
                    role(spinner)
                    Log.d(TAG, "onItemSelected ${spinner?.selectedItem}")
                }

                override fun onNothingSelected(spinner: AdapterView<*>?) {
                    role(spinner)
                    Log.d(TAG, "onNothingSelected")
                }
            }
        }


        /**
         * 버튼 클릭 리스너
         */
        binding.btnNext.setOnClickListener {
            name()
            email()
            phone()
            if (!isCheckRole) {
                binding.errorRole.text = getString(R.string.choose_role)
            }

            if (isCheckName && isCheckEmail && isCheckPhone && isCheckRole) {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }

    private fun name() {
        with(binding.layoutName) {
            isCheckName = viewModel.checkName(editText?.text)
            if (!isCheckName) {
                error = getString(R.string.error_name)
            }
            isErrorEnabled = !isCheckName
        }
    }

    private fun email() {
        with(binding.layoutEmail) {
            isCheckEmail = viewModel.checkEmail(editText?.text)
            if (!isCheckEmail) {
                error = getString(R.string.error_email)
            }
            isErrorEnabled = !isCheckEmail
        }
    }

    private fun phone() {
        with(binding.layoutPhone) {
            isCheckPhone = viewModel.checkPhone(editText?.text)
            if (!isCheckPhone) {
                error = getString(R.string.error_phone)
            }
            isErrorEnabled = !isCheckPhone
        }
    }

    private fun role(spinner: AdapterView<*>?) {
        isCheckRole = viewModel.checkRole(spinner?.selectedItem.toString())
    }

    companion object {
        const val TAG = "FirstFragment"
    }
}