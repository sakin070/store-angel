package com.musaroq.storeangel.logic

import com.musaroq.storeangel.entities.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PurchaseLogic (
         private val invoiceRepository: InvoiceRepository,
         private val invoiceItemRepository: InvoiceItemRepository,
         private val stockItemRepository: StockItemRepository
){
    fun persistPurchase(invoice: Invoice){
        val invoiceItems = invoice.invoiceItem
        invoice.invoiceItem = emptySet()
        val savedInvoice = invoiceRepository.save(invoice)
        for (invoiceItem in invoiceItems){
            invoiceItem.invoiceId = savedInvoice.id
            invoiceItemRepository.save(invoiceItem)
            val stockItemToUpdate: StockItem = stockItemRepository.getOne(invoiceItem.stockItemId)
            stockItemToUpdate.costPrice = invoiceItem.costPrice
            stockItemToUpdate.sellingPrice = invoiceItem.sellingPrice
            stockItemToUpdate.quantity = invoiceItem.quantityPurchased + stockItemToUpdate.quantity
            stockItemRepository.save(stockItemToUpdate)
        }
    }
}