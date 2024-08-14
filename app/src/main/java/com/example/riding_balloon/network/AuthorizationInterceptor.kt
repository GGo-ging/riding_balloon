package com.example.riding_balloon.network

import okhttp3.Interceptor

class AuthorizationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val newRequest = chain.request().newBuilder()
            .build()
        return chain.proceed(newRequest)
    }
}