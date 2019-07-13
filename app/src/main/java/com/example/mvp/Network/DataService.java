package com.example.mvp.Network;

import android.database.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataService {
    @GET("people")
    Observable<Data> fetchPeople(
            @Query("results") int page,
            @Query("nat") String nat
    );
}
