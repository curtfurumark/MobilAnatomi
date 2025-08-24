package se.curtrune.mobilanatomi.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import se.curtrune.mobilanatomi.model.ProgrammingLanguage
@Composable
fun ProgrammingLanguageComposable(language: ProgrammingLanguage, onCLick: (ProgrammingLanguage) -> Unit){
    println("ProgrammingLanguageComposable(...): $language")
    Card(modifier =
        Modifier.clickable { onCLick(language) }
            .fillMaxWidth()){
        Text(text = language.name)
        Text(text = language.creator)
    }
}