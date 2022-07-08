package com.project.pinjamin.usecase

import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    operator fun invoke(username: String, password: String): Flow<Boolean>
}
