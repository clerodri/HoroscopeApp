package com.clerodri.horoscapp.data

import android.util.Log
import com.clerodri.horoscapp.data.network.HoroscopeApiService
import com.clerodri.horoscapp.data.network.response.PredictionResponse
import com.clerodri.horoscapp.domain.Repository
import com.clerodri.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() } //mapeo de capa de data a capa de modelo
            .onFailure { Log.i("Aries","Ha ocurrido un error ${it.message}") }
        return null
    }
}