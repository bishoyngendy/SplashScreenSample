package com.bishoyngendy.splashscreensample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel: ViewModel() {
    private val _keepSplashScreenShown = MutableStateFlow(true)
    val keepSplashScreenShown: StateFlow<Boolean> = _keepSplashScreenShown

    init {
        viewModelScope.launch {
            val randomDelays = mutableListOf<Long>(1000, 5000, 10000)
            val randomIndex = Random().nextInt(randomDelays.size)
            val randomDelay = randomDelays[randomIndex]
            Log.i("MainViewModel", "Random Delay is $randomDelay ms")
            delay(randomDelay)
            _keepSplashScreenShown.value = false
        }
    }
}