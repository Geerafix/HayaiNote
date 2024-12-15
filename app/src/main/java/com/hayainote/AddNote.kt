package com.hayainote

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hayainote.components.CustomDropdown
import com.hayainote.components.CustomOutlinedTextField
import com.hayainote.components.CustomFloatingButton
import com.hayainote.ui.theme.HayaiNoteTheme
import com.hayainote.ui.theme.TailwindColor

class AddNote : ComponentActivity() {
    private var title by mutableStateOf("")
    private var content by mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HayaiNoteTheme {
                Scaffold(
                    topBar = { AddNoteTopAppBar { this.finish() } },
                    floatingActionButton = { CustomFloatingButton("Zapisz", Icons.Filled.Check) { saveNote() } },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding).padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        CustomOutlinedTextField(
                            "Tytuł",
                            {newText -> title = newText},
                            Modifier.fillMaxWidth()
                        )
                        CustomOutlinedTextField(
                            "Treść",
                            {newText -> content = newText},
                            Modifier.fillMaxWidth().requiredHeightIn(160.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteTopAppBar(callback: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Nowa notatka")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = TailwindColor.Gray[800]
        ),
        navigationIcon = {
            IconButton(
                onClick = { callback() }
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Arrow left")
            }
        }
    )
}
