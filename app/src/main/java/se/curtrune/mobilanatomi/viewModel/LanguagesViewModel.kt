package se.curtrune.mobilanatomi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import se.curtrune.mobilanatomi.model.Repository

class LanguagesViewModel : ViewModel() {
    private val repository = Repository
    private val _state = MutableStateFlow(LanguagesState())
    val state = _state.asStateFlow()
    init {
        _state.update { it.copy(languages = repository.programmingLanguages) }
    }

    fun onEvent(event: LanguagesEvent){
        when(event){
            is LanguagesEvent.AddLanguage -> {

            }
            is LanguagesEvent.DeleteLanguage -> {

            }
            is LanguagesEvent.OnClickLanguage -> {

            }
            is LanguagesEvent.UpdateLanguage -> {

            }
        }
    }
}