package com.example.harajtask

import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.ProductsLoader.ProductListAdapter
import com.example.harajtask.ProductsLoader.ProductListAdapter.ProductDiff
import com.example.harajtask.ProductsMVVM.ProductViewModel
import com.example.harajtask.ProductsMVVM.ProductViewModelFactory


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.products_recyclerView)
        val view2 = this.window.decorView
        val viewModel: ProductViewModel = ViewModelProvider(
            this,
            ProductViewModelFactory(this.application)
        )
            .get(ProductViewModel::class.java)

        view2.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                view2.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val adapter = ProductListAdapter(ProductDiff(), view2.height)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


                adapter.submitList(viewModel.fetchAllProducts())

            }
        })




    }









}