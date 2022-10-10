import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    printHelloWorldRunBlocking()
}

fun printHelloWorldGlobalScope() {
    GlobalScope.launch {
        delay(1000)
        print("World")
    }

    print("Hello, ")

    Thread.sleep(1500)
}

fun printHelloWorldRunBlocking() {
    GlobalScope.launch {
        delay(1000)
        print("World")
    }

    print("Hello, ")

    // This will block the main thread and will not return until the work inside is done
    // If GlobalScope is used, then it will return immediately
    runBlocking {
        delay(1500)
    }

//    GlobalScope.launch {
//        delay(1500)
//    }
}

fun printHelloWorldRunBlockingBetter() {
    runBlocking {
        launch {
            delay(1000)
            print("World")
        }

        print("Hello, ")

        // This will block the main thread and will not return until the work inside is done
        // If GlobalScope is used, then it will return immediately

        delay(1500)
    }
}