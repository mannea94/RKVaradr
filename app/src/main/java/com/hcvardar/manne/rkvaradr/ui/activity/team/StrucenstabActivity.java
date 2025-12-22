package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

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
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    StrucenAdapter adapter;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_rakovodstvo);
        ButterKnife.bind(this);

        adapter = new StrucenAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getList(this, 1));

        setActionBarInfo();
    }

    public void setActionBarInfo(){
        tvName.setText(R.string.expert_stuff);
        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }

}
