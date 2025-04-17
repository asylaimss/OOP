package com.example.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class NetworkServerMain {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            int port = 10000 + i;
            new Thread(() -> {
                try (ServerSocket serverSocket = new ServerSocket(port)) {
                    System.out.println("Server started on port " + port);
                    while (true) {
                        try (Socket client = serverSocket.accept();
                             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                            int price = new Random().nextInt(50) + 50;
                            out.println("Shirt price from port " + port + " is $" + price);
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Error on port " + port + ": " + e.getMessage());
                }
            }).start();
        }
    }
}