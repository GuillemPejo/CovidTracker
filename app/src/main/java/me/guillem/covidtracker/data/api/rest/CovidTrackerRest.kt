package me.guillem.covidtracker.data.api.rest

import io.reactivex.Observable
import me.guillem.covidtracker.data.api.model.CovidTracker
import retrofit2.http.GET
import retrofit2.http.Path

/**
 ** Created by Guillem on 12/02/21.
 */
interface CovidTrackerRest {

    @GET("{date}")
    fun getCovidTrackerByDate(@Path("date") date: String): Observable<CovidTracker>

/*
    @GET("{date}")
    suspend fun getCovidTrackerByDateAsResponse(@Path("date") date: String): Response<CovidTracker>
*/
}