package ru.ponomarevss.cleancodetest.domain.repository

import ru.ponomarevss.cleancodetest.domain.model.SaveUserNameParam
import ru.ponomarevss.cleancodetest.domain.model.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}