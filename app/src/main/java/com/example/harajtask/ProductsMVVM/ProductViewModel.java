package com.example.harajtask.ProductsMVVM;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;


import java.util.List;

public class ProductViewModel extends AndroidViewModel {


    private final ProductRepository productRepository;





    public ProductViewModel (Application application) {
        super(application);
        productRepository = new ProductRepository(application);


    }



    public List<Product> fetchAllProducts() {


        return productRepository.getAllProducts();

    }




}
