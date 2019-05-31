package com.example.rpp_lab_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecViewAdapter recRecViewAdapter;
    public static ArrayList<Element> technologies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getJson();


    }

    public void getJson()
    {
        int count = 0;
        String json;
        try{
            InputStream is = getAssets().open("techno.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONArray arr = new JSONArray(json);
            for (int i = 0; i<arr.length(); i++)
            {
                Element element = new Element();
                element.setName(arr.getJSONObject(i).getString("name"));
                element.setGraphic(arr.getJSONObject(i).getString("graphic"));
                if(arr.getJSONObject(i).has("helptext"))
                {
                    element.setHelptext(arr.getJSONObject(i).getString("helptext"));
                }
                else element.setHelptext("");
                technologies.add(element);
                count++;
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("TimLog", count +"");
    }

    public void init()
    {
        technologies = new ArrayList<>();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler);
        recRecViewAdapter = new RecViewAdapter();
        recyclerView.setAdapter(recRecViewAdapter);
        recyclerView.setLayoutManager(llm);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
