package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.newproject.adapters.RetrofitAdapters;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);
    recyclerView=findViewById(R.id.recyclerView);
//    getSupportActionBar().hide();

       getProduct();
    //    deleteProduct();

    }

    private void deleteProduct() {
        Call<List<Product>>deleteCall=RetrofitClient.getInstance().getApi().deleteProduct(6);
        deleteCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (!response.isSuccessful()){
                    return;
                }
Toast.makeText(MainActivity.this,"Deleted"+response.code(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    private void getProduct() {

        Call<List<Product>>apiCall=RetrofitClient.getInstance().getApi().getProduct();
        apiCall.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> products=response.body();
                setAdapter(products);

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(List<Product> products) {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RetrofitAdapters retrofitAdapters= new RetrofitAdapters(this,products);
        recyclerView.setAdapter(retrofitAdapters);
    }
}