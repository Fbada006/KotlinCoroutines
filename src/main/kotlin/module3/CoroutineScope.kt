package module3

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Scope in Kotlin's coroutines can be defined as the restrictions within which the Kotlin coroutines are being executed
// the local coroutine scope is a better pattern than GlobalScope because scope is tied to a component usually in android
suspend fun runWithLocalScope() {
    coroutineScope {
        launch {
            println("Launch 1")
            delay(1000)
        }
        launch {
            println("Launch 2")
            delay(2000)
        }
    }
    println("runWithLocalScope finished")

}

suspend fun runWithGlobalScope() {
    GlobalScope.launch {
        println("Launch 1")
        delay(1000)
    }
    GlobalScope.launch {
        println("Launch 2")
        delay(2000)
    }
    println("runWithGlobalScope finished")
}