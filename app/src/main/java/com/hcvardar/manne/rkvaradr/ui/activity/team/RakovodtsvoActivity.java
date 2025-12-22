package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.team.StrucenAdapter;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RakovodtsvoActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewStrucen)
    RecyclerView recyclerView;
    StrucenAdapter adapter;

    String imgUrl1="https://rkvardar.com.mk/wp-content/uploads/2022/12/mihajlo-mihajlovski-23997.png";

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rakovodstvo);
        ButterKnife.bind(this);

        adapter = new StrucenAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getList();

    }

    public void getList(){
        ArrayList<EkipaModel> model = new ArrayList<>();
        model.add(new EkipaModel("Михајло Михајловски", imgUrl1,"претседател"));
        adapter.setItems(model);
    }
}
