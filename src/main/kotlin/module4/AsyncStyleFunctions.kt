package module4

import kotlinx.coroutines.*

// 5. Show this and explain why non-idiomatic
// Should opt-in to concurrent code, this is always concurrent
// use the async builder like in previous demos
fun main() {
    val result = doWorkAsync("Hello")

    runBlocking {
        println(result.await())
    }
}

fun doWorkAsync(msg: String): Deferred<Int> = GlobalScope.async {
    log("$msg - Working")
    delay(500)
    log("$msg - Work done")

    // return from the closure
    return@async 42
}

fun log(msg: String) {
    println("$msg in ${Thread.currentThread().name}")
}