//package com.musaroq.storeangel.controller
//
//import com.musaroq.storeangel.entities.Inventory
//import com.musaroq.storeangel.entities.InventoryRepository
//import com.musaroq.storeangel.entities.StockItem
//import org.springframework.data.rest.webmvc.BasePathAwareController
//import org.springframework.web.bind.annotation.*
//import java.util.*
//
//@CrossOrigin(origins=["*"], maxAge = 3600)
//@RestController
//@BasePathAwareController
//@RequestMapping("/inventory")
//class InventoryController(private val repository: InventoryRepository){
//    @GetMapping("/")
//    fun index() = repository.findAll()
//
//    @RequestMapping(path = [("/{id}")], method = [(RequestMethod.GET)])
//    fun show(@PathVariable("id") inventoryId: Long): Optional<Inventory> {
//        return repository.findById(inventoryId)
//    }
//
//    @PostMapping
//    fun newStockItem(@RequestBody inventory: Inventory): Inventory {
//        repository.save(inventory)
//        return inventory
//    }
//}