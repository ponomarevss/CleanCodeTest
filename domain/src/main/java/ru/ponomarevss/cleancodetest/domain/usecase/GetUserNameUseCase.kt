package ru.ponomarevss.cleancodetest.domain.usecase

import ru.ponomarevss.cleancodetest.domain.model.UserName
import ru.ponomarevss.cleancodetest.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    
    fun execute(): UserName = userRepository.getName()
}