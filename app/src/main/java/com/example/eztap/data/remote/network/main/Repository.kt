package com.naturefit.ui.base

import com.example.eztap.utils.AppConstant
import com.khiladiadda.data.remote.network.ApiManger
import com.khiladiadda.data.remote.network.ApiService
import net.simplifiedcoding.data.network.SafeApiCall

 class Repository : SafeApiCall {
    private val manager: ApiManger = ApiManger()
    var apiService: ApiService = manager.createService(AppConstant.BASE_URL)
    suspend fun getDataList() = safeApiCall {
        apiService.getdatalist()
    }

}