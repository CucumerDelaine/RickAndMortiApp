package com.example.filmapps.domain.useCase

import com.example.filmapps.data.repository.RetrofitRepository
import com.example.filmapps.presentation.model.Request
import javax.inject.Inject

class GetListCharacterUseCaseImpl @Inject constructor(
    private val retrofitRepository: RetrofitRepository
): GetListCharacterUseCase {
    override suspend fun execute(): Request {
        return retrofitRepository.loadList()
    }
}