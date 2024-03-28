package kr.spartacodingclub.payment.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel() : ViewModel() {

    private val _showSplash = MutableLiveData<Boolean>(true)
    val showSplash: LiveData<Boolean> = _showSplash

    init {
        viewModelScope.launch {
            delay(3000)
            _showSplash.postValue(false)
        }
    }
}