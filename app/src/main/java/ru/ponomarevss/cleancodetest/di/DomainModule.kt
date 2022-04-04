package ru.ponomarevss.cleancodetest.di

import org.koin.dsl.module
import ru.ponomarevss.cleancodetest.domain.usecase.GetUserNameUseCase
import ru.ponomarevss.cleancodetest.domain.usecase.SaveUserNameUseCase

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}