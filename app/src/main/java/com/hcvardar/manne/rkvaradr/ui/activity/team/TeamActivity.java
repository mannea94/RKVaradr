package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.team.SortedTeamAdapter;
import com.hcvardar.manne.rkvaradr.ui.fragments.team.PlayerFragment;
import com.hcvardar.manne.rkvaradr.ui.model.team.PlayerPosition;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.ui.model.team.Player;
import com.hcvardar.manne.rkvaradr.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NonConstantResourceId")
public class TeamActivity extends AppCompatActivity {


    @BindView(R.id.recyclerViewPeople)
    RecyclerView recyclerView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    Player model;

    ArrayList<PlayerPosition> playerPositions;
    SortedTeamAdapter sortedTeamAdapter;

    @SuppressLint({"SourceLockedOrientationActivity", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);

        model = new Player();

        if(getIntent().hasExtra("player_info")){
            handleOnBackPressed();
            model = (Player) getIntent().getSerializableExtra("player_info");
            PlayerFragment fragment = new PlayerFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("current_player", model);
            fragment.setArguments(bundle);
            replaceFragment(fragment);
        }else {
            playerPositions = new GlobalClass().getSortedList(this, 1);
            sortedTeamAdapter = new SortedTeamAdapter(this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(sortedTeamAdapter);
            sortedTeamAdapter.setItems(playerPositions);
        }
        setActionBarInfo();
    }

    public void setActionBarInfo(){
        tvName.setText(R.string.team);
        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public void handleOnBackPressed(){
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish();
            }
        });
    }
}
