package ru.konstantinov.onlinestore.ui.cakelist.adapter

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import ru.konstantinov.onlinestore.common.App
import ru.konstantinov.onlinestore.domain.model.Cake
import ru.konstantinov.onlinestore.ui.detail.CakeDetailFragment

class CakeVM(application: Application, val cake: Cake) : AndroidViewModel(application) {
    fun onClick(){
        val cakeDetailFragment = CakeDetailFragment()
        val bundle = Bundle()
        bundle.putLong("ARG_CAKE_ID", cake.id ?: 1)
        cakeDetailFragment.arguments = bundle
        getApplication<App>().mainRouter.changeMainFragment(cakeDetailFragment)
    }
}