package kr.spartacodingclub.payment.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kr.spartacodingclub.payment.R
import kr.spartacodingclub.payment.databinding.FragmentFirstBinding
import kr.spartacodingclub.payment.databinding.FragmentSecondBinding

class FirstFragment : Fragment() {

    private lateinit var _binding: FragmentFirstBinding
    private val binding get() = _binding

    private val viewModel: SignUpViewModel by viewModels()

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

        name()
        email()
        phone()
        role()

        binding.btnNext.setOnClickListener {

        }

        if (true) {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun name() {

    }

    private fun email() {

    }

    private fun phone() {

    }

    private fun role() {
        with(binding.role) {
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.role_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                this.adapter = adapter
            }

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(spinner: AdapterView<*>?, item: View?, p2: Int, p3: Long) {

                    Log.d(TAG, "onItemSelected ${spinner?.selectedItem}")
                }

                override fun onNothingSelected(spinner: AdapterView<*>?) {

                    Log.d(TAG, "onNothingSelected")
                }

            }
        }
    }

    companion object {
        const val TAG = "FirstFragment"
    }
}