import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import domain.controller.ControllerManager
import presentation.MainWindow

fun main() = application {

    ControllerManager()


    Window(onCloseRequest = ::exitApplication) {
        MainWindow()
    }
}
