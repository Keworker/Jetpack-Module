package net.keworker.jetpackmodule

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

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

            var expanded by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .background(colors.background)
                    .padding(12.dp)
                    .fillMaxSize()
                    .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                        if (!expanded) expanded = true
                    },
                verticalArrangement = Arrangement.Bottom
            ) {
                ViewLogo(colors, expanded)
            }
        }
    }

    @Composable
    fun ViewLogo(colors: ColorScheme, expanded: Boolean) {
        AnimatedVisibility(visible = expanded) {
            Card(
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    colors.primaryContainer, colors.primary,
                    colors.secondaryContainer, colors.secondary
                ),
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
            color = colors.secondary,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        )
    }

    private fun startTest() {
        startActivity(Intent(this, EditTextActivity::class.java))
    }
}
