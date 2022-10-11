package module3

import kotlinx.coroutines.*

// https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-coroutine-dispatcher/
//A component that determines what thread or threads
//the corresponding coroutine uses for its execution. The coroutine dispatcher can confine coroutine execution to a
//specific thread, dispatch it to a thread pool, or let it run unconfined.

fun dispatchersDemo() = runBlocking {

    val job = launch(Dispatchers.IO) {
        repeat(1000) {
            delay(10)
            print(".")
        }
    }

    delay(250)
//    job.cancel()
//    job.join()
    job.cancelAndJoin()

    print("Done")
}