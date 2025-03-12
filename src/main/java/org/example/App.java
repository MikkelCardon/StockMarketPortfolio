package org.example;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App 
{
    public static void main( String[] args ) {
        callAPI();
    }


    public static void callAPI(){
        String api_key = "*"; //TODO: HUSK AT SLETTE!!!

        Gson gson = new Gson();
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey="+api_key))
                    .header("Authorization", api_key)
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            //HELE JSON kaldet
            JsonObject jsonResponse = gson.fromJson(getResponse.body(), JsonObject.class);

            //Gemmer TimerSeries i ny JSON og gemmer seneste tid i string
            JsonObject timeSeries = jsonResponse.getAsJsonObject("Time Series (5min)");
            String latestTime = timeSeries.entrySet().iterator().next().getKey();

            //Nyt JSON obejkt laves hvor vi tager den seneste tid fra timeSeries
            //Og gemmer latestPrice
            JsonObject stockData = timeSeries.getAsJsonObject(latestTime);
            String latestPrice = stockData.get("4. close").getAsString();

            JsonObject metaData = jsonResponse.getAsJsonObject("Meta Data");
            String symbol = metaData.get("2. Symbol").getAsString();

            System.out.println(symbol + " - " + latestPrice);


        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
