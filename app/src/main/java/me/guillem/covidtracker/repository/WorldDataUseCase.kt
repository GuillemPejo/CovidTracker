package me.guillem.covidtracker.repository

import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.guillem.covidtracker.data.api.conf.ServiceBuilder
import me.guillem.covidtracker.data.api.model.CovidTracker

/**
 ** Created by Guillem on 12/02/21.
 */
class WorldDataUseCase {
    val compositeDisposable = CompositeDisposable()

        fun retrofitRequest(){
            compositeDisposable.add(
                    ServiceBuilder.buildService().getCovidTrackerByDate("2021-02-11")
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    { result -> txt_search_result.text = "${result.query.searchinfo.totalhits} result found" },
                                    { error -> Log.e("TAG", error.message.toString()) }
                            ))
        }

}