package com.knowledgespike

import kotlinx.coroutines.*
import java.util.*
import kotlin.system.measureTimeMillis

// 2. Run using async and await - code now runs as long as the longest call
fun main() = runBlocking {
    val job = launch {
        val time = measureTimeMillis {
            println("About to work")
            val r1 = async {doWorkOne()}
            println("About to do more work")
            val r2: Deferred<Int> = async{doWorkTwo()}

            println("result: ${r1.await() + r2.await()}")
        }
        println("Done in $time")
    }
    job.join()
}

// 1. Run the code sequentially - this may be on a bkg thread but it's still sequential
//fun main() = runBlocking {
//    val job = launch {
//        val time = measureTimeMillis {
//            println("About to work")
//            val r1 = doWorkOne()
//            println("About to do more work")
//            val r2 = doWorkTwo()
//
//            println("result: ${r1 + r2}")
//        }
//        println("Done in $time")
//    }
//    job.join()
//}


suspend fun doWorkOne(): Int {
    delay(100)
    println("Working 1")
    return Random(System.currentTimeMillis()).nextInt(42)
}

suspend fun doWorkTwo(): Int {
    delay(200)
    println("Working 2")
    return Random(System.currentTimeMillis()).nextInt(42)
}