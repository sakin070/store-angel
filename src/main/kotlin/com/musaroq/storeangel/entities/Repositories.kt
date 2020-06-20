package com.musaroq.storeangel.entities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StockItemRepository: JpaRepository<StockItem, Long> {
    fun findByName(name: String): StockItem?

//    TODO: fix this query
    @Query("SELECT name, sellingPrice, wholeSalePrice, costPrice, posQuantity, storeQuantity, id FROM StockItem")
    fun listStockTable(): List<StockItem>
}

//interface InventoryRepository: JpaRepository<Inventory, Long>
interface CustomerRepository: JpaRepository<Customer, Long>
interface LoyaltyCardRepository: JpaRepository<LoyaltyCard, Long>
interface StockItemLoggingRepository: JpaRepository<StockItemLogging, Long>
interface SupplierRepository: JpaRepository<Supplier, Long>

interface UserRepository: JpaRepository<StoreUser, Long>{
    fun findByUserName(userName: String): StoreUser
}