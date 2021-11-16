package ru.konstantinov.onlinestore

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainRouter(private val fragmentManager: FragmentManager) {
    fun closeLastFragment(){
        fragmentManager.popBackStack()
    }

    fun changeMainFragment(fragment: Fragment){
        fragmentManager.beginTransaction()
            .replace(R.id.full_content, fragment)
            .addToBackStack(null)
            .commit()
    }
}