package com.example.returnit

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ReturnitApplication

fun main(args: Array<String>) {
    SpringApplication.run(ReturnitApplication::class.java, *args)
}
