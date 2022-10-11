import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

// This is better than handling cancellation yourself
fun timeout() = runBlocking {
    val job = withTimeout(100) {
        repeat(1000) {
            yield()

            print(".")
            Thread.sleep(1)
        }
    }
}

// Useful if you do not particularly care about the completion of a job
fun timeoutOrNull() = runBlocking {
    val job = withTimeoutOrNull(100) {
        repeat(1000) {
            yield()

            print(".")
            Thread.sleep(1)
        }
    }

    if (job == null) {
        print("Builder has timed out")
    }
}