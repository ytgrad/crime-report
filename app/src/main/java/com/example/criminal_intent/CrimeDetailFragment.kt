package com.example.criminal_intent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.criminal_intent.databinding.FragmentCrimeDetailBinding
import java.util.Date
import java.util.UUID

class CrimeDetailFragment : Fragment(){
    private var _binding: FragmentCrimeDetailBinding?= null
    private val binding get() = checkNotNull(_binding){
            "binding is null"
        }
    private lateinit var crime: Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etTitle.doOnTextChanged { text, _, _, _ ->
            crime = crime.copy(title = text.toString())
        }

        binding.btnDate.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            crime = crime.copy(isSolved = isChecked)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}