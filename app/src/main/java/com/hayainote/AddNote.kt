package com.hayainote

import android.content.Intent
import android.os.Bundle
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hayainote.components.CustomDropdown
import com.hayainote.components.CustomOutlinedTextField
import com.hayainote.components.CustomFloatingButton
import com.hayainote.components.CustomTopAppBar
import com.hayainote.ui.theme.HayaiNoteTheme

class AddNote : ComponentActivity() {
    private var title by mutableStateOf("")
    private var content by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HayaiNoteTheme {
                Scaffold(
                    topBar = {
                        CustomTopAppBar(
                            title = stringResource(R.string.new_note),
                            navigationCallback = { finish() },
                            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack
                        )
                    },
                    floatingActionButton = {
                        CustomFloatingButton(
                            text = stringResource(R.string.save),
                            Icons.Filled.Check,
                            callback = { saveNote() }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 5.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CustomOutlinedTextField(
                            hint = stringResource(R.string.note_title),
                            onTextChange = {newText -> title = newText},
                            modifier = Modifier.fillMaxWidth()
                        )
                        CustomOutlinedTextField(
                            hint = stringResource(R.string.note_content),
                            onTextChange = {newText -> content = newText},
                            modifier = Modifier
                                .fillMaxWidth()
                                .requiredHeightIn(160.dp)
                        )

                        CustomDropdown()
                    }
                }
            }
        }
    }

    private fun saveNote() {
        val resultIntent = Intent()
        resultIntent.putExtra("title", this.title)
        resultIntent.putExtra("content", this.content)
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}

