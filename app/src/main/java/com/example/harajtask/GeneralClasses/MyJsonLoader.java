package com.example.harajtask.GeneralClasses;

import android.content.Context;
import android.widget.Toast;

import com.example.harajtask.ProductsMVVM.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class MyJsonLoader {

    private final Context context;
    private final String file_name;

    public MyJsonLoader (Context context, String file_name){
        this.context = context;
        this.file_name = file_name;

    }

    private  String getJsonFile() {
        String json = null;
        try {

            InputStream is = context.getAssets().open(file_name+".json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, StandardCharsets.UTF_8);


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }




    public  ArrayList<Product> loadJsonFileData(){

        ArrayList<Product> productArrayList=new ArrayList<>();
        Product product=null;
        try {

            JSONArray jsonArray= new JSONArray(getJsonFile());

            for (int i=0;i<jsonArray.length();i++){

                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String title=jsonObject.getString("title");
                String username=jsonObject.getString("username");
                String thumbURL=jsonObject.getString("thumbURL");
                int commentCount=jsonObject.getInt("commentCount");
                String city=jsonObject.getString("city");
                long date=jsonObject.getLong("date");
                String body=jsonObject.getString("body");

                product = new Product(title, username, thumbURL, commentCount, city, date, body);
                productArrayList.add(product);
            }



        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Unexpected error", Toast.LENGTH_SHORT).show();
            return null;
        }

        return productArrayList;
    }

}
