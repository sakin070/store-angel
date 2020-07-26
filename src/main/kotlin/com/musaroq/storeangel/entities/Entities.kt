package com.musaroq.storeangel.entities

import org.hibernate.annotations.ColumnDefault
import java.io.Serializable
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

//Stock Item
@Entity
class StockItem(
        var sku: Long,
        var name: String,
        @ColumnDefault("1")
        var branchId: Int ,
        @ColumnDefault("0")
        var quantityPerUnit: Int,
        var reorderLevel: Int,
        @ColumnDefault("0")
        var sellingPrice: Float,
        @ColumnDefault("0")
        var wholeSalePrice: Float,
        @ColumnDefault("0")
        var costPrice: Float,
        @ColumnDefault("0")
        var quantity: Int,
        var category: String,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)

@Entity
class StockCategory(
        var name: String,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)
// stock adjustment table ??
@Entity
class StockItemLogging(
        var reason: String,
        var stockItemId: Long,
        var userId: Long,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)

@Entity
class InvoiceItem(
        var stockItemId: Long,
        var invoiceId: Long,
        var quantity: Int,
        var costPrice: Float,
        var sellingPrice: Float,
        var oldCostPrice: Float,
        var oldSellingPrice: Float,
        var expiry: Date,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)

@Entity
class Invoice(
//        var supplierId: Long,
        @ManyToOne
        @JoinColumn(name="supplier_id")
        var supplier: Supplier,
        var date: Date,
        var alphaId: String,
        @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        @JoinColumn(name = "invoiceId")
        var invoiceItem: Set<InvoiceItem> = HashSet(),
        var total: Float,
        var postedBy: String,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)

@Entity
class Customer(
        var firstName: String,
        var lastName: String,
        var age: Int,
        var phone: String?,
        var email: String,
        var address: String?,
        var loyaltyCardNumber: String ,
        var points: Long,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)

@Entity
class LoyaltyCard(
        var cardnumber: Long,
        @ColumnDefault("0")
        var points: Long,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)

@Entity
class Supplier(
        var name: String,
        var phone: String?,
        var address: String?,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long
)

@Entity
class StoreUser(
        var firstName: String,
        var lastName: String,
        var userName: String,
        var hashedPassword: String,
        @ColumnDefault("true")
        var accountNonExpired: Boolean,
        @ColumnDefault("true")
        var accountNonLocked: Boolean,
        @ColumnDefault("true")
        var credentialsNonExpired: Boolean,
        @ColumnDefault("true")
        var enabled: Boolean,
        @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        @JoinColumn(name = "storeUserId")
        var roles: Set<Role> = HashSet(),
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long? = null
)

@Entity
class Role(
        var name: String,
        var storeUserId: Long,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "serial")
        var id: Long? = null
)

@Entity
class Branch(
        var name: String,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "serial") var id: Long? = null
)

//@Entity
//class Organization(
//        var name: String,
//        var defaultMarkUp: Int,
//
//)