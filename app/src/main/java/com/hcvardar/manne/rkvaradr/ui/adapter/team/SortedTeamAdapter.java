package com.hcvardar.manne.rkvaradr.ui.adapter.team;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hcvardar.manne.rkvaradr.R;

import com.hcvardar.manne.rkvaradr.ui.activity.team.TeamActivity;
import com.hcvardar.manne.rkvaradr.ui.fragments.team.PlayerFragment;
import com.hcvardar.manne.rkvaradr.ui.model.team.Player;
import com.hcvardar.manne.rkvaradr.ui.model.team.PlayerPosition;
import com.hcvardar.manne.rkvaradr.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NonConstantResourceId")
public class SortedTeamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<PlayerPosition> playerPositions = new ArrayList<>();

    int TOP = 0, GOALKEEPER = 1, BACKS = 2, PICKER = 3, WINGS = 4, EXPERT_STUFF = 5;

    public void setItems(ArrayList<PlayerPosition> playerPositions){
        this.playerPositions = playerPositions;
    }

    public SortedTeamAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TOP) {
            view = inflater.inflate(R.layout.item_team_info, parent, false);
            return new TopViewHolder(view);
        }else if (viewType == GOALKEEPER) {
            view = inflater.inflate(R.layout.item_player_position, parent, false);
            return new GoalkeepersViewHolder(view);
        }else if(viewType == BACKS) {
            view = inflater.inflate(R.layout.item_player_position, parent, false);
            return new BacksViewHolder(view);
        }else if(viewType == PICKER) {
            view = inflater.inflate(R.layout.item_player_position, parent, false);
            return new PickerViewHolder(view);
        }else if(viewType == WINGS){
            view = inflater.inflate(R.layout.item_player_position, parent, false);
            return new WingsViewHolder(view);
        }else if(viewType == EXPERT_STUFF){
            view = inflater.inflate(R.layout.item_stuff_layout, parent, false);
            return new ExperStuffViewHolder(view);
        }else {
            view = inflater.inflate(R.layout.item_stuff_layout, parent, false);
            return new ManagementViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopViewHolder) {
            onBindTopViewHolder((TopViewHolder) holder, playerPositions.get(position).getPosition(), position);
        }else if (holder instanceof GoalkeepersViewHolder) {
            onBindGoalkeepersViewHolder((GoalkeepersViewHolder) holder, playerPositions.get(position).getPlayers(), position);
        } else if(holder instanceof BacksViewHolder){
            onBindBacksViewHolder((BacksViewHolder) holder, playerPositions.get(position).getPlayers(), position);
        } else if(holder instanceof PickerViewHolder){
            onBindPickerViewHolder((PickerViewHolder) holder, playerPositions.get(position).getPlayers(), position);
        } else if(holder instanceof WingsViewHolder){
            onBindWingsViewHolder((WingsViewHolder) holder, playerPositions.get(position).getPlayers(), position);
        }else if(holder instanceof ExperStuffViewHolder){
            onExpertStuffViewHolder((ExperStuffViewHolder) holder, playerPositions.get(position).getPlayers(), position);
        }else if(holder instanceof ManagementViewHolder){
            onManagementViewHolder((ManagementViewHolder) holder, playerPositions.get(position).getPlayers(), position);
        }
    }

    public void onBindTopViewHolder(TopViewHolder holder, String imgUrl, int position) {

        Glide.with(context)
                .load(Constants.VARDAR_UPLOADS_URL.concat(Constants.TEAM_URL))
                .into(holder.ivTeam);
    }
    public void onBindGoalkeepersViewHolder(GoalkeepersViewHolder holder, ArrayList<Player> players, int position) {

        holder.tvPosition.setText(context.getResources().getString(R.string.goalkeepers));

        setAdapterAndRecyclerView(holder.rvPlayers, players);
    }

    public void onBindBacksViewHolder(BacksViewHolder holder, ArrayList<Player> players, int position) {

        holder.tvPosition.setText(context.getResources().getString(R.string.backs));

        setAdapterAndRecyclerView(holder.rvPlayers, players);
    }

    public void onBindPickerViewHolder(PickerViewHolder holder, ArrayList<Player> players, int position) {

        holder.tvPosition.setText(context.getResources().getString(R.string.pickers));

        setAdapterAndRecyclerView(holder.rvPlayers, players);
    }

    public void onBindWingsViewHolder(WingsViewHolder holder, ArrayList<Player> players, int position) {

        holder.tvPosition.setText(context.getResources().getString(R.string.wings));

        setAdapterAndRecyclerView(holder.rvPlayers, players);
    }

    public void onExpertStuffViewHolder(ExperStuffViewHolder holder, ArrayList<Player> players, int position) {

        holder.tvPosition.setText(context.getResources().getString(R.string.expert_stuff));

        setAdapterAndRecyclerViewStuff(holder.rvPlayers, players);

    }

    public void onManagementViewHolder(ManagementViewHolder holder, ArrayList<Player> players, int position) {

        holder.tvPosition.setText(context.getResources().getString(R.string.management));

        setAdapterAndRecyclerViewStuff(holder.rvPlayers, players);


    }

    @Override
    public int getItemCount() {
        return playerPositions.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class TopViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_team)
        ImageView ivTeam;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public static class GoalkeepersViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPosition)
        TextView tvPosition;
        @BindView(R.id.rvPlayers)
        RecyclerView rvPlayers;

        public GoalkeepersViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class BacksViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPosition)
        TextView tvPosition;
        @BindView(R.id.rvPlayers)
        RecyclerView rvPlayers;
        public BacksViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class PickerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPosition)
        TextView tvPosition;
        @BindView(R.id.rvPlayers)
        RecyclerView rvPlayers;
        public PickerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class WingsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPosition)
        TextView tvPosition;
        @BindView(R.id.rvPlayers)
        RecyclerView rvPlayers;
        public WingsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ExperStuffViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPosition)
        TextView tvPosition;
        @BindView(R.id.rvPlayers)
        RecyclerView rvPlayers;
        public ExperStuffViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ManagementViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvPosition)
        TextView tvPosition;
        @BindView(R.id.rvPlayers)
        RecyclerView rvPlayers;
        public ManagementViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void goToPlayerInfo(Player player){
        PlayerFragment fragment = new PlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("current_player", player);
        fragment.setArguments(bundle);
        ((TeamActivity)context).replaceFragment(fragment);
    }

    public void setAdapterAndRecyclerView(RecyclerView rvPlayers, ArrayList<Player> players){

        TeamAdapter adapter = new TeamAdapter(context, (model, itemPosition) -> {
            goToPlayerInfo(model);
        });
        rvPlayers.setHasFixedSize(true);
        rvPlayers.setLayoutManager(new LinearLayoutManager(context));
        rvPlayers.setAdapter(adapter);
        adapter.setItems(players);

    }

    public void setAdapterAndRecyclerViewStuff(RecyclerView rvPlayers, ArrayList<Player> players){
        StuffAdapter adapter = new StuffAdapter(context);
        rvPlayers.setHasFixedSize(true);
        rvPlayers.setLayoutManager(new LinearLayoutManager(context));
        rvPlayers.setAdapter(adapter);
        adapter.setItems(players);
    }
}
