package ru.konstantinov.onlinestore.ui.cakelist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.konstantinov.onlinestore.BR
import ru.konstantinov.onlinestore.R
import ru.konstantinov.onlinestore.databinding.ItemCakeVhBinding

internal class CakeVH(private val binding: ItemCakeVhBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cake: CakeVM){
        binding.apply {
            setVariable(BR.viewModel, cake)
            cakeCalories.text = "${cake.cake.calories.toString()} ккал."
            cakeName.text = cake.cake.name
            cakeWeight.text = "${cake.cake.weight.toString()} г."
            cakePrice.text = "${cake.cake.price.toString()} руб."
            Picasso.get()
                .load("http://192.168.1.2:8080/${cake.cake.image}")
                .placeholder(R.drawable.noimg)
                .error(R.drawable.noimg)
                .into(cakeImg)
        }
    }
}