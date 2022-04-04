package ru.ponomarevss.cleancodetest.di

import org.koin.dsl.module
import ru.ponomarevss.cleancodetest.data.repository.UserRepositoryImpl
import ru.ponomarevss.cleancodetest.data.storage.UserStorage
import ru.ponomarevss.cleancodetest.data.storage.sharedpref.SharedPrefUserStorage
import ru.ponomarevss.cleancodetest.domain.repository.UserRepository

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}