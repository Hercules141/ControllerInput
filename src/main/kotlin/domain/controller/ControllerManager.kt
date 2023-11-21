package domain.controller

import net.java.games.input.Controller
import net.java.games.input.ControllerEnvironment

class ControllerManager {

    fun initControllerStuff(){
        val controllerEnvironment = ControllerEnvironment.getDefaultEnvironment()
        val controllers: Array<Controller> = controllerEnvironment.controllers

        // Iterate through the available controllers
        for (controller in controllers) {
            println("Controller: ${controller.name}")

            // Check if the controller is a gamepad
            if (controller.type == Controller.Type.GAMEPAD) {
                println("its even a game controller!")
            }
        }
    }

    fun getController(){

    }
}