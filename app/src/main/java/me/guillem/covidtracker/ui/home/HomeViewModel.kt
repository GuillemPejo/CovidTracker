package me.guillem.covidtracker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.guillem.covidtracker.data.api.model.CovidTracker
import me.guillem.covidtracker.repository.WorldDataUseCase

class HomeViewModel : ViewModel() {

    val worldDataUseCase = WorldDataUseCase()

    private val mutableLiveData = MutableLiveData<Unit>()


    init {
        geListData()
    }

    fun setListData(total: CovidTracker) {
        mutableLiveData.value = data
    }

    fun geListData() {
        setListData(worldDataUseCase.retritRequest())
    }

    fun getListDataLiveData(): LiveData<Unit> {
        return mutableLiveData
    }


}
