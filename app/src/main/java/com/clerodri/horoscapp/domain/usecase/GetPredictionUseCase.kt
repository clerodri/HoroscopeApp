package com.clerodri.horoscapp.domain.usecase

import com.clerodri.horoscapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository){
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}