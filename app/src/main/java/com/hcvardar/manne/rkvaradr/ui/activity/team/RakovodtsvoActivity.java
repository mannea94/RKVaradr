package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.team.StrucenAdapter;
import com.hcvardar.manne.rkvaradr.ui.model.Player;
import com.hcvardar.manne.rkvaradr.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RakovodtsvoActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewStrucen)
    RecyclerView recyclerView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    StrucenAdapter adapter;

    String imgUrl1="https://rkvardar.com.mk/wp-content/uploads/2022/12/mihajlo-mihajlovski-23997.png";

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
        getList();
        setActionBarInfo();

    }

    public void getList(){
        ArrayList<Player> model = new ArrayList<>();
        model.add(new Player("Михајло Михајловски", imgUrl1,"претседател"));
        adapter.setItems(model);
    }

    public void setActionBarInfo(){
        tvName.setText(R.string.management);
        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }
}
