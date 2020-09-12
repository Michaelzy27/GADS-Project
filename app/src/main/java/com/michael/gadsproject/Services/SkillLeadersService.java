package com.michael.gadsproject.Services;

import com.michael.gadsproject.SkillListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillLeadersService {

    @GET("api/skilliq")
    Call<List<SkillListModel>> getSkillLeaders();
}
