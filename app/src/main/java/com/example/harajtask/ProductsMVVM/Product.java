package com.example.harajtask.ProductsMVVM;


import java.io.Serializable;

public class Product implements Serializable {


    private final long product_date;
    private final String product_title,  username,  thumb_url, product_location, product_description;
    private final int comment_count;

    public Product(String product_title, String username,
                    String thumb_url, int comment_count,String product_location, long product_date,
                    String product_description) {

        this.product_title = product_title;
        this.username = username;
        this.thumb_url = thumb_url;
        this.comment_count = comment_count;
        this.product_location = product_location;
        this.product_date = product_date;
        this.product_description = product_description;
    }


    public long getProduct_date() {
        return product_date;
    }

    public String getProduct_title() {
        return product_title;
    }
    public String getUsername() {
        return username;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public int getComment_count() {
        return comment_count;
    }

    public String getProduct_location() {
        return product_location;
    }

    public String getProduct_description() {
        return product_description;
    }
}
