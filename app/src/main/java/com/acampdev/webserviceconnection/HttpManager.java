package com.acampdev.webserviceconnection;

import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpManager {
    public static String getData(String uri){
        BufferedReader reader= null;
        try {
            URL url= new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            StringBuilder stringBuilder= new StringBuilder();
            reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line= reader.readLine())!=null){
                stringBuilder.append(line).append("\n");
            }
            return  stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static  String getData(String uri, String username, String password){
        BufferedReader reader= null;
        byte[] login= (username+": " +password).getBytes();
        StringBuilder builder= new StringBuilder().append("Basic").append(Base64.encodeToString(login,Base64.DEFAULT));
        try{
            URL url= new URL(uri);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            connection.addRequestProperty("Authorization", builder.toString());
            StringBuilder stringBuilder= new StringBuilder();
            reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line= reader.readLine())!=null){
                stringBuilder.append(line).append("\n");
            }
            return  stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
