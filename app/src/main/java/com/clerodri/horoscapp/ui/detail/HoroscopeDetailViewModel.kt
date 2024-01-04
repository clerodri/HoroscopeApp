package com.clerodri.horoscapp.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clerodri.horoscapp.domain.model.HoroscopeModel
import com.clerodri.horoscapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    private val _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

   lateinit var horoscope: HoroscopeModel
    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign
        viewModelScope.launch {
            // hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result =
                withContext(Dispatchers.IO) { getPredictionUseCase(sign.name) }  //hilo secundario
            //hilo principal
            if (result != null) {
                _state.value =
                    HoroscopeDetailState.Successs(result.horoscope, result.sign, horoscope)
            } else {
                Log.i("ronaldo", "falla en view model ")
                _state.value =
                    HoroscopeDetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }

}