package com.fbtm.clientapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class SuborderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Suborder suborder;
    private Button flavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suborder);

        suborder = new Suborder(1, PizzaSize.NORMAL, "Margherita");

        Spinner spinner = (Spinner) findViewById(R.id.pizza_amount_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.amount_numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.normal:
                if (checked)
                    suborder.setSize(PizzaSize.NORMAL);
                    break;
            case R.id.maxi:
                if (checked)
                    suborder.setSize(PizzaSize.MAXI);
                    break;
        }
    }

    public void choosePizzaFlavor(View view) {
        Intent intent = new Intent(this, FlavorsActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("choosen_flavor");
                updateButtonText(result);
                suborder.setFlavor(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }

    public void goToOrder(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("suborder", suborder.getAmount() + " " + suborder.getSize().getValue() + " " + suborder.getFlavor());
        startActivity(intent);
    }

    private void updateButtonText(String result) {
        flavor = (Button) findViewById(R.id.flavors);
        flavor.setText(result);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        suborder.setAmount(position+1);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
