package net.keworker.jetpackmodule

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.keworker.jetpackmodule.ui.theme.JetpackModuleTheme

class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackModuleTheme {
                var expanded by remember { mutableStateOf(false) }
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize()
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            if (!expanded) expanded = true
                        },
                    verticalArrangement = Arrangement.Bottom
                ) {
                    ViewLogo(expanded)
                }
            }
        }
    }

    @Composable
    fun ViewLogo(expanded: Boolean) {
        AnimatedVisibility(visible = expanded) {
            Card(
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.clickable { startTest() }
            ) {
                Text(
                    resources.getString(R.string.test_subheading),
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Text(
            resources.getString(R.string.test_label),
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
        )
    }

    private fun startTest() {
        startActivity(Intent(this, EditTextActivity::class.java))
    }
}
