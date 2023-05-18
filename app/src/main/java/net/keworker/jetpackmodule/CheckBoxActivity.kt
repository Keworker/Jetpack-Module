package net.keworker.jetpackmodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import net.keworker.jetpackmodule.ui.theme.JetpackModuleTheme

class CheckBoxActivity : ComponentActivity() {
    private var checkBoxState: List<MutableState<Boolean>>? = null

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackModuleTheme {
                Scaffold(
                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = ::nextQuestion,
                            shape = MaterialTheme.shapes.extraLarge
                        ) {
                            Row(Modifier.padding(6.dp)) {
                                Text(
                                    resources.getString(R.string.finish_test),
                                    fontWeight = FontWeight.Medium,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Icon(
                                    Icons.Filled.Check,
                                    resources.getString(R.string.finish_test),
                                    modifier = Modifier.offset(x = 6.dp)
                                )
                            }
                        }
                    },
                ) {
                    QuestionAndChecks(it)
                }
            }
        }
    }

    @Composable
    fun QuestionAndChecks(paddingParams: PaddingValues) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
                .padding(paddingParams)
        ) {
            Text(
                resources.getString(R.string.checkbox_q),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            checkBoxState = listOf(
                remember { mutableStateOf(false) },
                remember { mutableStateOf(false) },
                remember { mutableStateOf(false) },
                remember { mutableStateOf(false) }
            )
            val variants = listOf(
                resources.getString(R.string.any_variant0),
                resources.getString(R.string.any_variant1),
                resources.getString(R.string.any_variant2),
                resources.getString(R.string.any_variant3)
            )
            for (i in variants.indices) {
                Row {
                    Checkbox(
                        checked = checkBoxState?.get(i)?.value ?: false,
                        onCheckedChange = {
                            checkBoxState?.get(i)?.value = !checkBoxState?.get(i)?.value!!
                        }
                    )
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

    }
}
