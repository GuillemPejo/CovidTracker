package me.guillem.covidtracker.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.guillem.covidtracker.R
import me.guillem.covidtracker.api.DataEndpoints
import me.guillem.covidtracker.api.RetrofitService
import me.guillem.covidtracker.models.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchByName()


    }

    private fun searchByName(){
        var aa:String
        val request = RetrofitService.buildService(DataEndpoints::class.java)
        val call = request.getData()

        call.enqueue(object : Callback<Request> {
            override fun onResponse(call: Call<Request>, response: Response<Request>) {
                if (response.isSuccessful){
                    Log.e("DATA:----------", response.body()!!.updated_at)
                }
            }

            override fun onFailure(call: Call<Request>, t: Throwable) {
                Log.e("Error", "Error: ${t.message}")
            }
        })
    }

}