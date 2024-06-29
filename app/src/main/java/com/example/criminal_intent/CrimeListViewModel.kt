package com.example.criminal_intent

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class CrimeListViewModel: ViewModel() {
    val crimesList = mutableListOf<Crime>()

    init {
        for (i in 1..50){
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "crime #${i}",
                date = Date(),
                isSolved = i % 2 == 0
            )
            crimesList += crime
        }
    }

}