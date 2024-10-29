package com.example.httprequest.request;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SocketService {
    @GET("android/requirePort")
    Call<Void> requirePort();
}
