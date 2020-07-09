package com.musaroq.storeangel.controller

import com.musaroq.storeangel.entities.Customer
import com.musaroq.storeangel.entities.CustomerRepository
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
@RequestMapping("/customer")
class CustomerController(private val repository: CustomerRepository) {

    @GetMapping("/")
    fun index() = repository.findAll()

    @PostMapping("/")
    fun create(@RequestBody customer: Customer): Customer{
        repository.save(customer)
        return customer
    }

    @PutMapping("/{id}")
    fun updateCustomer(@RequestBody customer: Customer, @PathVariable("id") id:Long): Customer{
        val customerToUpdate: Customer = repository.getOne(id)
        customerToUpdate.address = customer.address
        customerToUpdate.email = customer.email
        customerToUpdate.firstName = customer.firstName
        customerToUpdate.lastName = customer.lastName
        customerToUpdate.age = customer.age
        customerToUpdate.phone = customer.phone
        customerToUpdate.loyaltyCardNumber = customer.loyaltyCardNumber
        return customerToUpdate
    }
}