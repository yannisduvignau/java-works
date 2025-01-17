package com.server_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    String line;
                    String requestedPath = "/";

                    while ((line = in.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line);
                        if (line.startsWith("GET ")) {
                            requestedPath = line.split(" ")[1];
                        }
                    }

                    Path imagePath = Paths.get("../../../" + requestedPath);
                    System.out.println(imagePath);

                    if (Files.exists(imagePath) && !Files.isDirectory(imagePath)) {
                        byte[] fileData = Files.readAllBytes(imagePath);

                        out.print("HTTP/1.1 200 OK\r\n");
                        out.print("\r\n");
                        out.flush();

                        OutputStream dataOut = clientSocket.getOutputStream();
                        dataOut.write(fileData);
                        dataOut.flush();
                    } else {
                        out.print("HTTP/1.1 404 Not Found\r\n\r\n");
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
