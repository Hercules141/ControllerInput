package controller_manager.domain

data class ControllerState(
    val xAnalogL: Double = 0.0,
    val yAnalogL: Double = 0.0,
//    val xAnalogR: Double,
//    val yAnalogR: Double,
    // todo think, handle buttons as seperate callbacks?
)