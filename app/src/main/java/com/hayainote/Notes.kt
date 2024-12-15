package com.hayainote

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hayainote.components.CustomFloatingButton
import com.hayainote.model.Note
import com.hayainote.model.NoteViewModel
import com.hayainote.ui.theme.HayaiNoteTheme
import com.hayainote.ui.theme.TailwindColor

class MainActivity : ComponentActivity() {
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm = NoteViewModel(this.application)

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val data = result.data
            val title = data?.getStringExtra("title")
            val content = data?.getStringExtra("content")

            if (!title.isNullOrEmpty() && !content.isNullOrEmpty()) {
                vm.insertNote(Note(title = title, content = content))
            }
        }

        setContent {
            val notes = vm.getAllNotes()?.observeAsState(initial = emptyList())?.value ?: emptyList()

            HayaiNoteTheme {
                Scaffold(
                    topBar = { NotesTopAppBar() },
                    floatingActionButton = { CustomFloatingButton("Dodaj", Icons.Filled.Add) { onAddNoteButtonClick() } }
                )  { innerPadding ->
                    Column(modifier = Modifier.background(Color.Transparent).padding(innerPadding)) {
                        NoteList(notes = notes)
                    }
                }
            }
        }
    }

    private fun onAddNoteButtonClick() {
        startForResult.launch(Intent(this, AddNote::class.java))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "Notatki")
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Settings,
                    "Navigation button",
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = TailwindColor.Gray[800]
        )
    )
}

@Composable
fun NoteList(notes: List<Note>) {
    val context = LocalContext.current

    fun startActivity(note: Note) {
        val intent = Intent(context, EditNote::class.java)
        intent.putExtra("title", note.title)
        intent.putExtra("content", note.content)
        context.startActivity(intent)
    }

    LazyColumn (
        userScrollEnabled = true,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        items(items = notes) { note ->
            Card(modifier = Modifier
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = TailwindColor.Gray[200]),
                onClick = { startActivity(note) }
            ) {
                Column(
                    modifier = Modifier.fillParentMaxWidth().padding(10.dp)
                ) {
                    Text(text = note.title,
                        color = TailwindColor.Gray[800],
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(text = note.content.ifEmpty { "-" },
                        modifier = Modifier.padding(top = 15.dp),
                        color = TailwindColor.Gray[800],
                        fontSize = 16.sp,
                        maxLines = 8,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}