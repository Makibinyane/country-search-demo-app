package com.example.country_search_demo_app.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.country_search_demo_app.R
import com.example.country_search_demo_app.databinding.FragmentCountrySpellingNamesBinding
import com.example.country_search_demo_app.ui.adapter.SpellingNameAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountrySpellingNamesFragment : Fragment(R.layout.fragment_country_spelling_names) {

    private val args: CountrySpellingNamesFragmentArgs by navArgs()
    private lateinit var spellingNameBinding: FragmentCountrySpellingNamesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCountrySpellingNamesBinding.bind(view)
        spellingNameBinding = binding

        val spellingNamesAdapter = SpellingNameAdapter(args.spellingNames)

        spellingNameBinding.spellingNamesRecyclerView.apply {
            itemAnimator = DefaultItemAnimator()
            adapter = spellingNamesAdapter
        }
    }
}