package com.taetae98.hilt.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taetae98.hilt.api.RiotLeagueAPI
import com.taetae98.hilt.api.RiotSpectatorAPI
import com.taetae98.hilt.data.SummonerInformation
import com.taetae98.hilt.database.SummonerEntityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SummonerEntityViewModel @Inject constructor(
    summonerEntityRepository: SummonerEntityRepository,
    riotSpectatorAPI: RiotSpectatorAPI,
    riotLeagueAPI: RiotLeagueAPI,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val summonerInformationLiveData = MutableLiveData<List<SummonerInformation>>(emptyList())

    init {
        summonerEntityRepository.findLiveData().apply {
            observeForever {
                viewModelScope.launch {
                val list = ArrayList<SummonerInformation>()
                    it.forEach { entity ->
                        try {
                            val summoner = riotSpectatorAPI.getSummoner(entity.name)
                            val leagueEntry = riotLeagueAPI.getLeagueEntry(summoner.id)

                            list.add(SummonerInformation(summoner, entity, leagueEntry).also { information ->
                                Log.d("PASS", information.toString())
                            })
                        } catch (e: Exception) {
                            Log.d("PASS", e.toString())
                            summonerEntityRepository.deleteSummonerEntity(entity)
                        }
                    }

                    withContext(Dispatchers.Main) {
                        summonerInformationLiveData.value = list
                    }
                }
            }
        }
    }
}