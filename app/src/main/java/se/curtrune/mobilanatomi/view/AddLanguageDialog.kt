package se.curtrune.mobilanatomi.view

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import se.curtrune.mobilanatomi.model.ProgrammingLanguage
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.window.Dialog

@Composable
fun AddLanguageDialog(onDismiss: () -> Unit, onAdd: (ProgrammingLanguage) -> Unit){
    Dialog(onDismissRequest = onDismiss) {
        Card() {
            var name by remember { mutableStateOf("") }
            var creator by remember { mutableStateOf("") }
            Text(text = "add a language")
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = {name = it},
                label = { Text(text = "name")})
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = creator,
                onValueChange = {creator = it},
                label = { Text(text = "creator")})
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Button(onClick = {
                    onDismiss()
                }){
                    Text(text ="dismiss")
                }
                Button(onClick = {
                    onAdd(ProgrammingLanguage(name,creator))
                }){
                    Text(text ="add")
                }
            }

        }
    }
}


@Composable
@PreviewLightDark
fun PreviewAddLanguageDialog(){

}