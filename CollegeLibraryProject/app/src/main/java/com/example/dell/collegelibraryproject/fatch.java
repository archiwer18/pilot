package com.example.dell.collegelibraryproject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by DELL on 12-Dec-15.
 */
public class fatch implements Runnable {

    static String jada;
    InputStream inputStream;
    @Override
    public void run() {

        HttpClient httpClient=new DefaultHttpClient();
        HttpPost httpPost=new HttpPost("http://lib.poetshub.website/and_get_books.php");
        try
        {
            HttpResponse httpResponse=httpClient.execute(httpPost);
            HttpEntity httpEntity=httpResponse.getEntity();
             inputStream=httpEntity.getContent();

        }
        catch (ClientProtocolException e)
        {

            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        try{
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
            StringBuilder stringBuilder=new StringBuilder();
            String line=null;
            while((line=bufferedReader.readLine()) !=null)
            {
                stringBuilder.append(line);

            }
            jada=stringBuilder.toString();



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
