package com.uwjx.ossclient01.net;

import okhttp3.*;

import java.io.IOException;

public class HttpUtil {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private static OkHttpClient client = new OkHttpClient();

    public static String get(String url) {
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String post(String url, String json)  {
        try {
            String credential = Credentials.basic("client01", "12345");
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .header("Authorization", credential)

                    .url(url)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
