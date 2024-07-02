package com.example.criminal_intent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.criminal_intent.databinding.CrimeLayoutBinding


class CrimeListAdapter(private val crimeList:List<Crime>):Adapter<CrimeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
        val binding = CrimeLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CrimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        val crime = crimeList[position]
        holder.apply {
            binding.tvCrimeItemTitle.text = crime.title
            binding.tvCrimeItemDate.text = crime.date.toString()
        }
    }

    override fun getItemCount() = crimeList.size

}

class CrimeViewHolder(val binding: CrimeLayoutBinding): ViewHolder(binding.root) {

}