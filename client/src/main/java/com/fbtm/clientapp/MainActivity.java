package com.fbtm.clientapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String API_BASE_URL = "https://dry-badlands-78035.herokuapp.com/";
    public static final String[] NAMES = {"Margherita", "Pioggia", "4 Stagioni", "Wurstel", "Salamino", "Romana", "Zingara", "Crudo e gorgonzola", "Zucchine e gamberetti", "Vegetariana", "Misto bosco", "Peperoni", "Tonno e cipolle", "Bomba"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listView = (ListView) findViewById(R.id.pizzas_list);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, android.R.id.text1, NAMES));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setItemChecked(0, true);
    }

    @OnClick(R.id.order_button) void order() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OrderService service = retrofit.create(OrderService.class);
        String message = (String) listView.getAdapter().getItem(listView.getCheckedItemPosition());
        Call<Void> callback = service.order(message);
        callback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("","");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("","");
            }
        });
    }
}
