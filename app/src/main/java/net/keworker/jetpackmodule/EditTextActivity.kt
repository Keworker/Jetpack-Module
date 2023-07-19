package net.keworker.jetpackmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.keworker.jetpackmodule.ui.elements.FloatingActionButtonParams
import net.keworker.jetpackmodule.ui.elements.FloatingButton
import net.keworker.jetpackmodule.ui.theme.JetpackModuleTheme

class EditTextActivity : AppCompatActivity() {
    private var answer: MutableState<String>? = null

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackModuleTheme {
                // TODO: Add un focus by click
                // TODO: Research string in Jetpack

                Scaffold(
                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = {
                        FloatingButton(
                            FloatingActionButtonParams(
                                resources.getString(R.string.next_q), ::nextQuestion
                            )
                        )
                    }
                ) {
                    QuestionAndAnswer(it)
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun QuestionAndAnswer(paddingParams: PaddingValues) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
                .padding(paddingParams)
        ) {
            Text(
                resources.getString(R.string.edit_text_q),
                style = MaterialTheme.typography.bodyLarge,
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
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }

    private fun nextQuestion() {
        startActivity(Intent(this, RadioActivity::class.java))
    }
}
