package com.example.client;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {
    private final RequestResponse request;

    public NetworkClientCallable(RequestResponse request) {
        this.request = request;
    }

    @Override
    public RequestResponse call() {
        try (Socket socket = new Socket("localhost", request.getPort());
             Scanner scanner = new Scanner(socket.getInputStream())) {
            if (scanner.hasNextLine()) {
                request.setResponse(scanner.nextLine());
            } else {
                request.setResponse("No response");
            }
        } catch (Exception e) {
            request.setResponse("Error connecting to port " + request.getPort() + ": " + e.getMessage());
        }
        return request;
    }
}