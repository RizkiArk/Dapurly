package com.project.dapurly.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("predict")
    fun sendSurveyData(@Body inputPayload: InputPayload): Call<Void>
}
