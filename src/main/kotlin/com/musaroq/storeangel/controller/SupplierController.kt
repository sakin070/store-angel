package com.musaroq.storeangel.controller

import com.musaroq.storeangel.entities.StockItem
import com.musaroq.storeangel.entities.Supplier
import com.musaroq.storeangel.entities.SupplierRepository
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
@RequestMapping("/supplier")
class SupplierController (private val repository: SupplierRepository){

    @GetMapping("/")
    fun index() = repository.findAll()

    @PostMapping("/")
    fun create(@RequestBody supplier: Supplier): Supplier {
        repository.save(supplier)
        return supplier
    }
    @PutMapping("/{id}")
    fun updateSupplier(@RequestBody supplier: Supplier, @PathVariable("id") id:Long): Supplier{
        val toUpdate: Supplier   = repository.getOne(id)
        toUpdate.name = supplier.name
        toUpdate.phone = supplier.phone
        toUpdate.address = supplier.address
        repository.save(toUpdate)
        return toUpdate
    }
    @DeleteMapping("/{id}")
    fun deleteSupplier(@PathVariable("id") id:Long){
        repository.deleteById(id)
    }
}