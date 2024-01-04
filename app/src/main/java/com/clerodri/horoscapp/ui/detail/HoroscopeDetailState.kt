package com.clerodri.horoscapp.ui.detail

import com.clerodri.horoscapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {

    data object Loading : HoroscopeDetailState()

    data class Error(val error: String) : HoroscopeDetailState()
    data class Successs(val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel) : HoroscopeDetailState()
}