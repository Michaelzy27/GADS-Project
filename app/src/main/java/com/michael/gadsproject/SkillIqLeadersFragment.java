package com.michael.gadsproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.gadsproject.Services.LearningLeadersService;
import com.michael.gadsproject.Services.ServiceBuilder;
import com.michael.gadsproject.Services.SkillLeadersService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIqLeadersFragment extends Fragment {

    RecyclerView sRecyclerView;
    LinearLayoutManager sLinearLayoutManager;
    SkillIqLeaderAdapter sLeadersAdapter;

    public SkillIqLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);

        sRecyclerView = view.findViewById(R.id.skillIqRecyclerview);
//        leadersAdapter.addLearners(new LearningListModel("Test title", "Test Summary"));
//        leadersAdapter.addLearners(new LearningListModel("Test title", "Test Summary"));
//        leadersAdapter.addLearners(new LearningListModel("Test title", "Test Summary"));

        sLinearLayoutManager = new LinearLayoutManager(getContext());
        sRecyclerView.setLayoutManager(sLinearLayoutManager);

        SkillLeadersService skillLeadersService = ServiceBuilder.buildService(SkillLeadersService.class);
        Call<List<SkillListModel>> call = skillLeadersService.getSkillLeaders();

        call.enqueue(new Callback<List<SkillListModel>>() {
            @Override
            public void onResponse(Call<List<SkillListModel>> call, Response<List<SkillListModel>> response) {
                SkillIqLeaderAdapter skillIqLeaderAdapter = new SkillIqLeaderAdapter(response.body());
                sRecyclerView.setAdapter(skillIqLeaderAdapter);
                Log.i("respomnse", "success");
            }

            @Override
            public void onFailure(Call<List<SkillListModel>> call, Throwable t) {
                Log.i("responseFailure", "failed");
            }
        });

        return view;
    }
}