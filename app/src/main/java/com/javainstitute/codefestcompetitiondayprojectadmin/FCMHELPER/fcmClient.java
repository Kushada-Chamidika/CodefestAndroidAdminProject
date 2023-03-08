package com.javainstitute.codefestcompetitiondayprojectadmin.FCMHELPER;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class fcmClient extends AsyncTask<String,String,String> {

    public void sendFCMmsg(String token,String title,String msg){

        System.out.println(token+" / "+title+" / "+msg+"...............................................................................................................................................................");


        OkHttpClient client = new OkHttpClient.Builder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n\"to\":\""+token+"\",\r\n \"notification\" : {\r\n  \"sound\" : \"default\",\r\n  \"body\" :  \""+msg+"\",\r\n  \"title\" : \""+title+"\",\r\n  \"content_available\" : false,\r\n  \"priority\" : \"high\"\r\n },\r\n \"data\" : {\r\n  \"sound\" : \"Enable\",\r\n  \"body\" :  \"test body\",\r\n  \"title\" : \"test title\",\r\n  \"content_available\" : true,\r\n  \"priority\" : \"high\",\r\n }\r\n}");
        Request request = new Request.Builder()
                .url("https://fcm.googleapis.com/fcm/send")
                .method("POST", body)
                .addHeader("Authorization", "key=API_Key")
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected String doInBackground(String... strings) {

        sendFCMmsg(strings[0],strings[1],strings[2]);

        return null;
    }
}
