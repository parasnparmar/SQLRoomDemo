package com.example.sqlroomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products", ignoredColumns = ["isAvailable"])
data class Product(
    @PrimaryKey
    var id: Int = 0,
    @ColumnInfo(name = "product_title")
    var title: String? = null,
    var price: Int? =null,
    var isAvailable: Boolean = true
)
