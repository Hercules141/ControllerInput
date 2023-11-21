
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import domain.controller.ControllerManager
import presentation.MainContent

fun main() = application {
    val controllers = ControllerManager()

    Window(onCloseRequest = ::exitApplication) {
        MainContent()
    }
}
