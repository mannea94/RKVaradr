package com.hcvardar.manne.rkvaradr.ui.fragments.results;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.adapter.home.TableResultsAdapter;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */
@SuppressLint("NonConstantResourceId")
public class SuperLigaFragment extends Fragment {
    public Unbinder mUnBinder;


    @BindView(R.id.rvTableResults)
    RecyclerView rvTableResults;
    TableResultsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table_results, container, false);
        mUnBinder = ButterKnife.bind(this, view);

        adapter = new TableResultsAdapter(getActivity());
        rvTableResults.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTableResults.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getListTableResults(getActivity(), 5));

        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

   
    }
