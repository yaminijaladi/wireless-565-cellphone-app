package com.example.wless565;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;


import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class PostStuff extends AsyncTask<String, String, String> {
	//parameters progress result

	@Override
	protected String doInBackground(String... params) {
		//set up client and create post request
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://ec2-54-148-149-145.us-west-2.compute.amazonaws.com");
        
        //create key-value pairs
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        pairs.add(new BasicNameValuePair("k1", "v1"));
        
        //convert to post
        try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        //send get request
        /*String getURL = "http://www.google.com";
        HttpGet get = new HttpGet(getURL);
        try {
			HttpResponse responseGet = client.execute(get);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
      //send post request
        try {
			HttpResponse response = client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("clientprotocol");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ioexception");
		}
		// TODO Auto-generated method stub
		return null;
	}
	

}
