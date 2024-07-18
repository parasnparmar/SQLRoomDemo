package com.example.sqlroomdemo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao  {
    @Query("SELECT * From Products")
    fun getProducts(): List<Product>

    @Insert
    fun insertProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Query("delete from products where id = :id")
    fun deleteById(id: Int): Int
}