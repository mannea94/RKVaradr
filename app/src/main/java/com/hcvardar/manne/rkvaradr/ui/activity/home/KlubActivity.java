package com.hcvardar.manne.rkvaradr.ui.activity.home;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.adapter.ClubHistoryAdapter;
import com.hcvardar.manne.rkvaradr.ui.adapter.ClubInfoAdapter;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KlubActivity extends AppCompatActivity {

    @BindView(R.id.rvClubInfo)
    RecyclerView rvClubInfo;
    @BindView(R.id.rvClubHistory)
    RecyclerView rvClubHistory;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;

    ClubInfoAdapter adapter;
    ClubHistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klub);
        ButterKnife.bind(this);

        adapter = new ClubInfoAdapter(this);
        rvClubInfo.setLayoutManager(new LinearLayoutManager(this));
        rvClubInfo.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getListClubInfo(this, 8));

        historyAdapter = new ClubHistoryAdapter(this);
        rvClubHistory.setLayoutManager(new LinearLayoutManager(this));
        rvClubHistory.setAdapter(historyAdapter);
        historyAdapter.setItems(new GlobalClass().getListClubInfo(this, 9));
        historyAdapter.notifyDataSetChanged();

        setActionBarInfo();
    }

    public void setActionBarInfo(){
        tvName.setText(R.string.for_club);
        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }
}
