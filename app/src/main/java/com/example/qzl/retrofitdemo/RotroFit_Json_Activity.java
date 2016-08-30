package com.example.qzl.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.qzl.retrofitdemo.adapter.MyAdapter;
import com.example.qzl.retrofitdemo.bean.Cook;
import com.example.qzl.retrofitdemo.bean.Tngou;
import com.example.qzl.retrofitdemo.inter.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RotroFit_Json_Activity extends AppCompatActivity implements Callback<Tngou> {

    private MyAdapter mAdapter;
    private List<Cook> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotro_fit__json_);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.tngou.net").addConverterFactory(GsonConverterFactory.create()).build();
        Service service = retrofit.create(Service.class);
        //get方式请求
        //Call<Tngou> call = service.getList("cook",0, 1, 20);
        //post方式请求
        Call<Tngou> call = service.getPostList("cook",0, 1, 20);
        call.enqueue(this);

        ListView listView = (ListView) findViewById(R.id.list);
        mAdapter = new MyAdapter(this, new ArrayList<Cook>());
        listView.setAdapter(mAdapter);

    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        mList = response.body().getList();
        mAdapter.addAll(mList);
    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {
        t.printStackTrace();
    }
}
