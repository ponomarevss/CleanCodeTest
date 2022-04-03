package ru.ponomarevss.cleancodetest.data.storage

import ru.ponomarevss.cleancodetest.data.storage.model.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}