package ru.ponomarevss.cleancodetest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ponomarevss.cleancodetest.domain.model.SaveUserNameParam
import ru.ponomarevss.cleancodetest.domain.usecase.GetUserNameUseCase
import ru.ponomarevss.cleancodetest.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {
    init {
        Log.e("AAA", "VM created")
    }

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        resultLiveMutable.value =  "Save result = ${saveUserNameUseCase.execute(param = params)}"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}