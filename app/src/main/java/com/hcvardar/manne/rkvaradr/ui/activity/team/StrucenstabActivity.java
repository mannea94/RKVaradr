package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.team.StrucenAdapter;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StrucenstabActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewStrucen)
    RecyclerView recyclerView;
    StrucenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_strucenstab);
        ButterKnife.bind(this);

        adapter = new StrucenAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getList(this, 1));
    }

}
