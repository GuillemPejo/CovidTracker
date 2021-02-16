package me.guillem.covidtracker.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.guillem.covidtracker.data.model.CovidTracker
import me.guillem.covidtracker.data.remote.ApiBuilder
import me.guillem.covidtracker.databinding.ActivityMainBinding
import me.guillem.covidtracker.utils.HttpCallFailureException
import me.guillem.covidtracker.utils.NoNetworkException
import me.guillem.covidtracker.utils.ServerUnreachableException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

    }

    private fun getData() {
        if (ApiBuilder.isNetworkAvailable(this)) {
            var currentDate = getDate()
            Log.e("DATE", currentDate)
            compositeDisposable.add(
                    ApiBuilder.buildService().getCovidTrackerByDate(currentDate)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(this::handleResponse, this::handleError)
            )
        }
    }

    private fun getDate(): String= SimpleDateFormat("yyyy-MM-dd").format(Date())

    private fun handleError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
        Log.e("this", t.message.toString())
        Log.e("this", t.localizedMessage)
        Log.e("this", t.cause.toString())
        Log.e("this", t.javaClass.toString())

        when (t) {
            is NoNetworkException -> displayNoNetworkError()
            is ServerUnreachableException -> displayServerUnreachableError()
            is HttpCallFailureException -> displayCallFailedError()
            else -> displayGenericError(t)
        }
    }

    private fun handleResponse(response: CovidTracker) {

        binding.loading.visibility = View.GONE

        loadData(response)


    }

    private fun loadData(response: CovidTracker) {
        binding.data.newConfirmed.text = response.total.todayNewConfirmed.toString()
        binding.data.newDeaths.text = response.total.todayNewDeaths.toString()
        binding.data.newOpenCases.text = response.total.todayNewOpenCases.toString()
        binding.data.newRecovered.text = response.total.todayNewRecovered.toString()

        binding.data.updateDate.text = "Updated at "+ response.updatedAt

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun displayNoNetworkError() {
        Toast.makeText(this, "No network!", Toast.LENGTH_SHORT).show()
    }

    private fun displayServerUnreachableError() {
        Toast.makeText(this, "Server is unreachable!", Toast.LENGTH_SHORT).show()
    }

    private fun displayCallFailedError() {
        Toast.makeText(this, "Call failed!", Toast.LENGTH_SHORT).show()
    }

    private fun displayGenericError(error: Throwable) {
        Log.i("DEBUG", "Error in say hello", error)
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }


}