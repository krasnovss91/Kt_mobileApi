package com.example.demo_kotlin.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mobileApi")
class HelloController {
    @RequestMapping(value = ["/helloWorld"], method = [(RequestMethod.GET)])
    fun getHelloWordMessage(): ResponseEntity<String> = ResponseEntity.ok("Hello World")

    @RequestMapping(value = ["/helloWorld/{name}"], method = [(RequestMethod.GET)])
    fun getHelloWordMessageWithName(@PathVariable("name") name: String): ResponseEntity<Any> =
        if (name != "Ivan") {
            ResponseEntity.ok(HelloResponse(message = "Hello $name", name = name))
        } else {
            ResponseEntity.badRequest().body("I am Ivan")
        }
}

data class HelloResponse(val message: String, val name: String)

//curl --location --request GET 'http://localhost:8080/mobileApi/helloWorld'