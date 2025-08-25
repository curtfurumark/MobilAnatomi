package se.curtrune.mobilanatomi.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import se.curtrune.mobilanatomi.viewModel.LanguagesEvent
import se.curtrune.mobilanatomi.viewModel.LanguagesViewModel

@Composable
fun ProgrammingLanguageScreen(modifier: Modifier = Modifier){
    val myViewModel: LanguagesViewModel = viewModel()
    val state by myViewModel.state.collectAsState()
    var showAddLanguageDialog by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showAddLanguageDialog = true
            }){
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    ) { padding->
        ProgrammingLanguageList(modifier = Modifier.padding(padding), state = state, onCLick = {
            myViewModel.onEvent(LanguagesEvent.OnClickLanguage(it))
        })
    }
    if(showAddLanguageDialog){
        AddLanguageDialog(onDismiss = {
            showAddLanguageDialog = false
        }, onAdd = {
            myViewModel.onEvent(LanguagesEvent.AddLanguage(it))
            showAddLanguageDialog = false
        })
    }
}