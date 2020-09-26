package com.example.matches.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.base.extensions.io
import com.example.core.base.model.DataHolder
import com.example.core.base.model.matches.MatchesResponse
import com.example.core.base.repository.matches.MatchesRepository

class MatchesHomeViewModel(private val matchesRepository: MatchesRepository) : ViewModel() {
    private val _matchListLiveData = MutableLiveData<DataHolder<MatchesResponse?>?>()

    val matchListLiveData: LiveData<DataHolder<MatchesResponse?>?> = _matchListLiveData

    fun getMatches() = io {
        // if (matchesRepository.getMatches() is DataHolder.Success) {
        _matchListLiveData.postValue(matchesRepository.getMatches())
        //  }
    }
}