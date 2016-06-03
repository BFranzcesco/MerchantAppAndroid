package com.fbtm.clientapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OrderService {
    @FormUrlEncoded @POST("order") Call<Void> order(@Field("message") String message);
}
