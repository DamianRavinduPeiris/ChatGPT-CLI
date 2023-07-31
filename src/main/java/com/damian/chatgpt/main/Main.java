package com.damian.chatgpt.main;

import com.damian.chatgpt.requestbody.RequestBody;
import com.damian.chatgpt.response.Response;
import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String prompt = "";
        System.out.println("Welcome to the GPT-3 Chat bot. Type EXIT to exit.");
        System.out.print("Enter your API key : " );
        String apiKey = "";
        apiKey = s.nextLine();
        while(!prompt.equals("EXIT")){
            System.out.print("Enter your prompt : ");
            prompt= s.nextLine();
            RequestBody requestBody = new RequestBody("text-davinci-003", prompt, 500,0.8);
            Gson g1 = new Gson();
            String json = g1.toJson(requestBody);
            try {
                HttpRequest postRequest = HttpRequest.newBuilder().
                        uri(new URI("https://api.openai.com/v1/completions")).
                        header("content-type", "application/json").
                        header("Authorization", "Bearer "+apiKey).
                        POST(HttpRequest.BodyPublishers.ofString(json)).
                        build();

                HttpClient httpClient = HttpClient.newHttpClient();
                HttpResponse<String> response = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

                Gson g = new Gson();
                Response response1 = g.fromJson(response.body(), Response.class);
                System.out.println("AI : "+response1.getChoices().get(0).getText());


            } catch (URISyntaxException e) {
                System.out.println("URI Syntax Exception: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO Exception: " + e.getMessage());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
