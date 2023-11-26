package controller_input_tester.presentation.domain

import controller_manager.domain.ControllerManager

class ControllerInputTesterViewModel() {
    init {
        initViewModel()
    }

    private fun initViewModel() {
        ControllerManager(
            // todo check if event is some mutable reference here or what
            onAnalogControllerEvent = { event ->

            },
            onButtonPress = {}
        )
    }
}