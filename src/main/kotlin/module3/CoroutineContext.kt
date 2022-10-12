package module3

import kotlinx.coroutines.*

// Coroutine context is essentially a set of properties attached to the coroutine and user defined
// such as Dispatcher and name

suspend fun withContextDemo() {
    withContext(Dispatchers.Default) {
        delay(1000)
    }
}