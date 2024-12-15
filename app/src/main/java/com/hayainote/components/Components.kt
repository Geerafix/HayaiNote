package com.hayainote.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.hayainote.ui.theme.TailwindColor
import com.hayainote.ui.theme.outlinedTextFieldTheme

@Composable
fun CustomFloatingButton(text: String, icon: ImageVector, callback: () -> Unit) {
    ExtendedFloatingActionButton(
        shape = MaterialTheme.shapes.large,
        containerColor = TailwindColor.Gray[800],
        contentColor = TailwindColor.Gray[200],
        onClick = { callback() },
        icon = { Icon(icon, "Floating action button") },
        text = { Text(text = text) }
    )
}

@Composable
fun CustomOutlinedTextField(hint: String, onTextChange: (String) -> Unit, modifier: Modifier) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        shape = MaterialTheme.shapes.medium,
        value = text,
        onValueChange = {
            text = it
            onTextChange(it)
        },
        label = { Text(hint) },
        modifier = modifier,
        colors = outlinedTextFieldTheme()
    )
}

@Composable
fun CustomDropdown() {
    val expanded = remember { mutableStateOf(false) };


}