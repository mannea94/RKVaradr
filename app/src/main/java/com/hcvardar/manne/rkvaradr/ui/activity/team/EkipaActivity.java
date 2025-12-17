package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.team.EkipaAdapter;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaData;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.interfaces.Row_Click_Listener;

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
        adapter.setItems(new GlobalClass().getList(this, 0));
        adapter.notifyDataSetChanged();

    }
}
