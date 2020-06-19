package com.musaroq.storeangel.controller

import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
class AuthController {

    @GetMapping("/login")
    fun login() : String{
        val auth: Authentication = SecurityContextHolder.getContext().authentication
        return auth.name
    }

    @GetMapping("/xxy")
    fun stuff() =  "stuff"
}