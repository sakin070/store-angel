package com.musaroq.storeangel.logic

import com.musaroq.storeangel.entities.*
import org.springframework.context.annotation.Configuration
import java.security.SecureRandom

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
            stockItemToUpdate.quantity = invoiceItem.quantity + stockItemToUpdate.quantity
            stockItemRepository.save(stockItemToUpdate)
        }
    }
    fun generateInvoiceAlphaId(supplierId: Long): String{
        val rand = SecureRandom()
        var alphaId = ""
        val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        do{
            for (i in 0 until 5){
                alphaId += characters.get(rand.nextInt(36))
            }
            val result = invoiceRepository.findBySupplierIdAndAlphaId(supplierId, alphaId)
        }
        while (!result.isNullOrEmpty())
        return alphaId
    }
}