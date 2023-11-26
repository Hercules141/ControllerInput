package controller_manager.domain

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import net.java.games.input.Controller
import net.java.games.input.ControllerEnvironment
import net.java.games.input.Event

class ControllerManager(
    val onAnalogControllerEvent: (Event) -> Unit,
    val onButtonPress: (Event) -> Unit
    // todo prob try data class and states first with one sub dataclass for analog and digital, then give dataclass instead of event, tldr
) {
    private lateinit var controllerEnvironment: ControllerEnvironment
    private lateinit var controller: Controller

        init {
            initControllerStuff()
        }

    fun initControllerStuff(){
        controllerEnvironment = ControllerEnvironment.getDefaultEnvironment()

        // store first best game-controller
        val controllers: Array<Controller> = controllerEnvironment.controllers
        val gamepads = controllers.filter { controller -> controller.type == Controller.Type.GAMEPAD }
        controller = gamepads.first()

        println(controller)
        println("Honarable Mentions: \n ${gamepads.filter { it != controller }}")

        // TODO: consider having a better architecture for scopes
        GlobalScope.launch {
            addEventListenerToController()
        }
    }

    /**
    * Documentatation for Inputs:
    *   relevant infos are
    *       - event.component.name
    *       - event.value       -> 1.0 = 'on' ; 0.0 'off' (except arrow keys increments of 0.25, starting top, clockwise)
    *
    *       component names:
    *           cross: "Taste 0"
    *           circle: "Taste 1"
    *           square: "Taste 2"
    *           Triange: "Taste 3"
    *           L1: "Taste 4"
    *           R1: "Tate 5"
    *
    *           DPad: component name: "Mehrwegeschalter"
    *               values (all ca. check range possibly):
    *               -> up: "0.25"
    *               -> right: "0.5"
    *               -> down: "0.75"
    *               -> left: "1.0"
    *
    * */
    suspend fun addEventListenerToController(){
        val eventQueue = controller.eventQueue
        var event = Event()
        val _controllerState = MutableStateFlow(ControllerState())
        val controllerState = _controllerState.asStateFlow()
        delay(1000)

        while (true){
            controller.poll()

            if(eventQueue.getNextEvent(event)){     // event is overridden by library call
                if (event.component.isAnalog){
                    onAnalogControllerEvent(event)
                } else {
                    onButtonPress(event)
                    if(event.component.name == "Taste 0") {
                        logInputData(event)
                    }
                }

            }


//            if(eventContainer.component.isAnalog){
//                if(!eventContainer.component.isRelative){
//                    val xAnalogL = eventContainer.component
//                    val yAnalogL = eventContainer
//                }
//            }


//            _controllerState.update {
//                it.copy(
//                    xAnalogL =
//                )
//            }


            // test

        }
    }

    private fun logInputData(event: Event){
        println("event to string: " + event)
        println("component to String: " + event.component)
        println("component.isAnalog: " + event.component.isAnalog)
        println("component.isRelative: " + event.component.isRelative)
        println("component.name: " + event.component.name)
        println("component.identifier: " + event.component.identifier)
        println("component.deadzone: " + event.component.deadZone)
        println("component.pollData: " + event.component.pollData)

        println(".value: " + event.value)
        println(".nanos: " + event.nanos)
        println()
        println()
    }
}