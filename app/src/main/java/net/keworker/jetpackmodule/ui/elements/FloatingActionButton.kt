package net.keworker.jetpackmodule.ui.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NextPlan
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FloatingButton(
    @PreviewParameter(ParamsProvider::class) params: FloatingActionButtonParams,
) {
    FloatingActionButton(
        onClick = params.callback,
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                params.text,
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                Icons.Filled.NextPlan, params.text, modifier = Modifier.offset(x = 6.dp)
            )
        }
    }
}

data class FloatingActionButtonParams(val text: String, val callback: () -> Unit)

class ParamsProvider : PreviewParameterProvider<FloatingActionButtonParams> {
    override val values = sequenceOf(
        FloatingActionButtonParams("Short String") {},
        FloatingActionButtonParams("Very, very, very, very, very, very, very, long string") {},
        FloatingActionButtonParams("Very, ${"very ".repeat(100)} long string.") {},
        FloatingActionButtonParams("lower case string") {},
        FloatingActionButtonParams("UPPER CASE STRING") {}
    )
}
