package bot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;


import org.json.JSONArray;
import org.json.JSONObject;

public class getQuote {
    public static JSONArray arrUrl;
    
	public static void main(String[] args) {
        try{
            call_me();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
	   
public static String call_me() throws Exception {
    Random random = new Random();
    String url = "https://type.fit/api/quotes";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'GET' request to URL : " + url);
    System.out.println("Response Code : " + responseCode);
    BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
    }
    in.close();

    JSONArray myResponse = new JSONArray(response.toString());
    JSONObject objResponse = myResponse.getJSONObject(random.nextInt(myResponse.length()));
    return(objResponse.getString("text"));
    
    
    

    
}}
