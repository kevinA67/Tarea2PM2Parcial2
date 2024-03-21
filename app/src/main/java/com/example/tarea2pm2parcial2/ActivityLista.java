package com.example.tarea2pm2parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarea2pm2parcial2.Config.Datos;
import com.example.tarea2pm2parcial2.Config.ListAdapter;
import com.example.tarea2pm2parcial2.Config.RestApi;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityLista extends AppCompatActivity {

    private RequestQueue requestQueue;
    List<Datos> listDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        requestQueue = Volley.newRequestQueue(getApplicationContext());

        GetApiData();
    }

    private void GetApiData() {
        listDatos = new ArrayList<>();

        JsonArrayRequest request = new JsonArrayRequest(RestApi.EndpointGet, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject obj = response.getJSONObject(i);
                            Datos datos = new Datos();
                            datos.setId(obj.get("userId").toString());
                            datos.setSubId(obj.get("id").toString());
                            listDatos.add(new Datos(datos.getId(), datos.getSubId()));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    llenarLista();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error: "+error,Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(request);

    }

    private void llenarLista() {
        ListAdapter listAdapter=new ListAdapter(listDatos,this);
        RecyclerView recyclerView=findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}