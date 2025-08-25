package se.curtrune.mobilanatomi.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import se.curtrune.mobilanatomi.model.ProgrammingLanguage
import se.curtrune.mobilanatomi.model.Repository

class LanguagesViewModel : ViewModel() {
    private val repository = Repository
    private val _state = MutableStateFlow(LanguagesState())
    val state = _state.asStateFlow()
    init {
        println("init ProgrammingLanguagesViewModel")
        _state.update { it.copy(languages = repository.programmingLanguages) }
    }
    fun onEvent(event: LanguagesEvent){
        when(event){
            is LanguagesEvent.AddLanguage -> {
                addLanguage(event.language)
            }
            is LanguagesEvent.DeleteLanguage -> {
                repository.deleteLanguage(event.language)
            }
            is LanguagesEvent.OnClickLanguage -> {
                onLanguageClicked(event.language)
            }
            is LanguagesEvent.UpdateLanguage -> {
                repository.updateLanguage(event.language)
            }
        }
    }
    private fun addLanguage(language: ProgrammingLanguage){
        println("LanguagesViewModel.addLanguage $language")
        repository.addLanguage(language)
        val languages = repository.programmingLanguages
        _state.update{ it.copy(
            languages = languages,
            isLoading = !it.isLoading
        ) }
        println("state number of languages: ${state.value.languages.size}")
    }
    private fun onLanguageClicked(language: ProgrammingLanguage){

    }
}