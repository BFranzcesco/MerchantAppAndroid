package com.fbtm.clientapp;

import retrofit2.Call;
import retrofit2.http.POST;

public interface OrderService {
    @POST("order") Call<Void> order();
}
