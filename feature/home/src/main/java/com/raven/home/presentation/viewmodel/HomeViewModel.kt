package com.raven.home.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCase : GetNewsUseCase
) : ViewModel(){

    private val _onError = MutableLiveData<String>()
    val onError: LiveData<String> = _onError

    private val _onLoading = MutableLiveData<Boolean>()
    val onLoading: LiveData<Boolean> = _onLoading

    val newsData = liveData{
        _onLoading.value = true
        getNewsUseCase.execute(Unit)
            .catch {
                _onError.value = it.message
                _onLoading.value = false
            }
            .collect{response ->
                emit(response)
                _onLoading.value = false
            }
    }
}
