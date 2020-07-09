package com.musaroq.storeangel.controller

import com.musaroq.storeangel.entities.*
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.web.bind.annotation.*


@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
@RequestMapping("/logging")
class LoggingController(private val repository: StockItemLoggingRepository){

    @GetMapping("/")
    fun index() = repository.findAll()

    @PostMapping("/")
    fun create(@RequestBody logging: StockItemLogging): StockItemLogging {
        repository.save(logging)
        return logging
    }
}