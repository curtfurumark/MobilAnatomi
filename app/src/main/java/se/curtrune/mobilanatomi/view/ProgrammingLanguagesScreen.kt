package se.curtrune.mobilanatomi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import se.curtrune.mobilanatomi.model.ProgrammingLanguage
import se.curtrune.mobilanatomi.viewModel.LanguagesViewModel
@Composable
fun ProgrammingLanguageScreen() {
    val myViewModel: LanguagesViewModel = viewModel()
    val state by myViewModel.state.collectAsState()
    var showAddLanguageDialog by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showAddLanguageDialog = true
            },
                modifier = Modifier.padding(16.dp)) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add")
            }
        }
    ) {
        ProgrammingLanguageList(modifier = Modifier.padding(it),  state = state, onCLick = {
            //TODO
        })
    }
    if (showAddLanguageDialog){
        AddLanguageDialog(onDismiss = {
            showAddLanguageDialog = false
        },
            onAdd = {
                showAddLanguageDialog = false
            }
        )
    }
}

@Composable
fun AddLanguageDialog(onDismiss: () -> Unit, onAdd: (ProgrammingLanguage) -> Unit) {
    var name by remember { mutableStateOf("") }
    var creator by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.fillMaxWidth()) {
            TextField(value = name, onValueChange = { name = it }, label = { Text(text = "Name") })
            TextField(value = creator, onValueChange = { creator = it }, label = { Text(text = "Creator") })
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = onDismiss) {
                    Text(text = "Dismiss")
                }
                Button(onClick = {
                }) {
                    Text(text = "Add")
                }
            }
        }
    }
}













/*
@Composable
fun ProgrammingLanguageScreen(modifier: Modifier = Modifier){
    val context = LocalContext.current
    val myViewModel: LanguagesViewModel = viewModel()
*/
/*    val myViewModel: LanguagesViewModel = viewModel(){
        LanguagesViewModel.factory(LanguageDatabase.getDatabase(context).languageDao()).create(LanguagesViewModel::class.java)
    }*//*

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
}*/
