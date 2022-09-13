package com.example.feature_characterlist_impl.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.NavigationScreens
import com.example.core.data.model.CoreCharacter
import com.example.core_db_api.model.AppInfo
import com.example.core_db_api.model.Character
import com.example.feature_characterlist_api.domain.ClearDatabaseUseCase
import com.example.feature_characterlist_api.domain.GetAndSaveCharacterListUseCase
import com.example.feature_characterlist_api.domain.GetAppInfoUseCase
import com.example.feature_characterlist_api.domain.SaveAppInfoUseCase
import com.example.feature_characterlist_api.model.ClearDatabaseResult
import com.example.feature_characterlist_api.model.GetAppInfoResult
import com.example.feature_characterlist_api.model.GetCharacterListResponse
import com.example.feature_characterlist_api.model.SaveAppInfoResult
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
    private val screens: NavigationScreens,
    private val getAppInfoUseCase: GetAppInfoUseCase,
    private val saveAppInfoUseCase: SaveAppInfoUseCase
) : ViewModel() {


    private val _mutableState: MutableStateFlow<CharacterListResult> =
        MutableStateFlow(CharacterListResult.Loading)
    val mutableState: StateFlow<CharacterListResult> = _mutableState

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
        when (val it = saveAppInfoUseCase.execute(
            AppInfo(
                id = 0,
                time = System.currentTimeMillis(),
                page = 0
            )
        )) {
            is SaveAppInfoResult.Success -> Unit
            is SaveAppInfoResult.Error -> return ClearDatabaseResult.Error(it.message)
        }
        return clearDatabaseUseCase.execute()
    }

    private suspend fun clearCache() {
        when (val it = clearDatabase()) {
            is ClearDatabaseResult.Success -> loadCharacterList(true)
            is ClearDatabaseResult.Error -> _mutableState.emit(
                CharacterListResult.Error(
                    it.message
                )
            )
        }
    }

    private suspend fun firstStart() {
        when (val it = getAppInfoUseCase.execute()) {
            is GetAppInfoResult.Success -> {
                if (System.currentTimeMillis() - (it.value.time) > 300000)
                    clearCache()
                else
                    loadCharacterList(false)
            }
            is GetAppInfoResult.Error -> _mutableState.emit(
                CharacterListResult.Error(
                    it.message
                )
            )
        }
    }


    fun getCharacterList(firstStart: Boolean, clearCache: Boolean, pagination: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (firstStart) {
                firstStart()
            } else if (clearCache) {
                clearCache()
            } else
                loadCharacterList(pagination)
        }
    }

    private suspend fun loadCharacterList(pagination: Boolean) {
        when (val it = getAppInfoUseCase.execute()) {
            is GetAppInfoResult.Success -> {
                when (val response = saveAppInfoUseCase.execute(
                    AppInfo(
                        it.value.id,
                        it.value.time,
                        it.value.page + 1
                    )
                )) {
                    is SaveAppInfoResult.Success -> {
                        if (it.value.page + 1 == 43)
                            _mutableState.emit(CharacterListResult.Finally)
                        else {
                            when (val result = getAndSaveCharacterListUseCase.execute(
                                it.value.page + 1,
                                pagination
                            )) {
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
                    is SaveAppInfoResult.Error -> _mutableState.emit(
                        CharacterListResult.Error(
                            response.message
                        )
                    )
                }
            }
            is GetAppInfoResult.Error -> _mutableState.emit(
                CharacterListResult.Error(
                    it.message
                )
            )
        }
    }
}