package com.t3ch.shaj.jsonparsingwithvolley;

/**
 * Created by Shakil Ahmed Shaj on 9/11/2018
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mrubel.tuntuninews.R;

import java.util.HashMap;
import java.util.Map;

public class AddingNews extends AppCompatActivity {

    EditText _title, _date, _news;
    Button _submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_news);

        _title = findViewById(R.id.news_title);
        _date = findViewById(R.id.news_date);
        _news = findViewById(R.id.new_details);

        _submit = findViewById(R.id.submit_news);


        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://192.168.0.106/a/api/post.php";


                StringRequest sq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    protected Map<String, String> getParams() {
                        Map<String, String> parr = new HashMap<String, String>();

                        parr.put("mytitle", _title.getText().toString());
                        parr.put("mydate", _date.getText().toString());
                        parr.put("mynews", _news.getText().toString());

                        return parr;

                    }

                };


                AppController.getInstance().addToRequestQueue(sq);
                Toast.makeText(getApplicationContext(), "News published Successfully!", Toast.LENGTH_LONG).show();

            }

        });
    }
}