import kotlinx.coroutines.*
import module3.runWithGlobalScope
import module3.runWithLocalScope
import module4.dowWorkOne
import module4.dowWorkTwo

fun main(args: Array<String>) {
    runBlocking {
        val res1 = async { dowWorkOne() }
        val res2 = async { dowWorkTwo() }

        println("The res is ${res1.await() + res2.await()} ")
    }
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