package com.minhnv.lab4.ultil;

public class APIUltil {
    public static final String baseUrl = "http://asian.dotplays.com/";

    public static DataClient getData(){
        return RetrofitClient.getRetrofit(baseUrl).create(DataClient.class);
    }
}
