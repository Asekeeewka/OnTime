package com.example.ontime.network

import android.provider.SyncStateContract
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class ApiFactory private constructor() {

    val apiService: Api
        get() = retrofit.create(Api::class.java)


    init {
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(SyncStateContract.Constants.BASE_URL_GARAGE)
                .build()
    }

    companion object {
        private var ApiFactory: ApiFactory? = null
        private lateinit var retrofit: Retrofit

        val instance: ApiFactory
            get() {
                if (ApiFactory == null) {
                    ApiFactory = ApiFactory()
                }
                return ApiFactory as ApiFactory
            }
    }
}