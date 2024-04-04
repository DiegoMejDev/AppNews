package com.raven.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raven.home.R
import com.raven.home.presentation.adapters.NewsAdapter
import com.raven.home.presentation.view.utils.LoadingView
import com.raven.home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        val rvNews: RecyclerView = view.findViewById(R.id.rvNews)
        rvNews.layoutManager = LinearLayoutManager(requireContext())

        val viewLoading = LoadingView(requireContext())

        viewModel.newsData.observe(viewLifecycleOwner){ data ->
            rvNews.adapter = NewsAdapter(data)
        }
        viewModel.onLoading.observe(viewLifecycleOwner){
            if (it){
                viewLoading.showDialog()

            } else {
                viewLoading.hideDialog()
            }
        }
        viewModel.onError.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(),it , Toast.LENGTH_SHORT).show()

        }
    }
}
