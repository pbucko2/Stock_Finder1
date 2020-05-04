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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // contentview and button Ids need to be filled out once buttons and layout are made
        // setContentView(R.layout."") "" = inner info
        final Button startApple = findViewById();
        buttonClick(startApple, "AAPL");
        final Button startGoogle = findViewById();
        buttonClick(startGoogle, "GOOG");
        final Button startAmazon = findViewById();
        buttonClick(startAmazon, "AMZN");
        final Button startTesla = findViewById();
        buttonClick(startTesla, "TSLA");
        final Button startGE = findViewById();
        buttonClick(startGE, "GE");
    }
    public void putStockInfo(String setSymbol) {
        private final BarchartOnDemandClient onDemand = new BarchartOnDemandClient.Builder().apiKey(cd056e96e9f950cfd64b93565b12b399).build();
        final QuoteRequest.Builder builder = new QuoteRequest.Builder();
        builder.symbols(new String[] {"AAPL", "GOOG", "AMZN", "TSLA", "GE"});
        builder.mode(QuoteRequest.QuoteRequestMode.REAL_TIME);
        try {
            final Quotes quotes = onDemand.fetch(builder.build());
            // The Id corresponds to the text on the UI
            TextView currentPrice = findViewById();
            TextView currentHigh = findViewById();
            TextView currentLow = findViewById();
            TextView currentVol = findViewById();
            // this is where the symbol is used
            double price = quotes.bySymbol(setSymbol).getLastPrice();
            double high = quotes.bySymbol(setSymbol).getHigh();
            double low = quotes.bySymbol(setSymbol).getLow();
            long volume = quotes.bySymbol(setSymbol).getVolume();
            currentPrice.setText("Current Price: " + price);
            currentHigh.setText("Current High: " + high);
            currentLow.setText("Current Low: " + low);
            currentVol.setText("Volume: " + volume);
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
