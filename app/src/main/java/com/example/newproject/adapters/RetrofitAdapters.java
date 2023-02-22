package com.example.newproject.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newproject.DetailActivity;
import com.example.newproject.Product;
import com.example.newproject.R;

import java.util.List;

public class RetrofitAdapters extends RecyclerView.Adapter<RetrofitAdapters.MyViewHolder> {
    Context context;
    List<Product> products;

    public RetrofitAdapters(Context context,List<Product>products){
        this.products=products;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.product_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.text.setText(String.valueOf(products.get(position).getTitle()));
            holder.price.setText( "Price: "+String.valueOf(products.get(position).getPrice())+" ₹");
        //    holder.imageView.setImageResource(Integer.valueOf(products.get(position).getImage()));
           Glide.with(context).load(products.get(position).getImage()).placeholder(R.drawable.ic_launcher_background).
                error(R.drawable.ic_launcher_foreground).into(holder.imageView);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bundle bundle=new Bundle();
                //    bundle.putAll("image",products.get(position).getImage());
                    Intent intent=new Intent(context, DetailActivity.class);
                //    intent.putExtra("title",products.get(position).getTitle());
                    intent.putExtra("image",products.get(position).getImage());
                    intent.putExtra("price","Price: "+String.valueOf(products.get(position).getPrice())+" ₹");
                    intent.putExtra("description",products.get(position).getDescription());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text,price;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            text=itemView.findViewById(R.id.text);
            price=itemView.findViewById(R.id.price);

        }
    }
}
