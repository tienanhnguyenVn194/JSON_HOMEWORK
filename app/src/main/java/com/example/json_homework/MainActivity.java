package com.example.json_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String json ="{\"coord\": { \"lon\": 139,\"lat\": 35}," +
            " \"weather\": [ { \"id\": 800, \"main\": \"Clear\", " +
            "\"description\": \"clear sky\", \"icon\": \"01n\" } ], " +
            "\"base\": \"stations\", \"main\": { \"temp\": 289.92," +
            " \"pressure\": 1009, \"humidity\": 92, \"temp_min\": 288.71," +
            " \"temp_max\": 290.93 }, \"wind\": { \"speed\": 0.47, \"deg\": 107.538 }," +
            " \"clouds\": { \"all\": 2 }, \"dt\": 1560350192, \"sys\": { \"type\": 3, \"id\": 2019346," +
            " \"message\": 0.0065, \"country\": \"JP\", \"sunrise\": 1560281377, \"sunset\": 1560333478 }, " +
            "\"timezone\": 32400, \"id\": 1851632, \"name\": \"Shuzenji\", \"cod\": 200 }";
    TextView tvJson,tvJson1;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJson = findViewById(R.id.tvJson);
        tvJson1 = findViewById(R.id.tvJson1);

        products = new ArrayList<>();
        try {

            JSONObject jsonObject = new JSONObject(json);

            JSONObject mainn = jsonObject.getJSONObject("main");

            String  temp = mainn.getString("temp");
            String pressure = mainn.getString("pressure");
            String humidity = mainn.getString("humidity");
            String temp_min = mainn.getString("temp_min");
            String temp_max = mainn.getString("temp_max");

            tvJson1.setText("Main:" +"\n"+"     temp: " + temp + "\n" +
                    "     pressure: " + pressure + "\n" +
                    "     humidity: " + humidity + "\n" +
                    "     temp_min: " + temp_min + "\n" +
                    "     temp_max: " + temp_max );

            JSONArray mang = jsonObject.getJSONArray("weather");
            Log.d("JSONARRAY_RESUST", "" + mang.toString());

            for (int i=0;i<mang.length();i++){

                JSONObject cit = mang.getJSONObject(i);
                Log.d("JSONOBJECT_RESULT", "" + cit.toString());

                int id = cit.getInt("id");
                String main = cit.getString("main");
                String description = cit.getString("description");
                String icon = cit.getString("icon");



                products.add(new Product(id,main,description,icon));

                Log.d("AAAA", "" + products.get(0).getId());

            }

            tvJson.setText("Weather: "+"\n"+products.get(0).getId()+"\n"+products.get(0).getMain()+"\n"+
                    products.get(0).getDescription()+"\n"+products.get(0).getIcon());

            Log.d("PRINT_RESULT", "" + products.get(0).getId() );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
