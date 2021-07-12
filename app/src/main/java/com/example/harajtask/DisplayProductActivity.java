package com.example.harajtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.harajtask.GeneralClasses.BasicMethods;
import com.example.harajtask.ProductsMVVM.Product;
import com.squareup.picasso.Picasso;

public class DisplayProductActivity extends AppCompatActivity {

    private  ImageView product_thumb;
    private  TextView product_title, product_date, product_location, product_username, product_description;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_display_product);

        product = (Product) getIntent().getSerializableExtra("SelectedProduct");
        initializeView();
        fetchView();








    }


    private void initializeView(){
        product_thumb = findViewById(R.id.display_image_thumb);
        product_title = findViewById(R.id.display_text_title);
        product_date = findViewById(R.id.display_text_date);
        product_location = findViewById(R.id.display_text_location);
        product_username = findViewById(R.id.display_text_username);
        product_description = findViewById(R.id.display_text_description);

    }





    private void fetchView(){


        Picasso.with(this).load(product.getThumb_url()).fit().into(product_thumb);
        product_title.setText(product.getProduct_title());

        //display full date
        product_date.setText(BasicMethods.dateToString(product.getProduct_date(), "Full Date"));


        product_location.setText(product.getProduct_location());
        product_username.setText(product.getUsername());
        product_description.setText(product.getProduct_description());

    }




    public void shareProduct(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, product.getProduct_title());
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}