package com.example.harajtask.ProductsLoader;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.harajtask.DisplayProductActivity;
import com.example.harajtask.ProductsMVVM.Product;

public class ProductListAdapter extends ListAdapter<Product, ProductViewHolder> {

    private final int screen_height;
    public ProductListAdapter(@NonNull DiffUtil.ItemCallback<Product> diffCallback, int screen_height) {
        super(diffCallback);
        this.screen_height = screen_height;
    }



    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ProductViewHolder.create(parent, screen_height);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Product current = getItem(position);

        holder.bind(current.getProduct_title(), current.getProduct_location(), current.getUsername(), current.getProduct_date(),
                current.getComment_count(), current.getThumb_url());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = holder.itemView.getContext();

                //open the Display activity with the selected item
                Intent intent = new Intent(context, DisplayProductActivity.class);
                intent.putExtra("SelectedProduct", current);
                context.startActivity(intent);


            }
        });


    }



    public static class ProductDiff extends DiffUtil.ItemCallback<Product> {

        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getProduct_date() == newItem.getProduct_date();
        }
    }


}
