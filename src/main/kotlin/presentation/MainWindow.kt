package presentation

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
@Preview
fun MainWindow() {
    var text by remember { mutableStateOf("Hello, World!") }

    Button(
        onClick = {
            text = "Hello, Desktop!"
        }
    ) {
        Text(text)
    }
}
