package com.example.client;

import java.util.*;
import java.util.concurrent.*;

public class NetworkClientMain {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Map<RequestResponse, Future<RequestResponse>> futures = new HashMap<>();

        // Создание задач
        for (int port = 10000; port < 10010; port++) {
            RequestResponse request = new RequestResponse(port);
            NetworkClientCallable task = new NetworkClientCallable(request);
            Future<RequestResponse> future = executor.submit(task);
            futures.put(request, future);
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        for (Map.Entry<RequestResponse, Future<RequestResponse>> entry : futures.entrySet()) {
            try {
                RequestResponse result = entry.getValue().get();
                System.out.println("Server on port " + result.getPort() + ": " + result.getResponse());
            } catch (Exception e) {
                System.out.println("Failed to get response for port " + entry.getKey().getPort());
            }
        }
    }
}