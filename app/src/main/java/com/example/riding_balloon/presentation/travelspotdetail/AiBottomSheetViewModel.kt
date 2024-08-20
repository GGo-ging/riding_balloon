package com.example.riding_balloon.presentation.travelspotdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riding_balloon.data.repository.travelspotdetail.OpenAiApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AiBottomSheetViewModel @Inject constructor(
    private val openAiApiRepository: OpenAiApiRepository
) : ViewModel() {

    private val _aiMessage = MutableLiveData<String>()
    val aiMessage get() = _aiMessage

    private val _aiState = MutableLiveData<Boolean>()
    val aiState get() = _aiState

    fun getAiMessage(keyword: String) {
        viewModelScope.launch {
            _aiMessage.value = openAiApiRepository.getMessageFromAi(keyword)
        }
    }

    fun clearAiMessage() {
        _aiMessage.value = ""
    }

}