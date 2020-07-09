package com.musaroq.storeangel.controller

import com.musaroq.storeangel.entities.StockCategory
import com.musaroq.storeangel.entities.StockCategoryRepository
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
@RequestMapping("/stock-category")
class StockCategoryController (private val repository: StockCategoryRepository){
    @GetMapping("/")
    fun index() = repository.findAll()

    @GetMapping("/{id}")
    fun show(@PathVariable("id") sku: Long): Optional<StockCategory> {
        return repository.findById(sku)
    }

    @PostMapping("/")
    fun create(@RequestBody stockCategory: StockCategory): StockCategory {
        repository.save(stockCategory)
        return stockCategory
    }

    @PutMapping("/{id}")
    fun updateStockItem(@RequestBody stockCategory: StockCategory, @PathVariable("id") id:Long): StockCategory {
        val stockCategoryToUpdate: StockCategory = repository.getOne(id)
        stockCategoryToUpdate.name = stockCategory.name
        repository.save(stockCategoryToUpdate)
        return stockCategoryToUpdate
    }

    @DeleteMapping("/{id}")
    fun deleteStockItem(@PathVariable("id") id:Long){
        repository.deleteById(id)
    }
}