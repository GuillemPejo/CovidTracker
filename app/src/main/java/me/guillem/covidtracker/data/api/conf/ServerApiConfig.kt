package me.guillem.covidtracker.data.api.conf

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import me.guillem.covidtracker.data.api.rest.CovidTrackerRest
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceBuilder {
    private val moshiConverter: Moshi? = null
    val moshiConverterFactory = moshiConverter?.let {
        MoshiConverterFactory.create(moshiConverter)
    } ?: MoshiConverterFactory.create(Moshi.Builder().add(KotlinJsonAdapterFactory()).build())

    private val client = OkHttpClient
        .Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.covid19tracking.narrativa.com/api/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(moshiConverterFactory)
        .client(client)
        .build()
        .create(CovidTrackerRest::class.java)

    fun buildService(): CovidTrackerRest {
        return retrofit
    }
}