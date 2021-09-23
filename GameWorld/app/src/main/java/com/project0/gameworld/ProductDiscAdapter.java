package com.project0.gameworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductDiscAdapter extends RecyclerView.Adapter<ProductDiscAdapter.MyViewHolder> {

    private Context context;
    private List<ProductDiscount> data;


    public ProductDiscAdapter(Context context, List<ProductDiscount> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.cardview_item_product,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.product_name.setText(data.get(position).getTitle());
        holder.product_image.setImageResource(data.get(position).getProductImage());

        //Set OnclickListener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing data to the product activity
                Intent intent = new Intent(context, OutRidersActivity.class);
                intent.putExtra("Product Name",data.get(position).getTitle());
                intent.putExtra("Product Price",data.get(position).getPrice());
                intent.putExtra("Product Description",data.get(position).getDescription());
                intent.putExtra("Product Image",data.get(position).getProductImage());
                //start the activity
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView product_name;
        ImageView product_image;
        CardView cardView;

        public MyViewHolder(View itemView){
            super(itemView);

            product_name = (TextView) itemView.findViewById(R.id.product_title);
            product_image = (ImageView) itemView.findViewById(R.id.product_image);
            cardView = (CardView) itemView.findViewById(R.id.grid_cardView);


        }
    }

}
