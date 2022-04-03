package ru.ponomarevss.cleancodetest.domain.usecase

import ru.ponomarevss.cleancodetest.domain.model.SaveUserNameParam
import ru.ponomarevss.cleancodetest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) = userRepository.saveName(saveParam = param)
}