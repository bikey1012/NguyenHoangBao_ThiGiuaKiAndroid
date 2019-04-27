package com.example.a1606020003_nguyenhoangbao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<PhoneModel> models;
    String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        models = new ArrayList<>();
        recyclerView = findViewById(R.id.phone_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        Map<String,String> mMap = new HashMap<>();
        mMap.put("id","8");
        new PhoneAsyncTask(new IView() {
            @Override
            public void onGetDataSuccess(JSONArray jsonArray) {

                for (int i=0;i<jsonArray.length();i++){
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        PhoneModel model = new PhoneModel();
                        model.setProduct_Name(jsonObject.getString("product_name"));
                        model.setDesrciption(jsonObject.getString("description"));
                        model.setPrice(Integer.valueOf(jsonObject.getString("price")));
                        model.setProducer(jsonObject.getString("producer"));
                        model.setID(Integer.valueOf(jsonObject.getString("id")));
                        models.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                MyViewAdapter adapter = new MyViewAdapter(PhoneActivity.this,R.layout.phone_item,models);
                recyclerView.setAdapter(adapter);
            }
        },mMap).execute("http://www.vidophp.tk/api/account/getdata");
    }
}
