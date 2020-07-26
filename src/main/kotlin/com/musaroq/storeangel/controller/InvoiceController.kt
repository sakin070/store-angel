package com.musaroq.storeangel.controller

import com.musaroq.storeangel.entities.Invoice
import com.musaroq.storeangel.entities.InvoiceRepository
import com.musaroq.storeangel.logic.PurchaseLogic
import org.springframework.data.rest.webmvc.BasePathAwareController
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(origins=["*"], maxAge = 3600)
@RestController
@BasePathAwareController
@RequestMapping("/invoice")
class InvoiceController (private val repository: InvoiceRepository, private val purchaseLogic: PurchaseLogic){

    @GetMapping("/")
    fun index() = repository.findAll()

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Long): Optional<Invoice> {
        return repository.findById(id)
    }

    @GetMapping("/alpha/{supplierId}")
    fun generateAlphaId(@PathVariable("supplierId") supplierId: Long): String{
        return purchaseLogic.generateInvoiceAlphaId(supplierId)
    }

    @GetMapping("/supplier/{supplierId}")
    fun getInvoiceBySupplier(@PathVariable("supplierId") supplierId: Long) :List<Invoice>{
        return repository.findBySupplierId(supplierId)
    }

    @GetMapping("/transactions")
    fun listAllTransactions() = repository.listAllTransactions()

    @PostMapping("/")
    fun create(@RequestBody invoice: Invoice):Invoice{
        purchaseLogic.persistPurchase(invoice)
        return invoice
    }

    @DeleteMapping("/{id}")
    fun deleteStockItem(@PathVariable("id") id:Long){
        repository.deleteById(id)
    }
}