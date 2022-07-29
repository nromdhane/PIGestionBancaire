package tn.esprit.spring.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentimentalAnalysisController {
	@RequestMapping(value = { "/feedbacks/sentimentalAnalysis" }, method = RequestMethod.POST)
	public static String getSentiment(@Valid @RequestBody String text) throws IOException, InterruptedException {
		JSONObject body = new JSONObject();
		body.put("text", text);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://sentim-api.herokuapp.com/api/v1/"))
				.header("Content-Type", "application/json")
				.method("POST", HttpRequest.BodyPublishers.ofString(body.toString()))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		JSONObject obj = new JSONObject(response.body());
		JSONObject result = new JSONObject(obj.get("result").toString());

		return result.getString("type");
		
	}
}
