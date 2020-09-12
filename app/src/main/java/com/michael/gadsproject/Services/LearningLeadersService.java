package com.michael.gadsproject.Services;

import com.michael.gadsproject.LearningListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeadersService {

    @GET("api/hours")
    Call<List<LearningListModel>> getLearningLeaders();
}
