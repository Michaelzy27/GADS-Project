package com.michael.gadsproject.Services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface SubmitService {

    @POST
    @FormUrlEncoded
    Call<ResponseBody> submit(@Url String url,
                              @Field("entry.1877115667") String firstName,
                              @Field("entry.2006916086") String lastName,
                  p            @Field("entry.1824927963") String Email,
                              @Field("entry.284483984") String GithubLink);
}
