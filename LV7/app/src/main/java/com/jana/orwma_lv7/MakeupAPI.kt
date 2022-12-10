package com.jana.orwma_lv7

import retrofit2.http.GET
import retrofit2.http.Query


interface MakeupAPI {
    @GET("/api/v1/products.json?")
    fun getMakeup(@Query("brand")brand: String): retrofit2.Call<ArrayList<MakeupItem>>

}