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


    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(this);
        // setContentView(R.layout."") "" = inner info
        // final Button startApple = findViewById();
        // buttonClick(startApple, "AAPL");
        // final Button startGoogle = findViewById();
        // final Button startAmazon = findViewById();
        // final Button startTesla = findViewById();
        // final Button startGE = findViewById();
    }
    public void putStockInfo(String setSymbol) {
        private final BarchartOnDemandClient onDemand = new BarchartOnDemandClient.Builder().apiKey(cd056e96e9f950cfd64b93565b12b399).build();
        final QuoteRequest.Builder builder = new QuoteRequest.Builder();
        builder.symbols(new String[] {"AAPL", "GOOG", "AMZN", "TSLA", "GE"});
        builder.mode(QuoteRequest.QuoteRequestMode.REAL_TIME);
        String[] stockList = {"AAPL", "GOOG", "AMZN", "TSLA", "GE"};
        try {
            final Quotes quotes = onDemand.fetch(builder.build());
            // TextView currentAsk = findViewById();
            // repeat for high, low, and volume;
            double price = quotes.bySymbol(setSymbol).getLastPrice();
            double high = quotes.bySymbol(setSymbol).getHigh();
            double low = quotes.bySymbol(setSymbol).getLow();
            long volume = quotes.bySymbol(setSymbol).getVolume();
            // currentAsk.setText("Current Price : " + price);
            // repeat for all texts
        } catch (Exception e) {
            Log.d("MP5", "error");
        }
    }
    public void buttonClick(Button a, final String setSymbol) {
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                putStockInfo(setSymbol);
            }
        });
    }
}
