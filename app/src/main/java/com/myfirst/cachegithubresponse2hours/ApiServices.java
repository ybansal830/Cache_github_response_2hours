package com.myfirst.cachegithubresponse2hours;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("users/{user}/repos")
    Call<List<ResponseGitHub>> getData(@Path("user") String user);
}
