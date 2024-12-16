package com.hayainote

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hayainote.components.CustomFloatingButton
import com.hayainote.components.CustomTopAppBar
import com.hayainote.model.note.Note
import com.hayainote.model.note.NoteViewModel
import com.hayainote.model.note.NoteWithTag
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
                Toast.makeText(this.applicationContext,
                    getString(R.string.added_note_toast), Toast.LENGTH_SHORT).show()
            }
        }

        setContent {
            val notes = vm.getAllNotes()?.observeAsState(initial = emptyList())?.value ?: emptyList()

            HayaiNoteTheme {
                Scaffold(
                    topBar = {
                        CustomTopAppBar(
                            title = stringResource(R.string.all_notes),
                            actionCallback = { },
                            actionIcon = Icons.Filled.Menu
                        )
                    },
                    floatingActionButton = {
                        CustomFloatingButton(stringResource(R.string.add),
                            Icons.Filled.Add,
                            callback = { onAddNoteButtonClick() }
                        )
                    }
                )  { innerPadding ->
                    Column(modifier = Modifier
                        .background(Color.Transparent)
                        .padding(innerPadding)
                    ) {
                        NoteList(
                            notes = notes,
                            onNoteListItemClick = {
                                note -> onListItemClick(note)
                            }
                        )
                    }
                }
            }
        }
    }

    private fun onAddNoteButtonClick() {
        startForResult.launch(Intent(this, AddNote::class.java))
    }

    private fun onListItemClick(note: Note) {
        val intent = Intent(this, EditNote::class.java).apply {
            putExtra("note", note)
        }
        startForResult.launch(intent)
    }
}

@Composable
fun NoteList(notes: List<NoteWithTag>, onNoteListItemClick: (Note) -> Unit = {}) {
    LazyColumn (
        userScrollEnabled = true,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        items(items = notes) { note ->
            Card(modifier = Modifier
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = TailwindColor.Gray[200]),
                onClick = { onNoteListItemClick(note.note) }
            ) {
                Column(
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = note.note.title,
                        color = TailwindColor.Gray[800],
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(text = note.note.content.ifEmpty { "-" },
                        color = TailwindColor.Gray[800],
                        fontSize = 15.sp,
                        maxLines = 8,
                        fontWeight = FontWeight.Normal,
                        overflow = TextOverflow.Ellipsis
                    )

                    if (note.tag != null) {
                        Card(
                            shape = MaterialTheme.shapes.small,
                            colors = CardDefaults.cardColors(containerColor = TailwindColor.Gray[100])
                        ) {
                            Text(
                                text = note.tag!!.name,
                                color = TailwindColor.Gray[800],
                                modifier = Modifier.padding(horizontal = 5.dp, vertical = 3.dp),
                                fontSize = 15.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}