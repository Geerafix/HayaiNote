package com.hayainote

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hayainote.components.CustomFloatingButton
import com.hayainote.components.CustomOutlinedTextField
import com.hayainote.components.CustomTopAppBar
import com.hayainote.model.Note
import com.hayainote.ui.theme.HayaiNoteTheme

class EditNote : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val note: Note? = intent.getParcelableExtra("note")

        setContent {
            HayaiNoteTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CustomTopAppBar(
                            title = stringResource(R.string.note),
                            navigationCallback = { this.finish() },
                            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
                            actionCallback = { deleteNote() },
                            actionIcon = Icons.Filled.Delete
                        )
                    },
                    floatingActionButton = {
                        CustomFloatingButton(
                            text = stringResource(R.string.save),
                            Icons.Filled.Check,
                            callback = { saveNote() }
                        )
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 5.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CustomOutlinedTextField(
                            hint = stringResource(R.string.note_title),
                            initialValue = note?.title,
                            onTextChange = { newText -> note?.title = newText },
                            modifier = Modifier.fillMaxWidth()
                        )
                        CustomOutlinedTextField(
                            hint = stringResource(R.string.note_content),
                            initialValue = note?.content,
                            onTextChange = { newText -> note?.content = newText },
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeightIn(160.dp)
                        )
                    }
                }
            }
        }
    }

    fun saveNote() {
        Toast.makeText(this.applicationContext,
            getString(R.string.saved_note_toast), Toast.LENGTH_SHORT).show()
        setResult(RESULT_OK)
        finish()
    }

    fun deleteNote() {
        Toast.makeText(this.applicationContext,
            getString(R.string.deleted_note_toast), Toast.LENGTH_SHORT).show()
        setResult(RESULT_OK)
        finish()
    }
}
