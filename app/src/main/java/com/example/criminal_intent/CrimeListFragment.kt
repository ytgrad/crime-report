package com.example.criminal_intent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.criminal_intent.databinding.FragmentCrimeListBinding

class CrimeListFragment: Fragment() {
    private val crimeListViewModel: CrimeListViewModel by viewModels()
    private var _binding: FragmentCrimeListBinding? = null
    private val binding get() = checkNotNull(_binding){
        "binding is null"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag", "${crimeListViewModel.crimesList.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrimeListBinding.inflate(layoutInflater, container, false)
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.crimeRecyclerView.adapter = CrimeListAdapter(crimeListViewModel.crimesList)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}