package gui;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class chatGPT {

    public String chatGPT(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = ""; // Replace with your actual API key
        String model = "gpt-3.5-turbo"; // Specify the ChatGPT model

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setDoOutput(true);

            // Create the request body
            String requestBody = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";

            // Send the request
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Read the response
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                // Extract the relevant message from the JSON response
                // (You may need to parse the JSON more thoroughly based on your requirements)
                //JSONOject jsonResponse = new JSONObject()
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject messageObject = jsonResponse.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message");
                String content = messageObject.getString("content");
                return content;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Unable to connect to the ChatGPT API.";
        }
    }
}




