package com.hcvardar.manne.rkvaradr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.hcvardar.manne.rkvaradr.Adapter.EkipaAdapter;
import com.hcvardar.manne.rkvaradr.Model.EkipaData;
import com.hcvardar.manne.rkvaradr.Model.EkipaModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EkipaActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewPeople)
    RecyclerView recyclerView;
    EkipaAdapter adapter;
    EkipaData data;
    EkipaModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ekipa);
        ButterKnife.bind(this);
        model=new EkipaModel();
        data=new EkipaData();

        adapter = new EkipaAdapter(this, new Row_Click_Listener() {
            @Override
            public void onRowClick(EkipaModel model, int position) {
                Intent intent = new Intent(EkipaActivity.this, IgracActivity.class);
                intent.putExtra("EXTRA", model);
                intent.putExtra("POS", position);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getList(this, true));
        adapter.notifyDataSetChanged();

    }
}
