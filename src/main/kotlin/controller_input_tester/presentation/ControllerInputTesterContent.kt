package controller_input_tester.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import controller_input_tester.domain.ControllerInputTesterViewModel

@Composable
fun ControllerInputTesterContent(){

    val vm = remember { ControllerInputTesterViewModel() }
    val vmState by vm.state.collectAsState()

    val backColor = if (vmState.buttonPressed) Color.Red else Color.Gray
    Row {
        Spacer(Modifier.weight(1f))
        Column {
            Text("Input Tester:")
            Box(
                modifier = Modifier.background(backColor)
            ) {
                Text("buttonPressToggle")
            }
        }
        Spacer(Modifier.weight(1f))
    }
}