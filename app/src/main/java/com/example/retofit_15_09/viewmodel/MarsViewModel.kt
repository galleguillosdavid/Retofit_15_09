package com.example.retofit_15_09.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retofit_15_09.model.MarsDataBase
import com.example.retofit_15_09.model.Repository
import com.example.retofit_15_09.model.Terrain

class MarsViewModel(application: Application) : AndroidViewModel(application){

    // una variable referencia al Repositorio
    private var repository : Repository
    init {
        val terrainDao = MarsDataBase.getDatabase(application).getTerrainDao()
        repository = Repository(terrainDao)
        repository.getDataFromServer()
    }

    fun exposeLiveDataFromDatabase(): LiveData<List<Terrain>> {
        return repository.mLiveData
    }



}