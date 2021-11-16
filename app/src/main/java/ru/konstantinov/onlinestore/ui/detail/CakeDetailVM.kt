package ru.konstantinov.onlinestore.ui.detail

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import ru.konstantinov.onlinestore.R
import ru.konstantinov.onlinestore.data.repository.StoreRepositoryNet
import ru.konstantinov.onlinestore.domain.model.CakeDetail

@BindingAdapter("app:picasso")
fun image(view: ImageView, path: String?) {
    Picasso.get().load("http://192.168.1.2:8080/${path}").placeholder(R.drawable.noimg)
        .error(R.drawable.noimg)
        .into(view)
}

class CakeDetailVM(application: Application) : AndroidViewModel(application) {
    private var cakeDetail = CakeDetail.emptyCakeDetail()
    private val storeRepositoryNet = StoreRepositoryNet()


    fun loadData(id: Long){
        viewModelScope.launch {
            cakeDetail = storeRepositoryNet.cake(id)
            cakeDetail.run{
                nameObs.set(name)
                caloriesObs.set(calories.toString())
                imgObs.set(image)
                priceObs.set(price.toString())
                weightObs.set(weight.toString())
                descriptionObs.set(description)
                var res = ""
                cakeDetail.ingredients?.forEach { res += "-${it}\n" }
                ingredientsObs.set(res)
            }
        }
    }

    val nameObs = object : ObservableField<String>(){
        override fun get(): String?{
            return cakeDetail.name
        }
    }

    val caloriesObs = object : ObservableField<String>(){
        override fun get(): String? {
            return "${cakeDetail.calories.toString()} ккал."
        }
    }

    val imgObs = object : ObservableField<String>(){
        override fun get(): String?{
            return cakeDetail.image
        }
    }

    val priceObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${cakeDetail.price.toString()} руб."
        }
    }

    val weightObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${cakeDetail.weight.toString()} г."
        }
    }

    val descriptionObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "Описание:\n${cakeDetail.description}"
        }
    }

    val ingredientsObs = object : ObservableField<String>(){
        override fun get(): String?{
            var res = "Состав:\n"
            cakeDetail.ingredients?.forEach { res += "-${it}\n" }
            return res
        }
    }

/*    fun name() = cakeDetail.name
    fun calories() = cakeDetail.calories.toString()
    fun img() = cakeDetail.image

    fun price() = cakeDetail.price.toString()
    fun weight() = cakeDetail.weight.toString()
    fun description() = cakeDetail.description
    fun ingredients() : String{
        var res = ""
        cakeDetail.ingredients?.forEach { res += "-${it}\n" }
        return res
    }*/

}