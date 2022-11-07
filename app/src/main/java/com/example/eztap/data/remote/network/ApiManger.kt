package com.khiladiadda.data.remote.network

import com.example.eztap.utils.AppConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiManger {
    fun createService(baseUrl: String): ApiService {
        val retrofit = getRetrofit(baseUrl)
        return retrofit.create(ApiService::class.java)
    }

    private fun getRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val request: Request.Builder = original.newBuilder()
                .method(original.method, original.body)
            chain.proceed(request.build())
        }).addInterceptor(loggingInterceptor)
        httpClient.readTimeout(AppConstant.TIME_OUT, TimeUnit.SECONDS)
        httpClient.connectTimeout(AppConstant.TIME_OUT, TimeUnit.SECONDS)
        httpClient.writeTimeout(AppConstant.TIME_OUT, TimeUnit.SECONDS)
        httpClient.retryOnConnectionFailure(true)
        return httpClient.build()
    }



}