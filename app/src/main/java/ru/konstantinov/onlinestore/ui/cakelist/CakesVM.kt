package ru.konstantinov.onlinestore.ui.cakelist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.konstantinov.onlinestore.common.App
import ru.konstantinov.onlinestore.data.network.AppNetwork
import ru.konstantinov.onlinestore.data.repository.StoreRepositoryNet
import ru.konstantinov.onlinestore.ui.cakelist.adapter.CakeVM

class CakesVM(application: Application) : AndroidViewModel(application) {
    private val cakes: MutableLiveData<List<CakeVM>> = MutableLiveData()
    private val storeRepositoryNet = StoreRepositoryNet()

    init{
        loadCakes()
    }

    fun getCakes(): LiveData<List<CakeVM>>{
        return cakes
    }
    private fun loadCakes(){
        viewModelScope.launch {
            cakes.postValue(storeRepositoryNet.cakesList().map { CakeVM(getApplication<App>(), it) })
        }
    }
}