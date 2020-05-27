package com.intro.javapractice;

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ApiTest {

	 public static void main( String[] args ) throws Exception
	  {
		// Host url
	      String host = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/";
	      String charset = "UTF-8";
	      // Headers for a request
	      String x_rapidapi_host = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
	      String x_rapidapi_key = "";//Type here your key
	     
	   
	    	      
	    // Host, charset and headers vars should be the same
	    	      String orgin = "PVD-sky/";
	    	      String destination = "JFK-sky";
	    	  // Format query for preventing encoding problems
	    	      String query = String.format("term=%s", // change this to 'response' code snipped from unirest ; define?term=buck '
	    	   	       URLEncoder.encode(i, charset));      
	    	      // Json response
	    	      HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
	    	      .header("x-rapidapi-host", x_rapidapi_host)
	    	      .header("x-rapidapi-key", x_rapidapi_key)
	    	      .asJson();
	    	     
	    	      //gives response code
//	    	      System.out.println(response.getStatus());
//	    	      System.out.println(response.getHeaders().get("Content-Type"));
	    	 
	    	      //Prettifying
	    	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    	      JsonParser jp = new JsonParser();
	    	      JsonElement je = jp.parse(response.getBody().toString());
	    	      String prettyJsonString = gson.toJson(je);
	    	      System.out.println(prettyJsonString);
	  
	  }

}
