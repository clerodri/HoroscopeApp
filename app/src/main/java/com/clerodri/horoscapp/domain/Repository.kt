package com.clerodri.horoscapp.domain

import com.clerodri.horoscapp.data.network.response.PredictionResponse
import com.clerodri.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}