package com.example.eztap.data.remote.network.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eztap.data.remote.network.model.response.MainResponse
import com.khiladiadda.data.remote.network.Resource
import com.naturefit.ui.base.Repository
import kotlinx.coroutines.launch

 class ViewModel(private val repository: Repository) : ViewModel(){
    //Get Login OTP
    val mLoginOtpMutableLiveData: MutableLiveData<Resource<MainResponse>> = MutableLiveData()
    fun getLoginOtp() = viewModelScope.launch {
        mLoginOtpMutableLiveData.value = Resource.Loading
        mLoginOtpMutableLiveData.value = repository.getDataList()
    }
}
