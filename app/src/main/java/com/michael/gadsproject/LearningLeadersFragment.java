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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    LearningLeadersAdapter leadersAdapter;

    public LearningLeadersFragment() {
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
        final View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        recyclerView = view.findViewById(R.id.learningRecycler);
        //leadersAdapter = new LearningLeadersAdapter();
//        leadersAdapter.addLearners(new LearningListModel("Test title", "Test Summary"));
//        leadersAdapter.addLearners(new LearningListModel("Test title", "Test Summary"));
//        leadersAdapter.addLearners(new LearningListModel("Test title", "Test Summary"));

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //recyclerView.setAdapter(leadersAdapter);

        LearningLeadersService leadersService = ServiceBuilder.buildService(LearningLeadersService.class);
        Call<List<LearningListModel>> call = leadersService.getLearningLeaders();

        call.enqueue(new Callback<List<LearningListModel>>() {
            @Override
            public void onResponse(Call<List<LearningListModel>> call, Response<List<LearningListModel>> response) {
                LearningLeadersAdapter leadersAdapter = new LearningLeadersAdapter(response.body());
                recyclerView.setAdapter(leadersAdapter);
                Log.i("respomnse", "success");
            }

            @Override
            public void onFailure(Call<List<LearningListModel>> call, Throwable t) {
                Log.i("responseFailure", "failed");
            }
        });


        return view;
    }
}