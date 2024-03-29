package com.musaroq.storeangel.entities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StockItemRepository: JpaRepository<StockItem, Long> {
    fun findByName(name: String): StockItem?

//    TODO: fix this query
//    @Query("SELECT name, sellingPrice, wholeSalePrice, costPrice, posQuantity, storeQuantity, id FROM StockItem")
//    fun listStockTable(): List<StockItem>
}

//interface InventoryRepository: JpaRepository<Inventory, Long>
interface CustomerRepository: JpaRepository<Customer, Long>
interface LoyaltyCardRepository: JpaRepository<LoyaltyCard, Long>
interface StockItemLoggingRepository: JpaRepository<StockItemLogging, Long>
interface SupplierRepository: JpaRepository<Supplier, Long>
interface StockCategoryRepository:JpaRepository<StockCategory, Long>
interface InvoiceItemRepository:JpaRepository<InvoiceItem, Long>
interface InvoiceRepository:JpaRepository<Invoice, Long>{
    fun findBySupplierIdAndAlphaId(supplierId: Long, alphaId: String):List<Invoice>
    fun findBySupplierId(supplierId: Long): List<Invoice>
    @Query("SELECT  s.name, i.alpha_id, i.date, i.posted_by, i.total, i.id FROM invoice i  JOIN supplier s  ON i.supplier_id = s.id",
    nativeQuery = true)
    fun listAllTransactions(): List<Object>
}

interface UserRepository: JpaRepository<StoreUser, Long>{
    fun findByUserName(userName: String): StoreUser
}