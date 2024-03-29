package ru.job4j.io;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str1 = in.readLine();
                    if (str1.contains("Hello")) {
                        out.write("Hello".getBytes());
                    } else if (str1.contains("Exit")) {
                        server.close();
                    } else if (str1.contains("What")) {
                        out.write("What".getBytes());
                    } else {
                        out.write(str1.getBytes());
                    }
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {
            LOG.error("Server error", e);
        }
    }
}