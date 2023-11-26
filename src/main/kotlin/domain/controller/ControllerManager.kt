package domain.controller

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.java.games.input.Controller
import net.java.games.input.ControllerEnvironment
import net.java.games.input.Event

class ControllerManager {
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

    suspend fun addEventListenerToController(){
        val eventQueue = controller.eventQueue
        val eventContainer = Event()

        while (true){
            controller.poll()
            eventQueue.getNextEvent(eventContainer)
            println("Event component is: ${eventContainer.component}")
            println("Event value is: ${eventContainer.value}")
        }
    }
}