package com.example.stockfinder;

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

public class Main2Activity extends AppCompatActivity {
    public Quotes quotes;
    public double price;
    public double high;
    public double low;
    public long volume;
    public static String stock;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_main2);
        // final Button startApple = findViewById();
        // buttonClick(startApple, "AAPL");
        // final Button startGoogle = findViewById();
        // final Button startAmazon = findViewById();
        // final Button startTesla = findViewById();
        // final Button startGE = findViewById();



        Button apl = findViewById(R.id.btn0);

        apl.setOnClickListener(v -> {
            stock = "AAPL";
            stockInfo();

        });

        Button goog = findViewById(R.id.btn1);

        goog.setOnClickListener(v -> {
            stock = "GOOG";
            stockInfo();

        });

        Button amzn = findViewById(R.id.btn2);

        amzn.setOnClickListener(v -> {
            stock = "AMZN";

            stockInfo();
        });

        Button tsla = findViewById(R.id.btn3);

        tsla.setOnClickListener(v -> {
            stock = "TSLA";

            stockInfo();
        });

        Button ge = findViewById(R.id.btn4);

        ge.setOnClickListener(v -> {
            stock = "GE";

            stockInfo();
        });
    }

    private void stockInfo() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void putStockInfo(String setSymbol) {
        String apiKey = "cd056e96e9f950cfd64b93565b12b399";
        final BarchartOnDemandClient onDemand = new BarchartOnDemandClient.Builder().
                apiKey(apiKey).build();
        final QuoteRequest.Builder builder = new QuoteRequest.Builder();
        builder.symbols(new String[] {"AAPL", "GOOG", "AMZN", "TSLA", "GE"});
        builder.mode(QuoteRequest.QuoteRequestMode.REAL_TIME);
        final String[] stockList = {"AAPL", "GOOG", "AMZN", "TSLA", "GE"};

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
