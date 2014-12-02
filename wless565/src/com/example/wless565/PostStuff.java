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
import android.widget.*;

public class PostStuff extends AsyncTask<String, String, String> {
	//parameters progress result

	@Override
	protected String doInBackground(String... params) {
		//set up client and create post request
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://ec2-54-148-149-145.us-west-2.compute.amazonaws.com/cgi-bin/postreq");
        
        //create key-value pairs
        //GET LOCATION
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for(int i = 0; i < params.length; i += 2) {
        	pairs.add(new BasicNameValuePair(params[i],params[i + 1]));
        }
        //END GET LOCATION
        
        //convert to post
        try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      //send post request
       String content = null;
        try {
        	ResponseHandler<String> rhandler = new BasicResponseHandler();
        	content = client.execute(post,rhandler);
        	
			//HttpResponse response = client.execute(post);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("clientprotocol");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ioexception");
		}
		return content;
	}
	

}
