package com.example.httprequest.request;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("users/login")
    Call<User> resultado(@Query("username") String username, @Query("password") String password);
}
