package com.khiladiadda.data.remote.network

import com.example.eztap.utils.AppConstant
import com.example.eztap.data.remote.network.model.response.MainResponse
import retrofit2.http.GET

interface ApiService {
    @GET(AppConstant.assigmentjson)
    suspend fun getdatalist(): MainResponse
}