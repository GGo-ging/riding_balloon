package com.jeongu.imagesearchapp.network

import okhttp3.Interceptor

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val newRequest = chain.request().newBuilder()
            .build()
        return chain.proceed(newRequest)
    }
}