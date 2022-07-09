package com.project.pinjamin.usecase.login.impl

import com.project.pinjamin.data.repository.AdminRepository
import com.project.pinjamin.usecase.login.LoginUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val adminRepository: AdminRepository
) : LoginUseCase {
    override fun invoke(username: String, password: String): Flow<Boolean> {
        return flow {
            val loginResult = adminRepository.login(username, password)
            if (loginResult.first) adminRepository.insert(loginResult.second!!)
            emit(loginResult.first)
        }
    }
}
