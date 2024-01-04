package com.clerodri.horoscapp.data.network

import com.clerodri.horoscapp.data.network.response.PredictionResponse
import com.clerodri.horoscapp.domain.model.PredictionModel
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {


    @GET("/{sign}/")
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponse
}