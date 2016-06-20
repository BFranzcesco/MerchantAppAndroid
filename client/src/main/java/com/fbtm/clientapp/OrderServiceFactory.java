package com.fbtm.clientapp;

import retrofit2.Retrofit;

public class OrderServiceFactory extends ServiceFactory<OrderService> {
    @Override
    protected OrderService getRetrofitInstance(Retrofit retrofit) {
        return retrofit.create(OrderService.class);
    }
}
