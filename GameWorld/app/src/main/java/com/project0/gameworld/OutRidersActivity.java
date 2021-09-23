package com.project0.gameworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OutRidersActivity extends AppCompatActivity {

    private TextView ProductName, ProductPrice, ProductDescription;
    private ImageView img;
    Button AddCart;
    Context go;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_riders);

        ProductName = (TextView) findViewById(R.id.product_name);
        ProductPrice = (TextView) findViewById(R.id.ProductPrice);
        ProductDescription = (TextView) findViewById(R.id.Product_description);
        img = (ImageView) findViewById(R.id.product_image);
        AddCart = (Button) findViewById(R.id.add_cart);

        //Receive Data
        Intent intent = getIntent();
        String Product_Name = intent.getExtras().getString("Product Name");
        String Product_Price = intent.getExtras().getString("Product Price");
        String Product_Description = intent.getExtras().getString("Product Description");
        int Product_image = intent.getExtras().getInt("Product Image");

        //Set values
        ProductName.setText(Product_Name);
        ProductPrice.setText(Product_Price);
        ProductDescription.setText(Product_Description);
        img.setImageResource(Product_image);

        AddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OutRidersActivity.this, CartActivity.class));
            }
        });
    }
}