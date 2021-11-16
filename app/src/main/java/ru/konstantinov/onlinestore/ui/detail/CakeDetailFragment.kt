package ru.konstantinov.onlinestore.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.konstantinov.onlinestore.databinding.FragmentCakeDetailBinding

class CakeDetailFragment : Fragment() {
    private lateinit var binding: FragmentCakeDetailBinding
    private val cakeDetailVM: CakeDetailVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCakeDetailBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = cakeDetailVM
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getLong("ARG_CAKE_ID")
        id?.let{
            cakeDetailVM.loadData(it)
        }
    }
}