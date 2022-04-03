package ru.ponomarevss.cleancodetest.data.repository

import ru.ponomarevss.cleancodetest.data.storage.model.User
import ru.ponomarevss.cleancodetest.data.storage.UserStorage
import ru.ponomarevss.cleancodetest.domain.model.SaveUserNameParam
import ru.ponomarevss.cleancodetest.domain.model.UserName
import ru.ponomarevss.cleancodetest.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam) = User(firstName = saveParam.name, lastName = "")

    private fun mapToDomain(user: User) = UserName(firstName = user.firstName, lastName = user.lastName)
}