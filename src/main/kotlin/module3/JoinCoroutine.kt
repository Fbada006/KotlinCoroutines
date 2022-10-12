import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun joinDemo() {
    runBlocking {
        val job = launch {
            delay(1000)
            print("World")
        }

        print("Hello, ")

        // Suspends/waits until the coroutine is complete
        job.join()
    }
}