package com.example.country_search_demo_app.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.country_search_demo_app.R
import com.example.country_search_demo_app.databinding.FragmentSearchCountryBinding
import com.example.country_search_demo_app.model.CountryDetailsResponse
import com.example.country_search_demo_app.ui.adapter.CountryNameAdapter
import com.example.country_search_demo_app.viewmodel.SearchCountryViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchCountryFragment : Fragment(R.layout.fragment_search_country) {

    private val viewModel: SearchCountryViewModel by viewModels()
    private lateinit var searchCountryBinding: FragmentSearchCountryBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchCountryBinding.bind(view)
        searchCountryBinding = binding


        searchCountryBinding.btnSearch.setOnClickListener {
            if (searchCountryBinding.txtSearch.text.toString().isNotEmpty()) {
                viewModel.getCountryDetailsByName(searchCountryBinding.txtSearch.text.toString())
            } else {
                searchCountryBinding.txtSearch.error =
                    getString(R.string.search_input_error_message)
            }
        }

        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                searchCountryBinding.progressbar.visibility = View.VISIBLE
            } else {
                searchCountryBinding.progressbar.visibility = View.GONE
            }
        }

        viewModel.countryData.observe(viewLifecycleOwner) { items ->
            val countryNamesAdapter = CountryNameAdapter { handleClick(it) }

            searchCountryBinding.countryNamesRecyclerView.apply {
                itemAnimator = DefaultItemAnimator()
                adapter = countryNamesAdapter
            }
            countryNamesAdapter.submitList(items)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Snackbar.make(searchCountryBinding.txtSearch, message, Snackbar.LENGTH_LONG).show()
        }

    }

    private fun handleClick(data: CountryDetailsResponse) {
        val spellingNames = data.altSpellings.toTypedArray()

        findNavController().navigate(SearchCountryFragmentDirections
            .actionSearchCountryFragmentToCountrySpellingNamesFragment(data.name, spellingNames))
    }
}