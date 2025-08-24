package se.curtrune.mobilanatomi.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import se.curtrune.mobilanatomi.model.ProgrammingLanguage
import se.curtrune.mobilanatomi.viewModel.ProgrammingLanguagesState

@Composable
fun ProgrammingLanguageList(
    modifier: Modifier = Modifier,
    state: ProgrammingLanguagesState,
    //languages: List<ProgrammingLanguage>,
    onCLick: (ProgrammingLanguage) -> Unit
) {
    //println("ProgrammingLanguageList(...): $languages")
    LazyColumn(modifier = modifier.fillMaxWidth().padding(16.dp)) {
        item{
            //Text(text = "is loading, ${state.isLoading}")
            //Text(text =" number of languages: ${state.languages.size}")
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(state.languages.size){
            ProgrammingLanguageComposable(language = state.languages[it], onCLick = onCLick)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}