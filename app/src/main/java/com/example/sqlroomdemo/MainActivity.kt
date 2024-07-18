package com.example.sqlroomdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import androidx.room.RoomDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val productDatabase = Room.databaseBuilder(
            this,
            ProductDatabase::class.java,
            "db_prducsts"
        ).allowMainThreadQueries().build()
        val productDao = productDatabase.getProductDao()
        productDao.insertProduct(Product(1,"Product 1",1000))
        productDao.insertProduct(Product(2,"Product 2",2000))
        productDao.insertProduct(Product(3,"Product 3",3000))

        var products = productDao.getProducts()
        for (eachProduct in products){
            Log.d("Tag","Each Product --  ${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }

        productDao.updateProduct(Product(3,"new product",50000))
        for (eachProduct in productDao.getProducts()){
            Log.d("Tag Update", "Each Prodct -- ${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }

        productDao.deleteProduct(Product(2,"Product 2",2000))
        for(eachProduct in productDao.getProducts()){
            Log.d("Tag Delete","Each Product -- ${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }

        productDao.deleteById(1)
        for(eachProduct in productDao.getProducts()){
            Log.d("Tag DeletebyId", "Each Product -- ${eachProduct.id} -- ${eachProduct.title} -- ${eachProduct.price}")
        }
    }
}