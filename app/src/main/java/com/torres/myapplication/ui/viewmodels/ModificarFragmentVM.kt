package com.torres.myapplication.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ModificarFragmentVM : ViewModel() {

    var cLive = MutableLiveData<Int>()
    private var c = 1

    fun funcionContar() {
       val x = getDataAsync.invoke()
        x.collect {
            cLive.postValue(it)
        }
    }

}