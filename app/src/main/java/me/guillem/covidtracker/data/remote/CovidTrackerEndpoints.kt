package me.guillem.covidtracker.data.remote

import io.reactivex.Observable
import io.reactivex.Single
import me.guillem.covidtracker.data.model.CovidTracker
import retrofit2.http.GET
import retrofit2.http.Path

/**
 ** Created by Guillem on 15/02/21.
 */
interface CovidTrackerEndpoints {

    @GET("{date}")
    fun getCovidTrackerByDate(@Path("date") date: String): Observable<CovidTracker>


}