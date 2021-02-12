package me.guillem.covidtracker.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.guillem.covidtracker.repository.TotalCases

class HomeViewModel : ViewModel() {


    private var mutableLiveData: MutableLiveData<TotalCases>? = null
    private var totalCases: TotalCases? = null

    init {
        if (mutableLiveData != null) {

        }
        totalCases = TotalCases()
        mutableLiveData = totalCases.
    }


    fun getTotalRepository(): MutableLiveData<TotalCases>? {
        return mutableLiveData
    }


}
