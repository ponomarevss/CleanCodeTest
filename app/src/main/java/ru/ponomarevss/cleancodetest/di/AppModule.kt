package ru.ponomarevss.cleancodetest.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.ponomarevss.cleancodetest.presentation.MainViewModel

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
        )
    }
}