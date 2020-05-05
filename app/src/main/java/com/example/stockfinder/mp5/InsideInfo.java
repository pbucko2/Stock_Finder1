package com.example.stockfinder.mp5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.barchart.ondemand.BarchartOnDemandClient;
import com.barchart.ondemand.api.QuoteRequest;
import com.barchart.ondemand.api.responses.Quote;
import com.barchart.ondemand.api.responses.Quotes;
import com.example.stockfinder.R;

import org.json.JSONObject;

public class InsideInfo extends AppCompatActivity {

    public Quotes quotes;
    public double price;
    public double high;
    public double low;
    public long volume;
    public String stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // contentview and button Ids need to be filled out once buttons and layout are made
        // setContentView(R.layout."") "" = inner info

    }
    public void putStockInfo(String setSymbol) {
        String apiKey = "cd056e96e9f950cfd64b93565b12b399";
        final BarchartOnDemandClient onDemand = new BarchartOnDemandClient.Builder().
                apiKey(apiKey).build();
        final QuoteRequest.Builder builder = new QuoteRequest.Builder();
        builder.symbols(new String[] {"AAPL", "GOOG", "AMZN", "TSLA", "GE"});
        builder.mode(QuoteRequest.QuoteRequestMode.REAL_TIME);

        try {
            quotes = onDemand.fetch(builder.build());
            // TextView currentAsk = findViewById();
            // repeat for high, low, and volume;
            price = quotes.bySymbol(setSymbol).getLastPrice();
            high = quotes.bySymbol(setSymbol).getHigh();
            low = quotes.bySymbol(setSymbol).getLow();
            volume = quotes.bySymbol(setSymbol).getVolume();
            // currentAsk.setText("Current Price : " + price);
            // repeat for all texts
        } catch (Exception e) {
            Log.d("MP5", "error");
        }
    }
}
