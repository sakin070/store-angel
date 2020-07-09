package com.musaroq.storeangel.controller

import com.musaroq.storeangel.entities.StockItem
import com.musaroq.storeangel.entities.StockItemRepository
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.web.bind.annotation.*
import java.util.*


@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
@RequestMapping("/stock-item")
class StockController(private val repository: StockItemRepository) {

    @GetMapping("/")
    fun index() = repository.findAll()

//    @RequestMapping(path = [("/{id}")], method = [(RequestMethod.GET)])
    @GetMapping("/{id}")
    fun show(@PathVariable("id") sku: Long): Optional<StockItem> {
        return repository.findById(sku)
    }

    @PostMapping("/")
    fun create(@RequestBody stockItem: StockItem): StockItem {
        repository.save(stockItem)
        return stockItem
    }

    @PutMapping("/{id}")
    fun updateStockItem(@RequestBody stockItem: StockItem, @PathVariable("id") id:Long): StockItem{
        val stockItemToUpdate: StockItem   = repository.getOne(id)
        stockItemToUpdate.sku = stockItem.sku
        stockItemToUpdate.name = stockItem.name
        stockItemToUpdate.branchId = stockItem.branchId
        stockItemToUpdate.quantityPerUnit = stockItem.quantityPerUnit
        stockItemToUpdate.reorderLevel = stockItem.reorderLevel
        stockItemToUpdate.sellingPrice = stockItem.sellingPrice
        stockItemToUpdate.wholeSalePrice = stockItem.wholeSalePrice
        stockItemToUpdate.costPrice = stockItem.costPrice
        stockItemToUpdate.quantity = stockItem.quantity
        repository.save(stockItemToUpdate)
        return stockItemToUpdate
    }

    @DeleteMapping("/{id}")
    fun deleteStockItem(@PathVariable("id") id:Long){
        repository.deleteById(id)
    }


    //    @GetMapping("/stock-table")
//    fun stockTable() :List<StockItem> {
//        return repository.listStockTable()
//    }


}