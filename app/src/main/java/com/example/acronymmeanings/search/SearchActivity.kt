package com.example.acronymmeanings.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.acronymmeanings.R
import com.example.acronymmeanings.Utils.Status
import com.example.acronymmeanings.databinding.ActivityMeaningBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMeaningBinding
    private lateinit var adapter: SearchAdapter
    private val viewModel: SearchViewModel by lazy {
        ViewModelProvider(this)[SearchViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_meaning)
        binding.lifecycleOwner = this

        /**
         * getting the input from the user and start fetching data
         */
        binding.searchEt.doAfterTextChanged { acronym ->
            viewModel.fetch(acronym.toString())
        }

        adapter = SearchAdapter()
        binding.meaningList.adapter = adapter
        binding.meaningList.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        /**
         * observe the meanings liveData and send data to the adapter
         */
        subscribeToObservers()

    }

    private fun subscribeToObservers() {
        viewModel.meanings.observe(this, Observer {

            when (it.status) {
                Status.SUCCESS -> {
                    adapter.data = if (!it.data.isNullOrEmpty()) {
                        it.data[0].fullForms
                    } else {
                        listOf()
                    }
                    binding.progressBar.visibility = View.GONE
                }

                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                }

                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
    }


}