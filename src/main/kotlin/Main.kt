
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import controller_input_tester.presentation.ControllerInputTesterContent

fun main() = application {

    Window(onCloseRequest = ::exitApplication) {
//        MainWindow()
        ControllerInputTesterContent()
    }
}
