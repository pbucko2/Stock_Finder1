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

    final String[] stockList = new String[]{"AAPL", "GOOG", "AMZN", "TSLA", "GE"};
    private String name;
    private double high;
    private double low;
    private double price;
    private long volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpUi() {
        Main2Activity stockTime = new Main2Activity();
        name = stockTime.stock;
        stockTime.putStockInfo(name);
        System.out.println(name);

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
