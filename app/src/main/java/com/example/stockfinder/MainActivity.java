package com.example.stockfinder;

import android.content.Intent;
import android.os.Bundle;
import com.example.stockfinder.Main2Activity;

import com.example.stockfinder.mp5.InsideInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUi();
    }


    private String name;
    private double high;
    private double low;
    private double price;
    private long volume;


    private void setUpUi() {

        Intent startMain = getIntent();
        name = startMain.getStringExtra("name");
        InsideInfo stockTime = new InsideInfo();
        stockTime.putStockInfo(name);
        System.out.println("reached");

        high = stockTime.high;
        String stringHigh = String.valueOf(high);

        low = stockTime.low;
        String stringLow = String.valueOf(low);

        price = stockTime.price;
        String stringPrice = String.valueOf(price);

        volume = stockTime.volume;
        String stringVol = String.valueOf(volume);

        TextView stockName = findViewById(R.id.stockname);
        stockName.setText(name);

        TextView stockHigh = findViewById(R.id.stockhigh);
        stockHigh.setText("HIGH:/t" + stringHigh);

        TextView stockLow = findViewById(R.id.stocklow);
        stockLow.setText("LOW:/t" + stringLow);

        TextView stockPrice = findViewById(R.id.stockprice);
        stockPrice.setText("PRICE:/t" + stringPrice);

        TextView stockVol = findViewById(R.id.stockvol);
        stockVol.setText("VOLUME:/t" + stringVol);

    }

}
