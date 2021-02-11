package me.guillem.covidtracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.guillem.covidtracker.R
import me.guillem.covidtracker.api.DataEndpoints
import me.guillem.covidtracker.api.RetrofitService
import me.guillem.covidtracker.models.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Example : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        searchByName()


    }

    private fun searchByName() {
        var aa: String
        val request = RetrofitService.buildService(DataEndpoints::class.java)
        val call = request.getData()

        call.enqueue(object : Callback<Request> {
            override fun onResponse(call: Call<Request>, response: Response<Request>) {
                if (response.isSuccessful) {
                    Log.e("DATA:----------", response.body()!!.updated_at)
                }
            }

            override fun onFailure(call: Call<Request>, t: Throwable) {
                Log.e("Error", "Error: ${t.message}")
            }
        })
    }
}