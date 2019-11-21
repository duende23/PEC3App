package edu.uoc.android.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    //private val client: OkHttpClient = TODO()
    val retrofit = Retrofit.Builder()
        .baseUrl(ApiConstants.API_URL)
        //.client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val museumService = retrofit.create(MuseumService::class.java)


}