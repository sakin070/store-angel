package com.musaroq.storeangel.controller

import com.musaroq.storeangel.entities.User
import com.musaroq.storeangel.entities.UserRepository
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
@RequestMapping("/user")
class UserController (private val repository: UserRepository){
    @GetMapping("/")
    fun index() = repository.findAll()

    @GetMapping("/{name}")
    fun userByEmail(@PathVariable("name") name: String): User {
        return repository.findByUserName(name)
    }

    @PostMapping
    fun create(@RequestBody user: User): User {
        repository.save(user)
        return user
    }

//    @PutMapping("/{id}")
//    fun updateStockItem(@RequestBody supplier: Supplier, @PathVariable("id") id:Long): Supplier{
//        val toUpdate: Supplier   = repository.getOne(id)
//        toUpdate.name = supplier.name
//        toUpdate.phone = supplier.phone
//        toUpdate.address = supplier.address
//        repository.save(toUpdate)
//        return toUpdate
//    }

    @DeleteMapping("/{id}")
    fun deleteStockItem(@PathVariable("id") id:Long){
        repository.deleteById(id)
    }
}