package com.example.feature_characterlist_impl.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.NavigationScreens
import com.example.core.data.model.CoreCharacter
import com.example.core_db_api.model.Character
import com.example.feature_characterlist_api.domain.ClearDatabaseUseCase
import com.example.feature_characterlist_api.domain.GetAndSaveCharacterListUseCase
import com.example.feature_characterlist_api.model.ClearDatabaseResult
import com.example.feature_characterlist_api.model.GetCharacterListResponse
import com.example.feature_characterlist_impl.presentation.model.CharacterListResult
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val getAndSaveCharacterListUseCase: GetAndSaveCharacterListUseCase,
    private val clearDatabaseUseCase: ClearDatabaseUseCase,
    private val router: Router,
    private val screens: NavigationScreens
) : ViewModel() {


    private val _mutableState: MutableStateFlow<CharacterListResult> =
        MutableStateFlow(CharacterListResult.Loading)
    val mutableState: StateFlow<CharacterListResult> = _mutableState
    private var page = 0

    init {
        timer()
    }

    fun goToDetails(character: Character) {
        val coreCharacter = CoreCharacter(
            character.id,
            character.name,
            character.status,
            character.species,
            character.gender,
            character.origin,
            character.location,
            character.image
        )
        router.navigateTo(screens.details(coreCharacter))
    }

    private suspend fun clearDatabase(): ClearDatabaseResult {
        page = 0
        return clearDatabaseUseCase.execute()
    }

    fun getCharacterList(ignoreCache: Boolean, clearCache: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (clearCache) {
                when (val it = clearDatabase()) {
                    is ClearDatabaseResult.Success -> loadCharacterList(ignoreCache)
                    is ClearDatabaseResult.Error -> _mutableState.emit(
                        CharacterListResult.Error(
                            it.message
                        )
                    )
                }
            } else
                loadCharacterList(ignoreCache)
        }
    }

    private suspend fun loadCharacterList(ignoreCache: Boolean) {
        page++
        if (page == 43)
            _mutableState.emit(CharacterListResult.Finally)
        else {
            when (val result = getAndSaveCharacterListUseCase.execute(page, ignoreCache)) {
                is GetCharacterListResponse.Success -> _mutableState.emit(
                    CharacterListResult.Success(
                        result.value
                    )
                )
                is GetCharacterListResponse.Error -> _mutableState.emit(
                    CharacterListResult.Error(
                        result.message
                    )
                )
            }
        }
    }

    private fun timer() {
        val service: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        service.scheduleWithFixedDelay(Runnable {
            getCharacterList(ignoreCache = true, clearCache = true)
        }, 0, 1, TimeUnit.MINUTES)
    }
}