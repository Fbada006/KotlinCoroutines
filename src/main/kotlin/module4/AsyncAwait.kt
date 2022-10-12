package module4

import kotlinx.coroutines.delay
import java.util.Random

// Use async/await to return data from a coroutine
// launch does not return a value
// Deferred is a type of job
//The following two functions will run but not asynchronously
// use async to run them asynchronously
// This pattern is faster

suspend fun dowWorkOne(): Int {
    delay(100)
    println("Working 1")
    return Random().nextInt()
}

suspend fun dowWorkTwo(): Int {
    delay(200)
    println("Working 2")
    return Random().nextInt()
}