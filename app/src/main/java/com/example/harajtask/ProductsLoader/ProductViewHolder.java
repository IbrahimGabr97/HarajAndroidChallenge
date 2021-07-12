package com.example.harajtask.ProductsLoader;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.harajtask.GeneralClasses.BasicMethods;
import com.example.harajtask.R;
import com.squareup.picasso.Picasso;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private final TextView product_title, product_location, product_username, product_date, product_comments_count;
    private final ImageView product_thumb;

    private ProductViewHolder(View itemView) {
        super(itemView);

        product_title = itemView.findViewById(R.id.product_holder_title);
        product_location = itemView.findViewById(R.id.product_holder_location);
        product_username = itemView.findViewById(R.id.product_holder_username);
        product_date = itemView.findViewById(R.id.product_holder_date);
        product_comments_count = itemView.findViewById(R.id.product_holder_commentsCount);


        product_thumb = itemView.findViewById(R.id.product_holder_thumb);

    }


    public void bind(String title, String location, String username, long date, int comments_count, String thumb_url) {
        product_title.setText(title);
        product_location.setText(location);
        product_username.setText(username);
        product_date.setText(""+BasicMethods.dateToString(date, ""));


        //display comments count if and only if counts greater than 0
        if (comments_count != 0){
            product_comments_count.setVisibility(View.VISIBLE);
            product_comments_count.setText(""+comments_count);
        }else
            product_comments_count.setVisibility(View.INVISIBLE);




        //for rounded corners
        product_thumb.setClipToOutline(true);


        //check internet connection to load the product thumb
        if (BasicMethods.isInternetAvailable(itemView.getContext()))
        Picasso.with(itemView.getContext())
                .load(thumb_url).fit().into(product_thumb);

        else
            Toast.makeText(itemView.getContext(), "Please check your internet connection then try again",
                    Toast.LENGTH_SHORT).show();

    }


    static ProductViewHolder create(ViewGroup parent, int screen_height) {
        View viewRoot = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_holder_layout, parent, false);


        //to make a product holder has a percentage height depending on the device screen height
        ViewGroup.LayoutParams params=viewRoot.getLayoutParams();
        params.height=(int)(screen_height*0.135);
        viewRoot.setLayoutParams(params);



        return new ProductViewHolder(viewRoot);
    }

}
