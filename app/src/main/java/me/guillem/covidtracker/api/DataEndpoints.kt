package me.guillem.covidtracker.api

import me.guillem.covidtracker.models.Request
import retrofit2.Call
import retrofit2.http.GET

/**
 ** Created by Guillem on 12/02/21.
 */
interface DataEndpoints {

    @GET()
    fun getData(): Call<Request>

}

