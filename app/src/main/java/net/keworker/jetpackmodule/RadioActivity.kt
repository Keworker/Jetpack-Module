package net.keworker.jetpackmodule

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.keworker.jetpackmodule.ui.elements.FloatingActionButtonParams
import net.keworker.jetpackmodule.ui.elements.FloatingButton
import net.keworker.jetpackmodule.ui.theme.JetpackModuleTheme

class RadioActivity : ComponentActivity() {
    private var radioState: MutableState<Int>? = null

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackModuleTheme {
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
                    QuestionAndButtons(it)
                }
            }
        }
    }

    @Composable
    fun QuestionAndButtons(paddingParams: PaddingValues) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
                .padding(paddingParams)
                .selectableGroup()
        ) {
            Text(
                resources.getString(R.string.radio_q),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            radioState = remember { mutableStateOf(-1) }
            val variants = listOf(
                resources.getString(R.string.any_variant0),
                resources.getString(R.string.any_variant1),
                resources.getString(R.string.any_variant2),
                resources.getString(R.string.any_variant3)
            )
            for (i in variants.indices) {
                Row {
                    RadioButton((radioState?.value == i), onClick = { radioState?.value = i })
                    Text(
                        variants[i],
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }

    private fun nextQuestion() {
        startActivity(Intent(this, CheckBoxActivity::class.java))
    }
}
