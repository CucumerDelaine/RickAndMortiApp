package com.example.filmapps.feature.characterList.domain.useCase

import com.example.filmapps.feature.characterList.data.repository.RetrofitRepository
import com.example.filmapps.feature.characterList.presentation.model.CharacterListResponce
import javax.inject.Inject

class GetListCharacterUseCaseImpl @Inject constructor(
    private val retrofitRepository: RetrofitRepository
) : GetListCharacterUseCase {
    override suspend fun execute(): CharacterListResponce {
        return retrofitRepository.loadList()
    }
}