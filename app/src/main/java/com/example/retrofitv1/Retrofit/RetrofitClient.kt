package com.example.retrofitv1.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    object RetrofitClient {
        private var retrofit: Retrofit? = null
        fun requestInterceptor(): OkHttpClient {
            return OkHttpClient().newBuilder().addInterceptor {
                val original = it.request()
                val url = original.url().newBuilder().addQueryParameter("apiKey","15cae3c693be410b87d0447f8d451acc").build()
                val builder = original.newBuilder()
                    .method(original.method(), original.body()).url(url)



                it.proceed(builder.build())
            }.build()
        }
        fun getClient(baseUrl: String): Retrofit {
            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(requestInterceptor())
                    .build()
            }
            return retrofit!!
        }
    }

}