package com.fbtm.clientapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {

    private String suborder;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        setContentView(R.layout.activity_order);
        suborder = getIntent().getStringExtra("suborder");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.order_button) void order() {
        String message = suborder;
        OrderService service = new OrderServiceFactory().getInstance();
        Call<Void> callback = service.order(message);
        callback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(context, R.string.order_sent, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("ERROR","Order sending failure");
            }
        });
    }
}
