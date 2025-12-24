package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.team.EkipaAdapter;
import com.hcvardar.manne.rkvaradr.ui.fragments.PlayerFragment;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NonConstantResourceId")
public class EkipaActivity extends AppCompatActivity {


    @BindView(R.id.recyclerViewPeople)
    RecyclerView recyclerView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    EkipaAdapter adapter;
    EkipaModel model;

    @SuppressLint({"SourceLockedOrientationActivity", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ekipa);
        ButterKnife.bind(this);
        model=new EkipaModel();

        if(getIntent().hasExtra("player_info")){
            model = (EkipaModel) getIntent().getSerializableExtra("player_info");
            PlayerFragment fragment = new PlayerFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("current_player", model);
            fragment.setArguments(bundle);
            replaceFragment(fragment);
        }

        adapter = new EkipaAdapter(this, (model, position) -> {
            PlayerFragment fragment = new PlayerFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("current_player", model);
            fragment.setArguments(bundle);
            replaceFragment(fragment);
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getList(this, 0));
        adapter.notifyDataSetChanged();

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
}
