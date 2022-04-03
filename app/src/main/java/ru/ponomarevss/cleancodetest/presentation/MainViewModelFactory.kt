package ru.ponomarevss.cleancodetest.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ponomarevss.cleancodetest.data.repository.UserRepositoryImpl
import ru.ponomarevss.cleancodetest.data.storage.sharedpref.SharedPrefUserStorage
import ru.ponomarevss.cleancodetest.domain.usecase.GetUserNameUseCase
import ru.ponomarevss.cleancodetest.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T = MainViewModel(
        getUserNameUseCase = getUserNameUseCase,
        saveUserNameUseCase = saveUserNameUseCase
    ) as T
}