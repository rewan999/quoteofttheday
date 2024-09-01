package com.example.quote_of_the_day_encriptix;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    // https://run.mocky.io/v3/ce4c0ba8-231c-442c-a8dc-dc2f83dc7b67

    @GET("v3/ce4c0ba8-231c-442c-a8dc-dc2f83dc7b67")
    Call<ArrayList<QModel>> getdata();
}
