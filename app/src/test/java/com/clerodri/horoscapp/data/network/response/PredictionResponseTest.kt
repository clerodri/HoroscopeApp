package com.clerodri.horoscapp.data.network.response

import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class PredictionResponseTest{
    @Test
    fun  `toDomain should return a correct Prediction Model `(){
        //Given
        val horoscopeResponse = PredictionResponse("date","prediction","taurus")
        //When
        val predictionModel = horoscopeResponse.toDomain()
        //Then
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe  horoscopeResponse.horoscope
    }
}
