package com.cdgodoy.randomanimequote;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

// https://public-apis.io/category/anime-apis
// https://animechanapi.xyz/documentation#random
// https://animechanapi.xyz/api/quotes/random

public class MainActivity extends AppCompatActivity {

    private TextView animeTitle;
    private TextView animeQuote;
    private TextView animeCharacter;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animeTitle = findViewById(R.id.anime_title);
        animeQuote = findViewById(R.id.anime_quote);
        animeCharacter = findViewById(R.id.quoted_character);

        queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://animechanapi.xyz/api/quotes/random", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = new Gson();
                MyPojo pojo = gson.fromJson(response.toString(),  MyPojo.class);
                String quote = pojo.getData().get(0).getQuote();
                String character = pojo.getData().get(0).getCharacter();
                String anime = pojo.getData().get(0).getAnime();
                animeQuote.setText(quote);
                animeTitle.setText(anime);
                animeCharacter.setText(character);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonObjectRequest);

    }
}