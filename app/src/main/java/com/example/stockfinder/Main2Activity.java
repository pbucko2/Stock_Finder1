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
import com.example.stockfinder.mp5.InsideInfo;

import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {
    public static Quotes quotes;
    public static double price;
    public static double high;
    public static double low;
    public static long volume;
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
            System.out.println(stock);
            stockInfo();

        });

        Button goog = findViewById(R.id.btn1);

        goog.setOnClickListener(v -> {
            stock = "GOOG";
            System.out.println(stock);
            stockInfo();

        });

        Button amzn = findViewById(R.id.btn2);

        amzn.setOnClickListener(v -> {
            stock = "AMZN";
            System.out.println(stock);
            stockInfo();
        });

        Button tsla = findViewById(R.id.btn3);

        tsla.setOnClickListener(v -> {
            stock = "TSLA";
            System.out.println(stock);
            stockInfo();
        });

        Button ge = findViewById(R.id.btn4);

        ge.setOnClickListener(v -> {
            stock = "GE";
            System.out.println(stock);
            stockInfo();
        });
    }

    private void stockInfo() {
        Intent startMain = new Intent(this,MainActivity.class);
        startMain.putExtra("name", stock);
        startActivity(startMain);
    }


}
