package controller_input_tester.domain

import controller_input_tester.presentation.UiState
import controller_manager.domain.ControllerManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ControllerInputTesterViewModel() {

    private val _state = MutableStateFlow(UiState(false))
    val state = _state.asStateFlow()

    init {
        initViewModel()
    }

    private fun initViewModel() {
        ControllerManager(
            // todo check if event is some mutable reference here or what
            onAnalogControllerEvent = { event ->

            },
            onButtonPress = { event ->
                println("STATE before: ${state.value.buttonPressed}")
                _state.update {
                    state.value.copy(
                        buttonPressed = !it.buttonPressed
                    )
                }
                println("STATE after: ${state.value.buttonPressed}")
            }
        )
    }
}