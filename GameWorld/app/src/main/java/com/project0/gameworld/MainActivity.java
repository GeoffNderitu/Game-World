package com.project0.gameworld;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<ProductDiscount> product_one;
    Button Cart;
    Button About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cart = findViewById(R.id.mBtnCart);
        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        About= findViewById(R.id.mBTnABout);
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
            }
        });

        product_one = new ArrayList<>();
        product_one.add(new ProductDiscount("Ps4 Destiny 2 Bundle","Gaming Console","Ksh.35000",R.drawable.destinyps4l));
        product_one.add(new ProductDiscount("Xbox One Controller","Xbox One Gears of War Controller","Ksh.3000",R.drawable.download4));
        product_one.add(new ProductDiscount("Xbox Series X","Gaming Console","Ksh.45000",R.drawable.seriesx));
        product_one.add(new ProductDiscount("Outriders Xbox Series X","Action Video Game","Ksh.4500",R.drawable.outriderse));
        product_one.add(new ProductDiscount("Ps4 Controller","Ps4 Rose-gold Controller","Ksh.3000",R.drawable.rosegoldps4));
        product_one.add(new ProductDiscount("Ps4 Destiny 2 Bundle","Gaming Console","Ksh.35000",R.drawable.destinyps4l));
        product_one.add(new ProductDiscount("Xbox One Controller","Xbox One Grey Controller","Ksh.3000",R.drawable.xboxcrgrey));
        product_one.add(new ProductDiscount("Watch Dogs Legion","For PLaystation 4","Ksh.4500",R.drawable.wdl));
        product_one.add(new ProductDiscount("Spider-man Miles Morales","For PLaystation 4","Ksh.4500",R.drawable.spdmm));
        product_one.add(new ProductDiscount("Gears 5","Xbox One Exclusive","Ksh.5000",R.drawable.gears5));
        product_one.add(new ProductDiscount("Ps4 Destiny 2 Bundle","Gaming Console","Ksh.35000",R.drawable.destinyps4l));
        product_one.add(new ProductDiscount("Xbox One Controller","Xbox One Gears of War Controller","Ksh.3000",R.drawable.download4));
        product_one.add(new ProductDiscount("Xbox Series X","Gaming Console","Ksh.45000",R.drawable.seriesx));
        product_one.add(new ProductDiscount("Outriders Xbox Series X","Action Video Game","Ksh.4500",R.drawable.outriderse));
        product_one.add(new ProductDiscount("Ps4 Controller","Ps4 Rose-gold Controller","Ksh.3000",R.drawable.rosegoldps4));

        RecyclerView my_recycleView = (RecyclerView) findViewById(R.id.discountRecycler);
        ProductDiscAdapter myAdapter = new ProductDiscAdapter(this,product_one);
        my_recycleView.setLayoutManager(new GridLayoutManager(this,3));
        my_recycleView.setAdapter(myAdapter);

        //Onclick listener for User

    }


}