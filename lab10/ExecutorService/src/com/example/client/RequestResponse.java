package com.example.client;

public class RequestResponse {
    private final int port;
    private String response;

    public RequestResponse(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}