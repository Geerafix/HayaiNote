package com.hayainote.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hayainote.R
import com.hayainote.model.tag.Tag
import com.hayainote.ui.theme.TailwindColor
import com.hayainote.ui.theme.outlinedTextFieldColors
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.TextField
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset

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
        shape = MaterialTheme.shapes.large,
        value = text,
        onValueChange = {
            text = it
            onTextChange(it)
        },
        label = { Text(hint) },
        modifier = modifier,
        textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        colors = outlinedTextFieldColors()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropdown(options: List<Tag>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember {
        mutableStateOf(options.firstOrNull()?.name ?: "")
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField (
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {  },
            label = { Text(stringResource(R.string.tag)) },
            trailingIcon = { TrailingIcon(expanded = expanded) },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth().menuAnchor(),
            colors = outlinedTextFieldColors()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .border(1.dp, MaterialTheme.colorScheme.onSurface, MaterialTheme.shapes.large)
                .background(MaterialTheme.colorScheme.surface)
                .exposedDropdownSize(true),
            offset = DpOffset(x = 0.dp, y = 5.dp)
        ) {
             options.forEach{ option ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = option.name
                        expanded = false
                    },
                    text = { Text(text = option.name) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}