package com.minhnv.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.minhnv.lab4.adapter.AdapterCategory;
import com.minhnv.lab4.model.Categoryy;
import com.minhnv.lab4.ultil.APIUltil;
import com.minhnv.lab4.ultil.OnItemListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRycCates;
    private AdapterCategory adapterCategory;
    private List<Categoryy> categoryys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRycCates = findViewById(R.id.ryc_cates);
        mRycCates.setLayoutManager(new LinearLayoutManager(this));
        mRycCates.setHasFixedSize(true);

        loaddata();
    }

    public void loaddata() {

        APIUltil.getData().getCategory("1","10").enqueue(new Callback<List<Categoryy>>() {
            @Override
            public void onResponse(Call<List<Categoryy>> call, Response<List<Categoryy>> response) {

            categoryys = response.body();
               adapterCategory = new AdapterCategory(categoryys, MainActivity.this, new OnItemListener() {
                   @Override
                   public void OnItemlistener(int position) {
                    startActivity(new Intent(getApplicationContext(), PostCatesActivity.class));
                   }
               });
               mRycCates.setAdapter(adapterCategory);
               Log.d("abc",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Categoryy>> call, Throwable t) {
                Log.e("FF", t.getMessage());

            }
        });


    }
}
