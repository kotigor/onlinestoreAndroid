package ru.konstantinov.onlinestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.konstantinov.onlinestore.common.App
import ru.konstantinov.onlinestore.data.repository.StoreRepositoryNet
import ru.konstantinov.onlinestore.databinding.ActivityMainBinding
import ru.konstantinov.onlinestore.ui.cakelist.CakesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).mainRouter = MainRouter(supportFragmentManager)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportFragmentManager.beginTransaction().replace(R.id.full_content, CakesFragment()).commit()
    }
}