package org.example;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String ACCEPT = "Accept";
    public static final String AUTHORIZATION = "Authorization";
    public static final String ACCEPT_VALUE = "application/vnd.github.v3+json";
    public static final String GET = "GET";
    public static final String FILE = "file";

    public static void main(String[] args) throws IOException {
        String owner = "Nisenhouse";
        String repo = "entro_security";
        String token = "xxxx";
        List<Content> filesContent = getFilesContent(owner, repo, token);
        for (Content content : filesContent) {
            String data = fetchData(content.getDownloadUrl(), token);
            System.out.println(data);
        }
    }

    private static String fetchData(String downloadUrl, String token) throws IOException {
        HttpURLConnection con = getHttpURLConnection(token, downloadUrl, GET);
        int status = con.getResponseCode();
        if (status == 200) {
            return getResponseContent(con);
        }
        return null;
    }

    private static List<Content> getFilesContent(String owner, String repo, String token) throws IOException {
        String urlString = String.format("https://api.github.com/repos/%s/%s/contents", owner, repo);
        HttpURLConnection con = getHttpURLConnection(token, urlString, GET);
        int status = con.getResponseCode();
        String responseContent;
        if (status == 200) {
            responseContent = getResponseContent(con);
            Type listType = new TypeToken<ArrayList<Content>>(){}.getType();
            List<Content> yourClassList = new Gson().fromJson(responseContent, listType);
            return yourClassList.stream()
                    .filter(content -> FILE.equals(content.getType()))
                    .toList();
        }
        return null;
    }

    private static HttpURLConnection getHttpURLConnection(String token, String urlString, String method) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty(ACCEPT, ACCEPT_VALUE);
        con.setRequestProperty(AUTHORIZATION, "token " + token);
        con.setRequestMethod(method);
        return con;
    }

    private static String getResponseContent(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}