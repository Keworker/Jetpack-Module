package net.keworker.jetpackmodule

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NextPlan
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class EditTextActivity : AppCompatActivity() {
    private var answer: MutableState<String>? = null

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // TODO: Add un focus by click

            // TODO: DRY for colors
            // Dynamic color is available on Android 12+
            val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
            val darkTheme = isSystemInDarkTheme()
            val colors = when {
                dynamicColor && darkTheme -> dynamicDarkColorScheme(this)
                dynamicColor && !darkTheme -> dynamicLightColorScheme(this)
                darkTheme -> darkColorScheme()
                else -> lightColorScheme()
            }

            Scaffold(
                floatingActionButtonPosition = FabPosition.End,
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = ::nextQuestion,
                        shape = MaterialTheme.shapes.extraLarge
                    ) {
                        Row(Modifier.padding(6.dp)) {
                            Text(
                                resources.getString(R.string.next_q),
                                fontWeight = FontWeight.Medium,
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Icon(
                                Icons.Filled.NextPlan,
                                resources.getString(R.string.next_q),
                                modifier = Modifier.offset(x = 6.dp)
                            )
                        }
                    }
                },
            ) {
                QuestionAndAnswer(colors, it)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun QuestionAndAnswer(colors: ColorScheme, paddingParams: PaddingValues) {
        Column(
            modifier = Modifier
                .background(colors.background)
                .padding(12.dp)
                .fillMaxSize()
                .padding(paddingParams)
        ) {
            Text(
                resources.getString(R.string.edit_text_q),
                style = MaterialTheme.typography.bodyLarge,
                color = colors.tertiary,
                fontWeight = FontWeight.SemiBold
            )
            answer = remember { mutableStateOf("") }
            TextField(
                answer?.value ?: "",
                { answer?.value = it },
                label = { Text(resources.getString(R.string.answer)) },
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .offset(y = 12.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = colors.onPrimaryContainer,
                    containerColor = colors.primaryContainer,
                    cursorColor = colors.secondary,
                    selectionColors = TextSelectionColors(
                        colors.onSecondaryContainer,
                        colors.secondaryContainer
                    ),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = colors.secondary,
                    unfocusedLabelColor = colors.secondary
                )
            )
        }
    }

    private fun nextQuestion() {
        // TODO: Go to radio, then, go to checkbox
    }
}
