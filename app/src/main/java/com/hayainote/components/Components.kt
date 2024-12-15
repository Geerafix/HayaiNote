package com.hayainote.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.hayainote.ui.theme.TailwindColor
import com.hayainote.ui.theme.outlinedTextFieldTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    navigationCallback: (() -> Unit)? = null,
    actionCallback: (() -> Unit)? = null,
    navigationIcon: ImageVector? = null,
    actionIcon: ImageVector? = null
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = TailwindColor.Gray[800]
        ),
        navigationIcon = {
            if (navigationCallback != null && navigationIcon != null) {
                IconButton(
                    onClick = { navigationCallback() }
                ) {
                    Icon(
                        navigationIcon,
                        "Navigation button"
                    )
                }
            }
        },
        actions = {
            if (actionCallback != null && actionIcon != null) {
                IconButton(onClick = { actionCallback() }) {
                    Icon(
                        actionIcon,
                        "Action button",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        },
    )
}

@Composable
fun CustomFloatingButton(
    text: String,
    icon: ImageVector,
    callback: () -> Unit
) {
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
fun CustomOutlinedTextField(
    hint: String,
    initialValue: String? = null,
    onTextChange: (String) -> Unit,
    modifier: Modifier
) {
    var text by remember { mutableStateOf(initialValue ?: "") }

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