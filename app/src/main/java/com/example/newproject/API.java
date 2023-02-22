package com.example.newproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    String BASE_URL="https://fakestoreapi.com/";
    @GET("products")
    Call<List<Product>> getProduct();


    @DELETE("products/6")
    Call<List<Product>> deleteProduct(@Path("6")int id);

}
