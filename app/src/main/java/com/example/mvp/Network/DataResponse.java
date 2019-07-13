package com.example.mvp.Network;

import com.example.mvp.model.Response;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("results")
    private List<Response> responseListList;

    public List<Response> getResponseList() {
        return responseList;
    }
}
