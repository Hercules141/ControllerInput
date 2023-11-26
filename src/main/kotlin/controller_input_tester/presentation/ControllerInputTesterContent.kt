package controller_input_tester.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import controller_input_tester.presentation.domain.ControllerInputTesterViewModel

@Composable
fun ControllerInputTesterContent(){

    val vm by remember { mutableStateOf(ControllerInputTesterViewModel()) }

    Text("hey imma input tester")
}