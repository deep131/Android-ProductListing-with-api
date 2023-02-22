package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView description,prices,totalamount,quantitydisplay;
    ImageView images;
    int quantity = 0;
    int position = 0;
    int price = 0;
    int finalprice = 0;
    Button addquantity, subquantity, addtocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        description=findViewById(R.id.description);
        prices=findViewById(R.id.prices);
        images=findViewById(R.id.images);
        addquantity=findViewById(R.id.addquantity);
        subquantity=findViewById(R.id.subquantity);
        addtocart=findViewById(R.id.addtocart);
        totalamount=findViewById(R.id.totalamount);
        quantitydisplay=findViewById(R.id.quantitydisplay);





        addquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               quantity = Integer.parseInt(quantitydisplay.getText().toString());

                quantity++;
                quantitydisplay.setText(String.valueOf(quantity));


                /*finalprice = quantity * price;
                totalamount.setText("Total is " + String.valueOf(quantity) + " x " + String.valueOf(finalprice));*/
            }
            });


        subquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                quantity = Integer.parseInt(quantitydisplay.getText().toString());


                if (quantity <= 0) {

                    quantity = 0;
                    finalprice = 0;


                } else {

                    quantity--;

                    quantitydisplay.setText(String.valueOf(quantity));
                   // totalamount.setText("Total is " + String.valueOf(quantity) + " x " + String.valueOf(finalprice));
                }
            }
            });

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity==0){

                    Toast.makeText(getApplicationContext(),"Nothing to Add",Toast.LENGTH_SHORT).show();

                }
                else if(quantity!=0){

                    Toast.makeText(getApplicationContext(),quantity+ " Item Added",Toast.LENGTH_SHORT).show();

                }
            }
        });



prices.setText(getIntent().getStringExtra("price"));
description.setText(getIntent().getStringExtra("description"));
Intent i=getIntent();
        String image = i.getStringExtra("image");
     Glide.with(DetailActivity.this).load(image).into(images);
    }
}