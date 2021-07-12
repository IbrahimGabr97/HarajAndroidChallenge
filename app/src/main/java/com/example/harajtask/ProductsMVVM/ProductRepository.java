package com.example.harajtask.ProductsMVVM;

import android.app.Application;
import com.example.harajtask.GeneralClasses.MyJsonLoader;
import java.util.ArrayList;



class ProductRepository {

    private final MyJsonLoader myJsonLoader;
    private ArrayList<Product> cachedData;




    ProductRepository(Application application){

        myJsonLoader = new MyJsonLoader(application, "data");
        cachedData = new ArrayList<>();


    }





    public ArrayList<Product> getAllProducts () {

        if (cachedData !=null && cachedData.size() > 0){
            return cachedData;
        }

        ArrayList<Product> freshData = myJsonLoader.loadJsonFileData();
        cachedData = freshData;
        return freshData;


    }




}
