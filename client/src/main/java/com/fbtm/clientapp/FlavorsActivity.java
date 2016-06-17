package com.fbtm.clientapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FlavorsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String[] NAMES = {"Margherita", "Pioggia", "4 Stagioni", "Wurstel", "Salamino", "Romana", "Zingara", "Crudo e gorgonzola", "Zucchine e gamberetti", "Vegetariana", "Misto bosco", "Peperoni", "Tonno e cipolle", "Bomba"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavors);

        listView = (ListView) findViewById(R.id.pizzas_list);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, NAMES));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent returnIntent = new Intent();
        String choosenFlavor = (String) parent.getItemAtPosition(position);
        returnIntent.putExtra("choosen_flavor", choosenFlavor);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
