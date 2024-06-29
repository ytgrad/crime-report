package com.example.criminal_intent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class CrimeListFragment: Fragment() {
    private val crimeListViewModel: CrimeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag", "${crimeListViewModel.crimesList.size}")
    }

}